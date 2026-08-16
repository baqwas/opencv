/**
 * @file ex01_video_writer_test.cpp
 * @brief Test 07: Headless Sequential Video Frame Generation and Encoding (`cv::VideoWriter`)
 *
 * @par Purpose
 * Demonstrates headless time-series frame generation, sequential stream processing, and container encoding
 * using `cv::VideoWriter`. Procedurally synthesizes a multi-frame animation sequence with dynamic moving elements
 * and writes the stream directly to an encoded disk container without requiring a display server window.
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
 * - v1.0.0 (2026-08-11): Initial implementation with procedural frame animation and MJPG video container serialization.
 *
 * @par Prerequisites
 * - C++17 compliant compiler (GCC / Clang)
 * - CMake 3.22+
 * - OpenCV 4.x or 5.x development libraries (`libopencv-dev`) with video codec support (`ffmpeg` / `gstreamer`)
 * - Read/Write permissions within the active working build directory
 *
 * @par User Interface Guide
 * Non-interactive Command-Line Interface (CLI) tailored for headless environments:
 * 1. Build the CMake target `ex01_video_writer_test` in CLion or terminal.
 * 2. Execute the binary on the target node.
 * 3. Inspect telemetry log output in standard console streams (`stdout` / `stderr`).
 * 4. Verify generated container file `output_animation.avi` via local media tools or telemetry validators.
 *
 * @par Processing Workflow and Algorithms
 * 1. **Writer Initialization**: Instantiate `cv::VideoWriter` target with filename, fourcc codec (`MJPG`), frame rate (30 FPS), and dimension parameters (640x480).
 * 2. **Stream Validation**: Evaluate `writer.isOpened()` status flag to guarantee encoder readiness.
 * 3. **Sequential Frame Synthesis**: Execute a loop across $N$ frames, dynamically calculating object positions per iteration.
 * 4. **Stream Serialization**: Write each generated matrix buffer sequentially into the video stream via `writer.write(frame)`.
 * 5. **Resource Closure**: Release writer handle and validate execution exit status.
 *
 * @par Error Message Responses
 * - `[Ex 01 - Video Writer] ❌ ERROR: Could not open the output video file for write.`
 *   - **Cause**: Missing underlying video codecs (FFmpeg/OpenH264) or invalid target file path permissions.
 *   - **Resolution**: Verify OpenCV backend codec installation and output directory access rights.
 *
 * @par References and Notes
 * - OpenCV Video I/O: https://docs.opencv.org/master/dd/d9e/classcv_1_1VideoWriter.html
 * - Codec Selection: MJPG (`cv::VideoWriter::fourcc('M','J','P','G')`) provides high compatibility across headless Linux nodes.
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>

int main() {
    const std::string ex_prefix = "Ex 01 - Video Writer";
    const std::string output_filename = "output_animation.avi";

    std::cout << "[" << ex_prefix << "] 🎬 Initializing Headless Video Writer Pipeline...\n";

    int frame_width = 640;
    int frame_height = 480;
    int fps = 30;
    int total_frames = 90; // 3 seconds of animation

    cv::VideoWriter writer;
    int fourcc = cv::VideoWriter::fourcc('M', 'J', 'P', 'G');

    writer.open(output_filename, fourcc, fps, cv::Size(frame_width, frame_height), true);

    if (!writer.isOpened()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not open the output video file for write.\n";
        return EXIT_FAILURE;
    }

    // Procedural frame generation loop
    for (int i = 0; i < total_frames; ++i) {
        cv::Mat frame(frame_height, frame_width, CV_8UC3, cv::Scalar(20, 20, 20));

        // Calculate moving coordinate for shape animation
        int x_pos = static_int_cast: (50 + i * 6) % frame_width;
        int y_pos = 240 + static_int_cast: (std::sin(i * 0.1) * 80);

        // Draw animated elements
        cv::circle(frame, cv::Point(x_pos, y_pos), 40, cv::Scalar(0, 255, 128), -1);
        cv::putText(frame, "Frame: " + std::to_string(i), cv::Point(30, 50),
                    cv::FONT_HERSHEY_SIMPLEX, 0.8, cv::Scalar(255, 255, 255), 2, cv::LINE_AA);

        writer.write(frame);
    }

    writer.release();

    std::cout << "[" << ex_prefix << "] ✅ Video sequence successfully encoded and saved to: " << output_filename << "\n";
    return EXIT_SUCCESS;
}
