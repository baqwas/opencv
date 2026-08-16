# ==============================================================================
# @file CMakeLists.txt
# @brief Subdirectory Build Orchestrator for Chapter 04 - Contours and Shapes
#
# @version 1.0.0
# @date 2026-08-15
# @author Matha Goram
#
# @par Update History
# - v1.0.0 (2026-08-15): Initial creation incorporating find contours, properties,
#                        polygonal approximation, and convex hull targets under Chapter 04.
#
# @par Purpose
# Declares and builds executable targets for Chapter 04 contour and shape analysis
# exercises, linking them against the global OpenCV libraries and include directories
# established by the workspace root orchestrator.
# ==============================================================================

cmake_minimum_required(VERSION 3.22)

# Define executable targets for Chapter 04 exercises
add_executable(ex04_find_contours_test ex04_find_contours_test.cpp)
add_executable(ex04_contour_properties_test ex04_contour_properties_test.cpp)
add_executable(ex04_contour_approximation_test ex04_contour_approximation_test.cpp)
add_executable(ex04_convex_hull_test ex04_convex_hull_test.cpp)

# Link targets against OpenCV libraries and include paths
target_link_libraries(ex04_find_contours_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex04_find_contours_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex04_contour_properties_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex04_contour_properties_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex04_contour_approximation_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex04_contour_approximation_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex04_convex_hull_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex04_convex_hull_test PRIVATE ${OpenCV_INCLUDE_DIRS})
