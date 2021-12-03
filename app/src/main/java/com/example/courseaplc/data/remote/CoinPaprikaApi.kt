package com.example.courseaplc.data.remote

import com.example.courseaplc.data.remote.dto.CoinDetailDto.CoinDetailDto
import com.example.courseaplc.data.remote.dto.CoinDto.CoinDto
import com.example.courseaplc.data.remote.dto.CoinOhlcvDto.CoinOhlcvDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String) : CoinDetailDto

    @GET("/v1/coins/{coinId}/ohlcv/today")
    suspend fun getOhlcvTodayById(@Path("coinId") coinId: String) : List<CoinOhlcvDto>
}