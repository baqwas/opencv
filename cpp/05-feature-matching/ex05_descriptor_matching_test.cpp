/**
 * @file ex05_descriptor_matching_test.cpp
 * @brief Exercise 02: Brute-Force Descriptor Matching (`cv::BFMatcher`)
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
 * Demonstrates matching binary feature descriptors between two image views (query and train)
 * using Brute-Force matching with Hamming distance metrics (`cv::BFMatcher`).
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
 * - Headless command-line utility.
 * - Standard output (`std::cout`) logs status prefixed with `[Ex 05 - Descriptor Matching]`.
 * - Generates persistent disk artifact: `output_bf_matches.png`.
 *
 * @par Error Message Responses
 * - Missing Input Asset: Logs an error message if `output_live_snap.png` cannot be loaded, returning `EXIT_FAILURE`.
 *
 * @par Processing Workflow and Algorithms
 * 1. Load source image and create a transformed (shifted) variant to simulate a matching frame.
 * 2. Extract ORB keypoints and descriptors for both frames.
 * 3. Execute Brute-Force matcher with `NORM_HAMMING`.
 * 4. Filter top matches and render correspondence lines using `cv::drawMatches`.
 * 5. Serialize output to `output_bf_matches.png`.
 */

#include <opencv2/opencv.hpp>
#include <opencv2/features2d.hpp>
#include <iostream>
#include <string>
#include <cstdlib>
#include <vector>

int main() {
    const std::string ex_prefix = "Ex 05 - Descriptor Matching";
    const std::string input_filename = "output_live_snap.png";

    std::cout << "[" << ex_prefix << "] 🔗 Loading source image for Brute-Force descriptor matching...\n";

    cv::Mat img1 = cv::imread(input_filename, cv::IMREAD_GRAYSCALE);
    if (img1.empty()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not load " << input_filename << ".\n";
        return EXIT_FAILURE;
    }

    // Create a translated/warped second image to simulate a matching scene
    cv::Mat trans_mat = (cv::Mat_<double>(2,3) << 1, 0, 20, 0, 1, 15);
    cv::Mat img2;
    cv::warpAffine(img1, img2, trans_mat, img1.size());

    Ptr<cv::ORB> orb = cv::ORB::create(500);
    std::vector<cv::KeyPoint> kp1, kp2;
    cv::Mat desc1, desc2;

    orb->detectAndCompute(img1, cv::noArray(), kp1, desc1);
    orb->detectAndCompute(img2, cv::noArray(), kp2, desc2);

    // Perform Brute-Force matching with Hamming distance
    cv::BFMatcher matcher(cv::NORM_HAMMING, true);
    std::vector<cv::DMatch> matches;
    matcher.match(desc1, desc2, matches);

    // Sort matches by distance
    std::sort(matches.begin(), matches.end(), [](const cv::DMatch& a, const cv::DMatch& b) {
        return a.distance < b.distance;
    });

    // Keep top 50 matches
    if (matches.size() > 50) {
        matches.resize(50);
    }

    cv::Mat img_matches;
    cv::drawMatches(img1, kp1, img2, kp2, matches, img_matches, cv::Scalar::all(-1), cv::Scalar::all(-1),
                    std::vector<char>(), cv::DrawMatchesFlags::NOT_DRAW_SINGLE_POINTS);

    const std::string output_filename = "output_bf_matches.png";
    if (!cv::imwrite(output_filename, img_matches)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to serialize output image.\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Brute-Force matching completed successfully. Rendered "
              << matches.size() << " matches. Output saved to " << output_filename << ".\n";
    return EXIT_SUCCESS;
}
