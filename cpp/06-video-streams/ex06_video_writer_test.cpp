/**
 * @file ex06_video_writer_test.cpp
 * @brief Exercise 04: Video Stream Serialization and Encoding (`cv::VideoWriter`)
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
 * Demonstrates creating and writing encoded video stream files from frame sequences
 * using `cv::VideoWriter`.
 *
 * @par Update History
 * - v1.0.0 (2026-08-15): Initial implementation for Chapter 06 video streams.
 *
 * @par Processing Workflow and Algorithms
 * 1. Load source image frame.
 * 2. Instantiate `cv::VideoWriter` with FourCC codec (`mp4v`), frame rate, and dimensions.
 * 3. Write sequence frames iteratively into the video container.
 * 4. Release writer and verify persistent file generation (`output_video_stream.mp4`).
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>

int main() {
    const std::string ex_prefix = "Ex 06 - Video Writer";
    const std::string input_filename = "output_captured_frame.png";

    std::cout << "[" << ex_prefix << "] 💾 Initializing video writer stream...\n";

    cv::Mat frame = cv::imread(input_filename, cv::IMREAD_COLOR);
    if (frame.empty()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not load " << input_filename << ".\n";
        return EXIT_FAILURE;
    }

    const std::string output_filename = "output_video_stream.mp4";
    int codec = cv::VideoWriter::fourcc('m', 'p', '4', 'v');
    double fps = 25.0;
    cv::Size frame_size(frame.cols, frame.rows);

    cv::VideoWriter writer(output_filename, codec, fps, frame_size, true);
    if (!writer.isOpened()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not open video writer for " << output_filename << ".\n";
        return EXIT_FAILURE;
    }

    // Write sequence of frames
    for (int i = 0; i < 30; ++i) {
        writer.write(frame);
    }

    writer.release();

    std::cout << "[" << ex_prefix << "] ✅ Video stream encoding and serialization completed successfully. Output saved to "
              << output_filename << ".\n";
    return EXIT_SUCCESS;
}
