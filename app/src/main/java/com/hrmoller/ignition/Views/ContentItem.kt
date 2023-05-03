package com.hrmoller.ignition.Views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hrmoller.ignition.Models.Content

@Composable
fun ContentItem(item: Content){
    Box(modifier = Modifier.shadow(4.dp).padding(top = 8.dp, start = 24.dp, end = 24.dp).fillMaxWidth().wrapContentSize().border(2.dp,
        Color.White)) {
        Column(
            modifier = Modifier.fillMaxWidth().align(Alignment.Center).wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "ID: " + item.id, fontSize = 14.sp, modifier = Modifier.padding(4.dp))
            Text(text = "Title: " + item.title, fontSize = 18.sp, modifier = Modifier.padding(4.dp))

        }
    }
}