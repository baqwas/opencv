# opencv
OpenCV tutorials for Raspberry Pi boards:
- Raspberry Pi Zero 2 W
- Raspberry Pi 4 Model B
- Raspberry Pi 3 Model B+
- Raspberry Pi 2 Model B+
- Raspberry Pi 1 Model B+
- Raspberry Pi Zero 2

I did deploy from source to Raspberry Pi Zero but alas I no longer have access to that board.

## Installation


### Packages


### Build/Make


## Test


### C++


#### HelloOpenCV
HelloOpenCV.cpp - basic test to link key libraries from the OpenCV suite for a simple exercise to load and display an image


### Python
Reference [Using OpenCV with gcc and CMake](https://docs.opencv.org/4.x/db/df5/tutorial_linux_gcc_cmake.html)

#### HelloOpenCV
HelloOpenCV.py - load and display a specific image

#### DisplayImage
This program requires a command line parameter for the name of an image file.
The imread method reads the file.
The imshow method displays the file.
After the image is displayed in a new window, when any key is pressed 
the program dismisses the window and terminates 
with the completion code set to zero.

##### Error Messages
| completion |   |   |
| code | message | notes |
|------|---------|-------|
| -1 | No image data | check 1st parameter |

# References
OpenCV Tutorials
http://docs.opencv.org/master/index.html

OpenCV-Python Tutorials
http://docs.opencv.org/3.0-beta/doc/py_tutorials/py_tutorials.html
