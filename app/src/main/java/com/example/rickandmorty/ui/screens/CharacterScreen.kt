package com.example.rickandmorty.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CharacterScreen(items : List<CharacterModels>) {
    val columns = 2
    LazyVerticalGrid(columns = GridCells.Fixed(columns),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(items.size){ index ->
            val item = items.getOrNull(index)
            if (item != null) {
                CharactersItem(item = item)
            }
        }
    }
}



data class CharacterModels(
    val name: String? = null,
    val imageUrl: String? = null
)