package com.melihilhan.marveluniverseapp.data.source.dto

data class CharactersDTO(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)