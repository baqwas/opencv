package com.parkcircus.opencvlab.gettingstarted

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.parkcircus.opencvlab.R
import org.opencv.android.OpenCVLoader
import org.opencv.android.Utils
import org.opencv.core.Core
import org.opencv.core.CvType
import org.opencv.core.Mat
import org.opencv.core.Point
import org.opencv.core.Scalar
import org.opencv.imgcodecs.Imgcodecs
import org.opencv.imgproc.Imgproc
import java.io.File

class BlendTestActivity : Activity() {

    private val logTag = "Ex01_AlphaBlend"

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blend_test)

        // 1. Initialize OpenCV locally
        if (!OpenCVLoader.initLocal()) {
            Log.e(logTag, "❌ ERROR: OpenCV initialization failed.")
            return
        }

        Log.i(logTag, "⚖️ Initializing Alpha Blending Test...")

        // 2. Create base background image (640x480, 3-channel BGR) with a rectangle asset
        val img1 = Mat(480, 640, CvType.CV_8UC3, Scalar(30.0, 30.0, 30.0))
        Imgproc.rectangle(img1, Point(50.0, 50.0), Point(590.0, 430.0), Scalar(0.0, 150.0, 200.0), -1)

        // 3. Create overlay asset image with a centered circle asset
        val img2 = Mat(480, 640, CvType.CV_8UC3, Scalar(200.0, 200.0, 200.0))
        Imgproc.circle(img2, Point(320.0, 240.0), 150, Scalar(0.0, 0.0, 255.0), -1)

        val blended = Mat()
        val alpha = 0.6
        val beta = 0.4
        val gamma = 0.0

        // 4. Perform weighted linear matrix addition: dst = src1*alpha + src2*beta + gamma
        Core.addWeighted(img1, alpha, img2, beta, gamma, blended)

        // 5. Serialize output matrix to internal storage
        val outputFile = File(getExternalFilesDir(null), "output_blend.png")
        if (Imgcodecs.imwrite(outputFile.absolutePath, blended)) {
            Log.i(logTag, "✅ Blended frame serialized to: ${outputFile.absolutePath}")
        } else {
            Log.e(logTag, "❌ ERROR: Failed to write output_blend.png")
        }

        // 6. Convert OpenCV Mat to Android Bitmap for UI display
        val rgbBlended = Mat()
        Imgproc.cvtColor(blended, rgbBlended, Imgproc.COLOR_BGR2RGB)

        val bitmap = Bitmap.createBitmap(rgbBlended.cols(), rgbBlended.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(rgbBlended, bitmap)

        // 7. Render final asset onto ImageView
        val imageView = findViewById<ImageView>(R.id.blendImageView)
        imageView.setImageBitmap(bitmap)

        // 8. Release native matrix buffers
        img1.release()
        img2.release()
        blended.release()
        rgbBlended.release()
    }
}
