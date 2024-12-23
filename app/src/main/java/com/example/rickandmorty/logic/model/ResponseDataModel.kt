package com.example.rickandmorty.logic.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// Response data model
data class ApiResponse<T>(
    val results: List<T>
)

data class CharacterModels(
    val id: Int? = null,
    val name: String? = null,
    val image: String? = null
)

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val image: String
)
