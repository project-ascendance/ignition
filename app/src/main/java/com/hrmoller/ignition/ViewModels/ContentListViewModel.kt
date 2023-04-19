package com.hrmoller.ignition.ViewModels

import com.hrmoller.ignition.Models.Content
import com.hrmoller.ignition.Services.Datahandler

class ContentListViewModel(dataHandler: Datahandler) {
    private var _handler: Datahandler = dataHandler
    var contentList: List<Content>
    var selectedContent: Content = Content()

    init {
        contentList = _handler.getAllContents()
    }
}