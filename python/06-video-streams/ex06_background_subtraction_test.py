#!/usr/bin/env python3
"""
@file ex06_background_subtraction_test.py
@brief Exercise 02: Foreground Object Isolation via Background Subtraction (cv2.createBackgroundSubtractorMOG2)

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
Demonstrates detecting moving foreground objects in video streams using Gaussian Mixture
Model (MOG2) background subtraction algorithms[cite: 17].
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 06 - Background Subtraction"
    input_filename = "output_captured_frame.png"

    print(f"[{ex_prefix}] 🎭 Initializing MOG2 background subtractor...")

    # 1. Load source frame[cite: 17]
    frame = cv2.imread(input_filename, cv2.IMREAD_COLOR)
    if frame is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}.", file=sys.stderr)
        sys.exit(1)

    # 2. Instantiate MOG2 background subtractor[cite: 17]
    p_mog2 = cv2.createBackgroundSubtractorMOG2()
    fg_mask = None

    # 3. Simulate multi-frame ingestion to train background model[cite: 17]
    for i in range(15):
        fg_mask = p_mog2.apply(frame)

    # 4. Serialize foreground mask[cite: 17]
    output_filename = "output_fg_mask.png"
    if not cv2.imwrite(output_filename, fg_mask):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to serialize foreground mask.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Background subtraction mask generated successfully. Output saved to {output_filename}.")

if __name__ == "__main__":
    main()
