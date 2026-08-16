/**
 * @file ex01_roi_test.cpp
 * @brief Test 06: Regions of Interest (ROI) and Zero-Copy Matrix Slicing (`cv::Rect`)
 *
 * @par Purpose
 * Demonstrates memory-efficient sub-matrix extraction and manipulation using header referencing (`cv::Rect`).
 * Isolates a rectangular sub-region within a parent matrix without duplicating underlying pixel buffer memory,
 * applies an in-place color transformation to the ROI, and verifies that parent data references update instantly.
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
 * - v1.0.0 (2026-08-11): Initial implementation with zero-copy sub-matrix ROI slicing and modification.
 *
 * @par Prerequisites
 * - C++17 compliant compiler (GCC / Clang)
 * - CMake 3.22+
 * - OpenCV 4.x or 5.x development libraries (`libopencv-dev`)
 * - Read/Write permissions within the active working build directory
 *
 * @par User Interface Guide
 * Non-interactive Command-Line Interface (CLI) tailored for headless environments:
 * 1. Build the CMake target `ex01_roi_test` in CLion or terminal.
 * 2. Execute the binary on the target node.
 * 3. Inspect telemetry log output in standard console streams (`stdout` / `stderr`).
 * 4. Open `output_roi.png` in CLion's built-in image viewer.
 *
 * @par Processing Workflow and Algorithms
 * 1. **Canvas Allocation**: Instantiate 640x480 neutral background matrix.
 * 2. **ROI Slicing**: Define a `cv::Rect(160, 120, 320, 240)` and extract sub-matrix reference `cv::Mat roi = parent(region)`.
 * 3. **In-Place Modification**: Apply a solid color fill or pattern directly to the `roi` handle.
 * 4. **Frame Serialization**: Export modified parent matrix buffer to PNG image on disk via `cv::imwrite()`.
 * 5. **Error Validation**: Evaluate disk write boolean return code and report execution status.
 *
 * @par Error Message Responses
 * - `[Ex 01 - ROI Slicing] ❌ ERROR: Failed to write output_roi.png`
 *   - **Cause**: Target directory is read-only, disk space exhausted, or invalid target path.
 *   - **Resolution**: Verify directory permissions and disk capacity on target device.
 *
 * @par References and Notes
 * - OpenCV Basic Structures: https://docs.opencv.org/master/d3/d63/classcv_1_1Mat.html
 * - Memory Note: Slicing via `cv::Rect` creates a header pointing to the parent buffer without copying pixel data arrays.
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>

int main() {
    const std::string ex_prefix = "Ex 01 - ROI Slicing";
    const std::string output_filename = "output_roi.png";

    std::cout << "[" << ex_prefix << "] 📐 Initializing Region of Interest (ROI) Test...\n";

    // Create a background canvas
    cv::Mat canvas(480, 640, CV_8UC3, cv::Scalar(60, 60, 60));

    // Define a region of interest using cv::Rect(x, y, width, height)
    cv::Rect roi_region(160, 120, 320, 240);

    // Extract sub-matrix (zero-copy header reference)
    cv::Mat roi = canvas(roi_region);

    // Modify the ROI directly (fill with bright orange in BGR)
    roi.setTo(cv::Scalar(0, 128, 255));

    // Draw an inner marker to prove reference connection
    cv::rectangle(roi, cv::Point(40, 40), cv::Point(280, 200), cv::Scalar(255, 255, 255), 3);

    if (!cv::imwrite(output_filename, canvas)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to write " << output_filename << "\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ ROI modified parent frame serialized to: " << output_filename << "\n";
    return EXIT_SUCCESS;
}
