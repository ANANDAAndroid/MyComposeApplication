package com.demo.mycomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.mycomposeapplication.ui.theme.MyComposeApplicationTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeApplicationTheme {
                Scaffold(topBar = {
                    TopAppBar(title = {
                        Text(text = "Compose App")
                    }, navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                        }

                    }, actions = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Favourite"
                            )
                        }
                        IconButton(onClick = { }) {
                            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                        }
                    })
                }, floatingActionButton = {
                    FloatingActionButton(onClick = { }) {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
                    }
                }, floatingActionButtonPosition = FabPosition.End) {
                    Box(
                        Modifier
                            .padding(it)
                            .background(Color.Gray)) {
                        Greetings()
                    }
                }
            }
        }
    }
}

@Preview(widthDp = 200, heightDp = 400)
@Composable
fun Greetings() {
    val state= remember { mutableStateOf(false) }
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Welcome To Jetpack Compose",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Green,
            textAlign = TextAlign.Center
        )

        Switch(checked = state.value, onCheckedChange = {
            state.value=it
        }, modifier = Modifier.fillMaxWidth().padding(top = 10.dp))
    }

}

