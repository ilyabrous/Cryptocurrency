package com.example.courseaplc.domain.use_case.get_ohlcv

import com.example.courseaplc.common.Resourсe
import com.example.courseaplc.data.remote.dto.CoinDetailDto.toCoinDetail
import com.example.courseaplc.data.remote.dto.CoinOhlcvDto.toCoinOhlcv
import com.example.courseaplc.domain.model.CoinDetail
import com.example.courseaplc.domain.model.CoinOhlcv
import com.example.courseaplc.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinOhlcvUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String) : Flow<Resourсe<CoinOhlcv>> = flow {
        try{
            emit(Resourсe.Loading<CoinOhlcv>())
            val coins = repository.getOhlcvTodayById(coinId = coinId)
            if(!coins.isEmpty()) emit(Resourсe.Success<CoinOhlcv>(coins[0].toCoinOhlcv()))
            else emit(Resourсe.Error<CoinOhlcv>("No data!"))
        } catch (e: HttpException) {
            emit(Resourсe.Error<CoinOhlcv>(e.localizedMessage ?: "Unexpected error!"))
        } catch (e: IOException){
            emit(Resourсe.Error<CoinOhlcv>(e.localizedMessage ?: "Couldn't reach connection. Check your internet connection"))
        }

    }

}