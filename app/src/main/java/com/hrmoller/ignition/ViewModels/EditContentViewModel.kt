package com.hrmoller.ignition.ViewModels

import com.hrmoller.ignition.Models.Content
import com.hrmoller.ignition.Services.ContentDatahandler
import com.hrmoller.ignition.Services.factories.ContentFactory

class EditContentViewModel(
    var content: Content,
    val datahandler: ContentDatahandler
) {
    fun SaveChanges(){

        if (datahandler.getContent(content.id) == null){
            datahandler.createContent(content)
        }
        else datahandler.updateContent(content)
    }
}