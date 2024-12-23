package com.example.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.rickandmorty.logic.model.CharacterModels
import com.example.rickandmorty.ui.screens.CharacterScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val items = listOf(
                CharacterModels(1,"Item 1", "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
                CharacterModels(2,"Item 2", "https://rickandmortyapi.com/api/character/avatar/2.jpeg"),
                CharacterModels(3,"Item 3", "https://rickandmortyapi.com/api/character/avatar/3.jpeg")
            )
            CharacterScreen( )
        }
    }
}

