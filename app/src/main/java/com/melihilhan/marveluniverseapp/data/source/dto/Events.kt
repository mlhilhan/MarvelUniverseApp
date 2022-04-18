package com.melihilhan.marveluniverseapp.data.source.dto

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<İtemX>,
    val returned: Int
)