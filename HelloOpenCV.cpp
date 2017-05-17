/*
 * HelloOpenCV.cpp
 * Basic test for the linking of key libraries from the OpenCV suite
 * armw
 * 2017-05-16
 * v0.1
 * Notes:
 * Intentionally avoiding the use of the namespace keyword for this introductory example
 * compile: g++ -Wall -c "%f" -I/usr/include/
 * build: g++ -Wall -o "%e" "%f" `pkg-config opencv --libs` -I/usr/include/
 * 
 * Copyright 2017  <baqwas(at)gmail(dot)com>
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
 * 
 */

#include <iostream>						// console input/output
#include <string>

#include <opencv2/core.hpp>				// basic building blocks
#include <opencv2/imgcodecs.hpp>
#include <opencv2/highgui/highgui.hpp>	// functions for input/output operations

int main(int argc, char **argv)
{
	int completionCode = -1;			// return obligatory completion code to caller
	cv::Mat myImage;					// store the data of the loaded image
	std::string myWindow = "default.png";	// title for display windows
	
	if (argc > 1)						// # of command line arguments
	{									// including program name at argv[0]
		myWindow = argv[1];				// pass image filename from command line
	}
	try
	{
		myImage = cv::imread(myWindow, cv::IMREAD_COLOR);// store the loaded image data
		if (!myImage.empty())
		{
			cv::namedWindow(myWindow, cv::WINDOW_AUTOSIZE);// no window re-size
			cv::imshow(myWindow, myImage);	// display image in specified window
			cv::waitKey(0);					// await keystroke to end program
			completionCode = 0;				// normal completion within program
		}
		else
		{									// image file read issue
			std::cerr << argv[0] << ": empty image file: " << myWindow << std::endl;
			completionCode = -2;			// unable to load image file
		}
	}
	catch (const cv::Exception& e)			// catch OpenCV exceptions
	{
		std::cerr << e.what() << std::endl;	//'refinements later
		completionCode = -3;				// OpenCV exception
	}
	return completionCode;
}

