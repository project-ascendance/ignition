package com.hrmoller.ignition.DTOs.Content
import kotlinx.serialization.Serializable

@Serializable
data class ContentDTO(
    val id: Int,
    val type: String,
    val title: String,
    val sites: List<String>,
    val body: String,
    val image: String?,
    val startDate: String,
    val endDate: String
)