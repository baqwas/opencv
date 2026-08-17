//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.ptcloud;

import org.opencv.core.Mat;
import org.opencv.ptcloud.OdometryFrame;
import org.opencv.ptcloud.OdometrySettings;
import org.opencv.ptcloud.RgbdNormals;

// C++: class Odometry

public class Odometry {

    protected final long nativeObj;
    protected Odometry(long addr) {
      nativeObj = addr;

    }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static Odometry __fromPtr__(long addr) { return new Odometry(addr); }

    //
    // C++:   cv::Odometry::Odometry()
    //

    public Odometry() {
        nativeObj = Odometry_0();
    }


    //
    // C++:   cv::Odometry::Odometry(OdometryType otype)
    //

    public Odometry(int otype) {
        nativeObj = Odometry_1(otype);
    }


    //
    // C++:   cv::Odometry::Odometry(OdometryType otype, OdometrySettings settings, OdometryAlgoType algtype)
    //

    public Odometry(int otype, OdometrySettings settings, int algtype) {
        nativeObj = Odometry_2(otype, settings.getNativeObjAddr(), algtype);
    }


    //
    // C++:  void cv::Odometry::prepareFrame(OdometryFrame frame)
    //

    /**
     * Prepare frame for odometry calculation
     * @param frame odometry prepare this frame as src frame and dst frame simultaneously
     */
    public void prepareFrame(OdometryFrame frame) {
        prepareFrame_0(nativeObj, frame.getNativeObjAddr());
    }


    //
    // C++:  void cv::Odometry::prepareFrames(OdometryFrame srcFrame, OdometryFrame dstFrame)
    //

    /**
     * Prepare frame for odometry calculation
     * @param srcFrame frame will be prepared as src frame ("original" image)
     * @param dstFrame frame will be prepared as dsr frame ("rotated" image)
     */
    public void prepareFrames(OdometryFrame srcFrame, OdometryFrame dstFrame) {
        prepareFrames_0(nativeObj, srcFrame.getNativeObjAddr(), dstFrame.getNativeObjAddr());
    }


    //
    // C++:  bool cv::Odometry::compute(OdometryFrame srcFrame, OdometryFrame dstFrame, Mat& Rt)
    //

    /**
     * Compute Rigid Transformation between two frames so that Rt * src = dst
     * Both frames, source and destination, should have been prepared by calling prepareFrame() first
     *
     * @param srcFrame src frame ("original" image)
     * @param dstFrame dst frame ("rotated" image)
     * @param Rt Rigid transformation, which will be calculated, in form:
     * { R_11 R_12 R_13 t_1
     * R_21 R_22 R_23 t_2
     * R_31 R_32 R_33 t_3
     * 0    0    0    1  }
     * @return true on success, false if failed to find the transformation
     */
    public boolean compute(OdometryFrame srcFrame, OdometryFrame dstFrame, Mat Rt) {
        return compute_0(nativeObj, srcFrame.getNativeObjAddr(), dstFrame.getNativeObjAddr(), Rt.nativeObj);
    }


    //
    // C++:  bool cv::Odometry::compute(Mat srcDepth, Mat dstDepth, Mat& Rt)
    //

    /**
     * Compute Rigid Transformation between two frames so that Rt * src = dst
     *
     * @param srcDepth source depth ("original" image)
     * @param dstDepth destination depth ("rotated" image)
     * @param Rt Rigid transformation, which will be calculated, in form:
     * { R_11 R_12 R_13 t_1
     * R_21 R_22 R_23 t_2
     * R_31 R_32 R_33 t_3
     * 0    0    0    1  }
     * @return true on success, false if failed to find the transformation
     */
    public boolean compute(Mat srcDepth, Mat dstDepth, Mat Rt) {
        return compute_1(nativeObj, srcDepth.nativeObj, dstDepth.nativeObj, Rt.nativeObj);
    }


    //
    // C++:  bool cv::Odometry::compute(Mat srcDepth, Mat srcRGB, Mat dstDepth, Mat dstRGB, Mat& Rt)
    //

    /**
     * Compute Rigid Transformation between two frames so that Rt * src = dst
     *
     * @param srcDepth source depth ("original" image)
     * @param srcRGB source RGB
     * @param dstDepth destination depth ("rotated" image)
     * @param dstRGB destination RGB
     * @param Rt Rigid transformation, which will be calculated, in form:
     * { R_11 R_12 R_13 t_1
     * R_21 R_22 R_23 t_2
     * R_31 R_32 R_33 t_3
     * 0    0    0    1  }
     * @return true on success, false if failed to find the transformation
     */
    public boolean compute(Mat srcDepth, Mat srcRGB, Mat dstDepth, Mat dstRGB, Mat Rt) {
        return compute_2(nativeObj, srcDepth.nativeObj, srcRGB.nativeObj, dstDepth.nativeObj, dstRGB.nativeObj, Rt.nativeObj);
    }


    //
    // C++:  Ptr_RgbdNormals cv::Odometry::getNormalsComputer()
    //

    /**
     * Get the normals computer object used for normals calculation (if presented).
     * The normals computer is generated at first need during prepareFrame when normals are required for the ICP algorithm
     * but not presented by a user. Re-generated each time the related settings change or a new frame arrives with the different size.
     * @return automatically generated
     */
    public RgbdNormals getNormalsComputer() {
        return RgbdNormals.__fromPtr__(getNormalsComputer_0(nativeObj));
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::Odometry::Odometry()
    private static native long Odometry_0();

    // C++:   cv::Odometry::Odometry(OdometryType otype)
    private static native long Odometry_1(int otype);

    // C++:   cv::Odometry::Odometry(OdometryType otype, OdometrySettings settings, OdometryAlgoType algtype)
    private static native long Odometry_2(int otype, long settings_nativeObj, int algtype);

    // C++:  void cv::Odometry::prepareFrame(OdometryFrame frame)
    private static native void prepareFrame_0(long nativeObj, long frame_nativeObj);

    // C++:  void cv::Odometry::prepareFrames(OdometryFrame srcFrame, OdometryFrame dstFrame)
    private static native void prepareFrames_0(long nativeObj, long srcFrame_nativeObj, long dstFrame_nativeObj);

    // C++:  bool cv::Odometry::compute(OdometryFrame srcFrame, OdometryFrame dstFrame, Mat& Rt)
    private static native boolean compute_0(long nativeObj, long srcFrame_nativeObj, long dstFrame_nativeObj, long Rt_nativeObj);

    // C++:  bool cv::Odometry::compute(Mat srcDepth, Mat dstDepth, Mat& Rt)
    private static native boolean compute_1(long nativeObj, long srcDepth_nativeObj, long dstDepth_nativeObj, long Rt_nativeObj);

    // C++:  bool cv::Odometry::compute(Mat srcDepth, Mat srcRGB, Mat dstDepth, Mat dstRGB, Mat& Rt)
    private static native boolean compute_2(long nativeObj, long srcDepth_nativeObj, long srcRGB_nativeObj, long dstDepth_nativeObj, long dstRGB_nativeObj, long Rt_nativeObj);

    // C++:  Ptr_RgbdNormals cv::Odometry::getNormalsComputer()
    private static native long getNormalsComputer_0(long nativeObj);

    // native support for java finalize() or cleaner
    private static native void delete(long nativeObj);

}
