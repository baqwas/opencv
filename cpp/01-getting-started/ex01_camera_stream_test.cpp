/**
 * @file ex01_camera_stream_test.cpp
 * @brief Test 09: Live Hardware Video Stream Ingestion and Encoding
 *
 * @par Purpose
 * Demonstrates continuous frame-by-frame processing from a live hardware camera via the
 * native GStreamer pipeline (`libcamerasrc`). Establishes a sensor connection, ingests a
 * sequence of real-time frames, applies a dynamic text overlay (HUD) to each matrix buffer,
 * and serializes the sequence into an encoded MP4 video container.
 *
 * @author Matha Goram
 * @version 1.1.0
 * @date 2026-08-12
 *
 * @par Copyright
 * Copyright (c) 2026 ParkCircus Productions. All rights reserved.
 *
 * @par MIT License
 * [Standard MIT License text omitted for brevity]
 *
 * @par Prerequisites
 * - C++17 compliant compiler (GCC / Clang)
 * - CMake 3.22+
 * - OpenCV 4.x or 5.x development libraries with GStreamer support enabled
 * - Active libcamera stack (standard on RPi Bullseye/Bookworm/Trixie)
 * - Required GStreamer Runtime and Plugin Packages:
 *   - `gstreamer1.0-tools`
 *   - `gstreamer1.0-plugins-base`
 *   - `gstreamer1.0-plugins-good`
 *   - `gstreamer1.0-plugins-bad`
 *   - `gstreamer1.0-libcamera`
 *
 * @par User Interface Guide
 * Non-interactive Command-Line Interface (CLI):
 * 1. Build the CMake target `ex01_camera_stream_test`.
 * 2. Execute on the remote node (No wrappers required).
 * 3. Verify generated container `output_live_stream.mp4` via IDE or remote media tools.
 *
 * @par Processing Workflow and Algorithms
 * 1. **Pipeline Initialization**: Open `cv::VideoCapture` passing a GStreamer pipeline string targeting `libcamerasrc` with explicit resolution and framerate settings.
 * 2. **Sink Allocation**: Initialize `cv::VideoWriter` targeting an MP4 container matching the stream dimensions.
 * 3. **Stream Loop**: Execute a bounded loop for $N$ frames (e.g., 90 frames for a 3-second recording burst).
 * 4. **Buffer Processing**: For every iteration, extract a frame via `cap.read()`, stamp it with the current frame count via `cv::putText()`, and pass it to the encoder.
 * 5. **Resource Teardown**: Safely release both the camera capture and video writer handles to prevent memory leaks and hardware locks.
 *
 * @par Error Message Responses
 * - `[Ex 01 - Camera Stream] ❌ ERROR: Could not open the GStreamer pipeline.`
 *   - **Cause**: OpenCV built without GStreamer support or missing plugin packages.
 * - `[Ex 01 - Camera Stream] ❌ ERROR: Frame stream dropped prematurely.`
 *   - **Cause**: Pipeline capability mismatch or hardware drop mid-loop.
 *
 * @par References and Notes
 * - **Resolution Steps for Raspberry Pi CSI Cameras (IMX477 / Unicam)**:
 *   1. Avoid standard V4L2 device index bindings (`cv::CAP_V4L2`) on CSI sensors because they output raw Bayer data directly from Unicam, causing `select() timeout` errors.
 *   2. Install the required GStreamer runtime toolchains and plugins: `sudo apt install -y gstreamer1.0-tools gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad gstreamer1.0-libcamera`.
 *   3. Route video capture through a native GStreamer pipeline string via `cv::CAP_GSTREAMER`: `"libcamerasrc ! video/x-raw, width=1280, height=720, framerate=30/1 ! videoconvert ! appsink"`.
 * - **Common Fourcc Options for MP4 Containers**:
 *   - `cv::VideoWriter::fourcc('m', 'p', '4', 'v')`: MPEG-4 Visual codec. Widely supported across platforms with minimal external dependencies.
 *   - `cv::VideoWriter::fourcc('a', 'v', 'c', '1')` or `cv::VideoWriter::fourcc('H', '2', '6', '4')`: H.264 AVC codec. Delivers superior compression and smaller file sizes, though it relies on your system's FFmpeg installation having H.264 encoding support enabled.
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>

int main() {
    const std::string ex_prefix = "Ex 01 - Camera Stream";
    const std::string output_filename = "output_live_stream.mp4";

    // Define the GStreamer pipeline targeting the native libcamera stack
    const std::string pipeline = "libcamerasrc ! video/x-raw, width=1280, height=720, framerate=30/1 ! videoconvert ! appsink";

    std::cout << "[" << ex_prefix << "] 🎬 Initializing live sensor telemetry loop via GStreamer (libcamerasrc)...\n";

    // Open the pipeline using the GStreamer backend
    cv::VideoCapture cap(pipeline, cv::CAP_GSTREAMER);
    if (!cap.isOpened()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not open the GStreamer pipeline.\n";
        std::cerr << "          Ensure OpenCV was built with GStreamer support and libcamerasrc is available.\n";
        return EXIT_FAILURE;
    }

    int frame_width = 1280;
    int frame_height = 720;
    int fps = 30;
    int frames_to_record = 90; // 3-second recording burst

    cv::VideoWriter writer(output_filename, cv::VideoWriter::fourcc('m', 'p', '4', 'v'), fps, cv::Size(frame_width, frame_height));

    if (!writer.isOpened()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not open the output video file for write.\n";
        cap.release();
        return EXIT_FAILURE;
    }

    cv::Mat frame;
    std::cout << "[" << ex_prefix << "] ⏳ Recording live stream burst...\n";

    for (int i = 0; i < frames_to_record; i++) {
        if (!cap.read(frame) || frame.empty()) {
            std::cerr << "[" << ex_prefix << "] ❌ ERROR: Frame stream dropped prematurely at frame " << i << ".\n";
            break;
        }

        // Draw a diagnostic Heads-Up Display (HUD) overlay
        std::string hud_text = "LIVE STREAM | Frame: " + std::to_string(i);
        cv::putText(frame, hud_text, cv::Point(20, 40),
                    cv::FONT_HERSHEY_SIMPLEX, 0.7, cv::Scalar(0, 255, 0), 2, cv::LINE_AA);

        writer.write(frame); // Push modified frame to encoder
    }

    // Safe teardown of all hardware handles
    cap.release();
    writer.release();

    std::cout << "[" << ex_prefix << "] ✅ Hardware stream successfully encoded to: " << output_filename << "\n";
    return EXIT_SUCCESS;
}
