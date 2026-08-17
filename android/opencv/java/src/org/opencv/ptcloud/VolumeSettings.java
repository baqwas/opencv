//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.ptcloud;

import org.opencv.core.Mat;

// C++: class VolumeSettings

public class VolumeSettings {

    protected final long nativeObj;
    protected VolumeSettings(long addr) {
      nativeObj = addr;

    }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static VolumeSettings __fromPtr__(long addr) { return new VolumeSettings(addr); }

    //
    // C++:   cv::VolumeSettings::VolumeSettings(VolumeType volumeType = VolumeType::TSDF)
    //

    /**
     * Constructor of settings for custom Volume type.
     * @param volumeType volume type.
     */
    public VolumeSettings(int volumeType) {
        nativeObj = VolumeSettings_0(volumeType);
    }

    /**
     * Constructor of settings for custom Volume type.
     */
    public VolumeSettings() {
        nativeObj = VolumeSettings_1();
    }


    //
    // C++:  void cv::VolumeSettings::setIntegrateWidth(int val)
    //

    /**
     * Sets the width of the image for integration.
     * @param val input value.
     */
    public void setIntegrateWidth(int val) {
        setIntegrateWidth_0(nativeObj, val);
    }


    //
    // C++:  int cv::VolumeSettings::getIntegrateWidth()
    //

    /**
     * Returns the width of the image for integration.
     * @return automatically generated
     */
    public int getIntegrateWidth() {
        return getIntegrateWidth_0(nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::setIntegrateHeight(int val)
    //

    /**
     * Sets the height of the image for integration.
     * @param val input value.
     */
    public void setIntegrateHeight(int val) {
        setIntegrateHeight_0(nativeObj, val);
    }


    //
    // C++:  int cv::VolumeSettings::getIntegrateHeight()
    //

    /**
     * Returns the height of the image for integration.
     * @return automatically generated
     */
    public int getIntegrateHeight() {
        return getIntegrateHeight_0(nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::setRaycastWidth(int val)
    //

    /**
     * Sets the width of the raycasted image, used when user does not provide it at raycast() call.
     * @param val input value.
     */
    public void setRaycastWidth(int val) {
        setRaycastWidth_0(nativeObj, val);
    }


    //
    // C++:  int cv::VolumeSettings::getRaycastWidth()
    //

    /**
     * Returns the width of the raycasted image, used when user does not provide it at raycast() call.
     * @return automatically generated
     */
    public int getRaycastWidth() {
        return getRaycastWidth_0(nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::setRaycastHeight(int val)
    //

    /**
     * Sets the height of the raycasted image, used when user does not provide it at raycast() call.
     * @param val input value.
     */
    public void setRaycastHeight(int val) {
        setRaycastHeight_0(nativeObj, val);
    }


    //
    // C++:  int cv::VolumeSettings::getRaycastHeight()
    //

    /**
     * Returns the height of the raycasted image, used when user does not provide it at raycast() call.
     * @return automatically generated
     */
    public int getRaycastHeight() {
        return getRaycastHeight_0(nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::setDepthFactor(float val)
    //

    /**
     * Sets depth factor, witch is the number for depth scaling.
     * @param val input value.
     */
    public void setDepthFactor(float val) {
        setDepthFactor_0(nativeObj, val);
    }


    //
    // C++:  float cv::VolumeSettings::getDepthFactor()
    //

    /**
     * Returns depth factor, witch is the number for depth scaling.
     * @return automatically generated
     */
    public float getDepthFactor() {
        return getDepthFactor_0(nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::setVoxelSize(float val)
    //

    /**
     * Sets the size of voxel.
     * @param val input value.
     */
    public void setVoxelSize(float val) {
        setVoxelSize_0(nativeObj, val);
    }


    //
    // C++:  float cv::VolumeSettings::getVoxelSize()
    //

    /**
     * Returns the size of voxel.
     * @return automatically generated
     */
    public float getVoxelSize() {
        return getVoxelSize_0(nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::setTsdfTruncateDistance(float val)
    //

    /**
     * Sets TSDF truncation distance. Distances greater than value from surface will be truncated to 1.0.
     * @param val input value.
     */
    public void setTsdfTruncateDistance(float val) {
        setTsdfTruncateDistance_0(nativeObj, val);
    }


    //
    // C++:  float cv::VolumeSettings::getTsdfTruncateDistance()
    //

    /**
     * Returns TSDF truncation distance. Distances greater than value from surface will be truncated to 1.0.
     * @return automatically generated
     */
    public float getTsdfTruncateDistance() {
        return getTsdfTruncateDistance_0(nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::setMaxDepth(float val)
    //

    /**
     * Sets threshold for depth truncation in meters. Truncates the depth greater than threshold to 0.
     * @param val input value.
     */
    public void setMaxDepth(float val) {
        setMaxDepth_0(nativeObj, val);
    }


    //
    // C++:  float cv::VolumeSettings::getMaxDepth()
    //

    /**
     * Returns threshold for depth truncation in meters. Truncates the depth greater than threshold to 0.
     * @return automatically generated
     */
    public float getMaxDepth() {
        return getMaxDepth_0(nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::setMaxWeight(int val)
    //

    /**
     * Sets max number of frames to integrate per voxel.
     *         Represents the max number of frames over which a running average of the TSDF is calculated for a voxel.
     * @param val input value.
     */
    public void setMaxWeight(int val) {
        setMaxWeight_0(nativeObj, val);
    }


    //
    // C++:  int cv::VolumeSettings::getMaxWeight()
    //

    /**
     * Returns max number of frames to integrate per voxel.
     *         Represents the max number of frames over which a running average of the TSDF is calculated for a voxel.
     * @return automatically generated
     */
    public int getMaxWeight() {
        return getMaxWeight_0(nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::setRaycastStepFactor(float val)
    //

    /**
     * Sets length of single raycast step.
     *         Describes the percentage of voxel length that is skipped per march.
     * @param val input value.
     */
    public void setRaycastStepFactor(float val) {
        setRaycastStepFactor_0(nativeObj, val);
    }


    //
    // C++:  float cv::VolumeSettings::getRaycastStepFactor()
    //

    /**
     * Returns length of single raycast step.
     *         Describes the percentage of voxel length that is skipped per march.
     * @return automatically generated
     */
    public float getRaycastStepFactor() {
        return getRaycastStepFactor_0(nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::setVolumePose(Mat val)
    //

    /**
     * Sets volume pose.
     * @param val input value.
     */
    public void setVolumePose(Mat val) {
        setVolumePose_0(nativeObj, val.nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::getVolumePose(Mat& val)
    //

    /**
     * Sets volume pose.
     * @param val output value.
     */
    public void getVolumePose(Mat val) {
        getVolumePose_0(nativeObj, val.nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::setVolumeResolution(Mat val)
    //

    /**
     * Resolution of voxel space.
     *         Number of voxels in each dimension.
     *         Applicable only for TSDF Volume.
     *         HashTSDF volume only supports equal resolution in all three dimensions.
     * @param val input value.
     */
    public void setVolumeResolution(Mat val) {
        setVolumeResolution_0(nativeObj, val.nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::getVolumeResolution(Mat& val)
    //

    /**
     * Resolution of voxel space.
     *         Number of voxels in each dimension.
     *         Applicable only for TSDF Volume.
     *         HashTSDF volume only supports equal resolution in all three dimensions.
     * @param val output value.
     */
    public void getVolumeResolution(Mat val) {
        getVolumeResolution_0(nativeObj, val.nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::getVolumeStrides(Mat& val)
    //

    /**
     * Returns 3 integers representing strides by x, y and z dimension.
     *         Can be used to iterate over raw volume unit data.
     * @param val output value.
     */
    public void getVolumeStrides(Mat val) {
        getVolumeStrides_0(nativeObj, val.nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::setCameraIntegrateIntrinsics(Mat val)
    //

    /**
     * Sets intrinsics of camera for integrations.
     * Format of input:
     * [ fx  0 cx ]
     * [  0 fy cy ]
     * [  0  0  1 ]
     * where fx and fy are focus points of Ox and Oy axises, and cx and cy are central points of Ox and Oy axises.
     * @param val input value.
     */
    public void setCameraIntegrateIntrinsics(Mat val) {
        setCameraIntegrateIntrinsics_0(nativeObj, val.nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::getCameraIntegrateIntrinsics(Mat& val)
    //

    /**
     * Returns intrinsics of camera for integrations.
     * Format of output:
     * [ fx  0 cx ]
     * [  0 fy cy ]
     * [  0  0  1 ]
     * where fx and fy are focus points of Ox and Oy axises, and cx and cy are central points of Ox and Oy axises.
     * @param val output value.
     */
    public void getCameraIntegrateIntrinsics(Mat val) {
        getCameraIntegrateIntrinsics_0(nativeObj, val.nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::setCameraRaycastIntrinsics(Mat val)
    //

    /**
     * Sets camera intrinsics for raycast image which, used when user does not provide them at raycast() call.
     * Format of input:
     * [ fx  0 cx ]
     * [  0 fy cy ]
     * [  0  0  1 ]
     * where fx and fy are focus points of Ox and Oy axises, and cx and cy are central points of Ox and Oy axises.
     * @param val input value.
     */
    public void setCameraRaycastIntrinsics(Mat val) {
        setCameraRaycastIntrinsics_0(nativeObj, val.nativeObj);
    }


    //
    // C++:  void cv::VolumeSettings::getCameraRaycastIntrinsics(Mat& val)
    //

    /**
     * Returns camera intrinsics for raycast image, used when user does not provide them at raycast() call.
     * Format of output:
     * [ fx  0 cx ]
     * [  0 fy cy ]
     * [  0  0  1 ]
     * where fx and fy are focus points of Ox and Oy axises, and cx and cy are central points of Ox and Oy axises.
     * @param val output value.
     */
    public void getCameraRaycastIntrinsics(Mat val) {
        getCameraRaycastIntrinsics_0(nativeObj, val.nativeObj);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::VolumeSettings::VolumeSettings(VolumeType volumeType = VolumeType::TSDF)
    private static native long VolumeSettings_0(int volumeType);
    private static native long VolumeSettings_1();

    // C++:  void cv::VolumeSettings::setIntegrateWidth(int val)
    private static native void setIntegrateWidth_0(long nativeObj, int val);

    // C++:  int cv::VolumeSettings::getIntegrateWidth()
    private static native int getIntegrateWidth_0(long nativeObj);

    // C++:  void cv::VolumeSettings::setIntegrateHeight(int val)
    private static native void setIntegrateHeight_0(long nativeObj, int val);

    // C++:  int cv::VolumeSettings::getIntegrateHeight()
    private static native int getIntegrateHeight_0(long nativeObj);

    // C++:  void cv::VolumeSettings::setRaycastWidth(int val)
    private static native void setRaycastWidth_0(long nativeObj, int val);

    // C++:  int cv::VolumeSettings::getRaycastWidth()
    private static native int getRaycastWidth_0(long nativeObj);

    // C++:  void cv::VolumeSettings::setRaycastHeight(int val)
    private static native void setRaycastHeight_0(long nativeObj, int val);

    // C++:  int cv::VolumeSettings::getRaycastHeight()
    private static native int getRaycastHeight_0(long nativeObj);

    // C++:  void cv::VolumeSettings::setDepthFactor(float val)
    private static native void setDepthFactor_0(long nativeObj, float val);

    // C++:  float cv::VolumeSettings::getDepthFactor()
    private static native float getDepthFactor_0(long nativeObj);

    // C++:  void cv::VolumeSettings::setVoxelSize(float val)
    private static native void setVoxelSize_0(long nativeObj, float val);

    // C++:  float cv::VolumeSettings::getVoxelSize()
    private static native float getVoxelSize_0(long nativeObj);

    // C++:  void cv::VolumeSettings::setTsdfTruncateDistance(float val)
    private static native void setTsdfTruncateDistance_0(long nativeObj, float val);

    // C++:  float cv::VolumeSettings::getTsdfTruncateDistance()
    private static native float getTsdfTruncateDistance_0(long nativeObj);

    // C++:  void cv::VolumeSettings::setMaxDepth(float val)
    private static native void setMaxDepth_0(long nativeObj, float val);

    // C++:  float cv::VolumeSettings::getMaxDepth()
    private static native float getMaxDepth_0(long nativeObj);

    // C++:  void cv::VolumeSettings::setMaxWeight(int val)
    private static native void setMaxWeight_0(long nativeObj, int val);

    // C++:  int cv::VolumeSettings::getMaxWeight()
    private static native int getMaxWeight_0(long nativeObj);

    // C++:  void cv::VolumeSettings::setRaycastStepFactor(float val)
    private static native void setRaycastStepFactor_0(long nativeObj, float val);

    // C++:  float cv::VolumeSettings::getRaycastStepFactor()
    private static native float getRaycastStepFactor_0(long nativeObj);

    // C++:  void cv::VolumeSettings::setVolumePose(Mat val)
    private static native void setVolumePose_0(long nativeObj, long val_nativeObj);

    // C++:  void cv::VolumeSettings::getVolumePose(Mat& val)
    private static native void getVolumePose_0(long nativeObj, long val_nativeObj);

    // C++:  void cv::VolumeSettings::setVolumeResolution(Mat val)
    private static native void setVolumeResolution_0(long nativeObj, long val_nativeObj);

    // C++:  void cv::VolumeSettings::getVolumeResolution(Mat& val)
    private static native void getVolumeResolution_0(long nativeObj, long val_nativeObj);

    // C++:  void cv::VolumeSettings::getVolumeStrides(Mat& val)
    private static native void getVolumeStrides_0(long nativeObj, long val_nativeObj);

    // C++:  void cv::VolumeSettings::setCameraIntegrateIntrinsics(Mat val)
    private static native void setCameraIntegrateIntrinsics_0(long nativeObj, long val_nativeObj);

    // C++:  void cv::VolumeSettings::getCameraIntegrateIntrinsics(Mat& val)
    private static native void getCameraIntegrateIntrinsics_0(long nativeObj, long val_nativeObj);

    // C++:  void cv::VolumeSettings::setCameraRaycastIntrinsics(Mat val)
    private static native void setCameraRaycastIntrinsics_0(long nativeObj, long val_nativeObj);

    // C++:  void cv::VolumeSettings::getCameraRaycastIntrinsics(Mat& val)
    private static native void getCameraRaycastIntrinsics_0(long nativeObj, long val_nativeObj);

    // native support for java finalize() or cleaner
    private static native void delete(long nativeObj);

}
