/**
 * @file ex04_contour_properties_test.cpp
 * @brief Exercise 02: Contour Bounding Geometries (`cv::boundingRect`, `cv::minAreaRect`, `cv::minEnclosingCircle`)
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
 * Computes geometric descriptors and spatial bounding containers (rectangles, rotated boxes,
 * and circles) for detected contours.
 *
 * @par Update History
 * - v1.0.0 (2026-08-15): Initial implementation for Chapter 04 contours and shapes.
 *
 * @par Prerequisites
 * - Target Cluster Node (`raspbari13`, `raspbari42`, `raspbari44`)
 * - OpenCV 5.1.0 SDK configured via CMake & Ninja
 * - Input asset `output_live_snap.png`
 *
 * @par Processing Workflow and Algorithms
 * 1. Load source image and binarize.
 * 2. Extract contours via `cv::findContours`.
 * 3. Iterate through contours to compute bounding rects, min area rects, and enclosing circles.
 * 4. Draw bounding primitives and serialize output to `output_contour_properties.png`.
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>
#include <vector>

int main() {
    const std::string ex_prefix = "Ex 04 - Contour Properties";
    const std::string input_filename = "output_live_snap.png";

    std::cout << "[" << ex_prefix << "] 📐 Loading source image for contour property analysis...\n";

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
        if (cv::contourArea(contour) < 500.0) continue; // Filter small noise

        cv::Rect bound_rect = cv::boundingRect(contour);
        cv::rectangle(drawing, bound_rect, cv::Scalar(0, 255, 0), 2);

        cv::RotatedRect min_rect = cv::minAreaRect(contour);
        cv::Point2f rect_points[4];
        min_rect.points(rect_points);
        for (int j = 0; j < 4; j++) {
            cv::line(drawing, rect_points[j], rect_points[(j + 1) % 4], cv::Scalar(255, 0, 0), 2);
        }

        cv::Point2f center;
        float radius = 0;
        cv::minEnclosingCircle(contour, center, radius);
        cv::circle(drawing, center, static_cast<int>(radius), cv::Scalar(0, 0, 255), 2);
    }

    const std::string output_filename = "output_contour_properties.png";
    if (!cv::imwrite(output_filename, drawing)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to serialize output image.\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Contour properties analysis completed. Output saved to " << output_filename << ".\n";
    return EXIT_SUCCESS;
}
