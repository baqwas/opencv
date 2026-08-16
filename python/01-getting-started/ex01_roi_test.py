#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@file ex01_roi_test.py
@brief Exercise 07: Zero-Copy Memory Slicing and Region of Interest (ROI) Manipulation

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
Demonstrates extracting and modifying sub-matrices (Regions of Interest) without allocating
duplicate memory buffers, utilizing NumPy slice references.

@par Update History
- v1.0.0 (2026-08-16): Initial Python port for Chapter 01 getting started.

@par Processing Workflow and Algorithms
1. Load source image matrix.
2. Slice target region coordinates using array slicing (`img[y1:y2, x1:x2]`).
3. Apply in-place color transformation to the ROI view.
4. Verify parent matrix modification and write artifact to disk.
"""

import sys
import os
import numpy as np
import cv2

def main():
    ex_prefix = "Ex 01 - ROI"
    input_filename = "output_canvas.png"

    print(f"[{ex_prefix}] 📐 Extracting Region of Interest (ROI) via view slicing...")

    if not os.path.exists(input_filename):
        dummy = np.full((300, 300, 3), (100, 100, 100), dtype=np.uint8)
        cv2.imwrite(input_filename, dummy)

    src = cv2.imread(input_filename, cv2.IMREAD_COLOR)
    if src is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load source image.", file=sys.stderr)
        sys.exit(1)

    # Define ROI slice bounds (y: 100 to 250, x: 150 to 350)
    roi = src[100:250, 150:350]

    # In-place color tinting on ROI view (adding green tint)
    roi[:, :, 1] = cv2.add(roi[:, :, 1], 50)

    output_filename = "output_roi_modified.png"
    if not cv2.imwrite(output_filename, src):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to save ROI modified image.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ ROI view extraction and in-place modification complete. Saved to {output_filename}.")
    sys.exit(0)

if __name__ == "__main__":
    main()
