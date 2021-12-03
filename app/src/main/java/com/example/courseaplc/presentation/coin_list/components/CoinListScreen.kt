package com.example.courseaplc.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.courseaplc.presentation.Screen
import com.example.courseaplc.presentation.coin_list.CoinListViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import okhttp3.internal.notifyAll

@Composable
fun CoinListScreen(
    navController: NavController, 
    viewModel: CoinListViewModel = hiltViewModel(),
    ) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(state.coins) { coin ->
                CoinListItem(
                    coin = coin,
                    onItemClick = {
                        navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")
                    })
            }
        }
        if(state.error.isNotBlank()) {
            Column(modifier =
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                )

             Spacer(modifier = Modifier.height(20.dp))

                Button(
                    shape = RoundedCornerShape(20.dp),
                    onClick = { viewModel.getCoins() }) {
                    Text(
                        text = "Try again!",
                        color = Color.White,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                    )
                }
            }

        }
        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}