package com.example.realtime

import android.opengl.GLES20
import android.opengl.GLSurfaceView
import java.nio.ByteBuffer
import java.nio.ByteOrder
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class GLRenderer : GLSurfaceView.Renderer {
    private var textureId = 0
    private var frameBuffer: ByteBuffer? = null
    private var frameWidth = 0
    private var frameHeight = 0
    private lateinit var quad: FullscreenQuad

    @Volatile
    private var pendingFrame: FrameData? = null

    data class FrameData(val bytes: ByteArray, val width: Int, val height: Int)

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        textureId = genTexture()
        quad = FullscreenQuad()
        GLES20.glClearColor(0f, 0f, 0f, 1f)
    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        GLES20.glViewport(0, 0, width, height)
    }

    override fun onDrawFrame(gl: GL10?) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT)

        // Check for pending frame update
        pendingFrame?.let { frame ->
            updateTexture(frame.bytes, frame.width, frame.height)
            pendingFrame = null
        }

        // Draw the textured quad
        frameBuffer?.let {
            quad.draw(textureId)
        }
    }

    /**
     * Called from camera thread when native returns processed bytes
     * Safe to call from any thread
     */
    fun updateFrame(bytes: ByteArray, w: Int, h: Int) {
        pendingFrame = FrameData(bytes, w, h)
    }

    private fun updateTexture(bytes: ByteArray, w: Int, h: Int) {
        if (frameBuffer == null || frameWidth != w || frameHeight != h) {
            frameWidth = w
            frameHeight = h
            frameBuffer = ByteBuffer.allocateDirect(w * h * 4)
                .order(ByteOrder.nativeOrder())

            // Initialize texture storage
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureId)
            GLES20.glTexImage2D(
                GLES20.GL_TEXTURE_2D, 0, GLES20.GL_RGBA, w, h, 0,
                GLES20.GL_RGBA, GLES20.GL_UNSIGNED_BYTE, null
            )
        }

        frameBuffer?.clear()
        frameBuffer?.put(bytes)
        frameBuffer?.position(0)

        // Upload texture data
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureId)
        GLES20.glTexSubImage2D(
            GLES20.GL_TEXTURE_2D, 0,
            0, 0, frameWidth, frameHeight,
            GLES20.GL_RGBA, GLES20.GL_UNSIGNED_BYTE, frameBuffer
        )
    }

    private fun genTexture(): Int {
        val tex = IntArray(1)
        GLES20.glGenTextures(1, tex, 0)
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, tex[0])
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_LINEAR)
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_LINEAR)
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, GLES20.GL_CLAMP_TO_EDGE)
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, GLES20.GL_CLAMP_TO_EDGE)
        return tex[0]
    }
}
