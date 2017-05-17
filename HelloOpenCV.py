#!/usr/bin/env python3
# -*- coding: utf-8 -*-
#
#  HelloOpenCV.py
#  
#  Copyright 2017  <baqwas(at)gmail(dot)com>
#  
#  This program is free software; you can redistribute it and/or modify
#  it under the terms of the GNU General Public License as published by
#  the Free Software Foundation; either version 2 of the License, or
#  (at your option) any later version.
#  
#  This program is distributed in the hope that it will be useful,
#  but WITHOUT ANY WARRANTY; without even the implied warranty of
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#  GNU General Public License for more details.
#  
#  You should have received a copy of the GNU General Public License
#  along with this program; if not, write to the Free Software
#  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
#  MA 02110-1301, USA.
#  
#  

import cv2
import numpy as np

def HelloOpenCV(filename):
	myImage = cv2.imread(filename, 0) # load a color image in grayscale
	cv2.namedWindow(filename, cv2.WINDOW_NORMAL)
	cv2.imshow(filename, myImage)
	cv2.waitKey(0)
	cv2.destroyAllWindows()
	return 0

if __name__ == '__main__':
	imgFile = 'default.png'
	HelloOpenCV(imgFile)

