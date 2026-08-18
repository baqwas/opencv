/**
 * @file ex02_colorspace_test.cpp
 * @brief Exercise 01: Multi-Channel Color Space Transformations (`cv::cvtColor`)
 *
 * @version 1.0.0
 * @date 2026-08-15
 * @author Matha Goram (Systems Architect)
 *
 * @copyright MIT License
 * Copyright (c) 2026 ParkCircus Productions. All Rights Reserved.
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
 * Demonstrates the conversion of a standard BGR image into alternative color spaces
 * (Grayscale, HSV, and LAB) essential for feature extraction, thresholding, and color segmentation[cite: 1].
 *
 * @par Processing Workflow
 * 1. Generate or load a source image matrix[cite: 1].
 * 2. Convert BGR to Grayscale for intensity-based operations[cite: 1].
 * 3. Convert BGR to HSV for robust color-based masking independent of illumination[cite: 1].
 * 4. Convert BGR to LAB for perceptual color uniformity[cite: 1].
 * 5. Serialize all transformed matrices to disk for remote verification[cite: 1].
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>

int main() {
    const std::string ex_prefix = "Ex 02 - ColorSpace";
    const std::string input_filename = "output_live_snap.png"; // Leverages asset from Chapter 1[cite: 1]

    std::cout << "[" << ex_prefix << "] 🎨 Loading source image for color transformation...\n";

    cv::Mat src = cv::imread(input_filename, cv::IMREAD_COLOR);
    if (src.empty()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not load " << input_filename << ". Ensure Chapter 1 capture was executed.\n";
        return EXIT_FAILURE;
    }

    cv::Mat gray, hsv, lab;

    // 1. Grayscale Conversion
    cv::cvtColor(src, gray, cv::COLOR_BGR2GRAY);
    cv::imwrite("output_gray.png", gray);

    // 2. HSV Conversion (Hue, Saturation, Value)
    cv::cvtColor(src, hsv, cv::COLOR_BGR2HSV);
    cv::imwrite("output_hsv.png", hsv);

    // 3. LAB Conversion (CIELAB Uniform Color Space)
    cv::cvtColor(src, lab, cv::COLOR_BGR2Lab);
    cv::imwrite("output_lab.png", lab);

    std::cout << "[" << ex_prefix << "] ✅ Color space transformations completed successfully across Gray, HSV, and LAB channels.\n";
    return EXIT_SUCCESS;
}
