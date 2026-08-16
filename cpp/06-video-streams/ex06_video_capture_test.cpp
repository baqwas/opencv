/**
 * @file ex06_video_capture_test.cpp
 * @brief Exercise 01: Real-Time Video Stream Ingestion and Frame Capture (`cv::VideoCapture`)
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
 * Demonstrates initializing a video capture session from a camera device or media file stream,
 * querying stream properties, and reading individual frames sequentially across cluster nodes.
 *
 * @par Update History
 * - v1.0.0 (2026-08-15): Initial implementation for Chapter 06 video streams.
 *
 * @par Prerequisites
 * - Target Cluster Node (`raspbari13`, `raspbari42`, `raspbari44`)
 * - OpenCV 5.1.0 SDK configured via CMake & Ninja
 * - Access to a V4L2 camera source or valid test video file
 *
 * @par User Interface Guide
 * - Headless command-line utility.
 * - Standard output (`std::cout`) logs status prefixed with `[Ex 06 - Video Capture]`.
 * - Generates persistent disk artifact: `output_captured_frame.png`.
 *
 * @par Error Message Responses
 * - Device Connection Failure: Logs an error message if the video stream cannot be opened, returning `EXIT_FAILURE`.
 * - Frame Retrieval Failure: Logs an error message if reading an active frame fails, returning `EXIT_FAILURE`.
 *
 * @par Processing Workflow and Algorithms
 * 1. Initialize `cv::VideoCapture` with device index 0 or test file path.
 * 2. Query stream metadata (frame width, height, FPS).
 * 3. Read a sample operational frame into a managed `cv::Mat` container.
 * 4. Serialize the captured frame to disk as `output_captured_frame.png`.
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>

int main() {
    const std::string ex_prefix = "Ex 06 - Video Capture";

    std::cout << "[" << ex_prefix << "] 🎥 Initializing video capture device stream...\n";

    // 1. Open default video capture device (or video file path)
    cv::VideoCapture cap(0);
    if (!cap.isOpened()) {
        // Fallback to reading a sample video file if live camera is unavailable in headless cluster mode
        std::cout << "[" << ex_prefix << "] ⚠️ Live camera not detected. Attempting to open test video stream...\n";
        cap.open("output_test_stream.mp4");
        if (!cap.isOpened()) {
            std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not open video capture device or file stream.\n";
            return EXIT_FAILURE;
        }
    }

    // 2. Query stream properties
    double width = cap.get(cv::CAP_PROP_FRAME_WIDTH);
    double height = cap.get(cv::CAP_PROP_FRAME_HEIGHT);
    double fps = cap.get(cv::CAP_PROP_FPS);

    std::cout << "[" << ex_prefix << "] 📊 Stream Properties -> Resolution: "
              << width << "x" << height << " | FPS: " << fps << "\n";

    cv::Mat frame;
    // 3. Read sample frame
    if (!cap.read(frame) || frame.empty()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to read initial frame from video stream.\n";
        return EXIT_FAILURE;
    }

    // 4. Serialize captured frame to disk
    const std::string output_filename = "output_captured_frame.png";
    if (!cv::imwrite(output_filename, frame)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to serialize captured frame to " << output_filename << ".\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Video capture and frame extraction completed successfully. Output saved to "
              << output_filename << ".\n";
    return EXIT_SUCCESS;
}
