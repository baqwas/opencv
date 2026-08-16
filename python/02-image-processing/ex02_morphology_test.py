#!/usr/bin/env python3
"""
@file ex02_morphology_test.py
@brief Exercise 04: Morphological Operations (cv2.erode, cv2.dilate, cv2.morphologyEx)

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
Demonstrates advanced binary and grayscale morphological operations used for shape analysis,
noise removal, object separation, and structural gap-filling in computer vision pipelines.

@par Processing Workflow
1. Load source image matrix ('output_live_snap.png') in grayscale format.
2. Apply binary thresholding to prepare a clean segmentation mask.
3. Define a rectangular structuring kernel using cv2.getStructuringElement.
4. Perform Erosion to shrink boundaries and eliminate small isolated noise spots.
5. Perform Dilation to expand boundaries and bridge foreground gaps.
6. Execute Opening (erosion followed by dilation) to remove external noise.
7. Execute Closing (dilation followed by erosion) to close interior holes.
8. Serialize all resulting matrices to disk for remote cluster verification.
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 02 - Morphology"
    input_filename = "output_live_snap.png"

    print(f"[{ex_prefix}] 🧬 Loading source image for morphological processing...")

    src = cv2.imread(input_filename, cv2.IMREAD_GRAYSCALE)
    if src is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}. Ensure Chapter 1 capture was executed.", file=sys.stderr)
        sys.exit(1)

    # 1. Thresholding to create a binary mask
    _, bin_img = cv2.threshold(src, 128, 255, cv2.THRESH_BINARY)
    cv2.imwrite("output_binary.png", bin_img)

    # 2. Define structuring element (kernel)
    element = cv2.getStructuringElement(cv2.MORPH_RECT, (3, 3))

    # 3. Erosion
    eroded = cv2.erode(bin_img, element)
    cv2.imwrite("output_eroded.png", eroded)

    # 4. Dilation
    dilated = cv2.dilate(bin_img, element)
    cv2.imwrite("output_dilated.png", dilated)

    # 5. Opening (Erosion followed by Dilation)
    opened = cv2.morphologyEx(bin_img, cv2.MORPH_OPEN, element)
    cv2.imwrite("output_opened.png", opened)

    # 6. Closing (Dilation followed by Erosion)
    closed = cv2.morphologyEx(bin_img, cv2.MORPH_CLOSE, element)
    cv2.imwrite("output_closed.png", closed)

    print(f"[{ex_prefix}] ✅ Morphological operations completed successfully (Erode, Dilate, Open, Close).")

if __name__ == "__main__":
    main()
