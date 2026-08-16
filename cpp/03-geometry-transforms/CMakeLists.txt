# ==============================================================================
# @file CMakeLists.txt
# @brief Subdirectory Build Orchestrator for Chapter 03 - Geometry Transforms
#
# @version 1.0.0
# @date 2026-08-15
# @author Matha Goram
#
# @par Update History
# - v1.0.0 (2026-08-15): Initial creation incorporating affine, perspective,
#                        polar cartesian, and lens remap targets under Chapter 03.
#
# @par Purpose
# Declares and builds executable targets for Chapter 03 geometry transformation
# exercises, linking them against the global OpenCV libraries and include directories
# established by the workspace root orchestrator[cite: 2].
# ==============================================================================

cmake_minimum_required(VERSION 3.22)

# Define executable targets for Chapter 03 exercises
add_executable(ex03_affine_transform_test ex03_affine_transform_test.cpp)
add_executable(ex03_perspective_transform_test ex03_perspective_transform_test.cpp)
add_executable(ex03_polar_cartesian_test ex03_polar_cartesian_test.cpp)
add_executable(ex03_remap_lens_test ex03_remap_lens_test.cpp)

# Link targets against OpenCV libraries and include paths
target_link_libraries(ex03_affine_transform_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex03_affine_transform_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex03_perspective_transform_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex03_perspective_transform_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex03_polar_cartesian_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex03_polar_cartesian_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex03_remap_lens_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex03_remap_lens_test PRIVATE ${OpenCV_INCLUDE_DIRS})
