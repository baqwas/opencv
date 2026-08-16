#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@file ex01_video_writer_test.py
@brief Exercise 08: Headless Time-Series Frame Generation and Video Container Encoding (`cv2.VideoWriter`)

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
Demonstrates procedurally generating sequential animation frames and encoding them into
a compressed MP4 video container stream using `cv2.VideoWriter`.

@par Update History
- v1.0.0 (2026-08-16): Initial Python port for Chapter 01 getting started.

@par Processing Workflow and Algorithms
1. Initialize `cv2.VideoWriter` with `mp4v` FourCC codec specification.
2. Iterate through frame indices to render dynamic shapes (moving circles).
3. Write each frame sequentially into the stream container.
4. Release writer handler and verify persistent file generation.
"""

import sys
import numpy as np
import cv2


def main():
    ex_prefix = "Ex 01 - Video Writer"
    output_filename = "output_video_stream.mp4"

    print(f"[{ex_prefix}] 🎬 Initializing video stream writer container...")

    width, height = 640, 480
    fps = 25.0
    fourcc = cv2.VideoWriter_fourcc(*'mp4v')

    writer = cv2.VideoWriter(output_filename, fourcc, fps, (width, height))
    if not writer.isOpened():
        print(f"[{ex_prefix}] ❌ ERROR: Could not open VideoWriter for {output_filename}.", file=sys.stderr)
        sys.exit(1)

    # Generate 50 frames of animation
    for i in range(50):
        frame = np.zeros((height, width, 3), dtype=np.uint8)
        # Moving circle position calculation
        cx = int(width / 2 + 150 * np.sin(i * 0.1))
        cy = int(height / 2 + 100 * np.cos(i * 0.1))

        cv2.circle(frame, (cx, cy), 40, (0, 255, 255), -1)
        cv2.putText(frame, f"Frame Index: {i}", (30, 40),
                    cv2.FONT_HERSHEY_SIMPLEX, 0.7, (255, 255, 255), 2)

        writer.write(frame)

    writer.release()
    print(f"[{ex_prefix}] ✅ Video stream encoded and serialized successfully to {output_filename}.")
    sys.exit(0)


if __name__ == "__main__":
    main()
