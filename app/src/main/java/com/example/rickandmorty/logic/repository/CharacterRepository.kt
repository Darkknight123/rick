package com.example.rickandmorty.logic.repository

import com.example.rickandmorty.logic.model.CharacterModels
import com.example.rickandmorty.logic.webservice.CharactersApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(
    private val characterApi: CharactersApi
) {
    suspend fun getCharacters(): List<CharacterModels> {
        return characterApi.getCharacters().results
    }
}