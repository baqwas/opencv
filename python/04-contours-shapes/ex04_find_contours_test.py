#!/usr/bin/env python3
"""
@file ex04_find_contours_test.py
@brief Exercise 01: Binary Thresholding and Contour Extraction (cv2.findContours, cv2.drawContours)

@version 1.0.0
@date 2026-08-15
@author A Reza M Wajih (Systems Architect)

@copyright MIT License
Copyright (c) 2026 A Reza M Wajih

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
Demonstrates basic contour retrieval from a binary image matrix, allowing identification
and visualization of object boundaries in computer vision pipelines.
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 04 - Find Contours"
    input_filename = "output_live_snap.png"

    print(f"[{ex_prefix}] 🧬 Loading source image for contour extraction...")

    # 1. Load source image in grayscale format[cite: 12]
    src = cv2.imread(input_filename, cv2.IMREAD_GRAYSCALE)
    if src is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}. Ensure preceding image capture was executed.", file=sys.stderr)
        sys.exit(1)

    # 2. Apply binary thresholding[cite: 12]
    _, bin_img = cv2.threshold(src, 100, 255, cv2.THRESH_BINARY)

    # 3. Execute cv2.findContours using RETR_EXTERNAL and CHAIN_APPROX_SIMPLE[cite: 12]
    contours, hierarchy = cv2.findContours(bin_img, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

    # 4. Render extracted contours onto an RGB canvas[cite: 12]
    drawing = np.zeros((src.shape[0], src.shape[1], 3), dtype=np.uint8)
    for i in range(len(contours)):
        color = (0, 255, 0)
        cv2.drawContours(drawing, contours, i, color, 2, cv2.LINE_8, hierarchy, 0)

    # 5. Serialize output to disk[cite: 12]
    output_filename = "output_contours.png"
    if not cv2.imwrite(output_filename, drawing):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to serialize output image to {output_filename}.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Contour extraction completed successfully. Found {len(contours)} contours. Output saved to {output_filename}.")

if __name__ == "__main__":
    main()
