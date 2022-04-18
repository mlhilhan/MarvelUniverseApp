package com.melihilhan.marveluniverseapp.ui.CharactersList

import com.melihilhan.marveluniverseapp.domain.model.Character

data class MarvelListState(
    val isLoading: Boolean = false,
    val characterList: List<Character> = emptyList(),
    val error: String = ""
)
