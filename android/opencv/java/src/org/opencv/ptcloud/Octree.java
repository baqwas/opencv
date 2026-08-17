//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.ptcloud;

import org.opencv.core.Mat;
import org.opencv.core.Point3;
import org.opencv.ptcloud.Octree;

// C++: class Octree
/**
 * Octree for 3D vision.
 *
 * In 3D vision filed, the Octree is used to process and accelerate the pointcloud data. The class Octree represents
 * the Octree data structure. Each Octree will have a fixed depth. The depth of Octree refers to the distance from
 * the root node to the leaf node.All OctreeNodes will not exceed this depth.Increasing the depth will increase
 * the amount of calculation exponentially. And the small number of depth refers low resolution of Octree.
 * Each node contains 8 children, which are used to divide the space cube into eight parts. Each octree node represents
 * a cube. And these eight children will have a fixed order, the order is described as follows:
 *
 * For illustration, assume,
 *
 * rootNode: origin == (0, 0, 0), size == 2
 *
 * Then,
 *
 * children[0]: origin == (0, 0, 0), size == 1
 *
 * children[1]: origin == (1, 0, 0), size == 1, along X-axis next to child 0
 *
 * children[2]: origin == (0, 1, 0), size == 1, along Y-axis next to child 0
 *
 * children[3]: origin == (1, 1, 0), size == 1, in X-Y plane
 *
 * children[4]: origin == (0, 0, 1), size == 1, along Z-axis next to child 0
 *
 * children[5]: origin == (1, 0, 1), size == 1, in X-Z plane
 *
 * children[6]: origin == (0, 1, 1), size == 1, in Y-Z plane
 *
 * children[7]: origin == (1, 1, 1), size == 1, furthest from child 0
 */
public class Octree {

    protected final long nativeObj;
    protected Octree(long addr) {
      nativeObj = addr;

    }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static Octree __fromPtr__(long addr) { return new Octree(addr); }

    //
    // C++: static Ptr_Octree cv::Octree::createWithDepth(int maxDepth, double size, Point3f origin = { }, bool withColors = false)
    //

    /**
     *
     * Creates an empty Octree with given maximum depth
     *
     * @param maxDepth The max depth of the Octree
     * @param size bounding box size for the Octree
     * @param origin Initial center coordinate
     * @param withColors Whether to keep per-point colors or not
     * @return resulting Octree
     */
    public static Octree createWithDepth(int maxDepth, double size, Point3 origin, boolean withColors) {
        return Octree.__fromPtr__(createWithDepth_0(maxDepth, size, origin.x, origin.y, origin.z, withColors));
    }

    /**
     *
     * Creates an empty Octree with given maximum depth
     *
     * @param maxDepth The max depth of the Octree
     * @param size bounding box size for the Octree
     * @param origin Initial center coordinate
     * @return resulting Octree
     */
    public static Octree createWithDepth(int maxDepth, double size, Point3 origin) {
        return Octree.__fromPtr__(createWithDepth_1(maxDepth, size, origin.x, origin.y, origin.z));
    }

    /**
     *
     * Creates an empty Octree with given maximum depth
     *
     * @param maxDepth The max depth of the Octree
     * @param size bounding box size for the Octree
     * @return resulting Octree
     */
    public static Octree createWithDepth(int maxDepth, double size) {
        return Octree.__fromPtr__(createWithDepth_2(maxDepth, size));
    }


    //
    // C++: static Ptr_Octree cv::Octree::createWithDepth(int maxDepth, Mat pointCloud, Mat colors = Mat())
    //

    /**
     *
     * Create an Octree from the PointCloud data with the specific maxDepth
     *
     * @param maxDepth Max depth of the octree
     * @param pointCloud point cloud data, should be 3-channel float array
     * @param colors color attribute of point cloud in the same 3-channel float format
     * @return resulting Octree
     */
    public static Octree createWithDepth(int maxDepth, Mat pointCloud, Mat colors) {
        return Octree.__fromPtr__(createWithDepth_3(maxDepth, pointCloud.nativeObj, colors.nativeObj));
    }

    /**
     *
     * Create an Octree from the PointCloud data with the specific maxDepth
     *
     * @param maxDepth Max depth of the octree
     * @param pointCloud point cloud data, should be 3-channel float array
     * @return resulting Octree
     */
    public static Octree createWithDepth(int maxDepth, Mat pointCloud) {
        return Octree.__fromPtr__(createWithDepth_4(maxDepth, pointCloud.nativeObj));
    }


    //
    // C++: static Ptr_Octree cv::Octree::createWithResolution(double resolution, double size, Point3f origin = { }, bool withColors = false)
    //

    /**
     *
     * Creates an empty Octree with given resolution
     *
     * @param resolution The size of the octree leaf node
     * @param size bounding box size for the Octree
     * @param origin Initial center coordinate
     * @param withColors Whether to keep per-point colors or not
     * @return resulting Octree
     */
    public static Octree createWithResolution(double resolution, double size, Point3 origin, boolean withColors) {
        return Octree.__fromPtr__(createWithResolution_0(resolution, size, origin.x, origin.y, origin.z, withColors));
    }

    /**
     *
     * Creates an empty Octree with given resolution
     *
     * @param resolution The size of the octree leaf node
     * @param size bounding box size for the Octree
     * @param origin Initial center coordinate
     * @return resulting Octree
     */
    public static Octree createWithResolution(double resolution, double size, Point3 origin) {
        return Octree.__fromPtr__(createWithResolution_1(resolution, size, origin.x, origin.y, origin.z));
    }

    /**
     *
     * Creates an empty Octree with given resolution
     *
     * @param resolution The size of the octree leaf node
     * @param size bounding box size for the Octree
     * @return resulting Octree
     */
    public static Octree createWithResolution(double resolution, double size) {
        return Octree.__fromPtr__(createWithResolution_2(resolution, size));
    }


    //
    // C++: static Ptr_Octree cv::Octree::createWithResolution(double resolution, Mat pointCloud, Mat colors = Mat())
    //

    /**
     *
     * Create an Octree from the PointCloud data with the specific resolution
     *
     * @param resolution The size of the octree leaf node
     * @param pointCloud point cloud data, should be 3-channel float array
     * @param colors color attribute of point cloud in the same 3-channel float format
     * @return resulting octree
     */
    public static Octree createWithResolution(double resolution, Mat pointCloud, Mat colors) {
        return Octree.__fromPtr__(createWithResolution_3(resolution, pointCloud.nativeObj, colors.nativeObj));
    }

    /**
     *
     * Create an Octree from the PointCloud data with the specific resolution
     *
     * @param resolution The size of the octree leaf node
     * @param pointCloud point cloud data, should be 3-channel float array
     * @return resulting octree
     */
    public static Octree createWithResolution(double resolution, Mat pointCloud) {
        return Octree.__fromPtr__(createWithResolution_4(resolution, pointCloud.nativeObj));
    }


    //
    // C++:  bool cv::Octree::insertPoint(Point3f point, Point3f color = { })
    //

    /**
     *
     * Insert a point data with color to a OctreeNode.
     *
     * @param point The point data in Point3f format.
     * @param color The color attribute of point in Point3f format.
     * @return Returns whether the insertion is successful.
     */
    public boolean insertPoint(Point3 point, Point3 color) {
        return insertPoint_0(nativeObj, point.x, point.y, point.z, color.x, color.y, color.z);
    }

    /**
     *
     * Insert a point data with color to a OctreeNode.
     *
     * @param point The point data in Point3f format.
     * @return Returns whether the insertion is successful.
     */
    public boolean insertPoint(Point3 point) {
        return insertPoint_1(nativeObj, point.x, point.y, point.z);
    }


    //
    // C++:  bool cv::Octree::isPointInBound(Point3f point)
    //

    /**
     * Determine whether the point is within the space range of the specific cube.
     *
     * @param point The point coordinates.
     * @return If point is in bound, return ture. Otherwise, false.
     */
    public boolean isPointInBound(Point3 point) {
        return isPointInBound_0(nativeObj, point.x, point.y, point.z);
    }


    //
    // C++:  bool cv::Octree::empty()
    //

    public boolean empty() {
        return empty_0(nativeObj);
    }


    //
    // C++:  void cv::Octree::clear()
    //

    /**
     * Reset all octree parameter.
     *
     * Clear all the nodes of the octree and initialize the parameters.
     */
    public void clear() {
        clear_0(nativeObj);
    }


    //
    // C++:  bool cv::Octree::deletePoint(Point3f point)
    //

    /**
     * Delete a given point from the Octree.
     *
     * Delete the corresponding element from the pointList in the corresponding leaf node. If the leaf node
     * does not contain other points after deletion, this node will be deleted. In the same way,
     * its parent node may also be deleted if its last child is deleted.
     * @param point The point coordinates, comparison is epsilon-based
     * @return return ture if the point is deleted successfully.
     */
    public boolean deletePoint(Point3 point) {
        return deletePoint_0(nativeObj, point.x, point.y, point.z);
    }


    //
    // C++:  void cv::Octree::getPointCloudByOctree(Mat& restoredPointCloud, Mat& restoredColor = Mat())
    //

    /**
     * restore point cloud data from Octree.
     *
     * Restore the point cloud data from existing octree. The points in same leaf node will be seen as the same point.
     * This point is the center of the leaf node. If the resolution is small, it will work as a downSampling function.
     * @param restoredPointCloud The output point cloud data, can be replaced by noArray() if not needed
     * @param restoredColor The color attribute of point cloud data, can be omitted if not needed
     */
    public void getPointCloudByOctree(Mat restoredPointCloud, Mat restoredColor) {
        getPointCloudByOctree_0(nativeObj, restoredPointCloud.nativeObj, restoredColor.nativeObj);
    }

    /**
     * restore point cloud data from Octree.
     *
     * Restore the point cloud data from existing octree. The points in same leaf node will be seen as the same point.
     * This point is the center of the leaf node. If the resolution is small, it will work as a downSampling function.
     * @param restoredPointCloud The output point cloud data, can be replaced by noArray() if not needed
     */
    public void getPointCloudByOctree(Mat restoredPointCloud) {
        getPointCloudByOctree_1(nativeObj, restoredPointCloud.nativeObj);
    }


    //
    // C++:  int cv::Octree::radiusNNSearch(Point3f query, float radius, Mat& points, Mat& squareDists = Mat())
    //

    /**
     * Radius Nearest Neighbor Search in Octree.
     *
     * Search all points that are less than or equal to radius.
     * And return the number of searched points.
     * @param query Query point.
     * @param radius Retrieved radius value.
     * @param points Point output. Contains searched points in 3-float format, and output vector is not in order,
     * can be replaced by noArray() if not needed
     * @param squareDists Dist output. Contains searched squared distance in floats, and output vector is not in order,
     * can be omitted if not needed
     * @return the number of searched points.
     */
    public int radiusNNSearch(Point3 query, float radius, Mat points, Mat squareDists) {
        return radiusNNSearch_0(nativeObj, query.x, query.y, query.z, radius, points.nativeObj, squareDists.nativeObj);
    }

    /**
     * Radius Nearest Neighbor Search in Octree.
     *
     * Search all points that are less than or equal to radius.
     * And return the number of searched points.
     * @param query Query point.
     * @param radius Retrieved radius value.
     * @param points Point output. Contains searched points in 3-float format, and output vector is not in order,
     * can be replaced by noArray() if not needed
     * can be omitted if not needed
     * @return the number of searched points.
     */
    public int radiusNNSearch(Point3 query, float radius, Mat points) {
        return radiusNNSearch_1(nativeObj, query.x, query.y, query.z, radius, points.nativeObj);
    }


    //
    // C++:  int cv::Octree::radiusNNSearch(Point3f query, float radius, Mat& points, Mat& colors, Mat& squareDists)
    //

    /**
     *
     * Radius Nearest Neighbor Search in Octree.
     *
     * Search all points that are less than or equal to radius.
     * And return the number of searched points.
     * @param query Query point.
     * @param radius Retrieved radius value.
     * @param points Point output. Contains searched points in 3-float format, and output vector is not in order,
     * can be replaced by noArray() if not needed
     * @param colors Color output. Contains colors corresponding to points in pointSet, can be replaced by noArray() if not needed
     * @param squareDists Dist output. Contains searched squared distance in floats, and output vector is not in order,
     * can be replaced by noArray() if not needed
     * @return the number of searched points.
     */
    public int radiusNNSearch(Point3 query, float radius, Mat points, Mat colors, Mat squareDists) {
        return radiusNNSearch_2(nativeObj, query.x, query.y, query.z, radius, points.nativeObj, colors.nativeObj, squareDists.nativeObj);
    }


    //
    // C++:  void cv::Octree::KNNSearch(Point3f query, int K, Mat& points, Mat& squareDists = Mat())
    //

    /**
     * K Nearest Neighbor Search in Octree.
     *
     * Find the K nearest neighbors to the query point.
     * @param query Query point.
     * @param K amount of nearest neighbors to find
     * @param points Point output. Contains K points in 3-float format, arranged in order of distance from near to far,
     * can be replaced by noArray() if not needed
     * @param squareDists Dist output. Contains K squared distance in floats, arranged in order of distance from near to far,
     * can be omitted if not needed
     */
    public void KNNSearch(Point3 query, int K, Mat points, Mat squareDists) {
        KNNSearch_0(nativeObj, query.x, query.y, query.z, K, points.nativeObj, squareDists.nativeObj);
    }

    /**
     * K Nearest Neighbor Search in Octree.
     *
     * Find the K nearest neighbors to the query point.
     * @param query Query point.
     * @param K amount of nearest neighbors to find
     * @param points Point output. Contains K points in 3-float format, arranged in order of distance from near to far,
     * can be replaced by noArray() if not needed
     * can be omitted if not needed
     */
    public void KNNSearch(Point3 query, int K, Mat points) {
        KNNSearch_1(nativeObj, query.x, query.y, query.z, K, points.nativeObj);
    }


    //
    // C++:  void cv::Octree::KNNSearch(Point3f query, int K, Mat& points, Mat& colors, Mat& squareDists)
    //

    /**
     *
     * K Nearest Neighbor Search in Octree.
     *
     * Find the K nearest neighbors to the query point.
     * @param query Query point.
     * @param K amount of nearest neighbors to find
     * @param points Point output. Contains K points in 3-float format, arranged in order of distance from near to far,
     * can be replaced by noArray() if not needed
     * @param colors Color output. Contains colors corresponding to points in pointSet, can be replaced by noArray() if not needed
     * @param squareDists Dist output. Contains K squared distance in floats, arranged in order of distance from near to far,
     * can be replaced by noArray() if not needed
     */
    public void KNNSearch(Point3 query, int K, Mat points, Mat colors, Mat squareDists) {
        KNNSearch_2(nativeObj, query.x, query.y, query.z, K, points.nativeObj, colors.nativeObj, squareDists.nativeObj);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++: static Ptr_Octree cv::Octree::createWithDepth(int maxDepth, double size, Point3f origin = { }, bool withColors = false)
    private static native long createWithDepth_0(int maxDepth, double size, double origin_x, double origin_y, double origin_z, boolean withColors);
    private static native long createWithDepth_1(int maxDepth, double size, double origin_x, double origin_y, double origin_z);
    private static native long createWithDepth_2(int maxDepth, double size);

    // C++: static Ptr_Octree cv::Octree::createWithDepth(int maxDepth, Mat pointCloud, Mat colors = Mat())
    private static native long createWithDepth_3(int maxDepth, long pointCloud_nativeObj, long colors_nativeObj);
    private static native long createWithDepth_4(int maxDepth, long pointCloud_nativeObj);

    // C++: static Ptr_Octree cv::Octree::createWithResolution(double resolution, double size, Point3f origin = { }, bool withColors = false)
    private static native long createWithResolution_0(double resolution, double size, double origin_x, double origin_y, double origin_z, boolean withColors);
    private static native long createWithResolution_1(double resolution, double size, double origin_x, double origin_y, double origin_z);
    private static native long createWithResolution_2(double resolution, double size);

    // C++: static Ptr_Octree cv::Octree::createWithResolution(double resolution, Mat pointCloud, Mat colors = Mat())
    private static native long createWithResolution_3(double resolution, long pointCloud_nativeObj, long colors_nativeObj);
    private static native long createWithResolution_4(double resolution, long pointCloud_nativeObj);

    // C++:  bool cv::Octree::insertPoint(Point3f point, Point3f color = { })
    private static native boolean insertPoint_0(long nativeObj, double point_x, double point_y, double point_z, double color_x, double color_y, double color_z);
    private static native boolean insertPoint_1(long nativeObj, double point_x, double point_y, double point_z);

    // C++:  bool cv::Octree::isPointInBound(Point3f point)
    private static native boolean isPointInBound_0(long nativeObj, double point_x, double point_y, double point_z);

    // C++:  bool cv::Octree::empty()
    private static native boolean empty_0(long nativeObj);

    // C++:  void cv::Octree::clear()
    private static native void clear_0(long nativeObj);

    // C++:  bool cv::Octree::deletePoint(Point3f point)
    private static native boolean deletePoint_0(long nativeObj, double point_x, double point_y, double point_z);

    // C++:  void cv::Octree::getPointCloudByOctree(Mat& restoredPointCloud, Mat& restoredColor = Mat())
    private static native void getPointCloudByOctree_0(long nativeObj, long restoredPointCloud_nativeObj, long restoredColor_nativeObj);
    private static native void getPointCloudByOctree_1(long nativeObj, long restoredPointCloud_nativeObj);

    // C++:  int cv::Octree::radiusNNSearch(Point3f query, float radius, Mat& points, Mat& squareDists = Mat())
    private static native int radiusNNSearch_0(long nativeObj, double query_x, double query_y, double query_z, float radius, long points_nativeObj, long squareDists_nativeObj);
    private static native int radiusNNSearch_1(long nativeObj, double query_x, double query_y, double query_z, float radius, long points_nativeObj);

    // C++:  int cv::Octree::radiusNNSearch(Point3f query, float radius, Mat& points, Mat& colors, Mat& squareDists)
    private static native int radiusNNSearch_2(long nativeObj, double query_x, double query_y, double query_z, float radius, long points_nativeObj, long colors_nativeObj, long squareDists_nativeObj);

    // C++:  void cv::Octree::KNNSearch(Point3f query, int K, Mat& points, Mat& squareDists = Mat())
    private static native void KNNSearch_0(long nativeObj, double query_x, double query_y, double query_z, int K, long points_nativeObj, long squareDists_nativeObj);
    private static native void KNNSearch_1(long nativeObj, double query_x, double query_y, double query_z, int K, long points_nativeObj);

    // C++:  void cv::Octree::KNNSearch(Point3f query, int K, Mat& points, Mat& colors, Mat& squareDists)
    private static native void KNNSearch_2(long nativeObj, double query_x, double query_y, double query_z, int K, long points_nativeObj, long colors_nativeObj, long squareDists_nativeObj);

    // native support for java finalize() or cleaner
    private static native void delete(long nativeObj);

}
