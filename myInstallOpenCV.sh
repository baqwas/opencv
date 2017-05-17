#!/bin/bash
# myInstallOpenCV.sh
# Install OpenCV on Raspberry Pi Zero W
clear
echo "Installing OpenCV... It will take few hours! :)"
echo "Obligatory updates..."
# ensuring environment is current
sudo apt-get update
sudo apt-get -y upgrade
# build utilities
echo "Build utilities..."
sudo apt-get install -y build-essential cmake pkg-config
# image packages
echo "Image input/output packages..."
sudo apt-get install -y libjpeg-dev libtiff5-dev libjasper-dev libpng12-dev
# Video packages
echo "Video processing packages..."
sudo apt-get install -y libavcodec-dev libavformat-dev libswscale-dev libv4l-dev
sudo apt-get install -y libsvidcore-dev libx264-dev
# GTK libraries for the OpenCV GUI
echo "GTK libraries..."
sudo apt-get install -y libgtk2.0-dev
# optimization modules
echo "Optimization libraries..."
sudo apt-get install -y libatlas-base-dev gfortran
# python libraries for development
echo "Python3 libraries..."
sudo apt-get install -y python3-dev
# git the OpenCV source
echo "OpenCV from the public repository..."
cd ~
wget -O opencv.zip https://github.com/opencv/opencv/archive/3.2.0.zip
unzip opencv.zip
wget -O opencv_contrib.zip https://github.com/opencv/opencv_contrib/archive/3.2.0.zip
unzip opencv_contrib.zip
# python support
echo "Python support files"
wget https://bootstrap.pypa.io/get-pip.py
sudo python3 get-pip.py
echo "That's all folks!"
