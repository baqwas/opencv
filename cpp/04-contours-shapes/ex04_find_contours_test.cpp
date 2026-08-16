/**
 * @file ex04_find_contours_test.cpp
 * @brief Exercise 01: Binary Thresholding and Contour Extraction (`cv::findContours`, `cv::drawContours`)
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
 * Demonstrates basic contour retrieval from a binary image matrix, allowing identification
 * and visualization of object boundaries in computer vision pipelines.
 *
 * @par Update History
 * - v1.0.0 (2026-08-15): Initial implementation for Chapter 04 contours and shapes.
 *
 * @par Prerequisites
 * - Target Cluster Node (`raspbari13`, `raspbari42`, `raspbari44`)
 * - OpenCV 5.1.0 SDK configured via CMake & Ninja
 * - Input asset `output_live_snap.png`
 *
 * @par User Interface Guide
 * - Headless command-line utility.
 * - Standard output (`std::cout`) logs status prefixed with `[Ex 04 - Find Contours]`.
 * - Generates persistent disk artifact: `output_contours.png`.
 *
 * @par Error Message Responses
 * - Missing Input Asset: Logs an error message if `output_live_snap.png` cannot be loaded, returning `EXIT_FAILURE`.
 *
 * @par Processing Workflow and Algorithms
 * 1. Load `output_live_snap.png` in grayscale format.
 * 2. Apply binary thresholding to create a segmentation mask.
 * 3. Execute `cv::findContours` using `cv::RETR_EXTERNAL` and `cv::CHAIN_APPROX_SIMPLE`.
 * 4. Render extracted contours onto an RGB canvas via `cv::drawContours`.
 * 5. Serialize output to `output_contours.png`.
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>
#include <vector>

int main() {
    const std::string ex_prefix = "Ex 04 - Find Contours";
    const std::string input_filename = "output_live_snap.png";

    std::cout << "[" << ex_prefix << "] 🧬 Loading source image for contour extraction...\n";

    cv::Mat src = cv::imread(input_filename, cv::IMREAD_GRAYSCALE);
    if (src.empty()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not load " << input_filename
                  << ". Ensure preceding image capture was executed.\n";
        return EXIT_FAILURE;
    }

    cv::Mat bin;
    cv::threshold(src, bin, 100, 255, cv::THRESH_BINARY);

    std::vector<std::vector<cv::Point>> contours;
    std::vector<cv::Vec4i> hierarchy;
    cv::findContours(bin, contours, hierarchy, cv::RETR_EXTERNAL, cv::CHAIN_APPROX_SIMPLE);

    cv::Mat drawing = cv::Mat::zeros(src.size(), CV_8UC3);
    for (size_t i = 0; i < contours.size(); i++) {
        cv::Scalar color = cv::Scalar(0, 255, 0);
        cv::drawContours(drawing, contours, static_cast<int>(i), color, 2, cv::LINE_8, hierarchy, 0);
    }

    const std::string output_filename = "output_contours.png";
    if (!cv::imwrite(output_filename, drawing)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to serialize output image to " << output_filename << ".\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Contour extraction completed successfully. Found "
              << contours.size() << " contours. Output saved to " << output_filename << ".\n";
    return EXIT_SUCCESS;
}
