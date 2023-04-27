package com.hrmoller.ignition.DTOs.User

@kotlinx.serialization.Serializable
class UserDTO(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val userName: String,
    val role: String
) {
}