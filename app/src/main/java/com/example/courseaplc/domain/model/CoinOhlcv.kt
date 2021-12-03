package com.example.courseaplc.domain.model

import com.google.gson.annotations.SerializedName

data class CoinOhlcv (
    val close: Double,
    val high: Double,
    val low: Double,
    val marketCap: Long,
    val open: Double,
    val timeClose: String,
    val timeOpen: String,
    val volume: Long
)