/**
 * @file ex05_homography_matching_test.cpp
 * @brief Exercise 04: Object Localization and Homography Estimation via Feature Matches (`cv::findHomography`, `cv::RANSAC`)
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
 * Demonstrates localizing an object within a scene by computing a robust homography transformation
 * matrix using RANSAC outlier rejection on feature point correspondences.
 *
 * @par Update History
 * - v1.0.0 (2026-08-15): Initial implementation for Chapter 05 feature matching.
 *
 * @par Processing Workflow and Algorithms
 * 1. Load source image as query object and create a perspective-warped scene view.
 * 2. Extract ORB keypoints and descriptors.
 * 3. Match descriptors using Brute-Force matcher with ratio test filtering.
 * 4. Compute homography matrix via `cv::findHomography` with `cv::RANSAC`.
 * 5. Draw object bounding box outline on the scene and serialize to `output_homography_localization.png`.
 */

#include <opencv2/opencv.hpp>
#include <opencv2/features2d.hpp>
#include <iostream>
#include <string>
#include <cstdlib>
#include <vector>

int main() {
    const std::string ex_prefix = "Ex 05 - Homography Matching";
    const std::string input_filename = "output_live_snap.png";

    std::cout << "[" << ex_prefix << "] 🗺️ Loading source image for homography object localization...\n";

    cv::Mat img_object = cv::imread(input_filename, cv::IMREAD_GRAYSCALE);
    if (img_object.empty()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not load " << input_filename << ".\n";
        return EXIT_FAILURE;
    }

    // Create scene by warping object image
    std::vector<cv::Point2f> obj_corners(4);
    obj_corners[0] = cv::Point2f(0, 0);
    obj_corners[1] = cv::Point2f(static_cast<float>(img_object.cols), 0);
    obj_corners[2] = cv::Point2f(static_cast<float>(img_object.cols), static_cast<float>(img_object.rows));
    obj_corners[3] = cv::Point2f(0, static_cast<float>(img_object.rows));

    std::vector<cv::Point2f> scene_corners(4);
    scene_corners[0] = cv::Point2f(50, 40);
    scene_corners[1] = cv::Point2f(static_cast<float>(img_object.cols) - 20, 60);
    scene_corners[2] = cv::Point2f(static_cast<float>(img_object.cols) - 40, static_cast<float>(img_object.rows) - 30);
    scene_corners[3] = cv::Point2f(30, static_cast<float>(img_object.rows) - 10);

    cv::Mat H_warp = cv::getPerspectiveTransform(obj_corners, scene_corners);
    cv::Mat img_scene;
    cv::warpPerspective(img_object, img_scene, H_warp, img_object.size());

    // Extract features
    Ptr<cv::ORB> orb = cv::ORB::create(1000);
    std::vector<cv::KeyPoint> kp_obj, kp_scene;
    cv::Mat desc_obj, desc_scene;

    orb->detectAndCompute(img_object, cv::noArray(), kp_obj, desc_obj);
    orb->detectAndCompute(img_scene, cv::noArray(), kp_scene, desc_scene);

    cv::BFMatcher matcher(cv::NORM_HAMMING);
    std::vector<std::vector<cv::DMatch>> knn_matches;
    matcher.knnMatch(desc_obj, desc_scene, knn_matches, 2);

    // Apply Lowe's ratio test
    std::vector<cv::DMatch> good_matches;
    for (size_t i = 0; i < knn_matches.size(); i++) {
        if (knn_matches[i][0].distance < 0.75f * knn_matches[i][1].distance) {
            good_matches.push_back(knn_matches[i][0]);
        }
    }

    std::vector<cv::Point2f> src_pts;
    std::vector<cv::Point2f> dst_pts;
    for (size_t i = 0; i < good_matches.size(); i++) {
        src_pts.push_back(kp_obj[good_matches[i].queryIdx].pt);
        dst_pts.push_back(kp_scene[good_matches[i].trainIdx].pt);
    }

    cv::Mat H = cv::findHomography(src_pts, dst_pts, cv::RANSAC);

    // Get corners from object image and project to scene
    std::vector<cv::Point2f> transformed_corners(4);
    cv::perspectiveTransform(obj_corners, transformed_corners, H);

    cv::Mat img_result;
    cv::cvtColor(img_scene, img_result, cv::COLOR_GRAY2BGR);

    for (int i = 0; i < 4; i++) {
        cv::line(img_result, transformed_corners[i], transformed_corners[(i + 1) % 4], cv::Scalar(0, 255, 0), 4);
    }

    const std::string output_filename = "output_homography_localization.png";
    if (!cv::imwrite(output_filename, img_result)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to serialize output image.\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Homography object localization completed successfully. Output saved to " << output_filename << ".\n";
    return EXIT_SUCCESS;
}
