# Install OpenCV from Source

Here are the full instructions and the generalized automation script for cloning, configuring, building, and validating OpenCV 5 with full mathematical acceleration (Eigen3, OpenBLAS) and robust USB/CSI camera stream support via GStreamer on an Ubuntu/Linux target environment, enhanced with color Unicode icons. This document is intended to serve as Plan B. One should always download the binary packages where available for your deployment platoform.


---

### 📦 Prerequisites & Dependencies Installation

Building OpenCV from source requires a robust toolchain. The core mathematical packages include **Eigen3** for dense matrix linear algebra operations and **OpenBLAS** for optimized BLAS routines. For camera hardware integration (USB webcams and CSI sensor pipelines), **GStreamer** development packages are explicitly linked via CMake.

---

### 🛠️ Automated Build & Validation Script (`build_opencv5.sh`)

Save the following script as `build_opencv5.sh`, make it executable (`chmod +x build_opencv5.sh`), and run it inside your development workspace.

```bash
#!/usr/bin/env bash
set -e

# ==============================================================================
# Script Name:      build_opencv5.sh
# Description:      Automates cloning, building, and installing OpenCV 5.x
#                   alongside opencv_contrib, Eigen3, OpenBLAS, and GStreamer.
# ==============================================================================

WORKSPACE_DIR="$HOME/opencv_build"
INSTALL_PREFIX="/usr/local"

echo "⚙️ [*] Step 1: Installing system build tools and numerical/media dependencies..."
sudo apt-get update
sudo apt-get install -y \
    build-essential \
    cmake \
    git \
    pkg-config \
    libjpeg-dev \
    libpng-dev \
    libtiff-dev \
    libwebp-dev \
    libopenexr-dev \
    libatlas-base-dev \
    libblas-dev \
    liblapack-dev \
    libeigen3-dev \
    libopenblas-dev \
    libgstreamer1.0-dev \
    libgstreamer-plugins-base1.0-dev \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-ugly \
    gstreamer1.0-libav \
    python3-dev \
    python3-numpy \
    python3-pip

echo "📁 [*] Step 2: Preparing workspace directory at ${WORKSPACE_DIR}..."
mkdir -p "${WORKSPACE_DIR}"
cd "${WORKSPACE_DIR}"

echo "📥 [*] Step 3: Cloning OpenCV 5.x and opencv_contrib repositories..."
if [ ! -d "opencv" ]; then
    git clone --depth 1 --branch 5.x https://github.com/opencv/opencv.git
fi

if [ ! -d "opencv_contrib" ]; then
    git clone --depth 1 --branch 5.x https://github.com/opencv/opencv_contrib.git
fi

# Create build directory
cd opencv
mkdir -p build
cd build

echo "🔧 [*] Step 4: Configuring project flags with CMake..."
cmake -D CMAKE_BUILD_TYPE=Release \
      -D CMAKE_INSTALL_PREFIX="${INSTALL_PREFIX}" \
      -D OPENCV_EXTRA_MODULES_PATH="${WORKSPACE_DIR}/opencv_contrib/modules" \
      -D WITH_EIGEN=ON \
      -D WITH_OPENBLAS=ON \
      -D WITH_GSTREAMER=ON \
      -D WITH_FFMPEG=ON \
      -D BUILD_EXAMPLES=OFF \
      -D BUILD_TESTS=OFF \
      -D BUILD_PERF_TESTS=OFF \
      -D PYTHON3_EXECUTABLE="$(which python3)" \
      -D BUILD_opencv_python3=ON \
      -D INSTALL_PYTHON_EXAMPLES=OFF \
      -D INSTALL_C_EXAMPLES=OFF ..

echo "⚡ [*] Step 5: Compiling binaries (using all available hardware cores)..."
make -j"$(nproc)"

echo "💾 [*] Step 6: Installing libraries to system paths..."
sudo make install
sudo ldconfig

echo "🧪 [*] Step 7: Validating installation with a simple Python check..."
python3 -c "import cv2; print('Successfully deployed OpenCV version:', cv2.__version__)"

echo "🎉 [*] Build and verification completed successfully!"

```

---

### 📱 OpenCV SDK for Android Notes

If you plan to cross-compile or integrate OpenCV 5 modules into an Android application package (`.aar` or native JNI bindings), keep the following architectural guidelines in mind:

* 🛠️ **Build Environment Toolchain:** Compiling the Android SDK wrapper natively requires the **Android NDK** (version recommended by the target OpenCV branch) and **Gradle** installed alongside a configured JDK.
* 📜 **Build Script Target:** OpenCV supplies a dedicated build script located within the source tree at `platforms/android/build_sdk.py`. It automates the generation of target ABIs (`armeabi-v7a`, `arm64-v8a`, `x86`, `x86_64`).
* 🚀 **Execution Command:**
```bash
python3 platforms/android/build_sdk.py <output_directory> <opencv_source_directory>

```


* 🔗 **Integration Strategy:** Once compiled, the resulting package exposes a standard library structure that can be imported directly into Android Studio projects as a module dependency or bundled inside custom JNI dynamic libraries to interface with mobile camera streams (Camera2 API) or hardware-accelerated filters.
