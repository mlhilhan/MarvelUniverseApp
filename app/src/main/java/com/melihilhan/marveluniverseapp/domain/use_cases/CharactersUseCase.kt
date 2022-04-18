package com.melihilhan.marveluniverseapp.domain.use_cases

import com.melihilhan.marveluniverseapp.domain.model.Character
import com.melihilhan.marveluniverseapp.domain.repository.MarvelRepository
import com.melihilhan.marveluniverseapp.util.Response
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CharactersUseCase @Inject constructor(
    private val repository: MarvelRepository
) {
    operator fun invoke(offset: String): Flow<Response<List<Character>>> = flow {
        try {
            emit(Response.Loading<List<Character>>())
            val list = repository.getAllCharacter(offset = offset).data.results.map {
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