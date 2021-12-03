package com.example.courseaplc.domain.model

import com.google.gson.annotations.SerializedName

data class Coin(
    val id: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val name: String,
    val symbol: String,
    val rank: Int,
) {
}