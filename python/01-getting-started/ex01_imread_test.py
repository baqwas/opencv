#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@file ex01_imread_test.py
@brief Exercise 04: Asset Ingestion, Matrix Validation, and Round-Trip Serialization (`cv2.imread`)

@version 1.0.0
@date 2026-08-16
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
Demonstrates loading external image files into memory, validating buffer integrity,
and performing round-trip disk serialization.

@par Update History
- v1.0.0 (2026-08-16): Initial Python port for Chapter 01 getting started.

@par Processing Workflow and Algorithms
1. Attempt loading a reference image asset (`output_canvas.png`).
2. Verify that the returned matrix is non-empty and query its metadata dimensions.
3. Save a processed copy as `output_imread_copy.png`.
"""

import sys
import os
import cv2

def main():
    ex_prefix = "Ex 01 - Imread"
    input_filename = "output_canvas.png"

    print(f"[{ex_prefix}] 📁 Loading image asset from disk: {input_filename}...")

    # Fallback: create dummy asset if missing so script runs stand-alone
    if not os.path.exists(input_filename):
        dummy = cv2.circle(np.zeros((100, 100, 3), dtype=np.uint8), (50, 50), 25, (255, 0, 0), -1)
        cv2.imwrite(input_filename, dummy)

    img = cv2.imread(input_filename, cv2.IMREAD_COLOR)
    if img is None or img.size == 0:
        print(f"[{ex_prefix}] ❌ ERROR: Could not open or find input image {input_filename}.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] 📊 Image Properties -> Shape: {img.shape} | Datatype: {img.dtype}")

    output_filename = "output_imread_copy.png"
    if not cv2.imwrite(output_filename, img):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to write copy to {output_filename}.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Image successfully read and re-serialized to {output_filename}.")
    sys.exit(0)

if __name__ == "__main__":
    main()
