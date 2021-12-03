package com.example.courseaplc.domain.use_case.get_coin

import com.example.courseaplc.common.Resourсe
import com.example.courseaplc.data.remote.dto.CoinDetailDto.toCoinDetail
import com.example.courseaplc.domain.model.CoinDetail
import com.example.courseaplc.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String) : Flow<Resourсe<CoinDetail>> = flow {
       try{
           emit(Resourсe.Loading<CoinDetail>())
           val coins = repository.getCoinById(coinId = coinId).toCoinDetail()
           emit(Resourсe.Success<CoinDetail>(coins))
       } catch (e: HttpException) {
           emit(Resourсe.Error<CoinDetail>(e.localizedMessage ?: "Unexpected error!"))
       } catch (e: IOException){
           emit(Resourсe.Error<CoinDetail>(e.localizedMessage ?: "Couldn't reach connection. Check your internet connection"))
       }

    }

}