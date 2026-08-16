#!/usr/bin/env python3
"""
@file ex03_perspective_transform_test.py
@brief Exercise 02: Perspective Transformation and Homography (cv2.getPerspectiveTransform, cv2.warpPerspective)

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
Demonstrates projecting an image plane from one perspective to another via a 3x3
homography transformation matrix. Essential for document de-skewing, bird's-eye view
orthorectification, and plane-to-plane computer vision alignment pipelines.
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 03 - Perspective Transform"
    input_filename = "output_live_snap.png"

    print(f"[{ex_prefix}] 🌐 Loading source image for perspective homography warp...")

    # 1. Load source image matrix
    src = cv2.imread(input_filename, cv2.IMREAD_COLOR)
    if src is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}. Ensure preceding image capture was executed.", file=sys.stderr)
        sys.exit(1)

    rows, cols = src.shape[:2]
    width = float(cols)
    height = float(rows)

    # 2. Define 4 source quadrilateral corner points (simulating an angled / skewed plane)
    src_pts = np.float32([
        [width * 0.15, height * 0.20],  # Top-left
        [width * 0.85, height * 0.10],  # Top-right
        [width * 0.95, height * 0.90],  # Bottom-right
        [width * 0.05, height * 0.80]   # Bottom-left
    ])

    # Define 4 destination rectangle coordinates (rectified orthorectified view)
    dst_pts = np.float32([
        [0.0, 0.0],
        [width, 0.0],
        [width, height],
        [0.0, height]
    ])

    # 3. Calculate 3x3 perspective transformation (homography) matrix
    perspective_mat = cv2.getPerspectiveTransform(src_pts, dst_pts)

    # 4. Apply perspective transformation warp
    dst = cv2.warpPerspective(src, perspective_mat, (cols, rows))

    # 5. Serialize transformed matrix to disk
    output_filename = "output_perspective_warp.png"
    if not cv2.imwrite(output_filename, dst):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to serialize output image to {output_filename}.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Perspective homography warp completed successfully. Output saved to {output_filename}.")

if __name__ == "__main__":
    main()
