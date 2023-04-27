package com.hrmoller.ignition.DTOs.User

@kotlinx.serialization.Serializable
class UserLoginDTO(
    val email: String,
    val password: String
) {
}