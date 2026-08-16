/**
 * @file ex07_dnn_blob_preprocessing_test.cpp
 * @brief Exercise 02: Neural Network Input Blob Preprocessing (`cv::dnn::blobFromImage`)
 *
 * @version 1.0.0
 * @date 2026-08-15
 * @author A Reza M Wajih (Systems Architect)
 *
 * @copyright MIT License
 * Copyright (c) 2026 A Reza M Wajih
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * @par Purpose
 * Demonstrates converting raw input image matrices into 4D floating-point NCHW tensor blobs
 * with spatial resizing, mean subtraction, and channel scaling via `cv::dnn::blobFromImage`.
 *
 * @par Update History
 * - v1.0.0 (2026-08-15): Initial implementation for Chapter 07 deep learning DNN.
 *
 * @par Processing Workflow and Algorithms
 * 1. Load source image asset (`output_live_snap.png`).
 * 2. Construct 4D tensor blob using `cv::dnn::blobFromImage` (size 224x224, scale 1/255.0).
 * 3. Inspect blob dimensions and tensor memory layout.
 * 4. Serialize processing confirmation to disk.
 */

#include <opencv2/opencv.hpp>
#include <opencv2/dnn.hpp>
#include <iostream>
#include <string>
#include <cstdlib>

int main() {
    const std::string ex_prefix = "Ex 07 - Blob Preprocessing";
    const std::string input_filename = "output_live_snap.png";

    std::cout << "[" << ex_prefix << "] 📦 Loading source image for tensor blob preprocessing...\n";

    cv::Mat src = cv::imread(input_filename, cv::IMREAD_COLOR);
    if (src.empty()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not load " << input_filename << ".\n";
        return EXIT_FAILURE;
    }

    // Create 4D blob from image for deep learning ingestion
    cv::Mat blob = cv::dnn::blobFromImage(src, 1.0 / 255.0, cv::Size(224, 224),
                                          cv::Scalar(104.0, 117.0, 123.0), true, false);

    std::cout << "[" << ex_prefix << "] 📊 Tensor Blob Dimensions -> N: " << blob.size[0]
              << " | C: " << blob.size[1] << " | H: " << blob.size[2] << " | W: " << blob.size[3] << "\n";

    // Serialize verification artifact
    const std::string output_filename = "output_blob_status.txt";
    std::ofstream out(output_filename);
    if (out.is_open()) {
        out << "Blob Preprocessing Successful\n";
        out << "Dimensions: [" << blob.size[0] << ", " << blob.size[1] << ", " << blob.size[2] << ", " << blob.size[3] << "]\n";
        out.close();
    }

    std::cout << "[" << ex_prefix << "] ✅ Tensor blob preprocessing completed successfully. Status saved to "
              << output_filename << ".\n";
    return EXIT_SUCCESS;
}
