#!/usr/bin/env python3
"""
@file ex06_video_writer_test.py
@brief Exercise 04: Video Stream Serialization and Encoding (cv2.VideoWriter)

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
Demonstrates creating and writing encoded video stream files from frame sequences
using cv2.VideoWriter[cite: 20].
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 06 - Video Writer"
    input_filename = "output_captured_frame.png"

    print(f"[{ex_prefix}] 💾 Initializing video writer stream...")

    # 1. Load source image frame[cite: 20]
    frame = cv2.imread(input_filename, cv2.IMREAD_COLOR)
    if frame is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}.", file=sys.stderr)
        sys.exit(1)

    output_filename = "output_video_stream.mp4"
    codec = cv2.VideoWriter_fourcc(*'mp4v')
    fps = 25.0
    frame_size = (frame.shape[1], frame.shape[0])

    # 2. Instantiate cv2.VideoWriter with codec, frame rate, and dimensions[cite: 20]
    writer = cv2.VideoWriter(output_filename, codec, fps, frame_size, True)
    if not writer.isOpened():
        print(f"[{ex_prefix}] ❌ ERROR: Could not open video writer for {output_filename}.", file=sys.stderr)
        sys.exit(1)

    # 3. Write sequence of frames[cite: 20]
    for i in range(30):
        writer.write(frame)

    # 4. Release writer[cite: 20]
    writer.release()

    print(f"[{ex_prefix}] ✅ Video stream encoding and serialization completed successfully. Output saved to {output_filename}.")

if __name__ == "__main__":
    main()
