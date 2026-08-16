#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@file ex01_split_merge_test.py
@brief Exercise 05: Multi-Channel Matrix Decomposition and Synthesis (`cv2.split`, `cv2.merge`)

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
Shows how to split a multi-channel BGR color matrix into single-channel components,
manipulate individual channels, and merge them back into a composite frame.

@par Update History
- v1.0.0 (2026-08-16): Initial Python port for Chapter 01 getting started.

@par Processing Workflow and Algorithms
1. Load source image frame.
2. Decompose into Blue, Green, and Red channels via `cv2.split()`.
3. Modify one channel (e.g., zero out the Blue channel).
4. Recombine channels via `cv2.merge()` and write output to disk.
"""

import sys
import os
import numpy as np
import cv2

def main():
    ex_prefix = "Ex 01 - Split & Merge"
    input_filename = "output_canvas.png"

    print(f"[{ex_prefix}] 🔀 Decomposing multi-channel frame buffer...")

    if not os.path.exists(input_filename):
        dummy = cv2.rectangle(np.zeros((100, 100, 3), dtype=np.uint8), (10, 10), (90, 90), (0, 255, 255), -1)
        cv2.imwrite(input_filename, dummy)

    src = cv2.imread(input_filename, cv2.IMREAD_COLOR)
    if src is None:
        print(f"[{ex_prefix}] ❌ ERROR: Failed to load source asset.", file=sys.stderr)
        sys.exit(1)

    # Split channels
    b, g, r = cv2.split(src)

    # Zero out the blue channel for color filtering effect
    b = np.zeros_like(b)

    # Merge channels back
    merged = cv2.merge([b, g, r])

    output_filename = "output_split_merge.png"
    if not cv2.imwrite(output_filename, merged):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to write merged frame output.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Channel decomposition and synthesis complete. Saved to {output_filename}.")
    sys.exit(0)

if __name__ == "__main__":
    main()
