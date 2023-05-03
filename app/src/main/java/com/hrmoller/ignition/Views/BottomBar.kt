package com.hrmoller.ignition.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ignition.R

//TODO Implement Composable Bottom bar for home, navigation and addition(Add Content)

@Preview
@Composable
fun BottomBar(){
    BottomAppBar(
        actions = {
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(0.8f).fillMaxHeight()) {
                Icon(Icons.Filled.Home, contentDescription = "Return to home page", modifier = Modifier.fillMaxSize())
            }
        },
        modifier = Modifier
            .height(60.dp)
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        colorResource(id = R.color.top_bar_bg),
                        colorResource(id = R.color.top_bar_bg2)
                    ),
                    start = Offset(0f, Float.POSITIVE_INFINITY),
                    end = Offset(Float.POSITIVE_INFINITY, 0f)
                )
            ),
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxSize().padding(bottom = 8.dp)) {
                Icon(Icons.Filled.Add, contentDescription = "Add content")
            }
        },
        containerColor = colorResource(id = R.color.top_bar_bg),
        contentColor = Color.White
    )

}