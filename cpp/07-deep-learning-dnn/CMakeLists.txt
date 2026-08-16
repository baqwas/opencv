# ==============================================================================
# @file CMakeLists.txt
# @brief Subdirectory Build Orchestrator for Chapter 07 - Deep Learning DNN
#
# @version 1.0.0
# @date 2026-08-15
# @author Matha Goram
#
# @par Update History
# - v1.0.0 (2026-08-15): Initial creation incorporating model loading, blob preprocessing,
#                        object detection, and face detection targets under Chapter 07.
#
# @par Purpose
# Declares and builds executable targets for Chapter 07 deep learning DNN exercises,
# linking them against the global OpenCV libraries and include directories.
# ==============================================================================

cmake_minimum_required(VERSION 3.22)

# Define executable targets for Chapter 07 exercises
add_executable(ex07_dnn_model_loading_test ex07_dnn_model_loading_test.cpp)
add_executable(ex07_dnn_blob_preprocessing_test ex07_dnn_blob_preprocessing_test.cpp)
add_executable(ex07_dnn_object_detection_test ex07_dnn_object_detection_test.cpp)
add_executable(ex07_dnn_face_detection_test ex07_dnn_face_detection_test.cpp)

# Link targets against OpenCV libraries and include paths
target_link_libraries(ex07_dnn_model_loading_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex07_dnn_model_loading_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex07_dnn_blob_preprocessing_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex07_dnn_blob_preprocessing_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex07_dnn_object_detection_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex07_dnn_object_detection_test PRIVATE ${OpenCV_INCLUDE_DIRS})

target_link_libraries(ex07_dnn_face_detection_test PRIVATE ${OpenCV_LIBS})
target_include_directories(ex07_dnn_face_detection_test PRIVATE ${OpenCV_INCLUDE_DIRS})
