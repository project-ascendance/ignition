package com.hrmoller.ignition.ViewModels

import androidx.lifecycle.ViewModel
import com.hrmoller.ignition.Models.Content
import com.hrmoller.ignition.Services.Datahandler

class ContentListViewModel(val dataHandler: Datahandler) : ViewModel() {
    var contentList: List<Content>
    var selectedContent: Content = Content()

    init {
        contentList = dataHandler.getAllContents()
    }
}