package com.example.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rickandmorty.ui.screens.CharacterModels
import com.example.rickandmorty.ui.screens.CharacterScreen
import com.example.rickandmorty.ui.screens.CharactersItem

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val items = CharacterModels()
            CharacterScreen(listOf(items) )
        }
    }
}

