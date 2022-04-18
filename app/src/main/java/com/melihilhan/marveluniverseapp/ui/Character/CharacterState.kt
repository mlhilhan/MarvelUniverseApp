package com.melihilhan.marveluniverseapp.ui.Character

import com.melihilhan.marveluniverseapp.domain.model.Character

data class CharacterState(
    val isLoading : Boolean = false,
    val characterDetail : List<Character> = emptyList(),
    val error : String = ""
)