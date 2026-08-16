/**
 * @file ex06_background_subtraction_test.cpp
 * @brief Exercise 02: Foreground Object Isolation via Background Subtraction (`cv::createBackgroundSubtractorMOG2`)
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
 * Demonstrates detecting moving foreground objects in video streams using Gaussian Mixture
 * Model (MOG2) background subtraction algorithms.
 *
 * @par Update History
 * - v1.0.0 (2026-08-15): Initial implementation for Chapter 06 video streams.
 *
 * @par Processing Workflow and Algorithms
 * 1. Initialize background subtractor model via `cv::createBackgroundSubtractorMOG2`.
 * 2. Process synthetic or captured sequential video frames.
 * 3. Apply background subtraction update to extract the foreground binary mask.
 * 4. Serialize the resulting foreground mask to `output_fg_mask.png`.
 */

#include <opencv2/opencv.hpp>
#include <opencv2/video.hpp>
#include <iostream>
#include <string>
#include <cstdlib>

int main() {
    const std::string ex_prefix = "Ex 06 - Background Subtraction";
    const std::string input_filename = "output_captured_frame.png";

    std::cout << "[" << ex_prefix << "] 🎭 Initializing MOG2 background subtractor...\n";

    cv::Mat frame = cv::imread(input_filename, cv::IMREAD_COLOR);
    if (frame.empty()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not load " << input_filename << ".\n";
        return EXIT_FAILURE;
    }

    // Instantiate MOG2 background subtractor
    Ptr<cv::BackgroundSubtractor> p_mog2 = cv::createBackgroundSubtractorMOG2();
    cv::Mat fg_mask;

    // Simulate multi-frame ingestion to train background model
    for (int i = 0; i < 15; ++i) {
        p_mog2->apply(frame, fg_mask);
    }

    const std::string output_filename = "output_fg_mask.png";
    if (!cv::imwrite(output_filename, fg_mask)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to serialize foreground mask.\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Background subtraction mask generated successfully. Output saved to "
              << output_filename << ".\n";
    return EXIT_SUCCESS;
}
