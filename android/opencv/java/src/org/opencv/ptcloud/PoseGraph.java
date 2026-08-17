//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.ptcloud;



// C++: class PoseGraph

public class PoseGraph {

    protected final long nativeObj;
    protected PoseGraph(long addr) {
      nativeObj = addr;

    }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static PoseGraph __fromPtr__(long addr) { return new PoseGraph(addr); }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // native support for java finalize() or cleaner
    private static native void delete(long nativeObj);

}
