package com.hrmoller.ignition.Views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hrmoller.ignition.ViewModels.ContentListViewModel
import org.koin.dsl.module

//TODO Implement Composable List of Content (compact format)

@Composable
fun ContentList(contentListViewmodel: ContentListViewModel){

    val contentList by contentListViewmodel.contentList.collectAsState()
    contentList.groupBy { it.type }

    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().clickable(enabled = true, onClick = {/*TODO*/})){
        items(contentList) {
            content ->
                ContentItem(item = content)
        }
    }
}