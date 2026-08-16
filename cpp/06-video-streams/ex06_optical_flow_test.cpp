/**
 * @file ex06_optical_flow_test.cpp
 * @brief Exercise 03: Sparse Optical Flow Tracking via Lucas-Kanade (`cv::calcOpticalFlowPyrLK`)
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
 * Demonstrates tracking feature points across successive video frames using pyramidal
 * Lucas-Kanade sparse optical flow (`cv::calcOpticalFlowPyrLK`).
 *
 * @par Update History
 * - v1.0.0 (2026-08-15): Initial implementation for Chapter 06 video streams.
 *
 * @par Processing Workflow and Algorithms
 * 1. Load initial reference frame and generate a slightly transformed subsequent frame.
 * 2. Detect good features to track using Shi-Tomasi corner detector (`cv::goodFeaturesToTrack`).
 * 3. Calculate optical flow vectors to track points in the next frame via `cv::calcOpticalFlowPyrLK`.
 * 4. Render motion vectors and serialize to `output_optical_flow.png`.
 */

#include <opencv2/opencv.hpp>
#include <opencv2/video/tracking.hpp>
#include <iostream>
#include <string>
#include <cstdlib>
#include <vector>

int main() {
    const std::string ex_prefix = "Ex 06 - Optical Flow";
    const std::string input_filename = "output_captured_frame.png";

    std::cout << "[" << ex_prefix << "] 🌊 Loading frames for Lucas-Kanade optical flow tracking...\n";

    cv::Mat img1 = cv::imread(input_filename, cv::IMREAD_GRAYSCALE);
    if (img1.empty()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not load " << input_filename << ".\n";
        return EXIT_FAILURE;
    }

    // Create a translated second frame
    cv::Mat trans_mat = (cv::Mat_<double>(2,3) << 1, 0, 5, 0, 1, 3);
    cv::Mat img2;
    cv::warpAffine(img1, img2, trans_mat, img1.size());

    std::vector<cv::Point2f> p0, p1;
    cv::goodFeaturesToTrack(img1, p0, 100, 0.01, 10, cv::Mat(), 3, false, 0.04);

    std::vector<uchar> status;
    std::vector<float> err;
    cv::Size win_size(21, 21);
    cv::TermCriteria criteria(cv::TermCriteria::COUNT + cv::TermCriteria::EPS, 30, 0.01);

    // Calculate optical flow
    cv::calcOpticalFlowPyrLK(img1, img2, p0, p1, status, err, win_size, 3, criteria, 0, 1e-4);

    cv::Mat img_display;
    cv::cvtColor(img2, img_display, cv::COLOR_GRAY2BGR);

    for (size_t i = 0; i < p0.size(); i++) {
        if (status[i]) {
            cv::line(img_display, p0[i], p1[i], cv::Scalar(0, 0, 255), 2);
            cv::circle(img_display, p1[i], 3, cv::Scalar(0, 255, 0), -1);
        }
    }

    const std::string output_filename = "output_optical_flow.png";
    if (!cv::imwrite(output_filename, img_display)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to serialize optical flow output.\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Optical flow tracking completed. Output saved to " << output_filename << ".\n";
    return EXIT_SUCCESS;
}
