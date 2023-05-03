package com.hrmoller.ignition.Models

import android.media.Image
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalDateTime

class Content {
    var id: Int = 0
    var title: String = ""
    var type: String = ""
    var image: String? = ""
    var body: String = ""
    var sites: List<String> = mutableListOf()
    var activeFrom: String = ""
    var activeTo: String = ""
    var author: String = ""
    var creationTime: String = ""


}