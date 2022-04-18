package com.melihilhan.marveluniverseapp.data.repository

import com.melihilhan.marveluniverseapp.data.source.MarvelApi
import com.melihilhan.marveluniverseapp.data.source.dto.CharactersDTO
import com.melihilhan.marveluniverseapp.domain.repository.MarvelRepository
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val api: MarvelApi
): MarvelRepository {
    override suspend fun getAllCharacter(offset: String): CharactersDTO {
        return api.getAllCharacters(offset = offset.toString())
    }

    override suspend fun getAllSearchedCharacters(search: String): CharactersDTO {
        return api.getAllSearchedCharacters(search = search)
    }

    override suspend fun getCharacterById(id: String): CharactersDTO {
        return api.getCharacterById(id)
    }
}