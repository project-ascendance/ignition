package com.hrmoller.ignition.DTOs.Content

data class CreateContentDTO (
    val type: String,
    val title: String,
    val sites: List<String>,
    val body: String,
    val image: String,
    val releaseDate: String,
    val expirationDate: String,
    val creationTime: String,
    val author: String
    ) {

}