package com.demo.mycomposeapplication.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.demo.mycomposeapplication.api.Status
import com.demo.mycomposeapplication.Viewmodel
import com.demo.mycomposeapplication.screens.ProgressBar
import com.demo.mycomposeapplication.screens.QuotesRecycleView
import com.demo.mycomposeapplication.ui.theme.MyComposeApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MvvmWithComposeActivity : ComponentActivity() {
    private val viewmodel by viewModels<Viewmodel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel.getData()
        setContent {
            MyComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    when (val value = viewmodel.response.collectAsState().value) {
                        is Status.Loading -> {
                            ProgressBar()
                        }

                        is Status.Success -> {
                            QuotesRecycleView(list = value.data.quotes)
                        }

                        is Status.Failure -> {
                            Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}
