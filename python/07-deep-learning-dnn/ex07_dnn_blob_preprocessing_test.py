#!/usr/bin/env python3
"""
@file ex07_dnn_blob_preprocessing_test.py
@brief Exercise 02: Neural Network Input Blob Preprocessing (cv2.dnn.blobFromImage)

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
Demonstrates converting raw input image matrices into 4D floating-point NCHW tensor blobs
with spatial resizing, mean subtraction, and channel scaling via cv2.dnn.blobFromImage[cite: 21].
"""

import cv2
import numpy as np
import sys

def main():
    ex_prefix = "Ex 07 - Blob Preprocessing"
    input_filename = "output_live_snap.png"

    print(f"[{ex_prefix}] 📦 Loading source image for tensor blob preprocessing...")

    # 1. Load source image asset[cite: 21]
    src = cv2.imread(input_filename, cv2.IMREAD_COLOR)
    if src is None:
        print(f"[{ex_prefix}] ❌ ERROR: Could not load {input_filename}.", file=sys.stderr)
        sys.exit(1)

    # 2. Construct 4D tensor blob using cv2.dnn.blobFromImage[cite: 21]
    blob = cv2.dnn.blobFromImage(src, 1.0 / 255.0, (224, 224),
                                  (104.0, 117.0, 123.0), swapRB=True, crop=False)

    print(f"[{ex_prefix}] 📊 Tensor Blob Dimensions -> N: {blob.shape[0]} | C: {blob.shape[1]} | H: {blob.shape[2]} | W: {blob.shape[3]}")

    # 3. Serialize processing confirmation to disk[cite: 21]
    output_filename = "output_blob_status.txt"
    try:
        with open(output_filename, 'w') as out:
            out.write("Blob Preprocessing Successful\n")
            out.write(f"Dimensions: [{blob.shape[0]}, {blob.shape[1]}, {blob.shape[2]}, {blob.shape[3]}]\n")
    except IOError:
        print(f"[{ex_prefix}] ❌ ERROR: Failed to write status file {output_filename}.", file=sys.stderr)
        sys.exit(1)

    print(f"[{ex_prefix}] ✅ Tensor blob preprocessing completed successfully. Status saved to {output_filename}.")

if __name__ == "__main__":
    main()
