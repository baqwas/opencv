#!/usr/bin/env python3
"""
@file ex06_optical_flow_test.py
@brief Exercise 03: Sparse Optical Flow Tracking via Lucas-Kanade (cv2.calcOpticalFlowPyrLK)

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
Demonstrates tracking feature points across successive video frames using pyramidal
Lucas-Kanade sparse optical flow[cite: 18].
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 06 - Optical Flow"
    input_filename = "output_captured_frame.png"

    print(f"[{ex_prefix}] 🌊 Loading frames for Lucas-Kanade optical flow tracking...")

    # 1. Load initial reference frame[cite: 18]
    img1 = cv2.imread(input_filename, cv2.IMREAD_GRAYSCALE)
    if img1 is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}.", file=sys.stderr)
        sys.exit(1)

    # 2. Create a translated second frame[cite: 18]
    trans_mat = np.float32([[1, 0, 5], [0, 1, 3]])
    img2 = cv2.warpAffine(img1, trans_mat, (img1.shape[1], img1.shape[0]))

    # 3. Detect features to track using Shi-Tomasi corner detector[cite: 18]
    p0 = cv2.goodFeaturesToTrack(img1, maxCorners=100, qualityLevel=0.01, minDistance=10, blockSize=3, useHarrisDetector=False, k=0.04)
    if p0 is None:
        p0 = np.empty((0, 1, 2), dtype=np.float32)

    win_size = (21, 21)
    criteria = (cv2.TERM_CRITERIA_COUNT + cv2.TERM_CRITERIA_EPS, 30, 0.01)

    # 4. Calculate optical flow vectors[cite: 18]
    p1, status, err = cv2.calcOpticalFlowPyrLK(img1, img2, p0, None, winSize=win_size, maxLevel=3, criteria=criteria, flags=0, minEigThreshold=1e-4)

    img_display = cv2.cvtColor(img2, cv2.COLOR_GRAY2BGR)

    for i, (new, old) in enumerate(zip(p1, p0)):
        if status[i][0] == 1:
            a, b = new.ravel()
            c, d = old.ravel()
            cv2.line(img_display, (int(a), int(b)), (int(c), int(d)), (0, 0, 255), 2)
            cv2.circle(img_display, (int(a), int(b)), 3, (0, 255, 0), -1)

    # 5. Serialize output[cite: 18]
    output_filename = "output_optical_flow.png"
    if not cv2.imwrite(output_filename, img_display):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to serialize optical flow output.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Optical flow tracking completed. Output saved to {output_filename}.")

if __name__ == "__main__":
    main()
