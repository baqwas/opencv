#!/usr/bin/env python3
"""
@file ex06_video_capture_test.py
@brief Exercise 01: Real-Time Video Stream Ingestion and Frame Capture (cv2.VideoCapture)

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
Demonstrates initializing a video capture session from a camera device or media file stream,
querying stream properties, and reading individual frames sequentially[cite: 19].
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 06 - Video Capture"

    print(f"[{ex_prefix}] 🎥 Initializing video capture device stream...")

    # 1. Open default video capture device (or video file path)[cite: 19]
    cap = cv2.VideoCapture(0)
    if not cap.isOpened():
        print(f"[{ex_prefix}] ⚠️ Live camera not detected. Attempting to open test video stream...")
        cap.open("output_test_stream.mp4")
        if not cap.isOpened():
            print(f"[{ex_prefix}] ❌ ERROR: Could not open video capture device or file stream.", file=sys.stderr)
            sys.exit(1)

    # 2. Query stream properties[cite: 19]
    width = cap.get(cv2.CAP_PROP_FRAME_WIDTH)
    height = cap.get(cv2.CAP_PROP_FRAME_HEIGHT)
    fps = cap.get(cv2.CAP_PROP_FPS)

    print(f"[{ex_prefix}] 📊 Stream Properties -> Resolution: {int(width)}x{int(height)} | FPS: {fps}")

    # 3. Read sample frame[cite: 19]
    ret, frame = cap.read()
    if not ret or frame is None:
        print(f"[{ex_prefix}] ❌ ERROR: Failed to read initial frame from video stream.", file=sys.stderr)
        cap.release()
        sys.exit(1)

    cap.release()

    # 4. Serialize captured frame to disk[cite: 19]
    output_filename = "output_captured_frame.png"
    if not cv2.imwrite(output_filename, frame):
        print(f"[{ex_prefix}] ❌ ERROR: Failed to serialize captured frame to {output_filename}.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Video capture and frame extraction completed successfully. Output saved to {output_filename}.")

if __name__ == "__main__":
    main()
