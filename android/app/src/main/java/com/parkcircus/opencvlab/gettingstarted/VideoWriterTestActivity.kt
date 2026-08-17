package com.parkcircus.opencvlab.gettingstarted

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.parkcircus.opencvlab.R
import org.opencv.android.OpenCVLoader
import org.opencv.core.CvType
import org.opencv.core.Mat
import org.opencv.core.Point
import org.opencv.core.Scalar
import org.opencv.core.Size
import org.opencv.imgproc.Imgproc
import org.opencv.videoio.VideoWriter
import java.io.File
import java.util.concurrent.Executors

class VideoWriterTestActivity : Activity() {
    private val logTag = "Ex01_VideoWriter"

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_writer_test)

        if (!OpenCVLoader.initLocal()) {
            Log.e(logTag, "❌ ERROR: OpenCV initialization failed.")
            return
        }

        Log.i(logTag, "📹 Initializing Synthetic Video Writer Test...")

        val backgroundExecutor = Executors.newSingleThreadExecutor()
        backgroundExecutor.execute {
            val width = 640.0
            val height = 480.0
            val fps = 30.0
            val totalFrames = 60

            val outputFile = File(getExternalFilesDir(null), "output_synthetic_video.mp4")
            val fourcc = VideoWriter.fourcc('m', 'p', '4', 'v')
            val writer = VideoWriter(outputFile.absolutePath, fourcc, fps, Size(width, height))

            if (!writer.isOpened()) {
                Log.e(logTag, "❌ ERROR: Could not open VideoWriter for path: ${outputFile.absolutePath}")
                return@execute
            }

            val frame = Mat(height.toInt(), width.toInt(), CvType.CV_8UC3)
            for (i in 0 until totalFrames) {
                frame.setTo(Scalar(30.0, 30.0, 30.0))
                val posX = (100 + i * 7) % width.toInt()
                Imgproc.circle(frame, Point(posX.toDouble(), 240.0), 50, Scalar(0.0, 165.0, 255.0), -1)
                Imgproc.putText(frame, "Synthetic Frame: $i", Point(40.0, 60.0), Imgproc.FONT_HERSHEY_SIMPLEX, 0.8, Scalar(255.0, 255.0, 255.0), 2)

                writer.write(frame)
            }

            writer.release()
            frame.release()

            Log.i(logTag, "✅ Synthetic video successfully rendered and saved to: ${outputFile.absolutePath}")

            runOnUiThread {
                val statusText = findViewById<TextView>(R.id.writerStatusTextView)
                statusText.text = "Saved: output_synthetic_video.mp4"
            }
        }
    }
}
