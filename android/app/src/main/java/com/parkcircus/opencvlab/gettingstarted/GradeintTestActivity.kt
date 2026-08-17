package com.parkcircus.opencvlab.gettingstarted

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.parkcircus.opencvlab.R
import org.opencv.android.OpenCVLoader
import org.opencv.android.Utils
import org.opencv.core.CvType
import org.opencv.core.Mat
import org.opencv.imgcodecs.Imgcodecs
import org.opencv.imgproc.Imgproc
import java.io.File

class GradientTestActivity : Activity() {

    private val logTag = "Ex01_GradientTest"

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gradient_test)

        // 1. Initialize OpenCV locally
        if (!OpenCVLoader.initLocal()) {
            Log.e(logTag, "❌ ERROR: OpenCV initialization failed.")
            return
        }

        Log.i(logTag, "🌈 Computing Procedural Color Gradient...")

        // 2. Instantiate uninitialized 640x480 8UC3 matrix
        val image = Mat(480, 640, CvType.CV_8UC3)

        // 3. Populate pixel channels explicitly via nested coordinate loops
        val rows = image.rows()
        val cols = image.cols()
        for (y in 0 until rows) {
            for (x in 0 until cols) {
                val blue = (x * 255 / cols).toDouble()
                val green = (y * 255 / rows).toDouble()
                val red = 128.0

                image.put(y, x, blue, green, red)
            }
        }

        // 4. Serialize output matrix to internal storage
        val outputFile = File(getExternalFilesDir(null), "output_gradient.png")
        if (Imgcodecs.imwrite(outputFile.absolutePath, image)) {
            Log.i(logTag, "✅ Gradient frame serialized to: ${outputFile.absolutePath}")
        } else {
            Log.e(logTag, "❌ ERROR: Failed to write output_gradient.png")
        }

        // 5. Convert OpenCV Mat to Android Bitmap for UI display
        val rgbImage = Mat()
        Imgproc.cvtColor(image, rgbImage, Imgproc.COLOR_BGR2RGB)

        val bitmap = Bitmap.createBitmap(rgbImage.cols(), rgbImage.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(rgbImage, bitmap)

        // 6. Render final asset onto ImageView
        val imageView = findViewById<ImageView>(R.id.gradientImageView)
        imageView.setImageBitmap(bitmap)

        // 7. Release native matrix buffers
        image.release()
        rgbImage.release()
    }
}
