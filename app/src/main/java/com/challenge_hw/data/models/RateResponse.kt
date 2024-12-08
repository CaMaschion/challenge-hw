package com.challenge_hw.data.models

data class RateResponse(
    val success: Boolean,
    val timestamp: Long,
    val historical: Boolean,
    val base: String,
    val date: String,
    val rates: Map<String, Double>
)