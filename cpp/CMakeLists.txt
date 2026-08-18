# ==============================================================================
# @file CMakeLists.txt
# @brief C++ Workspace Root Orchestrator
#
# @par Purpose
# Serves as the top-level build orchestrator for the C++ domain of the repository.
# Enforces global C++17 language standards, discovers the custom-compiled OpenCV
# framework package, and controls the subdirectory inclusion order for foundational
# learning modules and automated testing frameworks[cite: 2].
#
# @author Matha Goram[cite: 2]
# @version 1.0.0[cite: 2]
# @date 2026-08-12[cite: 2]
#
# @par Processing Workflow
# 1. Initialize minimum required CMake version and project metadata[cite: 2].
# 2. Enforce strict C++17 standard compliance across all child targets[cite: 2].
# 3. Locate external OpenCV dependencies via package configuration paths[cite: 2].
# 4. Integrate functional subdirectories (`01-getting-started`, `02-image-processing`, and `test`)[cite: 2].
# ==============================================================================

cmake_minimum_required(VERSION 3.22)
project(opencv_learning_path CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Find OpenCV package installed on your system
# find_package(OpenCV 5 REQUIRED)
find_package(OpenCV 5 QUIET)
if(NOT OpenCV_FOUND)
    find_package(OpenCV 4 REQUIRED)
endif()

message(STATUS "OpenCV Configuration Status:")
message(STATUS "    Version      : ${OpenCV_VERSION}")
message(STATUS "    Libraries    : ${OpenCV_LIBS}")
message(STATUS "    Include Path : ${OpenCV_INCLUDE_DIRS}")

# Register module subdirectories
add_subdirectory(01-getting-started)
add_subdirectory(02-image-processing)
# add_subdirectory(03-geometry-transforms.md)
