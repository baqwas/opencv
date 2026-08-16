/**
 * @file ex01_imread_test.cpp
 * @brief Test 03: File Ingestion, Transformation, and Export Pipeline
 *
 * @par Purpose
 * Validates disk image file ingestion (`cv::imread`), fallback synthetic asset generation,
 * color space transformation (`cv::cvtColor`), and processed file serialization (`cv::imwrite`) in a
 * fully automated headless execution pipeline.
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
 * - v1.0.0 (2026-08-11): Initial implementation with disk ingestion, synthetic fallback, and grayscale conversion.
 *
 * @par Prerequisites
 * - C++17 compliant compiler (GCC / Clang)
 * - CMake 3.22+
 * - OpenCV 4.x or 5.x development libraries (`libopencv-dev`)
 * - Read/Write permissions within the active working build directory
 *
 * @par User Interface Guide
 * Non-interactive Command-Line Interface (CLI) tailored for headless environments:
 * 1. Build the CMake target `ex01_imread_test` in CLion or terminal.
 * 2. Execute the binary on the target node.
 * 3. Inspect telemetry log output in standard console streams (`stdout` / `stderr`).
 * 4. Open `output_processed.png` in CLion's built-in image viewer.
 *
 * @par Processing Workflow and Algorithms
 * 1. **Image Ingestion**: Attempt loading `input.png` matrix from working directory using `cv::imread()`.
 * 2. **Fallback Asset Generation**: If image buffer is empty, synthesize test image and write to disk.
 * 3. **Color Space Transformation**: Execute BGR to Grayscale color conversion (`COLOR_BGR2GRAY`).
 * 4. **Frame Serialization**: Encode transformed single-channel matrix to PNG file via `cv::imwrite()`.
 * 5. **Error Validation**: Check export operation result code and return execution status.
 *
 * @par Error Message Responses
 * - `[Ex 01 - Imread Test] ❌ ERROR: Failed to write output_processed.png`
 *   - **Cause**: Target directory is read-only, disk space exhausted, or invalid target path.
 *   - **Resolution**: Verify directory permissions and disk capacity on target device.
 *
 * @par References and Notes
 * - OpenCV Image File Reading: https://docs.opencv.org/master/d4/da8/group__imgcodecs.html
 * - Color Conversions: Grayscale conversion uses standard weighted luminance formula ($Y = 0.299R + 0.587G + 0.114B$).
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>

int main() {
    const std::string ex_prefix = "Ex 01 - Imread Test";
    const std::string input_filename = "input.png";
    const std::string output_filename = "output_processed.png";

    // Generate a temporary input image if non-existent
    cv::Mat source_image = cv::imread(input_filename, cv::IMREAD_COLOR);
    if (source_image.empty()) {
        std::cout << "[" << ex_prefix << "] ⚠️  " << input_filename
                  << " not found. Generating default synthetic input image...\n";
        source_image = cv::Mat(480, 640, CV_8UC3, cv::Scalar(100, 150, 200));
        cv::circle(source_image, cv::Point(320, 240), 100, cv::Scalar(0, 0, 255), -1);
        cv::imwrite(input_filename, source_image);
    }

    std::cout << "[" << ex_prefix << "] ⚙️ Processing image (BGR -> Grayscale conversion)...\n";

    cv::Mat gray_image;
    cv::cvtColor(source_image, gray_image, cv::COLOR_BGR2GRAY);

    if (!cv::imwrite(output_filename, gray_image)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to write " << output_filename << "\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Processed grayscale frame saved to: " << output_filename << "\n";
    return EXIT_SUCCESS;
}
