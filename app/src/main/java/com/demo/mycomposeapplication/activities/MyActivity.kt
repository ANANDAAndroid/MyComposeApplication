package com.demo.mycomposeapplication.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.demo.mycomposeapplication.ui.theme.MyComposeApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                }
            }
        }
    }
}

