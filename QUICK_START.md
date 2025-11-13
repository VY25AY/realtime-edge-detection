# ⚡ Quick Start Guide - Get Running in 30 Minutes

This is a streamlined guide to get your project running as fast as possible.

---

## 🎯 Goal

Get Android app running with edge detection in under 30 minutes.

---

## ✅ Prerequisites (5 minutes)

**Install These First:**

1. ✅ Android Studio (download while you work on other steps)
2. ✅ Node.js 18+ (for web viewer later)
3. ✅ Git (for version control)

**Download:**

- OpenCV Android SDK 4.x from https://opencv.org/releases/
- Extract to `C:\opencv-android-sdk\` (Windows) or `~/opencv-android-sdk/` (Mac/Linux)

---

## 📱 Android App - Fast Track (20 minutes)

### Step 1: Configure OpenCV (2 minutes)

Open `app/src/main/cpp/CMakeLists.txt` and update line 6:

**Windows:**

```cmake
set(OpenCV_DIR C:/opencv-android-sdk/sdk/native/jni)
```

**Mac/Linux:**

```cmake
set(OpenCV_DIR /Users/YOUR_USERNAME/opencv-android-sdk/sdk/native/jni)
```

### Step 2: Open in Android Studio (3 minutes)

```
1. Open Android Studio
2. File → Open → Select project folder
3. Wait for Gradle sync (may take 2-3 minutes first time)
```

### Step 3: Install NDK (3 minutes)

```
1. Tools → SDK Manager
2. SDK Tools tab
3. Check ☑️ NDK (Side by side)
4. Check ☑️ CMake
5. Click Apply → Wait for download
```

### Step 4: Build Project (2 minutes)

```
1. Build → Make Project
2. Wait for build to complete
3. Check for errors in Build output
```

**Common Error:** "OpenCV not found"

- **Fix:** Double-check OpenCV path in CMakeLists.txt

### Step 5: Connect Device (5 minutes)

```
1. Enable Developer Options on Android phone:
   - Settings → About Phone → Tap "Build Number" 7 times

2. Enable USB Debugging:
   - Settings → Developer Options → USB Debugging → ON

3. Connect phone to computer via USB

4. Accept "Allow USB Debugging" popup on phone

5. In Android Studio: Select your device in top toolbar
```

### Step 6: Run! (5 minutes)

```
1. Click green "Run" button ▶️
2. App installs on device
3. Grant camera permission when prompted
4. See real-time edge detection! 🎉
```

**Expected:** Black screen with white edges, FPS counter top-left showing 15+

---

## 🌐 Web Viewer - Fast Track (5 minutes)

### Step 1: Build (2 minutes)

```bash
cd web
npm install
npm run build
```

### Step 2: View (1 minute)

```
Open web/index.html in any browser
```

**Note:** Sample image placeholder shows. Add real frame after Android app runs.

### Step 3: Add Real Frame (2 minutes)

**Quick Method:**

1. Run Android app on device
2. Take screenshot of edge detection
3. Crop to just the processed frame
4. Save as `web/assets/sample.png`
5. Refresh browser

---

## 🚀 Git Setup - Fast Track (5 minutes)

### Quick Commit Sequence

```bash
# Initialize
git init
git add .gitignore README.md
git commit -m "init: project scaffold"

# Android structure
git add app/ build.gradle settings.gradle gradle/
git commit -m "feat(android): add Android app structure"

# Native code
git add app/src/main/cpp/
git commit -m "feat(native): add OpenCV C++ processing"

# Android code
git add app/src/main/java/
git commit -m "feat(app): add camera, OpenGL, and JNI integration"

# Web viewer
git add web/
git commit -m "feat(web): add TypeScript web viewer"

# Documentation
git add *.md
git commit -m "docs: add complete documentation"

# Create GitHub repo and push
git remote add origin https://github.com/YOUR_USERNAME/edge-detection.git
git branch -M main
git push -u origin main
```

---

## ✅ Verification (2 minutes)

### Android App Working?

- [ ] App opens without crashing
- [ ] Camera shows processed output (white edges on black)
- [ ] FPS counter shows (top-left)
- [ ] FPS is 10+ (preferably 15+)

### Web Viewer Working?

- [ ] Page opens in browser
- [ ] FPS counter animates
- [ ] Resolution displays
- [ ] Sample frame shows (or placeholder readme)

### Git Setup Complete?

- [ ] 6+ commits made
- [ ] Repository pushed to GitHub
- [ ] Repository is public or access granted

---

## 🐛 Quick Troubleshooting

### Android Won't Build

**Error:** "OpenCV not found"

```
→ Check OpenCV path in CMakeLists.txt
→ Use absolute path with forward slashes
→ Verify opencv-android-sdk/sdk/native/jni exists
```

**Error:** "No NDK found"

```
→ Tools → SDK Manager → SDK Tools
→ Install NDK (Side by side)
→ Restart Android Studio
```

### App Crashes on Open

**Error:** "Permission denied" or immediate crash

```
→ Grant camera permission
→ Settings → Apps → EdgeDetection → Permissions → Camera → Allow
→ Relaunch app
```

**Error:** "UnsatisfiedLinkError"

```
→ Clean project: Build → Clean Project
→ Rebuild: Build → Rebuild Project
→ Verify device ABI (arm64-v8a or armeabi-v7a)
```

### Low FPS (< 10)

```
→ Normal for older devices
→ Reduce resolution in CameraHelper.kt (line 27):
  private val targetSize = Size(480, 360)  // Lower resolution
→ Rebuild and run
```

### Web Build Fails

```
cd web
rm -rf node_modules package-lock.json
npm install
npm run build
```

---

## 🎯 Next Steps After Quick Start

Once everything is running:

### 1. Add More Commits (10 minutes)

Break down your commits more granularly:

```bash
git add app/src/main/java/com/example/realtime/CameraHelper.kt
git commit -m "feat(camera): add Camera2 ImageReader integration"

git add app/src/main/java/com/example/realtime/GLRenderer.kt
git commit -m "feat(gl): add OpenGL ES 2.0 renderer"

# Add 5-10 more commits
```

### 2. Capture Real Screenshot (5 minutes)

```
1. Run app on device
2. Screenshot the edge detection output
3. Transfer to computer
4. Add to web/assets/sample.png
5. Commit:
   git add web/assets/sample.png
   git commit -m "feat(web): add real processed frame sample"
```

### 3. Complete README (10 minutes)

- Add screenshot images
- Fill in your test device info
- Add any notes about your implementation

```bash
git add README.md screenshots/
git commit -m "docs: add screenshots and device info"
```

### 4. Final Push

```bash
git push origin main
```

---

## 📤 Submit (5 minutes)

1. **Verify Repository:**

   - Open GitHub repo in incognito/private window
   - Confirm it's accessible
   - Check commits are visible

2. **Fill Form:**

   - Go to: https://forms.gle/sBouUWUKxy7pf6mKA
   - Enter your details
   - Paste GitHub repository URL
   - Submit

3. **Confirm:**
   - Check for confirmation email
   - Repository stays public until evaluation

---

## ⏱️ Total Time Breakdown

| Task          | Time       | Status |
| ------------- | ---------- | ------ |
| Prerequisites | 5 min      | ⬜     |
| Android Setup | 20 min     | ⬜     |
| Web Viewer    | 5 min      | ⬜     |
| Git Setup     | 5 min      | ⬜     |
| **TOTAL**     | **35 min** | ⬜     |

Additional time for polish:

- More commits: +10 min
- Screenshots: +5 min
- Documentation: +10 min
- **Total with polish: ~60 minutes**

---

## 🎓 You're Done When...

✅ Android app shows edge detection in real-time  
✅ Web viewer displays (even with placeholder)  
✅ Git has 6+ commits with good messages  
✅ Repository is pushed and accessible  
✅ Form submitted before deadline

---

## 🆘 Still Stuck?

**Check these guides:**

- `SETUP_GUIDE.md` - Detailed setup instructions
- `GIT_COMMIT_GUIDE.md` - Git workflow examples
- `SUBMISSION_CHECKLIST.md` - Pre-submission verification
- `README.md` - Complete project documentation

**Common issues:**

- 90% of problems are OpenCV path configuration
- 5% are camera permissions
- 5% are NDK not installed

---

## 💡 Pro Tips

1. **Start with Android** - Most important part
2. **Test on real device** - Emulator won't work (camera + native libs)
3. **Commit often** - Don't wait until end
4. **Keep it simple** - Focus on core features working
5. **Submit early** - Don't wait for perfection

---

## 🎯 Minimum Viable Submission

If you're really short on time, get THIS working:

1. ✅ Android app builds
2. ✅ Camera captures frames
3. ✅ OpenCV processes (edges visible)
4. ✅ OpenGL renders output
5. ✅ Web viewer shows (placeholder OK)
6. ✅ 6-8 commits with good messages
7. ✅ README with setup instructions

Everything else is bonus!

---

**Let's go! You've got this! 🚀**

**Deadline:** November 14, 2025, 10:00 AM  
**Submit at:** https://forms.gle/sBouUWUKxy7pf6mKA
