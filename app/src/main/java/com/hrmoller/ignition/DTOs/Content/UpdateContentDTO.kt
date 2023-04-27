package com.hrmoller.ignition.DTOs.Content

@kotlinx.serialization.Serializable
data class UpdateContentDTO (
    val id: Int,
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