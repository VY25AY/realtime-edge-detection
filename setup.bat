@echo off
REM Setup script for Real-Time Edge Detection Project
REM This script helps you set up the project quickly

echo ========================================
echo Real-Time Edge Detection Setup
echo ========================================
echo.

echo [1/3] Checking TypeScript installation...
call npm --version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERROR: Node.js/npm not found!
    echo Please install Node.js from https://nodejs.org/
    pause
    exit /b 1
)
echo ✓ Node.js found

echo.
echo [2/3] Installing web dependencies...
cd web
call npm install
if %errorlevel% neq 0 (
    echo ERROR: Failed to install dependencies
    pause
    exit /b 1
)
echo ✓ Dependencies installed

echo.
echo [3/3] Building TypeScript...
call npm run build
if %errorlevel% neq 0 (
    echo ERROR: Failed to build TypeScript
    pause
    exit /b 1
)
echo ✓ TypeScript compiled

cd ..
echo.
echo ========================================
echo Setup Complete! ✓
echo ========================================
echo.
echo Next steps:
echo 1. Open the project in Android Studio
echo 2. Download OpenCV Android SDK from https://opencv.org/releases/
echo 3. Update local.properties with: opencv.dir=C:/path/to/opencv/sdk
echo 4. Sync Gradle and build the app
echo.
echo To start the web viewer:
echo   cd web
echo   python -m http.server 8000
echo   Open http://localhost:8000 in your browser
echo.
pause
