package com.example.courseaplc.data.remote.dto.CoinDetailDto


import com.google.gson.annotations.SerializedName

data class Contract(
    val contract: String,
    val platform: String,
    val type: String
)