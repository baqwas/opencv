#!/usr/bin/env python3
"""
@file ex05_flann_matching_test.py
@brief Exercise 03: FLANN-Based High-Dimensional Descriptor Matching (cv2.FlannBasedMatcher)

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
Demonstrates high-speed approximate nearest neighbor descriptor matching using the Fast Library
for Approximate Nearest Neighbors (FLANN).
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 05 - FLANN Matching"
    input_filename = "output_live_snap.png"

    print(f"[{ex_prefix}] ⚡ Loading source image for FLANN approximate matching...")

    # 1. Load source image[cite: 14]
    img1 = cv2.imread(input_filename, cv2.IMREAD_GRAYSCALE)
    if img1 is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}.", file=sys.stderr)
        sys.exit(1)

    # 2. Create rotated variant[cite: 14]
    center = (img1.shape[1] / 2.0, img1.shape[0] / 2.0)
    rot_mat = cv2.getRotationMatrix2D(center, 5.0, 1.0)
    img2 = cv2.warpAffine(img1, rot_mat, (img1.shape[1], img1.shape[0]))

    # 3. Extract ORB keypoints and descriptors[cite: 14]
    orb = cv2.ORB_create(500)
    kp1, desc1 = orb.detectAndCompute(img1, None)
    kp2, desc2 = orb.detectAndCompute(img2, None)

    # 4. Convert descriptors to CV_32F for FLANN compatibility[cite: 14]
    desc1 = np.float32(desc1)
    desc2 = np.float32(desc2)

    matcher = cv2.FlannBasedMatcher()
    matches = matcher.match(desc1, desc2)

    # 5. Sort and filter top matches[cite: 14]
    matches = sorted(matches, key=lambda x: x.distance)
    if len(matches) > 40:
        matches = matches[:40]

    # 6. Render and serialize output[cite: 14]
    img_matches = cv2.drawMatches(img1, kp1, img2, kp2, matches, None, flags=cv2.DrawMatchesFlags_NOT_DRAW_SINGLE_POINTS)

    output_filename = "output_flann_matches.png"
    if not cv2.imwrite(output_filename, img_matches):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to serialize output image.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ FLANN approximate matching completed. Output saved to {output_filename}.")

if __name__ == "__main__":
    main()
