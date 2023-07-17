package com.safronov.domain.model.rocket_launch

data class Core(
    val core: String,
    val flight: Int,
    val gridfins: Boolean,
    val landing_attempt: Boolean,
    val landing_success: Boolean,
    val landing_type: String,
    val landpad: String,
    val legs: Boolean,
    val reused: Boolean
)