/**
 * @file ex03_perspective_transform_test.cpp
 * @brief Exercise 02: Perspective Transformation and Homography (`cv::getPerspectiveTransform`, `cv::warpPerspective`)
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
 * Demonstrates projecting an image plane from one perspective to another via a 3x3
 * homography transformation matrix. Essential for document de-skewing, bird's-eye view
 * orthorectification, and plane-to-plane computer vision alignment pipelines.
 *
 * @par Update History
 * - v1.0.0 (2026-08-15): Initial implementation for Chapter 03 geometry transforms.
 *
 * @par Prerequisites
 * - Development Host / Target Cluster Node (`raspbari13`, `raspbari42`, `raspbari44`)
 * - OpenCV 5.1.0 SDK development environment configured via CMake & Ninja
 * - Pre-existing input source asset (`output_live_snap.png`) from preceding chapter executions
 *
 * @par User Interface Guide
 * - Headless command-line utility designed for automated remote cluster execution.
 * - Standard output (`std::cout`) provides step-by-step progress tags prefixed with `[Ex 03 - Perspective Transform]`.
 * - Standard error (`std::cerr`) logs file-loading or serialization failures.
 * - Generates persistent disk artifact: `output_perspective_warp.png`.
 *
 * @par Error Message Responses
 * - Missing Input Asset: Logs an error message if `output_live_snap.png` cannot be loaded, returning `EXIT_FAILURE`.
 * - Serialization Failure: Logs an error message if writing `output_perspective_warp.png` fails, returning `EXIT_FAILURE`.
 *
 * @par Processing Workflow and Algorithms
 * 1. Image Ingestion: Load `output_live_snap.png` into a managed `cv::Mat` source container.
 * 2. Quad Correspondence Setup: Define four source quadrilateral corner points representing an angled view
 *    and four target destination points representing a rectified rectangular bounding box.
 * 3. Homography Computation: Solve the direct linear transformation system via `cv::getPerspectiveTransform`
 *    to produce a $3 \times 3$ projective transformation matrix $\mathbf{H}$.
 * 4. Projective Warping: Apply $\mathbf{H}$ across the image domain via `cv::warpPerspective` using bilinear interpolation.
 * 5. Artifact Serialization: Write the resulting rectified matrix to disk as `output_perspective_warp.png`.
 *
 * @par References and Notes
 * - OpenCV 5.1.0 Imgproc Geometric Image Transformations Documentation.
 * - Validated across multi-node Raspberry Pi cluster architecture.
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>
#include <vector>

int main() {
    const std::string ex_prefix = "Ex 03 - Perspective Transform";
    const std::string input_filename = "output_live_snap.png";

    std::cout << "[" << ex_prefix << "] 🌐 Loading source image for perspective homography warp...\n";

    // 1. Load source image matrix
    cv::Mat src = cv::imread(input_filename, cv::IMREAD_COLOR);
    if (src.empty()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not load " << input_filename
                  << ". Ensure preceding image capture was executed.\n";
        return EXIT_FAILURE;
    }

    float width = static_cast<float>(src.cols);
    float height = static_cast<float>(src.rows);

    // 2. Define 4 source quadrilateral corner points (simulating an angled / skewed plane)
    std::vector<cv::Point2f> src_pts(4);
    src_pts[0] = cv::Point2f(width * 0.15f, height * 0.20f); // Top-left
    src_pts[1] = cv::Point2f(width * 0.85f, height * 0.10f); // Top-right
    src_pts[2] = cv::Point2f(width * 0.95f, height * 0.90f); // Bottom-right
    src_pts[3] = cv::Point2f(width * 0.05f, height * 0.80f); // Bottom-left

    // Define 4 destination rectangle coordinates (rectified orthorectified view)
    std::vector<cv::Point2f> dst_pts(4);
    dst_pts[0] = cv::Point2f(0.0f, 0.0f);
    dst_pts[1] = cv::Point2f(width, 0.0f);
    dst_pts[2] = cv::Point2f(width, height);
    dst_pts[3] = cv::Point2f(0.0f, height);

    // 3. Calculate 3x3 perspective transformation (homography) matrix
    cv::Mat perspective_mat = cv::getPerspectiveTransform(src_pts, dst_pts);

    cv::Mat dst;
    // 4. Apply perspective transformation warp
    cv::warpPerspective(src, dst, perspective_mat, src.size());

    // 5. Serialize transformed matrix to disk
    const std::string output_filename = "output_perspective_warp.png";
    if (!cv::imwrite(output_filename, dst)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to serialize output image to " << output_filename << ".\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Perspective homography warp completed successfully. Output saved to " << output_filename << ".\n";
    return EXIT_SUCCESS;
}
