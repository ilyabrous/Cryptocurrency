package com.example.courseaplc.data.remote.dto.CoinOhlcvDto


import android.util.Log
import com.example.courseaplc.domain.model.CoinOhlcv
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

data class CoinOhlcvDto(
    val close: Double,
    val high: Double,
    val low: Double,
    @SerializedName("market_cap")
    val marketCap: Long,
    val open: Double,
    @SerializedName("time_close")
    var timeClose: String,
    @SerializedName("time_open")
    var timeOpen: String,
    val volume: Long
)

fun CoinOhlcvDto.toCoinOhlcv() : CoinOhlcv {
    //todo replace
    timeClose = timeClose.replace('Z', ' ').replace("T", " ")
    timeOpen = timeOpen.replace('Z', ' ').replace("T", " ")


    return CoinOhlcv(
        close = close,
        high = high,
        low = low,
        marketCap = marketCap,
        open = open,
        timeClose = timeClose,
        timeOpen = timeOpen,
        volume = volume
    )
}