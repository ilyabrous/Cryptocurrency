package com.example.courseaplc.domain.model

import com.example.courseaplc.data.remote.dto.CoinDetailDto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
) {
}