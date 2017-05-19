
#!/bin/bash
# myOpenCVcmake.sh
# build cmake for OpenCV deployment
# baqwas(at)gmail(dot)com
# 2017-05-17
# v0.2
cd ~/opencv-3.2.0/
mkdir build
cd build
cmake -D CMAKE_BUILD_TYPE=RELEASE \
	-D CMAKE_INSTALL_PREFIX=/usr/local \
	-D INSTALL_C_EXAMPLES=OFF \
	-D INSTALL_PYTHON_EXAMPLES=ON \
	-D OPENCV_EXTRA_MODULES_PATH=~/opencv_contrib-3.2.0/modules \
	-D BUILD_EXAMPLES=ON ..
