# 📑 Documentation Index: `01-getting-started/`

**Module**: Foundational C++ Core Operations & Environment Validation
**Author**: Matha Goram
**Version**: 1.0.0
**License**: MIT
## 🎯 Overview
The `01-getting-started/` module establishes the baseline infrastructure for the C++ OpenCV development environment. It covers system validation, memory management, foundational matrix operations, channel manipulation, and headless stream generation without requiring an active graphical display server.

## 🗂️ File Index & Quick Reference

| Icon | Filename | Core Concept | Primary OpenCV API / Feature |
|------|---|---|---|
| 🟢   | hello_opencv.cpp | Environment Smoke Test | `cv::getVersionString()` |
| 🎨   | ex01_canvas_test.cpp | Matrix Allocation & Drawing | `cv::Mat, cv::circle, cv::rectangle |
| 🌈   | ex01_gradient_test.cpp | Pixel Mapping & Color Gradients | Direct pointer traversal / scalar loops |
| 📁   | ex01_imread_test.cpp | Asset Ingestion & Serialization | `cv::imread(), cv::imwrite()` |
| 🔀   | ex01_split_merge_test.cpp | Channel Decomposition & Synthesis | `cv::split(), cv::merge()` |
| ⚖️   | ex01_blend_test.cpp | Linear Combination & Blending | `cv::addWeighted()` |
| 📐 | ex01_roi_test.cpp | Zero-Copy Memory Slicingcv::Rect, Header reference assignment🎬ex01_video_writer_test.cppHeadless Stream Encodingcv::VideoWriter, FourCC MJPG⚙️CMakeLists.txtModule Build Specificationadd_executable(), target_link_libraries()🔍 Detailed Component Specifications🟢 hello_opencv.cppPurpose: Serves as the primary smoke test to confirm that the local OpenCV library paths, header inclusions, and linking configurations are functioning correctly.Workflow: Initializes runtime structures, queries the core library version string, prints telemetry to stdout, and exits with a success code.🎨 ex01_canvas_test.cppPurpose: Demonstrates dynamic matrix allocation (cv::Mat) and primitive shape rendering on a blank canvas.Workflow: Instantiates an 8-bit 3-channel matrix, draws filled background rectangles and geometric circles with scalar color definitions, and serializes the result to disk.🌈 ex01_gradient_test.cppPurpose: Explores direct pixel manipulation and iterative coordinate-based color gradient generation across a multi-channel matrix buffer.Workflow: Iterates across row and column boundaries to compute linear intensity shifts, applies pixel-level color assignments, and exports the generated asset.📁 ex01_imread_test.cppPurpose: Validates disk asset ingestion and basic image round-trip serialization.Workflow: Loads an external source image into memory via cv::imread(), checks buffer validity, and writes an encoded copy back to disk via cv::imwrite().🔀 ex01_split_merge_test.cppPurpose: Explores multi-channel matrix decomposition and reconstruction.Workflow: Splits a 3-channel BGR matrix into individual single-channel buffers using cv::split(), manipulates channel data (e.g., zeroing out the blue channel), reconstructs the composite frame via cv::merge(), and serializes the output.⚖️ ex01_blend_test.cppPurpose: Implements pixel-wise linear combinations and alpha blending between two independent image buffers.Workflow: Combines a background canvas and geometric overlay asset using cv::addWeighted() to produce a smooth transition overlay effect based on defined alpha ($\alpha$) and beta ($\beta$) weighting coefficients.📐 ex01_roi_test.cppPurpose: Demonstrates memory-efficient sub-matrix extraction and manipulation using zero-copy header referencing.Workflow: Defines a rectangular bounding region (cv::Rect), extracts a sub-matrix reference without duplicating pixel buffer memory, applies an in-place color transformation, and validates parent matrix synchronization.🎬 ex01_video_writer_test.cppPurpose: Provides headless time-series frame generation, sequential stream processing, and video container encoding.Workflow: Initializes a cv::VideoWriter instance with an MJPG FourCC codec, procedurally renders moving shapes across an animation loop, writes frames sequentially, and releases the stream buffer. |
| 📷 | ex01_camera_image_test.cpp | Single Frame Hardware Capturecv::VideoCapture, cv::imwrite() |
| 📹 | ex01_camera_stream_test.cpp | Live Stream Encodingcv::VideoCapture, cv::VideoWriter |
| 🎬 | ex01_video_writer_test.cpp | Headless Stream Encodingcv::VideoWriter, FourCC MJPG |
| ⚙️ | CMakeLists.txt | Module Build Specificationadd_executable(), target_link_libraries() |


### ⚙️ CMakeLists.txt
* **Purpose**: Configures module-level build targets for the `01-getting-started` directory.
* **Workflow**: Enumerates source files, declares standalone executable binaries for each exercise, and links required OpenCV library components (`${OpenCV_LIBS}`).
