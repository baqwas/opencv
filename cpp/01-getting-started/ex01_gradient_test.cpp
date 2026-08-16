/**
 * @file ex01_gradient_test.cpp
 * @brief Test 02: Direct Pixel Access & BGR Color Gradient Generation
 *
 * @par Purpose
 * Demonstrates low-level element access and explicit pixel manipulation using `cv::Mat::at<cv::Vec3b>()`.
 * Procedurally generates a 2D multi-channel color gradient mapped across Blue, Green, and Red channels
 * and serializes the resulting memory buffer directly to a disk file.
 *
 * @author Matha Goram
 * @version 1.0.0
 * @date 2026-08-11
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
 * - v1.0.0 (2026-08-11): Initial implementation with procedural pixel color gradient mapping.
 *
 * @par Prerequisites
 * - C++17 compliant compiler (GCC / Clang)
 * - CMake 3.22+
 * - OpenCV 4.x or 5.x development libraries (`libopencv-dev`)
 * - Read/Write permissions within the active working build directory
 *
 * @par User Interface Guide
 * Non-interactive Command-Line Interface (CLI) tailored for headless environments:
 * 1. Build the CMake target `ex01_gradient_test` in CLion or terminal.
 * 2. Execute the binary on the target node.
 * 3. Inspect telemetry log output in standard console streams (`stdout` / `stderr`).
 * 4. Open `output_gradient.png` in CLion's built-in image viewer.
 *
 * @par Processing Workflow and Algorithms
 * 1. **Buffer Allocation**: Instantiate 640x480 8UC3 `cv::Mat` uninitialized buffer.
 * 2. **Pixel Traversal**: Execute nested coordinate loops over image matrix rows ($y$) and columns ($x$).
 * 3. **Channel Mapping**: Calculate Blue (horizontal slope), Green (vertical slope), and constant Red value.
 * 4. **Frame Serialization**: Encode and serialize memory buffer to PNG image on disk via `cv::imwrite()`.
 * 5. **Error Validation**: Evaluate file export status code and return execution result.
 *
 * @par Error Message Responses
 * - `[Ex 01 - Gradient Test] ❌ ERROR: Failed to write output_gradient.png`
 *   - **Cause**: Target directory is read-only, disk space exhausted, or invalid target path.
 *   - **Resolution**: Verify directory permissions and disk capacity on target device.
 *
 * @par References and Notes
 * - OpenCV Pixel Access Tutorial: https://docs.opencv.org/master/db/da5/tutorial_how_to_scan_images.html
 * - Performance Note: `cv::Mat::at` provides bounds-checked access; batch operations are used in production loops.
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>

int main() {
    const std::string ex_prefix = "Ex 01 - Gradient Test";
    const std::string output_filename = "output_gradient.png";

    std::cout << "[" << ex_prefix << "] 🌈 Computing Procedural Color Gradient...\n";

    cv::Mat image(480, 640, CV_8UC3);

    // Populate pixel channels explicitly
    for (int y = 0; y < image.rows; ++y) {
        for (int x = 0; x < image.cols; ++x) {
            image.at<cv::Vec3b>(y, x) = cv::Vec3b(
                static_cast<uchar>(x * 255 / image.cols), // Blue channel
                static_cast<uchar>(y * 255 / image.rows), // Green channel
                128                                       // Red channel
            );
        }
    }

    if (!cv::imwrite(output_filename, image)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to write " << output_filename << "\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Gradient frame serialized to: " << output_filename << "\n";
    return EXIT_SUCCESS;
}
