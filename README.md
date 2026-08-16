# OpenCV Self-Paced Learning Exercises

Welcome to the central workspace for all computer vision development, experimentation, and mastery. This repository serves as a multi-language monorepo designed to explore the full capabilities of OpenCV 5 across native C++, Python prototyping, and mobile Android integrations.

<p align="center">
  <a href="https://github.com/baqwas/opencv/actions/workflows/ci.yml">
    <img src="https://github.com/baqwas/opencv/actions/workflows/ci.yml/badge.svg" alt="CI Status">
  </a>
  <img src="https://img.shields.io/badge/OpenCV-5.x-green.svg" alt="OpenCV Version">
  <img src="https://img.shields.io/badge/C%2B%2B-17-blue.svg" alt="C++ Standard">
  <img src="https://img.shields.io/badge/python-%3E%3D3.11-blue.svg" alt="Python Version">
  <img src="https://img.shields.io/badge/platform-Linux%20%7C%20Android-lightgrey.svg" alt="Platforms">
</p>

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
