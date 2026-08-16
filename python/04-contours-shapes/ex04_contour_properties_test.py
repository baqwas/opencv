#!/usr/bin/env python3
"""
@file ex04_contour_properties_test.py
@brief Exercise 02: Contour Bounding Geometries (cv2.boundingRect, cv2.minAreaRect, cv2.minEnclosingCircle)

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
Computes geometric descriptors and spatial bounding containers (rectangles, rotated boxes,
and circles) for detected contours.
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 04 - Contour Properties"
    input_filename = "output_live_snap.png"

    print(f"[{ex_prefix}] 📐 Loading source image for contour property analysis...")

    # 1. Load source image and binarize[cite: 10]
    src = cv2.imread(input_filename, cv2.IMREAD_COLOR)
    if src is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}.", file=sys.stderr)
        sys.exit(1)

    gray = cv2.cvtColor(src, cv2.COLOR_BGR2GRAY)
    _, bin_img = cv2.threshold(gray, 100, 255, cv2.THRESH_BINARY)

    # 2. Extract contours via cv2.findContours[cite: 10]
    contours, _ = cv2.findContours(bin_img, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

    drawing = src.copy()
    for contour in contours:
        if cv2.contourArea(contour) < 500.0:
            continue  # Filter small noise[cite: 10]

        # Compute bounding rect and draw[cite: 10]
        x, y, w, h = cv2.boundingRect(contour)
        cv2.rectangle(drawing, (x, y), (x + w, y + h), (0, 255, 0), 2)

        # Compute min area rect, get box points, and draw[cite: 10]
        min_rect = cv2.minAreaRect(contour)
        box_points = cv2.boxPoints(min_rect)
        box_points = np.int32(box_points)
        for j in range(4):
            pt1 = tuple(box_points[j])
            pt2 = tuple(box_points[(j + 1) % 4])
            cv2.line(drawing, pt1, pt2, (255, 0, 0), 2)

        # Compute min enclosing circle and draw[cite: 10]
        center, radius = cv2.minEnclosingCircle(contour)
        cv2.circle(drawing, (int(center[0]), int(center[1])), int(radius), (0, 0, 255), 2)

    # Serialize output[cite: 10]
    output_filename = "output_contour_properties.png"
    if not cv2.imwrite(output_filename, drawing):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to serialize output image.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Contour properties analysis completed. Output saved to {output_filename}.")

if __name__ == "__main__":
    main()
