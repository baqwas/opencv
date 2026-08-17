//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.calib;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.MatOfPoint3f;
import org.opencv.core.Size;
import org.opencv.core.TermCriteria;
import org.opencv.utils.Converters;

// C++: class Calib

public class Calib {

    // C++: enum <unnamed>
    public static final int
            CALIB_USE_INTRINSIC_GUESS = 0x00001,
            CALIB_FIX_ASPECT_RATIO = 0x00002,
            CALIB_FIX_PRINCIPAL_POINT = 0x00004,
            CALIB_ZERO_TANGENT_DIST = 0x00008,
            CALIB_FIX_FOCAL_LENGTH = 0x00010,
            CALIB_FIX_K1 = 0x00020,
            CALIB_FIX_K2 = 0x00040,
            CALIB_FIX_K3 = 0x00080,
            CALIB_FIX_K4 = 0x00800,
            CALIB_FIX_K5 = 0x01000,
            CALIB_FIX_K6 = 0x02000,
            CALIB_RATIONAL_MODEL = 0x04000,
            CALIB_THIN_PRISM_MODEL = 0x08000,
            CALIB_FIX_S1_S2_S3_S4 = 0x10000,
            CALIB_TILTED_MODEL = 0x40000,
            CALIB_FIX_TAUX_TAUY = 0x80000,
            CALIB_USE_QR = 0x100000,
            CALIB_FIX_TANGENT_DIST = 0x200000,
            CALIB_FIX_INTRINSIC = 0x00100,
            CALIB_SAME_FOCAL_LENGTH = 0x00200,
            CALIB_ZERO_DISPARITY = 0x00400,
            CALIB_USE_LU = (1 << 17),
            CALIB_DISABLE_SCHUR_COMPLEMENT = (1 << 18),
            CALIB_USE_EXTRINSIC_GUESS = (1 << 22),
            CALIB_RECOMPUTE_EXTRINSIC = (1 << 23),
            CALIB_CHECK_COND = (1 << 24),
            CALIB_FIX_SKEW = (1 << 25),
            CALIB_STEREO_REGISTRATION = (1 << 26);


    // C++: enum CameraModel (cv.CameraModel)
    public static final int
            CALIB_MODEL_PINHOLE = 0,
            CALIB_MODEL_FISHEYE = 1;


    // C++: enum HandEyeCalibrationMethod (cv.HandEyeCalibrationMethod)
    public static final int
            CALIB_HAND_EYE_TSAI = 0,
            CALIB_HAND_EYE_PARK = 1,
            CALIB_HAND_EYE_HORAUD = 2,
            CALIB_HAND_EYE_ANDREFF = 3,
            CALIB_HAND_EYE_DANIILIDIS = 4;


    // C++: enum RobotWorldHandEyeCalibrationMethod (cv.RobotWorldHandEyeCalibrationMethod)
    public static final int
            CALIB_ROBOT_WORLD_HAND_EYE_SHAH = 0,
            CALIB_ROBOT_WORLD_HAND_EYE_LI = 1;


    //
    // C++:  Mat cv::initCameraMatrix2D(vector_vector_Point3f objectPoints, vector_vector_Point2f imagePoints, Size imageSize, double aspectRatio = 1.0)
    //

    /**
     * Finds an initial camera intrinsic matrix from 3D-2D point correspondences.
     *
     * @param objectPoints Vector of vectors of the calibration pattern points in the calibration pattern
     * coordinate space. In the old interface all the per-view vectors are concatenated. See
     * #calibrateCamera for details.
     * @param imagePoints Vector of vectors of the projections of the calibration pattern points. In the
     * old interface all the per-view vectors are concatenated.
     * @param imageSize Image size in pixels used to initialize the principal point.
     * @param aspectRatio If it is zero or negative, both \(f_x\) and \(f_y\) are estimated independently.
     * Otherwise, \(f_x = f_y \cdot \texttt{aspectRatio}\) .
     *
     * The function estimates and returns an initial camera intrinsic matrix for the camera calibration process.
     * Currently, the function only supports planar calibration patterns, which are patterns where each
     * object point has z-coordinate =0.
     * @return automatically generated
     */
    public static Mat initCameraMatrix2D(List<MatOfPoint3f> objectPoints, List<MatOfPoint2f> imagePoints, Size imageSize, double aspectRatio) {
        List<Mat> objectPoints_tmplm = new ArrayList<Mat>((objectPoints != null) ? objectPoints.size() : 0);
        Mat objectPoints_mat = Converters.vector_vector_Point3f_to_Mat(objectPoints, objectPoints_tmplm);
        List<Mat> imagePoints_tmplm = new ArrayList<Mat>((imagePoints != null) ? imagePoints.size() : 0);
        Mat imagePoints_mat = Converters.vector_vector_Point2f_to_Mat(imagePoints, imagePoints_tmplm);
        return new Mat(initCameraMatrix2D_0(objectPoints_mat.nativeObj, imagePoints_mat.nativeObj, imageSize.width, imageSize.height, aspectRatio));
    }

    /**
     * Finds an initial camera intrinsic matrix from 3D-2D point correspondences.
     *
     * @param objectPoints Vector of vectors of the calibration pattern points in the calibration pattern
     * coordinate space. In the old interface all the per-view vectors are concatenated. See
     * #calibrateCamera for details.
     * @param imagePoints Vector of vectors of the projections of the calibration pattern points. In the
     * old interface all the per-view vectors are concatenated.
     * @param imageSize Image size in pixels used to initialize the principal point.
     * Otherwise, \(f_x = f_y \cdot \texttt{aspectRatio}\) .
     *
     * The function estimates and returns an initial camera intrinsic matrix for the camera calibration process.
     * Currently, the function only supports planar calibration patterns, which are patterns where each
     * object point has z-coordinate =0.
     * @return automatically generated
     */
    public static Mat initCameraMatrix2D(List<MatOfPoint3f> objectPoints, List<MatOfPoint2f> imagePoints, Size imageSize) {
        List<Mat> objectPoints_tmplm = new ArrayList<Mat>((objectPoints != null) ? objectPoints.size() : 0);
        Mat objectPoints_mat = Converters.vector_vector_Point3f_to_Mat(objectPoints, objectPoints_tmplm);
        List<Mat> imagePoints_tmplm = new ArrayList<Mat>((imagePoints != null) ? imagePoints.size() : 0);
        Mat imagePoints_mat = Converters.vector_vector_Point2f_to_Mat(imagePoints, imagePoints_tmplm);
        return new Mat(initCameraMatrix2D_1(objectPoints_mat.nativeObj, imagePoints_mat.nativeObj, imageSize.width, imageSize.height));
    }


    //
    // C++:  double cv::calibrateCamera(vector_Mat objectPoints, vector_Mat imagePoints, Size imageSize, Mat& cameraMatrix, Mat& distCoeffs, vector_Mat& rvecs, vector_Mat& tvecs, Mat& stdDeviationsIntrinsics, Mat& stdDeviationsExtrinsics, Mat& perViewErrors, int flags = 0, TermCriteria criteria = TermCriteria( TermCriteria::COUNT + TermCriteria::EPS, 500, DBL_EPSILON))
    //

    /**
     * Finds the camera intrinsic and extrinsic parameters from several views of a calibration
     * pattern.
     *
     * @param objectPoints In the new interface it is a vector of vectors of calibration pattern points in
     * the calibration pattern coordinate space (e.g. std::vector&lt;std::vector&lt;cv::Vec3f&gt;&gt;). The outer
     * vector contains as many elements as the number of pattern views. If the same calibration pattern
     * is shown in each view and it is fully visible, all the vectors will be the same. Although, it is
     * possible to use partially occluded patterns or even different patterns in different views. Then,
     * the vectors will be different. Although the points are 3D, they all lie in the calibration pattern's
     * XY coordinate plane (thus 0 in the Z-coordinate), if the used calibration pattern is a planar rig.
     * In the old interface all the vectors of object points from different views are concatenated
     * together.
     * @param imagePoints In the new interface it is a vector of vectors of the projections of calibration
     * pattern points (e.g. std::vector&lt;std::vector&lt;cv::Vec2f&gt;&gt;). imagePoints.size() and
     * objectPoints.size(), and imagePoints[i].size() and objectPoints[i].size() for each i, must be equal,
     * respectively. In the old interface all the vectors of object points from different views are
     * concatenated together.
     * @param imageSize Size of the image used only to initialize the camera intrinsic matrix.
     * @param cameraMatrix Input/output 3x3 floating-point camera intrinsic matrix
     * \(\cameramatrix{A}\) . If REF: CALIB_USE_INTRINSIC_GUESS
     * and/or REF: CALIB_FIX_ASPECT_RATIO, REF: CALIB_FIX_PRINCIPAL_POINT or REF: CALIB_FIX_FOCAL_LENGTH
     * are specified, some or all of fx, fy, cx, cy must be initialized before calling the function.
     * @param distCoeffs Input/output vector of distortion coefficients
     * \(\distcoeffs\).
     * @param rvecs Output vector of rotation vectors (REF: Rodrigues ) estimated for each pattern view
     * (e.g. std::vector&lt;cv::Mat&gt;&gt;). That is, each i-th rotation vector together with the corresponding
     * i-th translation vector (see the next output parameter description) brings the calibration pattern
     * from the object coordinate space (in which object points are specified) to the camera coordinate
     * space. In more technical terms, the tuple of the i-th rotation and translation vector performs
     * a change of basis from object coordinate space to camera coordinate space. Due to its duality, this
     * tuple is equivalent to the position of the calibration pattern with respect to the camera coordinate
     * space.
     * @param tvecs Output vector of translation vectors estimated for each pattern view, see parameter
     * description above.
     * @param stdDeviationsIntrinsics Output vector of standard deviations estimated for intrinsic
     * parameters. Order of deviations values:
     * \((f_x, f_y, c_x, c_y, k_1, k_2, p_1, p_2, k_3, k_4, k_5, k_6 , s_1, s_2, s_3,
     *  s_4, \tau_x, \tau_y)\) If one of parameters is not estimated, it's deviation is equals to zero.
     * @param stdDeviationsExtrinsics Output vector of standard deviations estimated for extrinsic
     * parameters. Order of deviations values: \((R_0, T_0, \dotsc , R_{M - 1}, T_{M - 1})\) where M is
     * the number of pattern views. \(R_i, T_i\) are concatenated 1x3 vectors.
     *  @param perViewErrors Output vector of the RMS re-projection error estimated for each pattern view.
     * @param flags Different flags that may be zero or a combination of the following values:
     * <ul>
     *   <li>
     *    REF: CALIB_USE_INTRINSIC_GUESS cameraMatrix contains valid initial values of
     * fx, fy, cx, cy that are optimized further. Otherwise, (cx, cy) is initially set to the image
     * center ( imageSize is used), and focal distances are computed in a least-squares fashion.
     * Note, that if intrinsic parameters are known, there is no need to use this function just to
     * estimate extrinsic parameters. Use REF: solvePnP instead.
     *   </li>
     *   <li>
     *    REF: CALIB_DISABLE_SCHUR_COMPLEMENT Disable Schur complement and use the Bouguet calibration engine (CITE: Zhang2000, CITE: BouguetMCT).
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_PRINCIPAL_POINT The principal point is not changed during the global
     * optimization. It stays at the center or at a different location specified when
     *  REF: CALIB_USE_INTRINSIC_GUESS is set too.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_ASPECT_RATIO The functions consider only fy as a free parameter. The
     * ratio fx/fy stays the same as in the input cameraMatrix . When
     *  REF: CALIB_USE_INTRINSIC_GUESS is not set, the actual input values of fx and fy are
     * ignored, only their ratio is computed and used further.
     *   </li>
     *   <li>
     *    REF: CALIB_ZERO_TANGENT_DIST Tangential distortion coefficients \((p_1, p_2)\) are set
     * to zeros and stay zero.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_FOCAL_LENGTH The focal length is not changed during the global optimization if
     *  REF: CALIB_USE_INTRINSIC_GUESS is set.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_K1,..., REF: CALIB_FIX_K6 The corresponding radial distortion
     * coefficient is not changed during the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is
     * set, the coefficient from the supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     *   <li>
     *    REF: CALIB_RATIONAL_MODEL Coefficients k4, k5, and k6 are enabled. To provide the
     * backward compatibility, this extra flag should be explicitly specified to make the
     * calibration function use the rational model and return 8 coefficients or more.
     *   </li>
     *   <li>
     *    REF: CALIB_THIN_PRISM_MODEL Coefficients s1, s2, s3 and s4 are enabled. To provide the
     * backward compatibility, this extra flag should be explicitly specified to make the
     * calibration function use the thin prism model and return 12 coefficients or more.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_S1_S2_S3_S4 The thin prism distortion coefficients are not changed during
     * the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is set, the coefficient from the
     * supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     *   <li>
     *    REF: CALIB_TILTED_MODEL Coefficients tauX and tauY are enabled. To provide the
     * backward compatibility, this extra flag should be explicitly specified to make the
     * calibration function use the tilted sensor model and return 14 coefficients.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_TAUX_TAUY The coefficients of the tilted sensor model are not changed during
     * the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is set, the coefficient from the
     * supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     * </ul>
     * @param criteria Termination criteria for the iterative optimization algorithm.
     *
     * @return the overall RMS re-projection error.
     *
     * The function estimates the intrinsic camera parameters and extrinsic parameters for each of the
     * views. By default, the optimization follows a sparse bundle adjustment formulation with Schur
     * complement; see CITE: Triggs2000_bundle_adjustment and CITE: Lourakis2009_sba for background. Use
     * REF: CALIB_DISABLE_SCHUR_COMPLEMENT to switch to the Bouguet calibration engine. The coordinates of 3D object
     * points and their corresponding 2D projections in each view must be specified. That may be achieved
     * by using an object with known geometry and easily detectable feature points. Such an object is
     * called a calibration rig or calibration pattern, and OpenCV has built-in support for a chessboard as
     * a calibration rig (see REF: findChessboardCorners). Currently, initialization of intrinsic
     * parameters (when REF: CALIB_USE_INTRINSIC_GUESS is not set) is only implemented for planar calibration
     * patterns (where Z-coordinates of the object points must be all zeros). 3D calibration rigs can also
     * be used as long as initial cameraMatrix is provided.
     *
     * The algorithm performs the following steps:
     *
     * <ul>
     *   <li>
     *    Compute the initial intrinsic parameters (the option only available for planar calibration
     *     patterns) or read them from the input parameters. The distortion coefficients are all set to
     *     zeros initially unless some of CALIB_FIX_K? are specified.
     *   </li>
     * </ul>
     *
     * <ul>
     *   <li>
     *    Estimate the initial camera pose as if the intrinsic parameters have been already known. This is
     *     done using REF: solvePnP .
     *   </li>
     * </ul>
     *
     * <ul>
     *   <li>
     *    Run the global Levenberg-Marquardt optimization algorithm to minimize the reprojection error,
     *     that is, the total sum of squared distances between the observed feature points imagePoints and
     *     the projected (using the current estimates for camera parameters and the poses) object points
     *     objectPoints. See REF: projectPoints for details.
     *   </li>
     * </ul>
     *
     * <ul>
     *   <li>
     *    In practice, robust acquisition is essential for stable results: use multiple board poses with
     *     significant tilt, avoid collecting all views at a single working distance, span the expected
     *     working-distance range (a larger board with larger squares can help for longer distances).
     *   </li>
     * </ul>
     *
     * <b>Note:</b>
     *     If you use a non-square (i.e. non-N-by-N) grid and REF: findChessboardCorners for calibration,
     *     and REF: calibrateCamera returns bad values (zero distortion coefficients, \(c_x\) and
     *     \(c_y\) very far from the image center, and/or large differences between \(f_x\) and
     *     \(f_y\) (ratios of 10:1 or more)), then you are probably using patternSize=cvSize(rows,cols)
     *     instead of using patternSize=cvSize(cols,rows) in REF: findChessboardCorners.
     *
     * <b>Note:</b>
     *     The function may throw exceptions, if unsupported combination of parameters is provided or
     *     the system is underconstrained.
     *
     * SEE:
     *    calibrateCameraRO, findChessboardCorners, solvePnP, initCameraMatrix2D, stereoCalibrate,
     *    undistort
     */
    public static double calibrateCameraExtended(List<Mat> objectPoints, List<Mat> imagePoints, Size imageSize, Mat cameraMatrix, Mat distCoeffs, List<Mat> rvecs, List<Mat> tvecs, Mat stdDeviationsIntrinsics, Mat stdDeviationsExtrinsics, Mat perViewErrors, int flags, TermCriteria criteria) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints_mat = Converters.vector_Mat_to_Mat(imagePoints);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = calibrateCameraExtended_0(objectPoints_mat.nativeObj, imagePoints_mat.nativeObj, imageSize.width, imageSize.height, cameraMatrix.nativeObj, distCoeffs.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, stdDeviationsIntrinsics.nativeObj, stdDeviationsExtrinsics.nativeObj, perViewErrors.nativeObj, flags, criteria.type, criteria.maxCount, criteria.epsilon);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }

    /**
     * Finds the camera intrinsic and extrinsic parameters from several views of a calibration
     * pattern.
     *
     * @param objectPoints In the new interface it is a vector of vectors of calibration pattern points in
     * the calibration pattern coordinate space (e.g. std::vector&lt;std::vector&lt;cv::Vec3f&gt;&gt;). The outer
     * vector contains as many elements as the number of pattern views. If the same calibration pattern
     * is shown in each view and it is fully visible, all the vectors will be the same. Although, it is
     * possible to use partially occluded patterns or even different patterns in different views. Then,
     * the vectors will be different. Although the points are 3D, they all lie in the calibration pattern's
     * XY coordinate plane (thus 0 in the Z-coordinate), if the used calibration pattern is a planar rig.
     * In the old interface all the vectors of object points from different views are concatenated
     * together.
     * @param imagePoints In the new interface it is a vector of vectors of the projections of calibration
     * pattern points (e.g. std::vector&lt;std::vector&lt;cv::Vec2f&gt;&gt;). imagePoints.size() and
     * objectPoints.size(), and imagePoints[i].size() and objectPoints[i].size() for each i, must be equal,
     * respectively. In the old interface all the vectors of object points from different views are
     * concatenated together.
     * @param imageSize Size of the image used only to initialize the camera intrinsic matrix.
     * @param cameraMatrix Input/output 3x3 floating-point camera intrinsic matrix
     * \(\cameramatrix{A}\) . If REF: CALIB_USE_INTRINSIC_GUESS
     * and/or REF: CALIB_FIX_ASPECT_RATIO, REF: CALIB_FIX_PRINCIPAL_POINT or REF: CALIB_FIX_FOCAL_LENGTH
     * are specified, some or all of fx, fy, cx, cy must be initialized before calling the function.
     * @param distCoeffs Input/output vector of distortion coefficients
     * \(\distcoeffs\).
     * @param rvecs Output vector of rotation vectors (REF: Rodrigues ) estimated for each pattern view
     * (e.g. std::vector&lt;cv::Mat&gt;&gt;). That is, each i-th rotation vector together with the corresponding
     * i-th translation vector (see the next output parameter description) brings the calibration pattern
     * from the object coordinate space (in which object points are specified) to the camera coordinate
     * space. In more technical terms, the tuple of the i-th rotation and translation vector performs
     * a change of basis from object coordinate space to camera coordinate space. Due to its duality, this
     * tuple is equivalent to the position of the calibration pattern with respect to the camera coordinate
     * space.
     * @param tvecs Output vector of translation vectors estimated for each pattern view, see parameter
     * description above.
     * @param stdDeviationsIntrinsics Output vector of standard deviations estimated for intrinsic
     * parameters. Order of deviations values:
     * \((f_x, f_y, c_x, c_y, k_1, k_2, p_1, p_2, k_3, k_4, k_5, k_6 , s_1, s_2, s_3,
     *  s_4, \tau_x, \tau_y)\) If one of parameters is not estimated, it's deviation is equals to zero.
     * @param stdDeviationsExtrinsics Output vector of standard deviations estimated for extrinsic
     * parameters. Order of deviations values: \((R_0, T_0, \dotsc , R_{M - 1}, T_{M - 1})\) where M is
     * the number of pattern views. \(R_i, T_i\) are concatenated 1x3 vectors.
     *  @param perViewErrors Output vector of the RMS re-projection error estimated for each pattern view.
     * @param flags Different flags that may be zero or a combination of the following values:
     * <ul>
     *   <li>
     *    REF: CALIB_USE_INTRINSIC_GUESS cameraMatrix contains valid initial values of
     * fx, fy, cx, cy that are optimized further. Otherwise, (cx, cy) is initially set to the image
     * center ( imageSize is used), and focal distances are computed in a least-squares fashion.
     * Note, that if intrinsic parameters are known, there is no need to use this function just to
     * estimate extrinsic parameters. Use REF: solvePnP instead.
     *   </li>
     *   <li>
     *    REF: CALIB_DISABLE_SCHUR_COMPLEMENT Disable Schur complement and use the Bouguet calibration engine (CITE: Zhang2000, CITE: BouguetMCT).
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_PRINCIPAL_POINT The principal point is not changed during the global
     * optimization. It stays at the center or at a different location specified when
     *  REF: CALIB_USE_INTRINSIC_GUESS is set too.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_ASPECT_RATIO The functions consider only fy as a free parameter. The
     * ratio fx/fy stays the same as in the input cameraMatrix . When
     *  REF: CALIB_USE_INTRINSIC_GUESS is not set, the actual input values of fx and fy are
     * ignored, only their ratio is computed and used further.
     *   </li>
     *   <li>
     *    REF: CALIB_ZERO_TANGENT_DIST Tangential distortion coefficients \((p_1, p_2)\) are set
     * to zeros and stay zero.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_FOCAL_LENGTH The focal length is not changed during the global optimization if
     *  REF: CALIB_USE_INTRINSIC_GUESS is set.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_K1,..., REF: CALIB_FIX_K6 The corresponding radial distortion
     * coefficient is not changed during the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is
     * set, the coefficient from the supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     *   <li>
     *    REF: CALIB_RATIONAL_MODEL Coefficients k4, k5, and k6 are enabled. To provide the
     * backward compatibility, this extra flag should be explicitly specified to make the
     * calibration function use the rational model and return 8 coefficients or more.
     *   </li>
     *   <li>
     *    REF: CALIB_THIN_PRISM_MODEL Coefficients s1, s2, s3 and s4 are enabled. To provide the
     * backward compatibility, this extra flag should be explicitly specified to make the
     * calibration function use the thin prism model and return 12 coefficients or more.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_S1_S2_S3_S4 The thin prism distortion coefficients are not changed during
     * the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is set, the coefficient from the
     * supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     *   <li>
     *    REF: CALIB_TILTED_MODEL Coefficients tauX and tauY are enabled. To provide the
     * backward compatibility, this extra flag should be explicitly specified to make the
     * calibration function use the tilted sensor model and return 14 coefficients.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_TAUX_TAUY The coefficients of the tilted sensor model are not changed during
     * the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is set, the coefficient from the
     * supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     * </ul>
     *
     * @return the overall RMS re-projection error.
     *
     * The function estimates the intrinsic camera parameters and extrinsic parameters for each of the
     * views. By default, the optimization follows a sparse bundle adjustment formulation with Schur
     * complement; see CITE: Triggs2000_bundle_adjustment and CITE: Lourakis2009_sba for background. Use
     * REF: CALIB_DISABLE_SCHUR_COMPLEMENT to switch to the Bouguet calibration engine. The coordinates of 3D object
     * points and their corresponding 2D projections in each view must be specified. That may be achieved
     * by using an object with known geometry and easily detectable feature points. Such an object is
     * called a calibration rig or calibration pattern, and OpenCV has built-in support for a chessboard as
     * a calibration rig (see REF: findChessboardCorners). Currently, initialization of intrinsic
     * parameters (when REF: CALIB_USE_INTRINSIC_GUESS is not set) is only implemented for planar calibration
     * patterns (where Z-coordinates of the object points must be all zeros). 3D calibration rigs can also
     * be used as long as initial cameraMatrix is provided.
     *
     * The algorithm performs the following steps:
     *
     * <ul>
     *   <li>
     *    Compute the initial intrinsic parameters (the option only available for planar calibration
     *     patterns) or read them from the input parameters. The distortion coefficients are all set to
     *     zeros initially unless some of CALIB_FIX_K? are specified.
     *   </li>
     * </ul>
     *
     * <ul>
     *   <li>
     *    Estimate the initial camera pose as if the intrinsic parameters have been already known. This is
     *     done using REF: solvePnP .
     *   </li>
     * </ul>
     *
     * <ul>
     *   <li>
     *    Run the global Levenberg-Marquardt optimization algorithm to minimize the reprojection error,
     *     that is, the total sum of squared distances between the observed feature points imagePoints and
     *     the projected (using the current estimates for camera parameters and the poses) object points
     *     objectPoints. See REF: projectPoints for details.
     *   </li>
     * </ul>
     *
     * <ul>
     *   <li>
     *    In practice, robust acquisition is essential for stable results: use multiple board poses with
     *     significant tilt, avoid collecting all views at a single working distance, span the expected
     *     working-distance range (a larger board with larger squares can help for longer distances).
     *   </li>
     * </ul>
     *
     * <b>Note:</b>
     *     If you use a non-square (i.e. non-N-by-N) grid and REF: findChessboardCorners for calibration,
     *     and REF: calibrateCamera returns bad values (zero distortion coefficients, \(c_x\) and
     *     \(c_y\) very far from the image center, and/or large differences between \(f_x\) and
     *     \(f_y\) (ratios of 10:1 or more)), then you are probably using patternSize=cvSize(rows,cols)
     *     instead of using patternSize=cvSize(cols,rows) in REF: findChessboardCorners.
     *
     * <b>Note:</b>
     *     The function may throw exceptions, if unsupported combination of parameters is provided or
     *     the system is underconstrained.
     *
     * SEE:
     *    calibrateCameraRO, findChessboardCorners, solvePnP, initCameraMatrix2D, stereoCalibrate,
     *    undistort
     */
    public static double calibrateCameraExtended(List<Mat> objectPoints, List<Mat> imagePoints, Size imageSize, Mat cameraMatrix, Mat distCoeffs, List<Mat> rvecs, List<Mat> tvecs, Mat stdDeviationsIntrinsics, Mat stdDeviationsExtrinsics, Mat perViewErrors, int flags) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints_mat = Converters.vector_Mat_to_Mat(imagePoints);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = calibrateCameraExtended_1(objectPoints_mat.nativeObj, imagePoints_mat.nativeObj, imageSize.width, imageSize.height, cameraMatrix.nativeObj, distCoeffs.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, stdDeviationsIntrinsics.nativeObj, stdDeviationsExtrinsics.nativeObj, perViewErrors.nativeObj, flags);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }

    /**
     * Finds the camera intrinsic and extrinsic parameters from several views of a calibration
     * pattern.
     *
     * @param objectPoints In the new interface it is a vector of vectors of calibration pattern points in
     * the calibration pattern coordinate space (e.g. std::vector&lt;std::vector&lt;cv::Vec3f&gt;&gt;). The outer
     * vector contains as many elements as the number of pattern views. If the same calibration pattern
     * is shown in each view and it is fully visible, all the vectors will be the same. Although, it is
     * possible to use partially occluded patterns or even different patterns in different views. Then,
     * the vectors will be different. Although the points are 3D, they all lie in the calibration pattern's
     * XY coordinate plane (thus 0 in the Z-coordinate), if the used calibration pattern is a planar rig.
     * In the old interface all the vectors of object points from different views are concatenated
     * together.
     * @param imagePoints In the new interface it is a vector of vectors of the projections of calibration
     * pattern points (e.g. std::vector&lt;std::vector&lt;cv::Vec2f&gt;&gt;). imagePoints.size() and
     * objectPoints.size(), and imagePoints[i].size() and objectPoints[i].size() for each i, must be equal,
     * respectively. In the old interface all the vectors of object points from different views are
     * concatenated together.
     * @param imageSize Size of the image used only to initialize the camera intrinsic matrix.
     * @param cameraMatrix Input/output 3x3 floating-point camera intrinsic matrix
     * \(\cameramatrix{A}\) . If REF: CALIB_USE_INTRINSIC_GUESS
     * and/or REF: CALIB_FIX_ASPECT_RATIO, REF: CALIB_FIX_PRINCIPAL_POINT or REF: CALIB_FIX_FOCAL_LENGTH
     * are specified, some or all of fx, fy, cx, cy must be initialized before calling the function.
     * @param distCoeffs Input/output vector of distortion coefficients
     * \(\distcoeffs\).
     * @param rvecs Output vector of rotation vectors (REF: Rodrigues ) estimated for each pattern view
     * (e.g. std::vector&lt;cv::Mat&gt;&gt;). That is, each i-th rotation vector together with the corresponding
     * i-th translation vector (see the next output parameter description) brings the calibration pattern
     * from the object coordinate space (in which object points are specified) to the camera coordinate
     * space. In more technical terms, the tuple of the i-th rotation and translation vector performs
     * a change of basis from object coordinate space to camera coordinate space. Due to its duality, this
     * tuple is equivalent to the position of the calibration pattern with respect to the camera coordinate
     * space.
     * @param tvecs Output vector of translation vectors estimated for each pattern view, see parameter
     * description above.
     * @param stdDeviationsIntrinsics Output vector of standard deviations estimated for intrinsic
     * parameters. Order of deviations values:
     * \((f_x, f_y, c_x, c_y, k_1, k_2, p_1, p_2, k_3, k_4, k_5, k_6 , s_1, s_2, s_3,
     *  s_4, \tau_x, \tau_y)\) If one of parameters is not estimated, it's deviation is equals to zero.
     * @param stdDeviationsExtrinsics Output vector of standard deviations estimated for extrinsic
     * parameters. Order of deviations values: \((R_0, T_0, \dotsc , R_{M - 1}, T_{M - 1})\) where M is
     * the number of pattern views. \(R_i, T_i\) are concatenated 1x3 vectors.
     *  @param perViewErrors Output vector of the RMS re-projection error estimated for each pattern view.
     * <ul>
     *   <li>
     *    REF: CALIB_USE_INTRINSIC_GUESS cameraMatrix contains valid initial values of
     * fx, fy, cx, cy that are optimized further. Otherwise, (cx, cy) is initially set to the image
     * center ( imageSize is used), and focal distances are computed in a least-squares fashion.
     * Note, that if intrinsic parameters are known, there is no need to use this function just to
     * estimate extrinsic parameters. Use REF: solvePnP instead.
     *   </li>
     *   <li>
     *    REF: CALIB_DISABLE_SCHUR_COMPLEMENT Disable Schur complement and use the Bouguet calibration engine (CITE: Zhang2000, CITE: BouguetMCT).
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_PRINCIPAL_POINT The principal point is not changed during the global
     * optimization. It stays at the center or at a different location specified when
     *  REF: CALIB_USE_INTRINSIC_GUESS is set too.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_ASPECT_RATIO The functions consider only fy as a free parameter. The
     * ratio fx/fy stays the same as in the input cameraMatrix . When
     *  REF: CALIB_USE_INTRINSIC_GUESS is not set, the actual input values of fx and fy are
     * ignored, only their ratio is computed and used further.
     *   </li>
     *   <li>
     *    REF: CALIB_ZERO_TANGENT_DIST Tangential distortion coefficients \((p_1, p_2)\) are set
     * to zeros and stay zero.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_FOCAL_LENGTH The focal length is not changed during the global optimization if
     *  REF: CALIB_USE_INTRINSIC_GUESS is set.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_K1,..., REF: CALIB_FIX_K6 The corresponding radial distortion
     * coefficient is not changed during the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is
     * set, the coefficient from the supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     *   <li>
     *    REF: CALIB_RATIONAL_MODEL Coefficients k4, k5, and k6 are enabled. To provide the
     * backward compatibility, this extra flag should be explicitly specified to make the
     * calibration function use the rational model and return 8 coefficients or more.
     *   </li>
     *   <li>
     *    REF: CALIB_THIN_PRISM_MODEL Coefficients s1, s2, s3 and s4 are enabled. To provide the
     * backward compatibility, this extra flag should be explicitly specified to make the
     * calibration function use the thin prism model and return 12 coefficients or more.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_S1_S2_S3_S4 The thin prism distortion coefficients are not changed during
     * the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is set, the coefficient from the
     * supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     *   <li>
     *    REF: CALIB_TILTED_MODEL Coefficients tauX and tauY are enabled. To provide the
     * backward compatibility, this extra flag should be explicitly specified to make the
     * calibration function use the tilted sensor model and return 14 coefficients.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_TAUX_TAUY The coefficients of the tilted sensor model are not changed during
     * the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is set, the coefficient from the
     * supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     * </ul>
     *
     * @return the overall RMS re-projection error.
     *
     * The function estimates the intrinsic camera parameters and extrinsic parameters for each of the
     * views. By default, the optimization follows a sparse bundle adjustment formulation with Schur
     * complement; see CITE: Triggs2000_bundle_adjustment and CITE: Lourakis2009_sba for background. Use
     * REF: CALIB_DISABLE_SCHUR_COMPLEMENT to switch to the Bouguet calibration engine. The coordinates of 3D object
     * points and their corresponding 2D projections in each view must be specified. That may be achieved
     * by using an object with known geometry and easily detectable feature points. Such an object is
     * called a calibration rig or calibration pattern, and OpenCV has built-in support for a chessboard as
     * a calibration rig (see REF: findChessboardCorners). Currently, initialization of intrinsic
     * parameters (when REF: CALIB_USE_INTRINSIC_GUESS is not set) is only implemented for planar calibration
     * patterns (where Z-coordinates of the object points must be all zeros). 3D calibration rigs can also
     * be used as long as initial cameraMatrix is provided.
     *
     * The algorithm performs the following steps:
     *
     * <ul>
     *   <li>
     *    Compute the initial intrinsic parameters (the option only available for planar calibration
     *     patterns) or read them from the input parameters. The distortion coefficients are all set to
     *     zeros initially unless some of CALIB_FIX_K? are specified.
     *   </li>
     * </ul>
     *
     * <ul>
     *   <li>
     *    Estimate the initial camera pose as if the intrinsic parameters have been already known. This is
     *     done using REF: solvePnP .
     *   </li>
     * </ul>
     *
     * <ul>
     *   <li>
     *    Run the global Levenberg-Marquardt optimization algorithm to minimize the reprojection error,
     *     that is, the total sum of squared distances between the observed feature points imagePoints and
     *     the projected (using the current estimates for camera parameters and the poses) object points
     *     objectPoints. See REF: projectPoints for details.
     *   </li>
     * </ul>
     *
     * <ul>
     *   <li>
     *    In practice, robust acquisition is essential for stable results: use multiple board poses with
     *     significant tilt, avoid collecting all views at a single working distance, span the expected
     *     working-distance range (a larger board with larger squares can help for longer distances).
     *   </li>
     * </ul>
     *
     * <b>Note:</b>
     *     If you use a non-square (i.e. non-N-by-N) grid and REF: findChessboardCorners for calibration,
     *     and REF: calibrateCamera returns bad values (zero distortion coefficients, \(c_x\) and
     *     \(c_y\) very far from the image center, and/or large differences between \(f_x\) and
     *     \(f_y\) (ratios of 10:1 or more)), then you are probably using patternSize=cvSize(rows,cols)
     *     instead of using patternSize=cvSize(cols,rows) in REF: findChessboardCorners.
     *
     * <b>Note:</b>
     *     The function may throw exceptions, if unsupported combination of parameters is provided or
     *     the system is underconstrained.
     *
     * SEE:
     *    calibrateCameraRO, findChessboardCorners, solvePnP, initCameraMatrix2D, stereoCalibrate,
     *    undistort
     */
    public static double calibrateCameraExtended(List<Mat> objectPoints, List<Mat> imagePoints, Size imageSize, Mat cameraMatrix, Mat distCoeffs, List<Mat> rvecs, List<Mat> tvecs, Mat stdDeviationsIntrinsics, Mat stdDeviationsExtrinsics, Mat perViewErrors) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints_mat = Converters.vector_Mat_to_Mat(imagePoints);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = calibrateCameraExtended_2(objectPoints_mat.nativeObj, imagePoints_mat.nativeObj, imageSize.width, imageSize.height, cameraMatrix.nativeObj, distCoeffs.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, stdDeviationsIntrinsics.nativeObj, stdDeviationsExtrinsics.nativeObj, perViewErrors.nativeObj);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }


    //
    // C++:  double cv::calibrateCamera(vector_Mat objectPoints, vector_Mat imagePoints, Size imageSize, Mat& cameraMatrix, Mat& distCoeffs, vector_Mat& rvecs, vector_Mat& tvecs, int flags = 0, TermCriteria criteria = TermCriteria( TermCriteria::COUNT + TermCriteria::EPS, 500, DBL_EPSILON))
    //

    public static double calibrateCamera(List<Mat> objectPoints, List<Mat> imagePoints, Size imageSize, Mat cameraMatrix, Mat distCoeffs, List<Mat> rvecs, List<Mat> tvecs, int flags, TermCriteria criteria) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints_mat = Converters.vector_Mat_to_Mat(imagePoints);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = calibrateCamera_0(objectPoints_mat.nativeObj, imagePoints_mat.nativeObj, imageSize.width, imageSize.height, cameraMatrix.nativeObj, distCoeffs.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, flags, criteria.type, criteria.maxCount, criteria.epsilon);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }

    public static double calibrateCamera(List<Mat> objectPoints, List<Mat> imagePoints, Size imageSize, Mat cameraMatrix, Mat distCoeffs, List<Mat> rvecs, List<Mat> tvecs, int flags) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints_mat = Converters.vector_Mat_to_Mat(imagePoints);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = calibrateCamera_1(objectPoints_mat.nativeObj, imagePoints_mat.nativeObj, imageSize.width, imageSize.height, cameraMatrix.nativeObj, distCoeffs.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, flags);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }

    public static double calibrateCamera(List<Mat> objectPoints, List<Mat> imagePoints, Size imageSize, Mat cameraMatrix, Mat distCoeffs, List<Mat> rvecs, List<Mat> tvecs) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints_mat = Converters.vector_Mat_to_Mat(imagePoints);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = calibrateCamera_2(objectPoints_mat.nativeObj, imagePoints_mat.nativeObj, imageSize.width, imageSize.height, cameraMatrix.nativeObj, distCoeffs.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }


    //
    // C++:  double cv::calibrateCameraRO(vector_Mat objectPoints, vector_Mat imagePoints, Size imageSize, int iFixedPoint, Mat& cameraMatrix, Mat& distCoeffs, vector_Mat& rvecs, vector_Mat& tvecs, Mat& newObjPoints, Mat& stdDeviationsIntrinsics, Mat& stdDeviationsExtrinsics, Mat& stdDeviationsObjPoints, Mat& perViewErrors, int flags = 0, TermCriteria criteria = TermCriteria( TermCriteria::COUNT + TermCriteria::EPS, 500, DBL_EPSILON))
    //

    /**
     * Finds the camera intrinsic and extrinsic parameters from several views of a calibration pattern.
     *
     * This function is an extension of #calibrateCamera with the method of releasing object which was
     * proposed in CITE: strobl2011iccv. In many common cases with inaccurate, unmeasured, roughly planar
     * targets (calibration plates), this method can dramatically improve the precision of the estimated
     * camera parameters. Both the object-releasing method and standard method are supported by this
     * function. Use the parameter <b>iFixedPoint</b> for method selection. In the internal implementation,
     * #calibrateCamera is a wrapper for this function.
     *
     * @param objectPoints Vector of vectors of calibration pattern points in the calibration pattern
     * coordinate space. See #calibrateCamera for details. If the method of releasing object to be used,
     * the identical calibration board must be used in each view and it must be fully visible, and all
     * objectPoints[i] must be the same and all points should be roughly close to a plane. <b>The calibration
     * target has to be rigid, or at least static if the camera (rather than the calibration target) is
     * shifted for grabbing images.</b>
     * @param imagePoints Vector of vectors of the projections of calibration pattern points. See
     * #calibrateCamera for details.
     * @param imageSize Size of the image used only to initialize the intrinsic camera matrix.
     * @param iFixedPoint The index of the 3D object point in objectPoints[0] to be fixed. It also acts as
     * a switch for calibration method selection. If object-releasing method to be used, pass in the
     * parameter in the range of [1, objectPoints[0].size()-2], otherwise a value out of this range will
     * make standard calibration method selected. Usually the top-right corner point of the calibration
     * board grid is recommended to be fixed when object-releasing method being utilized. According to
     * \cite strobl2011iccv, two other points are also fixed. In this implementation, objectPoints[0].front
     * and objectPoints[0].back.z are used. With object-releasing method, accurate rvecs, tvecs and
     * newObjPoints are only possible if coordinates of these three fixed points are accurate enough.
     * @param cameraMatrix Output 3x3 floating-point camera matrix. See #calibrateCamera for details.
     * @param distCoeffs Output vector of distortion coefficients. See #calibrateCamera for details.
     * @param rvecs Output vector of rotation vectors estimated for each pattern view. See #calibrateCamera
     * for details.
     * @param tvecs Output vector of translation vectors estimated for each pattern view.
     * @param newObjPoints The updated output vector of calibration pattern points. The coordinates might
     * be scaled based on three fixed points. The returned coordinates are accurate only if the above
     * mentioned three fixed points are accurate. If not needed, noArray() can be passed in. This parameter
     * is ignored with standard calibration method.
     * @param stdDeviationsIntrinsics Output vector of standard deviations estimated for intrinsic parameters.
     * See #calibrateCamera for details.
     * @param stdDeviationsExtrinsics Output vector of standard deviations estimated for extrinsic parameters.
     * See #calibrateCamera for details.
     * @param stdDeviationsObjPoints Output vector of standard deviations estimated for refined coordinates
     * of calibration pattern points. It has the same size and order as objectPoints[0] vector. This
     * parameter is ignored with standard calibration method.
     *  @param perViewErrors Output vector of the RMS re-projection error estimated for each pattern view.
     * @param flags Different flags that may be zero or a combination of some predefined values. See
     * #calibrateCamera for details. If the method of releasing object is used, the calibration time may
     * be much longer. CALIB_USE_QR or CALIB_USE_LU could be used for faster calibration with potentially
     * less precise and less stable in some rare cases.
     * @param criteria Termination criteria for the iterative optimization algorithm.
     *
     * @return the overall RMS re-projection error.
     *
     * The function estimates the intrinsic camera parameters and extrinsic parameters for each of the
     * views. The object-releasing extension follows CITE: strobl2011iccv and uses the same optimization
     * core as #calibrateCamera. See #calibrateCamera for other detailed explanations.
     * SEE:
     *    calibrateCamera, findChessboardCorners, solvePnP, initCameraMatrix2D, stereoCalibrate, undistort
     */
    public static double calibrateCameraROExtended(List<Mat> objectPoints, List<Mat> imagePoints, Size imageSize, int iFixedPoint, Mat cameraMatrix, Mat distCoeffs, List<Mat> rvecs, List<Mat> tvecs, Mat newObjPoints, Mat stdDeviationsIntrinsics, Mat stdDeviationsExtrinsics, Mat stdDeviationsObjPoints, Mat perViewErrors, int flags, TermCriteria criteria) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints_mat = Converters.vector_Mat_to_Mat(imagePoints);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = calibrateCameraROExtended_0(objectPoints_mat.nativeObj, imagePoints_mat.nativeObj, imageSize.width, imageSize.height, iFixedPoint, cameraMatrix.nativeObj, distCoeffs.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, newObjPoints.nativeObj, stdDeviationsIntrinsics.nativeObj, stdDeviationsExtrinsics.nativeObj, stdDeviationsObjPoints.nativeObj, perViewErrors.nativeObj, flags, criteria.type, criteria.maxCount, criteria.epsilon);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }

    /**
     * Finds the camera intrinsic and extrinsic parameters from several views of a calibration pattern.
     *
     * This function is an extension of #calibrateCamera with the method of releasing object which was
     * proposed in CITE: strobl2011iccv. In many common cases with inaccurate, unmeasured, roughly planar
     * targets (calibration plates), this method can dramatically improve the precision of the estimated
     * camera parameters. Both the object-releasing method and standard method are supported by this
     * function. Use the parameter <b>iFixedPoint</b> for method selection. In the internal implementation,
     * #calibrateCamera is a wrapper for this function.
     *
     * @param objectPoints Vector of vectors of calibration pattern points in the calibration pattern
     * coordinate space. See #calibrateCamera for details. If the method of releasing object to be used,
     * the identical calibration board must be used in each view and it must be fully visible, and all
     * objectPoints[i] must be the same and all points should be roughly close to a plane. <b>The calibration
     * target has to be rigid, or at least static if the camera (rather than the calibration target) is
     * shifted for grabbing images.</b>
     * @param imagePoints Vector of vectors of the projections of calibration pattern points. See
     * #calibrateCamera for details.
     * @param imageSize Size of the image used only to initialize the intrinsic camera matrix.
     * @param iFixedPoint The index of the 3D object point in objectPoints[0] to be fixed. It also acts as
     * a switch for calibration method selection. If object-releasing method to be used, pass in the
     * parameter in the range of [1, objectPoints[0].size()-2], otherwise a value out of this range will
     * make standard calibration method selected. Usually the top-right corner point of the calibration
     * board grid is recommended to be fixed when object-releasing method being utilized. According to
     * \cite strobl2011iccv, two other points are also fixed. In this implementation, objectPoints[0].front
     * and objectPoints[0].back.z are used. With object-releasing method, accurate rvecs, tvecs and
     * newObjPoints are only possible if coordinates of these three fixed points are accurate enough.
     * @param cameraMatrix Output 3x3 floating-point camera matrix. See #calibrateCamera for details.
     * @param distCoeffs Output vector of distortion coefficients. See #calibrateCamera for details.
     * @param rvecs Output vector of rotation vectors estimated for each pattern view. See #calibrateCamera
     * for details.
     * @param tvecs Output vector of translation vectors estimated for each pattern view.
     * @param newObjPoints The updated output vector of calibration pattern points. The coordinates might
     * be scaled based on three fixed points. The returned coordinates are accurate only if the above
     * mentioned three fixed points are accurate. If not needed, noArray() can be passed in. This parameter
     * is ignored with standard calibration method.
     * @param stdDeviationsIntrinsics Output vector of standard deviations estimated for intrinsic parameters.
     * See #calibrateCamera for details.
     * @param stdDeviationsExtrinsics Output vector of standard deviations estimated for extrinsic parameters.
     * See #calibrateCamera for details.
     * @param stdDeviationsObjPoints Output vector of standard deviations estimated for refined coordinates
     * of calibration pattern points. It has the same size and order as objectPoints[0] vector. This
     * parameter is ignored with standard calibration method.
     *  @param perViewErrors Output vector of the RMS re-projection error estimated for each pattern view.
     * @param flags Different flags that may be zero or a combination of some predefined values. See
     * #calibrateCamera for details. If the method of releasing object is used, the calibration time may
     * be much longer. CALIB_USE_QR or CALIB_USE_LU could be used for faster calibration with potentially
     * less precise and less stable in some rare cases.
     *
     * @return the overall RMS re-projection error.
     *
     * The function estimates the intrinsic camera parameters and extrinsic parameters for each of the
     * views. The object-releasing extension follows CITE: strobl2011iccv and uses the same optimization
     * core as #calibrateCamera. See #calibrateCamera for other detailed explanations.
     * SEE:
     *    calibrateCamera, findChessboardCorners, solvePnP, initCameraMatrix2D, stereoCalibrate, undistort
     */
    public static double calibrateCameraROExtended(List<Mat> objectPoints, List<Mat> imagePoints, Size imageSize, int iFixedPoint, Mat cameraMatrix, Mat distCoeffs, List<Mat> rvecs, List<Mat> tvecs, Mat newObjPoints, Mat stdDeviationsIntrinsics, Mat stdDeviationsExtrinsics, Mat stdDeviationsObjPoints, Mat perViewErrors, int flags) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints_mat = Converters.vector_Mat_to_Mat(imagePoints);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = calibrateCameraROExtended_1(objectPoints_mat.nativeObj, imagePoints_mat.nativeObj, imageSize.width, imageSize.height, iFixedPoint, cameraMatrix.nativeObj, distCoeffs.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, newObjPoints.nativeObj, stdDeviationsIntrinsics.nativeObj, stdDeviationsExtrinsics.nativeObj, stdDeviationsObjPoints.nativeObj, perViewErrors.nativeObj, flags);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }

    /**
     * Finds the camera intrinsic and extrinsic parameters from several views of a calibration pattern.
     *
     * This function is an extension of #calibrateCamera with the method of releasing object which was
     * proposed in CITE: strobl2011iccv. In many common cases with inaccurate, unmeasured, roughly planar
     * targets (calibration plates), this method can dramatically improve the precision of the estimated
     * camera parameters. Both the object-releasing method and standard method are supported by this
     * function. Use the parameter <b>iFixedPoint</b> for method selection. In the internal implementation,
     * #calibrateCamera is a wrapper for this function.
     *
     * @param objectPoints Vector of vectors of calibration pattern points in the calibration pattern
     * coordinate space. See #calibrateCamera for details. If the method of releasing object to be used,
     * the identical calibration board must be used in each view and it must be fully visible, and all
     * objectPoints[i] must be the same and all points should be roughly close to a plane. <b>The calibration
     * target has to be rigid, or at least static if the camera (rather than the calibration target) is
     * shifted for grabbing images.</b>
     * @param imagePoints Vector of vectors of the projections of calibration pattern points. See
     * #calibrateCamera for details.
     * @param imageSize Size of the image used only to initialize the intrinsic camera matrix.
     * @param iFixedPoint The index of the 3D object point in objectPoints[0] to be fixed. It also acts as
     * a switch for calibration method selection. If object-releasing method to be used, pass in the
     * parameter in the range of [1, objectPoints[0].size()-2], otherwise a value out of this range will
     * make standard calibration method selected. Usually the top-right corner point of the calibration
     * board grid is recommended to be fixed when object-releasing method being utilized. According to
     * \cite strobl2011iccv, two other points are also fixed. In this implementation, objectPoints[0].front
     * and objectPoints[0].back.z are used. With object-releasing method, accurate rvecs, tvecs and
     * newObjPoints are only possible if coordinates of these three fixed points are accurate enough.
     * @param cameraMatrix Output 3x3 floating-point camera matrix. See #calibrateCamera for details.
     * @param distCoeffs Output vector of distortion coefficients. See #calibrateCamera for details.
     * @param rvecs Output vector of rotation vectors estimated for each pattern view. See #calibrateCamera
     * for details.
     * @param tvecs Output vector of translation vectors estimated for each pattern view.
     * @param newObjPoints The updated output vector of calibration pattern points. The coordinates might
     * be scaled based on three fixed points. The returned coordinates are accurate only if the above
     * mentioned three fixed points are accurate. If not needed, noArray() can be passed in. This parameter
     * is ignored with standard calibration method.
     * @param stdDeviationsIntrinsics Output vector of standard deviations estimated for intrinsic parameters.
     * See #calibrateCamera for details.
     * @param stdDeviationsExtrinsics Output vector of standard deviations estimated for extrinsic parameters.
     * See #calibrateCamera for details.
     * @param stdDeviationsObjPoints Output vector of standard deviations estimated for refined coordinates
     * of calibration pattern points. It has the same size and order as objectPoints[0] vector. This
     * parameter is ignored with standard calibration method.
     *  @param perViewErrors Output vector of the RMS re-projection error estimated for each pattern view.
     * #calibrateCamera for details. If the method of releasing object is used, the calibration time may
     * be much longer. CALIB_USE_QR or CALIB_USE_LU could be used for faster calibration with potentially
     * less precise and less stable in some rare cases.
     *
     * @return the overall RMS re-projection error.
     *
     * The function estimates the intrinsic camera parameters and extrinsic parameters for each of the
     * views. The object-releasing extension follows CITE: strobl2011iccv and uses the same optimization
     * core as #calibrateCamera. See #calibrateCamera for other detailed explanations.
     * SEE:
     *    calibrateCamera, findChessboardCorners, solvePnP, initCameraMatrix2D, stereoCalibrate, undistort
     */
    public static double calibrateCameraROExtended(List<Mat> objectPoints, List<Mat> imagePoints, Size imageSize, int iFixedPoint, Mat cameraMatrix, Mat distCoeffs, List<Mat> rvecs, List<Mat> tvecs, Mat newObjPoints, Mat stdDeviationsIntrinsics, Mat stdDeviationsExtrinsics, Mat stdDeviationsObjPoints, Mat perViewErrors) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints_mat = Converters.vector_Mat_to_Mat(imagePoints);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = calibrateCameraROExtended_2(objectPoints_mat.nativeObj, imagePoints_mat.nativeObj, imageSize.width, imageSize.height, iFixedPoint, cameraMatrix.nativeObj, distCoeffs.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, newObjPoints.nativeObj, stdDeviationsIntrinsics.nativeObj, stdDeviationsExtrinsics.nativeObj, stdDeviationsObjPoints.nativeObj, perViewErrors.nativeObj);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }


    //
    // C++:  double cv::calibrateCameraRO(vector_Mat objectPoints, vector_Mat imagePoints, Size imageSize, int iFixedPoint, Mat& cameraMatrix, Mat& distCoeffs, vector_Mat& rvecs, vector_Mat& tvecs, Mat& newObjPoints, int flags = 0, TermCriteria criteria = TermCriteria( TermCriteria::COUNT + TermCriteria::EPS, 500, DBL_EPSILON))
    //

    public static double calibrateCameraRO(List<Mat> objectPoints, List<Mat> imagePoints, Size imageSize, int iFixedPoint, Mat cameraMatrix, Mat distCoeffs, List<Mat> rvecs, List<Mat> tvecs, Mat newObjPoints, int flags, TermCriteria criteria) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints_mat = Converters.vector_Mat_to_Mat(imagePoints);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = calibrateCameraRO_0(objectPoints_mat.nativeObj, imagePoints_mat.nativeObj, imageSize.width, imageSize.height, iFixedPoint, cameraMatrix.nativeObj, distCoeffs.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, newObjPoints.nativeObj, flags, criteria.type, criteria.maxCount, criteria.epsilon);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }

    public static double calibrateCameraRO(List<Mat> objectPoints, List<Mat> imagePoints, Size imageSize, int iFixedPoint, Mat cameraMatrix, Mat distCoeffs, List<Mat> rvecs, List<Mat> tvecs, Mat newObjPoints, int flags) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints_mat = Converters.vector_Mat_to_Mat(imagePoints);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = calibrateCameraRO_1(objectPoints_mat.nativeObj, imagePoints_mat.nativeObj, imageSize.width, imageSize.height, iFixedPoint, cameraMatrix.nativeObj, distCoeffs.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, newObjPoints.nativeObj, flags);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }

    public static double calibrateCameraRO(List<Mat> objectPoints, List<Mat> imagePoints, Size imageSize, int iFixedPoint, Mat cameraMatrix, Mat distCoeffs, List<Mat> rvecs, List<Mat> tvecs, Mat newObjPoints) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints_mat = Converters.vector_Mat_to_Mat(imagePoints);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = calibrateCameraRO_2(objectPoints_mat.nativeObj, imagePoints_mat.nativeObj, imageSize.width, imageSize.height, iFixedPoint, cameraMatrix.nativeObj, distCoeffs.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, newObjPoints.nativeObj);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }


    //
    // C++:  double cv::stereoCalibrate(vector_Mat objectPoints, vector_Mat imagePoints1, vector_Mat imagePoints2, Mat& cameraMatrix1, Mat& distCoeffs1, Mat& cameraMatrix2, Mat& distCoeffs2, Size imageSize, Mat& R, Mat& T, Mat& E, Mat& F, vector_Mat& rvecs, vector_Mat& tvecs, Mat& perViewErrors, int flags = CALIB_FIX_INTRINSIC, TermCriteria criteria = TermCriteria(TermCriteria::COUNT+TermCriteria::EPS, 100, 1e-6))
    //

    /**
     * Calibrates a stereo camera set up. This function finds the intrinsic parameters
     * for each of the two cameras and the extrinsic parameters between the two cameras.
     *
     * @param objectPoints Vector of vectors of the calibration pattern points. The same structure as
     * in REF: calibrateCamera. For each pattern view, both cameras need to see the same object
     * points. Therefore, objectPoints.size(), imagePoints1.size(), and imagePoints2.size() need to be
     * equal as well as objectPoints[i].size(), imagePoints1[i].size(), and imagePoints2[i].size() need to
     * be equal for each i.
     * @param imagePoints1 Vector of vectors of the projections of the calibration pattern points,
     * observed by the first camera. The same structure as in REF: calibrateCamera.
     * @param imagePoints2 Vector of vectors of the projections of the calibration pattern points,
     * observed by the second camera. The same structure as in REF: calibrateCamera.
     * @param cameraMatrix1 Input/output camera intrinsic matrix for the first camera, the same as in
     * REF: calibrateCamera. Furthermore, for the stereo case, additional flags may be used, see below.
     * @param distCoeffs1 Input/output vector of distortion coefficients, the same as in
     * REF: calibrateCamera.
     * @param cameraMatrix2 Input/output second camera intrinsic matrix for the second camera. See description for
     * cameraMatrix1.
     * @param distCoeffs2 Input/output lens distortion coefficients for the second camera. See
     * description for distCoeffs1.
     * @param imageSize Size of the image used only to initialize the camera intrinsic matrices.
     * @param R Output rotation matrix. Together with the translation vector T, this matrix brings
     * points given in the first camera's coordinate system to points in the second camera's
     * coordinate system. In more technical terms, the tuple of R and T performs a change of basis
     * from the first camera's coordinate system to the second camera's coordinate system. Due to its
     * duality, this tuple is equivalent to the position of the first camera with respect to the
     * second camera coordinate system.
     * @param T Output translation vector, see description above.
     * @param E Output essential matrix.
     * @param F Output fundamental matrix.
     * @param rvecs Output vector of rotation vectors ( REF: Rodrigues ) estimated for each pattern view in the
     * coordinate system of the first camera of the stereo pair (e.g. std::vector&lt;cv::Mat&gt;). More in detail, each
     * i-th rotation vector together with the corresponding i-th translation vector (see the next output parameter
     * description) brings the calibration pattern from the object coordinate space (in which object points are
     * specified) to the camera coordinate space of the first camera of the stereo pair. In more technical terms,
     * the tuple of the i-th rotation and translation vector performs a change of basis from object coordinate space
     * to camera coordinate space of the first camera of the stereo pair.
     * @param tvecs Output vector of translation vectors estimated for each pattern view, see parameter description
     * of previous output parameter ( rvecs ).
     * @param perViewErrors Output vector of the RMS re-projection error estimated for each pattern view.
     * @param flags Different flags that may be zero or a combination of the following values:
     * <ul>
     *   <li>
     *    REF: CALIB_FIX_INTRINSIC Fix cameraMatrix? and distCoeffs? so that only R, T, E, and F
     * matrices are estimated.
     *   </li>
     *   <li>
     *    REF: CALIB_USE_INTRINSIC_GUESS Optimize some or all of the intrinsic parameters
     * according to the specified flags. Initial values are provided by the user.
     *   </li>
     *   <li>
     *    REF: CALIB_USE_EXTRINSIC_GUESS R and T contain valid initial values that are optimized further.
     * Otherwise R and T are initialized to the median value of the pattern views (each dimension separately).
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_PRINCIPAL_POINT Fix the principal points during the optimization.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_FOCAL_LENGTH Fix \(f^{(j)}_x\) and \(f^{(j)}_y\) .
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_ASPECT_RATIO Optimize \(f^{(j)}_y\) . Fix the ratio \(f^{(j)}_x/f^{(j)}_y\)
     * .
     *   </li>
     *   <li>
     *    REF: CALIB_SAME_FOCAL_LENGTH Enforce \(f^{(0)}_x=f^{(1)}_x\) and \(f^{(0)}_y=f^{(1)}_y\) .
     *   </li>
     *   <li>
     *    REF: CALIB_ZERO_TANGENT_DIST Set tangential distortion coefficients for each camera to
     * zeros and fix there.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_K1,..., REF: CALIB_FIX_K6 Do not change the corresponding radial
     * distortion coefficient during the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is set,
     * the coefficient from the supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     *   <li>
     *    REF: CALIB_RATIONAL_MODEL Enable coefficients k4, k5, and k6. To provide the backward
     * compatibility, this extra flag should be explicitly specified to make the calibration
     * function use the rational model and return 8 coefficients. If the flag is not set, the
     * function computes and returns only 5 distortion coefficients.
     *   </li>
     *   <li>
     *    REF: CALIB_THIN_PRISM_MODEL Coefficients s1, s2, s3 and s4 are enabled. To provide the
     * backward compatibility, this extra flag should be explicitly specified to make the
     * calibration function use the thin prism model and return 12 coefficients. If the flag is not
     * set, the function computes and returns only 5 distortion coefficients.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_S1_S2_S3_S4 The thin prism distortion coefficients are not changed during
     * the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is set, the coefficient from the
     * supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     *   <li>
     *    REF: CALIB_TILTED_MODEL Coefficients tauX and tauY are enabled. To provide the
     * backward compatibility, this extra flag should be explicitly specified to make the
     * calibration function use the tilted sensor model and return 14 coefficients. If the flag is not
     * set, the function computes and returns only 5 distortion coefficients.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_TAUX_TAUY The coefficients of the tilted sensor model are not changed during
     * the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is set, the coefficient from the
     * supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     * </ul>
     * @param criteria Termination criteria for the iterative optimization algorithm.
     *
     * The function estimates the transformation between two cameras making a stereo pair. If one computes
     * the poses of an object relative to the first camera and to the second camera,
     * ( \(R_1\),\(T_1\) ) and (\(R_2\),\(T_2\)), respectively, for a stereo camera where the
     * relative position and orientation between the two cameras are fixed, then those poses definitely
     * relate to each other. This means, if the relative position and orientation (\(R\),\(T\)) of the
     * two cameras is known, it is possible to compute (\(R_2\),\(T_2\)) when (\(R_1\),\(T_1\)) is
     * given. This is what the described function does. It computes (\(R\),\(T\)) such that:
     *
     * \(R_2=R R_1\)
     * \(T_2=R T_1 + T.\)
     *
     * Therefore, one can compute the coordinate representation of a 3D point for the second camera's
     * coordinate system when given the point's coordinate representation in the first camera's coordinate
     * system:
     *
     * \(\begin{bmatrix}
     * X_2 \\
     * Y_2 \\
     * Z_2 \\
     * 1
     * \end{bmatrix} = \begin{bmatrix}
     * R &amp; T \\
     * 0 &amp; 1
     * \end{bmatrix} \begin{bmatrix}
     * X_1 \\
     * Y_1 \\
     * Z_1 \\
     * 1
     * \end{bmatrix}.\)
     *
     *
     * Optionally, it computes the essential matrix E:
     *
     * \(E= \vecthreethree{0}{-T_2}{T_1}{T_2}{0}{-T_0}{-T_1}{T_0}{0} R\)
     *
     * where \(T_i\) are components of the translation vector \(T\) : \(T=[T_0, T_1, T_2]^T\) .
     * And the function can also compute the fundamental matrix F:
     *
     * \(F = cameraMatrix2^{-T}\cdot E \cdot cameraMatrix1^{-1}\)
     *
     * Besides the stereo-related information, the function can also perform a full calibration of each of
     * the two cameras. However, due to the high dimensionality of the parameter space and noise in the
     * input data, the function can diverge from the correct solution. If the intrinsic parameters can be
     * estimated with high accuracy for each of the cameras individually (for example, using
     * #calibrateCamera ), you are recommended to do so and then pass REF: CALIB_FIX_INTRINSIC flag to the
     * function along with the computed intrinsic parameters. Otherwise, if all the parameters are
     * estimated at once, it makes sense to restrict some parameters, for example, pass
     *  REF: CALIB_SAME_FOCAL_LENGTH and REF: CALIB_ZERO_TANGENT_DIST flags, which is usually a
     * reasonable assumption.
     *
     * Similarly to #calibrateCamera, the function minimizes the total re-projection error for all the
     * points in all the available views from both cameras. The function returns the final value of the
     * re-projection error.
     * @return automatically generated
     */
    public static double stereoCalibrateExtended(List<Mat> objectPoints, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, Mat cameraMatrix2, Mat distCoeffs2, Size imageSize, Mat R, Mat T, Mat E, Mat F, List<Mat> rvecs, List<Mat> tvecs, Mat perViewErrors, int flags, TermCriteria criteria) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = stereoCalibrateExtended_0(objectPoints_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, cameraMatrix1.nativeObj, distCoeffs1.nativeObj, cameraMatrix2.nativeObj, distCoeffs2.nativeObj, imageSize.width, imageSize.height, R.nativeObj, T.nativeObj, E.nativeObj, F.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, perViewErrors.nativeObj, flags, criteria.type, criteria.maxCount, criteria.epsilon);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }

    /**
     * Calibrates a stereo camera set up. This function finds the intrinsic parameters
     * for each of the two cameras and the extrinsic parameters between the two cameras.
     *
     * @param objectPoints Vector of vectors of the calibration pattern points. The same structure as
     * in REF: calibrateCamera. For each pattern view, both cameras need to see the same object
     * points. Therefore, objectPoints.size(), imagePoints1.size(), and imagePoints2.size() need to be
     * equal as well as objectPoints[i].size(), imagePoints1[i].size(), and imagePoints2[i].size() need to
     * be equal for each i.
     * @param imagePoints1 Vector of vectors of the projections of the calibration pattern points,
     * observed by the first camera. The same structure as in REF: calibrateCamera.
     * @param imagePoints2 Vector of vectors of the projections of the calibration pattern points,
     * observed by the second camera. The same structure as in REF: calibrateCamera.
     * @param cameraMatrix1 Input/output camera intrinsic matrix for the first camera, the same as in
     * REF: calibrateCamera. Furthermore, for the stereo case, additional flags may be used, see below.
     * @param distCoeffs1 Input/output vector of distortion coefficients, the same as in
     * REF: calibrateCamera.
     * @param cameraMatrix2 Input/output second camera intrinsic matrix for the second camera. See description for
     * cameraMatrix1.
     * @param distCoeffs2 Input/output lens distortion coefficients for the second camera. See
     * description for distCoeffs1.
     * @param imageSize Size of the image used only to initialize the camera intrinsic matrices.
     * @param R Output rotation matrix. Together with the translation vector T, this matrix brings
     * points given in the first camera's coordinate system to points in the second camera's
     * coordinate system. In more technical terms, the tuple of R and T performs a change of basis
     * from the first camera's coordinate system to the second camera's coordinate system. Due to its
     * duality, this tuple is equivalent to the position of the first camera with respect to the
     * second camera coordinate system.
     * @param T Output translation vector, see description above.
     * @param E Output essential matrix.
     * @param F Output fundamental matrix.
     * @param rvecs Output vector of rotation vectors ( REF: Rodrigues ) estimated for each pattern view in the
     * coordinate system of the first camera of the stereo pair (e.g. std::vector&lt;cv::Mat&gt;). More in detail, each
     * i-th rotation vector together with the corresponding i-th translation vector (see the next output parameter
     * description) brings the calibration pattern from the object coordinate space (in which object points are
     * specified) to the camera coordinate space of the first camera of the stereo pair. In more technical terms,
     * the tuple of the i-th rotation and translation vector performs a change of basis from object coordinate space
     * to camera coordinate space of the first camera of the stereo pair.
     * @param tvecs Output vector of translation vectors estimated for each pattern view, see parameter description
     * of previous output parameter ( rvecs ).
     * @param perViewErrors Output vector of the RMS re-projection error estimated for each pattern view.
     * @param flags Different flags that may be zero or a combination of the following values:
     * <ul>
     *   <li>
     *    REF: CALIB_FIX_INTRINSIC Fix cameraMatrix? and distCoeffs? so that only R, T, E, and F
     * matrices are estimated.
     *   </li>
     *   <li>
     *    REF: CALIB_USE_INTRINSIC_GUESS Optimize some or all of the intrinsic parameters
     * according to the specified flags. Initial values are provided by the user.
     *   </li>
     *   <li>
     *    REF: CALIB_USE_EXTRINSIC_GUESS R and T contain valid initial values that are optimized further.
     * Otherwise R and T are initialized to the median value of the pattern views (each dimension separately).
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_PRINCIPAL_POINT Fix the principal points during the optimization.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_FOCAL_LENGTH Fix \(f^{(j)}_x\) and \(f^{(j)}_y\) .
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_ASPECT_RATIO Optimize \(f^{(j)}_y\) . Fix the ratio \(f^{(j)}_x/f^{(j)}_y\)
     * .
     *   </li>
     *   <li>
     *    REF: CALIB_SAME_FOCAL_LENGTH Enforce \(f^{(0)}_x=f^{(1)}_x\) and \(f^{(0)}_y=f^{(1)}_y\) .
     *   </li>
     *   <li>
     *    REF: CALIB_ZERO_TANGENT_DIST Set tangential distortion coefficients for each camera to
     * zeros and fix there.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_K1,..., REF: CALIB_FIX_K6 Do not change the corresponding radial
     * distortion coefficient during the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is set,
     * the coefficient from the supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     *   <li>
     *    REF: CALIB_RATIONAL_MODEL Enable coefficients k4, k5, and k6. To provide the backward
     * compatibility, this extra flag should be explicitly specified to make the calibration
     * function use the rational model and return 8 coefficients. If the flag is not set, the
     * function computes and returns only 5 distortion coefficients.
     *   </li>
     *   <li>
     *    REF: CALIB_THIN_PRISM_MODEL Coefficients s1, s2, s3 and s4 are enabled. To provide the
     * backward compatibility, this extra flag should be explicitly specified to make the
     * calibration function use the thin prism model and return 12 coefficients. If the flag is not
     * set, the function computes and returns only 5 distortion coefficients.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_S1_S2_S3_S4 The thin prism distortion coefficients are not changed during
     * the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is set, the coefficient from the
     * supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     *   <li>
     *    REF: CALIB_TILTED_MODEL Coefficients tauX and tauY are enabled. To provide the
     * backward compatibility, this extra flag should be explicitly specified to make the
     * calibration function use the tilted sensor model and return 14 coefficients. If the flag is not
     * set, the function computes and returns only 5 distortion coefficients.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_TAUX_TAUY The coefficients of the tilted sensor model are not changed during
     * the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is set, the coefficient from the
     * supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     * </ul>
     *
     * The function estimates the transformation between two cameras making a stereo pair. If one computes
     * the poses of an object relative to the first camera and to the second camera,
     * ( \(R_1\),\(T_1\) ) and (\(R_2\),\(T_2\)), respectively, for a stereo camera where the
     * relative position and orientation between the two cameras are fixed, then those poses definitely
     * relate to each other. This means, if the relative position and orientation (\(R\),\(T\)) of the
     * two cameras is known, it is possible to compute (\(R_2\),\(T_2\)) when (\(R_1\),\(T_1\)) is
     * given. This is what the described function does. It computes (\(R\),\(T\)) such that:
     *
     * \(R_2=R R_1\)
     * \(T_2=R T_1 + T.\)
     *
     * Therefore, one can compute the coordinate representation of a 3D point for the second camera's
     * coordinate system when given the point's coordinate representation in the first camera's coordinate
     * system:
     *
     * \(\begin{bmatrix}
     * X_2 \\
     * Y_2 \\
     * Z_2 \\
     * 1
     * \end{bmatrix} = \begin{bmatrix}
     * R &amp; T \\
     * 0 &amp; 1
     * \end{bmatrix} \begin{bmatrix}
     * X_1 \\
     * Y_1 \\
     * Z_1 \\
     * 1
     * \end{bmatrix}.\)
     *
     *
     * Optionally, it computes the essential matrix E:
     *
     * \(E= \vecthreethree{0}{-T_2}{T_1}{T_2}{0}{-T_0}{-T_1}{T_0}{0} R\)
     *
     * where \(T_i\) are components of the translation vector \(T\) : \(T=[T_0, T_1, T_2]^T\) .
     * And the function can also compute the fundamental matrix F:
     *
     * \(F = cameraMatrix2^{-T}\cdot E \cdot cameraMatrix1^{-1}\)
     *
     * Besides the stereo-related information, the function can also perform a full calibration of each of
     * the two cameras. However, due to the high dimensionality of the parameter space and noise in the
     * input data, the function can diverge from the correct solution. If the intrinsic parameters can be
     * estimated with high accuracy for each of the cameras individually (for example, using
     * #calibrateCamera ), you are recommended to do so and then pass REF: CALIB_FIX_INTRINSIC flag to the
     * function along with the computed intrinsic parameters. Otherwise, if all the parameters are
     * estimated at once, it makes sense to restrict some parameters, for example, pass
     *  REF: CALIB_SAME_FOCAL_LENGTH and REF: CALIB_ZERO_TANGENT_DIST flags, which is usually a
     * reasonable assumption.
     *
     * Similarly to #calibrateCamera, the function minimizes the total re-projection error for all the
     * points in all the available views from both cameras. The function returns the final value of the
     * re-projection error.
     * @return automatically generated
     */
    public static double stereoCalibrateExtended(List<Mat> objectPoints, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, Mat cameraMatrix2, Mat distCoeffs2, Size imageSize, Mat R, Mat T, Mat E, Mat F, List<Mat> rvecs, List<Mat> tvecs, Mat perViewErrors, int flags) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = stereoCalibrateExtended_1(objectPoints_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, cameraMatrix1.nativeObj, distCoeffs1.nativeObj, cameraMatrix2.nativeObj, distCoeffs2.nativeObj, imageSize.width, imageSize.height, R.nativeObj, T.nativeObj, E.nativeObj, F.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, perViewErrors.nativeObj, flags);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }

    /**
     * Calibrates a stereo camera set up. This function finds the intrinsic parameters
     * for each of the two cameras and the extrinsic parameters between the two cameras.
     *
     * @param objectPoints Vector of vectors of the calibration pattern points. The same structure as
     * in REF: calibrateCamera. For each pattern view, both cameras need to see the same object
     * points. Therefore, objectPoints.size(), imagePoints1.size(), and imagePoints2.size() need to be
     * equal as well as objectPoints[i].size(), imagePoints1[i].size(), and imagePoints2[i].size() need to
     * be equal for each i.
     * @param imagePoints1 Vector of vectors of the projections of the calibration pattern points,
     * observed by the first camera. The same structure as in REF: calibrateCamera.
     * @param imagePoints2 Vector of vectors of the projections of the calibration pattern points,
     * observed by the second camera. The same structure as in REF: calibrateCamera.
     * @param cameraMatrix1 Input/output camera intrinsic matrix for the first camera, the same as in
     * REF: calibrateCamera. Furthermore, for the stereo case, additional flags may be used, see below.
     * @param distCoeffs1 Input/output vector of distortion coefficients, the same as in
     * REF: calibrateCamera.
     * @param cameraMatrix2 Input/output second camera intrinsic matrix for the second camera. See description for
     * cameraMatrix1.
     * @param distCoeffs2 Input/output lens distortion coefficients for the second camera. See
     * description for distCoeffs1.
     * @param imageSize Size of the image used only to initialize the camera intrinsic matrices.
     * @param R Output rotation matrix. Together with the translation vector T, this matrix brings
     * points given in the first camera's coordinate system to points in the second camera's
     * coordinate system. In more technical terms, the tuple of R and T performs a change of basis
     * from the first camera's coordinate system to the second camera's coordinate system. Due to its
     * duality, this tuple is equivalent to the position of the first camera with respect to the
     * second camera coordinate system.
     * @param T Output translation vector, see description above.
     * @param E Output essential matrix.
     * @param F Output fundamental matrix.
     * @param rvecs Output vector of rotation vectors ( REF: Rodrigues ) estimated for each pattern view in the
     * coordinate system of the first camera of the stereo pair (e.g. std::vector&lt;cv::Mat&gt;). More in detail, each
     * i-th rotation vector together with the corresponding i-th translation vector (see the next output parameter
     * description) brings the calibration pattern from the object coordinate space (in which object points are
     * specified) to the camera coordinate space of the first camera of the stereo pair. In more technical terms,
     * the tuple of the i-th rotation and translation vector performs a change of basis from object coordinate space
     * to camera coordinate space of the first camera of the stereo pair.
     * @param tvecs Output vector of translation vectors estimated for each pattern view, see parameter description
     * of previous output parameter ( rvecs ).
     * @param perViewErrors Output vector of the RMS re-projection error estimated for each pattern view.
     * <ul>
     *   <li>
     *    REF: CALIB_FIX_INTRINSIC Fix cameraMatrix? and distCoeffs? so that only R, T, E, and F
     * matrices are estimated.
     *   </li>
     *   <li>
     *    REF: CALIB_USE_INTRINSIC_GUESS Optimize some or all of the intrinsic parameters
     * according to the specified flags. Initial values are provided by the user.
     *   </li>
     *   <li>
     *    REF: CALIB_USE_EXTRINSIC_GUESS R and T contain valid initial values that are optimized further.
     * Otherwise R and T are initialized to the median value of the pattern views (each dimension separately).
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_PRINCIPAL_POINT Fix the principal points during the optimization.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_FOCAL_LENGTH Fix \(f^{(j)}_x\) and \(f^{(j)}_y\) .
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_ASPECT_RATIO Optimize \(f^{(j)}_y\) . Fix the ratio \(f^{(j)}_x/f^{(j)}_y\)
     * .
     *   </li>
     *   <li>
     *    REF: CALIB_SAME_FOCAL_LENGTH Enforce \(f^{(0)}_x=f^{(1)}_x\) and \(f^{(0)}_y=f^{(1)}_y\) .
     *   </li>
     *   <li>
     *    REF: CALIB_ZERO_TANGENT_DIST Set tangential distortion coefficients for each camera to
     * zeros and fix there.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_K1,..., REF: CALIB_FIX_K6 Do not change the corresponding radial
     * distortion coefficient during the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is set,
     * the coefficient from the supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     *   <li>
     *    REF: CALIB_RATIONAL_MODEL Enable coefficients k4, k5, and k6. To provide the backward
     * compatibility, this extra flag should be explicitly specified to make the calibration
     * function use the rational model and return 8 coefficients. If the flag is not set, the
     * function computes and returns only 5 distortion coefficients.
     *   </li>
     *   <li>
     *    REF: CALIB_THIN_PRISM_MODEL Coefficients s1, s2, s3 and s4 are enabled. To provide the
     * backward compatibility, this extra flag should be explicitly specified to make the
     * calibration function use the thin prism model and return 12 coefficients. If the flag is not
     * set, the function computes and returns only 5 distortion coefficients.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_S1_S2_S3_S4 The thin prism distortion coefficients are not changed during
     * the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is set, the coefficient from the
     * supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     *   <li>
     *    REF: CALIB_TILTED_MODEL Coefficients tauX and tauY are enabled. To provide the
     * backward compatibility, this extra flag should be explicitly specified to make the
     * calibration function use the tilted sensor model and return 14 coefficients. If the flag is not
     * set, the function computes and returns only 5 distortion coefficients.
     *   </li>
     *   <li>
     *    REF: CALIB_FIX_TAUX_TAUY The coefficients of the tilted sensor model are not changed during
     * the optimization. If REF: CALIB_USE_INTRINSIC_GUESS is set, the coefficient from the
     * supplied distCoeffs matrix is used. Otherwise, it is set to 0.
     *   </li>
     * </ul>
     *
     * The function estimates the transformation between two cameras making a stereo pair. If one computes
     * the poses of an object relative to the first camera and to the second camera,
     * ( \(R_1\),\(T_1\) ) and (\(R_2\),\(T_2\)), respectively, for a stereo camera where the
     * relative position and orientation between the two cameras are fixed, then those poses definitely
     * relate to each other. This means, if the relative position and orientation (\(R\),\(T\)) of the
     * two cameras is known, it is possible to compute (\(R_2\),\(T_2\)) when (\(R_1\),\(T_1\)) is
     * given. This is what the described function does. It computes (\(R\),\(T\)) such that:
     *
     * \(R_2=R R_1\)
     * \(T_2=R T_1 + T.\)
     *
     * Therefore, one can compute the coordinate representation of a 3D point for the second camera's
     * coordinate system when given the point's coordinate representation in the first camera's coordinate
     * system:
     *
     * \(\begin{bmatrix}
     * X_2 \\
     * Y_2 \\
     * Z_2 \\
     * 1
     * \end{bmatrix} = \begin{bmatrix}
     * R &amp; T \\
     * 0 &amp; 1
     * \end{bmatrix} \begin{bmatrix}
     * X_1 \\
     * Y_1 \\
     * Z_1 \\
     * 1
     * \end{bmatrix}.\)
     *
     *
     * Optionally, it computes the essential matrix E:
     *
     * \(E= \vecthreethree{0}{-T_2}{T_1}{T_2}{0}{-T_0}{-T_1}{T_0}{0} R\)
     *
     * where \(T_i\) are components of the translation vector \(T\) : \(T=[T_0, T_1, T_2]^T\) .
     * And the function can also compute the fundamental matrix F:
     *
     * \(F = cameraMatrix2^{-T}\cdot E \cdot cameraMatrix1^{-1}\)
     *
     * Besides the stereo-related information, the function can also perform a full calibration of each of
     * the two cameras. However, due to the high dimensionality of the parameter space and noise in the
     * input data, the function can diverge from the correct solution. If the intrinsic parameters can be
     * estimated with high accuracy for each of the cameras individually (for example, using
     * #calibrateCamera ), you are recommended to do so and then pass REF: CALIB_FIX_INTRINSIC flag to the
     * function along with the computed intrinsic parameters. Otherwise, if all the parameters are
     * estimated at once, it makes sense to restrict some parameters, for example, pass
     *  REF: CALIB_SAME_FOCAL_LENGTH and REF: CALIB_ZERO_TANGENT_DIST flags, which is usually a
     * reasonable assumption.
     *
     * Similarly to #calibrateCamera, the function minimizes the total re-projection error for all the
     * points in all the available views from both cameras. The function returns the final value of the
     * re-projection error.
     * @return automatically generated
     */
    public static double stereoCalibrateExtended(List<Mat> objectPoints, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, Mat cameraMatrix2, Mat distCoeffs2, Size imageSize, Mat R, Mat T, Mat E, Mat F, List<Mat> rvecs, List<Mat> tvecs, Mat perViewErrors) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = stereoCalibrateExtended_2(objectPoints_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, cameraMatrix1.nativeObj, distCoeffs1.nativeObj, cameraMatrix2.nativeObj, distCoeffs2.nativeObj, imageSize.width, imageSize.height, R.nativeObj, T.nativeObj, E.nativeObj, F.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, perViewErrors.nativeObj);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }


    //
    // C++:  double cv::stereoCalibrate(vector_Mat objectPoints, vector_Mat imagePoints1, vector_Mat imagePoints2, Mat& cameraMatrix1, Mat& distCoeffs1, Mat& cameraMatrix2, Mat& distCoeffs2, Size imageSize, Mat& R, Mat& T, Mat& E, Mat& F, int flags = CALIB_FIX_INTRINSIC, TermCriteria criteria = TermCriteria(TermCriteria::COUNT+TermCriteria::EPS, 100, 1e-6))
    //

    public static double stereoCalibrate(List<Mat> objectPoints, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, Mat cameraMatrix2, Mat distCoeffs2, Size imageSize, Mat R, Mat T, Mat E, Mat F, int flags, TermCriteria criteria) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        return stereoCalibrate_0(objectPoints_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, cameraMatrix1.nativeObj, distCoeffs1.nativeObj, cameraMatrix2.nativeObj, distCoeffs2.nativeObj, imageSize.width, imageSize.height, R.nativeObj, T.nativeObj, E.nativeObj, F.nativeObj, flags, criteria.type, criteria.maxCount, criteria.epsilon);
    }

    public static double stereoCalibrate(List<Mat> objectPoints, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, Mat cameraMatrix2, Mat distCoeffs2, Size imageSize, Mat R, Mat T, Mat E, Mat F, int flags) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        return stereoCalibrate_1(objectPoints_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, cameraMatrix1.nativeObj, distCoeffs1.nativeObj, cameraMatrix2.nativeObj, distCoeffs2.nativeObj, imageSize.width, imageSize.height, R.nativeObj, T.nativeObj, E.nativeObj, F.nativeObj, flags);
    }

    public static double stereoCalibrate(List<Mat> objectPoints, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, Mat cameraMatrix2, Mat distCoeffs2, Size imageSize, Mat R, Mat T, Mat E, Mat F) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        return stereoCalibrate_2(objectPoints_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, cameraMatrix1.nativeObj, distCoeffs1.nativeObj, cameraMatrix2.nativeObj, distCoeffs2.nativeObj, imageSize.width, imageSize.height, R.nativeObj, T.nativeObj, E.nativeObj, F.nativeObj);
    }


    //
    // C++:  double cv::stereoCalibrate(vector_Mat objectPoints, vector_Mat imagePoints1, vector_Mat imagePoints2, Mat& cameraMatrix1, Mat& distCoeffs1, Mat& cameraMatrix2, Mat& distCoeffs2, Size imageSize, Mat& R, Mat& T, Mat& E, Mat& F, Mat& perViewErrors, int flags = CALIB_FIX_INTRINSIC, TermCriteria criteria = TermCriteria(TermCriteria::COUNT+TermCriteria::EPS, 30, 1e-6))
    //

    public static double stereoCalibrate(List<Mat> objectPoints, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, Mat cameraMatrix2, Mat distCoeffs2, Size imageSize, Mat R, Mat T, Mat E, Mat F, Mat perViewErrors, int flags, TermCriteria criteria) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        return stereoCalibrate_3(objectPoints_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, cameraMatrix1.nativeObj, distCoeffs1.nativeObj, cameraMatrix2.nativeObj, distCoeffs2.nativeObj, imageSize.width, imageSize.height, R.nativeObj, T.nativeObj, E.nativeObj, F.nativeObj, perViewErrors.nativeObj, flags, criteria.type, criteria.maxCount, criteria.epsilon);
    }

    public static double stereoCalibrate(List<Mat> objectPoints, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, Mat cameraMatrix2, Mat distCoeffs2, Size imageSize, Mat R, Mat T, Mat E, Mat F, Mat perViewErrors, int flags) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        return stereoCalibrate_4(objectPoints_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, cameraMatrix1.nativeObj, distCoeffs1.nativeObj, cameraMatrix2.nativeObj, distCoeffs2.nativeObj, imageSize.width, imageSize.height, R.nativeObj, T.nativeObj, E.nativeObj, F.nativeObj, perViewErrors.nativeObj, flags);
    }

    public static double stereoCalibrate(List<Mat> objectPoints, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, Mat cameraMatrix2, Mat distCoeffs2, Size imageSize, Mat R, Mat T, Mat E, Mat F, Mat perViewErrors) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        return stereoCalibrate_5(objectPoints_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, cameraMatrix1.nativeObj, distCoeffs1.nativeObj, cameraMatrix2.nativeObj, distCoeffs2.nativeObj, imageSize.width, imageSize.height, R.nativeObj, T.nativeObj, E.nativeObj, F.nativeObj, perViewErrors.nativeObj);
    }


    //
    // C++:  double cv::registerCameras(vector_Mat objectPoints1, vector_Mat objectPoints2, vector_Mat imagePoints1, vector_Mat imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, CameraModel cameraModel1, Mat cameraMatrix2, Mat distCoeffs2, CameraModel cameraModel2, Mat& R, Mat& T, Mat& E, Mat& F, vector_Mat& rvecs, vector_Mat& tvecs, Mat& perViewErrors, int flags = 0, TermCriteria criteria = TermCriteria(TermCriteria::COUNT+TermCriteria::EPS, 100, 1e-6))
    //

    /**
     * Calibrates a camera pair set up. This function finds the extrinsic parameters between the two cameras.
     *
     * @param objectPoints1 Vector of vectors of the calibration pattern points for camera 1.
     * A similar structure as objectPoints in REF: calibrateCamera and for each pattern view,
     * both cameras do not need to see the same object points. objectPoints1.size(), imagePoints1.size()
     * nees to be equal,as well as objectPoints1[i].size(), imagePoints1[i].size() need to be equal for each i.
     * @param objectPoints2 Vector of vectors of the calibration pattern points for camera 2.
     * A similar structure as objectPoints1. objectPoints2.size(), and imagePoints2.size() nees to be equal,
     * as well as objectPoints2[i].size(), imagePoints2[i].size() need to be equal for each i.
     * However, objectPoints1[i].size() and objectPoints2[i].size() are not required to be equal.
     * @param imagePoints1 Vector of vectors of the projections of the calibration pattern points,
     * observed by the first camera. The same structure as in REF: calibrateCamera.
     * @param imagePoints2 Vector of vectors of the projections of the calibration pattern points,
     * observed by the second camera. The same structure as in REF: calibrateCamera.
     * @param cameraMatrix1 Input/output camera intrinsic matrix for the first camera, the same as in
     * REF: calibrateCamera. Furthermore, for the stereo case, additional flags may be used, see below.
     * @param distCoeffs1 Input/output vector of distortion coefficients, the same as in
     * REF: calibrateCamera.
     * @param cameraModel1 Flag reflecting the type of model for camera 1 (pinhole / fisheye):
     * <ul>
     *   <li>
     *  REF: CALIB_MODEL_PINHOLE pinhole camera model
     *   </li>
     *   <li>
     *  REF: CALIB_MODEL_FISHEYE fisheye camera model
     *   </li>
     * </ul>
     * @param cameraMatrix2 Input/output second camera intrinsic matrix for the second camera.
     * See description for cameraMatrix1.
     * @param distCoeffs2 Input/output lens distortion coefficients for the second camera. See
     * description for distCoeffs1.
     * @param cameraModel2 Flag reflecting the type of model for camera 2 (pinhole / fisheye).
     * See description for cameraModel1.
     * @param R Output rotation matrix. Together with the translation vector T, this matrix brings
     * points given in the first camera's coordinate system to points in the second camera's
     * coordinate system. In more technical terms, the tuple of R and T performs a change of basis
     * from the first camera's coordinate system to the second camera's coordinate system. Due to its
     * duality, this tuple is equivalent to the position of the first camera with respect to the
     * second camera coordinate system.
     * @param T Output translation vector, see description above.
     * @param E Output essential matrix.
     * @param F Output fundamental matrix.
     * @param rvecs Output vector of rotation vectors ( REF: Rodrigues ) estimated for each pattern view in the
     * coordinate system of the first camera of the stereo pair (e.g. std::vector&lt;cv::Mat&gt;). More in detail, each
     * i-th rotation vector together with the corresponding i-th translation vector (see the next output parameter
     * description) brings the calibration pattern from the object coordinate space (in which object points are
     * specified) to the camera coordinate space of the first camera of the stereo pair. In more technical terms,
     * the tuple of the i-th rotation and translation vector performs a change of basis from object coordinate space
     * to the camera coordinate space of the first camera of the stereo pair.
     * @param tvecs Output vector of translation vectors estimated for each pattern view, see parameter description
     * of previous output parameter ( rvecs ).
     * @param perViewErrors Output vector of the RMS re-projection error estimated for each pattern view.
     * @param flags Different flags that may be zero or a combination of the following values:
     * <ul>
     *   <li>
     *    REF: CALIB_USE_EXTRINSIC_GUESS R and T contain valid initial values that are optimized further.
     *   </li>
     * </ul>
     * @param criteria Termination criteria for the iterative optimization algorithm.
     *
     * The function estimates the transformation between two cameras similar to stereo pair calibration.
     * The principle follows closely to REF: stereoCalibrate. To understand the problem of estimating the
     * relative pose between a camera pair, please refer to the description there. The difference for
     * this function is that, camera intrinsics are not optimized and two cameras are not required
     * to have overlapping fields of view as long as they are observing the same calibration target
     * and the absolute positions of each object point are known.
     * ![](pics/register_pair.png)
     * The above illustration shows an example where such a case may become relevant.
     * Additionally, it supports a camera pair with the mixed model (pinhole / fisheye).
     * Similarly to #calibrateCamera, the function minimizes the total re-projection error for all the
     * points in all the available views from both cameras.
     * @return the final value of the re-projection error.
     *
     * SEE: calibrateCamera, stereoCalibrate
     */
    public static double registerCamerasExtended(List<Mat> objectPoints1, List<Mat> objectPoints2, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, int cameraModel1, Mat cameraMatrix2, Mat distCoeffs2, int cameraModel2, Mat R, Mat T, Mat E, Mat F, List<Mat> rvecs, List<Mat> tvecs, Mat perViewErrors, int flags, TermCriteria criteria) {
        Mat objectPoints1_mat = Converters.vector_Mat_to_Mat(objectPoints1);
        Mat objectPoints2_mat = Converters.vector_Mat_to_Mat(objectPoints2);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = registerCamerasExtended_0(objectPoints1_mat.nativeObj, objectPoints2_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, cameraMatrix1.nativeObj, distCoeffs1.nativeObj, cameraModel1, cameraMatrix2.nativeObj, distCoeffs2.nativeObj, cameraModel2, R.nativeObj, T.nativeObj, E.nativeObj, F.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, perViewErrors.nativeObj, flags, criteria.type, criteria.maxCount, criteria.epsilon);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }

    /**
     * Calibrates a camera pair set up. This function finds the extrinsic parameters between the two cameras.
     *
     * @param objectPoints1 Vector of vectors of the calibration pattern points for camera 1.
     * A similar structure as objectPoints in REF: calibrateCamera and for each pattern view,
     * both cameras do not need to see the same object points. objectPoints1.size(), imagePoints1.size()
     * nees to be equal,as well as objectPoints1[i].size(), imagePoints1[i].size() need to be equal for each i.
     * @param objectPoints2 Vector of vectors of the calibration pattern points for camera 2.
     * A similar structure as objectPoints1. objectPoints2.size(), and imagePoints2.size() nees to be equal,
     * as well as objectPoints2[i].size(), imagePoints2[i].size() need to be equal for each i.
     * However, objectPoints1[i].size() and objectPoints2[i].size() are not required to be equal.
     * @param imagePoints1 Vector of vectors of the projections of the calibration pattern points,
     * observed by the first camera. The same structure as in REF: calibrateCamera.
     * @param imagePoints2 Vector of vectors of the projections of the calibration pattern points,
     * observed by the second camera. The same structure as in REF: calibrateCamera.
     * @param cameraMatrix1 Input/output camera intrinsic matrix for the first camera, the same as in
     * REF: calibrateCamera. Furthermore, for the stereo case, additional flags may be used, see below.
     * @param distCoeffs1 Input/output vector of distortion coefficients, the same as in
     * REF: calibrateCamera.
     * @param cameraModel1 Flag reflecting the type of model for camera 1 (pinhole / fisheye):
     * <ul>
     *   <li>
     *  REF: CALIB_MODEL_PINHOLE pinhole camera model
     *   </li>
     *   <li>
     *  REF: CALIB_MODEL_FISHEYE fisheye camera model
     *   </li>
     * </ul>
     * @param cameraMatrix2 Input/output second camera intrinsic matrix for the second camera.
     * See description for cameraMatrix1.
     * @param distCoeffs2 Input/output lens distortion coefficients for the second camera. See
     * description for distCoeffs1.
     * @param cameraModel2 Flag reflecting the type of model for camera 2 (pinhole / fisheye).
     * See description for cameraModel1.
     * @param R Output rotation matrix. Together with the translation vector T, this matrix brings
     * points given in the first camera's coordinate system to points in the second camera's
     * coordinate system. In more technical terms, the tuple of R and T performs a change of basis
     * from the first camera's coordinate system to the second camera's coordinate system. Due to its
     * duality, this tuple is equivalent to the position of the first camera with respect to the
     * second camera coordinate system.
     * @param T Output translation vector, see description above.
     * @param E Output essential matrix.
     * @param F Output fundamental matrix.
     * @param rvecs Output vector of rotation vectors ( REF: Rodrigues ) estimated for each pattern view in the
     * coordinate system of the first camera of the stereo pair (e.g. std::vector&lt;cv::Mat&gt;). More in detail, each
     * i-th rotation vector together with the corresponding i-th translation vector (see the next output parameter
     * description) brings the calibration pattern from the object coordinate space (in which object points are
     * specified) to the camera coordinate space of the first camera of the stereo pair. In more technical terms,
     * the tuple of the i-th rotation and translation vector performs a change of basis from object coordinate space
     * to the camera coordinate space of the first camera of the stereo pair.
     * @param tvecs Output vector of translation vectors estimated for each pattern view, see parameter description
     * of previous output parameter ( rvecs ).
     * @param perViewErrors Output vector of the RMS re-projection error estimated for each pattern view.
     * @param flags Different flags that may be zero or a combination of the following values:
     * <ul>
     *   <li>
     *    REF: CALIB_USE_EXTRINSIC_GUESS R and T contain valid initial values that are optimized further.
     *   </li>
     * </ul>
     *
     * The function estimates the transformation between two cameras similar to stereo pair calibration.
     * The principle follows closely to REF: stereoCalibrate. To understand the problem of estimating the
     * relative pose between a camera pair, please refer to the description there. The difference for
     * this function is that, camera intrinsics are not optimized and two cameras are not required
     * to have overlapping fields of view as long as they are observing the same calibration target
     * and the absolute positions of each object point are known.
     * ![](pics/register_pair.png)
     * The above illustration shows an example where such a case may become relevant.
     * Additionally, it supports a camera pair with the mixed model (pinhole / fisheye).
     * Similarly to #calibrateCamera, the function minimizes the total re-projection error for all the
     * points in all the available views from both cameras.
     * @return the final value of the re-projection error.
     *
     * SEE: calibrateCamera, stereoCalibrate
     */
    public static double registerCamerasExtended(List<Mat> objectPoints1, List<Mat> objectPoints2, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, int cameraModel1, Mat cameraMatrix2, Mat distCoeffs2, int cameraModel2, Mat R, Mat T, Mat E, Mat F, List<Mat> rvecs, List<Mat> tvecs, Mat perViewErrors, int flags) {
        Mat objectPoints1_mat = Converters.vector_Mat_to_Mat(objectPoints1);
        Mat objectPoints2_mat = Converters.vector_Mat_to_Mat(objectPoints2);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = registerCamerasExtended_1(objectPoints1_mat.nativeObj, objectPoints2_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, cameraMatrix1.nativeObj, distCoeffs1.nativeObj, cameraModel1, cameraMatrix2.nativeObj, distCoeffs2.nativeObj, cameraModel2, R.nativeObj, T.nativeObj, E.nativeObj, F.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, perViewErrors.nativeObj, flags);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }

    /**
     * Calibrates a camera pair set up. This function finds the extrinsic parameters between the two cameras.
     *
     * @param objectPoints1 Vector of vectors of the calibration pattern points for camera 1.
     * A similar structure as objectPoints in REF: calibrateCamera and for each pattern view,
     * both cameras do not need to see the same object points. objectPoints1.size(), imagePoints1.size()
     * nees to be equal,as well as objectPoints1[i].size(), imagePoints1[i].size() need to be equal for each i.
     * @param objectPoints2 Vector of vectors of the calibration pattern points for camera 2.
     * A similar structure as objectPoints1. objectPoints2.size(), and imagePoints2.size() nees to be equal,
     * as well as objectPoints2[i].size(), imagePoints2[i].size() need to be equal for each i.
     * However, objectPoints1[i].size() and objectPoints2[i].size() are not required to be equal.
     * @param imagePoints1 Vector of vectors of the projections of the calibration pattern points,
     * observed by the first camera. The same structure as in REF: calibrateCamera.
     * @param imagePoints2 Vector of vectors of the projections of the calibration pattern points,
     * observed by the second camera. The same structure as in REF: calibrateCamera.
     * @param cameraMatrix1 Input/output camera intrinsic matrix for the first camera, the same as in
     * REF: calibrateCamera. Furthermore, for the stereo case, additional flags may be used, see below.
     * @param distCoeffs1 Input/output vector of distortion coefficients, the same as in
     * REF: calibrateCamera.
     * @param cameraModel1 Flag reflecting the type of model for camera 1 (pinhole / fisheye):
     * <ul>
     *   <li>
     *  REF: CALIB_MODEL_PINHOLE pinhole camera model
     *   </li>
     *   <li>
     *  REF: CALIB_MODEL_FISHEYE fisheye camera model
     *   </li>
     * </ul>
     * @param cameraMatrix2 Input/output second camera intrinsic matrix for the second camera.
     * See description for cameraMatrix1.
     * @param distCoeffs2 Input/output lens distortion coefficients for the second camera. See
     * description for distCoeffs1.
     * @param cameraModel2 Flag reflecting the type of model for camera 2 (pinhole / fisheye).
     * See description for cameraModel1.
     * @param R Output rotation matrix. Together with the translation vector T, this matrix brings
     * points given in the first camera's coordinate system to points in the second camera's
     * coordinate system. In more technical terms, the tuple of R and T performs a change of basis
     * from the first camera's coordinate system to the second camera's coordinate system. Due to its
     * duality, this tuple is equivalent to the position of the first camera with respect to the
     * second camera coordinate system.
     * @param T Output translation vector, see description above.
     * @param E Output essential matrix.
     * @param F Output fundamental matrix.
     * @param rvecs Output vector of rotation vectors ( REF: Rodrigues ) estimated for each pattern view in the
     * coordinate system of the first camera of the stereo pair (e.g. std::vector&lt;cv::Mat&gt;). More in detail, each
     * i-th rotation vector together with the corresponding i-th translation vector (see the next output parameter
     * description) brings the calibration pattern from the object coordinate space (in which object points are
     * specified) to the camera coordinate space of the first camera of the stereo pair. In more technical terms,
     * the tuple of the i-th rotation and translation vector performs a change of basis from object coordinate space
     * to the camera coordinate space of the first camera of the stereo pair.
     * @param tvecs Output vector of translation vectors estimated for each pattern view, see parameter description
     * of previous output parameter ( rvecs ).
     * @param perViewErrors Output vector of the RMS re-projection error estimated for each pattern view.
     * <ul>
     *   <li>
     *    REF: CALIB_USE_EXTRINSIC_GUESS R and T contain valid initial values that are optimized further.
     *   </li>
     * </ul>
     *
     * The function estimates the transformation between two cameras similar to stereo pair calibration.
     * The principle follows closely to REF: stereoCalibrate. To understand the problem of estimating the
     * relative pose between a camera pair, please refer to the description there. The difference for
     * this function is that, camera intrinsics are not optimized and two cameras are not required
     * to have overlapping fields of view as long as they are observing the same calibration target
     * and the absolute positions of each object point are known.
     * ![](pics/register_pair.png)
     * The above illustration shows an example where such a case may become relevant.
     * Additionally, it supports a camera pair with the mixed model (pinhole / fisheye).
     * Similarly to #calibrateCamera, the function minimizes the total re-projection error for all the
     * points in all the available views from both cameras.
     * @return the final value of the re-projection error.
     *
     * SEE: calibrateCamera, stereoCalibrate
     */
    public static double registerCamerasExtended(List<Mat> objectPoints1, List<Mat> objectPoints2, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, int cameraModel1, Mat cameraMatrix2, Mat distCoeffs2, int cameraModel2, Mat R, Mat T, Mat E, Mat F, List<Mat> rvecs, List<Mat> tvecs, Mat perViewErrors) {
        Mat objectPoints1_mat = Converters.vector_Mat_to_Mat(objectPoints1);
        Mat objectPoints2_mat = Converters.vector_Mat_to_Mat(objectPoints2);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = registerCamerasExtended_2(objectPoints1_mat.nativeObj, objectPoints2_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, cameraMatrix1.nativeObj, distCoeffs1.nativeObj, cameraModel1, cameraMatrix2.nativeObj, distCoeffs2.nativeObj, cameraModel2, R.nativeObj, T.nativeObj, E.nativeObj, F.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, perViewErrors.nativeObj);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }


    //
    // C++:  double cv::registerCameras(vector_Mat objectPoints1, vector_Mat objectPoints2, vector_Mat imagePoints1, vector_Mat imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, CameraModel cameraModel1, Mat cameraMatrix2, Mat distCoeffs2, CameraModel cameraModel2, Mat& R, Mat& T, Mat& E, Mat& F, Mat& perViewErrors, int flags = 0, TermCriteria criteria = TermCriteria(TermCriteria::COUNT+TermCriteria::EPS, 100, 1e-6))
    //

    public static double registerCameras(List<Mat> objectPoints1, List<Mat> objectPoints2, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, int cameraModel1, Mat cameraMatrix2, Mat distCoeffs2, int cameraModel2, Mat R, Mat T, Mat E, Mat F, Mat perViewErrors, int flags, TermCriteria criteria) {
        Mat objectPoints1_mat = Converters.vector_Mat_to_Mat(objectPoints1);
        Mat objectPoints2_mat = Converters.vector_Mat_to_Mat(objectPoints2);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        return registerCameras_0(objectPoints1_mat.nativeObj, objectPoints2_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, cameraMatrix1.nativeObj, distCoeffs1.nativeObj, cameraModel1, cameraMatrix2.nativeObj, distCoeffs2.nativeObj, cameraModel2, R.nativeObj, T.nativeObj, E.nativeObj, F.nativeObj, perViewErrors.nativeObj, flags, criteria.type, criteria.maxCount, criteria.epsilon);
    }

    public static double registerCameras(List<Mat> objectPoints1, List<Mat> objectPoints2, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, int cameraModel1, Mat cameraMatrix2, Mat distCoeffs2, int cameraModel2, Mat R, Mat T, Mat E, Mat F, Mat perViewErrors, int flags) {
        Mat objectPoints1_mat = Converters.vector_Mat_to_Mat(objectPoints1);
        Mat objectPoints2_mat = Converters.vector_Mat_to_Mat(objectPoints2);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        return registerCameras_1(objectPoints1_mat.nativeObj, objectPoints2_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, cameraMatrix1.nativeObj, distCoeffs1.nativeObj, cameraModel1, cameraMatrix2.nativeObj, distCoeffs2.nativeObj, cameraModel2, R.nativeObj, T.nativeObj, E.nativeObj, F.nativeObj, perViewErrors.nativeObj, flags);
    }

    public static double registerCameras(List<Mat> objectPoints1, List<Mat> objectPoints2, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, int cameraModel1, Mat cameraMatrix2, Mat distCoeffs2, int cameraModel2, Mat R, Mat T, Mat E, Mat F, Mat perViewErrors) {
        Mat objectPoints1_mat = Converters.vector_Mat_to_Mat(objectPoints1);
        Mat objectPoints2_mat = Converters.vector_Mat_to_Mat(objectPoints2);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        return registerCameras_2(objectPoints1_mat.nativeObj, objectPoints2_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, cameraMatrix1.nativeObj, distCoeffs1.nativeObj, cameraModel1, cameraMatrix2.nativeObj, distCoeffs2.nativeObj, cameraModel2, R.nativeObj, T.nativeObj, E.nativeObj, F.nativeObj, perViewErrors.nativeObj);
    }


    //
    // C++:  double cv::calibrateMultiview(vector_Mat objPoints, vector_vector_Mat imagePoints, vector_Size imageSize, Mat detectionMask, Mat models, vector_Mat& Ks, vector_Mat& distortions, vector_Mat& Rs, vector_Mat& Ts, Mat& initializationPairs, vector_Mat& rvecs0, vector_Mat& tvecs0, Mat& perFrameErrors, Mat flagsForIntrinsics = Mat(), int flags = 0, TermCriteria criteria = TermCriteria(TermCriteria::COUNT + TermCriteria::EPS, 100, DBL_EPSILON))
    //

    // Unknown type 'vector_Size' (I), skipping the function


    //
    // C++:  double cv::calibrateMultiview(vector_Mat objPoints, vector_vector_Mat imagePoints, vector_Size imageSize, Mat detectionMask, Mat models, vector_Mat& Ks, vector_Mat& distortions, vector_Mat& Rs, vector_Mat& Ts, Mat flagsForIntrinsics = Mat(), int flags = 0, TermCriteria criteria = TermCriteria(TermCriteria::COUNT + TermCriteria::EPS, 100, DBL_EPSILON))
    //

    // Unknown type 'vector_Size' (I), skipping the function


    //
    // C++:  double cv::fisheye::calibrate(vector_Mat objectPoints, vector_Mat imagePoints, Size image_size, Mat& K, Mat& D, vector_Mat& rvecs, vector_Mat& tvecs, int flags = 0, TermCriteria criteria = TermCriteria(TermCriteria::COUNT + TermCriteria::EPS, 100, DBL_EPSILON))
    //

    /**
     * Performs camera calibration
     *
     * @param objectPoints vector of vectors of calibration pattern points in the calibration pattern
     * coordinate space.
     * @param imagePoints vector of vectors of the projections of calibration pattern points.
     * imagePoints.size() and objectPoints.size() and imagePoints[i].size() must be equal to
     * objectPoints[i].size() for each i.
     * @param image_size Size of the image used only to initialize the camera intrinsic matrix.
     * @param K Output 3x3 floating-point camera intrinsic matrix
     * \(\cameramatrix{A}\) . If
     * REF: cv::CALIB_USE_INTRINSIC_GUESS is specified, some or all of fx, fy, cx, cy must be
     * initialized before calling the function.
     * @param D Output vector of distortion coefficients \(\distcoeffsfisheye\).
     * @param rvecs Output vector of rotation vectors (see Rodrigues ) estimated for each pattern view.
     * That is, each k-th rotation vector together with the corresponding k-th translation vector (see
     * the next output parameter description) brings the calibration pattern from the model coordinate
     * space (in which object points are specified) to the world coordinate space, that is, a real
     * position of the calibration pattern in the k-th pattern view (k=0.. *M* -1).
     * @param tvecs Output vector of translation vectors estimated for each pattern view.
     * @param flags Different flags that may be zero or a combination of the following values:
     * <ul>
     *   <li>
     *    REF: cv::CALIB_USE_INTRINSIC_GUESS  cameraMatrix contains valid initial values of
     * fx, fy, cx, cy that are optimized further. Otherwise, (cx, cy) is initially set to the image
     * center ( imageSize is used), and focal distances are computed in a least-squares fashion.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_RECOMPUTE_EXTRINSIC  Extrinsic will be recomputed after each iteration
     * of intrinsic optimization.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_CHECK_COND  The functions will check validity of condition number.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_SKEW  Skew coefficient (alpha) is set to zero and stay zero.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_K1,..., REF: cv::CALIB_FIX_K4 Selected distortion coefficients
     * are set to zeros and stay zero.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_PRINCIPAL_POINT  The principal point is not changed during the global
     * optimization. It stays at the center or at a different location specified when REF: cv::CALIB_USE_INTRINSIC_GUESS is set too.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_FOCAL_LENGTH The focal length is not changed during the global
     * optimization. It is the \(max(width,height)/\pi\) or the provided \(f_x\), \(f_y\) when REF: cv::CALIB_USE_INTRINSIC_GUESS is set too.
     *   </li>
     * </ul>
     * @param criteria Termination criteria for the iterative optimization algorithm.
     * @return automatically generated
     */
    public static double fisheye_calibrate(List<Mat> objectPoints, List<Mat> imagePoints, Size image_size, Mat K, Mat D, List<Mat> rvecs, List<Mat> tvecs, int flags, TermCriteria criteria) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints_mat = Converters.vector_Mat_to_Mat(imagePoints);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = fisheye_calibrate_0(objectPoints_mat.nativeObj, imagePoints_mat.nativeObj, image_size.width, image_size.height, K.nativeObj, D.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, flags, criteria.type, criteria.maxCount, criteria.epsilon);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }

    /**
     * Performs camera calibration
     *
     * @param objectPoints vector of vectors of calibration pattern points in the calibration pattern
     * coordinate space.
     * @param imagePoints vector of vectors of the projections of calibration pattern points.
     * imagePoints.size() and objectPoints.size() and imagePoints[i].size() must be equal to
     * objectPoints[i].size() for each i.
     * @param image_size Size of the image used only to initialize the camera intrinsic matrix.
     * @param K Output 3x3 floating-point camera intrinsic matrix
     * \(\cameramatrix{A}\) . If
     * REF: cv::CALIB_USE_INTRINSIC_GUESS is specified, some or all of fx, fy, cx, cy must be
     * initialized before calling the function.
     * @param D Output vector of distortion coefficients \(\distcoeffsfisheye\).
     * @param rvecs Output vector of rotation vectors (see Rodrigues ) estimated for each pattern view.
     * That is, each k-th rotation vector together with the corresponding k-th translation vector (see
     * the next output parameter description) brings the calibration pattern from the model coordinate
     * space (in which object points are specified) to the world coordinate space, that is, a real
     * position of the calibration pattern in the k-th pattern view (k=0.. *M* -1).
     * @param tvecs Output vector of translation vectors estimated for each pattern view.
     * @param flags Different flags that may be zero or a combination of the following values:
     * <ul>
     *   <li>
     *    REF: cv::CALIB_USE_INTRINSIC_GUESS  cameraMatrix contains valid initial values of
     * fx, fy, cx, cy that are optimized further. Otherwise, (cx, cy) is initially set to the image
     * center ( imageSize is used), and focal distances are computed in a least-squares fashion.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_RECOMPUTE_EXTRINSIC  Extrinsic will be recomputed after each iteration
     * of intrinsic optimization.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_CHECK_COND  The functions will check validity of condition number.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_SKEW  Skew coefficient (alpha) is set to zero and stay zero.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_K1,..., REF: cv::CALIB_FIX_K4 Selected distortion coefficients
     * are set to zeros and stay zero.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_PRINCIPAL_POINT  The principal point is not changed during the global
     * optimization. It stays at the center or at a different location specified when REF: cv::CALIB_USE_INTRINSIC_GUESS is set too.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_FOCAL_LENGTH The focal length is not changed during the global
     * optimization. It is the \(max(width,height)/\pi\) or the provided \(f_x\), \(f_y\) when REF: cv::CALIB_USE_INTRINSIC_GUESS is set too.
     *   </li>
     * </ul>
     * @return automatically generated
     */
    public static double fisheye_calibrate(List<Mat> objectPoints, List<Mat> imagePoints, Size image_size, Mat K, Mat D, List<Mat> rvecs, List<Mat> tvecs, int flags) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints_mat = Converters.vector_Mat_to_Mat(imagePoints);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = fisheye_calibrate_1(objectPoints_mat.nativeObj, imagePoints_mat.nativeObj, image_size.width, image_size.height, K.nativeObj, D.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, flags);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }

    /**
     * Performs camera calibration
     *
     * @param objectPoints vector of vectors of calibration pattern points in the calibration pattern
     * coordinate space.
     * @param imagePoints vector of vectors of the projections of calibration pattern points.
     * imagePoints.size() and objectPoints.size() and imagePoints[i].size() must be equal to
     * objectPoints[i].size() for each i.
     * @param image_size Size of the image used only to initialize the camera intrinsic matrix.
     * @param K Output 3x3 floating-point camera intrinsic matrix
     * \(\cameramatrix{A}\) . If
     * REF: cv::CALIB_USE_INTRINSIC_GUESS is specified, some or all of fx, fy, cx, cy must be
     * initialized before calling the function.
     * @param D Output vector of distortion coefficients \(\distcoeffsfisheye\).
     * @param rvecs Output vector of rotation vectors (see Rodrigues ) estimated for each pattern view.
     * That is, each k-th rotation vector together with the corresponding k-th translation vector (see
     * the next output parameter description) brings the calibration pattern from the model coordinate
     * space (in which object points are specified) to the world coordinate space, that is, a real
     * position of the calibration pattern in the k-th pattern view (k=0.. *M* -1).
     * @param tvecs Output vector of translation vectors estimated for each pattern view.
     * <ul>
     *   <li>
     *    REF: cv::CALIB_USE_INTRINSIC_GUESS  cameraMatrix contains valid initial values of
     * fx, fy, cx, cy that are optimized further. Otherwise, (cx, cy) is initially set to the image
     * center ( imageSize is used), and focal distances are computed in a least-squares fashion.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_RECOMPUTE_EXTRINSIC  Extrinsic will be recomputed after each iteration
     * of intrinsic optimization.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_CHECK_COND  The functions will check validity of condition number.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_SKEW  Skew coefficient (alpha) is set to zero and stay zero.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_K1,..., REF: cv::CALIB_FIX_K4 Selected distortion coefficients
     * are set to zeros and stay zero.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_PRINCIPAL_POINT  The principal point is not changed during the global
     * optimization. It stays at the center or at a different location specified when REF: cv::CALIB_USE_INTRINSIC_GUESS is set too.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_FOCAL_LENGTH The focal length is not changed during the global
     * optimization. It is the \(max(width,height)/\pi\) or the provided \(f_x\), \(f_y\) when REF: cv::CALIB_USE_INTRINSIC_GUESS is set too.
     *   </li>
     * </ul>
     * @return automatically generated
     */
    public static double fisheye_calibrate(List<Mat> objectPoints, List<Mat> imagePoints, Size image_size, Mat K, Mat D, List<Mat> rvecs, List<Mat> tvecs) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints_mat = Converters.vector_Mat_to_Mat(imagePoints);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = fisheye_calibrate_2(objectPoints_mat.nativeObj, imagePoints_mat.nativeObj, image_size.width, image_size.height, K.nativeObj, D.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }


    //
    // C++:  double cv::fisheye::stereoCalibrate(vector_Mat objectPoints, vector_Mat imagePoints1, vector_Mat imagePoints2, Mat& K1, Mat& D1, Mat& K2, Mat& D2, Size imageSize, Mat& R, Mat& T, vector_Mat& rvecs, vector_Mat& tvecs, int flags = CALIB_FIX_INTRINSIC, TermCriteria criteria = TermCriteria(TermCriteria::COUNT + TermCriteria::EPS, 100, DBL_EPSILON))
    //

    /**
     * Performs stereo calibration
     *
     * @param objectPoints Vector of vectors of the calibration pattern points.
     * @param imagePoints1 Vector of vectors of the projections of the calibration pattern points,
     * observed by the first camera.
     * @param imagePoints2 Vector of vectors of the projections of the calibration pattern points,
     * observed by the second camera.
     * @param K1 Input/output first camera intrinsic matrix:
     * \(\vecthreethree{f_x^{(j)}}{0}{c_x^{(j)}}{0}{f_y^{(j)}}{c_y^{(j)}}{0}{0}{1}\) , \(j = 0,\, 1\) . If
     * any of REF: cv::CALIB_USE_INTRINSIC_GUESS , REF: cv::CALIB_FIX_INTRINSIC are specified,
     * some or all of the matrix components must be initialized.
     * @param D1 Input/output vector of distortion coefficients \(\distcoeffsfisheye\) of 4 elements.
     * @param K2 Input/output second camera intrinsic matrix. The parameter is similar to K1 .
     * @param D2 Input/output lens distortion coefficients for the second camera. The parameter is
     * similar to D1 .
     * @param imageSize Size of the image used only to initialize camera intrinsic matrix.
     * @param R Output rotation matrix between the 1st and the 2nd camera coordinate systems.
     * @param T Output translation vector between the coordinate systems of the cameras.
     * @param rvecs Output vector of rotation vectors ( REF: Rodrigues ) estimated for each pattern view in the
     * coordinate system of the first camera of the stereo pair (e.g. std::vector&lt;cv::Mat&gt;). More in detail, each
     * i-th rotation vector together with the corresponding i-th translation vector (see the next output parameter
     * description) brings the calibration pattern from the object coordinate space (in which object points are
     * specified) to the camera coordinate space of the first camera of the stereo pair. In more technical terms,
     * the tuple of the i-th rotation and translation vector performs a change of basis from object coordinate space
     * to camera coordinate space of the first camera of the stereo pair.
     * @param tvecs Output vector of translation vectors estimated for each pattern view, see parameter description
     * of previous output parameter ( rvecs ).
     * @param flags Different flags that may be zero or a combination of the following values:
     * <ul>
     *   <li>
     *    REF: cv::CALIB_FIX_INTRINSIC  Fix K1, K2? and D1, D2? so that only R, T matrices
     * are estimated.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_USE_INTRINSIC_GUESS  K1, K2 contains valid initial values of
     * fx, fy, cx, cy that are optimized further. Otherwise, (cx, cy) is initially set to the image
     * center (imageSize is used), and focal distances are computed in a least-squares fashion.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_RECOMPUTE_EXTRINSIC  Extrinsic will be recomputed after each iteration
     * of intrinsic optimization.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_CHECK_COND  The functions will check validity of condition number.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_SKEW  Skew coefficient (alpha) is set to zero and stay zero.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_K1,..., REF: cv::CALIB_FIX_K4 Selected distortion coefficients are set to zeros and stay
     * zero.
     *   </li>
     * </ul>
     * @param criteria Termination criteria for the iterative optimization algorithm.
     * @return automatically generated
     */
    public static double fisheye_stereoCalibrate(List<Mat> objectPoints, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat K1, Mat D1, Mat K2, Mat D2, Size imageSize, Mat R, Mat T, List<Mat> rvecs, List<Mat> tvecs, int flags, TermCriteria criteria) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = fisheye_stereoCalibrate_0(objectPoints_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, K1.nativeObj, D1.nativeObj, K2.nativeObj, D2.nativeObj, imageSize.width, imageSize.height, R.nativeObj, T.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, flags, criteria.type, criteria.maxCount, criteria.epsilon);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }

    /**
     * Performs stereo calibration
     *
     * @param objectPoints Vector of vectors of the calibration pattern points.
     * @param imagePoints1 Vector of vectors of the projections of the calibration pattern points,
     * observed by the first camera.
     * @param imagePoints2 Vector of vectors of the projections of the calibration pattern points,
     * observed by the second camera.
     * @param K1 Input/output first camera intrinsic matrix:
     * \(\vecthreethree{f_x^{(j)}}{0}{c_x^{(j)}}{0}{f_y^{(j)}}{c_y^{(j)}}{0}{0}{1}\) , \(j = 0,\, 1\) . If
     * any of REF: cv::CALIB_USE_INTRINSIC_GUESS , REF: cv::CALIB_FIX_INTRINSIC are specified,
     * some or all of the matrix components must be initialized.
     * @param D1 Input/output vector of distortion coefficients \(\distcoeffsfisheye\) of 4 elements.
     * @param K2 Input/output second camera intrinsic matrix. The parameter is similar to K1 .
     * @param D2 Input/output lens distortion coefficients for the second camera. The parameter is
     * similar to D1 .
     * @param imageSize Size of the image used only to initialize camera intrinsic matrix.
     * @param R Output rotation matrix between the 1st and the 2nd camera coordinate systems.
     * @param T Output translation vector between the coordinate systems of the cameras.
     * @param rvecs Output vector of rotation vectors ( REF: Rodrigues ) estimated for each pattern view in the
     * coordinate system of the first camera of the stereo pair (e.g. std::vector&lt;cv::Mat&gt;). More in detail, each
     * i-th rotation vector together with the corresponding i-th translation vector (see the next output parameter
     * description) brings the calibration pattern from the object coordinate space (in which object points are
     * specified) to the camera coordinate space of the first camera of the stereo pair. In more technical terms,
     * the tuple of the i-th rotation and translation vector performs a change of basis from object coordinate space
     * to camera coordinate space of the first camera of the stereo pair.
     * @param tvecs Output vector of translation vectors estimated for each pattern view, see parameter description
     * of previous output parameter ( rvecs ).
     * @param flags Different flags that may be zero or a combination of the following values:
     * <ul>
     *   <li>
     *    REF: cv::CALIB_FIX_INTRINSIC  Fix K1, K2? and D1, D2? so that only R, T matrices
     * are estimated.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_USE_INTRINSIC_GUESS  K1, K2 contains valid initial values of
     * fx, fy, cx, cy that are optimized further. Otherwise, (cx, cy) is initially set to the image
     * center (imageSize is used), and focal distances are computed in a least-squares fashion.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_RECOMPUTE_EXTRINSIC  Extrinsic will be recomputed after each iteration
     * of intrinsic optimization.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_CHECK_COND  The functions will check validity of condition number.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_SKEW  Skew coefficient (alpha) is set to zero and stay zero.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_K1,..., REF: cv::CALIB_FIX_K4 Selected distortion coefficients are set to zeros and stay
     * zero.
     *   </li>
     * </ul>
     * @return automatically generated
     */
    public static double fisheye_stereoCalibrate(List<Mat> objectPoints, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat K1, Mat D1, Mat K2, Mat D2, Size imageSize, Mat R, Mat T, List<Mat> rvecs, List<Mat> tvecs, int flags) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = fisheye_stereoCalibrate_1(objectPoints_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, K1.nativeObj, D1.nativeObj, K2.nativeObj, D2.nativeObj, imageSize.width, imageSize.height, R.nativeObj, T.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj, flags);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }

    /**
     * Performs stereo calibration
     *
     * @param objectPoints Vector of vectors of the calibration pattern points.
     * @param imagePoints1 Vector of vectors of the projections of the calibration pattern points,
     * observed by the first camera.
     * @param imagePoints2 Vector of vectors of the projections of the calibration pattern points,
     * observed by the second camera.
     * @param K1 Input/output first camera intrinsic matrix:
     * \(\vecthreethree{f_x^{(j)}}{0}{c_x^{(j)}}{0}{f_y^{(j)}}{c_y^{(j)}}{0}{0}{1}\) , \(j = 0,\, 1\) . If
     * any of REF: cv::CALIB_USE_INTRINSIC_GUESS , REF: cv::CALIB_FIX_INTRINSIC are specified,
     * some or all of the matrix components must be initialized.
     * @param D1 Input/output vector of distortion coefficients \(\distcoeffsfisheye\) of 4 elements.
     * @param K2 Input/output second camera intrinsic matrix. The parameter is similar to K1 .
     * @param D2 Input/output lens distortion coefficients for the second camera. The parameter is
     * similar to D1 .
     * @param imageSize Size of the image used only to initialize camera intrinsic matrix.
     * @param R Output rotation matrix between the 1st and the 2nd camera coordinate systems.
     * @param T Output translation vector between the coordinate systems of the cameras.
     * @param rvecs Output vector of rotation vectors ( REF: Rodrigues ) estimated for each pattern view in the
     * coordinate system of the first camera of the stereo pair (e.g. std::vector&lt;cv::Mat&gt;). More in detail, each
     * i-th rotation vector together with the corresponding i-th translation vector (see the next output parameter
     * description) brings the calibration pattern from the object coordinate space (in which object points are
     * specified) to the camera coordinate space of the first camera of the stereo pair. In more technical terms,
     * the tuple of the i-th rotation and translation vector performs a change of basis from object coordinate space
     * to camera coordinate space of the first camera of the stereo pair.
     * @param tvecs Output vector of translation vectors estimated for each pattern view, see parameter description
     * of previous output parameter ( rvecs ).
     * <ul>
     *   <li>
     *    REF: cv::CALIB_FIX_INTRINSIC  Fix K1, K2? and D1, D2? so that only R, T matrices
     * are estimated.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_USE_INTRINSIC_GUESS  K1, K2 contains valid initial values of
     * fx, fy, cx, cy that are optimized further. Otherwise, (cx, cy) is initially set to the image
     * center (imageSize is used), and focal distances are computed in a least-squares fashion.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_RECOMPUTE_EXTRINSIC  Extrinsic will be recomputed after each iteration
     * of intrinsic optimization.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_CHECK_COND  The functions will check validity of condition number.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_SKEW  Skew coefficient (alpha) is set to zero and stay zero.
     *   </li>
     *   <li>
     *    REF: cv::CALIB_FIX_K1,..., REF: cv::CALIB_FIX_K4 Selected distortion coefficients are set to zeros and stay
     * zero.
     *   </li>
     * </ul>
     * @return automatically generated
     */
    public static double fisheye_stereoCalibrate(List<Mat> objectPoints, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat K1, Mat D1, Mat K2, Mat D2, Size imageSize, Mat R, Mat T, List<Mat> rvecs, List<Mat> tvecs) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        Mat rvecs_mat = new Mat();
        Mat tvecs_mat = new Mat();
        double retVal = fisheye_stereoCalibrate_2(objectPoints_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, K1.nativeObj, D1.nativeObj, K2.nativeObj, D2.nativeObj, imageSize.width, imageSize.height, R.nativeObj, T.nativeObj, rvecs_mat.nativeObj, tvecs_mat.nativeObj);
        Converters.Mat_to_vector_Mat(rvecs_mat, rvecs);
        rvecs_mat.release();
        Converters.Mat_to_vector_Mat(tvecs_mat, tvecs);
        tvecs_mat.release();
        return retVal;
    }


    //
    // C++:  double cv::fisheye::stereoCalibrate(vector_Mat objectPoints, vector_Mat imagePoints1, vector_Mat imagePoints2, Mat& K1, Mat& D1, Mat& K2, Mat& D2, Size imageSize, Mat& R, Mat& T, int flags = CALIB_FIX_INTRINSIC, TermCriteria criteria = TermCriteria(TermCriteria::COUNT + TermCriteria::EPS, 100, DBL_EPSILON))
    //

    public static double fisheye_stereoCalibrate(List<Mat> objectPoints, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat K1, Mat D1, Mat K2, Mat D2, Size imageSize, Mat R, Mat T, int flags, TermCriteria criteria) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        return fisheye_stereoCalibrate_3(objectPoints_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, K1.nativeObj, D1.nativeObj, K2.nativeObj, D2.nativeObj, imageSize.width, imageSize.height, R.nativeObj, T.nativeObj, flags, criteria.type, criteria.maxCount, criteria.epsilon);
    }

    public static double fisheye_stereoCalibrate(List<Mat> objectPoints, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat K1, Mat D1, Mat K2, Mat D2, Size imageSize, Mat R, Mat T, int flags) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        return fisheye_stereoCalibrate_4(objectPoints_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, K1.nativeObj, D1.nativeObj, K2.nativeObj, D2.nativeObj, imageSize.width, imageSize.height, R.nativeObj, T.nativeObj, flags);
    }

    public static double fisheye_stereoCalibrate(List<Mat> objectPoints, List<Mat> imagePoints1, List<Mat> imagePoints2, Mat K1, Mat D1, Mat K2, Mat D2, Size imageSize, Mat R, Mat T) {
        Mat objectPoints_mat = Converters.vector_Mat_to_Mat(objectPoints);
        Mat imagePoints1_mat = Converters.vector_Mat_to_Mat(imagePoints1);
        Mat imagePoints2_mat = Converters.vector_Mat_to_Mat(imagePoints2);
        return fisheye_stereoCalibrate_5(objectPoints_mat.nativeObj, imagePoints1_mat.nativeObj, imagePoints2_mat.nativeObj, K1.nativeObj, D1.nativeObj, K2.nativeObj, D2.nativeObj, imageSize.width, imageSize.height, R.nativeObj, T.nativeObj);
    }




    // C++:  Mat cv::initCameraMatrix2D(vector_vector_Point3f objectPoints, vector_vector_Point2f imagePoints, Size imageSize, double aspectRatio = 1.0)
    private static native long initCameraMatrix2D_0(long objectPoints_mat_nativeObj, long imagePoints_mat_nativeObj, double imageSize_width, double imageSize_height, double aspectRatio);
    private static native long initCameraMatrix2D_1(long objectPoints_mat_nativeObj, long imagePoints_mat_nativeObj, double imageSize_width, double imageSize_height);

    // C++:  double cv::calibrateCamera(vector_Mat objectPoints, vector_Mat imagePoints, Size imageSize, Mat& cameraMatrix, Mat& distCoeffs, vector_Mat& rvecs, vector_Mat& tvecs, Mat& stdDeviationsIntrinsics, Mat& stdDeviationsExtrinsics, Mat& perViewErrors, int flags = 0, TermCriteria criteria = TermCriteria( TermCriteria::COUNT + TermCriteria::EPS, 500, DBL_EPSILON))
    private static native double calibrateCameraExtended_0(long objectPoints_mat_nativeObj, long imagePoints_mat_nativeObj, double imageSize_width, double imageSize_height, long cameraMatrix_nativeObj, long distCoeffs_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, long stdDeviationsIntrinsics_nativeObj, long stdDeviationsExtrinsics_nativeObj, long perViewErrors_nativeObj, int flags, int criteria_type, int criteria_maxCount, double criteria_epsilon);
    private static native double calibrateCameraExtended_1(long objectPoints_mat_nativeObj, long imagePoints_mat_nativeObj, double imageSize_width, double imageSize_height, long cameraMatrix_nativeObj, long distCoeffs_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, long stdDeviationsIntrinsics_nativeObj, long stdDeviationsExtrinsics_nativeObj, long perViewErrors_nativeObj, int flags);
    private static native double calibrateCameraExtended_2(long objectPoints_mat_nativeObj, long imagePoints_mat_nativeObj, double imageSize_width, double imageSize_height, long cameraMatrix_nativeObj, long distCoeffs_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, long stdDeviationsIntrinsics_nativeObj, long stdDeviationsExtrinsics_nativeObj, long perViewErrors_nativeObj);

    // C++:  double cv::calibrateCamera(vector_Mat objectPoints, vector_Mat imagePoints, Size imageSize, Mat& cameraMatrix, Mat& distCoeffs, vector_Mat& rvecs, vector_Mat& tvecs, int flags = 0, TermCriteria criteria = TermCriteria( TermCriteria::COUNT + TermCriteria::EPS, 500, DBL_EPSILON))
    private static native double calibrateCamera_0(long objectPoints_mat_nativeObj, long imagePoints_mat_nativeObj, double imageSize_width, double imageSize_height, long cameraMatrix_nativeObj, long distCoeffs_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, int flags, int criteria_type, int criteria_maxCount, double criteria_epsilon);
    private static native double calibrateCamera_1(long objectPoints_mat_nativeObj, long imagePoints_mat_nativeObj, double imageSize_width, double imageSize_height, long cameraMatrix_nativeObj, long distCoeffs_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, int flags);
    private static native double calibrateCamera_2(long objectPoints_mat_nativeObj, long imagePoints_mat_nativeObj, double imageSize_width, double imageSize_height, long cameraMatrix_nativeObj, long distCoeffs_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj);

    // C++:  double cv::calibrateCameraRO(vector_Mat objectPoints, vector_Mat imagePoints, Size imageSize, int iFixedPoint, Mat& cameraMatrix, Mat& distCoeffs, vector_Mat& rvecs, vector_Mat& tvecs, Mat& newObjPoints, Mat& stdDeviationsIntrinsics, Mat& stdDeviationsExtrinsics, Mat& stdDeviationsObjPoints, Mat& perViewErrors, int flags = 0, TermCriteria criteria = TermCriteria( TermCriteria::COUNT + TermCriteria::EPS, 500, DBL_EPSILON))
    private static native double calibrateCameraROExtended_0(long objectPoints_mat_nativeObj, long imagePoints_mat_nativeObj, double imageSize_width, double imageSize_height, int iFixedPoint, long cameraMatrix_nativeObj, long distCoeffs_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, long newObjPoints_nativeObj, long stdDeviationsIntrinsics_nativeObj, long stdDeviationsExtrinsics_nativeObj, long stdDeviationsObjPoints_nativeObj, long perViewErrors_nativeObj, int flags, int criteria_type, int criteria_maxCount, double criteria_epsilon);
    private static native double calibrateCameraROExtended_1(long objectPoints_mat_nativeObj, long imagePoints_mat_nativeObj, double imageSize_width, double imageSize_height, int iFixedPoint, long cameraMatrix_nativeObj, long distCoeffs_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, long newObjPoints_nativeObj, long stdDeviationsIntrinsics_nativeObj, long stdDeviationsExtrinsics_nativeObj, long stdDeviationsObjPoints_nativeObj, long perViewErrors_nativeObj, int flags);
    private static native double calibrateCameraROExtended_2(long objectPoints_mat_nativeObj, long imagePoints_mat_nativeObj, double imageSize_width, double imageSize_height, int iFixedPoint, long cameraMatrix_nativeObj, long distCoeffs_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, long newObjPoints_nativeObj, long stdDeviationsIntrinsics_nativeObj, long stdDeviationsExtrinsics_nativeObj, long stdDeviationsObjPoints_nativeObj, long perViewErrors_nativeObj);

    // C++:  double cv::calibrateCameraRO(vector_Mat objectPoints, vector_Mat imagePoints, Size imageSize, int iFixedPoint, Mat& cameraMatrix, Mat& distCoeffs, vector_Mat& rvecs, vector_Mat& tvecs, Mat& newObjPoints, int flags = 0, TermCriteria criteria = TermCriteria( TermCriteria::COUNT + TermCriteria::EPS, 500, DBL_EPSILON))
    private static native double calibrateCameraRO_0(long objectPoints_mat_nativeObj, long imagePoints_mat_nativeObj, double imageSize_width, double imageSize_height, int iFixedPoint, long cameraMatrix_nativeObj, long distCoeffs_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, long newObjPoints_nativeObj, int flags, int criteria_type, int criteria_maxCount, double criteria_epsilon);
    private static native double calibrateCameraRO_1(long objectPoints_mat_nativeObj, long imagePoints_mat_nativeObj, double imageSize_width, double imageSize_height, int iFixedPoint, long cameraMatrix_nativeObj, long distCoeffs_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, long newObjPoints_nativeObj, int flags);
    private static native double calibrateCameraRO_2(long objectPoints_mat_nativeObj, long imagePoints_mat_nativeObj, double imageSize_width, double imageSize_height, int iFixedPoint, long cameraMatrix_nativeObj, long distCoeffs_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, long newObjPoints_nativeObj);

    // C++:  double cv::stereoCalibrate(vector_Mat objectPoints, vector_Mat imagePoints1, vector_Mat imagePoints2, Mat& cameraMatrix1, Mat& distCoeffs1, Mat& cameraMatrix2, Mat& distCoeffs2, Size imageSize, Mat& R, Mat& T, Mat& E, Mat& F, vector_Mat& rvecs, vector_Mat& tvecs, Mat& perViewErrors, int flags = CALIB_FIX_INTRINSIC, TermCriteria criteria = TermCriteria(TermCriteria::COUNT+TermCriteria::EPS, 100, 1e-6))
    private static native double stereoCalibrateExtended_0(long objectPoints_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long cameraMatrix1_nativeObj, long distCoeffs1_nativeObj, long cameraMatrix2_nativeObj, long distCoeffs2_nativeObj, double imageSize_width, double imageSize_height, long R_nativeObj, long T_nativeObj, long E_nativeObj, long F_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, long perViewErrors_nativeObj, int flags, int criteria_type, int criteria_maxCount, double criteria_epsilon);
    private static native double stereoCalibrateExtended_1(long objectPoints_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long cameraMatrix1_nativeObj, long distCoeffs1_nativeObj, long cameraMatrix2_nativeObj, long distCoeffs2_nativeObj, double imageSize_width, double imageSize_height, long R_nativeObj, long T_nativeObj, long E_nativeObj, long F_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, long perViewErrors_nativeObj, int flags);
    private static native double stereoCalibrateExtended_2(long objectPoints_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long cameraMatrix1_nativeObj, long distCoeffs1_nativeObj, long cameraMatrix2_nativeObj, long distCoeffs2_nativeObj, double imageSize_width, double imageSize_height, long R_nativeObj, long T_nativeObj, long E_nativeObj, long F_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, long perViewErrors_nativeObj);

    // C++:  double cv::stereoCalibrate(vector_Mat objectPoints, vector_Mat imagePoints1, vector_Mat imagePoints2, Mat& cameraMatrix1, Mat& distCoeffs1, Mat& cameraMatrix2, Mat& distCoeffs2, Size imageSize, Mat& R, Mat& T, Mat& E, Mat& F, int flags = CALIB_FIX_INTRINSIC, TermCriteria criteria = TermCriteria(TermCriteria::COUNT+TermCriteria::EPS, 100, 1e-6))
    private static native double stereoCalibrate_0(long objectPoints_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long cameraMatrix1_nativeObj, long distCoeffs1_nativeObj, long cameraMatrix2_nativeObj, long distCoeffs2_nativeObj, double imageSize_width, double imageSize_height, long R_nativeObj, long T_nativeObj, long E_nativeObj, long F_nativeObj, int flags, int criteria_type, int criteria_maxCount, double criteria_epsilon);
    private static native double stereoCalibrate_1(long objectPoints_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long cameraMatrix1_nativeObj, long distCoeffs1_nativeObj, long cameraMatrix2_nativeObj, long distCoeffs2_nativeObj, double imageSize_width, double imageSize_height, long R_nativeObj, long T_nativeObj, long E_nativeObj, long F_nativeObj, int flags);
    private static native double stereoCalibrate_2(long objectPoints_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long cameraMatrix1_nativeObj, long distCoeffs1_nativeObj, long cameraMatrix2_nativeObj, long distCoeffs2_nativeObj, double imageSize_width, double imageSize_height, long R_nativeObj, long T_nativeObj, long E_nativeObj, long F_nativeObj);

    // C++:  double cv::stereoCalibrate(vector_Mat objectPoints, vector_Mat imagePoints1, vector_Mat imagePoints2, Mat& cameraMatrix1, Mat& distCoeffs1, Mat& cameraMatrix2, Mat& distCoeffs2, Size imageSize, Mat& R, Mat& T, Mat& E, Mat& F, Mat& perViewErrors, int flags = CALIB_FIX_INTRINSIC, TermCriteria criteria = TermCriteria(TermCriteria::COUNT+TermCriteria::EPS, 30, 1e-6))
    private static native double stereoCalibrate_3(long objectPoints_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long cameraMatrix1_nativeObj, long distCoeffs1_nativeObj, long cameraMatrix2_nativeObj, long distCoeffs2_nativeObj, double imageSize_width, double imageSize_height, long R_nativeObj, long T_nativeObj, long E_nativeObj, long F_nativeObj, long perViewErrors_nativeObj, int flags, int criteria_type, int criteria_maxCount, double criteria_epsilon);
    private static native double stereoCalibrate_4(long objectPoints_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long cameraMatrix1_nativeObj, long distCoeffs1_nativeObj, long cameraMatrix2_nativeObj, long distCoeffs2_nativeObj, double imageSize_width, double imageSize_height, long R_nativeObj, long T_nativeObj, long E_nativeObj, long F_nativeObj, long perViewErrors_nativeObj, int flags);
    private static native double stereoCalibrate_5(long objectPoints_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long cameraMatrix1_nativeObj, long distCoeffs1_nativeObj, long cameraMatrix2_nativeObj, long distCoeffs2_nativeObj, double imageSize_width, double imageSize_height, long R_nativeObj, long T_nativeObj, long E_nativeObj, long F_nativeObj, long perViewErrors_nativeObj);

    // C++:  double cv::registerCameras(vector_Mat objectPoints1, vector_Mat objectPoints2, vector_Mat imagePoints1, vector_Mat imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, CameraModel cameraModel1, Mat cameraMatrix2, Mat distCoeffs2, CameraModel cameraModel2, Mat& R, Mat& T, Mat& E, Mat& F, vector_Mat& rvecs, vector_Mat& tvecs, Mat& perViewErrors, int flags = 0, TermCriteria criteria = TermCriteria(TermCriteria::COUNT+TermCriteria::EPS, 100, 1e-6))
    private static native double registerCamerasExtended_0(long objectPoints1_mat_nativeObj, long objectPoints2_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long cameraMatrix1_nativeObj, long distCoeffs1_nativeObj, int cameraModel1, long cameraMatrix2_nativeObj, long distCoeffs2_nativeObj, int cameraModel2, long R_nativeObj, long T_nativeObj, long E_nativeObj, long F_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, long perViewErrors_nativeObj, int flags, int criteria_type, int criteria_maxCount, double criteria_epsilon);
    private static native double registerCamerasExtended_1(long objectPoints1_mat_nativeObj, long objectPoints2_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long cameraMatrix1_nativeObj, long distCoeffs1_nativeObj, int cameraModel1, long cameraMatrix2_nativeObj, long distCoeffs2_nativeObj, int cameraModel2, long R_nativeObj, long T_nativeObj, long E_nativeObj, long F_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, long perViewErrors_nativeObj, int flags);
    private static native double registerCamerasExtended_2(long objectPoints1_mat_nativeObj, long objectPoints2_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long cameraMatrix1_nativeObj, long distCoeffs1_nativeObj, int cameraModel1, long cameraMatrix2_nativeObj, long distCoeffs2_nativeObj, int cameraModel2, long R_nativeObj, long T_nativeObj, long E_nativeObj, long F_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, long perViewErrors_nativeObj);

    // C++:  double cv::registerCameras(vector_Mat objectPoints1, vector_Mat objectPoints2, vector_Mat imagePoints1, vector_Mat imagePoints2, Mat cameraMatrix1, Mat distCoeffs1, CameraModel cameraModel1, Mat cameraMatrix2, Mat distCoeffs2, CameraModel cameraModel2, Mat& R, Mat& T, Mat& E, Mat& F, Mat& perViewErrors, int flags = 0, TermCriteria criteria = TermCriteria(TermCriteria::COUNT+TermCriteria::EPS, 100, 1e-6))
    private static native double registerCameras_0(long objectPoints1_mat_nativeObj, long objectPoints2_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long cameraMatrix1_nativeObj, long distCoeffs1_nativeObj, int cameraModel1, long cameraMatrix2_nativeObj, long distCoeffs2_nativeObj, int cameraModel2, long R_nativeObj, long T_nativeObj, long E_nativeObj, long F_nativeObj, long perViewErrors_nativeObj, int flags, int criteria_type, int criteria_maxCount, double criteria_epsilon);
    private static native double registerCameras_1(long objectPoints1_mat_nativeObj, long objectPoints2_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long cameraMatrix1_nativeObj, long distCoeffs1_nativeObj, int cameraModel1, long cameraMatrix2_nativeObj, long distCoeffs2_nativeObj, int cameraModel2, long R_nativeObj, long T_nativeObj, long E_nativeObj, long F_nativeObj, long perViewErrors_nativeObj, int flags);
    private static native double registerCameras_2(long objectPoints1_mat_nativeObj, long objectPoints2_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long cameraMatrix1_nativeObj, long distCoeffs1_nativeObj, int cameraModel1, long cameraMatrix2_nativeObj, long distCoeffs2_nativeObj, int cameraModel2, long R_nativeObj, long T_nativeObj, long E_nativeObj, long F_nativeObj, long perViewErrors_nativeObj);

    // C++:  double cv::fisheye::calibrate(vector_Mat objectPoints, vector_Mat imagePoints, Size image_size, Mat& K, Mat& D, vector_Mat& rvecs, vector_Mat& tvecs, int flags = 0, TermCriteria criteria = TermCriteria(TermCriteria::COUNT + TermCriteria::EPS, 100, DBL_EPSILON))
    private static native double fisheye_calibrate_0(long objectPoints_mat_nativeObj, long imagePoints_mat_nativeObj, double image_size_width, double image_size_height, long K_nativeObj, long D_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, int flags, int criteria_type, int criteria_maxCount, double criteria_epsilon);
    private static native double fisheye_calibrate_1(long objectPoints_mat_nativeObj, long imagePoints_mat_nativeObj, double image_size_width, double image_size_height, long K_nativeObj, long D_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, int flags);
    private static native double fisheye_calibrate_2(long objectPoints_mat_nativeObj, long imagePoints_mat_nativeObj, double image_size_width, double image_size_height, long K_nativeObj, long D_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj);

    // C++:  double cv::fisheye::stereoCalibrate(vector_Mat objectPoints, vector_Mat imagePoints1, vector_Mat imagePoints2, Mat& K1, Mat& D1, Mat& K2, Mat& D2, Size imageSize, Mat& R, Mat& T, vector_Mat& rvecs, vector_Mat& tvecs, int flags = CALIB_FIX_INTRINSIC, TermCriteria criteria = TermCriteria(TermCriteria::COUNT + TermCriteria::EPS, 100, DBL_EPSILON))
    private static native double fisheye_stereoCalibrate_0(long objectPoints_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long K1_nativeObj, long D1_nativeObj, long K2_nativeObj, long D2_nativeObj, double imageSize_width, double imageSize_height, long R_nativeObj, long T_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, int flags, int criteria_type, int criteria_maxCount, double criteria_epsilon);
    private static native double fisheye_stereoCalibrate_1(long objectPoints_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long K1_nativeObj, long D1_nativeObj, long K2_nativeObj, long D2_nativeObj, double imageSize_width, double imageSize_height, long R_nativeObj, long T_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj, int flags);
    private static native double fisheye_stereoCalibrate_2(long objectPoints_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long K1_nativeObj, long D1_nativeObj, long K2_nativeObj, long D2_nativeObj, double imageSize_width, double imageSize_height, long R_nativeObj, long T_nativeObj, long rvecs_mat_nativeObj, long tvecs_mat_nativeObj);

    // C++:  double cv::fisheye::stereoCalibrate(vector_Mat objectPoints, vector_Mat imagePoints1, vector_Mat imagePoints2, Mat& K1, Mat& D1, Mat& K2, Mat& D2, Size imageSize, Mat& R, Mat& T, int flags = CALIB_FIX_INTRINSIC, TermCriteria criteria = TermCriteria(TermCriteria::COUNT + TermCriteria::EPS, 100, DBL_EPSILON))
    private static native double fisheye_stereoCalibrate_3(long objectPoints_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long K1_nativeObj, long D1_nativeObj, long K2_nativeObj, long D2_nativeObj, double imageSize_width, double imageSize_height, long R_nativeObj, long T_nativeObj, int flags, int criteria_type, int criteria_maxCount, double criteria_epsilon);
    private static native double fisheye_stereoCalibrate_4(long objectPoints_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long K1_nativeObj, long D1_nativeObj, long K2_nativeObj, long D2_nativeObj, double imageSize_width, double imageSize_height, long R_nativeObj, long T_nativeObj, int flags);
    private static native double fisheye_stereoCalibrate_5(long objectPoints_mat_nativeObj, long imagePoints1_mat_nativeObj, long imagePoints2_mat_nativeObj, long K1_nativeObj, long D1_nativeObj, long K2_nativeObj, long D2_nativeObj, double imageSize_width, double imageSize_height, long R_nativeObj, long T_nativeObj);

}
