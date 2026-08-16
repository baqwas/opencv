# ==============================================================================
# @file CMakeLists.txt
# @brief Module Build Specification for Getting Started Exercises
#
# @par Purpose
# Defines and compiles individual executable targets for the foundational
# `01-getting-started` module. Links raw C++ source files (such as canvas rendering,
# color splitting, alpha blending, ROI slicing, and video stream generation)
# against the shared OpenCV core and imgcodecs library bundles.
#
# @author Matha Goram
# @version 1.0.0
# @date 2026-08-12
#
# @par Processing Workflow
# 1. Enumerate target source files for basic canvas, gradient, and stream operations.
# 2. Declare binary executables for each individual getting-started exercise.
# 3. Link required OpenCV library components (`${OpenCV_LIBS}`) to each target.
# ==============================================================================

cmake_minimum_required(VERSION 3.22)
project(opencv_learning CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

find_package(OpenCV 5 REQUIRED)

# -----------------------------------------------------------------------------
# Targets in 01-getting-started/
# -----------------------------------------------------------------------------

# Original baseline target
add_executable(hello_opencv hello_opencv.cpp)
target_include_directories(hello_opencv PRIVATE ${OpenCV_INCLUDE_DIRS})
target_link_libraries(hello_opencv PRIVATE ${OpenCV_LIBS})

# Test 1: Generated Test Canvas
add_executable(ex01_canvas_test ex01_canvas_test.cpp)
target_include_directories(ex01_canvas_test PRIVATE ${OpenCV_INCLUDE_DIRS})
target_link_libraries(ex01_canvas_test PRIVATE ${OpenCV_LIBS})

# Test 2: BGR Color Gradient Generator
add_executable(ex01_gradient_test ex01_gradient_test.cpp)
target_include_directories(ex01_gradient_test PRIVATE ${OpenCV_INCLUDE_DIRS})
target_link_libraries(ex01_gradient_test PRIVATE ${OpenCV_LIBS})

# Test 3: Disk Image Ingestion & Grayscale Processing
add_executable(ex01_imread_test ex01_imread_test.cpp)
target_include_directories(ex01_imread_test PRIVATE ${OpenCV_INCLUDE_DIRS})
target_link_libraries(ex01_imread_test PRIVATE ${OpenCV_LIBS})

# -----------------------------------------------------------------------------
# Hardware Sensor Capture Exercises
# -----------------------------------------------------------------------------
add_executable(camera_image_test ex01_camera_image_test.cpp)
target_link_libraries(camera_image_test PRIVATE ${OpenCV_LIBS})

add_executable(camera_stream_test ex01_camera_stream_test.cpp)
target_link_libraries(camera_stream_test PRIVATE ${OpenCV_LIBS})
