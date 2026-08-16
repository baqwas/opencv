#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@file hello_opencv.py
@brief Exercise 01: Environment Smoke Test and OpenCV Version Verification (`cv2.getVersionString`)

@version 1.0.0
@date 2026-08-16
@author Matha Goram (Systems Architect)

@copyright MIT License
Copyright (c) 2026 ParkCircus Productions. All Rights Reserved.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

@par Purpose
Serves as the foundational smoke test to confirm that Python bindings for OpenCV
are properly installed, linked, and accessible within the student's runtime environment.

@par Update History
- v1.0.0 (2026-08-16): Initial Python port for Chapter 01 getting started.

@par Prerequisites
- Python 3.8+
- OpenCV Python bindings (`pip install opencv-python`)

@par User Interface Guide
- Headless command-line utility.
- Standard output (`sys.stdout`) logs telemetry prefixed with `[Ex 01 - Hello OpenCV]`.

@par Error Message Responses
- Import Failure: Raises `ImportError` if OpenCV package is missing from the active Python environment.

@par Processing Workflow and Algorithms
1. Import the `cv2` module.
2. Query the runtime OpenCV version using `cv2.getVersionString()`.
3. Output confirmation to standard out and exit cleanly.
"""

import sys
import cv2

def main():
    ex_prefix = "Ex 01 - Hello OpenCV"
    print(f"[{ex_prefix}] 🚀 Initializing OpenCV Python environment verification...")

    try:
        version = cv2.getVersionString()
        print(f"[{ex_prefix}] ✅ OpenCV Core Library Version: {version}")
    except Exception as e:
        print(f"[{ex_prefix}] ❌ ERROR: Failed to query OpenCV version: {e}", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Environment smoke test completed successfully.")
    sys.exit(0)

if __name__ == "__main__":
    main()
