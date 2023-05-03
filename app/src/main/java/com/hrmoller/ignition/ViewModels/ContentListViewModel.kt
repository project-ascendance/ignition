package com.hrmoller.ignition.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hrmoller.ignition.Models.Content
import com.hrmoller.ignition.Services.ContentDatahandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContentListViewModel(private val dataHandler: ContentDatahandler) : ViewModel() {
    private val _contentList = MutableStateFlow(emptyList<Content>())
    val contentList = _contentList.asStateFlow()
    private val  _selectedContent = MutableStateFlow(Content())
    val selectedContent = _selectedContent.asStateFlow()


    init {
        viewModelScope.launch { _contentList.value = dataHandler.getAllContents() }
    }

}