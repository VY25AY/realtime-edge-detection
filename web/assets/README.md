# Sample Image Placeholder

This file is a placeholder. Please replace `sample.png` with an actual processed frame from your Android app.

## How to Add Your Processed Frame

### Method 1: From Android Device (Recommended)

1. Run the Android app on your device
2. Add this code to `MainActivity.kt` after processing a frame:

```kotlin
// Add this method to MainActivity
private fun saveProcessedFrame(bytes: ByteArray, width: Int, height: Int) {
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val buffer = ByteBuffer.wrap(bytes)
    bitmap.copyPixelsFromBuffer(buffer)

    val file = File(getExternalFilesDir(null), "processed_frame.png")
    FileOutputStream(file).use { out ->
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
    }
    Log.d("MainActivity", "Saved to: ${file.absolutePath}")
}

// Call it once after processing:
// saveProcessedFrame(processed, width, height)
```

3. Pull the file from device:

```bash
adb pull /sdcard/Android/data/com.example.realtime/files/processed_frame.png
```

4. Copy to `web/assets/sample.png`

### Method 2: Screenshot (Quick Test)

1. Run the Android app
2. Take a screenshot of the edge-detected output
3. Crop to just the processed frame
4. Save as `sample.png` in this folder

### Expected Output

The image should show:

- Black background
- White edges detected by Canny algorithm
- Resolution: 640×480 pixels
- Format: PNG

## Example

Your processed frame should look similar to edge detection output:

- Objects outlined in white
- Black background
- Clear edge boundaries
- No color (grayscale edges)

Once you add the actual image, delete this README file.
