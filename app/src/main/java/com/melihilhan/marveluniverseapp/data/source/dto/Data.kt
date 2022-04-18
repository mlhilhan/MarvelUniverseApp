package com.melihilhan.marveluniverseapp.data.source.dto

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)