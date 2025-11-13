/**
 * TypeScript Web Viewer for Edge Detection
 * Real-time FPS monitoring and frame visualization
 * @author AY-10
 * @version 2.0.0
 */

const img = document.getElementById("img") as HTMLImageElement;
const fpsEl = document.getElementById("fps")!;
const resEl = document.getElementById("res")!;
const statusEl = document.getElementById("status")!;

let lastTime = performance.now();
let frameCount = 0;
let currentFPS = 0;
let isImageLoaded = false;

/**
 * Main animation loop to calculate FPS
 * Simulates 60 FPS rendering cycle
 */
function tick(): void {
  frameCount++;
  const now = performance.now();
  const elapsed = now - lastTime;

  if (elapsed >= 1000) {
    // Calculate FPS with slight randomization for demo
    currentFPS = Math.round((frameCount * 1000) / elapsed);
    
    // Apply FPS color coding
    if (currentFPS >= 55) {
      fpsEl.className = "stat-value fps-high";
    } else if (currentFPS >= 30) {
      fpsEl.className = "stat-value";
    } else {
      fpsEl.className = "stat-value warning";
    }
    
    frameCount = 0;
    lastTime = now;
  }

  requestAnimationFrame(tick);
}

/**
 * Update resolution display when image loads
 */
img.onload = () => {
  const width = img.naturalWidth;
  const height = img.naturalHeight;
  resEl.textContent = `${width}×${height}`;
  isImageLoaded = true;
  
  console.log(`✅ Image loaded successfully: ${width}×${height}`);
  console.log(`📊 Image format: ${img.src.split('.').pop()?.toUpperCase()}`);
  
  // Update status
  if (statusEl) {
    statusEl.textContent = "Sample Mode";
    statusEl.className = "stat-value warning";
  }
};

/**
 * Handle image load errors
 */
img.onerror = () => {
  resEl.textContent = "Error";
  if (statusEl) {
    statusEl.textContent = "Load Failed";
    statusEl.style.color = "#ff4444";
  }
  console.error("❌ Failed to load sample image");
};

/**
 * Add keyboard shortcuts
 */
document.addEventListener("keydown", (e: KeyboardEvent) => {
  switch (e.key) {
    case "r":
    case "R":
      location.reload();
      console.log("🔄 Refreshing viewer...");
      break;
    case "f":
    case "F":
      if (document.fullscreenElement) {
        document.exitFullscreen();
      } else {
        document.getElementById("container")?.requestFullscreen();
      }
      console.log("⛶ Toggling fullscreen...");
      break;
    case "i":
    case "I":
      console.log("ℹ️ Edge Detection Viewer Info:");
      console.log(`  FPS: ${currentFPS}`);
      console.log(`  Resolution: ${resEl.textContent}`);
      console.log(`  Image Loaded: ${isImageLoaded}`);
      console.log(`  Status: ${statusEl?.textContent}`);
      break;
  }
});

/**
 * Performance monitoring
 */
const logPerformanceMetrics = () => {
  const metrics = {
    fps: currentFPS,
    resolution: resEl.textContent,
    imageLoaded: isImageLoaded,
    uptime: Math.round(performance.now() / 1000),
  };
  
  console.table(metrics);
};

// Start FPS counter
requestAnimationFrame(tick);

// Log initialization
console.log("🚀 Edge Detection Viewer initialized");
console.log("📷 Waiting for processed frames from Android app...");
console.log("💡 Keyboard shortcuts: R (refresh) | F (fullscreen) | I (info)");

// Log performance every 30 seconds
setInterval(logPerformanceMetrics, 30000);

// Export for debugging
(window as any).viewerDebug = {
  getFPS: () => currentFPS,
  getResolution: () => resEl.textContent,
  isLoaded: () => isImageLoaded,
  refresh: () => location.reload(),
  metrics: logPerformanceMetrics,
};

console.log("🔧 Debug tools available via window.viewerDebug");
