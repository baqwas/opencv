/**
 * @file ex03_polar_cartesian_test.cpp
 * @brief Exercise 03: Polar and Log-Polar Coordinate Mappings (`cv::linearPolar`, `cv::logPolar`)
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
 * Demonstrates transforming an image from Cartesian coordinates to polar and log-polar
 * coordinate systems. This transformation maps concentric circles into horizontal lines
 * and rays from the center into vertical lines, enabling rotation- and scale-invariant
 * template matching and radial visual feature analysis.
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
 * - Standard output (`std::cout`) provides step-by-step progress tags prefixed with `[Ex 03 - Polar Cartesian]`.
 * - Standard error (`std::cerr`) logs file-loading or serialization failures.
 * - Generates persistent disk artifacts: `output_linear_polar.png` and `output_log_polar.png`.
 *
 * @par Error Message Responses
 * - Missing Input Asset: Logs an error message if `output_live_snap.png` cannot be loaded, returning `EXIT_FAILURE`.
 * - Serialization Failure: Logs an error message if writing polar images fails, returning `EXIT_FAILURE`.
 *
 * @par Processing Workflow and Algorithms
 * 1. Image Ingestion: Load `output_live_snap.png` into a managed `cv::Mat` source container.
 * 2. Center and Radius Calculation: Determine the geometric center $(x_c, y_c)$ of the image frame
 *    and compute the maximum radius $R$ encompassing the region of interest.
 * 3. Linear Polar Transformation: Map Cartesian pixels to polar coordinates $(\rho, \theta)$ linearly
 *    using `cv::linearPolar` with bilinear interpolation and warp flags.
 * 4. Log-Polar Transformation: Map radial distance logarithmically using `cv::logPolar` to provide
 *    scale invariance.
 * 5. Artifact Serialization: Write both transformed matrices to disk as `output_linear_polar.png`
 *    and `output_log_polar.png`.
 *
 * @par References and Notes
 * - OpenCV 5.1.0 Imgproc Geometric Image Transformations Documentation.
 * - Validated across multi-node Raspberry Pi cluster architecture.
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>
#include <algorithm>

int main() {
    const std::string ex_prefix = "Ex 03 - Polar Cartesian";
    const std::string input_filename = "output_live_snap.png";

    std::cout << "[" << ex_prefix << "] 🌀 Loading source image for polar coordinate transformations...\n";

    // 1. Load source image matrix
    cv::Mat src = cv::imread(input_filename, cv::IMREAD_COLOR);
    if (src.empty()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not load " << input_filename
                  << ". Ensure preceding image capture was executed.\n";
        return EXIT_FAILURE;
    }

    // 2. Compute geometric center and maximum radius
    cv::Point2f center(static_cast<float>(src.cols) / 2.0f, static_cast<float>(src.rows) / 2.0f);
    double max_radius = std::min(center.x, center.y);

    cv::Mat linear_polar_dst, log_polar_dst;

    // 3. Apply Linear Polar Transformation
    cv::linearPolar(src, linear_polar_dst, center, max_radius, cv::INTER_LINEAR | cv::WARP_FILL_OUTLIERS);

    // 4. Apply Log-Polar Transformation
    cv::logPolar(src, log_polar_dst, center, max_radius, cv::INTER_LINEAR | cv::WARP_FILL_OUTLIERS);

    // 5. Serialize transformed matrices to disk
    const std::string lin_output = "output_linear_polar.png";
    const std::string log_output = "output_log_polar.png";

    if (!cv::imwrite(lin_output, linear_polar_dst)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to serialize linear polar output to " << lin_output << ".\n";
        return EXIT_FAILURE;
    }

    if (!cv::imwrite(log_output, log_polar_dst)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to serialize log-polar output to " << log_output << ".\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Polar and log-polar transformations completed successfully. Outputs saved to "
              << lin_output << " and " << log_output << ".\n";
    return EXIT_SUCCESS;
}
