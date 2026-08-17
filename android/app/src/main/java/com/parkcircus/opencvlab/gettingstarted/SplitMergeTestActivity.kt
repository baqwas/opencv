package com.parkcircus.opencvlab.gettingstarted

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.core.graphics.createBitmap
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

class SplitMergeTestActivity : Activity() {
    private val logTag = "Ex01_SplitMerge"

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_split_merge_test)

        if (!OpenCVLoader.initLocal()) {
            Log.e(logTag, "❌ ERROR: OpenCV initialization failed.")
            return
        }

        Log.i(logTag, "🔀 Initializing Channel Split and Merge Test...")

        // Create a multicolor test image
        val image = Mat(480, 640, CvType.CV_8UC3, Scalar(100.0, 150.0, 200.0))
        Imgproc.circle(image, Point(320.0, 240.0), 120, Scalar(0.0, 0.0, 255.0), -1)

        // Split channels
        val channels = ArrayList<Mat>()
        Core.split(image, channels)

        // Zero out blue channel
        channels[0].setTo(Scalar(0.0))

        // Merge channels back
        val merged = Mat()
        Core.merge(channels, merged)

        val outputFile = File(getExternalFilesDir(null), "output_split_merge.png")
        Imgcodecs.imwrite(outputFile.absolutePath, merged)
        Log.i(logTag, "✅ Split and merge processed, saved to: ${outputFile.absolutePath}")

        // Convert to Bitmap for UI display
        val rgbMerged = Mat()
        Imgproc.cvtColor(merged, rgbMerged, Imgproc.COLOR_BGR2RGB)
        val bitmap = createBitmap(rgbMerged.cols(), rgbMerged.rows())
        Utils.matToBitmap(rgbMerged, bitmap)

        val imageView = findViewById<ImageView>(R.id.splitMergeImageView)
        imageView.setImageBitmap(bitmap)

        image.release()
        merged.release()
        rgbMerged.release()
        for (ch in channels) ch.release()
    }
}
