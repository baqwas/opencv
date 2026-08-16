/**
 * @file ex01_canvas_test.cpp
 * @brief Test 01: Vector Geometry & Canvas Rendering
 *
 * @par Purpose
 * Demonstrates 2D vector graphic drawing primitives in OpenCV (filled circles,
 * outline rectangles, anti-aliased text overlays) on an 8-bit multi-channel matrix canvas.
 * Encapsulates non-interactive frame serialization to disk without requiring a display server.
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
 * - v1.0.0 (2026-08-11): Initial release with 2D vector shape synthesis and PNG frame export.
 *
 * @par Prerequisites
 * - C++17 compliant compiler (GCC / Clang)
 * - CMake 3.22+
 * - OpenCV 4.x or 5.x development libraries (`libopencv-dev`)
 * - Read/Write permissions within the active working build directory
 *
 * @par User Interface Guide
 * Non-interactive Command-Line Interface (CLI) tailored for headless environments:
 * 1. Build the CMake target `ex01_canvas_test` in CLion or terminal.
 * 2. Execute the binary on the target node.
 * 3. Inspect telemetry log output in standard console streams (`stdout` / `stderr`).
 * 4. Open `output_canvas.png` in CLion's built-in image viewer.
 *
 * @par Processing Workflow and Algorithms
 * 1. **Canvas Allocation**: Instantiate 640x480 8UC3 `cv::Mat` buffer initialized to dark gray `(40, 40, 40)`.
 * 2. **Vector Shape Rendering**: Draw filled green circle (`cv::circle`) and blue outline rectangle (`cv::rectangle`).
 * 3. **Text Overlay**: Render white vector typography using anti-aliased font rendering (`cv::LINE_AA`).
 * 4. **Frame Serialization**: Export encoded matrix buffer to PNG image on disk via `cv::imwrite()`.
 * 5. **Error Validation**: Evaluate disk write boolean return code and report execution status.
 *
 * @par Error Message Responses
 * - `[Ex 01 - Canvas Test] ❌ ERROR: Failed to write output_canvas.png`
 *   - **Cause**: Target directory is read-only, disk space exhausted, or invalid target path.
 *   - **Resolution**: Verify directory permissions and disk capacity on target device.
 *
 * @par References and Notes
 * - OpenCV Drawing Functions: https://docs.opencv.org/master/d6/d6e/group__imgproc__draw.html
 * - BGR Color Model: OpenCV uses native Blue-Green-Red channel ordering.
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>

int main() {
    const std::string ex_prefix = "Ex 01 - Canvas Test";
    const std::string output_filename = "output_canvas.png";

    std::cout << "[" << ex_prefix << "] 🎨 Initializing Vector Canvas Test...\n";

    // Create a 640x480 matrix, 8-bit unsigned, 3 channels (BGR)
    cv::Mat canvas(480, 640, CV_8UC3, cv::Scalar(40, 40, 40));

    // Draw shapes
    cv::circle(canvas, cv::Point(320, 240), 80, cv::Scalar(0, 200, 100), -1);
    cv::rectangle(canvas, cv::Point(100, 100), cv::Point(200, 200), cv::Scalar(255, 100, 0), 3);

    // Overlay text
    cv::putText(canvas, "raspbari13 Canvas Test", cv::Point(140, 400),
                cv::FONT_HERSHEY_SIMPLEX, 0.9, cv::Scalar(255, 255, 255), 2, cv::LINE_AA);

    if (!cv::imwrite(output_filename, canvas)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to write " << output_filename << "\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Output frame serialized to: " << output_filename << "\n";
    return EXIT_SUCCESS;
}
