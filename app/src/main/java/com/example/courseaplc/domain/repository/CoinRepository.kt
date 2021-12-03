package com.example.courseaplc.domain.repository

import com.example.courseaplc.data.remote.dto.CoinDetailDto.CoinDetailDto
import com.example.courseaplc.data.remote.dto.CoinDto.CoinDto
import com.example.courseaplc.data.remote.dto.CoinOhlcvDto.CoinOhlcvDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId : String) : CoinDetailDto

    suspend fun getOhlcvTodayById(coinId: String) : List<CoinOhlcvDto>
}