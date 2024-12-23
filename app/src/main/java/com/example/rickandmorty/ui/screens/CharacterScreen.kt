package com.example.rickandmorty.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rickandmorty.logic.viewmodel.CharacterViewModel

@Composable
fun CharacterScreen(
    viewModel: CharacterViewModel = hiltViewModel()
) {
    val items by viewModel.characters.observeAsState(emptyList())
    val isLoading by viewModel.isLoading.observeAsState(true)

    Column(modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Characters",
            fontSize = 20.sp,
            color = Color.Black
        )

        val columns = 2
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(columns),
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            if (isLoading) {
                // Show shimmer placeholders while loading
                items(10) { ShimmerPlaceholder() }
            } else {
                // Display the fetched character items
                items(items.size) { index ->
                    val item = items.getOrNull(index)
                    if (item != null) {
                        CharactersItem(item = item)
                    }
                }
            }
        }
    }
}

