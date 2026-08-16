/**
 * @file ex03_affine_transform_test.cpp
 * @brief Exercise 01: Arbitrary 3-Point Affine Warp (`cv::getAffineTransform`, `cv::warpAffine`)
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
 * Demonstrates computing an arbitrary 2D affine transformation matrix from three point
 * coordinate pairs and applying it to warp an image matrix, enabling affine operations
 * such as scaling, rotation, shearing, and skewing.
 *
 * @par Update History
 * - v1.0.0 (2026-08-15): Initial implementation for Chapter 03 geometry transforms.
 *
 * @par Prerequisites
 * - Development Host / Target Cluster Node (`raspbari13`, `raspbari42`, `raspbari44`)
 * - OpenCV 5.1.0 SDK development environment configured via CMake & Ninja
 * - Pre-existing input source asset (`output_live_snap.png`) from Chapter 1 execution
 *
 * @par User Interface Guide
 * - Headless command-line utility designed for automated remote cluster execution.
 * - Standard output (`std::cout`) provides step-by-step progress tags prefixed with `[Ex 03 - Affine Transform]`.
 * - Standard error (`std::cerr`) logs file-loading or serialization failures.
 * - Generates persistent disk artifact: `output_affine_warp.png`.
 *
 * @par Error Message Responses
 * - Missing Input Asset: Logs an error message if `output_live_snap.png` cannot be loaded, returning `EXIT_FAILURE`.
 * - Serialization Failure: Logs an error message if writing `output_affine_warp.png` fails, returning `EXIT_FAILURE`.
 *
 * @par Processing Workflow and Algorithms
 * 1. Image Ingestion: Load `output_live_snap.png` into a managed `cv::Mat` source container.
 * 2. Coordinate Mapping Setup: Define three source triangle coordinates corresponding to image corners
 *    and three destination triangle coordinates introducing geometric skew/shearing.
 * 3. Matrix Computation: Solve the linear system via `cv::getAffineTransform` to produce a $2 \times 3$
 *    affine transformation matrix $\mathbf{M}$.
 * 4. Spatial Warping: Apply $\mathbf{M}$ across the image domain via `cv::warpAffine` using bilinear interpolation.
 * 5. Artifact Serialization: Write the resulting transformed matrix to disk as `output_affine_warp.png`.
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
    const std::string ex_prefix = "Ex 03 - Affine Transform";
    const std::string input_filename = "output_live_snap.png";

    std::cout << "[" << ex_prefix << "] 📐 Loading source image for 3-point affine transformation...\n";

    // 1. Load source image matrix
    cv::Mat src = cv::imread(input_filename, cv::IMREAD_COLOR);
    if (src.empty()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not load " << input_filename
                  << ". Ensure preceding image capture was executed.\n";
        return EXIT_FAILURE;
    }

    // 2. Define 3 source triangle point coordinates
    std::vector<cv::Point2f> src_pts(3);
    src_pts[0] = cv::Point2f(0.0f, 0.0f);
    src_pts[1] = cv::Point2f(static_cast<float>(src.cols - 1), 0.0f);
    src_pts[2] = cv::Point2f(0.0f, static_cast<float>(src.rows - 1));

    // Define 3 destination triangle point coordinates with structural skew
    std::vector<cv::Point2f> dst_pts(3);
    dst_pts[0] = cv::Point2f(static_cast<float>(src.cols) * 0.0f, static_cast<float>(src.rows) * 0.33f);
    dst_pts[1] = cv::Point2f(static_cast<float>(src.cols) * 0.85f, static_cast<float>(src.rows) * 0.25f);
    dst_pts[2] = cv::Point2f(static_cast<float>(src.cols) * 0.15f, static_cast<float>(src.rows) * 0.90f);

    // 3. Calculate 2x3 affine transformation matrix
    cv::Mat warp_mat = cv::getAffineTransform(src_pts, dst_pts);

    cv::Mat dst;
    // 4. Apply affine transformation warp
    cv::warpAffine(src, dst, warp_mat, src.size());

    // 5. Serialize transformed matrix to disk
    const std::string output_filename = "output_affine_warp.png";
    if (!cv::imwrite(output_filename, dst)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to serialize output image to " << output_filename << ".\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Affine transformation completed successfully. Output saved to " << output_filename << ".\n";
    return EXIT_SUCCESS;
}
