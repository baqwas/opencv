#!/usr/bin/env python3
"""
@file ex02_smoothing_test.py
@brief Exercise 03: Spatial Filtering and Noise Reduction (cv2.GaussianBlur, cv2.medianBlur, cv2.bilateralFilter)

@version 1.0.0
@date 2026-08-15
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
Demonstrates advanced spatial smoothing techniques and noise reduction filters
designed to eliminate sensor grain or high-frequency artifacts while preserving vital edge structures.

@par Processing Workflow
1. Load source image matrix ('output_live_snap.png') in color format.
2. Apply Gaussian Blur to smooth out high-frequency noise using a weighted Gaussian kernel.
3. Apply Median Blur to effectively remove impulse noise (salt-and-pepper) while preserving sharp edges.
4. Apply Bilateral Filtering for edge-preserving smoothing across color spaces.
5. Serialize all smoothed output matrices to disk for remote cluster verification.
"""

import cv2
import sys

def main():
    ex_prefix = "Ex 02 - Smoothing"
    input_filename = "output_live_snap.png"

    print(f"[{ex_prefix}] 🔍 Loading source image for spatial filtering and smoothing...")

    src = cv2.imread(input_filename, cv2.IMREAD_COLOR)
    if src is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}. Ensure Chapter 1 capture was executed.", file=sys.stderr)
        sys.exit(1)

    # 1. Gaussian Blur (Kernel size 5x5, Sigma X = 0)
    gaussian_blurred = cv2.GaussianBlur(src, (5, 5), 0)
    cv2.imwrite("output_gaussian.png", gaussian_blurred)

    # 2. Median Blur (Aperture linear size = 5)
    median_blurred = cv2.medianBlur(src, 5)
    cv2.imwrite("output_median.png", median_blurred)

    # 3. Bilateral Filter (d = 9, sigmaColor = 75, sigmaSpace = 75)
    bilateral_smoothed = cv2.bilateralFilter(src, 9, 75, 75)
    cv2.imwrite("output_bilateral.png", bilateral_smoothed)

    print(f"[{ex_prefix}] ✅ Spatial filtering and smoothing completed successfully (Gaussian, Median, Bilateral).")

if __name__ == "__main__":
    main()
