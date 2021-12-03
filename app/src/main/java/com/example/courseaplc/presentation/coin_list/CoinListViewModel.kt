package com.example.courseaplc.presentation.coin_list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.courseaplc.common.Resourсe
import com.example.courseaplc.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase : GetCoinsUseCase
) : ViewModel() {

    private var _state = mutableStateOf(CoinListState())
    var state : State<CoinListState> = _state

    init {
        getCoins()
    }

    private val TAG = CoinListViewModel::class.java.name



    fun getCoins(){
        getCoinsUseCase().onEach { result ->
            when(result){
                is Resourсe.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resourсe.Error -> {
                    _state.value = CoinListState(error = result.message ?: "Unexpected Error!")
                }
                is Resourсe.Loading -> {
                   _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}