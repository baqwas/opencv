#!/usr/bin/env python3
"""
@file ex05_homography_matching_test.py
@brief Exercise 04: Object Localization and Homography Estimation via Feature Matches (cv2.findHomography, cv2.RANSAC)

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
Demonstrates localizing an object within a scene by computing a robust homography transformation
matrix using RANSAC outlier rejection on feature point correspondences.
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 05 - Homography Matching"
    input_filename = "output_live_snap.png"

    print(f"[{ex_prefix}] 🗺️ Loading source image for homography object localization...")

    # 1. Load query image object[cite: 15]
    img_object = cv2.imread(input_filename, cv2.IMREAD_GRAYSCALE)
    if img_object is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}.", file=sys.stderr)
        sys.exit(1)

    cols = img_object.shape[1]
    rows = img_object.shape[0]

    # 2. Create scene by warping object image[cite: 15]
    obj_corners = np.array([
        [0, 0],
        [cols, 0],
        [cols, rows],
        [0, rows]
    ], dtype=np.float32)

    scene_corners = np.array([
        [50, 40],
        [cols - 20, 60],
        [cols - 40, rows - 30],
        [30, rows - 10]
    ], dtype=np.float32)

    H_warp = cv2.getPerspectiveTransform(obj_corners, scene_corners)
    img_scene = cv2.warpPerspective(img_object, H_warp, (cols, rows))

    # 3. Extract features using ORB[cite: 15]
    orb = cv2.ORB_create(1000)
    kp_obj, desc_obj = orb.detectAndCompute(img_object, None)
    kp_scene, desc_scene = orb.detectAndCompute(img_scene, None)

    # 4. Match descriptors with KNN and apply Lowe's ratio test[cite: 15]
    matcher = cv2.BFMatcher(cv2.NORM_HAMMING)
    knn_matches = matcher.knnMatch(desc_obj, desc_scene, 2)

    good_matches = []
    for m, n in knn_matches:
        if m.distance < 0.75 * n.distance:
            good_matches.append(m)

    src_pts = np.float32([kp_obj[m.queryIdx].pt for m in good_matches]).reshape(-1, 1, 2)
    dst_pts = np.float32([kp_scene[m.trainIdx].pt for m in good_matches]).reshape(-1, 1, 2)

    # 5. Compute Homography matrix via RANSAC[cite: 15]
    H, _ = cv2.findHomography(src_pts, dst_pts, cv2.RANSAC, 3.0)

    # 6. Project object corners onto scene and render outline[cite: 15]
    transformed_corners = cv2.perspectiveTransform(obj_corners.reshape(-1, 1, 2), H)
    img_result = cv2.cvtColor(img_scene, cv2.COLOR_GRAY2BGR)

    pts = np.int32(transformed_corners)
    for i in range(4):
        pt1 = tuple(pts[i][0])
        pt2 = tuple(pts[(i + 1) % 4][0])
        cv2.line(img_result, pt1, pt2, (0, 255, 0), 4)

    output_filename = "output_homography_localization.png"
    if not cv2.imwrite(output_filename, img_result):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to serialize output image.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Homography object localization completed successfully. Output saved to {output_filename}.")

if __name__ == "__main__":
    main()
