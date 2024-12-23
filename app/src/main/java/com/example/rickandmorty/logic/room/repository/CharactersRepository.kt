package com.example.rickandmorty.logic.room.repository

import com.example.rickandmorty.logic.model.CharacterEntity
import com.example.rickandmorty.logic.model.CharacterModels
import com.example.rickandmorty.logic.room.dao.CharactersDao
import com.example.rickandmorty.logic.webservice.CharactersApi
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val characterApi: CharactersApi,
    private val characterDao: CharactersDao
) {
    suspend fun getCharacters(): List<CharacterModels> {
        val cached = characterDao.getCharacters()
        return if (cached.isNotEmpty()) {
            cached.map { CharacterModels(it.id, it.name, it.image) }
        } else {
            val result = characterApi.getCharacters().results
            result.map { it.id?.let { it1 ->
                it.name?.let { it2 ->
                    it.image?.let { it3 ->
                        CharacterEntity(
                            it1,
                            it2,
                            it3
                        )
                    }
                }
            } }.let { characterDao.insertCharacters(it) }
            result
        }
    }
}
