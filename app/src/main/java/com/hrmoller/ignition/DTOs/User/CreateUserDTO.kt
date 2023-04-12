package com.hrmoller.ignition.DTOs.User

class CreateUserDTO(
    val firstName: String,
    val lastName: String,
    val email: String,
    val userName: String,
    val role: String,
    val password: String
) {
}