# 📸 Screenshots Folder

## Required Screenshots for Submission

### Web Viewer (3 images + 1 GIF)

#### Static Screenshots:
1. **web-viewer-main.png** - Full page view showing all features
2. **web-viewer-running.png** - Processing active with progress bar
3. **web-viewer-upload.png** - Upload feature demonstration

#### Animated Demo:
4. **web-viewer-demo.gif** - Interactive demo showing start/stop/upload flow

### Android App (3 images + 1 GIF)

#### Static Screenshots:
1. **android-app-main.png** - Camera with real-time edge detection
2. **android-app-performance.png** - FPS counter visible (30+ FPS)
3. **android-app-scene.png** - Different object/scene demonstration

#### Animated Demo:
4. **android-app-demo.gif** - Live edge detection in action

---

## 🎬 How to Capture Screenshots

### Web Viewer (Browser Open at http://localhost:8002)

**Screenshot 1: Main View**
```
1. Open http://localhost:8002 in browser
2. Make sure window is maximized
3. Press: Win + Shift + S
4. Select area and save as: web-viewer-main.png
```

**Screenshot 2: Processing Active**
```
1. Click "▶️ Start" button on web page
2. Wait 2 seconds for progress bar to animate
3. Press: Win + Shift + S
4. Save as: web-viewer-running.png
```

**Screenshot 3: Upload Feature**
```
1. Click "📁 Upload" button
2. Select any image file
3. After it loads on canvas
4. Press: Win + Shift + S
5. Save as: web-viewer-upload.png
```

**GIF: Interactive Demo**
```
Tool: ScreenToGif (Download: https://www.screentogif.com/)
OR: ShareX (Download: https://getsharex.com/)

Steps:
1. Start screen recording
2. Click Start button → show processing
3. Click Stop → show pause
4. Click Upload → select image → show result
5. Click Download → show save dialog
6. Stop recording
7. Export as: web-viewer-demo.gif (max 10MB)
```

---

### Android App

**Prerequisites:**
```bash
# Build APK
cd C:\Users\Anurag\Desktop\project
.\gradlew assembleDebug

# Install on device
adb devices
adb install app\build\outputs\apk\debug\app-debug.apk
```

**Screenshot 1: Main View**
```
1. Open app on device
2. Grant camera permission
3. Point at object with clear edges
4. Press: Power + Volume Down (simultaneously)
5. Transfer: adb pull /sdcard/Pictures/Screenshots/Screenshot_xxx.png screenshots/android-app-main.png
```

**Screenshot 2: Performance**
```
1. Make sure FPS counter is visible in app
2. Ensure it shows 30+ FPS
3. Take screenshot: Power + Volume Down
4. Pull and rename to: android-app-performance.png
```

**Screenshot 3: Different Scene**
```
1. Point camera at different object (book, laptop, etc.)
2. Show edge detection working
3. Take screenshot: Power + Volume Down
4. Pull and rename to: android-app-scene.png
```

**GIF: Live Demo**
```
Tool: AZ Screen Recorder (Install from Play Store on device)
OR: scrcpy + ScreenToGif on PC

Method 1 (On Device):
1. Install AZ Screen Recorder
2. Start recording
3. Open edge detection app
4. Move camera around showing edge detection
5. Stop recording
6. Transfer: adb pull /sdcard/Movies/AZScreenRecorder/xxx.mp4 .
7. Convert to GIF using online tool or ffmpeg
8. Save as: android-app-demo.gif

Method 2 (On PC with scrcpy):
1. Install scrcpy: https://github.com/Genymobile/scrcpy
2. Run: scrcpy
3. Record screen with ScreenToGif while moving phone camera
4. Export as: android-app-demo.gif
```

---

## 🛠️ Tools for Screenshot Capture

### Windows Built-in:
- **Snipping Tool**: Win + Shift + S
- **Print Screen**: PrtScn key

### Recommended Free Tools:
- **ScreenToGif**: https://www.screentogif.com/ (Best for GIFs)
- **ShareX**: https://getsharex.com/ (Screenshots + GIFs)
- **Greenshot**: https://getgreenshot.org/ (Annotations)

### Android Tools:
- **Built-in**: Power + Volume Down
- **ADB Command**: `adb shell screencap -p /sdcard/screenshot.png`
- **scrcpy**: https://github.com/Genymobile/scrcpy (Mirror to PC)
- **AZ Screen Recorder**: Play Store app for recording

---

## 📏 Image Guidelines

### Screenshot Requirements:
- **Format**: PNG (lossless)
- **Web Resolution**: 1920x1080 or 1600x900 (Full HD preferred)
- **Android Resolution**: Native device resolution (typically 1080x2400)
- **Max File Size**: 5MB per image

### GIF Requirements:
- **Format**: GIF or MP4 (GIF preferred for GitHub)
- **Duration**: 10-30 seconds
- **FPS**: 15-20 fps (smooth but not too large)
- **Max File Size**: 10MB (GitHub limit)
- **Resolution**: 800x600 or 1280x720 (reduce from source)

---

## ✅ Checklist

After capturing all media:

- [ ] web-viewer-main.png (exists and < 5MB)
- [ ] web-viewer-running.png (exists and < 5MB)
- [ ] web-viewer-upload.png (exists and < 5MB)
- [ ] web-viewer-demo.gif (exists and < 10MB)
- [ ] android-app-main.png (exists and < 5MB)
- [ ] android-app-performance.png (exists and < 5MB)
- [ ] android-app-scene.png (exists and < 5MB)
- [ ] android-app-demo.gif (exists and < 10MB)

Total: 6 PNG images + 2 GIF animations = 8 files

---

## 🚀 After Capturing All Screenshots

Run these commands:

```bash
# Verify all files exist
cd C:\Users\Anurag\Desktop\project\screenshots
ls

# Expected output:
# web-viewer-main.png
# web-viewer-running.png
# web-viewer-upload.png
# web-viewer-demo.gif
# android-app-main.png
# android-app-performance.png
# android-app-scene.png
# android-app-demo.gif

# Stage and commit
cd ..
git add screenshots/
git add README.md
git commit -m "docs: add screenshots and demo GIFs for web viewer and Android app"
git push origin main
```

---

**Need Help?** Check SCREENSHOT_GUIDE.md in project root for detailed instructions.
