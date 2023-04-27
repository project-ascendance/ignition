package com.hrmoller.ignition.DTOs.User

@kotlinx.serialization.Serializable
class CreateUserDTO(
    val firstName: String,
    val lastName: String,
    val email: String,
    val userName: String,
    val role: String,
    val password: String
) {
}