package com.parkcircus.opencvlab

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.parkcircus.opencvlab.ui.theme.OpenCVLabTheme
import org.opencv.android.OpenCVLoader
import org.opencv.core.Core

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize OpenCV and check status
        val opencvStatus = if (OpenCVLoader.initLocal()) {
            val version = Core.VERSION
            Log.i("OpenCV", "OpenCV loaded successfully. Version: $version")
            "Hello OpenCV!\nVersion: $version"
        } else {
            Log.e("OpenCV", "OpenCV initialization failed!")
            "OpenCV Initialization Failed"
        }

        enableEdgeToEdge()
        setContent {
            OpenCVLabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HelloOpenCVView(
                        statusMessage = opencvStatus,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HelloOpenCVView(statusMessage: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = statusMessage)
    }
}
