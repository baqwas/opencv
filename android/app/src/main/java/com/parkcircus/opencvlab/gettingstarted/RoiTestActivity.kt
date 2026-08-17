package com.parkcircus.opencvlab.gettingstarted

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.core.graphics.createBitmap
import com.parkcircus.opencvlab.R
import org.opencv.android.OpenCVLoader
import org.opencv.android.Utils
import org.opencv.core.CvType
import org.opencv.core.Mat
import org.opencv.core.Point
import org.opencv.core.Rect
import org.opencv.core.Scalar
import org.opencv.imgcodecs.Imgcodecs
import org.opencv.imgproc.Imgproc
import java.io.File

class RoiTestActivity : Activity() {
    private val logTag = "Ex01_RoiTest"

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roi_test)

        if (!OpenCVLoader.initLocal()) {
            Log.e(logTag, "❌ ERROR: OpenCV initialization failed.")
            return
        }

        Log.i(logTag, "✂️ Initializing Region of Interest (ROI) Test...")

        // Create base image
        val image = Mat(480, 640, CvType.CV_8UC3, Scalar(40.0, 40.0, 40.0))
        Imgproc.rectangle(image, Point(100.0, 100.0), Point(540.0, 380.0), Scalar(200.0, 100.0, 50.0), -1)

        // Define Region of Interest (ROI) rectangle and extract submatrix
        val roiRect = Rect(200, 150, 240, 180)
        val roi = Mat(image, roiRect)

        // Modify ROI content
        roi.setTo(Scalar(0.0, 255.0, 255.0))

        // Draw border around ROI on original image
        Imgproc.rectangle(image, roiRect, Scalar(255.0, 255.0, 255.0), 3)

        val outputFile = File(getExternalFilesDir(null), "output_roi.png")
        Imgcodecs.imwrite(outputFile.absolutePath, image)
        Log.i(logTag, "✅ ROI processed and saved to: ${outputFile.absolutePath}")

        // Convert to Bitmap for UI display
        val rgbImage = Mat()
        Imgproc.cvtColor(image, rgbImage, Imgproc.COLOR_BGR2RGB)
        val bitmap = createBitmap(rgbImage.cols(), rgbImage.rows())
        Utils.matToBitmap(rgbImage, bitmap)

        val imageView = findViewById<ImageView>(R.id.roiImageView)
        imageView.setImageBitmap(bitmap)

        image.release()
        rgbImage.release()
    }
}
