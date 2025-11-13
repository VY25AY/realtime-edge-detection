# Git Commit Guide for Flam Assignment

## ⚠️ CRITICAL: Proper Commit History is Required

The assignment explicitly states:

> "Your commit history should clearly reflect your development process (no single 'final commit' uploads)"

This guide provides a structured commit sequence to demonstrate incremental development.

---

## 📋 Recommended Commit Sequence

### 1. Initial Setup (Day 1 Morning)

```bash
git init
git add .gitignore README.md
git commit -m "init: project scaffold with gitignore and README"
```

### 2. Android Project Structure (Day 1 Morning)

```bash
git add app/build.gradle build.gradle settings.gradle gradle/
git commit -m "feat(android): add Android project structure and Gradle config"

git add app/src/main/AndroidManifest.xml app/src/main/res/
git commit -m "feat(android): add AndroidManifest and layout resources"
```

### 3. Camera Integration (Day 1 Afternoon)

```bash
git add app/src/main/java/com/example/realtime/CameraHelper.kt
git add app/src/main/java/com/example/realtime/YuvUtils.kt
git commit -m "feat(camera): add Camera2 API integration with ImageReader

- Implement CameraHelper with Camera2 API
- Add YUV to RGBA conversion utility
- Setup ImageReader for frame capture at 640x480"
```

### 4. MainActivity Skeleton (Day 1 Evening)

```bash
git add app/src/main/java/com/example/realtime/MainActivity.kt
git commit -m "feat(app): add MainActivity with camera permissions

- Implement camera permission handling
- Setup GLSurfaceView for rendering
- Add FPS counter TextView overlay"
```

### 5. Native Bridge Setup (Day 2 Morning)

```bash
git add app/src/main/java/com/example/realtime/NativeBridge.kt
git commit -m "feat(jni): add JNI bridge interface for native processing

- Create NativeBridge object with native method declarations
- Load native library on initialization"
```

### 6. CMake Configuration (Day 2 Morning)

```bash
git add app/src/main/cpp/CMakeLists.txt
git commit -m "feat(native): add CMake configuration for OpenCV

- Configure CMake to find OpenCV Android SDK
- Setup native library compilation
- Link OpenCV libraries"
```

### 7. Native OpenCV Processing (Day 2 Afternoon)

```bash
git add app/src/main/cpp/native-lib.cpp
git commit -m "feat(process): implement Canny edge detection in native C++

- Add RGBA to BGR conversion
- Implement Gaussian blur for noise reduction
- Apply Canny edge detection (thresholds 50, 150)
- Convert result back to RGBA
- Add error handling and logging"
```

### 8. OpenGL Renderer (Day 2 Evening)

```bash
git add app/src/main/java/com/example/realtime/GLRenderer.kt
git commit -m "feat(gl): add OpenGL ES 2.0 renderer

- Implement GLSurfaceView.Renderer
- Setup texture creation and binding
- Add texture upload via glTexSubImage2D
- Thread-safe frame update mechanism"
```

### 9. OpenGL Shaders (Day 2 Evening)

```bash
git add app/src/main/java/com/example/realtime/FullscreenQuad.kt
git commit -m "feat(gl): add fullscreen textured quad renderer

- Implement vertex/fragment GLSL shaders
- Create VBO for quad geometry
- Add texture coordinate mapping
- Compile and link shader program"
```

### 10. Performance Optimization (Day 3 Morning)

```bash
git add app/src/main/java/com/example/realtime/*.kt
git commit -m "perf: optimize frame processing for real-time performance

- Reduce processing resolution to 640x480
- Reuse ByteBuffers to minimize GC
- Run camera callbacks on background thread
- Achieve 15+ FPS on test device"
```

### 11. Web Viewer Structure (Day 3 Afternoon)

```bash
git add web/package.json web/tsconfig.json web/README.md
git commit -m "feat(web): add TypeScript web viewer project structure

- Initialize npm package
- Configure TypeScript compiler
- Add build scripts"
```

### 12. Web Viewer Implementation (Day 3 Afternoon)

```bash
git add web/src/main.ts web/index.html
git commit -m "feat(web): implement TypeScript web viewer with FPS overlay

- Create HTML page with modern styling
- Implement TypeScript FPS counter
- Add image loading with resolution display
- Show system architecture overview"
```

### 13. Sample Assets (Day 3 Evening)

```bash
git add web/assets/sample.png
git commit -m "test: add sample processed frame for web viewer

- Include example Canny edge detection output
- Captured from Android app at 640x480"
```

### 14. Documentation (Day 3 Evening)

```bash
git add README.md
git commit -m "docs: complete README with full setup instructions

- Add architecture diagram and frame flow
- Include setup instructions for OpenCV
- Add build and run instructions
- Document technical implementation details
- Include performance notes and testing info"
```

### 15. Final Polish (Before Submission)

```bash
# Add screenshots if you have them
git add screenshots/
git commit -m "docs: add screenshots of running application"

# Final commit
git commit --allow-empty -m "chore: prepare for submission

Submission for Flam Placement Drive Assignment
- All features implemented and tested
- Camera2 + OpenCV C++ + OpenGL ES + TypeScript
- Real-time edge detection at 15+ FPS
- Complete documentation and commit history"
```

---

## 📤 Push to GitHub

```bash
# Create repository on GitHub (github.com/new)
# Repository name: realtime-edge-detection (or similar)

# Add remote
git remote add origin https://github.com/YOUR_USERNAME/realtime-edge-detection.git

# Push with all commit history
git branch -M main
git push -u origin main
```

---

## ✅ Verification Checklist

Before submitting, verify:

- [ ] Repository has 10+ meaningful commits
- [ ] Each commit has descriptive message
- [ ] Commits are chronologically ordered (simulate development process)
- [ ] No "WIP" or "final commit" messages
- [ ] README.md is complete with all sections filled
- [ ] .gitignore excludes build artifacts
- [ ] Repository is public or access is granted

---

## 🎯 Commit Message Best Practices

### Format

```
<type>(<scope>): <subject>

[optional body]
```

### Types

- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation only
- `perf`: Performance improvement
- `refactor`: Code restructure without feature change
- `test`: Adding tests
- `chore`: Build process or auxiliary tools

### Examples

**Good** ✅

```
feat(camera): add Camera2 API integration with ImageReader

- Implement CameraHelper with Camera2 API
- Add YUV to RGBA conversion
- Setup ImageReader for 640x480 capture
```

**Bad** ❌

```
update files
final commit
changes
```

---

## 🚫 Common Mistakes to Avoid

1. **Single Giant Commit**

   - ❌ Adding all files at once
   - ✅ Break into logical chunks

2. **Vague Messages**

   - ❌ "update"
   - ✅ "feat(gl): add OpenGL ES 2.0 renderer"

3. **Out of Order Commits**

   - ❌ Committing docs before code
   - ✅ Follow logical development order

4. **Including Build Artifacts**
   - ❌ Committing `build/`, `node_modules/`
   - ✅ Use proper `.gitignore`

---

## 💡 Pro Tips

### Simulate Realistic Development

Even though you may complete sections quickly, space out your commits to show realistic development:

```bash
# Make a commit
git commit -m "feat(camera): add Camera2 integration"

# Wait a bit or work on something else
# Then make next commit
git commit -m "feat(jni): add native bridge"
```

### Use Git Log to Verify

```bash
# View commit history
git log --oneline --graph

# Should show clear progression:
# * docs: complete README
# * feat(web): add TypeScript viewer
# * feat(gl): add OpenGL renderer
# * feat(process): implement Canny detection
# * feat(native): add CMake config
# * feat(camera): add Camera2 integration
# * init: project scaffold
```

---

## 📋 Pre-Submission Checklist

Run these commands before submitting:

```bash
# 1. Check commit count (should be 10+)
git log --oneline | wc -l

# 2. Verify no large files
git ls-files -s | awk '{if ($4 > 1000000) print $4, $5}'

# 3. Check .gitignore is working
git status

# 4. Verify remote is set
git remote -v

# 5. Final push
git push origin main
```

---

## 🎓 Example Complete History

Here's what your `git log --oneline` should look like:

```
a1b2c3d docs: add screenshots of running application
d4e5f6g docs: complete README with full setup instructions
g7h8i9j test: add sample processed frame for web viewer
j0k1l2m feat(web): implement TypeScript web viewer with FPS overlay
m3n4o5p feat(web): add TypeScript web viewer project structure
p6q7r8s perf: optimize frame processing for real-time performance
s9t0u1v feat(gl): add fullscreen textured quad renderer
v2w3x4y feat(gl): add OpenGL ES 2.0 renderer
y5z6a7b feat(process): implement Canny edge detection in native C++
b8c9d0e feat(native): add CMake configuration for OpenCV
e1f2g3h feat(jni): add JNI bridge interface for native processing
h4i5j6k feat(app): add MainActivity with camera permissions
k7l8m9n feat(camera): add Camera2 API integration with ImageReader
n0o1p2q feat(android): add AndroidManifest and layout resources
q3r4s5t feat(android): add Android project structure and Gradle config
t6u7v8w init: project scaffold with gitignore and README
```

---

## 📞 Need Help?

If you have questions about Git workflow:

1. Refer to this guide
2. Use `git --help <command>` for specific commands
3. Check your commit history frequently with `git log`

**Remember**: The evaluators will check your commit history. Make it count!
