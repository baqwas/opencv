/**
 * @file ex05_keypoints_detection_test.cpp
 * @brief Exercise 01: Keypoint Detection and Description via ORB (`cv::ORB`, `cv::drawKeypoints`)
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
 * Demonstrates detecting scale- and rotation-invariant local feature points and computing
 * binary descriptors using the Oriented FAST and Rotated BRIEF (ORB) algorithm across cluster nodes.
 *
 * @par Update History
 * - v1.0.0 (2026-08-15): Initial implementation for Chapter 05 feature matching.
 *
 * @par Prerequisites
 * - Target Cluster Node (`raspbari13`, `raspbari42`, `raspbari44`)
 * - OpenCV 5.1.0 SDK configured via CMake & Ninja
 * - Input asset `output_live_snap.png`
 *
 * @par User Interface Guide
 * - Headless command-line utility designed for automated remote execution.
 * - Standard output (`std::cout`) logs status prefixed with `[Ex 05 - Keypoints Detection]`.
 * - Generates persistent disk artifact: `output_keypoints.png`.
 *
 * @par Error Message Responses
 * - Missing Input Asset: Logs an error message if `output_live_snap.png` cannot be loaded, returning `EXIT_FAILURE`.
 *
 * @par Processing Workflow and Algorithms
 * 1. Load `output_live_snap.png` into grayscale format.
 * 2. Instantiate `cv::ORB` detector.
 * 3. Detect keypoints and compute binary descriptors via `detectAndCompute`.
 * 4. Render keypoints with orientation markers using `cv::drawKeypoints`.
 * 5. Serialize output to `output_keypoints.png`.
 */

#include <opencv2/opencv.hpp>
#include <opencv2/features2d.hpp>
#include <iostream>
#include <string>
#include <cstdlib>
#include <vector>

int main() {
    const std::string ex_prefix = "Ex 05 - Keypoints Detection";
    const std::string input_filename = "output_live_snap.png";

    std::cout << "[" << ex_prefix << "] 🌟 Loading source image for ORB keypoint detection...\n";

    cv::Mat src = cv::imread(input_filename, cv::IMREAD_GRAYSCALE);
    if (src.empty()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not load " << input_filename
                  << ". Ensure preceding image capture was executed.\n";
        return EXIT_FAILURE;
    }

    // Initialize ORB detector
    Ptr<cv::ORB> orb = cv::ORB::create(1000);
    std::vector<cv::KeyPoint> keypoints;
    cv::Mat descriptors;

    // Detect keypoints and compute descriptors
    orb->detectAndCompute(src, cv::noArray(), keypoints, descriptors);

    cv::Mat output_img;
    cv::drawKeypoints(src, keypoints, output_img, cv::Scalar::all(-1), cv::DrawMatchesFlags::DRAW_RICH_KEYPOINTS);

    const std::string output_filename = "output_keypoints.png";
    if (!cv::imwrite(output_filename, output_img)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to serialize output image to " << output_filename << ".\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Keypoint detection completed successfully. Detected "
              << keypoints.size() << " keypoints. Output saved to " << output_filename << ".\n";
    return EXIT_SUCCESS;
}
