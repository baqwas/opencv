#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@file ex01_blend_test.py
@brief Exercise 06: Pixel-Wise Linear Combination and Alpha Blending (`cv2.addWeighted`)

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
Demonstrates combining two equal-sized image buffers using weighted alpha blending formulas.

@par Update History
- v1.0.0 (2026-08-16): Initial Python port for Chapter 01 getting started.

@par Processing Workflow and Algorithms
1. Load or generate two source images of identical dimensions.
2. Apply `cv2.addWeighted(img1, alpha, img2, beta, gamma)` to blend pixels.
3. Serialize the composite result to disk.
"""

import sys
import numpy as np
import cv2

def main():
    ex_prefix = "Ex 01 - Blend"
    print(f"[{ex_prefix}] ⚖️ Initializing alpha blending pipeline...")

    # Create two matching 300x300 frames with distinct colors
    img1 = np.full((300, 300, 3), (255, 0, 0), dtype=np.uint8)   # Blue image
    img2 = np.full((300, 300, 3), (0, 0, 255), dtype=np.uint8)   # Red image

    # Alpha blend: 70% img1, 30% img2
    alpha = 0.7
    beta = 0.3
    gamma = 0.0
    blended = cv2.addWeighted(img1, alpha, img2, beta, gamma)

    output_filename = "output_blended.png"
    if not cv2.imwrite(output_filename, blended):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to save blended output.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Alpha blending completed successfully. Saved to {output_filename}.")
    sys.exit(0)

if __name__ == "__main__":
    main()
