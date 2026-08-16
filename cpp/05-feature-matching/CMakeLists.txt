# ==============================================================================
# @file CMakeLists.txt
# @brief Subdirectory Build Orchestrator for Chapter 05 - Feature Matching
#
# @version 1.0.0
# @date 2026-08-15
# @author Matha Goram
#
# @par Update History
# - v1.0.0 (2026-08-15): Initial creation incorporating keypoints detection, descriptor
#                        matching, FLANN matching, and homography localization targets.
#
# @par Purpose
# Declares and builds executable targets for Chapter 05 feature matching exercises,
# linking them against the global OpenCV libraries and include directories.
# ==============================================================================

cmake_minimum_required(VERSION 3.22)

# Define executable targets for Chapter 05 exercises
add_executable(ex05_keypoints_detection_test ex05_keypoints_detection_test.cpp)
add_executable(ex05_descriptor_matching_test ex05_descriptor_matching_test.cpp)
add_executable(ex05_flann_matching_test ex05_flann_matching_test.cpp)
add_executable(ex05_homography_matching_test ex05_homography_matching_test.cpp)

# Link targets against OpenCV libraries and include paths
target_link_libraries(ex05_keypoints_detection_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex05_keypoints_detection_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex05_descriptor_matching_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex05_descriptor_matching_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex05_flann_matching_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex05_flann_matching_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex05_homography_matching_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex05_homography_matching_test PRIVATE ${OpenCV_INCLUDE_DIRS})
