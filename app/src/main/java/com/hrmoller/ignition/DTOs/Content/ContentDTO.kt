package com.hrmoller.ignition.DTOs.Content

@kotlinx.serialization.Serializable
data class ContentDTO(
    val id: Int,
    val type: String,
    val title: String,
    val sites: List<String>,
    val body: String,
    val image: String,
    val activeFrom: String,
    val activeTo: String
) {

}