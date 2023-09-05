/*
 * readwrite.cpp
 * 
 * Copyright 2023  <parkcircus@raspbari4>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * Reference
 * https://docs.opencv.org/4.x/db/deb/tutorial_display_image.html
 */
#include <opencv2/core.hpp>			// basic building blocks
#include <opencv2/imgcodecs.hpp>	// reading and writing
#include <opencv2/highgui.hpp>		// show image in a window

#include <iostream>
using namespace cv;

#include <iostream>
using namespace std;

int main(int argc, char **argv)
{
	string imgFile = "chihuly.jpg";
	string savFile = "chihuly.png";
	string image_path = samples::findFile(imgFile);
	/*
	 *  IMREAD_COLOR loads the image in the BGR 8-bit format. This is the default that is used here.
	 *  IMREAD_UNCHANGED loads the image as is (including the alpha channel if present)
	 *  IMREAD_GRAYSCALE loads the image as an intensity one
	 */
	Mat img = imread(image_path, IMREAD_COLOR);	// read & store in Mat object
	if(img.empty())	// was the image loaded?
	{
		cout << "Could not read the image: " << image_path << endl;
		return -1;
	}
	imshow(imgFile, img);
	int k = waitKey(0); // Wait for a keystroke in the window
	if(k == 's')
	{
		imwrite(savFile, img);
	}
	return 0;
}

