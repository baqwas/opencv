/**
 * @file ex04_contour_approximation_test.cpp
 * @brief Exercise 03: Contour Polygonal Approximation (`cv::approxPolyDP`)
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
 * Simplifies complex contours into polygonal curves with fewer vertices using the
 * Douglas-Peucker algorithm (`cv::approxPolyDP`).
 *
 * @par Update History
 * - v1.0.0 (2026-08-15): Initial implementation for Chapter 04 contours and shapes.
 *
 * @par Processing Workflow and Algorithms
 * 1. Load source image and binarize.
 * 2. Extract contours.
 * 3. Apply `cv::approxPolyDP` with epsilon proportional to contour perimeter.
 * 4. Draw approximated polygons and serialize to `output_approx_poly.png`.
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>
#include <vector>

int main() {
    const std::string ex_prefix = "Ex 04 - Contour Approximation";
    const std::string input_filename = "output_live_snap.png";

    std::cout << "[" << ex_prefix << "] 🔷 Loading source image for polygonal contour approximation...\n";

    cv::Mat src = cv::imread(input_filename, cv::IMREAD_COLOR);
    if (src.empty()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not load " << input_filename << ".\n";
        return EXIT_FAILURE;
    }

    cv::Mat gray, bin;
    cv::cvtColor(src, gray, cv::COLOR_BGR2GRAY);
    cv::threshold(gray, bin, 100, 255, cv::THRESH_BINARY);

    std::vector<std::vector<cv::Point>> contours;
    cv::findContours(bin, contours, cv::RETR_EXTERNAL, cv::CHAIN_APPROX_SIMPLE);

    cv::Mat drawing = src.clone();
    for (const auto& contour : contours) {
        if (cv::contourArea(contour) < 500.0) continue;

        std::vector<cv::Point> approx;
        double epsilon = 0.02 * cv::arcLength(contour, true);
        cv::approxPolyDP(contour, approx, epsilon, true);

        cv::polylines(drawing, std::vector<std::vector<cv::Point>>{approx}, true, cv::Scalar(0, 255, 255), 3);
    }

    const std::string output_filename = "output_approx_poly.png";
    if (!cv::imwrite(output_filename, drawing)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to serialize output image.\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Polygonal approximation completed successfully. Output saved to " << output_filename << ".\n";
    return EXIT_SUCCESS;
}
