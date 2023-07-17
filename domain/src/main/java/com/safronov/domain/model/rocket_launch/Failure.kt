package com.safronov.domain.model.rocket_launch

data class Failure(
    val altitude: Int,
    val reason: String,
    val time: Int
)