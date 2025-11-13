/**
 * TypeScript Web Viewer for Edge Detection
 * Displays sample processed frame with live FPS counter
 */

const img = document.getElementById('img') as HTMLImageElement;
const fpsEl = document.getElementById('fps')!;
const resEl = document.getElementById('res')!;

let lastTime = performance.now();
let frameCount = 0;
let currentFPS = 0;

/**
 * Main animation loop to calculate FPS
 */
function tick(): void {
    frameCount++;
    const now = performance.now();
    const elapsed = now - lastTime;

    if (elapsed >= 1000) {
        currentFPS = Math.round((frameCount * 1000) / elapsed);
        fpsEl.textContent = currentFPS.toString();
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
    console.log(`Image loaded: ${width}×${height}`);
};

/**
 * Handle image load errors
 */
img.onerror = () => {
    resEl.textContent = 'Error loading';
    console.error('Failed to load sample image');
};

// Start FPS counter
requestAnimationFrame(tick);

// Log initialization
console.log('Edge Detection Viewer initialized');
console.log('Waiting for sample frame from Android app...');
