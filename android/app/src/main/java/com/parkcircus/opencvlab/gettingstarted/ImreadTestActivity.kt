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
import org.opencv.core.Scalar
import org.opencv.imgcodecs.Imgcodecs
import org.opencv.imgproc.Imgproc
import java.io.File

class ImreadTestActivity : Activity() {
    private val logTag = "Ex01_ImreadTest"

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imread_test)

        if (!OpenCVLoader.initLocal()) {
            Log.e(logTag, "❌ ERROR: OpenCV initialization failed.")
            return
        }

        Log.i(logTag, "📂 Initializing Image Read and Write Test...")

        // Create a source image to simulate reading from disk
        val srcFile = File(getExternalFilesDir(null), "input_source.png")
        val sampleMat = Mat(480, 640, CvType.CV_8UC3, Scalar(50.0, 50.0, 50.0))
        Imgproc.putText(sampleMat, "OpenCV Imread Test", Point(80.0, 240.0), Imgproc.FONT_HERSHEY_SIMPLEX, 1.2, Scalar(0.0, 255.0, 255.0), 3)
        Imgcodecs.imwrite(srcFile.absolutePath, sampleMat)

        // Read image back using Imgcodecs.imread()
        val loadedMat = Imgcodecs.imread(srcFile.absolutePath)
        if (loadedMat.empty()) {
            Log.e(logTag, "❌ ERROR: Failed to read image from ${srcFile.absolutePath}")
            return
        }

        Log.i(logTag, "✅ Successfully loaded image: ${srcFile.absolutePath} [Cols: ${loadedMat.cols()}, Rows: ${loadedMat.rows()}]")

        // Convert to Bitmap for UI display
        val rgbMat = Mat()
        Imgproc.cvtColor(loadedMat, rgbMat, Imgproc.COLOR_BGR2RGB)
        val bitmap = createBitmap(rgbMat.cols(), rgbMat.rows())
        Utils.matToBitmap(rgbMat, bitmap)

        val imageView = findViewById<ImageView>(R.id.imreadImageView)
        imageView.setImageBitmap(bitmap)

        sampleMat.release()
        loadedMat.release()
        rgbMat.release()
    }
}
