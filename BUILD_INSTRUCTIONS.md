# 🔨 Build Instructions

Complete step-by-step guide to build and run the Real-Time Edge Detection project.

## 📋 Prerequisites

### Required Software

1. **Android Studio** (Arctic Fox or later)
   - Download: https://developer.android.com/studio
   - Includes: Android SDK, Gradle, Build Tools

2. **Android NDK** (v25.1.8937393 or later)
   - Install via Android Studio SDK Manager
   - Tools → SDK Manager → SDK Tools → NDK (Side by side)

3. **OpenCV Android SDK** (v4.x)
   - Download: https://opencv.org/releases/
   - Choose: opencv-4.x.x-android-sdk.zip
   - Extract to a known location

4. **Node.js** (v14 or later)
   - Download: https://nodejs.org/
   - Includes npm package manager

5. **Python** (v3.6 or later)
   - Download: https://www.python.org/downloads/
   - For running local web server

### Recommended
- Git for version control
- Physical Android device (Camera2 API requires real hardware)
- USB debugging enabled on device

---

## 🚀 Quick Start (5 Minutes)

### Step 1: Clone the Repository
```bash
git clone https://github.com/VY25AY/Flam.git
cd realtime-edge-detection
```

### Step 2: Run Setup Script
```bash
# On Windows
setup.bat

# On Linux/Mac
chmod +x setup.sh
./setup.sh
```

### Step 3: Configure OpenCV
1. Download OpenCV Android SDK from https://opencv.org/releases/
2. Extract the downloaded ZIP file
3. Copy `local.properties.template` to `local.properties`
4. Edit `local.properties` and update the OpenCV path:
   ```properties
   opencv.dir=C:\\path\\to\\opencv\\sdk
   ```

### Step 4: Open in Android Studio
1. Launch Android Studio
2. File → Open → Select project folder
3. Wait for Gradle sync to complete

### Step 5: Build and Run
1. Connect Android device via USB
2. Enable USB debugging on device
3. Click ▶️ Run button in Android Studio
4. Select your device from the list

---

## 📱 Detailed Android App Build

### 1. Configure Android Studio

#### Install Required Components
```
SDK Manager → SDK Tools:
✓ Android SDK Build-Tools
✓ NDK (Side by side) v25.1.8937393
✓ CMake
✓ Android SDK Platform-Tools
```

#### SDK Platform
```
SDK Manager → SDK Platforms:
✓ Android 14.0 (API 34) - Target SDK
✓ Android 7.0 (API 24) - Minimum SDK
```

### 2. OpenCV Integration

#### Download OpenCV
```bash
# Visit https://opencv.org/releases/
# Download: opencv-4.8.0-android-sdk.zip (or latest 4.x)
# Extract to: C:\opencv\android-sdk\
```

#### Configure OpenCV Path

**Option A: Using local.properties** (Recommended)
```properties
# local.properties
opencv.dir=C:\\opencv\\android-sdk\\OpenCV-android-sdk\\sdk
```

**Option B: Using CMakeLists.txt**
```cmake
# app/src/main/cpp/CMakeLists.txt
set(OpenCV_DIR C:/opencv/android-sdk/OpenCV-android-sdk/sdk/native/jni)
```

**Option C: Using build.gradle**
```gradle
// app/build.gradle
android {
    defaultConfig {
        externalNativeBuild {
            cmake {
                arguments "-DOpenCV_DIR=/path/to/opencv/sdk/native/jni"
            }
        }
    }
}
```

### 3. Gradle Sync

```bash
# In Android Studio Terminal
./gradlew --refresh-dependencies

# Or click: File → Sync Project with Gradle Files
```

### 4. Build Native Library

```bash
# Clean build
./gradlew clean

# Build native libraries
./gradlew :app:externalNativeBuildDebug

# Build APK
./gradlew assembleDebug
```

### 5. Install on Device

```bash
# Via ADB
adb install -r app/build/outputs/apk/debug/app-debug.apk

# Or via Android Studio
# Click Run button (Shift+F10)
```

---

## 🌐 Web Viewer Setup

### 1. Install Dependencies
```bash
cd web
npm install
```

### 2. Build TypeScript
```bash
npm run build
```

### 3. Start Development Server
```bash
# Python 3
python -m http.server 8000

# Or Python 2
python -m SimpleHTTPServer 8000

# Or Node.js http-server
npx http-server -p 8000
```

### 4. Open in Browser
```
http://localhost:8000
```

---

## 🔧 Troubleshooting

### Common Issues

#### 1. OpenCV Not Found
```
Error: find_package(OpenCV REQUIRED) failed
```

**Solution:**
- Verify OpenCV SDK path in `local.properties`
- Use forward slashes or escaped backslashes
- Ensure path points to the `sdk` folder (containing `native/jni`)

Example correct paths:
```properties
# Windows
opencv.dir=C:\\opencv\\OpenCV-android-sdk\\sdk
opencv.dir=C:/opencv/OpenCV-android-sdk/sdk

# Linux/Mac
opencv.dir=/home/user/opencv/sdk
```

#### 2. NDK Not Found
```
Error: NDK is not configured
```

**Solution:**
```
Android Studio → Tools → SDK Manager → SDK Tools
✓ Check "NDK (Side by side)"
Click Apply
```

#### 3. Gradle Sync Failed
```
Error: Plugin with id 'com.android.application' not found
```

**Solution:**
```bash
# Update Gradle wrapper
./gradlew wrapper --gradle-version 8.2

# Or in gradle-wrapper.properties
distributionUrl=https\://services.gradle.org/distributions/gradle-8.2-bin.zip
```

#### 4. TypeScript Compilation Error
```
Error: Cannot find module 'typescript'
```

**Solution:**
```bash
cd web
npm install
npm run build
```

#### 5. Camera Permission Denied
```
Error: Camera permission not granted
```

**Solution:**
- Go to device Settings → Apps → Edge Detection → Permissions
- Enable Camera permission
- Restart the app

#### 6. Black Screen on Device
```
App runs but shows black screen
```

**Solution:**
- Check Logcat for native errors
- Verify OpenCV libraries are included in APK
- Test on different device (Camera2 API compatibility)

---

## 📦 Build Variants

### Debug Build
```bash
./gradlew assembleDebug
# Output: app/build/outputs/apk/debug/app-debug.apk
```

### Release Build
```bash
./gradlew assembleRelease
# Output: app/build/outputs/apk/release/app-release-unsigned.apk

# Sign the APK
jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 \
  -keystore my-release-key.keystore \
  app-release-unsigned.apk alias_name
```

---

## 🧪 Testing

### Unit Tests
```bash
./gradlew test
```

### Instrumented Tests
```bash
./gradlew connectedAndroidTest
```

### Manual Testing Checklist
- [ ] App launches successfully
- [ ] Camera permission requested
- [ ] Camera preview displays
- [ ] Edge detection processing works
- [ ] FPS counter updates
- [ ] No crashes or memory leaks
- [ ] Smooth performance (>30 FPS)

---

## 📊 Performance Optimization

### Native Code
```cpp
// Enable compiler optimizations
// CMakeLists.txt
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O3 -march=armv8-a")
```

### Gradle
```gradle
// app/build.gradle
android {
    buildTypes {
        release {
            minifyEnabled true
            shrinkResources true
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt')
        }
    }
}
```

---

## 🐛 Debug Mode

### Enable Debug Logs
```kotlin
// MainActivity.kt
private val DEBUG = true

if (DEBUG) {
    Log.d(TAG, "Frame processed: $fps FPS")
}
```

### Native Debug
```bash
# Enable NDK debugging in Android Studio
Run → Edit Configurations → Debugger → Debug type: Dual (Java + Native)
```

### ADB Logcat
```bash
# Filter by app
adb logcat | grep "com.example.realtime"

# Filter by tag
adb logcat -s NativeLib:D MainActivity:D

# Clear and watch
adb logcat -c && adb logcat
```

---

## 📚 Additional Resources

- **OpenCV Documentation**: https://docs.opencv.org/4.x/
- **Android Camera2 API**: https://developer.android.com/training/camera2
- **JNI Guide**: https://developer.android.com/training/articles/perf-jni
- **CMake Documentation**: https://cmake.org/cmake/help/latest/

---

## 💡 Tips for Success

1. **Always use a physical device** - Emulators don't support Camera2 API properly
2. **Check OpenCV version compatibility** - Use 4.x series for best results
3. **Monitor memory usage** - Large frames can cause OutOfMemory errors
4. **Profile with Android Profiler** - Identify performance bottlenecks
5. **Test on multiple devices** - Different hardware may behave differently

---

## 🆘 Getting Help

If you encounter issues:

1. Check **Logcat** for error messages
2. Review **Gradle Build Output**
3. Verify **OpenCV installation**
4. Check **GitHub Issues**: https://github.com/VY25AY/Flam/issues
5. Read **TROUBLESHOOTING.md** for common solutions

---

**Built with ❤️ for Flam Placement Drive Assignment**
