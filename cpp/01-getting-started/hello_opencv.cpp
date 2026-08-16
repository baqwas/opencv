/**
 * @file hello_opencv.cpp
 * @brief Exercise 01: Hello OpenCV Test & Environment Verification
 *
 * @par Purpose
 * Validates the remote C++ build environment, CMake toolchain linkage, and OpenCV 5.x
 * library runtime initialization on headless target nodes. Constructs an 8-bit multi-channel
 * matrix canvas, renders anti-aliased vector typography, and serializes the memory frame
 * directly to a PNG disk image.
 *
 * @author Matha Goram
 * @version 1.1.0
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
 * - v1.0.0 (2026-08-11): Initial implementation using interactive GTK window rendering.
 * - v1.1.0 (2026-08-11): Refactored for headless remote execution via cv::imwrite.
 *                        Added error handling, string prefix variables, and dynamic paths.
 *
 * @par Prerequisites
 * - C++17 compliant compiler (GCC / Clang)
 * - CMake 3.22+
 * - OpenCV 4.x or 5.x development libraries (`libopencv-dev`)
 * - Read/Write permissions within the active working build directory
 *
 * @par User Interface Guide
 * Non-interactive Command-Line Interface (CLI) tailored for headless environments:
 * 1. Build the CMake target `hello_opencv` in CLion or terminal.
 * 2. Execute the binary on the target node.
 * 3. Inspect telemetry log output in standard console streams (`stdout` / `stderr`).
 * 4. Open the generated image file in CLion's built-in image viewer.
 *
 * @par Processing Workflow and Algorithms
 * 1. **Telemetry Initialization**: Query and format OpenCV version macro (`CV_VERSION`).
 * 2. **Buffer Allocation**: Instantiate `cv::Mat` (300x500 pixels, 3 channels, 8-bit unsigned integer).
 * 3. **Color Initialization**: Uniformly fill matrix memory buffer with BGR navy blue `(40, 30, 20)`.
 * 4. **Typography Rendering**: Apply `cv::FONT_HERSHEY_SIMPLEX` text using 2px anti-aliased lines (`cv::LINE_AA`).
 * 5. **Frame Serialization**: Encode matrix memory buffer to PNG format on disk via `cv::imwrite()`.
 * 6. **Error Validation**: Evaluate disk write boolean return code and report execution status.
 *
 * @par Error Message Responses
 * - `[Ex 01 - Hello OpenCV] ❌ ERROR: Failed to write output frame to <filename>`
 *   - **Cause**: Target directory is read-only, disk is full, or path is invalid.
 *   - **Resolution**: Check write permissions and confirm valid working directory paths.
 *
 * @par References and Notes
 * - OpenCV Mat Class Reference: https://docs.opencv.org/master/d3/d63/classcv_1_1Mat.html
 * - BGR Color Model: OpenCV uses native Blue-Green-Red channel ordering instead of RGB.
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>

int main() {
    // -------------------------------------------------------------------------
    // Configuration Variables & Prefix Identifiers
    // -------------------------------------------------------------------------
    const std::string ex_prefix = "Ex 01 - Hello OpenCV";
    const std::string output_filename = "output.png";

    std::cout << "==========================================\n";
    std::cout << "      OpenCV Learning Path - " << ex_prefix << "\n";
    std::cout << "==========================================\n";

    // 1. Verify OpenCV version telemetry
    std::cout << "[" << ex_prefix << "] ✅ OpenCV Version Detected: " << CV_VERSION << "\n";

    // 2. Allocate image matrix (300 rows x 500 columns, 3 channels, 8-bit unsigned)
    // OpenCV uses BGR channel ordering by default.
    cv::Mat canvas = cv::Mat::zeros(300, 500, CV_8UC3);
    canvas.setTo(cv::Scalar(40, 30, 20)); // Dark navy blue background (BGR)

    // 3. Render vector text onto the matrix canvas
    cv::putText(
        canvas,                       // Target matrix canvas
        "Hello, OpenCV 5!",           // Text payload
        cv::Point(45, 160),           // Origin (bottom-left coordinate)
        cv::FONT_HERSHEY_SIMPLEX,     // Font family
        1.0,                          // Scale factor
        cv::Scalar(0, 255, 128),      // Bright teal-green (BGR)
        2,                            // Line thickness (pixels)
        cv::LINE_AA                   // Anti-aliased line rendering
    );

    // 4. Serialize matrix buffer to disk (Headless PNG export)
    std::cout << "[" << ex_prefix << "] 💾 Exporting frame buffer to: " << output_filename << "\n";

    const bool write_success = cv::imwrite(output_filename, canvas);

    // 5. Robust error validation
    if (!write_success) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to write output frame to file: "
                  << output_filename << "\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Successfully saved image frame to "
              << output_filename << "\n";
    std::cout << "[" << ex_prefix << "] 🚀 Execution completed successfully.\n";

    return EXIT_SUCCESS;
}
