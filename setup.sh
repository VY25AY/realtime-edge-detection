#!/bin/bash
# Setup script for Real-Time Edge Detection Project (Linux/Mac)

echo "========================================"
echo "Real-Time Edge Detection Setup"
echo "========================================"
echo ""

# Check Node.js
echo "[1/3] Checking Node.js installation..."
if ! command -v npm &> /dev/null; then
    echo "ERROR: Node.js/npm not found!"
    echo "Please install Node.js from https://nodejs.org/"
    exit 1
fi
echo "✓ Node.js found: $(node --version)"

# Install dependencies
echo ""
echo "[2/3] Installing web dependencies..."
cd web
npm install
if [ $? -ne 0 ]; then
    echo "ERROR: Failed to install dependencies"
    exit 1
fi
echo "✓ Dependencies installed"

# Build TypeScript
echo ""
echo "[3/3] Building TypeScript..."
npm run build
if [ $? -ne 0 ]; then
    echo "ERROR: Failed to build TypeScript"
    exit 1
fi
echo "✓ TypeScript compiled"

cd ..
echo ""
echo "========================================"
echo "Setup Complete! ✓"
echo "========================================"
echo ""
echo "Next steps:"
echo "1. Open the project in Android Studio"
echo "2. Download OpenCV Android SDK from https://opencv.org/releases/"
echo "3. Update local.properties with: opencv.dir=/path/to/opencv/sdk"
echo "4. Sync Gradle and build the app"
echo ""
echo "To start the web viewer:"
echo "  cd web"
echo "  python3 -m http.server 8000"
echo "  Open http://localhost:8000 in your browser"
echo ""
