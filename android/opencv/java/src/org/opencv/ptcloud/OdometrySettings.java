//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.ptcloud;

import org.opencv.core.Mat;

// C++: class OdometrySettings

public class OdometrySettings {

    protected final long nativeObj;
    protected OdometrySettings(long addr) {
      nativeObj = addr;

    }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static OdometrySettings __fromPtr__(long addr) { return new OdometrySettings(addr); }

    //
    // C++:   cv::OdometrySettings::OdometrySettings()
    //

    public OdometrySettings() {
        nativeObj = OdometrySettings_0();
    }


    //
    // C++:  void cv::OdometrySettings::setCameraMatrix(Mat val)
    //

    public void setCameraMatrix(Mat val) {
        setCameraMatrix_0(nativeObj, val.nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::getCameraMatrix(Mat& val)
    //

    public void getCameraMatrix(Mat val) {
        getCameraMatrix_0(nativeObj, val.nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::setIterCounts(Mat val)
    //

    public void setIterCounts(Mat val) {
        setIterCounts_0(nativeObj, val.nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::getIterCounts(Mat& val)
    //

    public void getIterCounts(Mat val) {
        getIterCounts_0(nativeObj, val.nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::setMinDepth(float val)
    //

    public void setMinDepth(float val) {
        setMinDepth_0(nativeObj, val);
    }


    //
    // C++:  float cv::OdometrySettings::getMinDepth()
    //

    public float getMinDepth() {
        return getMinDepth_0(nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::setMaxDepth(float val)
    //

    public void setMaxDepth(float val) {
        setMaxDepth_0(nativeObj, val);
    }


    //
    // C++:  float cv::OdometrySettings::getMaxDepth()
    //

    public float getMaxDepth() {
        return getMaxDepth_0(nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::setMaxDepthDiff(float val)
    //

    public void setMaxDepthDiff(float val) {
        setMaxDepthDiff_0(nativeObj, val);
    }


    //
    // C++:  float cv::OdometrySettings::getMaxDepthDiff()
    //

    public float getMaxDepthDiff() {
        return getMaxDepthDiff_0(nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::setMaxPointsPart(float val)
    //

    public void setMaxPointsPart(float val) {
        setMaxPointsPart_0(nativeObj, val);
    }


    //
    // C++:  float cv::OdometrySettings::getMaxPointsPart()
    //

    public float getMaxPointsPart() {
        return getMaxPointsPart_0(nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::setSobelSize(int val)
    //

    public void setSobelSize(int val) {
        setSobelSize_0(nativeObj, val);
    }


    //
    // C++:  int cv::OdometrySettings::getSobelSize()
    //

    public int getSobelSize() {
        return getSobelSize_0(nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::setSobelScale(double val)
    //

    public void setSobelScale(double val) {
        setSobelScale_0(nativeObj, val);
    }


    //
    // C++:  double cv::OdometrySettings::getSobelScale()
    //

    public double getSobelScale() {
        return getSobelScale_0(nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::setNormalWinSize(int val)
    //

    public void setNormalWinSize(int val) {
        setNormalWinSize_0(nativeObj, val);
    }


    //
    // C++:  int cv::OdometrySettings::getNormalWinSize()
    //

    public int getNormalWinSize() {
        return getNormalWinSize_0(nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::setNormalDiffThreshold(float val)
    //

    public void setNormalDiffThreshold(float val) {
        setNormalDiffThreshold_0(nativeObj, val);
    }


    //
    // C++:  float cv::OdometrySettings::getNormalDiffThreshold()
    //

    public float getNormalDiffThreshold() {
        return getNormalDiffThreshold_0(nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::setNormalMethod(RgbdNormals_RgbdNormalsMethod nm)
    //

    public void setNormalMethod(int nm) {
        setNormalMethod_0(nativeObj, nm);
    }


    //
    // C++:  RgbdNormals_RgbdNormalsMethod cv::OdometrySettings::getNormalMethod()
    //

    public int getNormalMethod() {
        return getNormalMethod_0(nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::setAngleThreshold(float val)
    //

    public void setAngleThreshold(float val) {
        setAngleThreshold_0(nativeObj, val);
    }


    //
    // C++:  float cv::OdometrySettings::getAngleThreshold()
    //

    public float getAngleThreshold() {
        return getAngleThreshold_0(nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::setMaxTranslation(float val)
    //

    public void setMaxTranslation(float val) {
        setMaxTranslation_0(nativeObj, val);
    }


    //
    // C++:  float cv::OdometrySettings::getMaxTranslation()
    //

    public float getMaxTranslation() {
        return getMaxTranslation_0(nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::setMaxRotation(float val)
    //

    public void setMaxRotation(float val) {
        setMaxRotation_0(nativeObj, val);
    }


    //
    // C++:  float cv::OdometrySettings::getMaxRotation()
    //

    public float getMaxRotation() {
        return getMaxRotation_0(nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::setMinGradientMagnitude(float val)
    //

    public void setMinGradientMagnitude(float val) {
        setMinGradientMagnitude_0(nativeObj, val);
    }


    //
    // C++:  float cv::OdometrySettings::getMinGradientMagnitude()
    //

    public float getMinGradientMagnitude() {
        return getMinGradientMagnitude_0(nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::setMinGradientMagnitudes(Mat val)
    //

    public void setMinGradientMagnitudes(Mat val) {
        setMinGradientMagnitudes_0(nativeObj, val.nativeObj);
    }


    //
    // C++:  void cv::OdometrySettings::getMinGradientMagnitudes(Mat& val)
    //

    public void getMinGradientMagnitudes(Mat val) {
        getMinGradientMagnitudes_0(nativeObj, val.nativeObj);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::OdometrySettings::OdometrySettings()
    private static native long OdometrySettings_0();

    // C++:  void cv::OdometrySettings::setCameraMatrix(Mat val)
    private static native void setCameraMatrix_0(long nativeObj, long val_nativeObj);

    // C++:  void cv::OdometrySettings::getCameraMatrix(Mat& val)
    private static native void getCameraMatrix_0(long nativeObj, long val_nativeObj);

    // C++:  void cv::OdometrySettings::setIterCounts(Mat val)
    private static native void setIterCounts_0(long nativeObj, long val_nativeObj);

    // C++:  void cv::OdometrySettings::getIterCounts(Mat& val)
    private static native void getIterCounts_0(long nativeObj, long val_nativeObj);

    // C++:  void cv::OdometrySettings::setMinDepth(float val)
    private static native void setMinDepth_0(long nativeObj, float val);

    // C++:  float cv::OdometrySettings::getMinDepth()
    private static native float getMinDepth_0(long nativeObj);

    // C++:  void cv::OdometrySettings::setMaxDepth(float val)
    private static native void setMaxDepth_0(long nativeObj, float val);

    // C++:  float cv::OdometrySettings::getMaxDepth()
    private static native float getMaxDepth_0(long nativeObj);

    // C++:  void cv::OdometrySettings::setMaxDepthDiff(float val)
    private static native void setMaxDepthDiff_0(long nativeObj, float val);

    // C++:  float cv::OdometrySettings::getMaxDepthDiff()
    private static native float getMaxDepthDiff_0(long nativeObj);

    // C++:  void cv::OdometrySettings::setMaxPointsPart(float val)
    private static native void setMaxPointsPart_0(long nativeObj, float val);

    // C++:  float cv::OdometrySettings::getMaxPointsPart()
    private static native float getMaxPointsPart_0(long nativeObj);

    // C++:  void cv::OdometrySettings::setSobelSize(int val)
    private static native void setSobelSize_0(long nativeObj, int val);

    // C++:  int cv::OdometrySettings::getSobelSize()
    private static native int getSobelSize_0(long nativeObj);

    // C++:  void cv::OdometrySettings::setSobelScale(double val)
    private static native void setSobelScale_0(long nativeObj, double val);

    // C++:  double cv::OdometrySettings::getSobelScale()
    private static native double getSobelScale_0(long nativeObj);

    // C++:  void cv::OdometrySettings::setNormalWinSize(int val)
    private static native void setNormalWinSize_0(long nativeObj, int val);

    // C++:  int cv::OdometrySettings::getNormalWinSize()
    private static native int getNormalWinSize_0(long nativeObj);

    // C++:  void cv::OdometrySettings::setNormalDiffThreshold(float val)
    private static native void setNormalDiffThreshold_0(long nativeObj, float val);

    // C++:  float cv::OdometrySettings::getNormalDiffThreshold()
    private static native float getNormalDiffThreshold_0(long nativeObj);

    // C++:  void cv::OdometrySettings::setNormalMethod(RgbdNormals_RgbdNormalsMethod nm)
    private static native void setNormalMethod_0(long nativeObj, int nm);

    // C++:  RgbdNormals_RgbdNormalsMethod cv::OdometrySettings::getNormalMethod()
    private static native int getNormalMethod_0(long nativeObj);

    // C++:  void cv::OdometrySettings::setAngleThreshold(float val)
    private static native void setAngleThreshold_0(long nativeObj, float val);

    // C++:  float cv::OdometrySettings::getAngleThreshold()
    private static native float getAngleThreshold_0(long nativeObj);

    // C++:  void cv::OdometrySettings::setMaxTranslation(float val)
    private static native void setMaxTranslation_0(long nativeObj, float val);

    // C++:  float cv::OdometrySettings::getMaxTranslation()
    private static native float getMaxTranslation_0(long nativeObj);

    // C++:  void cv::OdometrySettings::setMaxRotation(float val)
    private static native void setMaxRotation_0(long nativeObj, float val);

    // C++:  float cv::OdometrySettings::getMaxRotation()
    private static native float getMaxRotation_0(long nativeObj);

    // C++:  void cv::OdometrySettings::setMinGradientMagnitude(float val)
    private static native void setMinGradientMagnitude_0(long nativeObj, float val);

    // C++:  float cv::OdometrySettings::getMinGradientMagnitude()
    private static native float getMinGradientMagnitude_0(long nativeObj);

    // C++:  void cv::OdometrySettings::setMinGradientMagnitudes(Mat val)
    private static native void setMinGradientMagnitudes_0(long nativeObj, long val_nativeObj);

    // C++:  void cv::OdometrySettings::getMinGradientMagnitudes(Mat& val)
    private static native void getMinGradientMagnitudes_0(long nativeObj, long val_nativeObj);

    // native support for java finalize() or cleaner
    private static native void delete(long nativeObj);

}
