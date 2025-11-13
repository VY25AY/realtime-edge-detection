# Quick Setup Script for Edge Detection Project

## 🚀 Automated Setup (Windows PowerShell)

Save this as `setup.ps1` and run in PowerShell:

```powershell
# Quick Setup for Android + OpenCV + OpenGL + TypeScript Project

Write-Host "🚀 Starting Quick Setup..." -ForegroundColor Green

# Check prerequisites
Write-Host "`n📋 Checking prerequisites..." -ForegroundColor Cyan

# Check Node.js
if (Get-Command node -ErrorAction SilentlyContinue) {
    $nodeVersion = node --version
    Write-Host "✅ Node.js installed: $nodeVersion" -ForegroundColor Green
} else {
    Write-Host "❌ Node.js not found. Please install from https://nodejs.org/" -ForegroundColor Red
    exit 1
}

# Check Git
if (Get-Command git -ErrorAction SilentlyContinue) {
    $gitVersion = git --version
    Write-Host "✅ Git installed: $gitVersion" -ForegroundColor Green
} else {
    Write-Host "❌ Git not found. Please install from https://git-scm.com/" -ForegroundColor Red
    exit 1
}

# Setup Web Viewer
Write-Host "`n🌐 Setting up TypeScript web viewer..." -ForegroundColor Cyan
Set-Location web

if (Test-Path "package.json") {
    npm install
    if ($LASTEXITCODE -eq 0) {
        Write-Host "✅ npm packages installed" -ForegroundColor Green
        npm run build
        if ($LASTEXITCODE -eq 0) {
            Write-Host "✅ TypeScript compiled successfully" -ForegroundColor Green
        } else {
            Write-Host "❌ TypeScript compilation failed" -ForegroundColor Red
        }
    } else {
        Write-Host "❌ npm install failed" -ForegroundColor Red
    }
} else {
    Write-Host "❌ package.json not found in web/" -ForegroundColor Red
}

Set-Location ..

# Initialize Git repository
Write-Host "`n📦 Initializing Git repository..." -ForegroundColor Cyan

if (Test-Path ".git") {
    Write-Host "⚠️  Git repository already initialized" -ForegroundColor Yellow
} else {
    git init
    Write-Host "✅ Git repository initialized" -ForegroundColor Green
}

# Create placeholder sample image if not exists
Write-Host "`n🖼️  Checking for sample image..." -ForegroundColor Cyan
if (-not (Test-Path "web/assets/sample.png")) {
    Write-Host "⚠️  web/assets/sample.png not found" -ForegroundColor Yellow
    Write-Host "   Please add a processed frame from your Android app" -ForegroundColor Yellow
}

# Summary
Write-Host "`n✨ Setup Complete!" -ForegroundColor Green
Write-Host "`n📝 Next Steps:" -ForegroundColor Cyan
Write-Host "1. Download OpenCV Android SDK from https://opencv.org/releases/" -ForegroundColor White
Write-Host "2. Update OpenCV path in app/src/main/cpp/CMakeLists.txt" -ForegroundColor White
Write-Host "3. Open project in Android Studio" -ForegroundColor White
Write-Host "4. Build and run on Android device" -ForegroundColor White
Write-Host "5. Follow GIT_COMMIT_GUIDE.md for proper commit history" -ForegroundColor White
Write-Host "`n6. Open web/index.html in browser to view web viewer" -ForegroundColor White

Write-Host "`n🔗 Important Links:" -ForegroundColor Cyan
Write-Host "OpenCV Android: https://opencv.org/releases/" -ForegroundColor Blue
Write-Host "Android NDK: https://developer.android.com/ndk/downloads" -ForegroundColor Blue
Write-Host "Assignment Form: https://forms.gle/sBouUWUKxy7pf6mKA" -ForegroundColor Blue

Write-Host "`n⏰ Deadline: November 14, 2025, 10:00 AM" -ForegroundColor Red
```

---

## 🐧 Linux/Mac Setup (Bash)

Save this as `setup.sh`:

```bash
#!/bin/bash

# Quick Setup for Android + OpenCV + OpenGL + TypeScript Project

echo "🚀 Starting Quick Setup..."

# Colors
GREEN='\033[0;32m'
RED='\033[0;31m'
CYAN='\033[0;36m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Check prerequisites
echo -e "\n${CYAN}📋 Checking prerequisites...${NC}"

# Check Node.js
if command -v node &> /dev/null; then
    NODE_VERSION=$(node --version)
    echo -e "${GREEN}✅ Node.js installed: $NODE_VERSION${NC}"
else
    echo -e "${RED}❌ Node.js not found. Please install from https://nodejs.org/${NC}"
    exit 1
fi

# Check Git
if command -v git &> /dev/null; then
    GIT_VERSION=$(git --version)
    echo -e "${GREEN}✅ Git installed: $GIT_VERSION${NC}"
else
    echo -e "${RED}❌ Git not found. Please install git${NC}"
    exit 1
fi

# Setup Web Viewer
echo -e "\n${CYAN}🌐 Setting up TypeScript web viewer...${NC}"
cd web

if [ -f "package.json" ]; then
    npm install
    if [ $? -eq 0 ]; then
        echo -e "${GREEN}✅ npm packages installed${NC}"
        npm run build
        if [ $? -eq 0 ]; then
            echo -e "${GREEN}✅ TypeScript compiled successfully${NC}"
        else
            echo -e "${RED}❌ TypeScript compilation failed${NC}"
        fi
    else
        echo -e "${RED}❌ npm install failed${NC}"
    fi
else
    echo -e "${RED}❌ package.json not found in web/${NC}"
fi

cd ..

# Initialize Git repository
echo -e "\n${CYAN}📦 Initializing Git repository...${NC}"

if [ -d ".git" ]; then
    echo -e "${YELLOW}⚠️  Git repository already initialized${NC}"
else
    git init
    echo -e "${GREEN}✅ Git repository initialized${NC}"
fi

# Check for sample image
echo -e "\n${CYAN}🖼️  Checking for sample image...${NC}"
if [ ! -f "web/assets/sample.png" ]; then
    echo -e "${YELLOW}⚠️  web/assets/sample.png not found${NC}"
    echo -e "${YELLOW}   Please add a processed frame from your Android app${NC}"
fi

# Summary
echo -e "\n${GREEN}✨ Setup Complete!${NC}"
echo -e "\n${CYAN}📝 Next Steps:${NC}"
echo "1. Download OpenCV Android SDK from https://opencv.org/releases/"
echo "2. Update OpenCV path in app/src/main/cpp/CMakeLists.txt"
echo "3. Open project in Android Studio"
echo "4. Build and run on Android device"
echo "5. Follow GIT_COMMIT_GUIDE.md for proper commit history"
echo "6. Open web/index.html in browser to view web viewer"

echo -e "\n${CYAN}🔗 Important Links:${NC}"
echo -e "${CYAN}OpenCV Android: https://opencv.org/releases/${NC}"
echo -e "${CYAN}Android NDK: https://developer.android.com/ndk/downloads${NC}"
echo -e "${CYAN}Assignment Form: https://forms.gle/sBouUWUKxy7pf6mKA${NC}"

echo -e "\n${RED}⏰ Deadline: November 14, 2025, 10:00 AM${NC}"
```

Make it executable:

```bash
chmod +x setup.sh
./setup.sh
```

---

## 📱 Android Studio Setup

### 1. Install Android Studio

- Download from: https://developer.android.com/studio
- Install with default settings

### 2. Install NDK

In Android Studio:

- Tools → SDK Manager
- SDK Tools tab
- Check "NDK (Side by side)"
- Check "CMake"
- Click Apply

### 3. Download OpenCV Android SDK

- Visit: https://opencv.org/releases/
- Download "Android" version (4.x)
- Extract to a known location

### 4. Configure Project

1. Open `app/build.gradle`
2. Update NDK version if needed
3. Open `app/src/main/cpp/CMakeLists.txt`
4. Update `OpenCV_DIR` path to your OpenCV location

Example:

```cmake
set(OpenCV_DIR C:/opencv-android-sdk/sdk/native/jni)
```

Or on Linux/Mac:

```cmake
set(OpenCV_DIR /home/user/opencv-android-sdk/sdk/native/jni)
```

### 5. Sync and Build

- File → Sync Project with Gradle Files
- Build → Make Project
- Connect Android device
- Run → Run 'app'

---

## 🌐 Web Viewer Setup

### Quick Start

```bash
cd web
npm install
npm run build
```

### Open in Browser

- Simply open `web/index.html` in any browser
- Or use a local server:

```bash
# Python 3
python -m http.server 8000

# Node.js (install http-server first)
npx http-server

# Then visit http://localhost:8000
```

---

## ⚠️ Troubleshooting

### "OpenCV not found"

**Problem**: CMake can't find OpenCV  
**Solution**:

1. Verify OpenCV SDK is extracted
2. Update `OpenCV_DIR` in `CMakeLists.txt` with absolute path
3. Use forward slashes even on Windows: `C:/opencv/sdk/native/jni`

### "UnsatisfiedLinkError"

**Problem**: Native library not loaded  
**Solution**:

1. Clean and rebuild project
2. Check NDK is installed
3. Verify `ndk.abiFilters` in `build.gradle` matches device architecture

### "Camera permission denied"

**Problem**: App crashes on start  
**Solution**:

1. Grant camera permission when prompted
2. Or manually: Settings → Apps → EdgeDetection → Permissions → Camera

### "TypeScript compilation error"

**Problem**: `npm run build` fails  
**Solution**:

```bash
cd web
rm -rf node_modules package-lock.json
npm install
npm run build
```

---

## 📋 Pre-Build Checklist

Before building the Android app:

- [ ] Android Studio installed with NDK
- [ ] OpenCV Android SDK downloaded and extracted
- [ ] OpenCV path updated in CMakeLists.txt
- [ ] Gradle files synced without errors
- [ ] Android device connected with USB debugging enabled
- [ ] Camera permission will be granted

Before pushing to Git:

- [ ] Web viewer built successfully
- [ ] .gitignore properly configured
- [ ] No build artifacts in staging
- [ ] README.md complete
- [ ] Meaningful commit messages prepared
- [ ] GIT_COMMIT_GUIDE.md reviewed

---

## 🎯 Quick Build Commands

```bash
# Web viewer
cd web && npm install && npm run build && cd ..

# Android (command line - optional)
cd android
./gradlew assembleDebug

# Git setup
git init
git add .gitignore README.md
git commit -m "init: project scaffold"
```

---

## 📞 Support

If you encounter issues:

1. **Check logs**: Android Logcat for native crashes
2. **Verify paths**: Ensure OpenCV path is absolute and correct
3. **Test incrementally**: Build each component separately
4. **Review guides**: GIT_COMMIT_GUIDE.md and README.md

---

## ⏰ Timeline Reminder

**Deadline**: November 14, 2025, 10:00 AM

Recommended schedule:

- **Day 1**: Android + Camera setup
- **Day 2**: Native OpenCV + OpenGL rendering
- **Day 3**: Web viewer + Documentation + Git commits

**Submit**: https://forms.gle/sBouUWUKxy7pf6mKA
