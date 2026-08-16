#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@file ex01_canvas_test.py
@brief Exercise 02: Dynamic Matrix Allocation and Primitive Shape Rendering (`np.zeros`, `cv2.rectangle`)

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
Demonstrates allocating a NumPy multi-dimensional array as an image buffer and rendering
geometric primitives (rectangles, circles, and text annotations) onto the canvas.

@par Update History
- v1.0.0 (2026-08-16): Initial Python port for Chapter 01 getting started.

@par Prerequisites
- Python 3.8+, NumPy, OpenCV Python bindings

@par User Interface Guide
- Headless utility. Serializes the generated canvas to disk as `output_canvas.png`.

@par Error Message Responses
- Serialization Failure: Logs an error if `cv2.imwrite` fails to write the asset to disk.

@par Processing Workflow and Algorithms
1. Allocate a 3-channel 8-bit BGR canvas matrix (640x480) initialized to zero.
2. Draw a filled background rectangle and concentric geometric shapes.
3. Render descriptive text annotations using `cv2.putText`.
4. Serialize the frame buffer to disk.
"""

import sys
import numpy as np
import cv2

def main():
    ex_prefix = "Ex 01 - Canvas"
    print(f"[{ex_prefix}] 🎨 Initializing blank canvas matrix allocation...")

    # 1. Allocate 640x480 3-channel BGR image matrix
    width, height = 640, 480
    canvas = np.zeros((height, width, 3), dtype=np.uint8)

    # 2. Draw background fill and geometric primitives
    cv2.rectangle(canvas, (50, 50), (590, 430), (40, 40, 40), -1)
    cv2.circle(canvas, (320, 240), 100, (0, 255, 0), 3)
    cv2.putText(canvas, "OpenCV Python Canvas", (140, 245),
                cv2.FONT_HERSHEY_SIMPLEX, 0.8, (255, 255, 255), 2, cv2.LINE_AA)

    # 3. Serialize canvas to disk
    output_filename = "output_canvas.png"
    success = cv2.imwrite(output_filename, canvas)
    if not success:
        print(f"[{ex_prefix}] ❌ ERROR: Failed to serialize canvas image to {output_filename}.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Canvas generated and serialized successfully to {output_filename}.")
    sys.exit(0)

if __name__ == "__main__":
    main()
