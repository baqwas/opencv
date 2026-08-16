#!/usr/bin/env python3
"""
@file ex05_keypoints_detection_test.py
@brief Exercise 01: Keypoint Detection and Description via ORB (cv2.ORB, cv2.drawKeypoints)

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
Demonstrates detecting scale- and rotation-invariant local feature points and computing
binary descriptors using the Oriented FAST and Rotated BRIEF (ORB) algorithm.
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 05 - Keypoints Detection"
    input_filename = "output_live_snap.png"

    print(f"[{ex_prefix}] 🌟 Loading source image for ORB keypoint detection...")

    # 1. Load source image in grayscale format[cite: 16]
    src = cv2.imread(input_filename, cv2.IMREAD_GRAYSCALE)
    if src is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}. Ensure preceding image capture was executed.", file=sys.stderr)
        sys.exit(1)

    # 2. Initialize ORB detector[cite: 16]
    orb = cv2.ORB_create(1000)

    # 3. Detect keypoints and compute descriptors[cite: 16]
    keypoints, descriptors = orb.detectAndCompute(src, None)

    # 4. Render keypoints with orientation markers[cite: 16]
    output_img = cv2.drawKeypoints(src, keypoints, None, color=(0, 255, 0), flags=cv2.DrawMatchesFlags_DRAW_RICH_KEYPOINTS)

    # 5. Serialize output to disk[cite: 16]
    output_filename = "output_keypoints.png"
    if not cv2.imwrite(output_filename, output_img):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to serialize output image to {output_filename}.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Keypoint detection completed successfully. Detected {len(keypoints)} keypoints. Output saved to {output_filename}.")

if __name__ == "__main__":
    main()
