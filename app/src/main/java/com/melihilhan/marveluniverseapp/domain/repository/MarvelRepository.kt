package com.melihilhan.marveluniverseapp.domain.repository

import com.melihilhan.marveluniverseapp.data.source.dto.CharactersDTO

interface MarvelRepository {
    suspend fun getAllCharacter(offset: String): CharactersDTO
    suspend fun getAllSearchedCharacters(search: String): CharactersDTO
    suspend fun getCharacterById(id: String): CharactersDTO
}