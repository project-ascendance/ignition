package com.hrmoller.ignition

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.ignition.R
import com.hrmoller.ignition.Services.ContentDatahandler
import com.hrmoller.ignition.ViewModels.ContentListViewModel
import com.hrmoller.ignition.Views.BottomBar
import com.hrmoller.ignition.Views.ContentList
import com.hrmoller.ignition.Views.TopBar
import com.hrmoller.ignition.ui.theme.IgnitionTheme
import org.koin.androidx.compose.getViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.androidx.compose.get

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            IgnitionTheme {
                val contentListViewModel = getViewModel<ContentListViewModel>()
                Scaffold(
                    topBar = {
                        TopBar()
                    },
                    bottomBar = {
                        BottomBar()
                    },
                    backgroundColor = colorResource(id = R.color.top_bar_bg),
                    modifier = Modifier.fillMaxSize()
                ) { paddingValues ->
                    Modifier.padding(paddingValues)
                    ContentList(contentListViewmodel = contentListViewModel) }
            }
        }
    }
}