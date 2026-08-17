//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.photo;

import org.opencv.core.Mat;

// C++: class ColorCorrectionModel
/**
 * Core class of ccm model
 *
 * Produce a ColorCorrectionModel instance for inference
 */
public class ColorCorrectionModel {

    protected final long nativeObj;
    protected ColorCorrectionModel(long addr) {
      nativeObj = addr;

    }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static ColorCorrectionModel __fromPtr__(long addr) { return new ColorCorrectionModel(addr); }

    //
    // C++:   cv::ccm::ColorCorrectionModel::ColorCorrectionModel()
    //

    public ColorCorrectionModel() {
        nativeObj = ColorCorrectionModel_0();
    }


    //
    // C++:   cv::ccm::ColorCorrectionModel::ColorCorrectionModel(Mat src, int constColor)
    //

    /**
     * Color Correction Model
     *
     *         Supported list of color cards:
     * <ul>
     *   <li>
     *          REF: COLORCHECKER_MACBETH, the Macbeth ColorChecker
     *   </li>
     *   <li>
     *          REF: COLORCHECKER_VINYL, the DKK ColorChecker
     *   </li>
     *   <li>
     *          REF: COLORCHECKER_DIGITAL_SG, the DigitalSG ColorChecker with 140 squares
     *   </li>
     * </ul>
     *
     *         @param src detected colors of ColorChecker patches;
     *                     the color type is RGB not BGR, and the color values are in [0, 1];
     *         @param constColor the Built-in color card
     */
    public ColorCorrectionModel(Mat src, int constColor) {
        nativeObj = ColorCorrectionModel_1(src.nativeObj, constColor);
    }


    //
    // C++:   cv::ccm::ColorCorrectionModel::ColorCorrectionModel(Mat src, Mat colors, ColorSpace refColorSpace)
    //

    // Unknown type 'ColorSpace' (I), skipping the function


    //
    // C++:   cv::ccm::ColorCorrectionModel::ColorCorrectionModel(Mat src, Mat colors, ColorSpace refColorSpace, Mat coloredPatchesMask)
    //

    // Unknown type 'ColorSpace' (I), skipping the function


    //
    // C++:  void cv::ccm::ColorCorrectionModel::setColorSpace(ColorSpace cs)
    //

    // Unknown type 'ColorSpace' (I), skipping the function


    //
    // C++:  void cv::ccm::ColorCorrectionModel::setCcmType(CcmType ccmType)
    //

    // Unknown type 'CcmType' (I), skipping the function


    //
    // C++:  void cv::ccm::ColorCorrectionModel::setDistance(DistanceType distance)
    //

    // Unknown type 'DistanceType' (I), skipping the function


    //
    // C++:  void cv::ccm::ColorCorrectionModel::setLinearization(LinearizationType linearizationType)
    //

    // Unknown type 'LinearizationType' (I), skipping the function


    //
    // C++:  void cv::ccm::ColorCorrectionModel::setLinearizationGamma(double gamma)
    //

    /**
     * set Gamma
     *
     *     <b>Note:</b> only valid when linear is set to "gamma";
     *
     *     @param gamma the gamma value of gamma correction;
     *                  default: 2.2;
     */
    public void setLinearizationGamma(double gamma) {
        setLinearizationGamma_0(nativeObj, gamma);
    }


    //
    // C++:  void cv::ccm::ColorCorrectionModel::setLinearizationDegree(int deg)
    //

    /**
     * set degree
     *         <b>Note:</b> only valid when linear is set to
     * <ul>
     *   <li>
     *          REF: LINEARIZATION_COLORPOLYFIT
     *   </li>
     *   <li>
     *          REF: LINEARIZATION_GRAYPOLYFIT
     *   </li>
     *   <li>
     *          REF: LINEARIZATION_COLORLOGPOLYFIT
     *   </li>
     *   <li>
     *          REF: LINEARIZATION_GRAYLOGPOLYFIT
     *   </li>
     * </ul>
     *
     *         @param deg the degree of linearization polynomial
     *             default: 3
     */
    public void setLinearizationDegree(int deg) {
        setLinearizationDegree_0(nativeObj, deg);
    }


    //
    // C++:  void cv::ccm::ColorCorrectionModel::setSaturatedThreshold(double lower, double upper)
    //

    /**
     * set SaturatedThreshold.
     *                 The colors in the closed interval [lower, upper] are reserved to participate
     *                 in the calculation of the loss function and initialization parameters
     *         @param lower the lower threshold to determine saturation;
     *                 default: 0;
     *         @param upper the upper threshold to determine saturation;
     *                 default: 0
     */
    public void setSaturatedThreshold(double lower, double upper) {
        setSaturatedThreshold_0(nativeObj, lower, upper);
    }


    //
    // C++:  void cv::ccm::ColorCorrectionModel::setWeightsList(Mat weightsList)
    //

    /**
     * set WeightsList
     *     @param weightsList the list of weight of each color;
     *                         default: empty array
     */
    public void setWeightsList(Mat weightsList) {
        setWeightsList_0(nativeObj, weightsList.nativeObj);
    }


    //
    // C++:  void cv::ccm::ColorCorrectionModel::setWeightCoeff(double weightsCoeff)
    //

    /**
     * set WeightCoeff
     *     @param weightsCoeff the exponent number of L* component of the reference color in CIE Lab color space;
     *                          default: 0
     */
    public void setWeightCoeff(double weightsCoeff) {
        setWeightCoeff_0(nativeObj, weightsCoeff);
    }


    //
    // C++:  void cv::ccm::ColorCorrectionModel::setInitialMethod(InitialMethodType initialMethodType)
    //

    // Unknown type 'InitialMethodType' (I), skipping the function


    //
    // C++:  void cv::ccm::ColorCorrectionModel::setMaxCount(int maxCount)
    //

    /**
     * set MaxCount
     *     @param maxCount used in MinProblemSolver-DownhillSolver;
     *         Terminal criteria to the algorithm;
     *                      default: 5000;
     */
    public void setMaxCount(int maxCount) {
        setMaxCount_0(nativeObj, maxCount);
    }


    //
    // C++:  void cv::ccm::ColorCorrectionModel::setEpsilon(double epsilon)
    //

    /**
     * set Epsilon
     *     @param epsilon used in MinProblemSolver-DownhillSolver;
     *         Terminal criteria to the algorithm;
     *                    default: 1e-4;
     */
    public void setEpsilon(double epsilon) {
        setEpsilon_0(nativeObj, epsilon);
    }


    //
    // C++:  void cv::ccm::ColorCorrectionModel::setRGB(bool rgb)
    //

    /**
     * Set whether the input image is in RGB color space
     *     @param rgb If true, the model expects input images in RGB format.
     *                  If false, input is assumed to be in BGR (default).
     */
    public void setRGB(boolean rgb) {
        setRGB_0(nativeObj, rgb);
    }


    //
    // C++:  Mat cv::ccm::ColorCorrectionModel::compute()
    //

    /**
     * make color correction
     * @return automatically generated
     */
    public Mat compute() {
        return new Mat(compute_0(nativeObj));
    }


    //
    // C++:  Mat cv::ccm::ColorCorrectionModel::getColorCorrectionMatrix()
    //

    public Mat getColorCorrectionMatrix() {
        return new Mat(getColorCorrectionMatrix_0(nativeObj));
    }


    //
    // C++:  double cv::ccm::ColorCorrectionModel::getLoss()
    //

    public double getLoss() {
        return getLoss_0(nativeObj);
    }


    //
    // C++:  Mat cv::ccm::ColorCorrectionModel::getSrcLinearRGB()
    //

    public Mat getSrcLinearRGB() {
        return new Mat(getSrcLinearRGB_0(nativeObj));
    }


    //
    // C++:  Mat cv::ccm::ColorCorrectionModel::getRefLinearRGB()
    //

    public Mat getRefLinearRGB() {
        return new Mat(getRefLinearRGB_0(nativeObj));
    }


    //
    // C++:  Mat cv::ccm::ColorCorrectionModel::getMask()
    //

    public Mat getMask() {
        return new Mat(getMask_0(nativeObj));
    }


    //
    // C++:  Mat cv::ccm::ColorCorrectionModel::getWeights()
    //

    public Mat getWeights() {
        return new Mat(getWeights_0(nativeObj));
    }


    //
    // C++:  void cv::ccm::ColorCorrectionModel::correctImage(Mat src, Mat& dst, bool islinear = false)
    //

    /**
     * Applies color correction to the input image using a fitted color correction matrix.
     *
     * The conventional ranges for R, G, and B channel values are:
     * <ul>
     *   <li>
     *         0 to 255 for CV_8U images
     *   </li>
     *   <li>
     *         0 to 65535 for CV_16U images
     *   </li>
     *   <li>
     *         0 to 1 for CV_32F images
     *   </li>
     * </ul>
     *         @param src Input 8-bit, 16-bit unsigned or 32-bit float 3-channel image..
     *         @param dst Output image of the same size and datatype as src.
     *         @param islinear default false.
     */
    public void correctImage(Mat src, Mat dst, boolean islinear) {
        correctImage_0(nativeObj, src.nativeObj, dst.nativeObj, islinear);
    }

    /**
     * Applies color correction to the input image using a fitted color correction matrix.
     *
     * The conventional ranges for R, G, and B channel values are:
     * <ul>
     *   <li>
     *         0 to 255 for CV_8U images
     *   </li>
     *   <li>
     *         0 to 65535 for CV_16U images
     *   </li>
     *   <li>
     *         0 to 1 for CV_32F images
     *   </li>
     * </ul>
     *         @param src Input 8-bit, 16-bit unsigned or 32-bit float 3-channel image..
     *         @param dst Output image of the same size and datatype as src.
     */
    public void correctImage(Mat src, Mat dst) {
        correctImage_1(nativeObj, src.nativeObj, dst.nativeObj);
    }


    //
    // C++:  void cv::ccm::ColorCorrectionModel::write(FileStorage fs)
    //

    // Unknown type 'FileStorage' (I), skipping the function


    //
    // C++:  void cv::ccm::ColorCorrectionModel::read(FileNode node)
    //

    // Unknown type 'FileNode' (I), skipping the function


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::ccm::ColorCorrectionModel::ColorCorrectionModel()
    private static native long ColorCorrectionModel_0();

    // C++:   cv::ccm::ColorCorrectionModel::ColorCorrectionModel(Mat src, int constColor)
    private static native long ColorCorrectionModel_1(long src_nativeObj, int constColor);

    // C++:  void cv::ccm::ColorCorrectionModel::setLinearizationGamma(double gamma)
    private static native void setLinearizationGamma_0(long nativeObj, double gamma);

    // C++:  void cv::ccm::ColorCorrectionModel::setLinearizationDegree(int deg)
    private static native void setLinearizationDegree_0(long nativeObj, int deg);

    // C++:  void cv::ccm::ColorCorrectionModel::setSaturatedThreshold(double lower, double upper)
    private static native void setSaturatedThreshold_0(long nativeObj, double lower, double upper);

    // C++:  void cv::ccm::ColorCorrectionModel::setWeightsList(Mat weightsList)
    private static native void setWeightsList_0(long nativeObj, long weightsList_nativeObj);

    // C++:  void cv::ccm::ColorCorrectionModel::setWeightCoeff(double weightsCoeff)
    private static native void setWeightCoeff_0(long nativeObj, double weightsCoeff);

    // C++:  void cv::ccm::ColorCorrectionModel::setMaxCount(int maxCount)
    private static native void setMaxCount_0(long nativeObj, int maxCount);

    // C++:  void cv::ccm::ColorCorrectionModel::setEpsilon(double epsilon)
    private static native void setEpsilon_0(long nativeObj, double epsilon);

    // C++:  void cv::ccm::ColorCorrectionModel::setRGB(bool rgb)
    private static native void setRGB_0(long nativeObj, boolean rgb);

    // C++:  Mat cv::ccm::ColorCorrectionModel::compute()
    private static native long compute_0(long nativeObj);

    // C++:  Mat cv::ccm::ColorCorrectionModel::getColorCorrectionMatrix()
    private static native long getColorCorrectionMatrix_0(long nativeObj);

    // C++:  double cv::ccm::ColorCorrectionModel::getLoss()
    private static native double getLoss_0(long nativeObj);

    // C++:  Mat cv::ccm::ColorCorrectionModel::getSrcLinearRGB()
    private static native long getSrcLinearRGB_0(long nativeObj);

    // C++:  Mat cv::ccm::ColorCorrectionModel::getRefLinearRGB()
    private static native long getRefLinearRGB_0(long nativeObj);

    // C++:  Mat cv::ccm::ColorCorrectionModel::getMask()
    private static native long getMask_0(long nativeObj);

    // C++:  Mat cv::ccm::ColorCorrectionModel::getWeights()
    private static native long getWeights_0(long nativeObj);

    // C++:  void cv::ccm::ColorCorrectionModel::correctImage(Mat src, Mat& dst, bool islinear = false)
    private static native void correctImage_0(long nativeObj, long src_nativeObj, long dst_nativeObj, boolean islinear);
    private static native void correctImage_1(long nativeObj, long src_nativeObj, long dst_nativeObj);

    // native support for java finalize() or cleaner
    private static native void delete(long nativeObj);

}
