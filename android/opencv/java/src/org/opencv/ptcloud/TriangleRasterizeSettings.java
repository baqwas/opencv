//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.ptcloud;

import org.opencv.ptcloud.TriangleRasterizeSettings;

// C++: class TriangleRasterizeSettings
/**
 * Structure to keep settings for rasterization
 */
public class TriangleRasterizeSettings {

    protected final long nativeObj;
    protected TriangleRasterizeSettings(long addr) {
      nativeObj = addr;

    }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static TriangleRasterizeSettings __fromPtr__(long addr) { return new TriangleRasterizeSettings(addr); }

    //
    // C++:  TriangleRasterizeSettings cv::TriangleRasterizeSettings::setShadingType(TriangleShadingType st)
    //

    public TriangleRasterizeSettings setShadingType(int st) {
        return new TriangleRasterizeSettings(setShadingType_0(nativeObj, st));
    }


    //
    // C++:  TriangleRasterizeSettings cv::TriangleRasterizeSettings::setCullingMode(TriangleCullingMode cm)
    //

    public TriangleRasterizeSettings setCullingMode(int cm) {
        return new TriangleRasterizeSettings(setCullingMode_0(nativeObj, cm));
    }


    //
    // C++:  TriangleRasterizeSettings cv::TriangleRasterizeSettings::setGlCompatibleMode(TriangleGlCompatibleMode gm)
    //

    public TriangleRasterizeSettings setGlCompatibleMode(int gm) {
        return new TriangleRasterizeSettings(setGlCompatibleMode_0(nativeObj, gm));
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:  TriangleRasterizeSettings cv::TriangleRasterizeSettings::setShadingType(TriangleShadingType st)
    private static native long setShadingType_0(long nativeObj, int st);

    // C++:  TriangleRasterizeSettings cv::TriangleRasterizeSettings::setCullingMode(TriangleCullingMode cm)
    private static native long setCullingMode_0(long nativeObj, int cm);

    // C++:  TriangleRasterizeSettings cv::TriangleRasterizeSettings::setGlCompatibleMode(TriangleGlCompatibleMode gm)
    private static native long setGlCompatibleMode_0(long nativeObj, int gm);

    // native support for java finalize() or cleaner
    private static native void delete(long nativeObj);

}
