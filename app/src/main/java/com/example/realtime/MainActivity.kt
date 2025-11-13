package com.example.realtime

import android.Manifest
import android.content.pm.PackageManager
import android.opengl.GLSurfaceView
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val CAMERA_PERMISSION_CODE = 100

    private lateinit var glSurfaceView: GLSurfaceView
    private lateinit var renderer: GLRenderer
    private lateinit var cameraHelper: CameraHelper
    private lateinit var fpsTextView: TextView

    private var frameCount = 0
    private var lastFpsTime = System.currentTimeMillis()
    private var currentFps = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        glSurfaceView = findViewById(R.id.glSurfaceView)
        fpsTextView = findViewById(R.id.fpsTextView)

        // Setup OpenGL ES 2.0
        glSurfaceView.setEGLContextClientVersion(2)
        renderer = GLRenderer()
        glSurfaceView.setRenderer(renderer)
        glSurfaceView.renderMode = GLSurfaceView.RENDERMODE_CONTINUOUSLY

        // Setup camera helper
        cameraHelper = CameraHelper(this) { rgba, width, height ->
            processFrame(rgba, width, height)
        }

        // Check camera permission
        if (checkCameraPermission()) {
            startCamera()
        } else {
            requestCameraPermission()
        }
    }

    private fun processFrame(rgba: ByteArray, width: Int, height: Int) {
        thread {
            try {
                val startTime = System.currentTimeMillis()

                // Process frame through native OpenCV code
                val processed = NativeBridge.processFrame(rgba, width, height)

                val processingTime = System.currentTimeMillis() - startTime

                // Update OpenGL texture
                renderer.updateFrame(processed, width, height)

                // Calculate FPS
                updateFps()

                // Log processing time occasionally
                if (frameCount % 30 == 0) {
                    Log.d(TAG, "Processing time: ${processingTime}ms, FPS: $currentFps")
                }

            } catch (e: Exception) {
                Log.e(TAG, "Error processing frame", e)
            }
        }
    }

    private fun updateFps() {
        frameCount++
        val currentTime = System.currentTimeMillis()
        val elapsed = currentTime - lastFpsTime

        if (elapsed >= 1000) {
            currentFps = (frameCount * 1000f) / elapsed
            frameCount = 0
            lastFpsTime = currentTime

            // Update UI on main thread
            runOnUiThread {
                fpsTextView.text = "FPS: %.1f".format(currentFps)
            }
        }
    }

    private fun checkCameraPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestCameraPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CAMERA),
            CAMERA_PERMISSION_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startCamera()
            } else {
                Toast.makeText(this, "Camera permission required", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    private fun startCamera() {
        try {
            cameraHelper.start()
            Log.d(TAG, "Camera started")
        } catch (e: Exception) {
            Log.e(TAG, "Error starting camera", e)
            Toast.makeText(this, "Failed to start camera", Toast.LENGTH_LONG).show()
        }
    }

    override fun onResume() {
        super.onResume()
        glSurfaceView.onResume()
    }

    override fun onPause() {
        super.onPause()
        glSurfaceView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraHelper.stop()
    }
}
