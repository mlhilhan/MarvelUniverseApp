package com.melihilhan.marveluniverseapp.data.source.dto

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<İtem>,
    val returned: Int
)