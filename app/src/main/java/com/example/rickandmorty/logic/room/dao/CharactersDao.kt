package com.example.rickandmorty.logic.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.logic.model.CharacterEntity

@Dao
interface CharactersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<CharacterEntity?>)

    @Query("SELECT * FROM characters")
    suspend fun getCharacters(): List<CharacterEntity>
}
