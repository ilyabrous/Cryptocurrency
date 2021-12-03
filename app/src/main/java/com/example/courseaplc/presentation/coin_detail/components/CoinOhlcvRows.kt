package com.example.courseaplc.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.courseaplc.domain.model.CoinOhlcv

@Composable
fun CoinOhlcvRows(
    ohlcv: CoinOhlcv,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Time open",
            style = MaterialTheme.typography.h4,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = ohlcv.timeOpen,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )
    }
    Divider()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Time close",
            style = MaterialTheme.typography.h4,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = ohlcv.timeClose,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )

    }
    Divider()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Open",
            style = MaterialTheme.typography.h4,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "$" + ohlcv.open.toString(),
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )

    }
    Divider()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "High",
            style = MaterialTheme.typography.h4,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "$" + ohlcv.high.toString(),
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )

    }
    Divider()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Low",
            style = MaterialTheme.typography.h4,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "$" + ohlcv.low.toString(),
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )

    }
    Divider()
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Close",
            style = MaterialTheme.typography.h4,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "$" + ohlcv.close.toString(),
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )

    }
    Divider()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Volume",
            style = MaterialTheme.typography.h4,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "$" + ohlcv.volume.toString(),
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )

    }
    Divider()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Market capacity",
            style = MaterialTheme.typography.h4,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "$" + ohlcv.marketCap.toString(),
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )

    }
    Divider()
}
