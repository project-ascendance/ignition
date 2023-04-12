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
    var image: Image = TODO()
    var body: String = ""
    var sites: List<String>
    @RequiresApi(Build.VERSION_CODES.O)
    var releaseDate: LocalDate = LocalDate.now()
    @RequiresApi(Build.VERSION_CODES.O)
    var expirationDate: LocalDate = LocalDate.now().plusWeeks(1)
    var author: String = ""
    @RequiresApi(Build.VERSION_CODES.O)
    var creationTime: LocalDateTime = LocalDateTime.now()
}