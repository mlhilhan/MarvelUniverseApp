package com.melihilhan.marveluniverseapp.domain.use_cases

import com.melihilhan.marveluniverseapp.domain.model.Character
import com.melihilhan.marveluniverseapp.domain.repository.MarvelRepository
import com.melihilhan.marveluniverseapp.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchCharactersUseCase @Inject constructor(
    private val repository: MarvelRepository
) {
    operator fun invoke(search: String): Flow<Response<List<Character>>> = flow {
        try {
            emit(Response.Loading<List<Character>>())
            val list = repository.getAllSearchedCharacters(search).data.results.map {
                it.toCharacter()
            }
            emit(Response.Success<List<Character>>(list))
        }
        catch (e: HttpException) {
            emit(Response.Error<List<Character>>(e.printStackTrace().toString()))
        }
        catch (e: IOException) {
            emit(Response.Error<List<Character>>(e.printStackTrace().toString()))
        }
    }
}