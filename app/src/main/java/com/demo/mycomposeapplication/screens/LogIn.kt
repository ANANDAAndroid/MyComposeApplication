package com.demo.mycomposeapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.mycomposeapplication.ui.theme.Purple40

@Preview(showSystemUi = true)
@Composable
fun LogInPrev() {
    LogIn{ _, _ -> }
}
@Composable
fun LogIn(value: (username: String, password: String) -> Unit) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Hello Again!\nWelcome\nBack",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            textAlign = TextAlign.Start,
            color = Color.Blue,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(value = username.value, onValueChange = {
            username.value = it
        }, placeholder = { Text(text = "Enter username") },
            label = { Text(text = "Username") },
            textStyle = TextStyle.Default.copy(color = Color.Black),
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(top = 10.dp)
                .fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "username",
                    tint = Color.Black
                )
            }
        )
        OutlinedTextField(value = password.value, onValueChange = {
            password.value = it
        }, placeholder = { Text(text = "Enter password") },
            label = { Text(text = "Password") },
            textStyle = TextStyle.Default.copy(color = Color.Black),
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(top = 10.dp)
                .fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "password",
                    tint = Color.Black,
                )
            }
        )

        OutlinedButton(
            onClick = { value(username.value, password.value) },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.11f)
                .padding(horizontal = 20.dp)
                .padding(top = 10.dp)
        ) {
            Text(text = "Login", fontWeight = FontWeight.Bold, fontSize = 22.sp, color = Purple40)
        }
    }
}