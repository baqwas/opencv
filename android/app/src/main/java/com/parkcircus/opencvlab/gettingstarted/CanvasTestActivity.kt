package com.parkcircus.opencvlab.gettingstarted

import android.app.Activity // <-- Changed from AppCompatActivity
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
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

class CanvasTestActivity : Activity() { // <-- Inheriting from standard Activity now

    private val logTag = "Ex01_CanvasTest"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canvas_test)

        // 1. Initialize the OpenCV library
        if (!OpenCVLoader.initLocal()) {
            Log.e(logTag, "❌ ERROR: OpenCV initialization failed.")
            return
        }

        Log.i(logTag, "🎨 Initializing Vector Canvas Test...")

        // 2. Create a 640x480 matrix, 8-bit unsigned, 3 channels (BGR)
        val canvas = Mat(480, 640, CvType.CV_8UC3, Scalar(40.0, 40.0, 40.0))

        // 3. Draw shapes
        Imgproc.circle(canvas, Point(320.0, 240.0), 80, Scalar(0.0, 200.0, 100.0), -1)
        Imgproc.rectangle(canvas, Point(100.0, 100.0), Point(200.0, 200.0), Scalar(255.0, 100.0, 0.0), 3)

        // 4. Overlay text
        Imgproc.putText(
            canvas,
            "OpenCV Lab Canvas Test",
            Point(140.0, 400.0),
            Imgproc.FONT_HERSHEY_SIMPLEX,
            0.9,
            Scalar(255.0, 255.0, 255.0),
            2,
            Imgproc.LINE_AA
        )

        // 5. Serialize to disk (saving to app's internal cache to avoid permission errors)
        val outputFile = File(getExternalFilesDir(null), "output_canvas.png")
        if (Imgcodecs.imwrite(outputFile.absolutePath, canvas)) {
            Log.i(logTag, "✅ Output frame serialized to: ${outputFile.absolutePath}")
        } else {
            Log.e(logTag, "❌ ERROR: Failed to write to ${outputFile.absolutePath}")
        }

        // 6. Convert to Android Bitmap for UI rendering
        val rgbCanvas = Mat()
        Imgproc.cvtColor(canvas, rgbCanvas, Imgproc.COLOR_BGR2RGB)

        val bitmap = Bitmap.createBitmap(rgbCanvas.cols(), rgbCanvas.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(rgbCanvas, bitmap)

        // 7. Display on screen using the ImageView we made in XML
        val imageView = findViewById<ImageView>(R.id.canvasImageView)
        imageView.setImageBitmap(bitmap)

        // 8. Memory cleanup
        canvas.release()
        rgbCanvas.release()
    }
}
