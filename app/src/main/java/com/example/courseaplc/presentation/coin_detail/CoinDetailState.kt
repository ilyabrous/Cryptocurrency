package com.example.courseaplc.presentation.coin_detail

import com.example.courseaplc.domain.model.Coin
import com.example.courseaplc.domain.model.CoinDetail
import com.example.courseaplc.domain.model.CoinOhlcv

data class CoinDetailState(
    val isLoading : Boolean = false,
    val coin : CoinDetail? = null,
    val ohlcv : CoinOhlcv? = null,
    val error: String = ""
)
