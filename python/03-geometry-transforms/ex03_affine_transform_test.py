#!/usr/bin/env python3
"""
@file ex03_affine_transform_test.py
@brief Exercise 01: Arbitrary 3-Point Affine Warp (cv2.getAffineTransform, cv2.warpAffine)

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
Demonstrates computing an arbitrary 2D affine transformation matrix from three point
coordinate pairs and applying it to warp an image matrix, enabling affine operations
such as scaling, rotation, shearing, and skewing.
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 03 - Affine Transform"
    input_filename = "output_live_snap.png"

    print(f"[{ex_prefix}] 📐 Loading source image for 3-point affine transformation...")

    # 1. Load source image matrix
    src = cv2.imread(input_filename, cv2.IMREAD_COLOR)
    if src is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}. Ensure preceding image capture was executed.", file=sys.stderr)
        sys.exit(1)

    rows, cols = src.shape[:2]

    # 2. Define 3 source triangle point coordinates
    src_pts = np.float32([
        [0.0, 0.0],
        [float(cols - 1), 0.0],
        [0.0, float(rows - 1)]
    ])

    # Define 3 destination triangle point coordinates with structural skew
    dst_pts = np.float32([
        [float(cols) * 0.0, float(rows) * 0.33],
        [float(cols) * 0.85, float(rows) * 0.25],
        [float(cols) * 0.15, float(rows) * 0.90]
    ])

    # 3. Calculate 2x3 affine transformation matrix
    warp_mat = cv2.getAffineTransform(src_pts, dst_pts)

    # 4. Apply affine transformation warp
    dst = cv2.warpAffine(src, warp_mat, (cols, rows))

    # 5. Serialize transformed matrix to disk
    output_filename = "output_affine_warp.png"
    if not cv2.imwrite(output_filename, dst):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to serialize output image to {output_filename}.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Affine transformation completed successfully. Output saved to {output_filename}.")

if __name__ == "__main__":
    main()
