package com.demo.mycomposeapplication

import android.os.Bundle
import android.provider.Settings
import android.provider.Settings.Secure
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.demo.mycomposeapplication.screens.LogIn
import com.demo.mycomposeapplication.screens.ProgressBar
import com.demo.mycomposeapplication.screens.QuotesRecycleView
import com.demo.mycomposeapplication.screens.RecycleView
import com.demo.mycomposeapplication.ui.theme.MyComposeApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

@AndroidEntryPoint
class MyActivity : ComponentActivity() {

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
                    /******************************************************************************************/
                    /*LogIn { username, password ->
                       Toast.makeText(
                           this,
                           "username is $username :: password is $password ",
                           Toast.LENGTH_SHORT
                       ).show()
                   }*/

                    /******************************************************************************************/

                    // RecycleView(list = arrayList)

                    /******************************************************************************************/


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

