package com.example.courseaplc.presentation.coin_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.courseaplc.common.Constants
import com.example.courseaplc.common.Resourсe
import com.example.courseaplc.domain.model.CoinOhlcv
import com.example.courseaplc.domain.use_case.get_coin.GetCoinUseCase
import com.example.courseaplc.domain.use_case.get_ohlcv.GetCoinOhlcvUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    private val getCoinOhlcvUseCase: GetCoinOhlcvUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val TAG = CoinDetailViewModel::class.java.name

    private val _state = mutableStateOf(CoinDetailState())
    val state : State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId = coinId)
        }
    }



    private fun getCoin(coinId: String){


        val coinUseCaseFlow = getCoinUseCase(coinId = coinId)
        val coinOhlcvUseCaseFlow = getCoinOhlcvUseCase(coinId = coinId)

        coinUseCaseFlow.combine(coinOhlcvUseCaseFlow) { resultCase, resultOhlcv ->
            if(resultCase is Resourсe.Success && resultOhlcv is Resourсe.Success) {
                _state.value = CoinDetailState(coin = resultCase.data, ohlcv = resultOhlcv.data)
            }
            if(resultCase is Resourсe.Error) {
                _state.value = CoinDetailState(error = resultCase.message ?: "Unexpected Error!")
            }
            if(resultCase is Resourсe.Loading) {
                _state.value = CoinDetailState(isLoading = true)
            }
            if(resultOhlcv is Resourсe.Error) {
                _state.value = CoinDetailState(error = resultOhlcv.message!!)
            }
        }.launchIn(viewModelScope)

    }
}


