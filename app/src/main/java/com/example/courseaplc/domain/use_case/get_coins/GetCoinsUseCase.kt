package com.example.courseaplc.domain.use_case.get_coins

import com.example.courseaplc.common.Resourсe
import com.example.courseaplc.data.remote.dto.CoinDto.toCoin

import com.example.courseaplc.domain.model.Coin
import com.example.courseaplc.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class   GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke() : Flow<Resourсe<List<Coin>>> = flow {
       try{
           emit(Resourсe.Loading<List<Coin>>())
           val coins = repository.getCoins().map { it.toCoin() }
           emit(Resourсe.Success<List<Coin>>(coins))
       } catch (e: HttpException) {
           emit(Resourсe.Error<List<Coin>>(e.localizedMessage ?: "Unexpected error!"))
       } catch (e: IOException){
           emit(Resourсe.Error<List<Coin>>(e.localizedMessage ?: "Couldn't reach connection. Check your internet connection"))
       }




    }

}