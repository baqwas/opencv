#!/usr/bin/env python3
"""
@file ex03_remap_lens_test.py
@brief Exercise 04: Lens Distortion and Spatial Remapping (cv2.remap)

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
Demonstrates custom pixel remapping using cv2.remap to simulate optical lens distortion
(barrel/pincushion effects) via explicit coordinate lookup tables.
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 03 - Remap Lens"
    input_filename = "output_live_snap.png"

    print(f"[{ex_prefix}] 📷 Loading source image for lens distortion remapping...")

    # 1. Load source image matrix
    src = cv2.imread(input_filename, cv2.IMREAD_COLOR)
    if src is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}. Ensure preceding image capture was executed.", file=sys.stderr)
        sys.exit(1)

    rows, cols = src.shape[:2]

    # 2. Initialize coordinate mapping matrices
    map_x = np.zeros((rows, cols), dtype=np.float32)
    map_y = np.zeros((rows, cols), dtype=np.float32)

    cx = float(cols) / 2.0
    cy = float(rows) / 2.0

    # 3. Generate barrel distortion coordinate lookup tables
    for y in range(rows):
        for x in range(cols):
            dx = (float(x) - cx) / cx
            dy = (float(y) - cy) / cy
            r = np.sqrt(dx * dx + dy * dy)

            if r < 1.5:
                factor = 1.0 + 0.2 * (r ** 2)
                map_x[y, x] = cx + dx * cx * factor
                map_y[y, x] = cy + dy * cy * factor
            else:
                map_x[y, x] = float(x)
                map_y[y, x] = float(y)

    # 4. Apply remapping
    dst = cv2.remap(src, map_x, map_y, cv2.INTER_LINEAR, borderMode=cv2.BORDER_CONSTANT)

    # 5. Serialize transformed matrix to disk
    output_filename = "output_remap_lens.png"
    if not cv2.imwrite(output_filename, dst):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to serialize output image to {output_filename}.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Lens distortion remapping completed successfully. Output saved to {output_filename}.")

if __name__ == "__main__":
    main()
