package com.parkcircus.opencvlab.gettingstarted

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.parkcircus.opencvlab.R
import org.opencv.android.OpenCVLoader
import org.opencv.android.Utils
import org.opencv.core.Mat
import org.opencv.imgcodecs.Imgcodecs
import org.opencv.imgproc.Imgproc
import java.io.File
import java.util.concurrent.Executors
import androidx.core.graphics.createBitmap

class CameraSnapActivity : Activity() {

    private val logTag = "Ex01_CameraSnap"
    private val CAMERA_PERMISSION_CODE = 100

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_test)

        // 1. Initialize OpenCV locally
        if (!OpenCVLoader.initLocal()) {
            Log.e(logTag, "❌ ERROR: OpenCV initialization failed.")
            return
        }

        // 2. Check and request runtime camera permissions
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_CODE)
        } else {
            initializeCameraPipeline()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initializeCameraPipeline()
            } else {
                Log.e(logTag, "❌ ERROR: Camera permission denied by user.")
            }
        }
    }

    private fun initializeCameraPipeline() {
        Log.i(logTag, "📷 Initializing hardware camera sensor via Android subsystem...")

        // Open default camera stream index via OpenCV VideoCapture
        val cap = org.opencv.videoio.VideoCapture(0)

        if (!cap.isOpened()) {
            Log.e(logTag, "❌ ERROR: Could not open the camera device stream.")
            return
        }

        val backgroundExecutor = Executors.newSingleThreadExecutor()
        backgroundExecutor.execute {
            val frame = Mat()
            Log.i(logTag, "⏳ Warming up sensor auto-exposure and flushing initial frames...")

            // Discard the first 15 frames to allow auto-exposure/AWB to settle (matching C++ workflow)
            for (i in 0 until 15) {
                if (!cap.read(frame)) {
                    Log.e(logTag, "❌ ERROR: Camera stream dropped frame $i during warm-up.")
                    cap.release()
                    return@execute
                }
            }

            // Capture the final targeted frame[cite: 3]
            if (!cap.read(frame) || frame.empty()) {
                Log.e(logTag, "❌ ERROR: Final captured frame is empty. Stream dropped.")
                cap.release()
                return@execute
            }

            // Release the hardware interface[cite: 3]
            cap.release()

            // Serialize output matrix to internal storage[cite: 3]
            val outputFile = File(getExternalFilesDir(null), "output_live_snap.png")
            if (Imgcodecs.imwrite(outputFile.absolutePath, frame)) {
                Log.i(logTag, "✅ Hardware frame captured and saved to: ${outputFile.absolutePath}")
            } else {
                Log.e(logTag, "❌ ERROR: Failed to write output_live_snap.png")
            }

            // Convert OpenCV Mat to Android Bitmap for UI display
            val rgbFrame = Mat()
            Imgproc.cvtColor(frame, rgbFrame, Imgproc.COLOR_BGR2RGB)

            val bitmap = createBitmap(rgbFrame.cols(), rgbFrame.rows())
            Utils.matToBitmap(rgbFrame, bitmap)

            runOnUiThread {
                val imageView = findViewById<ImageView>(R.id.cameraImageView)
                imageView.setImageBitmap(bitmap)
            }

            // Release native matrix buffers
            frame.release()
            rgbFrame.release()
        }
    }
}
