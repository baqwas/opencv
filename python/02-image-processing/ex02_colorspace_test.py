#!/usr/bin/env python3
"""
@file ex02_colorspace_test.py
@brief Exercise 01: Multi-Channel Color Space Transformations (cv2.cvtColor)

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
Demonstrates the conversion of a standard BGR image into alternative color spaces
(Grayscale, HSV, and LAB) essential for feature extraction, thresholding, and color segmentation.

@par Processing Workflow
1. Load source image matrix ('output_live_snap.png').
2. Convert BGR to Grayscale for intensity-based operations.
3. Convert BGR to HSV for robust color-based masking independent of illumination.
4. Convert BGR to LAB for perceptual color uniformity.
5. Serialize all transformed matrices to disk for remote verification.
"""

import cv2
import sys

def main():
    ex_prefix = "Ex 02 - ColorSpace"
    input_filename = "output_live_snap.png"

    print(f"[{ex_prefix}] 🎨 Loading source image for color transformation...")

    src = cv2.imread(input_filename, cv2.IMREAD_COLOR)
    if src is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}. Ensure Chapter 1 capture was executed.", file=sys.stderr)
        sys.exit(1)

    # 1. Grayscale Conversion
    gray = cv2.cvtColor(src, cv2.COLOR_BGR2GRAY)
    cv2.imwrite("output_gray.png", gray)

    # 2. HSV Conversion (Hue, Saturation, Value)
    hsv = cv2.cvtColor(src, cv2.COLOR_BGR2HSV)
    cv2.imwrite("output_hsv.png", hsv)

    # 3. LAB Conversion (CIELAB Uniform Color Space)
    lab = cv2.cvtColor(src, cv2.COLOR_BGR2LAB)
    cv2.imwrite("output_lab.png", lab)

    print(f"[{ex_prefix}] ✅ Color space transformations completed successfully across Gray, HSV, and LAB channels.")

if __name__ == "__main__":
    main()
