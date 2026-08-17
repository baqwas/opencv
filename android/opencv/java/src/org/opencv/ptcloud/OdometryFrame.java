//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.ptcloud;

import org.opencv.core.Mat;

// C++: class OdometryFrame
/**
 * An object that keeps per-frame data for Odometry algorithms from user-provided images to algorithm-specific precalculated data.
 * When not empty, it contains a depth image, a mask of valid pixels and a set of pyramids generated from that data.
 * A BGR/Gray image and normals are optional.
 * OdometryFrame is made to be used together with Odometry class to reuse precalculated data between Rt data calculations.
 * A correct way to do that is to call Odometry::prepareFrames() on prev and next frames and then pass them to Odometry::compute() method.
 */
public class OdometryFrame {

    protected final long nativeObj;
    protected OdometryFrame(long addr) {
      nativeObj = addr;

    }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static OdometryFrame __fromPtr__(long addr) { return new OdometryFrame(addr); }

    //
    // C++:   cv::OdometryFrame::OdometryFrame(Mat depth = Mat(), Mat image = Mat(), Mat mask = Mat(), Mat normals = Mat())
    //

    /**
     * Construct a new OdometryFrame object. All non-empty images should have the same size.
     *
     * @param depth A depth image, should be CV_8UC1
     * @param image An BGR or grayscale image (or noArray() if it's not required for used ICP algorithm).
     * Should be CV_8UC3 or CV_8C4 if it's BGR image or CV_8UC1 if it's grayscale. If it's BGR then it's converted to grayscale
     * image automatically.
     * @param mask A user-provided mask of valid pixels, should be CV_8UC1
     * @param normals A user-provided normals to the depth surface, should be CV_32FC4
     */
    public OdometryFrame(Mat depth, Mat image, Mat mask, Mat normals) {
        nativeObj = OdometryFrame_0(depth.nativeObj, image.nativeObj, mask.nativeObj, normals.nativeObj);
    }

    /**
     * Construct a new OdometryFrame object. All non-empty images should have the same size.
     *
     * @param depth A depth image, should be CV_8UC1
     * @param image An BGR or grayscale image (or noArray() if it's not required for used ICP algorithm).
     * Should be CV_8UC3 or CV_8C4 if it's BGR image or CV_8UC1 if it's grayscale. If it's BGR then it's converted to grayscale
     * image automatically.
     * @param mask A user-provided mask of valid pixels, should be CV_8UC1
     */
    public OdometryFrame(Mat depth, Mat image, Mat mask) {
        nativeObj = OdometryFrame_1(depth.nativeObj, image.nativeObj, mask.nativeObj);
    }

    /**
     * Construct a new OdometryFrame object. All non-empty images should have the same size.
     *
     * @param depth A depth image, should be CV_8UC1
     * @param image An BGR or grayscale image (or noArray() if it's not required for used ICP algorithm).
     * Should be CV_8UC3 or CV_8C4 if it's BGR image or CV_8UC1 if it's grayscale. If it's BGR then it's converted to grayscale
     * image automatically.
     */
    public OdometryFrame(Mat depth, Mat image) {
        nativeObj = OdometryFrame_2(depth.nativeObj, image.nativeObj);
    }

    /**
     * Construct a new OdometryFrame object. All non-empty images should have the same size.
     *
     * @param depth A depth image, should be CV_8UC1
     * Should be CV_8UC3 or CV_8C4 if it's BGR image or CV_8UC1 if it's grayscale. If it's BGR then it's converted to grayscale
     * image automatically.
     */
    public OdometryFrame(Mat depth) {
        nativeObj = OdometryFrame_3(depth.nativeObj);
    }

    /**
     * Construct a new OdometryFrame object. All non-empty images should have the same size.
     *
     * Should be CV_8UC3 or CV_8C4 if it's BGR image or CV_8UC1 if it's grayscale. If it's BGR then it's converted to grayscale
     * image automatically.
     */
    public OdometryFrame() {
        nativeObj = OdometryFrame_4();
    }


    //
    // C++:  void cv::OdometryFrame::getImage(Mat& image)
    //

    /**
     * Get the original user-provided BGR/Gray image
     *
     * @param image Output image
     */
    public void getImage(Mat image) {
        getImage_0(nativeObj, image.nativeObj);
    }


    //
    // C++:  void cv::OdometryFrame::getGrayImage(Mat& image)
    //

    /**
     * Get the gray image generated from the user-provided BGR/Gray image
     *
     * @param image Output image
     */
    public void getGrayImage(Mat image) {
        getGrayImage_0(nativeObj, image.nativeObj);
    }


    //
    // C++:  void cv::OdometryFrame::getDepth(Mat& depth)
    //

    /**
     * Get the original user-provided depth image
     *
     * @param depth Output image
     */
    public void getDepth(Mat depth) {
        getDepth_0(nativeObj, depth.nativeObj);
    }


    //
    // C++:  void cv::OdometryFrame::getProcessedDepth(Mat& depth)
    //

    /**
     * Get the depth image generated from the user-provided one after conversion, rescale or filtering for ICP algorithm needs
     *
     * @param depth Output image
     */
    public void getProcessedDepth(Mat depth) {
        getProcessedDepth_0(nativeObj, depth.nativeObj);
    }


    //
    // C++:  void cv::OdometryFrame::getMask(Mat& mask)
    //

    /**
     * Get the valid pixels mask generated for the ICP calculations intersected with the user-provided mask
     *
     * @param mask Output image
     */
    public void getMask(Mat mask) {
        getMask_0(nativeObj, mask.nativeObj);
    }


    //
    // C++:  void cv::OdometryFrame::getNormals(Mat& normals)
    //

    /**
     * Get the normals image either generated for the ICP calculations or user-provided
     *
     * @param normals Output image
     */
    public void getNormals(Mat normals) {
        getNormals_0(nativeObj, normals.nativeObj);
    }


    //
    // C++:  int cv::OdometryFrame::getPyramidLevels()
    //

    /**
     * Get the amount of levels in pyramids (all of them if not empty should have the same number of levels)
     * or 0 if no pyramids were prepared yet
     * @return automatically generated
     */
    public int getPyramidLevels() {
        return getPyramidLevels_0(nativeObj);
    }


    //
    // C++:  void cv::OdometryFrame::getPyramidAt(Mat& img, OdometryFramePyramidType pyrType, size_t level)
    //

    /**
     * Get the image generated for the ICP calculations from one of the pyramids specified by pyrType. Returns empty image if
     * the pyramid is empty or there's no such pyramid level
     *
     * @param img Output image
     * @param pyrType Type of pyramid
     * @param level Level in the pyramid
     */
    public void getPyramidAt(Mat img, int pyrType, long level) {
        getPyramidAt_0(nativeObj, img.nativeObj, pyrType, level);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::OdometryFrame::OdometryFrame(Mat depth = Mat(), Mat image = Mat(), Mat mask = Mat(), Mat normals = Mat())
    private static native long OdometryFrame_0(long depth_nativeObj, long image_nativeObj, long mask_nativeObj, long normals_nativeObj);
    private static native long OdometryFrame_1(long depth_nativeObj, long image_nativeObj, long mask_nativeObj);
    private static native long OdometryFrame_2(long depth_nativeObj, long image_nativeObj);
    private static native long OdometryFrame_3(long depth_nativeObj);
    private static native long OdometryFrame_4();

    // C++:  void cv::OdometryFrame::getImage(Mat& image)
    private static native void getImage_0(long nativeObj, long image_nativeObj);

    // C++:  void cv::OdometryFrame::getGrayImage(Mat& image)
    private static native void getGrayImage_0(long nativeObj, long image_nativeObj);

    // C++:  void cv::OdometryFrame::getDepth(Mat& depth)
    private static native void getDepth_0(long nativeObj, long depth_nativeObj);

    // C++:  void cv::OdometryFrame::getProcessedDepth(Mat& depth)
    private static native void getProcessedDepth_0(long nativeObj, long depth_nativeObj);

    // C++:  void cv::OdometryFrame::getMask(Mat& mask)
    private static native void getMask_0(long nativeObj, long mask_nativeObj);

    // C++:  void cv::OdometryFrame::getNormals(Mat& normals)
    private static native void getNormals_0(long nativeObj, long normals_nativeObj);

    // C++:  int cv::OdometryFrame::getPyramidLevels()
    private static native int getPyramidLevels_0(long nativeObj);

    // C++:  void cv::OdometryFrame::getPyramidAt(Mat& img, OdometryFramePyramidType pyrType, size_t level)
    private static native void getPyramidAt_0(long nativeObj, long img_nativeObj, int pyrType, long level);

    // native support for java finalize() or cleaner
    private static native void delete(long nativeObj);

}
