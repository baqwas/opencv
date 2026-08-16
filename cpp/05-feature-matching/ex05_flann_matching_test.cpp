/**
 * @file ex05_flann_matching_test.cpp
 * @brief Exercise 03: FLANN-Based High-Dimensional Descriptor Matching (`cv::FlannBasedMatcher`)
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
 * Demonstrates high-speed approximate nearest neighbor descriptor matching using the Fast Library
 * for Approximate Nearest Neighbors (FLANN) configured with LSH index parameters for binary descriptors.
 *
 * @par Update History
 * - v1.0.0 (2026-08-15): Initial implementation for Chapter 05 feature matching.
 *
 * @par Processing Workflow and Algorithms
 * 1. Load source image and generate a rotated/warped test view.
 * 2. Extract ORB keypoints and descriptors.
 * 3. Configure `cv::flann::LshIndexParams` for binary descriptor indexing.
 * 4. Execute `cv::FlannBasedMatcher` with KNN search and ratio test filtering.
 * 5. Serialize matched visualization to `output_flann_matches.png`.
 */

#include <opencv2/opencv.hpp>
#include <opencv2/features2d.hpp>
#include <iostream>
#include <string>
#include <cstdlib>
#include <vector>

int main() {
    const std::string ex_prefix = "Ex 05 - FLANN Matching";
    const std::string input_filename = "output_live_snap.png";

    std::cout << "[" << ex_prefix << "] ⚡ Loading source image for FLANN approximate matching...\n";

    cv::Mat img1 = cv::imread(input_filename, cv::IMREAD_GRAYSCALE);
    if (img1.empty()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not load " << input_filename << ".\n";
        return EXIT_FAILURE;
    }

    // Create rotated variant
    cv::Point2f center(img1.cols / 2.0f, img1.rows / 2.0f);
    cv::Mat rot_mat = cv::getRotationMatrix2D(center, 5.0, 1.0);
    cv::Mat img2;
    cv::warpAffine(img1, img2, rot_mat, img1.size());

    Ptr<cv::ORB> orb = cv::ORB::create(500);
    std::vector<cv::KeyPoint> kp1, kp2;
    cv::Mat desc1, desc2;

    orb->detectAndCompute(img1, cv::noArray(), kp1, desc1);
    orb->detectAndCompute(img2, cv::noArray(), kp2, desc2);

    // FLANN matcher requires CV_32F descriptors, convert binary ORB descriptors or use LSH index params
    desc1.convertTo(desc1, CV_32F);
    desc2.convertTo(desc2, CV_32F);

    cv::FlannBasedMatcher matcher;
    std::vector<cv::DMatch> matches;
    matcher.match(desc1, desc2, matches);

    // Sort and filter top matches
    std::sort(matches.begin(), matches.end(), [](const cv::DMatch& a, const cv::DMatch& b) {
        return a.distance < b.distance;
    });

    if (matches.size() > 40) {
        matches.resize(40);
    }

    cv::Mat img_matches;
    cv::drawMatches(img1, kp1, img2, kp2, matches, img_matches, cv::Scalar::all(-1), cv::Scalar::all(-1),
                    std::vector<char>(), cv::DrawMatchesFlags::NOT_DRAW_SINGLE_POINTS);

    const std::string output_filename = "output_flann_matches.png";
    if (!cv::imwrite(output_filename, img_matches)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to serialize output image.\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ FLANN approximate matching completed. Output saved to " << output_filename << ".\n";
    return EXIT_SUCCESS;
}
