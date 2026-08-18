# OpenCV Self-Paced Learning Exercises

# OpenCV Android, C++ & Python Lab Monorepository

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

**Code**
[![Language: C++17](https://img.shields.io/badge/C%2B%2B-17-blue.svg)](https://isocpp.org/)
[![Language: Java](https://img.shields.io/badge/Java-Android-orange.svg)](https://www.java.com/)
[![Language: Python](https://img.shields.io/badge/Python->=3.11-yellow.svg)](https://www.python.org/)

**Architectures:**
[![Architecture: amd64](https://img.shields.io/badge/Architecture-amd64-blue.svg)](https://en.wikipedia.org/wiki/X86-64)
[![Architecture: arm64](https://img.shields.io/badge/Architecture-arm64%2Faarch64-blue.svg)](https://en.wikipedia.org/wiki/64-bit_computing)

**Operating Systems:**
[![OS: Ubuntu](https://img.shields.io/badge/OS-Ubuntu-E95420.svg)](https://ubuntu.com/)
[![OS: Debian](https://img.shields.io/badge/OS-Debian-A81D33.svg)](https://www.debian.org/)
[![Platform: Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com/)

**Target Hardware:**
[![Hardware: Raspberry Pi](https://img.shields.io/badge/Hardware-Raspberry_Pi-C51A4A.svg)](https://www.raspberrypi.com/)
[![Hardware: NVIDIA Jetson](https://img.shields.io/badge/Hardware-NVIDIA_Jetson_Orin-76B900.svg)](https://www.nvidia.com/en-us/autonomous-machines/embedded-systems/)
[![Hardware: Intel Core Ultra](https://img.shields.io/badge/Hardware-Intel_Core_Ultra-0071C5.svg)](https://www.intel.com/content/www/us/en/products/details/processors/core-ultra.html)

**Security**
[![Security: ggshield](https://img.shields.io/badge/Security-ggshield-blueviolet.svg)](https://gitguardian.com/)

**Repository**
[![GitHub last commit](https://img.shields.io/github/last-commit/baqwas/opencv)](https://github.com/baqwas/opencv/commits/main)
[![GitHub issues](https://img.shields.io/github/issues/baqwas/opencv)](https://github.com/baqwas/opencv/issues)
[![GitHub stars](https://img.shields.io/github/stars/baqwas/opencv?style=social)](https://github.com/baqwas/opencv/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/baqwas/opencv?style=social)](https://github.com/baqwas/opencv/network/members)

---

## Introduction

Welcome to the **OpenCV Android & C++ Lab** monorepository! This project serves as an experimental sandbox and modular learning toolkit designed for exploring computer vision, image processing, and hardware sensor integration. Built with cross-platform portability in mind, the codebase bridges low-level C++ core logic with high-level Android application modules—featuring robust implementations for direct pixel manipulation (RGB/BGR gradients), alpha blending, geometric region-of-interest (ROI) filtering, split-and-merge channels, and real-time hardware camera ingestion using native GStreamer and `libcamera` pipelines.

Whether you are testing standalone algorithms or deploying accelerated video pipelines to mobile and embedded systems, this repository provides clean, well-structured examples to accelerate your computer vision development.

---

## Repository Structure

- `android/` - Android Studio project containing modular getting-started activities (`BlendTestActivity`, `CameraSnapActivity`, `CameraStreamActivity`, etc.).
- `native/` - Native C++ test harnesses and low-level processing modules.
- `etc/` - License documentation and configuration files.

## Getting Started

1. Clone the repository:
   ```bash
   git clone [https://github.com/baqwas/opencv.git](https://github.com/baqwas/opencv.git)
## 🎯 Repository Intent

The primary goal of this repository is twofold:

* **The Learning Curve**: To provide a structured, stepwise progression of C++ and Python exercises that scale from fundamental pixel manipulation to advanced deep learning-based inference and geometry transformations.
* **The Unified Sandbox**: To house independent project workflows—ranging from low-latency edge computing scripts on single-board hardware to mobile-optimized Android NDK modules—under a single, clean workspace.

## 📂 Repository Structure

```Plaintext

opencv/
├── .github/
│   └── workflows/          # Automated CI pipeline checks
├── cpp/                    # CLion C++ Workspace (Stepwise learning exercises)
│   ├── CMakeLists.txt      # Master CMake build orchestration
│   ├── common/             # Shared helper utilities and visualization tools
│   ├── 01-getting-started/ # Core structures, matrices, and basic I/O
│   ├── 02-image-processing/# Filtering, color spaces, and thresholding
│   ├── 03-geometry-transforms/ # Affine, perspective, and resizing
│   └── ...                 # Advanced modules (contours, features, DNN)
├── python/                 # PyCharm Python Workspace (Scripts & notebooks)
│   ├── requirements.txt
│   └── exercises/
├── android/                # Android Studio Workspace (NDK / JNI integration)
└── README.md
```

## 🛠️ Technology Stack & Toolchain

* **Core Engine**: OpenCV 5 (5.x branch) with opencv_contrib modules.
* **C++ Environment**: Developed and built via CLion using modern CMake (C++17 standard).
* **Python Environment**: Prototyped in PyCharm with NumPy, Matplotlib, and integrated tooling.
* **Mobile Environment**: Handled via Android Studio utilizing native C++ layers through the Android NDK.
* **CI/CD**: Automated GitHub Actions workflows verifying syntax and compilation health on every push.

---

## 📄 License

This project is open-source and available under the terms of the [MIT License](LICENSE).

Copyright © 2026 **ParkCircus Productions**. All rights reserved.
