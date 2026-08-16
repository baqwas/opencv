#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@file ex01_gradient_test.py
@brief Exercise 03: Pixel-Level Matrix Manipulation and Color Gradient Generation

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
Illustrates vectorised and iterative pixel mapping techniques to construct smooth color
gradients across image matrix buffers.

@par Update History
- v1.0.0 (2026-08-16): Initial Python port for Chapter 01 getting started.

@par Processing Workflow and Algorithms
1. Construct coordinate meshgrids or vectorized array slices for width and height.
2. Compute harmonic intensity transitions across color channels.
3. Export the resulting visual gradient pattern as `output_gradient.png`.
"""

import sys
import numpy as np
import cv2


def main():
    ex_prefix = "Ex 01 - Gradient"
    print(f"[{ex_prefix}] 🌈 Generating vectorized color gradient matrix...")

    width, height = 512, 512

    # Vectorized gradient calculation using NumPy arrays for high performance
    x = np.linspace(0, 255, width, dtype=np.uint8)
    y = np.linspace(0, 255, height, dtype=np.uint8)

    xx, yy = np.meshgrid(x, y)

    gradient = np.zeros((height, width, 3), dtype=np.uint8)
    gradient[:, :, 0] = xx  # Blue channel ramp
    gradient[:, :, 1] = yy  # Green channel ramp
    gradient[:, :, 2] = 128  # Constant Red baseline

    output_filename = "output_gradient.png"
    if not cv2.imwrite(output_filename, gradient):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to write gradient asset to {output_filename}.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Gradient generated and saved successfully to {output_filename}.")
    sys.exit(0)


if __name__ == "__main__":
    main()
