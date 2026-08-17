//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.ptcloud;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.ptcloud.TriangleRasterizeSettings;
import org.opencv.utils.Converters;

// C++: class Ptcloud

public class Ptcloud {

    // C++: enum OdometryAlgoType (cv.OdometryAlgoType)
    public static final int
            OdometryAlgoType_COMMON = 0,
            OdometryAlgoType_FAST = 1;


    // C++: enum OdometryFramePyramidType (cv.OdometryFramePyramidType)
    public static final int
            PYR_IMAGE = 0,
            PYR_DEPTH = 1,
            PYR_MASK = 2,
            PYR_CLOUD = 3,
            PYR_DIX = 4,
            PYR_DIY = 5,
            PYR_TEXMASK = 6,
            PYR_NORM = 7,
            PYR_NORMMASK = 8,
            N_PYRAMIDS = 8+1;


    // C++: enum OdometryType (cv.OdometryType)
    public static final int
            OdometryType_DEPTH = 0,
            OdometryType_RGB = 1,
            OdometryType_RGB_DEPTH = 2;


    // C++: enum RgbdPlaneMethod (cv.RgbdPlaneMethod)
    public static final int
            RGBD_PLANE_METHOD_DEFAULT = 0;


    // C++: enum TriangleCullingMode (cv.TriangleCullingMode)
    public static final int
            RASTERIZE_CULLING_NONE = 0,
            RASTERIZE_CULLING_CW = 1,
            RASTERIZE_CULLING_CCW = 2;


    // C++: enum TriangleGlCompatibleMode (cv.TriangleGlCompatibleMode)
    public static final int
            RASTERIZE_COMPAT_DISABLED = 0,
            RASTERIZE_COMPAT_INVDEPTH = 1;


    // C++: enum TriangleShadingType (cv.TriangleShadingType)
    public static final int
            RASTERIZE_SHADING_WHITE = 0,
            RASTERIZE_SHADING_FLAT = 1,
            RASTERIZE_SHADING_SHADED = 2;


    // C++: enum VolumeType (cv.VolumeType)
    public static final int
            VolumeType_TSDF = 0,
            VolumeType_HashTSDF = 1,
            VolumeType_ColorTSDF = 2;


    //
    // C++:  void cv::loadPointCloud(String filename, Mat& vertices, Mat& normals = Mat(), Mat& rgb = Mat())
    //

    /**
     * Loads a point cloud from a file.
     *
     * The function loads point cloud from the specified file and returns it.
     * If the cloud cannot be read, throws an error.
     * Vertex coordinates, normals and colors are returned as they are saved in the file
     * even if these arrays have different sizes and their elements do not correspond to each other
     * (which is typical for OBJ files for example)
     *
     * Currently, the following file formats are supported:
     * -  [Wavefront obj file *.obj](https://en.wikipedia.org/wiki/Wavefront_.obj_file)
     * -  [Polygon File Format *.ply](https://en.wikipedia.org/wiki/PLY_(file_format))
     *
     * @param filename Name of the file
     * @param vertices vertex coordinates, each value contains 3 floats
     * @param normals per-vertex normals, each value contains 3 floats
     * @param rgb per-vertex colors, each value contains 3 floats
     */
    public static void loadPointCloud(String filename, Mat vertices, Mat normals, Mat rgb) {
        loadPointCloud_0(filename, vertices.nativeObj, normals.nativeObj, rgb.nativeObj);
    }

    /**
     * Loads a point cloud from a file.
     *
     * The function loads point cloud from the specified file and returns it.
     * If the cloud cannot be read, throws an error.
     * Vertex coordinates, normals and colors are returned as they are saved in the file
     * even if these arrays have different sizes and their elements do not correspond to each other
     * (which is typical for OBJ files for example)
     *
     * Currently, the following file formats are supported:
     * -  [Wavefront obj file *.obj](https://en.wikipedia.org/wiki/Wavefront_.obj_file)
     * -  [Polygon File Format *.ply](https://en.wikipedia.org/wiki/PLY_(file_format))
     *
     * @param filename Name of the file
     * @param vertices vertex coordinates, each value contains 3 floats
     * @param normals per-vertex normals, each value contains 3 floats
     */
    public static void loadPointCloud(String filename, Mat vertices, Mat normals) {
        loadPointCloud_1(filename, vertices.nativeObj, normals.nativeObj);
    }

    /**
     * Loads a point cloud from a file.
     *
     * The function loads point cloud from the specified file and returns it.
     * If the cloud cannot be read, throws an error.
     * Vertex coordinates, normals and colors are returned as they are saved in the file
     * even if these arrays have different sizes and their elements do not correspond to each other
     * (which is typical for OBJ files for example)
     *
     * Currently, the following file formats are supported:
     * -  [Wavefront obj file *.obj](https://en.wikipedia.org/wiki/Wavefront_.obj_file)
     * -  [Polygon File Format *.ply](https://en.wikipedia.org/wiki/PLY_(file_format))
     *
     * @param filename Name of the file
     * @param vertices vertex coordinates, each value contains 3 floats
     */
    public static void loadPointCloud(String filename, Mat vertices) {
        loadPointCloud_2(filename, vertices.nativeObj);
    }


    //
    // C++:  void cv::savePointCloud(String filename, Mat vertices, Mat normals = Mat(), Mat rgb = Mat())
    //

    /**
     * Saves a point cloud to a specified file.
     *
     * The function saves point cloud to the specified file.
     * File format is chosen based on the filename extension.
     *
     * @param filename Name of the file
     * @param vertices vertex coordinates, each value contains 3 floats
     * @param normals per-vertex normals, each value contains 3 floats
     * @param rgb per-vertex colors, each value contains 3 floats
     */
    public static void savePointCloud(String filename, Mat vertices, Mat normals, Mat rgb) {
        savePointCloud_0(filename, vertices.nativeObj, normals.nativeObj, rgb.nativeObj);
    }

    /**
     * Saves a point cloud to a specified file.
     *
     * The function saves point cloud to the specified file.
     * File format is chosen based on the filename extension.
     *
     * @param filename Name of the file
     * @param vertices vertex coordinates, each value contains 3 floats
     * @param normals per-vertex normals, each value contains 3 floats
     */
    public static void savePointCloud(String filename, Mat vertices, Mat normals) {
        savePointCloud_1(filename, vertices.nativeObj, normals.nativeObj);
    }

    /**
     * Saves a point cloud to a specified file.
     *
     * The function saves point cloud to the specified file.
     * File format is chosen based on the filename extension.
     *
     * @param filename Name of the file
     * @param vertices vertex coordinates, each value contains 3 floats
     */
    public static void savePointCloud(String filename, Mat vertices) {
        savePointCloud_2(filename, vertices.nativeObj);
    }


    //
    // C++:  void cv::loadMesh(String filename, Mat& vertices, vector_Mat& indices, Mat& normals = Mat(), Mat& colors = Mat(), Mat& texCoords = Mat())
    //

    /**
     * Loads a mesh from a file.
     *
     * The function loads mesh from the specified file and returns it.
     * If the mesh cannot be read, throws an error
     * Vertex attributes (i.e. space and texture coodinates, normals and colors) are returned in same-sized
     * arrays with corresponding elements having the same indices.
     * This means that if a face uses a vertex with a normal or a texture coordinate with different indices
     * (which is typical for OBJ files for example), this vertex will be duplicated for each face it uses.
     *
     * Currently, the following file formats are supported:
     * -  [Wavefront obj file *.obj](https://en.wikipedia.org/wiki/Wavefront_.obj_file) (ONLY TRIANGULATED FACES)
     * -  [Polygon File Format *.ply](https://en.wikipedia.org/wiki/PLY_(file_format))
     * @param filename Name of the file
     * @param vertices vertex coordinates, each value contains 3 floats
     * @param indices per-face list of vertices, each value is a vector of ints
     * @param normals per-vertex normals, each value contains 3 floats
     * @param colors per-vertex colors, each value contains 3 floats
     * @param texCoords per-vertex texture coordinates, each value contains 2 or 3 floats
     */
    public static void loadMesh(String filename, Mat vertices, List<Mat> indices, Mat normals, Mat colors, Mat texCoords) {
        Mat indices_mat = new Mat();
        loadMesh_0(filename, vertices.nativeObj, indices_mat.nativeObj, normals.nativeObj, colors.nativeObj, texCoords.nativeObj);
        Converters.Mat_to_vector_Mat(indices_mat, indices);
        indices_mat.release();
    }

    /**
     * Loads a mesh from a file.
     *
     * The function loads mesh from the specified file and returns it.
     * If the mesh cannot be read, throws an error
     * Vertex attributes (i.e. space and texture coodinates, normals and colors) are returned in same-sized
     * arrays with corresponding elements having the same indices.
     * This means that if a face uses a vertex with a normal or a texture coordinate with different indices
     * (which is typical for OBJ files for example), this vertex will be duplicated for each face it uses.
     *
     * Currently, the following file formats are supported:
     * -  [Wavefront obj file *.obj](https://en.wikipedia.org/wiki/Wavefront_.obj_file) (ONLY TRIANGULATED FACES)
     * -  [Polygon File Format *.ply](https://en.wikipedia.org/wiki/PLY_(file_format))
     * @param filename Name of the file
     * @param vertices vertex coordinates, each value contains 3 floats
     * @param indices per-face list of vertices, each value is a vector of ints
     * @param normals per-vertex normals, each value contains 3 floats
     * @param colors per-vertex colors, each value contains 3 floats
     */
    public static void loadMesh(String filename, Mat vertices, List<Mat> indices, Mat normals, Mat colors) {
        Mat indices_mat = new Mat();
        loadMesh_1(filename, vertices.nativeObj, indices_mat.nativeObj, normals.nativeObj, colors.nativeObj);
        Converters.Mat_to_vector_Mat(indices_mat, indices);
        indices_mat.release();
    }

    /**
     * Loads a mesh from a file.
     *
     * The function loads mesh from the specified file and returns it.
     * If the mesh cannot be read, throws an error
     * Vertex attributes (i.e. space and texture coodinates, normals and colors) are returned in same-sized
     * arrays with corresponding elements having the same indices.
     * This means that if a face uses a vertex with a normal or a texture coordinate with different indices
     * (which is typical for OBJ files for example), this vertex will be duplicated for each face it uses.
     *
     * Currently, the following file formats are supported:
     * -  [Wavefront obj file *.obj](https://en.wikipedia.org/wiki/Wavefront_.obj_file) (ONLY TRIANGULATED FACES)
     * -  [Polygon File Format *.ply](https://en.wikipedia.org/wiki/PLY_(file_format))
     * @param filename Name of the file
     * @param vertices vertex coordinates, each value contains 3 floats
     * @param indices per-face list of vertices, each value is a vector of ints
     * @param normals per-vertex normals, each value contains 3 floats
     */
    public static void loadMesh(String filename, Mat vertices, List<Mat> indices, Mat normals) {
        Mat indices_mat = new Mat();
        loadMesh_2(filename, vertices.nativeObj, indices_mat.nativeObj, normals.nativeObj);
        Converters.Mat_to_vector_Mat(indices_mat, indices);
        indices_mat.release();
    }

    /**
     * Loads a mesh from a file.
     *
     * The function loads mesh from the specified file and returns it.
     * If the mesh cannot be read, throws an error
     * Vertex attributes (i.e. space and texture coodinates, normals and colors) are returned in same-sized
     * arrays with corresponding elements having the same indices.
     * This means that if a face uses a vertex with a normal or a texture coordinate with different indices
     * (which is typical for OBJ files for example), this vertex will be duplicated for each face it uses.
     *
     * Currently, the following file formats are supported:
     * -  [Wavefront obj file *.obj](https://en.wikipedia.org/wiki/Wavefront_.obj_file) (ONLY TRIANGULATED FACES)
     * -  [Polygon File Format *.ply](https://en.wikipedia.org/wiki/PLY_(file_format))
     * @param filename Name of the file
     * @param vertices vertex coordinates, each value contains 3 floats
     * @param indices per-face list of vertices, each value is a vector of ints
     */
    public static void loadMesh(String filename, Mat vertices, List<Mat> indices) {
        Mat indices_mat = new Mat();
        loadMesh_3(filename, vertices.nativeObj, indices_mat.nativeObj);
        Converters.Mat_to_vector_Mat(indices_mat, indices);
        indices_mat.release();
    }


    //
    // C++:  void cv::saveMesh(String filename, Mat vertices, vector_Mat indices, Mat normals = Mat(), Mat colors = Mat(), Mat texCoords = Mat())
    //

    /**
     * Saves a mesh to a specified file.
     *
     * The function saves mesh to the specified file.
     * File format is chosen based on the filename extension.
     *
     * @param filename Name of the file.
     * @param vertices vertex coordinates, each value contains 3 floats
     * @param indices per-face list of vertices, each value is a vector of ints
     * @param normals per-vertex normals, each value contains 3 floats
     * @param colors per-vertex colors, each value contains 3 floats
     * @param texCoords per-vertex texture coordinates, each value contains 2 or 3 floats
     */
    public static void saveMesh(String filename, Mat vertices, List<Mat> indices, Mat normals, Mat colors, Mat texCoords) {
        Mat indices_mat = Converters.vector_Mat_to_Mat(indices);
        saveMesh_0(filename, vertices.nativeObj, indices_mat.nativeObj, normals.nativeObj, colors.nativeObj, texCoords.nativeObj);
    }

    /**
     * Saves a mesh to a specified file.
     *
     * The function saves mesh to the specified file.
     * File format is chosen based on the filename extension.
     *
     * @param filename Name of the file.
     * @param vertices vertex coordinates, each value contains 3 floats
     * @param indices per-face list of vertices, each value is a vector of ints
     * @param normals per-vertex normals, each value contains 3 floats
     * @param colors per-vertex colors, each value contains 3 floats
     */
    public static void saveMesh(String filename, Mat vertices, List<Mat> indices, Mat normals, Mat colors) {
        Mat indices_mat = Converters.vector_Mat_to_Mat(indices);
        saveMesh_1(filename, vertices.nativeObj, indices_mat.nativeObj, normals.nativeObj, colors.nativeObj);
    }

    /**
     * Saves a mesh to a specified file.
     *
     * The function saves mesh to the specified file.
     * File format is chosen based on the filename extension.
     *
     * @param filename Name of the file.
     * @param vertices vertex coordinates, each value contains 3 floats
     * @param indices per-face list of vertices, each value is a vector of ints
     * @param normals per-vertex normals, each value contains 3 floats
     */
    public static void saveMesh(String filename, Mat vertices, List<Mat> indices, Mat normals) {
        Mat indices_mat = Converters.vector_Mat_to_Mat(indices);
        saveMesh_2(filename, vertices.nativeObj, indices_mat.nativeObj, normals.nativeObj);
    }

    /**
     * Saves a mesh to a specified file.
     *
     * The function saves mesh to the specified file.
     * File format is chosen based on the filename extension.
     *
     * @param filename Name of the file.
     * @param vertices vertex coordinates, each value contains 3 floats
     * @param indices per-face list of vertices, each value is a vector of ints
     */
    public static void saveMesh(String filename, Mat vertices, List<Mat> indices) {
        Mat indices_mat = Converters.vector_Mat_to_Mat(indices);
        saveMesh_3(filename, vertices.nativeObj, indices_mat.nativeObj);
    }


    //
    // C++:  void cv::triangleRasterize(Mat vertices, Mat indices, Mat colors, Mat& colorBuf, Mat& depthBuf, Mat world2cam, double fovY, double zNear, double zFar, TriangleRasterizeSettings settings = TriangleRasterizeSettings())
    //

    /**
     * Renders a set of triangles on a depth and color image
     *
     * Triangles can be drawn white (1.0, 1.0, 1.0), flat-shaded or with a color interpolation between vertices.
     * In flat-shaded mode the 1st vertex color of each triangle is used to fill the whole triangle.
     *
     * The world2cam is an inverted camera pose matrix in fact. It transforms vertices from world to
     * camera coordinate system.
     *
     * The camera coordinate system emulates the OpenGL's coordinate system having coordinate origin in a screen center,
     * X axis pointing right, Y axis pointing up and Z axis pointing towards the viewer
     * except that image is vertically flipped after the render.
     * This means that all visible objects are placed in z-negative area, or exactly in -zNear &gt; z &gt; -zFar since
     * zNear and zFar are positive.
     * For example, at fovY = PI/2 the point (0, 1, -1) will be projected to (width/2, 0) screen point,
     * (1, 0, -1) to (width/2 + height/2, height/2). Increasing fovY makes projection smaller and vice versa.
     *
     * The function does not create or clear output images before the rendering. This means that it can be used
     * for drawing over an existing image or for rendering a model into a 3D scene using pre-filled Z-buffer.
     *
     * Empty scene results in a depth buffer filled by the maximum value since every pixel is infinitely far from the camera.
     * Therefore, before rendering anything from scratch the depthBuf should be filled by zFar values (or by ones in INVDEPTH mode).
     *
     * There are special versions of this function named triangleRasterizeDepth and triangleRasterizeColor
     * for cases if a user needs a color image or a depth image alone; they may run slightly faster.
     *
     * @param vertices vertices coordinates array. Should contain values of CV_32FC3 type or a compatible one (e.g. cv::Vec3f, etc.)
     * @param indices triangle vertices index array, 3 per triangle. Each index indicates a vertex in a vertices array.
     * Should contain CV_32SC3 values or compatible
     * @param colors per-vertex colors of CV_32FC3 type or compatible. Can be empty or the same size as vertices array.
     * If the values are out of [0; 1] range, the result correctness is not guaranteed
     * @param colorBuf an array representing the final rendered image. Should containt CV_32FC3 values and be the same size as depthBuf.
     * Not cleared before rendering, i.e. the content is reused as there is some pre-rendered scene.
     * @param depthBuf an array of floats containing resulting Z buffer. Should contain float values and be the same size as colorBuf.
     * Not cleared before rendering, i.e. the content is reused as there is some pre-rendered scene.
     * Empty scene corresponds to all values set to zFar (or to 1.0 in INVDEPTH mode)
     * @param world2cam a 4x3 or 4x4 float or double matrix containing inverted (sic!) camera pose
     * @param fovY field of view in vertical direction, given in radians
     * @param zNear minimum Z value to render, everything closer is clipped
     * @param zFar maximum Z value to render, everything farther is clipped
     * @param settings see TriangleRasterizeSettings. By default the smooth shading is on,
     * with CW culling and with disabled GL compatibility
     */
    public static void triangleRasterize(Mat vertices, Mat indices, Mat colors, Mat colorBuf, Mat depthBuf, Mat world2cam, double fovY, double zNear, double zFar, TriangleRasterizeSettings settings) {
        triangleRasterize_0(vertices.nativeObj, indices.nativeObj, colors.nativeObj, colorBuf.nativeObj, depthBuf.nativeObj, world2cam.nativeObj, fovY, zNear, zFar, settings.getNativeObjAddr());
    }

    /**
     * Renders a set of triangles on a depth and color image
     *
     * Triangles can be drawn white (1.0, 1.0, 1.0), flat-shaded or with a color interpolation between vertices.
     * In flat-shaded mode the 1st vertex color of each triangle is used to fill the whole triangle.
     *
     * The world2cam is an inverted camera pose matrix in fact. It transforms vertices from world to
     * camera coordinate system.
     *
     * The camera coordinate system emulates the OpenGL's coordinate system having coordinate origin in a screen center,
     * X axis pointing right, Y axis pointing up and Z axis pointing towards the viewer
     * except that image is vertically flipped after the render.
     * This means that all visible objects are placed in z-negative area, or exactly in -zNear &gt; z &gt; -zFar since
     * zNear and zFar are positive.
     * For example, at fovY = PI/2 the point (0, 1, -1) will be projected to (width/2, 0) screen point,
     * (1, 0, -1) to (width/2 + height/2, height/2). Increasing fovY makes projection smaller and vice versa.
     *
     * The function does not create or clear output images before the rendering. This means that it can be used
     * for drawing over an existing image or for rendering a model into a 3D scene using pre-filled Z-buffer.
     *
     * Empty scene results in a depth buffer filled by the maximum value since every pixel is infinitely far from the camera.
     * Therefore, before rendering anything from scratch the depthBuf should be filled by zFar values (or by ones in INVDEPTH mode).
     *
     * There are special versions of this function named triangleRasterizeDepth and triangleRasterizeColor
     * for cases if a user needs a color image or a depth image alone; they may run slightly faster.
     *
     * @param vertices vertices coordinates array. Should contain values of CV_32FC3 type or a compatible one (e.g. cv::Vec3f, etc.)
     * @param indices triangle vertices index array, 3 per triangle. Each index indicates a vertex in a vertices array.
     * Should contain CV_32SC3 values or compatible
     * @param colors per-vertex colors of CV_32FC3 type or compatible. Can be empty or the same size as vertices array.
     * If the values are out of [0; 1] range, the result correctness is not guaranteed
     * @param colorBuf an array representing the final rendered image. Should containt CV_32FC3 values and be the same size as depthBuf.
     * Not cleared before rendering, i.e. the content is reused as there is some pre-rendered scene.
     * @param depthBuf an array of floats containing resulting Z buffer. Should contain float values and be the same size as colorBuf.
     * Not cleared before rendering, i.e. the content is reused as there is some pre-rendered scene.
     * Empty scene corresponds to all values set to zFar (or to 1.0 in INVDEPTH mode)
     * @param world2cam a 4x3 or 4x4 float or double matrix containing inverted (sic!) camera pose
     * @param fovY field of view in vertical direction, given in radians
     * @param zNear minimum Z value to render, everything closer is clipped
     * @param zFar maximum Z value to render, everything farther is clipped
     * with CW culling and with disabled GL compatibility
     */
    public static void triangleRasterize(Mat vertices, Mat indices, Mat colors, Mat colorBuf, Mat depthBuf, Mat world2cam, double fovY, double zNear, double zFar) {
        triangleRasterize_1(vertices.nativeObj, indices.nativeObj, colors.nativeObj, colorBuf.nativeObj, depthBuf.nativeObj, world2cam.nativeObj, fovY, zNear, zFar);
    }


    //
    // C++:  void cv::triangleRasterizeDepth(Mat vertices, Mat indices, Mat& depthBuf, Mat world2cam, double fovY, double zNear, double zFar, TriangleRasterizeSettings settings = TriangleRasterizeSettings())
    //

    /**
     * Overloaded version of triangleRasterize() with depth-only rendering
     *
     * @param vertices vertices coordinates array. Should contain values of CV_32FC3 type or a compatible one (e.g. cv::Vec3f, etc.)
     * @param indices triangle vertices index array, 3 per triangle. Each index indicates a vertex in a vertices array.
     * Should contain CV_32SC3 values or compatible
     * @param depthBuf an array of floats containing resulting Z buffer. Should contain float values and be the same size as colorBuf.
     * Not cleared before rendering, i.e. the content is reused as there is some pre-rendered scene.
     * Empty scene corresponds to all values set to zFar (or to 1.0 in INVDEPTH mode)
     * @param world2cam a 4x3 or 4x4 float or double matrix containing inverted (sic!) camera pose
     * @param fovY field of view in vertical direction, given in radians
     * @param zNear minimum Z value to render, everything closer is clipped
     * @param zFar maximum Z value to render, everything farther is clipped
     * @param settings see TriangleRasterizeSettings. By default the smooth shading is on,
     * with CW culling and with disabled GL compatibility
     */
    public static void triangleRasterizeDepth(Mat vertices, Mat indices, Mat depthBuf, Mat world2cam, double fovY, double zNear, double zFar, TriangleRasterizeSettings settings) {
        triangleRasterizeDepth_0(vertices.nativeObj, indices.nativeObj, depthBuf.nativeObj, world2cam.nativeObj, fovY, zNear, zFar, settings.getNativeObjAddr());
    }

    /**
     * Overloaded version of triangleRasterize() with depth-only rendering
     *
     * @param vertices vertices coordinates array. Should contain values of CV_32FC3 type or a compatible one (e.g. cv::Vec3f, etc.)
     * @param indices triangle vertices index array, 3 per triangle. Each index indicates a vertex in a vertices array.
     * Should contain CV_32SC3 values or compatible
     * @param depthBuf an array of floats containing resulting Z buffer. Should contain float values and be the same size as colorBuf.
     * Not cleared before rendering, i.e. the content is reused as there is some pre-rendered scene.
     * Empty scene corresponds to all values set to zFar (or to 1.0 in INVDEPTH mode)
     * @param world2cam a 4x3 or 4x4 float or double matrix containing inverted (sic!) camera pose
     * @param fovY field of view in vertical direction, given in radians
     * @param zNear minimum Z value to render, everything closer is clipped
     * @param zFar maximum Z value to render, everything farther is clipped
     * with CW culling and with disabled GL compatibility
     */
    public static void triangleRasterizeDepth(Mat vertices, Mat indices, Mat depthBuf, Mat world2cam, double fovY, double zNear, double zFar) {
        triangleRasterizeDepth_1(vertices.nativeObj, indices.nativeObj, depthBuf.nativeObj, world2cam.nativeObj, fovY, zNear, zFar);
    }


    //
    // C++:  void cv::triangleRasterizeColor(Mat vertices, Mat indices, Mat colors, Mat& colorBuf, Mat world2cam, double fovY, double zNear, double zFar, TriangleRasterizeSettings settings = TriangleRasterizeSettings())
    //

    /**
     * Overloaded version of triangleRasterize() with color-only rendering
     *
     * @param vertices vertices coordinates array. Should contain values of CV_32FC3 type or a compatible one (e.g. cv::Vec3f, etc.)
     * @param indices triangle vertices index array, 3 per triangle. Each index indicates a vertex in a vertices array.
     * Should contain CV_32SC3 values or compatible
     * @param colors per-vertex colors of CV_32FC3 type or compatible. Can be empty or the same size as vertices array.
     * If the values are out of [0; 1] range, the result correctness is not guaranteed
     * @param colorBuf an array representing the final rendered image. Should containt CV_32FC3 values and be the same size as depthBuf.
     * Not cleared before rendering, i.e. the content is reused as there is some pre-rendered scene.
     * @param world2cam a 4x3 or 4x4 float or double matrix containing inverted (sic!) camera pose
     * @param fovY field of view in vertical direction, given in radians
     * @param zNear minimum Z value to render, everything closer is clipped
     * @param zFar maximum Z value to render, everything farther is clipped
     * @param settings see TriangleRasterizeSettings. By default the smooth shading is on,
     * with CW culling and with disabled GL compatibility
     */
    public static void triangleRasterizeColor(Mat vertices, Mat indices, Mat colors, Mat colorBuf, Mat world2cam, double fovY, double zNear, double zFar, TriangleRasterizeSettings settings) {
        triangleRasterizeColor_0(vertices.nativeObj, indices.nativeObj, colors.nativeObj, colorBuf.nativeObj, world2cam.nativeObj, fovY, zNear, zFar, settings.getNativeObjAddr());
    }

    /**
     * Overloaded version of triangleRasterize() with color-only rendering
     *
     * @param vertices vertices coordinates array. Should contain values of CV_32FC3 type or a compatible one (e.g. cv::Vec3f, etc.)
     * @param indices triangle vertices index array, 3 per triangle. Each index indicates a vertex in a vertices array.
     * Should contain CV_32SC3 values or compatible
     * @param colors per-vertex colors of CV_32FC3 type or compatible. Can be empty or the same size as vertices array.
     * If the values are out of [0; 1] range, the result correctness is not guaranteed
     * @param colorBuf an array representing the final rendered image. Should containt CV_32FC3 values and be the same size as depthBuf.
     * Not cleared before rendering, i.e. the content is reused as there is some pre-rendered scene.
     * @param world2cam a 4x3 or 4x4 float or double matrix containing inverted (sic!) camera pose
     * @param fovY field of view in vertical direction, given in radians
     * @param zNear minimum Z value to render, everything closer is clipped
     * @param zFar maximum Z value to render, everything farther is clipped
     * with CW culling and with disabled GL compatibility
     */
    public static void triangleRasterizeColor(Mat vertices, Mat indices, Mat colors, Mat colorBuf, Mat world2cam, double fovY, double zNear, double zFar) {
        triangleRasterizeColor_1(vertices.nativeObj, indices.nativeObj, colors.nativeObj, colorBuf.nativeObj, world2cam.nativeObj, fovY, zNear, zFar);
    }


    //
    // C++:  void cv::registerDepth(Mat unregisteredCameraMatrix, Mat registeredCameraMatrix, Mat registeredDistCoeffs, Mat Rt, Mat unregisteredDepth, Size outputImagePlaneSize, Mat& registeredDepth, bool depthDilation = false)
    //

    /**
     * Registers depth data to an external camera
     * Registration is performed by creating a depth cloud, transforming the cloud by
     * the rigid body transformation between the cameras, and then projecting the
     * transformed points into the RGB camera.
     *
     * uv_rgb = K_rgb * [R | t] * z * inv(K_ir) * uv_ir
     *
     * Currently does not check for negative depth values.
     *
     * @param unregisteredCameraMatrix the camera matrix of the depth camera
     * @param registeredCameraMatrix the camera matrix of the external camera
     * @param registeredDistCoeffs the distortion coefficients of the external camera
     * @param Rt the rigid body transform between the cameras. Transforms points from depth camera frame to external camera frame.
     * @param unregisteredDepth the input depth data
     * @param outputImagePlaneSize the image plane dimensions of the external camera (width, height)
     * @param registeredDepth the result of transforming the depth into the external camera
     * @param depthDilation whether or not the depth is dilated to avoid holes and occlusion errors (optional)
     */
    public static void registerDepth(Mat unregisteredCameraMatrix, Mat registeredCameraMatrix, Mat registeredDistCoeffs, Mat Rt, Mat unregisteredDepth, Size outputImagePlaneSize, Mat registeredDepth, boolean depthDilation) {
        registerDepth_0(unregisteredCameraMatrix.nativeObj, registeredCameraMatrix.nativeObj, registeredDistCoeffs.nativeObj, Rt.nativeObj, unregisteredDepth.nativeObj, outputImagePlaneSize.width, outputImagePlaneSize.height, registeredDepth.nativeObj, depthDilation);
    }

    /**
     * Registers depth data to an external camera
     * Registration is performed by creating a depth cloud, transforming the cloud by
     * the rigid body transformation between the cameras, and then projecting the
     * transformed points into the RGB camera.
     *
     * uv_rgb = K_rgb * [R | t] * z * inv(K_ir) * uv_ir
     *
     * Currently does not check for negative depth values.
     *
     * @param unregisteredCameraMatrix the camera matrix of the depth camera
     * @param registeredCameraMatrix the camera matrix of the external camera
     * @param registeredDistCoeffs the distortion coefficients of the external camera
     * @param Rt the rigid body transform between the cameras. Transforms points from depth camera frame to external camera frame.
     * @param unregisteredDepth the input depth data
     * @param outputImagePlaneSize the image plane dimensions of the external camera (width, height)
     * @param registeredDepth the result of transforming the depth into the external camera
     */
    public static void registerDepth(Mat unregisteredCameraMatrix, Mat registeredCameraMatrix, Mat registeredDistCoeffs, Mat Rt, Mat unregisteredDepth, Size outputImagePlaneSize, Mat registeredDepth) {
        registerDepth_1(unregisteredCameraMatrix.nativeObj, registeredCameraMatrix.nativeObj, registeredDistCoeffs.nativeObj, Rt.nativeObj, unregisteredDepth.nativeObj, outputImagePlaneSize.width, outputImagePlaneSize.height, registeredDepth.nativeObj);
    }


    //
    // C++:  void cv::depthTo3dSparse(Mat depth, Mat in_K, Mat in_points, Mat& points3d)
    //

    /**
     * @param depth the depth image
     * @param in_K
     * @param in_points the list of xy coordinates
     * @param points3d the resulting 3d points (point is represented by 4 chanels value [x, y, z, 0])
     */
    public static void depthTo3dSparse(Mat depth, Mat in_K, Mat in_points, Mat points3d) {
        depthTo3dSparse_0(depth.nativeObj, in_K.nativeObj, in_points.nativeObj, points3d.nativeObj);
    }


    //
    // C++:  void cv::depthTo3d(Mat depth, Mat K, Mat& points3d, Mat mask = Mat())
    //

    /**
     * Converts a depth image to 3d points. If the mask is empty then the resulting array has the same dimensions as {@code depth},
     * otherwise it is 1d vector containing mask-enabled values only.
     * The coordinate system is x pointing left, y down and z away from the camera
     * @param depth the depth image (if given as short int CV_U, it is assumed to be the depth in millimeters
     * (as done with the Microsoft Kinect), otherwise, if given as CV_32F or CV_64F, it is assumed in meters)
     * @param K The calibration matrix
     * @param points3d the resulting 3d points (point is represented by 4 channels value [x, y, z, 0]). They are of the same depth as {@code depth} if it is CV_32F or CV_64F, and the
     * depth of {@code K} if {@code depth} is of depth CV_16U or CV_16S
     * @param mask the mask of the points to consider (can be empty)
     */
    public static void depthTo3d(Mat depth, Mat K, Mat points3d, Mat mask) {
        depthTo3d_0(depth.nativeObj, K.nativeObj, points3d.nativeObj, mask.nativeObj);
    }

    /**
     * Converts a depth image to 3d points. If the mask is empty then the resulting array has the same dimensions as {@code depth},
     * otherwise it is 1d vector containing mask-enabled values only.
     * The coordinate system is x pointing left, y down and z away from the camera
     * @param depth the depth image (if given as short int CV_U, it is assumed to be the depth in millimeters
     * (as done with the Microsoft Kinect), otherwise, if given as CV_32F or CV_64F, it is assumed in meters)
     * @param K The calibration matrix
     * @param points3d the resulting 3d points (point is represented by 4 channels value [x, y, z, 0]). They are of the same depth as {@code depth} if it is CV_32F or CV_64F, and the
     * depth of {@code K} if {@code depth} is of depth CV_16U or CV_16S
     */
    public static void depthTo3d(Mat depth, Mat K, Mat points3d) {
        depthTo3d_1(depth.nativeObj, K.nativeObj, points3d.nativeObj);
    }


    //
    // C++:  void cv::rescaleDepth(Mat in, int type, Mat& out, double depth_factor = 1000.0)
    //

    /**
     * If the input image is of type CV_16UC1 (like the Kinect one), the image is converted to floats, divided
     * by depth_factor to get a depth in meters, and the values 0 are converted to std::numeric_limits&lt;float&gt;::quiet_NaN()
     * Otherwise, the image is simply converted to floats
     * @param in the depth image (if given as short int CV_U, it is assumed to be the depth in millimeters
     * (as done with the Microsoft Kinect), it is assumed in meters)
     * @param type the desired output depth (CV_32F or CV_64F)
     * @param out The rescaled float depth image
     * @param depth_factor (optional) factor by which depth is converted to distance (by default = 1000.0 for Kinect sensor)
     */
    public static void rescaleDepth(Mat in, int type, Mat out, double depth_factor) {
        rescaleDepth_0(in.nativeObj, type, out.nativeObj, depth_factor);
    }

    /**
     * If the input image is of type CV_16UC1 (like the Kinect one), the image is converted to floats, divided
     * by depth_factor to get a depth in meters, and the values 0 are converted to std::numeric_limits&lt;float&gt;::quiet_NaN()
     * Otherwise, the image is simply converted to floats
     * @param in the depth image (if given as short int CV_U, it is assumed to be the depth in millimeters
     * (as done with the Microsoft Kinect), it is assumed in meters)
     * @param type the desired output depth (CV_32F or CV_64F)
     * @param out The rescaled float depth image
     */
    public static void rescaleDepth(Mat in, int type, Mat out) {
        rescaleDepth_1(in.nativeObj, type, out.nativeObj);
    }


    //
    // C++:  void cv::warpFrame(Mat depth, Mat image, Mat mask, Mat Rt, Mat cameraMatrix, Mat& warpedDepth = Mat(), Mat& warpedImage = Mat(), Mat& warpedMask = Mat())
    //

    /**
     * Warps depth or RGB-D image by reprojecting it in 3d, applying Rt transformation
     * and then projecting it back onto the image plane.
     * This function can be used to visualize the results of the Odometry algorithm.
     * @param depth Depth data, should be 1-channel CV_16U, CV_16S, CV_32F or CV_64F
     * @param image RGB image (optional), should be 1-, 3- or 4-channel CV_8U
     * @param mask Mask of used pixels (optional), should be CV_8UC1, CV_8SC1 or CV_BoolC1
     * @param Rt Rotation+translation matrix (3x4 or 4x4) to be applied to depth points
     * @param cameraMatrix Camera intrinsics matrix (3x3)
     * @param warpedDepth The warped depth data (optional)
     * @param warpedImage The warped RGB image (optional)
     * @param warpedMask The mask of valid pixels in warped image (optional)
     */
    public static void warpFrame(Mat depth, Mat image, Mat mask, Mat Rt, Mat cameraMatrix, Mat warpedDepth, Mat warpedImage, Mat warpedMask) {
        warpFrame_0(depth.nativeObj, image.nativeObj, mask.nativeObj, Rt.nativeObj, cameraMatrix.nativeObj, warpedDepth.nativeObj, warpedImage.nativeObj, warpedMask.nativeObj);
    }

    /**
     * Warps depth or RGB-D image by reprojecting it in 3d, applying Rt transformation
     * and then projecting it back onto the image plane.
     * This function can be used to visualize the results of the Odometry algorithm.
     * @param depth Depth data, should be 1-channel CV_16U, CV_16S, CV_32F or CV_64F
     * @param image RGB image (optional), should be 1-, 3- or 4-channel CV_8U
     * @param mask Mask of used pixels (optional), should be CV_8UC1, CV_8SC1 or CV_BoolC1
     * @param Rt Rotation+translation matrix (3x4 or 4x4) to be applied to depth points
     * @param cameraMatrix Camera intrinsics matrix (3x3)
     * @param warpedDepth The warped depth data (optional)
     * @param warpedImage The warped RGB image (optional)
     */
    public static void warpFrame(Mat depth, Mat image, Mat mask, Mat Rt, Mat cameraMatrix, Mat warpedDepth, Mat warpedImage) {
        warpFrame_1(depth.nativeObj, image.nativeObj, mask.nativeObj, Rt.nativeObj, cameraMatrix.nativeObj, warpedDepth.nativeObj, warpedImage.nativeObj);
    }

    /**
     * Warps depth or RGB-D image by reprojecting it in 3d, applying Rt transformation
     * and then projecting it back onto the image plane.
     * This function can be used to visualize the results of the Odometry algorithm.
     * @param depth Depth data, should be 1-channel CV_16U, CV_16S, CV_32F or CV_64F
     * @param image RGB image (optional), should be 1-, 3- or 4-channel CV_8U
     * @param mask Mask of used pixels (optional), should be CV_8UC1, CV_8SC1 or CV_BoolC1
     * @param Rt Rotation+translation matrix (3x4 or 4x4) to be applied to depth points
     * @param cameraMatrix Camera intrinsics matrix (3x3)
     * @param warpedDepth The warped depth data (optional)
     */
    public static void warpFrame(Mat depth, Mat image, Mat mask, Mat Rt, Mat cameraMatrix, Mat warpedDepth) {
        warpFrame_2(depth.nativeObj, image.nativeObj, mask.nativeObj, Rt.nativeObj, cameraMatrix.nativeObj, warpedDepth.nativeObj);
    }

    /**
     * Warps depth or RGB-D image by reprojecting it in 3d, applying Rt transformation
     * and then projecting it back onto the image plane.
     * This function can be used to visualize the results of the Odometry algorithm.
     * @param depth Depth data, should be 1-channel CV_16U, CV_16S, CV_32F or CV_64F
     * @param image RGB image (optional), should be 1-, 3- or 4-channel CV_8U
     * @param mask Mask of used pixels (optional), should be CV_8UC1, CV_8SC1 or CV_BoolC1
     * @param Rt Rotation+translation matrix (3x4 or 4x4) to be applied to depth points
     * @param cameraMatrix Camera intrinsics matrix (3x3)
     */
    public static void warpFrame(Mat depth, Mat image, Mat mask, Mat Rt, Mat cameraMatrix) {
        warpFrame_3(depth.nativeObj, image.nativeObj, mask.nativeObj, Rt.nativeObj, cameraMatrix.nativeObj);
    }


    //
    // C++:  void cv::findPlanes(Mat points3d, Mat normals, Mat& mask, Mat& plane_coefficients, int block_size = 40, int min_size = 40*40, double threshold = 0.01, double sensor_error_a = 0, double sensor_error_b = 0, double sensor_error_c = 0, RgbdPlaneMethod method = RGBD_PLANE_METHOD_DEFAULT)
    //

    /**
     * Find the planes in a depth image
     * @param points3d the 3d points organized like the depth image: rows x cols with 3 channels
     * @param normals the normals for every point in the depth image; optional, can be empty
     * @param mask An image where each pixel is labeled with the plane it belongs to
     * and 255 if it does not belong to any plane
     * @param plane_coefficients the coefficients of the corresponding planes (a,b,c,d) such that ax+by+cz+d=0, norm(a,b,c)=1
     * and c &lt; 0 (so that the normal points towards the camera)
     * @param block_size The size of the blocks to look at for a stable MSE
     * @param min_size The minimum size of a cluster to be considered a plane
     * @param threshold The maximum distance of a point from a plane to belong to it (in meters)
     * @param sensor_error_a coefficient of the sensor error. 0 by default, use 0.0075 for a Kinect
     * @param sensor_error_b coefficient of the sensor error. 0 by default
     * @param sensor_error_c coefficient of the sensor error. 0 by default
     * @param method The method to use to compute the planes.
     */
    public static void findPlanes(Mat points3d, Mat normals, Mat mask, Mat plane_coefficients, int block_size, int min_size, double threshold, double sensor_error_a, double sensor_error_b, double sensor_error_c, int method) {
        findPlanes_0(points3d.nativeObj, normals.nativeObj, mask.nativeObj, plane_coefficients.nativeObj, block_size, min_size, threshold, sensor_error_a, sensor_error_b, sensor_error_c, method);
    }

    /**
     * Find the planes in a depth image
     * @param points3d the 3d points organized like the depth image: rows x cols with 3 channels
     * @param normals the normals for every point in the depth image; optional, can be empty
     * @param mask An image where each pixel is labeled with the plane it belongs to
     * and 255 if it does not belong to any plane
     * @param plane_coefficients the coefficients of the corresponding planes (a,b,c,d) such that ax+by+cz+d=0, norm(a,b,c)=1
     * and c &lt; 0 (so that the normal points towards the camera)
     * @param block_size The size of the blocks to look at for a stable MSE
     * @param min_size The minimum size of a cluster to be considered a plane
     * @param threshold The maximum distance of a point from a plane to belong to it (in meters)
     * @param sensor_error_a coefficient of the sensor error. 0 by default, use 0.0075 for a Kinect
     * @param sensor_error_b coefficient of the sensor error. 0 by default
     * @param sensor_error_c coefficient of the sensor error. 0 by default
     */
    public static void findPlanes(Mat points3d, Mat normals, Mat mask, Mat plane_coefficients, int block_size, int min_size, double threshold, double sensor_error_a, double sensor_error_b, double sensor_error_c) {
        findPlanes_1(points3d.nativeObj, normals.nativeObj, mask.nativeObj, plane_coefficients.nativeObj, block_size, min_size, threshold, sensor_error_a, sensor_error_b, sensor_error_c);
    }

    /**
     * Find the planes in a depth image
     * @param points3d the 3d points organized like the depth image: rows x cols with 3 channels
     * @param normals the normals for every point in the depth image; optional, can be empty
     * @param mask An image where each pixel is labeled with the plane it belongs to
     * and 255 if it does not belong to any plane
     * @param plane_coefficients the coefficients of the corresponding planes (a,b,c,d) such that ax+by+cz+d=0, norm(a,b,c)=1
     * and c &lt; 0 (so that the normal points towards the camera)
     * @param block_size The size of the blocks to look at for a stable MSE
     * @param min_size The minimum size of a cluster to be considered a plane
     * @param threshold The maximum distance of a point from a plane to belong to it (in meters)
     * @param sensor_error_a coefficient of the sensor error. 0 by default, use 0.0075 for a Kinect
     * @param sensor_error_b coefficient of the sensor error. 0 by default
     */
    public static void findPlanes(Mat points3d, Mat normals, Mat mask, Mat plane_coefficients, int block_size, int min_size, double threshold, double sensor_error_a, double sensor_error_b) {
        findPlanes_2(points3d.nativeObj, normals.nativeObj, mask.nativeObj, plane_coefficients.nativeObj, block_size, min_size, threshold, sensor_error_a, sensor_error_b);
    }

    /**
     * Find the planes in a depth image
     * @param points3d the 3d points organized like the depth image: rows x cols with 3 channels
     * @param normals the normals for every point in the depth image; optional, can be empty
     * @param mask An image where each pixel is labeled with the plane it belongs to
     * and 255 if it does not belong to any plane
     * @param plane_coefficients the coefficients of the corresponding planes (a,b,c,d) such that ax+by+cz+d=0, norm(a,b,c)=1
     * and c &lt; 0 (so that the normal points towards the camera)
     * @param block_size The size of the blocks to look at for a stable MSE
     * @param min_size The minimum size of a cluster to be considered a plane
     * @param threshold The maximum distance of a point from a plane to belong to it (in meters)
     * @param sensor_error_a coefficient of the sensor error. 0 by default, use 0.0075 for a Kinect
     */
    public static void findPlanes(Mat points3d, Mat normals, Mat mask, Mat plane_coefficients, int block_size, int min_size, double threshold, double sensor_error_a) {
        findPlanes_3(points3d.nativeObj, normals.nativeObj, mask.nativeObj, plane_coefficients.nativeObj, block_size, min_size, threshold, sensor_error_a);
    }

    /**
     * Find the planes in a depth image
     * @param points3d the 3d points organized like the depth image: rows x cols with 3 channels
     * @param normals the normals for every point in the depth image; optional, can be empty
     * @param mask An image where each pixel is labeled with the plane it belongs to
     * and 255 if it does not belong to any plane
     * @param plane_coefficients the coefficients of the corresponding planes (a,b,c,d) such that ax+by+cz+d=0, norm(a,b,c)=1
     * and c &lt; 0 (so that the normal points towards the camera)
     * @param block_size The size of the blocks to look at for a stable MSE
     * @param min_size The minimum size of a cluster to be considered a plane
     * @param threshold The maximum distance of a point from a plane to belong to it (in meters)
     */
    public static void findPlanes(Mat points3d, Mat normals, Mat mask, Mat plane_coefficients, int block_size, int min_size, double threshold) {
        findPlanes_4(points3d.nativeObj, normals.nativeObj, mask.nativeObj, plane_coefficients.nativeObj, block_size, min_size, threshold);
    }

    /**
     * Find the planes in a depth image
     * @param points3d the 3d points organized like the depth image: rows x cols with 3 channels
     * @param normals the normals for every point in the depth image; optional, can be empty
     * @param mask An image where each pixel is labeled with the plane it belongs to
     * and 255 if it does not belong to any plane
     * @param plane_coefficients the coefficients of the corresponding planes (a,b,c,d) such that ax+by+cz+d=0, norm(a,b,c)=1
     * and c &lt; 0 (so that the normal points towards the camera)
     * @param block_size The size of the blocks to look at for a stable MSE
     * @param min_size The minimum size of a cluster to be considered a plane
     */
    public static void findPlanes(Mat points3d, Mat normals, Mat mask, Mat plane_coefficients, int block_size, int min_size) {
        findPlanes_5(points3d.nativeObj, normals.nativeObj, mask.nativeObj, plane_coefficients.nativeObj, block_size, min_size);
    }

    /**
     * Find the planes in a depth image
     * @param points3d the 3d points organized like the depth image: rows x cols with 3 channels
     * @param normals the normals for every point in the depth image; optional, can be empty
     * @param mask An image where each pixel is labeled with the plane it belongs to
     * and 255 if it does not belong to any plane
     * @param plane_coefficients the coefficients of the corresponding planes (a,b,c,d) such that ax+by+cz+d=0, norm(a,b,c)=1
     * and c &lt; 0 (so that the normal points towards the camera)
     * @param block_size The size of the blocks to look at for a stable MSE
     */
    public static void findPlanes(Mat points3d, Mat normals, Mat mask, Mat plane_coefficients, int block_size) {
        findPlanes_6(points3d.nativeObj, normals.nativeObj, mask.nativeObj, plane_coefficients.nativeObj, block_size);
    }

    /**
     * Find the planes in a depth image
     * @param points3d the 3d points organized like the depth image: rows x cols with 3 channels
     * @param normals the normals for every point in the depth image; optional, can be empty
     * @param mask An image where each pixel is labeled with the plane it belongs to
     * and 255 if it does not belong to any plane
     * @param plane_coefficients the coefficients of the corresponding planes (a,b,c,d) such that ax+by+cz+d=0, norm(a,b,c)=1
     * and c &lt; 0 (so that the normal points towards the camera)
     */
    public static void findPlanes(Mat points3d, Mat normals, Mat mask, Mat plane_coefficients) {
        findPlanes_7(points3d.nativeObj, normals.nativeObj, mask.nativeObj, plane_coefficients.nativeObj);
    }




    // C++:  void cv::loadPointCloud(String filename, Mat& vertices, Mat& normals = Mat(), Mat& rgb = Mat())
    private static native void loadPointCloud_0(String filename, long vertices_nativeObj, long normals_nativeObj, long rgb_nativeObj);
    private static native void loadPointCloud_1(String filename, long vertices_nativeObj, long normals_nativeObj);
    private static native void loadPointCloud_2(String filename, long vertices_nativeObj);

    // C++:  void cv::savePointCloud(String filename, Mat vertices, Mat normals = Mat(), Mat rgb = Mat())
    private static native void savePointCloud_0(String filename, long vertices_nativeObj, long normals_nativeObj, long rgb_nativeObj);
    private static native void savePointCloud_1(String filename, long vertices_nativeObj, long normals_nativeObj);
    private static native void savePointCloud_2(String filename, long vertices_nativeObj);

    // C++:  void cv::loadMesh(String filename, Mat& vertices, vector_Mat& indices, Mat& normals = Mat(), Mat& colors = Mat(), Mat& texCoords = Mat())
    private static native void loadMesh_0(String filename, long vertices_nativeObj, long indices_mat_nativeObj, long normals_nativeObj, long colors_nativeObj, long texCoords_nativeObj);
    private static native void loadMesh_1(String filename, long vertices_nativeObj, long indices_mat_nativeObj, long normals_nativeObj, long colors_nativeObj);
    private static native void loadMesh_2(String filename, long vertices_nativeObj, long indices_mat_nativeObj, long normals_nativeObj);
    private static native void loadMesh_3(String filename, long vertices_nativeObj, long indices_mat_nativeObj);

    // C++:  void cv::saveMesh(String filename, Mat vertices, vector_Mat indices, Mat normals = Mat(), Mat colors = Mat(), Mat texCoords = Mat())
    private static native void saveMesh_0(String filename, long vertices_nativeObj, long indices_mat_nativeObj, long normals_nativeObj, long colors_nativeObj, long texCoords_nativeObj);
    private static native void saveMesh_1(String filename, long vertices_nativeObj, long indices_mat_nativeObj, long normals_nativeObj, long colors_nativeObj);
    private static native void saveMesh_2(String filename, long vertices_nativeObj, long indices_mat_nativeObj, long normals_nativeObj);
    private static native void saveMesh_3(String filename, long vertices_nativeObj, long indices_mat_nativeObj);

    // C++:  void cv::triangleRasterize(Mat vertices, Mat indices, Mat colors, Mat& colorBuf, Mat& depthBuf, Mat world2cam, double fovY, double zNear, double zFar, TriangleRasterizeSettings settings = TriangleRasterizeSettings())
    private static native void triangleRasterize_0(long vertices_nativeObj, long indices_nativeObj, long colors_nativeObj, long colorBuf_nativeObj, long depthBuf_nativeObj, long world2cam_nativeObj, double fovY, double zNear, double zFar, long settings_nativeObj);
    private static native void triangleRasterize_1(long vertices_nativeObj, long indices_nativeObj, long colors_nativeObj, long colorBuf_nativeObj, long depthBuf_nativeObj, long world2cam_nativeObj, double fovY, double zNear, double zFar);

    // C++:  void cv::triangleRasterizeDepth(Mat vertices, Mat indices, Mat& depthBuf, Mat world2cam, double fovY, double zNear, double zFar, TriangleRasterizeSettings settings = TriangleRasterizeSettings())
    private static native void triangleRasterizeDepth_0(long vertices_nativeObj, long indices_nativeObj, long depthBuf_nativeObj, long world2cam_nativeObj, double fovY, double zNear, double zFar, long settings_nativeObj);
    private static native void triangleRasterizeDepth_1(long vertices_nativeObj, long indices_nativeObj, long depthBuf_nativeObj, long world2cam_nativeObj, double fovY, double zNear, double zFar);

    // C++:  void cv::triangleRasterizeColor(Mat vertices, Mat indices, Mat colors, Mat& colorBuf, Mat world2cam, double fovY, double zNear, double zFar, TriangleRasterizeSettings settings = TriangleRasterizeSettings())
    private static native void triangleRasterizeColor_0(long vertices_nativeObj, long indices_nativeObj, long colors_nativeObj, long colorBuf_nativeObj, long world2cam_nativeObj, double fovY, double zNear, double zFar, long settings_nativeObj);
    private static native void triangleRasterizeColor_1(long vertices_nativeObj, long indices_nativeObj, long colors_nativeObj, long colorBuf_nativeObj, long world2cam_nativeObj, double fovY, double zNear, double zFar);

    // C++:  void cv::registerDepth(Mat unregisteredCameraMatrix, Mat registeredCameraMatrix, Mat registeredDistCoeffs, Mat Rt, Mat unregisteredDepth, Size outputImagePlaneSize, Mat& registeredDepth, bool depthDilation = false)
    private static native void registerDepth_0(long unregisteredCameraMatrix_nativeObj, long registeredCameraMatrix_nativeObj, long registeredDistCoeffs_nativeObj, long Rt_nativeObj, long unregisteredDepth_nativeObj, double outputImagePlaneSize_width, double outputImagePlaneSize_height, long registeredDepth_nativeObj, boolean depthDilation);
    private static native void registerDepth_1(long unregisteredCameraMatrix_nativeObj, long registeredCameraMatrix_nativeObj, long registeredDistCoeffs_nativeObj, long Rt_nativeObj, long unregisteredDepth_nativeObj, double outputImagePlaneSize_width, double outputImagePlaneSize_height, long registeredDepth_nativeObj);

    // C++:  void cv::depthTo3dSparse(Mat depth, Mat in_K, Mat in_points, Mat& points3d)
    private static native void depthTo3dSparse_0(long depth_nativeObj, long in_K_nativeObj, long in_points_nativeObj, long points3d_nativeObj);

    // C++:  void cv::depthTo3d(Mat depth, Mat K, Mat& points3d, Mat mask = Mat())
    private static native void depthTo3d_0(long depth_nativeObj, long K_nativeObj, long points3d_nativeObj, long mask_nativeObj);
    private static native void depthTo3d_1(long depth_nativeObj, long K_nativeObj, long points3d_nativeObj);

    // C++:  void cv::rescaleDepth(Mat in, int type, Mat& out, double depth_factor = 1000.0)
    private static native void rescaleDepth_0(long in_nativeObj, int type, long out_nativeObj, double depth_factor);
    private static native void rescaleDepth_1(long in_nativeObj, int type, long out_nativeObj);

    // C++:  void cv::warpFrame(Mat depth, Mat image, Mat mask, Mat Rt, Mat cameraMatrix, Mat& warpedDepth = Mat(), Mat& warpedImage = Mat(), Mat& warpedMask = Mat())
    private static native void warpFrame_0(long depth_nativeObj, long image_nativeObj, long mask_nativeObj, long Rt_nativeObj, long cameraMatrix_nativeObj, long warpedDepth_nativeObj, long warpedImage_nativeObj, long warpedMask_nativeObj);
    private static native void warpFrame_1(long depth_nativeObj, long image_nativeObj, long mask_nativeObj, long Rt_nativeObj, long cameraMatrix_nativeObj, long warpedDepth_nativeObj, long warpedImage_nativeObj);
    private static native void warpFrame_2(long depth_nativeObj, long image_nativeObj, long mask_nativeObj, long Rt_nativeObj, long cameraMatrix_nativeObj, long warpedDepth_nativeObj);
    private static native void warpFrame_3(long depth_nativeObj, long image_nativeObj, long mask_nativeObj, long Rt_nativeObj, long cameraMatrix_nativeObj);

    // C++:  void cv::findPlanes(Mat points3d, Mat normals, Mat& mask, Mat& plane_coefficients, int block_size = 40, int min_size = 40*40, double threshold = 0.01, double sensor_error_a = 0, double sensor_error_b = 0, double sensor_error_c = 0, RgbdPlaneMethod method = RGBD_PLANE_METHOD_DEFAULT)
    private static native void findPlanes_0(long points3d_nativeObj, long normals_nativeObj, long mask_nativeObj, long plane_coefficients_nativeObj, int block_size, int min_size, double threshold, double sensor_error_a, double sensor_error_b, double sensor_error_c, int method);
    private static native void findPlanes_1(long points3d_nativeObj, long normals_nativeObj, long mask_nativeObj, long plane_coefficients_nativeObj, int block_size, int min_size, double threshold, double sensor_error_a, double sensor_error_b, double sensor_error_c);
    private static native void findPlanes_2(long points3d_nativeObj, long normals_nativeObj, long mask_nativeObj, long plane_coefficients_nativeObj, int block_size, int min_size, double threshold, double sensor_error_a, double sensor_error_b);
    private static native void findPlanes_3(long points3d_nativeObj, long normals_nativeObj, long mask_nativeObj, long plane_coefficients_nativeObj, int block_size, int min_size, double threshold, double sensor_error_a);
    private static native void findPlanes_4(long points3d_nativeObj, long normals_nativeObj, long mask_nativeObj, long plane_coefficients_nativeObj, int block_size, int min_size, double threshold);
    private static native void findPlanes_5(long points3d_nativeObj, long normals_nativeObj, long mask_nativeObj, long plane_coefficients_nativeObj, int block_size, int min_size);
    private static native void findPlanes_6(long points3d_nativeObj, long normals_nativeObj, long mask_nativeObj, long plane_coefficients_nativeObj, int block_size);
    private static native void findPlanes_7(long points3d_nativeObj, long normals_nativeObj, long mask_nativeObj, long plane_coefficients_nativeObj);

}
