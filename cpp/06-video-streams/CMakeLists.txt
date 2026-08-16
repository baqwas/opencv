# ==============================================================================
# @file CMakeLists.txt
# @brief Subdirectory Build Orchestrator for Chapter 06 - Video Streams
#
# @version 1.0.0
# @date 2026-08-15
# @author Matha Goram
#
# @par Update History
# - v1.0.0 (2026-08-15): Initial creation incorporating video capture, background
#                        subtraction, optical flow, and video writer targets under Chapter 06.
#
# @par Purpose
# Declares and builds executable targets for Chapter 06 video stream exercises,
# linking them against the global OpenCV libraries and include directories.
# ==============================================================================

cmake_minimum_required(VERSION 3.22)

# Define executable targets for Chapter 06 exercises
add_executable(ex06_video_capture_test ex06_video_capture_test.cpp)
add_executable(ex06_background_subtraction_test ex06_background_subtraction_test.cpp)
add_executable(ex06_optical_flow_test ex06_optical_flow_test.cpp)
add_executable(ex06_video_writer_test ex06_video_writer_test.cpp)

# Link targets against OpenCV libraries and include paths
target_link_libraries(ex06_video_capture_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex06_video_capture_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex06_background_subtraction_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex06_background_subtraction_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex06_optical_flow_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex06_optical_flow_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex06_video_writer_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex06_video_writer_test PRIVATE ${OpenCV_INCLUDE_DIRS})
