#!/usr/bin/env python3
"""
@file ex05_descriptor_matching_test.py
@brief Exercise 02: Brute-Force Descriptor Matching (cv2.BFMatcher)

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
Demonstrates matching binary feature descriptors between two image views (query and train)
using Brute-Force matching with Hamming distance metrics (cv2.BFMatcher).
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 05 - Descriptor Matching"
    input_filename = "output_live_snap.png"

    print(f"[{ex_prefix}] 🔗 Loading source image for Brute-Force descriptor matching...")

    # 1. Load source image[cite: 13]
    img1 = cv2.imread(input_filename, cv2.IMREAD_GRAYSCALE)
    if img1 is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}.", file=sys.stderr)
        sys.exit(1)

    # 2. Create a translated/warped second image to simulate a matching scene[cite: 13]
    trans_mat = np.float32([[1, 0, 20], [0, 1, 15]])
    img2 = cv2.warpAffine(img1, trans_mat, (img1.shape[1], img1.shape[0]))

    # 3. Detect ORB keypoints and compute descriptors[cite: 13]
    orb = cv2.ORB_create(500)
    kp1, desc1 = orb.detectAndCompute(img1, None)
    kp2, desc2 = orb.detectAndCompute(img2, None)

    # 4. Perform Brute-Force matching with Hamming distance[cite: 13]
    matcher = cv2.BFMatcher(cv2.NORM_HAMMING, crossCheck=True)
    matches = matcher.match(desc1, desc2)

    # 5. Sort matches by distance and keep top 50[cite: 13]
    matches = sorted(matches, key=lambda x: x.distance)
    if len(matches) > 50:
        matches = matches[:50]

    # 6. Draw matches and serialize output[cite: 13]
    img_matches = cv2.drawMatches(img1, kp1, img2, kp2, matches, None, flags=cv2.DrawMatchesFlags_NOT_DRAW_SINGLE_POINTS)

    output_filename = "output_bf_matches.png"
    if not cv2.imwrite(output_filename, img_matches):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to serialize output image.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Brute-Force matching completed successfully. Rendered {len(matches)} matches. Output saved to {output_filename}.")

if __name__ == "__main__":
    main()
