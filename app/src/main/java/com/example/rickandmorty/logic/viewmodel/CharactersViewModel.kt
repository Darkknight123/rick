package com.example.rickandmorty.logic.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.logic.model.CharacterModels
import com.example.rickandmorty.logic.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _characters = MutableLiveData<List<CharacterModels>>()
    val characters: LiveData<List<CharacterModels>> = _characters

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val result = repository.getCharacters()
                _characters.value = result
            } catch (e: Exception) {
                // Handle errors (e.g., show an error message)
                _characters.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
