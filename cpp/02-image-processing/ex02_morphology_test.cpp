/**
 * @file ex02_morphology_test.cpp
 * @brief Exercise 04: Morphological Operations (`cv::erode`, `cv::dilate`, `cv::morphologyEx`)
 *
 * @version 1.0.0
 * @date 2026-08-15
 * @author Matha Goram
 *
 * @copyright MIT License
 * Copyright (c) 2026 ParkCircus Productions. All Rights Reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * @par Purpose
 * Demonstrates advanced binary and grayscale morphological operations used for shape analysis,
 * noise removal, object separation, and structural gap-filling in computer vision pipelines.
 *
 * @par Processing Workflow
 * 1. Load source image matrix (`output_live_snap.png`) in grayscale format.
 * 2. Apply binary thresholding to prepare a clean segmentation mask.
 * 3. Define a rectangular structuring kernel using `cv::getStructuringElement`.
 * 4. Perform Erosion to shrink boundaries and eliminate small isolated noise spots.
 * 5. Perform Dilation to expand boundaries and bridge foreground gaps.
 * 6. Execute Opening (erosion followed by dilation) to remove external noise.
 * 7. Execute Closing (dilation followed by erosion) to close interior holes.
 * 8. Serialize all resulting matrices to disk for remote cluster verification.
 */

#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>

int main() {
    const std::string ex_prefix = "Ex 02 - Morphology";
    const std::string input_filename = "output_live_snap.png";

    std::cout << "[" << ex_prefix << "] 🧬 Loading source image for morphological processing...\n";

    cv::Mat src = cv::imread(input_filename, cv::IMREAD_GRAYSCALE);
    if (src.empty()) {
        std::cerr << "[" << ex_prefix << "] ❌ ERROR: Could not load " << input_filename << ". Ensure Chapter 1 capture was executed.\n";
        return EXIT_FAILURE;
    }

    // 1. Thresholding to create a binary mask
    cv::Mat bin;
    cv::threshold(src, bin, 128, 255, cv::THRESH_BINARY);
    cv::imwrite("output_binary.png", bin);

    // 2. Define structuring element (kernel)
    cv::Mat element = cv::getStructuringElement(cv::MORPH_RECT, cv::Size(3, 3));

    cv::Mat eroded, dilated, opened, closed;

    // 3. Erosion
    cv::erode(bin, eroded, element);
    cv::imwrite("output_eroded.png", eroded);

    // 4. Dilation
    cv::dilate(bin, dilated, element);
    cv::imwrite("output_dilated.png", dilated);

    // 5. Opening (Erosion followed by Dilation)
    cv::morphologyEx(bin, opened, cv::MORPH_OPEN, element);
    cv::imwrite("output_opened.png", opened);

    // 6. Closing (Dilation followed by Erosion)
    cv::morphologyEx(bin, closed, cv::MORPH_CLOSE, element);
    cv::imwrite("output_closed.png", closed);

    std::cout << "[" << ex_prefix << "] ✅ Morphological operations completed successfully (Erode, Dilate, Open, Close).\n";
    return EXIT_SUCCESS;
}
