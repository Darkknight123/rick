package com.example.rickandmorty.logic.webservice

import com.example.rickandmorty.logic.model.ApiResponse
import com.example.rickandmorty.logic.model.CharacterModels
import retrofit2.http.GET

interface CharactersApi {

    @GET("character")
    suspend fun getCharacters(): ApiResponse<CharacterModels>
}