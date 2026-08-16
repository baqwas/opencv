#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
@file ex01_camera_stream_test.py
@brief Exercise 10: Real-Time Stream Ingestion and Serialized Output Pipeline (`cv2.VideoCapture` + `cv2.VideoWriter`)

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
Demonstrates establishing an automated loop to ingest multiple sequential frames from a live
video stream and write them out directly into a persistent video file container.

@par Update History
- v1.0.0 (2026-08-16): Initial Python port for Chapter 01 getting started.

@par Processing Workflow and Algorithms
1. Initialize `cv2.VideoCapture` and query stream resolution parameters.
2. Setup `cv2.VideoWriter` matching target frame dimensions.
3. Process a bounded batch of sequential frames in an execution loop.
4. Release device handlers and close file streams cleanly.
"""

import sys
import numpy as np
import cv2


def main():
    ex_prefix = "Ex 01 - Camera Stream"
    output_filename = "output_live_stream_record.mp4"

    print(f"[{ex_prefix}] 📹 Initializing live stream record pipeline...")

    cap = cv2.VideoCapture(0)
    use_live_camera = cap.isOpened()

    width, height, fps = 640, 480, 25.0
    if use_live_camera:
        width = int(cap.get(cv2.CAP_PROP_FRAME_WIDTH) or 640)
        height = int(cap.get(cv2.CAP_PROP_FRAME_HEIGHT) or 480)

    fourcc = cv2.VideoWriter_fourcc(*'mp4v')
    writer = cv2.VideoWriter(output_filename, fourcc, fps, (width, height))

    if not writer.isOpened():
        print(f"[{ex_prefix}] ❌ ERROR: Could not open VideoWriter target {output_filename}.", file=sys.stderr)
        if use_live_camera:
            cap.release()
        sys.exit(1)

    print(f"[{ex_prefix}] 🔄 Recording stream sequence (30 frames)...")
    for i in range(30):
        if use_live_camera:
            ret, frame = cap.read()
            if not ret or frame is None:
                break
        else:
            # Fallback synthetic frame sequence for headless testing
            frame = np.full((height, width, 3), (30, 30, 30), dtype=np.uint8)
            cv2.putText(frame, f"Simulated Live Frame {i}", (50, 240),
                        cv2.FONT_HERSHEY_SIMPLEX, 0.7, (0, 255, 0), 2)

        writer.write(frame)

    if use_live_camera:
        cap.release()
    writer.release()

    print(f"[{ex_prefix}] ✅ Camera stream recording completed successfully. Saved to {output_filename}.")
    sys.exit(0)


if __name__ == "__main__":
    main()
