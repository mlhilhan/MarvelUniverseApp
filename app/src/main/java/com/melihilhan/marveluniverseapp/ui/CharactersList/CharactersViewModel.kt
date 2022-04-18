package com.melihilhan.marveluniverseapp.ui.CharactersList

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.melihilhan.marveluniverseapp.domain.use_cases.CharactersUseCase
import com.melihilhan.marveluniverseapp.domain.use_cases.SearchCharacterCase
import com.melihilhan.marveluniverseapp.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val characterUseCase: CharactersUseCase,
    private val searchCharacterCase : SearchCharacterCase
): ViewModel() {
    private val marvelValue = MutableStateFlow(MarvelListState())
    var _marvelValue: StateFlow<MarvelListState> = marvelValue

    fun getSearchedCharacters(search:String)=viewModelScope.launch(Dispatchers.IO){
        searchCharacterCase.invoke(search=search).collect {
            when(it){
                is State.Success ->{
                    marvelValue.value = MarvelListState(characterList = it.data?: emptyList())
                    Log.d("toCharacter",_marvelValue.value.toString())
                }
                is State.Loading ->{
                    marvelValue.value = MarvelListState(isLoading = true)
                    Log.d("loading",it.data.toString())
                }
                is State.Error ->{
                    marvelValue.value = MarvelListState(error = it.message?:"An Unexpected Error")
                    Log.d("Error",it.data.toString())
                }
            }
        }
    }

    fun getAllCharactersData(offset:Int)=viewModelScope.launch(Dispatchers.IO){
        characterUseCase(offset.toString()).collect {
            when(it){
                is State.Success<*> ->{
                    marvelValue.value = MarvelListState(characterList = it.data?: emptyList())
                    Log.d("toCharacter",_marvelValue.value.toString())
                }
                is State.Loading<*> ->{
                    marvelValue.value = MarvelListState(isLoading = true)
                    Log.d("loading",it.data.toString())
                }
                is State.Error<*> ->{
                    marvelValue.value = MarvelListState(error = it.message?:"An Unexpected Error")
                    Log.d("Error",it.data.toString())
                }
            }
        }
    }
}