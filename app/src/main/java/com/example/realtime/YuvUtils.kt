package com.example.realtime

import android.graphics.ImageFormat
import android.media.Image
import java.nio.ByteBuffer

object YuvUtils {
    /**
     * Convert YUV_420_888 Image to RGBA byte array
     * Simple conversion for assessment purposes
     */
    fun yuv420ToRGBA(image: Image): ByteArray {
        val width = image.width
        val height = image.height
        val yPlane = image.planes[0]
        val uPlane = image.planes[1]
        val vPlane = image.planes[2]

        val yBuffer = yPlane.buffer
        val uBuffer = uPlane.buffer
        val vBuffer = vPlane.buffer

        val ySize = yBuffer.remaining()
        val uSize = uBuffer.remaining()
        val vSize = vBuffer.remaining()

        val nv21 = ByteArray(ySize + uSize + vSize)
        
        // Copy Y plane
        yBuffer.get(nv21, 0, ySize)
        
        // Copy UV planes (converting to NV21 format)
        val uvPixelStride = uPlane.pixelStride
        if (uvPixelStride == 1) {
            vBuffer.get(nv21, ySize, vSize)
            uBuffer.get(nv21, ySize + vSize, uSize)
        } else {
            // Interleaved UV
            var pos = ySize
            for (i in 0 until uSize) {
                nv21[pos++] = vBuffer.get(i * uvPixelStride)
                nv21[pos++] = uBuffer.get(i * uvPixelStride)
            }
        }

        // Convert NV21 to RGBA
        return nv21ToRGBA(nv21, width, height)
    }

    private fun nv21ToRGBA(nv21: ByteArray, width: Int, height: Int): ByteArray {
        val rgba = ByteArray(width * height * 4)
        val frameSize = width * height

        for (j in 0 until height) {
            for (i in 0 until width) {
                val y = (0xff and nv21[j * width + i].toInt())
                val v = (0xff and nv21[frameSize + (j shr 1) * width + (i and 1.inv())].toInt())
                val u = (0xff and nv21[frameSize + (j shr 1) * width + (i and 1.inv()) + 1].toInt())

                var r = (1.164f * (y - 16) + 1.596f * (v - 128)).toInt()
                var g = (1.164f * (y - 16) - 0.813f * (v - 128) - 0.391f * (u - 128)).toInt()
                var b = (1.164f * (y - 16) + 2.018f * (u - 128)).toInt()

                r = r.coerceIn(0, 255)
                g = g.coerceIn(0, 255)
                b = b.coerceIn(0, 255)

                val index = (j * width + i) * 4
                rgba[index] = r.toByte()
                rgba[index + 1] = g.toByte()
                rgba[index + 2] = b.toByte()
                rgba[index + 3] = 255.toByte()
            }
        }

        return rgba
    }
}
