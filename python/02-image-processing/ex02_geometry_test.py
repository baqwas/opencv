#!/usr/bin/env python3
"""
@file ex02_geometry_test.py
@brief Exercise 02: Geometric Transformations (cv2.resize, cv2.warpAffine)

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
Demonstrates fundamental 2D geometric transformations on image matrices,
including spatial scaling, translation shifts, and affine rotations around the image center.

@par Processing Workflow
1. Load source image matrix ('output_live_snap.png').
2. Perform spatial scaling (resize dimensions by a factor of 0.5).
3. Apply a 2D translation matrix shift along coordinate axes.
4. Execute an affine rotation matrix transformation around the geometric center.
5. Serialize all transformed matrices to disk for remote verification.
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 02 - Geometry"
    input_filename = "output_live_snap.png"

    print(f"[{ex_prefix}] 📐 Loading source image for geometric transformations...")

    src = cv2.imread(input_filename, cv2.IMREAD_COLOR)
    if src is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}. Ensure Chapter 1 capture was executed.", file=sys.stderr)
        sys.exit(1)

    rows, cols = src.shape[:2]

    # 1. Scaling (Resize by factor of 0.5)
    resized = cv2.resize(src, (0, 0), fx=0.5, fy=0.5, interpolation=cv2.INTER_LINEAR)
    cv2.imwrite("output_resized.png", resized)

    # 2. Translation (Shift by dx = 50, dy = 30 pixels)
    trans_mat = np.float32([[1, 0, 50], [0, 1, 30]])
    translated = cv2.warpAffine(src, trans_mat, (cols, rows))
    cv2.imwrite("output_translated.png", translated)

    # 3. Affine Rotation (Rotate 45 degrees around center)
    center = (cols / 2.0, rows / 2.0)
    rot_mat = cv2.getRotationMatrix2D(center, 45.0, 1.0)
    rotated = cv2.warpAffine(src, rot_mat, (cols, rows))
    cv2.imwrite("output_rotated.png", rotated)

    print(f"[{ex_prefix}] ✅ Geometric transformations completed successfully (Resize, Translate, Rotate).")

if __name__ == "__main__":
    main()
