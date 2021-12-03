package com.example.courseaplc.data.repository

import com.example.courseaplc.data.remote.CoinPaprikaApi
import com.example.courseaplc.data.remote.dto.CoinDetailDto.CoinDetailDto
import com.example.courseaplc.data.remote.dto.CoinDto.CoinDto
import com.example.courseaplc.data.remote.dto.CoinOhlcvDto.CoinOhlcvDto
import com.example.courseaplc.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    val api: CoinPaprikaApi
) : CoinRepository{

    override suspend fun getCoins(): List<CoinDto> {
       return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }

    override suspend fun getOhlcvTodayById(coinId: String): List<CoinOhlcvDto> {
        return api.getOhlcvTodayById(coinId = coinId)
    }
}