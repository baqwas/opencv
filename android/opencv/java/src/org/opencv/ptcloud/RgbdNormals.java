//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.ptcloud;

import org.opencv.core.Mat;
import org.opencv.ptcloud.RgbdNormals;

// C++: class RgbdNormals
/**
 * Object that can compute the normals in an image.
 * It is an object as it can cache data for speed efficiency
 * The implemented methods are either:
 * - FALS (the fastest) and SRI from
 * {@code }Fast and Accurate Computation of Surface Normals from Range Images{@code }
 * by H. Badino, D. Huber, Y. Park and T. Kanade
 * - the normals with bilateral filtering on a depth image from
 * {@code }Gradient Response Maps for Real-Time Detection of Texture-Less Objects{@code }
 * by S. Hinterstoisser, C. Cagniart, S. Ilic, P. Sturm, N. Navab, P. Fua, and V. Lepetit
 */
public class RgbdNormals {

    protected final long nativeObj;
    protected RgbdNormals(long addr) {
      nativeObj = addr;

    }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static RgbdNormals __fromPtr__(long addr) { return new RgbdNormals(addr); }

    // C++: enum RgbdNormalsMethod (cv.RgbdNormals.RgbdNormalsMethod)
    public static final int
            RGBD_NORMALS_METHOD_FALS = 0,
            RGBD_NORMALS_METHOD_LINEMOD = 1,
            RGBD_NORMALS_METHOD_SRI = 2,
            RGBD_NORMALS_METHOD_CROSS_PRODUCT = 3;


    //
    // C++: static Ptr_RgbdNormals cv::RgbdNormals::create(int rows = 0, int cols = 0, int depth = 0, Mat K = Mat(), int window_size = 5, float diff_threshold = 50.f, RgbdNormals_RgbdNormalsMethod method = RgbdNormals::RgbdNormalsMethod::RGBD_NORMALS_METHOD_FALS)
    //

    /**
     * Creates new RgbdNormals object
     * @param rows the number of rows of the depth image normals will be computed on
     * @param cols the number of cols of the depth image normals will be computed on
     * @param depth the depth of the normals (only CV_32F or CV_64F)
     * @param K the calibration matrix to use
     * @param window_size the window size to compute the normals: can only be 1,3,5 or 7
     * @param diff_threshold threshold in depth difference, used in LINEMOD algirithm
     * @param method one of the methods to use: RGBD_NORMALS_METHOD_SRI, RGBD_NORMALS_METHOD_FALS
     * @return automatically generated
     */
    public static RgbdNormals create(int rows, int cols, int depth, Mat K, int window_size, float diff_threshold, int method) {
        return RgbdNormals.__fromPtr__(create_0(rows, cols, depth, K.nativeObj, window_size, diff_threshold, method));
    }

    /**
     * Creates new RgbdNormals object
     * @param rows the number of rows of the depth image normals will be computed on
     * @param cols the number of cols of the depth image normals will be computed on
     * @param depth the depth of the normals (only CV_32F or CV_64F)
     * @param K the calibration matrix to use
     * @param window_size the window size to compute the normals: can only be 1,3,5 or 7
     * @param diff_threshold threshold in depth difference, used in LINEMOD algirithm
     * @return automatically generated
     */
    public static RgbdNormals create(int rows, int cols, int depth, Mat K, int window_size, float diff_threshold) {
        return RgbdNormals.__fromPtr__(create_1(rows, cols, depth, K.nativeObj, window_size, diff_threshold));
    }

    /**
     * Creates new RgbdNormals object
     * @param rows the number of rows of the depth image normals will be computed on
     * @param cols the number of cols of the depth image normals will be computed on
     * @param depth the depth of the normals (only CV_32F or CV_64F)
     * @param K the calibration matrix to use
     * @param window_size the window size to compute the normals: can only be 1,3,5 or 7
     * @return automatically generated
     */
    public static RgbdNormals create(int rows, int cols, int depth, Mat K, int window_size) {
        return RgbdNormals.__fromPtr__(create_2(rows, cols, depth, K.nativeObj, window_size));
    }

    /**
     * Creates new RgbdNormals object
     * @param rows the number of rows of the depth image normals will be computed on
     * @param cols the number of cols of the depth image normals will be computed on
     * @param depth the depth of the normals (only CV_32F or CV_64F)
     * @param K the calibration matrix to use
     * @return automatically generated
     */
    public static RgbdNormals create(int rows, int cols, int depth, Mat K) {
        return RgbdNormals.__fromPtr__(create_3(rows, cols, depth, K.nativeObj));
    }

    /**
     * Creates new RgbdNormals object
     * @param rows the number of rows of the depth image normals will be computed on
     * @param cols the number of cols of the depth image normals will be computed on
     * @param depth the depth of the normals (only CV_32F or CV_64F)
     * @return automatically generated
     */
    public static RgbdNormals create(int rows, int cols, int depth) {
        return RgbdNormals.__fromPtr__(create_4(rows, cols, depth));
    }

    /**
     * Creates new RgbdNormals object
     * @param rows the number of rows of the depth image normals will be computed on
     * @param cols the number of cols of the depth image normals will be computed on
     * @return automatically generated
     */
    public static RgbdNormals create(int rows, int cols) {
        return RgbdNormals.__fromPtr__(create_5(rows, cols));
    }

    /**
     * Creates new RgbdNormals object
     * @param rows the number of rows of the depth image normals will be computed on
     * @return automatically generated
     */
    public static RgbdNormals create(int rows) {
        return RgbdNormals.__fromPtr__(create_6(rows));
    }

    /**
     * Creates new RgbdNormals object
     * @return automatically generated
     */
    public static RgbdNormals create() {
        return RgbdNormals.__fromPtr__(create_7());
    }


    //
    // C++:  void cv::RgbdNormals::apply(Mat points, Mat& normals)
    //

    /**
     * Given a set of 3d points in a depth image, compute the normals at each point.
     * @param points a rows x cols x 3 matrix of CV_32F/CV64F or a rows x cols x 1 CV_U16S
     * @param normals a rows x cols x 3 matrix
     */
    public void apply(Mat points, Mat normals) {
        apply_0(nativeObj, points.nativeObj, normals.nativeObj);
    }


    //
    // C++:  void cv::RgbdNormals::cache()
    //

    /**
     * Prepares cached data required for calculation
     * If not called by user, called automatically at first calculation
     */
    public void cache() {
        cache_0(nativeObj);
    }


    //
    // C++:  int cv::RgbdNormals::getRows()
    //

    public int getRows() {
        return getRows_0(nativeObj);
    }


    //
    // C++:  void cv::RgbdNormals::setRows(int val)
    //

    public void setRows(int val) {
        setRows_0(nativeObj, val);
    }


    //
    // C++:  int cv::RgbdNormals::getCols()
    //

    public int getCols() {
        return getCols_0(nativeObj);
    }


    //
    // C++:  void cv::RgbdNormals::setCols(int val)
    //

    public void setCols(int val) {
        setCols_0(nativeObj, val);
    }


    //
    // C++:  int cv::RgbdNormals::getWindowSize()
    //

    public int getWindowSize() {
        return getWindowSize_0(nativeObj);
    }


    //
    // C++:  void cv::RgbdNormals::setWindowSize(int val)
    //

    public void setWindowSize(int val) {
        setWindowSize_0(nativeObj, val);
    }


    //
    // C++:  int cv::RgbdNormals::getDepth()
    //

    public int getDepth() {
        return getDepth_0(nativeObj);
    }


    //
    // C++:  void cv::RgbdNormals::getK(Mat& val)
    //

    public void getK(Mat val) {
        getK_0(nativeObj, val.nativeObj);
    }


    //
    // C++:  void cv::RgbdNormals::setK(Mat val)
    //

    public void setK(Mat val) {
        setK_0(nativeObj, val.nativeObj);
    }


    //
    // C++:  RgbdNormals_RgbdNormalsMethod cv::RgbdNormals::getMethod()
    //

    public int getMethod() {
        return getMethod_0(nativeObj);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++: static Ptr_RgbdNormals cv::RgbdNormals::create(int rows = 0, int cols = 0, int depth = 0, Mat K = Mat(), int window_size = 5, float diff_threshold = 50.f, RgbdNormals_RgbdNormalsMethod method = RgbdNormals::RgbdNormalsMethod::RGBD_NORMALS_METHOD_FALS)
    private static native long create_0(int rows, int cols, int depth, long K_nativeObj, int window_size, float diff_threshold, int method);
    private static native long create_1(int rows, int cols, int depth, long K_nativeObj, int window_size, float diff_threshold);
    private static native long create_2(int rows, int cols, int depth, long K_nativeObj, int window_size);
    private static native long create_3(int rows, int cols, int depth, long K_nativeObj);
    private static native long create_4(int rows, int cols, int depth);
    private static native long create_5(int rows, int cols);
    private static native long create_6(int rows);
    private static native long create_7();

    // C++:  void cv::RgbdNormals::apply(Mat points, Mat& normals)
    private static native void apply_0(long nativeObj, long points_nativeObj, long normals_nativeObj);

    // C++:  void cv::RgbdNormals::cache()
    private static native void cache_0(long nativeObj);

    // C++:  int cv::RgbdNormals::getRows()
    private static native int getRows_0(long nativeObj);

    // C++:  void cv::RgbdNormals::setRows(int val)
    private static native void setRows_0(long nativeObj, int val);

    // C++:  int cv::RgbdNormals::getCols()
    private static native int getCols_0(long nativeObj);

    // C++:  void cv::RgbdNormals::setCols(int val)
    private static native void setCols_0(long nativeObj, int val);

    // C++:  int cv::RgbdNormals::getWindowSize()
    private static native int getWindowSize_0(long nativeObj);

    // C++:  void cv::RgbdNormals::setWindowSize(int val)
    private static native void setWindowSize_0(long nativeObj, int val);

    // C++:  int cv::RgbdNormals::getDepth()
    private static native int getDepth_0(long nativeObj);

    // C++:  void cv::RgbdNormals::getK(Mat& val)
    private static native void getK_0(long nativeObj, long val_nativeObj);

    // C++:  void cv::RgbdNormals::setK(Mat val)
    private static native void setK_0(long nativeObj, long val_nativeObj);

    // C++:  RgbdNormals_RgbdNormalsMethod cv::RgbdNormals::getMethod()
    private static native int getMethod_0(long nativeObj);

    // native support for java finalize() or cleaner
    private static native void delete(long nativeObj);

}
