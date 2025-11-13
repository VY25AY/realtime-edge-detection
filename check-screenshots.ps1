# Quick Screenshot Capture Script
# Run this after you've taken screenshots manually

Write-Host "========================================" -ForegroundColor Cyan
Write-Host "  Screenshot Verification Tool" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

$screenshotsDir = "C:\Users\Anurag\Desktop\project\screenshots"

# Required files
$requiredFiles = @(
    "web-viewer-main.png",
    "web-viewer-running.png", 
    "web-viewer-upload.png",
    "web-viewer-demo.gif",
    "android-app-main.png",
    "android-app-performance.png",
    "android-app-scene.png",
    "android-app-demo.gif"
)

Write-Host "Checking for required screenshots..." -ForegroundColor Yellow
Write-Host ""

$missingFiles = @()
$foundFiles = @()

foreach ($file in $requiredFiles) {
    $filePath = Join-Path $screenshotsDir $file
    if (Test-Path $filePath) {
        $size = (Get-Item $filePath).Length
        $sizeMB = [math]::Round($size / 1MB, 2)
        Write-Host "[✓] $file ($sizeMB MB)" -ForegroundColor Green
        $foundFiles += $file
    } else {
        Write-Host "[✗] $file (MISSING)" -ForegroundColor Red
        $missingFiles += $file
    }
}

Write-Host ""
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Summary:" -ForegroundColor Cyan
Write-Host "  Found: $($foundFiles.Count) / $($requiredFiles.Count)" -ForegroundColor $(if ($foundFiles.Count -eq $requiredFiles.Count) { "Green" } else { "Yellow" })
Write-Host "  Missing: $($missingFiles.Count)" -ForegroundColor $(if ($missingFiles.Count -eq 0) { "Green" } else { "Red" })
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

if ($missingFiles.Count -gt 0) {
    Write-Host "Still need to capture:" -ForegroundColor Yellow
    foreach ($file in $missingFiles) {
        Write-Host "  - $file" -ForegroundColor Red
    }
    Write-Host ""
    Write-Host "📸 See screenshots/README.md for capture instructions" -ForegroundColor Cyan
    Write-Host ""
} else {
    Write-Host "✓ All screenshots captured!" -ForegroundColor Green
    Write-Host ""
    Write-Host "Next steps:" -ForegroundColor Cyan
    Write-Host "  1. Review screenshots to ensure quality" -ForegroundColor White
    Write-Host "  2. Run: git add screenshots/" -ForegroundColor White
    Write-Host "  3. Run: git commit -m 'docs: add screenshots and demo GIFs'" -ForegroundColor White
    Write-Host "  4. Run: git push origin main" -ForegroundColor White
    Write-Host ""
}

# Offer to open folder
Write-Host "Would you like to open the screenshots folder? (Y/N): " -ForegroundColor Yellow -NoNewline
$response = Read-Host

if ($response -eq "Y" -or $response -eq "y") {
    explorer.exe $screenshotsDir
}
