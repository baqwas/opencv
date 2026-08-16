# ==============================================================================
# @file CMakeLists.txt
# @brief Subdirectory Build Orchestrator for Chapter 02 - Image Processing
#
# @version 1.1.0
# @date 2026-08-15
# @author Matha Goram
#
# @par Update History
# - v1.1.0 (2026-08-15): Added missing add_executable declarations for morphology
#                        and smoothing targets.
# - v1.0.0 (2026-08-15): Initial creation incorporating ex02_colorspace_test target
#                        under the Chapter 02 image processing module[cite: 7].
#
# @par Purpose
# Declares and builds executable targets for Chapter 02 image processing exercises,
# linking them against the global OpenCV libraries and include directories
# established by the workspace root orchestrator[cite: 2].
# ==============================================================================

cmake_minimum_required(VERSION 3.22)

# Define executable targets for Chapter 02 exercises
add_executable(ex02_colorspace_test ex02_colorspace_test.cpp)
add_executable(ex02_geometry_test ex02_geometry_test.cpp)
add_executable(ex02_morphology_test ex02_morphology_test.cpp)
add_executable(ex02_smoothing_test ex02_smoothing_test.cpp)

# Link targets against OpenCV libraries and include paths
target_link_libraries(ex02_colorspace_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex02_colorspace_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex02_geometry_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex02_geometry_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex02_morphology_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex02_morphology_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex02_smoothing_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex02_smoothing_test PRIVATE ${OpenCV_INCLUDE_DIRS})
