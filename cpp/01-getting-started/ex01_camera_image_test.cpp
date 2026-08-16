/**
 * @file ex01_camera_image_test.cpp
 * @brief Test 08: Single Frame Hardware Sensor Capture (`cv::VideoCapture`)
 *
 * @par Purpose
 * Demonstrates the initialization of a physical USB or CSI camera sensor via the
 * native GStreamer pipeline (libcamerasrc). Establishes a hardware connection, flushes
 * initial frames to allow auto-exposure (AE) and auto-white-balance (AWB) algorithms
 * to settle, captures a single verified matrix frame, and serializes it to disk.
 *
 * @author Matha Goram
 * @version 1.2.0
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
 * - Active libcamera stack (standard on RPi Bullseye/Bookworm)
 *
 * @par User Interface Guide
 * Non-interactive Command-Line Interface (CLI):
 * 1. Build the CMake target `ex01_camera_image_test`.
 * 2. Execute on the remote node (No wrappers required).
 * 3. Inspect standard console streams for hardware connection telemetry.
 * 4. Open `output_live_snap.png` in the IDE to view the captured frame.
 *
 * @par Processing Workflow and Algorithms
 * 1. **Pipeline Initialization**: Open `cv::VideoCapture` passing a GStreamer pipeline string targeting `libcamerasrc`.
 * 2. **Hardware Validation**: Assert that the sensor stream is successfully opened.
 * 3. **Buffer Flushing (Sensor Warm-up)**: Pull frames to allow the hardware's internal light-balancing logic to stabilize.
 * 4. **Frame Ingestion**: Extract one clean `cv::Mat` frame from the active stream using `cap.read()`.
 * 5. **Serialization**: Write the buffer to disk via `cv::imwrite()`.
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>

int main() {
    const std::string ex_prefix = "Ex 01 - Camera Snap";
    const std::string output_filename = "output_live_snap.png";

    // Define the GStreamer pipeline targeting the native libcamera stack
    // We request a 1280x720 stream, convert it, and push it to OpenCV's appsink
    const std::string pipeline = "libcamerasrc ! video/x-raw, width=1280, height=720 ! videoconvert ! appsink";

    std::cout << "[" << ex_prefix << "] 📷 Initializing hardware sensor via GStreamer (libcamerasrc)...\n";

    // Open the pipeline using the GStreamer backend
    cv::VideoCapture cap(pipeline, cv::CAP_GSTREAMER);

    if (!cap.isOpened()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not open the GStreamer pipeline.\n";
        std::cerr << "          Ensure OpenCV was built with GStreamer support and libcamerasrc is available.\n";
        return EXIT_FAILURE;
    }

    cv::Mat frame;

    std::cout << "[" << ex_prefix << "] ⏳ Warming up sensor auto-exposure...\n";

    // Discard the first 15 frames to allow the ISP to settle
    for (int i = 0; i < 15; i++) {
        if (!cap.read(frame)) {
            std::cerr << "[" << ex_prefix << "] ❌ ERROR: GStreamer pipeline dropped frame " << i << " during warm-up.\n";
            cap.release();
            return EXIT_FAILURE;
        }
    }

    // Capture the final targeted frame
    if (!cap.read(frame) || frame.empty()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Final captured frame is empty. Pipeline dropped.\n";
        cap.release();
        return EXIT_FAILURE;
    }

    // Release the hardware interface
    cap.release();

    if (!cv::imwrite(output_filename, frame)) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Failed to write " << output_filename << "\n";
        return EXIT_FAILURE;
    }

    std::cout << "[" << ex_prefix << "] ✅ Hardware frame captured and saved to: " << output_filename << "\n";
    return EXIT_SUCCESS;
}
