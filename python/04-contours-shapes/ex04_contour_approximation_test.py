#!/usr/bin/env python3
"""
@file ex04_contour_approximation_test.py
@brief Exercise 03: Contour Polygonal Approximation (cv2.approxPolyDP)

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
Simplifies complex contours into polygonal curves with fewer vertices using the
Douglas-Peucker algorithm (cv2.approxPolyDP).
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 04 - Contour Approximation"
    input_filename = "output_live_snap.png"

    print(f"[{ex_prefix}] 🔷 Loading source image for polygonal contour approximation...")

    # 1. Load source image and binarize[cite: 9]
    src = cv2.imread(input_filename, cv2.IMREAD_COLOR)
    if src is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}.", file=sys.stderr)
        sys.exit(1)

    gray = cv2.cvtColor(src, cv2.COLOR_BGR2GRAY)
    _, bin_img = cv2.threshold(gray, 100, 255, cv2.THRESH_BINARY)

    # 2. Extract contours[cite: 9]
    contours, _ = cv2.findContours(bin_img, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

    drawing = src.copy()
    for contour in contours:
        if cv2.contourArea(contour) < 500.0:
            continue

        # 3. Apply cv2.approxPolyDP with epsilon proportional to contour perimeter[cite: 9]
        epsilon = 0.02 * cv2.arcLength(contour, True)
        approx = cv2.approxPolyDP(contour, epsilon, True)

        # 4. Draw approximated polygons[cite: 9]
        cv2.polylines(drawing, [approx], True, (0, 255, 255), 3)

    # Serialize to disk[cite: 9]
    output_filename = "output_approx_poly.png"
    if not cv2.imwrite(output_filename, drawing):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to serialize output image.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Polygonal approximation completed successfully. Output saved to {output_filename}.")

if __name__ == "__main__":
    main()
