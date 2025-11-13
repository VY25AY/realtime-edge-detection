@echo off
cd /d "%~dp0"

echo Initializing git repository...
if not exist .git (
    git init
)

echo Adding all files...
git add .

echo Checking git status...
git status

echo Creating commit...
git commit -m "Initial commit: Real-time edge detection project"

echo Adding remote origin...
git remote remove origin 2>nul
git remote add origin https://github.com/VY25AY/realtime-edge-detection.git

echo Setting main branch...
git branch -M main

echo Pushing to GitHub...
echo Note: You may need to authenticate with your GitHub credentials
git push -u origin main

echo Done!
pause

