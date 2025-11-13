# 🎬 Complete Screenshot & GIF Capture Guide

## 📋 What You Need to Capture

### Total: 8 Files
- ✅ 6 PNG screenshots
- ✅ 2 GIF animations

---

## 🌐 PART 1: Web Viewer (4 files)

### Setup
The web server should already be running at http://localhost:8002

### Capture Instructions

#### 1️⃣ Screenshot: Main View (web-viewer-main.png)
```
Steps:
1. Open http://localhost:8002 in your browser
2. Maximize browser window (F11 for fullscreen)
3. Scroll to show full page including header and canvas
4. Press: Windows + Shift + S
5. Click "Rectangle snip"
6. Select entire browser content area
7. Click notification popup
8. Save as: screenshots\web-viewer-main.png
```

**What should be visible:**
- ✅ Header "Real-Time Edge Detection Viewer"
- ✅ Quick Start Guide banner
- ✅ Canvas with edge detection sample
- ✅ Stats overlay (FPS, Resolution, Algorithm, Status)
- ✅ Control buttons (Upload, Start, Stop, Download, Fullscreen)
- ✅ System Architecture section

---

#### 2️⃣ Screenshot: Processing Active (web-viewer-running.png)
```
Steps:
1. On the web page, click the "▶️ Start" button
2. Wait 2-3 seconds (you'll see):
   - Progress bar animating at bottom of canvas
   - Status changing to "Running"
   - Toast notification "Processing started"
   - FPS counter updating
3. Press: Windows + Shift + S
4. Capture the canvas area with controls
5. Save as: screenshots\web-viewer-running.png
```

**What should be visible:**
- ✅ Green animated progress bar at canvas bottom
- ✅ Status showing "Running"
- ✅ FPS counter updating (around 60)
- ✅ Toast notification visible (if timing is right)

---

#### 3️⃣ Screenshot: Upload Feature (web-viewer-upload.png)
```
Steps:
1. Click the "📁 Upload" button
2. Select any image file from your computer (JPG, PNG)
3. Wait for it to load on canvas
4. You'll see edge detection applied to your image
5. Press: Windows + Shift + S
6. Capture showing the uploaded image processed
7. Save as: screenshots\web-viewer-upload.png
```

**What should be visible:**
- ✅ Your uploaded image with edge detection applied
- ✅ Resolution updated to match your image
- ✅ Status showing "Uploaded"

---

#### 4️⃣ GIF Animation: Interactive Demo (web-viewer-demo.gif)

**Tool Needed:** ScreenToGif (https://www.screentogif.com/)

```
Download & Install:
1. Visit: https://www.screentogif.com/
2. Download portable version (no install needed)
3. Extract and run ScreenToGif.exe

Recording Steps:
1. Open ScreenToGif → Click "Recorder"
2. Position recorder window over web viewer canvas area
3. Click "Record" button (or press F7)
4. Perform these actions slowly:
   a. Click "▶️ Start" → wait 3 seconds (show progress bar)
   b. Click "⏸️ Stop" → wait 2 seconds (show paused)
   c. Click "📁 Upload" → select image → wait for it to load
   d. Click "💾 Download" → show save dialog briefly
   e. Click "▶️ Start" again → show running
5. Press F8 to stop recording
6. In ScreenToGif editor:
   - Delete first/last frames if needed
   - Go to: File → Save As → GIF
   - Optimize: Encoder → System.Drawing
   - Max colors: 256
   - Quality: 85
7. Save as: screenshots\web-viewer-demo.gif
```

**Target GIF specs:**
- Duration: 15-20 seconds
- FPS: 15-20
- Size: < 10MB (if larger, reduce FPS or resolution in ScreenToGif)

---

## 📱 PART 2: Android App (4 files)

### Prerequisites

#### A. Build the APK
```bash
cd C:\Users\Anurag\Desktop\project
.\gradlew assembleDebug
```
Wait 2-5 minutes for build to complete.

#### B. Connect Your Android Device
```bash
1. Enable Developer Options on phone:
   Settings → About Phone → Tap "Build Number" 7 times

2. Enable USB Debugging:
   Settings → Developer Options → USB Debugging (ON)

3. Connect phone via USB cable to computer

4. On phone: Accept "Allow USB Debugging?" dialog
   ✓ Check "Always allow from this computer"
   Click OK

5. Verify connection:
   adb devices
   
   Should show:
   List of devices attached
   ABC123XYZ    device
```

#### C. Install the App
```bash
adb install app\build\outputs\apk\debug\app-debug.apk

# If already installed, use -r to reinstall:
adb install -r app\build\outputs\apk\debug\app-debug.apk
```

#### D. Launch and Grant Permission
```bash
1. Open "Edge Detection" app on phone
2. Click "Allow" when asked for Camera permission
3. You should see live edge detection!
```

---

### Capture Instructions

#### 5️⃣ Screenshot: Main View (android-app-main.png)
```
Steps:
1. Open the Edge Detection app
2. Point camera at object with clear edges:
   - Book cover
   - Laptop
   - Door frame
   - Any object with distinct edges
3. Hold phone steady
4. When edge detection is clear and smooth:
5. Press: Power + Volume Down (simultaneously)
6. Screenshot saved to phone

Transfer to PC:
Method 1 (USB):
- Phone → File Transfer mode
- Open phone storage on PC
- Navigate to: DCIM\Screenshots\
- Copy latest screenshot to: C:\Users\Anurag\Desktop\project\screenshots\
- Rename to: android-app-main.png

Method 2 (ADB):
adb pull /sdcard/Pictures/Screenshots/Screenshot_*.png screenshots/android-app-main.png
```

**What should be visible:**
- ✅ Live camera feed with edges detected (white lines on black)
- ✅ Clear edge outlines of objects
- ✅ Good contrast between edges and background

---

#### 6️⃣ Screenshot: Performance (android-app-performance.png)
```
Steps:
1. Make sure FPS counter is visible in app (if implemented)
2. Wait until FPS stabilizes at 30+ FPS
3. Take screenshot: Power + Volume Down
4. Transfer to PC and rename to: android-app-performance.png

Note: If FPS counter is not visible in current build,
you can skip this or use same image as android-app-main.png
```

**What should be visible:**
- ✅ FPS counter showing 30+ FPS (if available)
- ✅ Smooth edge detection running
- ✅ Clear performance indication

---

#### 7️⃣ Screenshot: Different Scene (android-app-scene.png)
```
Steps:
1. Point camera at a DIFFERENT object than screenshot 1
2. Examples:
   - Indoor: Kitchen items, furniture, electronics
   - Outdoor: Buildings, cars, trees
   - Close-up: Text on paper, keyboard, hand
3. Ensure edges are clearly detected
4. Take screenshot: Power + Volume Down
5. Transfer to PC and rename to: android-app-scene.png
```

**What should be visible:**
- ✅ Different subject from first screenshot
- ✅ Edge detection working on new scene
- ✅ Demonstrates versatility of algorithm

---

#### 8️⃣ GIF Animation: Live Demo (android-app-demo.gif)

**Method 1: Using scrcpy (Recommended)**

```
Install scrcpy:
1. Download: https://github.com/Genymobile/scrcpy/releases
2. Extract scrcpy-win64.zip
3. Run scrcpy.exe

Record with ScreenToGif:
1. Phone connected via USB
2. Run scrcpy.exe → Phone screen appears on PC
3. Open ScreenToGif → Recorder
4. Position over scrcpy window
5. Click Record
6. Slowly move phone camera around showing:
   - Point at object 1 (book) → edges appear
   - Move to object 2 (laptop) → edges change
   - Move to object 3 (hand/pen) → edges update
   - Show smooth real-time processing (10-15 seconds)
7. Stop recording
8. Save as GIF: screenshots\android-app-demo.gif
```

**Method 2: Using Phone's Screen Recorder**

```
If scrcpy doesn't work:
1. Install "AZ Screen Recorder" from Play Store
2. Open AZ Screen Recorder
3. Click record button (floating bubble)
4. Open Edge Detection app
5. Move camera showing edge detection for 10-15 seconds
6. Stop recording
7. Transfer video to PC:
   adb pull /sdcard/Movies/AZScreenRecorder/*.mp4 .
8. Convert MP4 to GIF:
   - Upload to: https://cloudconvert.com/mp4-to-gif
   - Or use ffmpeg:
     ffmpeg -i video.mp4 -vf "fps=15,scale=480:-1" -loop 0 android-app-demo.gif
9. Move GIF to: screenshots\android-app-demo.gif
```

**Target GIF specs:**
- Duration: 10-15 seconds
- FPS: 15
- Size: < 10MB
- Shows camera moving and edges updating in real-time

---

## ✅ Verification Checklist

After capturing all 8 files, run:

```bash
cd C:\Users\Anurag\Desktop\project
.\check-screenshots.ps1
```

This will verify all files exist and show their sizes.

Expected output:
```
[✓] web-viewer-main.png (2.3 MB)
[✓] web-viewer-running.png (2.1 MB)
[✓] web-viewer-upload.png (1.8 MB)
[✓] web-viewer-demo.gif (8.5 MB)
[✓] android-app-main.png (1.2 MB)
[✓] android-app-performance.png (1.3 MB)
[✓] android-app-scene.png (1.1 MB)
[✓] android-app-demo.gif (7.2 MB)

Summary: Found 8 / 8
```

---

## 🚀 Final Steps

Once all 8 files are in the screenshots folder:

```bash
# Stage all files
git add screenshots/
git add README.md
git add SCREENSHOT_GUIDE.md
git add check-screenshots.ps1

# Commit
git commit -m "docs: add comprehensive screenshots and demo GIFs

- Add web viewer screenshots: main, running, upload states
- Add web viewer demo GIF showing interactive features
- Add Android app screenshots: main, performance, different scenes
- Add Android app demo GIF showing live edge detection
- Update README.md with embedded screenshots
- Add screenshot capture guides and verification script"

# Push to GitHub
git push origin main

# Verify on GitHub
# Open: https://github.com/AY-10/realtime-edge-detection
# Scroll to Screenshots section
# All 8 images should be visible
```

---

## 🎯 Quick Reference

| File | Type | Purpose | Key Features to Show |
|------|------|---------|---------------------|
| web-viewer-main.png | PNG | Full web page | Header, canvas, stats, controls, architecture |
| web-viewer-running.png | PNG | Processing active | Progress bar, "Running" status, FPS updating |
| web-viewer-upload.png | PNG | Upload feature | Custom image processed, new resolution |
| web-viewer-demo.gif | GIF | Interactive demo | Start/stop/upload/download flow |
| android-app-main.png | PNG | Main app view | Live edges, clear object detection |
| android-app-performance.png | PNG | FPS visible | 30+ FPS counter, smooth performance |
| android-app-scene.png | PNG | Different scene | Versatility, different object/lighting |
| android-app-demo.gif | GIF | Live demo | Camera movement, real-time edge updates |

---

## 💡 Pro Tips

1. **Screenshots:**
   - Use PNG format (lossless)
   - Ensure good lighting for Android screenshots
   - Maximize browser window for web screenshots
   - Clean desktop/browser UI for professional look

2. **GIFs:**
   - Keep under 10MB (GitHub display limit)
   - 15-20 FPS is smooth enough
   - Record in landscape for web, portrait for Android
   - Show actual functionality, not just static view

3. **Quality Check:**
   - Preview each file before committing
   - Ensure text is readable in screenshots
   - GIFs should play smoothly
   - No personal information visible

---

**Need Help?**
- Web server not running? Run: `python -m http.server 8002` in web folder
- Android build failing? Check: TROUBLESHOOTING.md
- GIF too large? Reduce FPS or resolution in ScreenToGif
- ADB not found? Install Android SDK Platform Tools

**Estimated Time:**
- Web screenshots: 5 minutes
- Web GIF: 5 minutes
- Android build & install: 10 minutes
- Android screenshots: 5 minutes
- Android GIF: 10 minutes
- **Total: ~35 minutes**

Good luck! 🎉
