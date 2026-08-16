/**
 * @file ex01_split_merge_test.cpp
 * @brief Test 04: Multi-Channel Matrix Decomposition and Reconstruction (`cv::split` / `cv::merge`)
 *
 * @par Purpose
 * Demonstrates channel separation and synthesis in multi-channel matrices. Decomposes
 * a standard 3-channel BGR matrix into individual single-channel grayscale buffers, modifies
 * a specific target channel (e.g., suppressing the blue channel), reconstructs the composite
 * frame via matrix merging, and serializes the result to disk.
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
 * - v1.0.0 (2026-08-11): Initial implementation with channel splitting, zero-out modification, and re-merging.
 *
 * @par Prerequisites
 * - C++17 compliant compiler (GCC / Clang)
 * - CMake 3.22+
 * - OpenCV 4.x or 5.x development libraries (`libopencv-dev`)
 * - Read/Write permissions within the active working build directory
 *
 * @par User Interface Guide
 * Non-interactive Command-Line Interface (CLI) tailored for headless environments:
 * 1. Build the CMake target `ex01_split_merge_test` in CLion or terminal.
 * 2. Execute the binary on the target node.
 * 3. Inspect telemetry log output in standard console streams (`stdout` / `stderr`).
 * 4. Open `output_split_merge.png` in CLion's built-in image viewer.
 *
 * @par Processing Workflow and Algorithms
 * 1. **Synthetic Frame Creation**: Instantiate a 640x480 8UC3 multi-color canvas matrix.
 * 2. **Channel Splitting**: Invoke `cv::split()` to separate the BGR container into vector channels `[B, G, R]`.
 * 3. **Channel Manipulation**: Overwrite the blue channel matrix with a zero scalar matrix (`cv::Scalar(0)`).
 * 4. **Matrix Re-merging**: Combine modified channels back into a unified 3-channel frame via `cv::merge()`.
 * 5. **Frame Serialization**: Export encoded matrix buffer to PNG image on disk via `cv::imwrite()`.
 * 6. **Error Validation**: Evaluate disk write boolean return code and report execution status.
 *
 * @par Error Message Responses
 * - `[Ex 01 - Split/Merge] ❌ ERROR: Failed to write output_split_merge.png`
 *   - **Cause**: Target directory is read-only, disk space exhausted, or invalid target path.
 *   - **Resolution**: Verify directory permissions and disk capacity on target device.
 *
 * @par References and Notes
 * - OpenCV Core Operations: https://docs.opencv.org/master/d2/de8/group__core__array.html
 * - Channel Order: OpenCV splits channels into vector index order: 0 = Blue, 1 = Green, 2 = Red.
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <vector>
#include <string>
#include <cstdlib>

int main() {
    const std::string ex_prefix = "Ex 01 - Split/Merge";
    const std::string output_filename = "output_split_merge.png";

    std::cout << "[" << ex_prefix << "] 🔄 Initializing Channel Split & Merge Test...\n";

    // Create a base image with distinct color gradients/shapes
    cv::Mat canvas(480, 640, CV_8UC3, cv::Scalar(50, 100, 150));
    cv::circle(canvas, cv::Point(320, 240), 120, cv::Scalar(255, 128, 50), -1);

    // Split channels
    std::vector<cv::Mat> channels;
    cv::split(canvas, channels);

    if (channels.size() != 3) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to split channels correctly.\n";
        return EXIT_FAILURE;
    }

    // Suppress the Blue channel completely
    channels[0] = cv::Scalar(0);

    // Merge channels back together
    cv::Mat merged_canvas;
    cv::merge(channels, merged_canvas);

    if (!cv::imwrite(output_filename, merged_canvas)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to write " << output_filename << "\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Split/Merge frame serialized to: " << output_filename << "\n";
    return EXIT_SUCCESS;
}
