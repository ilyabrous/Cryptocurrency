package com.example.courseaplc.data.remote.dto.CoinDetailDto


import com.google.gson.annotations.SerializedName

data class Stats(
    val contributors: Int,
    val followers: Int,
    val stars: Int,
    val subscribers: Int
)