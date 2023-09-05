#!/usr/bin/env python3
# -*- coding: utf-8 -*-
#
#  displayimage.py
#  
#  Copyright 2023  <parkcircus@raspbari4>
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
#  Reference
#   
import cv2 as cv
import sys

def main(args):
    img = cv.imread(cv.samples.findFile("displayimage.jpg"))
    if img is None:
        sys.exit("Could not read the image.")
    cv.imshow("Display window", img)
    k = cv.waitKey(0)
    if k == ord("s"):
        cv.imwrite("test.png", img)
    return 0

if __name__ == '__main__':
    import sys
    sys.exit(main(sys.argv))
