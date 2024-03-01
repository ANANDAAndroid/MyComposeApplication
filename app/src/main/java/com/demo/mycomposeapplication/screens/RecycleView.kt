package com.demo.mycomposeapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.mycomposeapplication.Comments
import com.demo.mycomposeapplication.R
import com.demo.mycomposeapplication.arrayList


@Preview
@Composable
fun RecycleViewPrev() {
    RecycleView(list = arrayList)
}


@Composable
fun RecycleView(list:ArrayList<Comments>) {
LazyColumn{
    items(list){
        Item_RecycleView(comments = it)
    }
}
}


@Composable
fun Item_RecycleView(comments: Comments) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp, horizontal = 15.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.image1),
                contentDescription = "image",
                modifier = Modifier
                    .weight(0.2f)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Fit
            )
            Text(
                text = comments.comment,
                color = Color.Black,
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
                lineHeight = TextUnit(15f, TextUnitType.Sp),
                modifier = Modifier
                    .weight(0.8f)
                    .padding(horizontal = 5.dp , vertical = 5.dp)
            )
        }
    }


}