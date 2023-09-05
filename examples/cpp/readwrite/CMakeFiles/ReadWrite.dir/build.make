# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.18

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/chowkidar/projects/opencv_tests/readwrite

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/chowkidar/projects/opencv_tests/readwrite

# Include any dependencies generated for this target.
include CMakeFiles/ReadWrite.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/ReadWrite.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/ReadWrite.dir/flags.make

CMakeFiles/ReadWrite.dir/readwrite.cpp.o: CMakeFiles/ReadWrite.dir/flags.make
CMakeFiles/ReadWrite.dir/readwrite.cpp.o: readwrite.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/chowkidar/projects/opencv_tests/readwrite/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/ReadWrite.dir/readwrite.cpp.o"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/ReadWrite.dir/readwrite.cpp.o -c /home/chowkidar/projects/opencv_tests/readwrite/readwrite.cpp

CMakeFiles/ReadWrite.dir/readwrite.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/ReadWrite.dir/readwrite.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/chowkidar/projects/opencv_tests/readwrite/readwrite.cpp > CMakeFiles/ReadWrite.dir/readwrite.cpp.i

CMakeFiles/ReadWrite.dir/readwrite.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/ReadWrite.dir/readwrite.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/chowkidar/projects/opencv_tests/readwrite/readwrite.cpp -o CMakeFiles/ReadWrite.dir/readwrite.cpp.s

# Object files for target ReadWrite
ReadWrite_OBJECTS = \
"CMakeFiles/ReadWrite.dir/readwrite.cpp.o"

# External object files for target ReadWrite
ReadWrite_EXTERNAL_OBJECTS =

ReadWrite: CMakeFiles/ReadWrite.dir/readwrite.cpp.o
ReadWrite: CMakeFiles/ReadWrite.dir/build.make
ReadWrite: /usr/local/lib/aarch64-linux-gnu/libopencv_highgui.so.4.8.0
ReadWrite: /usr/local/lib/aarch64-linux-gnu/libopencv_ml.so.4.8.0
ReadWrite: /usr/local/lib/aarch64-linux-gnu/libopencv_objdetect.so.4.8.0
ReadWrite: /usr/local/lib/aarch64-linux-gnu/libopencv_photo.so.4.8.0
ReadWrite: /usr/local/lib/aarch64-linux-gnu/libopencv_stitching.so.4.8.0
ReadWrite: /usr/local/lib/aarch64-linux-gnu/libopencv_video.so.4.8.0
ReadWrite: /usr/local/lib/aarch64-linux-gnu/libopencv_videoio.so.4.8.0
ReadWrite: /usr/local/lib/aarch64-linux-gnu/libopencv_imgcodecs.so.4.8.0
ReadWrite: /usr/local/lib/aarch64-linux-gnu/libopencv_calib3d.so.4.8.0
ReadWrite: /usr/local/lib/aarch64-linux-gnu/libopencv_dnn.so.4.8.0
ReadWrite: /usr/local/lib/aarch64-linux-gnu/libopencv_features2d.so.4.8.0
ReadWrite: /usr/local/lib/aarch64-linux-gnu/libopencv_flann.so.4.8.0
ReadWrite: /usr/local/lib/aarch64-linux-gnu/libopencv_imgproc.so.4.8.0
ReadWrite: /usr/local/lib/aarch64-linux-gnu/libopencv_core.so.4.8.0
ReadWrite: CMakeFiles/ReadWrite.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/chowkidar/projects/opencv_tests/readwrite/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable ReadWrite"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/ReadWrite.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/ReadWrite.dir/build: ReadWrite

.PHONY : CMakeFiles/ReadWrite.dir/build

CMakeFiles/ReadWrite.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/ReadWrite.dir/cmake_clean.cmake
.PHONY : CMakeFiles/ReadWrite.dir/clean

CMakeFiles/ReadWrite.dir/depend:
	cd /home/chowkidar/projects/opencv_tests/readwrite && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/chowkidar/projects/opencv_tests/readwrite /home/chowkidar/projects/opencv_tests/readwrite /home/chowkidar/projects/opencv_tests/readwrite /home/chowkidar/projects/opencv_tests/readwrite /home/chowkidar/projects/opencv_tests/readwrite/CMakeFiles/ReadWrite.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/ReadWrite.dir/depend
