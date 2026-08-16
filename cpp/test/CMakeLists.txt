# ==============================================================================
# @file CMakeLists.txt
# @brief Centralized CTest Automation and Test Runner Configuration
#
# @par Purpose
# Orchestrates automated validation for the C++ codebase using CMake's native CTest
# engine. References functional source files via relative paths from their parent
# learning modules to eliminate file duplication, compiles test runners, and registers
# execution binaries for continuous integration test reporting.
#
# @author Matha Goram
# @version 1.0.0
# @date 2026-08-12
#
# @par Processing Workflow
# 1. Enable the native CTest testing framework subsystem.
# 2. Compile test executables by pointing directly to source files in module directories.
# 3. Bind compiled targets to CTest test identifiers using `add_test()`.
# ==============================================================================

cmake_minimum_required(VERSION 3.22)
project(opencv_cpp_tests CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

find_package(OpenCV REQUIRED)
enable_testing()

# Compile directly from the 01-getting-started module directory
add_executable(canvas_test ../01-getting-started/ex01_canvas_test.cpp)
target_link_libraries(canvas_test PRIVATE ${OpenCV_LIBS})
add_test(NAME Ex01_CanvasTest COMMAND canvas_test)

add_executable(gradient_test ../01-getting-started/ex01_gradient_test.cpp)
target_link_libraries(gradient_test PRIVATE ${OpenCV_LIBS})
add_test(NAME Ex01_GradientTest COMMAND gradient_test)

# -----------------------------------------------------------------------------
# Hardware Sensor Capture Tests
# -----------------------------------------------------------------------------
add_executable(camera_image_test ../01-getting-started/ex01_camera_image_test.cpp)
target_link_libraries(camera_image_test PRIVATE ${OpenCV_LIBS})
add_test(NAME Ex01_CameraImageTest COMMAND camera_image_test)

add_executable(camera_stream_test ../01-getting-started/ex01_camera_stream_test.cpp)
target_link_libraries(camera_stream_test PRIVATE ${OpenCV_LIBS})
add_test(NAME Ex01_CameraStreamTest COMMAND camera_stream_test)
