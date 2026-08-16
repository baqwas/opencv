#!/usr/bin/env python3
"""
@file ex03_polar_cartesian_test.py
@brief Exercise 03: Polar and Log-Polar Coordinate Mappings (cv2.linearPolar, cv2.logPolar)

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
Demonstrates transforming an image from Cartesian coordinates to polar and log-polar
coordinate systems. This transformation maps concentric circles into horizontal lines
and rays from the center into vertical lines, enabling rotation- and scale-invariant
template matching and radial visual feature analysis.
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 03 - Polar Cartesian"
    input_filename = "output_live_snap.png"

    print(f"[{ex_prefix}] 🌀 Loading source image for polar coordinate transformations...")

    # 1. Load source image matrix
    src = cv2.imread(input_filename, cv2.IMREAD_COLOR)
    if src is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}. Ensure preceding image capture was executed.", file=sys.stderr)
        sys.exit(1)

    rows, cols = src.shape[:2]
    center = (float(cols) / 2.0, float(rows) / 2.0)
    max_radius = min(center[0], center[1])

    # 3. Apply Linear Polar Transformation
    linear_polar_dst = cv2.linearPolar(
        src, center, max_radius, cv2.INTER_LINEAR | cv2.WARP_FILL_OUTLIERS
    )

    # 4. Apply Log-Polar Transformation
    log_polar_dst = cv2.logPolar(
        src, center, max_radius, cv2.INTER_LINEAR | cv2.WARP_FILL_OUTLIERS
    )

    # 5. Serialize transformed matrices to disk
    lin_output = "output_linear_polar.png"
    log_output = "output_log_polar.png"

    if not cv2.imwrite(lin_output, linear_polar_dst):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to serialize linear polar output to {lin_output}.", file=sys.stderr)
        sys.exit(1)

    if not cv2.imwrite(log_output, log_polar_dst):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to serialize log-polar output to {log_output}.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Polar and log-polar transformations completed successfully. Outputs saved to {lin_output} and {log_output}.")

if __name__ == "__main__":
    main()
