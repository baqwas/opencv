/*
 * basic_image_container.cpp
 * 
 * Copyright 2023  <chowkidar@raspbari4>
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
 * https://docs.opencv.org/4.x/d6/d6d/tutorial_mat_the_basic_image_container.html
 * 
 */
#include <opencv2/opencv.hpp>

#include <iostream>

using namespace cv;
using namespace std;

int main(int argc, char **argv)
{
	// introduction to Mat
	cout << "Introduction to Mat" << endl;
	Mat A, C; // creates just the header parts
	A = imread(argv[1], IMREAD_COLOR); // here we'll know the method used (allocate matrix)
	Mat B(A); // Use the copy constructor
	C = A; // Assignment operator
	
	Mat D (A, Rect(10, 10, 100, 100) ); // using a rectangle
	Mat E = A(Range::all(), Range(1,3)); // using row and column boundaries
	
	Mat F = A.clone();
	Mat G;
	A.copyTo(G);
	cout << "Introduction completed" << endl;
	
	// Storing methods
	/*
	 *
	 * RGB is the most common as our eyes use something similar, however keep in mind that OpenCV standard display system composes colors using the BGR color space (red and blue channels are swapped places).
	 * The HSV and HLS decompose colors into their hue, saturation and value/luminance components, which is a more natural way for us to describe colors. You might, for example, dismiss the last component, making your algorithm less sensible to the light conditions of the input image.
	 * YCrCb is used by the popular JPEG image format
	 * CIE L*a*b* is a perceptually uniform color space, which comes in handy if you need to measure the distance of a given color to another color.
	 */
	 
	 // Creating a Mat object explicitly
	 // cv::Mat::Mat Constructor
	 // CV_[The number of bits per item][Signed or Unsigned][Type Prefix]C[The channel number]
	Mat M(2,2, CV_8UC3, Scalar(0,0,255));
	cout << "M = " << endl << " " << M << endl << endl;
	// Use C/C++ arrays and initialize via constructor
	int sz[3] = {2,2,2};
	Mat L(3,sz, CV_8UC(1), Scalar::all(0));
	// cv::Mat::create function
	// cannot initialize values with this method
	// only reallocate its data memory if the new size exceeds the old one
	M.create(4,4, CV_8UC(2));
	cout << "M = "<< endl << " " << M << endl << endl;
	// MATLAB style initializer - specify size and data type
	Mat E2 = Mat::eye(4, 4, CV_64F);
	cout << "E = " << endl << " " << E2 << endl << endl;
	Mat O = Mat::ones(2, 2, CV_32F);
	cout << "O = " << endl << " " << O << endl << endl;
	Mat Z = Mat::zeros(3,3, CV_8UC1);
	cout << "Z = " << endl << " " << Z << endl << endl;
	// For small matrices you may use comma separated initializers or initializer lists
	Mat C2 = (Mat_<double>(3,3) << 0, -1, 0, -1, 5, -1, 0, -1, 0);
	cout << "C = " << endl << " " << C2 << endl << endl;
	C2 = (Mat_<double>({0, -1, 0, -1, 5, -1, 0, -1, 0})).reshape(3);
	cout << "C = " << endl << " " << C2 << endl << endl;
	// Create a new header for an existing Mat object and cv::Mat::clone or cv::Mat::copyTo it
	Mat RowClone = C.row(1).clone();
	cout << "RowClone = " << endl << " " << RowClone << endl << endl;
	// You can fill out a matrix with random values using the cv::randu() function. You need to give a lower and upper limit for the random values
	Mat R = Mat(3, 2, CV_8UC3);
	randu(R, Scalar::all(0), Scalar::all(255));

	// Output formatting
	cout << "R (default) = " << endl << R << endl << endl; // default
	cout << "R (python) = " << endl << format(R, Formatter::FMT_PYTHON) << endl << endl; // Python
	cout << "R (csv) = " << endl << format(R, Formatter::FMT_CSV ) << endl << endl; // csv
	cout << "R (numpy) = " << endl << format(R, Formatter::FMT_NUMPY ) << endl << endl; // numpy
	cout << "R (c) = " << endl << format(R, Formatter::FMT_C ) << endl << endl; // C
	
	// Output of other common items
	Point2f P(5, 1);
	cout << "Point (2D) = " << P << endl << endl; // 2D point
	
	Point3f P3f(2, 6, 7);
	cout << "Point (3D) = " << P3f << endl << endl; // 3D point
	
	vector<float> v;
	v.push_back( (float)CV_PI); v.push_back(2); v.push_back(3.01f);
	cout << "Vector of floats via Mat = " << Mat(v) << endl << endl; // std::vector via cv::Mat
	
	vector<Point2f> vPoints(20);
	for (size_t i = 0; i < vPoints.size(); ++i)
		vPoints[i] = Point2f((float)(i * 5), (float)(i % 7));
	cout << "A vector of 2D Points = " << vPoints << endl << endl; // std::vector points
	
	return 0;
}

