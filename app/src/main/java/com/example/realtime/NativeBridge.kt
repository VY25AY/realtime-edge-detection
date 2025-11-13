package com.example.realtime

object NativeBridge {
    init {
        System.loadLibrary("native-lib")
    }

    /**
     * Process a frame using OpenCV native code
     * @param input RGBA byte array
     * @param width Frame width
     * @param height Frame height
     * @return Processed RGBA byte array (Canny edges)
     */
    external fun processFrame(input: ByteArray, width: Int, height: Int): ByteArray
}
