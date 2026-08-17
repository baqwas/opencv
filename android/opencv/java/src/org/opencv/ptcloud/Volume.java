//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.ptcloud;

import org.opencv.core.Mat;
import org.opencv.ptcloud.OdometryFrame;
import org.opencv.ptcloud.VolumeSettings;

// C++: class Volume

public class Volume {

    protected final long nativeObj;
    protected Volume(long addr) {
      nativeObj = addr;

    }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static Volume __fromPtr__(long addr) { return new Volume(addr); }

    // C++: enum BoundingBoxPrecision (cv.Volume.BoundingBoxPrecision)
    public static final int
            VOLUME_UNIT = 0,
            VOXEL = 1;


    //
    // C++:   cv::Volume::Volume(VolumeType vtype = VolumeType::TSDF, VolumeSettings settings = VolumeSettings(VolumeType::TSDF))
    //

    /**
     * Constructor of custom volume.
     * @param vtype the volume type [TSDF, HashTSDF, ColorTSDF].
     * @param settings the custom settings for volume.
     */
    public Volume(int vtype, VolumeSettings settings) {
        nativeObj = Volume_0(vtype, settings.getNativeObjAddr());
    }

    /**
     * Constructor of custom volume.
     * @param vtype the volume type [TSDF, HashTSDF, ColorTSDF].
     */
    public Volume(int vtype) {
        nativeObj = Volume_1(vtype);
    }

    /**
     * Constructor of custom volume.
     */
    public Volume() {
        nativeObj = Volume_2();
    }


    //
    // C++:  void cv::Volume::integrate(OdometryFrame frame, Mat pose)
    //

    /**
     * Integrates the input data to the volume.
     *
     *     Camera intrinsics are taken from volume settings structure.
     *
     * @param frame the object from which to take depth and image data.
     *       For color TSDF a depth data should be registered with color data, i.e. have the same intrinsics &amp; camera pose.
     *       This can be done using function registerDepth() from 3d module.
     * @param pose the pose of camera in global coordinates.
     */
    public void integrateFrame(OdometryFrame frame, Mat pose) {
        integrateFrame_0(nativeObj, frame.getNativeObjAddr(), pose.nativeObj);
    }


    //
    // C++:  void cv::Volume::integrate(Mat depth, Mat pose)
    //

    /**
     * Integrates the input data to the volume.
     *
     *     Camera intrinsics are taken from volume settings structure.
     *
     * @param depth the depth image.
     * @param pose the pose of camera in global coordinates.
     */
    public void integrate(Mat depth, Mat pose) {
        integrate_0(nativeObj, depth.nativeObj, pose.nativeObj);
    }


    //
    // C++:  void cv::Volume::integrate(Mat depth, Mat image, Mat pose)
    //

    /**
     * Integrates the input data to the volume.
     *
     *     Camera intrinsics are taken from volume settings structure.
     *
     * @param depth the depth image.
     * @param image the color image (only for ColorTSDF).
     *       For color TSDF a depth data should be registered with color data, i.e. have the same intrinsics &amp; camera pose.
     *       This can be done using function registerDepth() from 3d module.
     * @param pose the pose of camera in global coordinates.
     */
    public void integrateColor(Mat depth, Mat image, Mat pose) {
        integrateColor_0(nativeObj, depth.nativeObj, image.nativeObj, pose.nativeObj);
    }


    //
    // C++:  void cv::Volume::raycast(Mat cameraPose, Mat& points, Mat& normals)
    //

    /**
     * Renders the volume contents into an image. The resulting points and normals are in camera's coordinate system.
     *
     *     Rendered image size and camera intrinsics are taken from volume settings structure.
     *
     * @param cameraPose the pose of camera in global coordinates.
     * @param points image to store rendered points.
     * @param normals image to store rendered normals corresponding to points.
     */
    public void raycast(Mat cameraPose, Mat points, Mat normals) {
        raycast_0(nativeObj, cameraPose.nativeObj, points.nativeObj, normals.nativeObj);
    }


    //
    // C++:  void cv::Volume::raycast(Mat cameraPose, Mat& points, Mat& normals, Mat& colors)
    //

    /**
     * Renders the volume contents into an image. The resulting points and normals are in camera's coordinate system.
     *
     *     Rendered image size and camera intrinsics are taken from volume settings structure.
     *
     * @param cameraPose the pose of camera in global coordinates.
     * @param points image to store rendered points.
     * @param normals image to store rendered normals corresponding to points.
     * @param colors image to store rendered colors corresponding to points (only for ColorTSDF).
     */
    public void raycastColor(Mat cameraPose, Mat points, Mat normals, Mat colors) {
        raycastColor_0(nativeObj, cameraPose.nativeObj, points.nativeObj, normals.nativeObj, colors.nativeObj);
    }


    //
    // C++:  void cv::Volume::raycast(Mat cameraPose, int height, int width, Mat K, Mat& points, Mat& normals)
    //

    /**
     * Renders the volume contents into an image. The resulting points and normals are in camera's coordinate system.
     *
     *     Rendered image size and camera intrinsics are taken from volume settings structure.
     *
     * @param cameraPose the pose of camera in global coordinates.
     * @param height the height of result image
     * @param width the width of result image
     * @param K camera raycast intrinsics
     * @param points image to store rendered points.
     * @param normals image to store rendered normals corresponding to points.
     */
    public void raycastEx(Mat cameraPose, int height, int width, Mat K, Mat points, Mat normals) {
        raycastEx_0(nativeObj, cameraPose.nativeObj, height, width, K.nativeObj, points.nativeObj, normals.nativeObj);
    }


    //
    // C++:  void cv::Volume::raycast(Mat cameraPose, int height, int width, Mat K, Mat& points, Mat& normals, Mat& colors)
    //

    /**
     * Renders the volume contents into an image. The resulting points and normals are in camera's coordinate system.
     *
     *     Rendered image size and camera intrinsics are taken from volume settings structure.
     *
     * @param cameraPose the pose of camera in global coordinates.
     * @param height the height of result image
     * @param width the width of result image
     * @param K camera raycast intrinsics
     * @param points image to store rendered points.
     * @param normals image to store rendered normals corresponding to points.
     * @param colors image to store rendered colors corresponding to points (only for ColorTSDF).
     */
    public void raycastExColor(Mat cameraPose, int height, int width, Mat K, Mat points, Mat normals, Mat colors) {
        raycastExColor_0(nativeObj, cameraPose.nativeObj, height, width, K.nativeObj, points.nativeObj, normals.nativeObj, colors.nativeObj);
    }


    //
    // C++:  void cv::Volume::fetchNormals(Mat points, Mat& normals)
    //

    /**
     * Extract the all data from volume.
     * @param points the input exist point.
     * @param normals the storage of normals (corresponding to input points) in the image.
     */
    public void fetchNormals(Mat points, Mat normals) {
        fetchNormals_0(nativeObj, points.nativeObj, normals.nativeObj);
    }


    //
    // C++:  void cv::Volume::fetchPointsNormals(Mat& points, Mat& normals)
    //

    /**
     * Extract the all data from volume.
     * @param points the storage of all points.
     * @param normals the storage of all normals, corresponding to points.
     */
    public void fetchPointsNormals(Mat points, Mat normals) {
        fetchPointsNormals_0(nativeObj, points.nativeObj, normals.nativeObj);
    }


    //
    // C++:  void cv::Volume::fetchPointsNormalsColors(Mat& points, Mat& normals, Mat& colors)
    //

    /**
     * Extract the all data from volume.
     * @param points the storage of all points.
     * @param normals the storage of all normals, corresponding to points.
     * @param colors the storage of all colors, corresponding to points (only for ColorTSDF).
     */
    public void fetchPointsNormalsColors(Mat points, Mat normals, Mat colors) {
        fetchPointsNormalsColors_0(nativeObj, points.nativeObj, normals.nativeObj, colors.nativeObj);
    }


    //
    // C++:  void cv::Volume::reset()
    //

    /**
     * clear all data in volume.
     */
    public void reset() {
        reset_0(nativeObj);
    }


    //
    // C++:  int cv::Volume::getVisibleBlocks()
    //

    /**
     * return visible blocks in volume.
     * @return automatically generated
     */
    public int getVisibleBlocks() {
        return getVisibleBlocks_0(nativeObj);
    }


    //
    // C++:  size_t cv::Volume::getTotalVolumeUnits()
    //

    /**
     * return number of volume units in volume.
     * @return automatically generated
     */
    public long getTotalVolumeUnits() {
        return getTotalVolumeUnits_0(nativeObj);
    }


    //
    // C++:  void cv::Volume::getBoundingBox(Mat& bb, int precision)
    //

    /**
     * Gets bounding box in volume coordinates with given precision:
     * VOLUME_UNIT - up to volume unit
     * VOXEL - up to voxel (currently not supported)
     * @param bb 6-float 1d array containing (min_x, min_y, min_z, max_x, max_y, max_z) in volume coordinates
     * @param precision bounding box calculation precision
     */
    public void getBoundingBox(Mat bb, int precision) {
        getBoundingBox_0(nativeObj, bb.nativeObj, precision);
    }


    //
    // C++:  void cv::Volume::setEnableGrowth(bool v)
    //

    /**
     * Enables or disables new volume unit allocation during integration.
     * Makes sense for HashTSDF only.
     * @param v automatically generated
     */
    public void setEnableGrowth(boolean v) {
        setEnableGrowth_0(nativeObj, v);
    }


    //
    // C++:  bool cv::Volume::getEnableGrowth()
    //

    /**
     * Returns if new volume units are allocated during integration or not.
     * Makes sense for HashTSDF only.
     * @return automatically generated
     */
    public boolean getEnableGrowth() {
        return getEnableGrowth_0(nativeObj);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::Volume::Volume(VolumeType vtype = VolumeType::TSDF, VolumeSettings settings = VolumeSettings(VolumeType::TSDF))
    private static native long Volume_0(int vtype, long settings_nativeObj);
    private static native long Volume_1(int vtype);
    private static native long Volume_2();

    // C++:  void cv::Volume::integrate(OdometryFrame frame, Mat pose)
    private static native void integrateFrame_0(long nativeObj, long frame_nativeObj, long pose_nativeObj);

    // C++:  void cv::Volume::integrate(Mat depth, Mat pose)
    private static native void integrate_0(long nativeObj, long depth_nativeObj, long pose_nativeObj);

    // C++:  void cv::Volume::integrate(Mat depth, Mat image, Mat pose)
    private static native void integrateColor_0(long nativeObj, long depth_nativeObj, long image_nativeObj, long pose_nativeObj);

    // C++:  void cv::Volume::raycast(Mat cameraPose, Mat& points, Mat& normals)
    private static native void raycast_0(long nativeObj, long cameraPose_nativeObj, long points_nativeObj, long normals_nativeObj);

    // C++:  void cv::Volume::raycast(Mat cameraPose, Mat& points, Mat& normals, Mat& colors)
    private static native void raycastColor_0(long nativeObj, long cameraPose_nativeObj, long points_nativeObj, long normals_nativeObj, long colors_nativeObj);

    // C++:  void cv::Volume::raycast(Mat cameraPose, int height, int width, Mat K, Mat& points, Mat& normals)
    private static native void raycastEx_0(long nativeObj, long cameraPose_nativeObj, int height, int width, long K_nativeObj, long points_nativeObj, long normals_nativeObj);

    // C++:  void cv::Volume::raycast(Mat cameraPose, int height, int width, Mat K, Mat& points, Mat& normals, Mat& colors)
    private static native void raycastExColor_0(long nativeObj, long cameraPose_nativeObj, int height, int width, long K_nativeObj, long points_nativeObj, long normals_nativeObj, long colors_nativeObj);

    // C++:  void cv::Volume::fetchNormals(Mat points, Mat& normals)
    private static native void fetchNormals_0(long nativeObj, long points_nativeObj, long normals_nativeObj);

    // C++:  void cv::Volume::fetchPointsNormals(Mat& points, Mat& normals)
    private static native void fetchPointsNormals_0(long nativeObj, long points_nativeObj, long normals_nativeObj);

    // C++:  void cv::Volume::fetchPointsNormalsColors(Mat& points, Mat& normals, Mat& colors)
    private static native void fetchPointsNormalsColors_0(long nativeObj, long points_nativeObj, long normals_nativeObj, long colors_nativeObj);

    // C++:  void cv::Volume::reset()
    private static native void reset_0(long nativeObj);

    // C++:  int cv::Volume::getVisibleBlocks()
    private static native int getVisibleBlocks_0(long nativeObj);

    // C++:  size_t cv::Volume::getTotalVolumeUnits()
    private static native long getTotalVolumeUnits_0(long nativeObj);

    // C++:  void cv::Volume::getBoundingBox(Mat& bb, int precision)
    private static native void getBoundingBox_0(long nativeObj, long bb_nativeObj, int precision);

    // C++:  void cv::Volume::setEnableGrowth(bool v)
    private static native void setEnableGrowth_0(long nativeObj, boolean v);

    // C++:  bool cv::Volume::getEnableGrowth()
    private static native boolean getEnableGrowth_0(long nativeObj);

    // native support for java finalize() or cleaner
    private static native void delete(long nativeObj);

}
