/**
 * @file ex01_blend_test.cpp
 * @brief Test 05: Pixel-Wise Linear Combination and Alpha Blending (`cv::addWeighted`)
 *
 * @par Purpose
 * Demonstrates pixel-wise linear blending of two equally-sized image buffers.
 * Combines a base color gradient matrix with a geometric overlay asset using a weighted
 * alpha-blending formula to produce a transparent transition overlay effect.
 *
 * @author Matha Goram
 * @version 1.0.0
 * @date 2026-08-12
 *
 * @par Copyright
 * Copyright (c) 2026 ParkCircus Productions. All rights reserved.
 *
 * @par MIT License
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation rights
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
 * @par Update History
 * - v1.0.0 (2026-08-11): Initial implementation with dual-matrix linear alpha blending.
 *
 * @par Prerequisites
 * - C++17 compliant compiler (GCC / Clang)
 * - CMake 3.22+
 * - OpenCV 4.x or 5.x development libraries (`libopencv-dev`)
 * - Read/Write permissions within the active working build directory
 *
 * @par User Interface Guide
 * Non-interactive Command-Line Interface (CLI) tailored for headless environments:
 * 1. Build the CMake target `ex01_blend_test` in CLion or terminal.
 * 2. Execute the binary on the target node.
 * 3. Inspect telemetry log output in standard console streams (`stdout` / `stderr`).
 * 4. Open `output_blend.png` in CLion's built-in image viewer.
 *
 * @par Processing Workflow and Algorithms
 * 1. **Source Asset Generation**: Allocate and populate two independent 640x480 matrices (`img1` and `img2`).
 * 2. **Weighted Blending Calculation**: Execute `cv::addWeighted(img1, 0.6, img2, 0.4, 0.0, blended)` to calculate linear pixel mixing ($dst = src1*\alpha + src2*\beta + gamma$).
 * 3. **Frame Serialization**: Export encoded matrix buffer to PNG image on disk via `cv::imwrite()`.
 * 4. **Error Validation**: Evaluate disk write boolean return code and report execution status.
 *
 * @par Error Message Responses
 * - `[Ex 01 - Alpha Blend] ❌ ERROR: Failed to write output_blend.png`
 *   - **Cause**: Target directory is read-only, disk space exhausted, or invalid target path.
 *   - **Resolution**: Verify directory permissions and disk capacity on target device.
 *
 * @par References and Notes
 * - OpenCV Matrix Arithmetic: https://docs.opencv.org/master/d2/de8/group__core__array.html#gafafbce1d3e9154aef720bab5b3d2a74e
 * - Mathematical Formula: Evaluates $dst = \alpha \cdot src1 + \beta \cdot src2 + \gamma$ per pixel channel.
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>

int main() {
    const std::string ex_prefix = "Ex 01 - Alpha Blend";
    const std::string output_filename = "output_blend.png";

    std::cout << "[" << ex_prefix << "] ⚖️ Initializing Alpha Blending Test...\n";

    // Create background image
    cv::Mat img1(480, 640, CV_8UC3, cv::Scalar(30, 30, 30));
    cv::rectangle(img1, cv::Point(50, 50), cv::Point(590, 430), cv::Scalar(0, 150, 200), -1);

    // Create overlay image
    cv::Mat img2(480, 640, CV_8UC3, cv::Scalar(200, 200, 200));
    cv::circle(img2, cv::Point(320, 240), 150, cv::Scalar(0, 0, 255), -1);

    cv::Mat blended;
    double alpha = 0.6;
    double beta = 0.4;
    double gamma = 0.0;

    // Perform weighted addition
    cv::addWeighted(img1, alpha, img2, beta, gamma, blended);

    if (!cv::imwrite(output_filename, blended)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to write " << output_filename << "\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Blended frame serialized to: " << output_filename << "\n";
    return EXIT_SUCCESS;
}
