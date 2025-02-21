package com.l4kt.woltfinder.presentation.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import com.l4kt.woltfinder.presentation.viewmodel.VenueViewModel

@Composable
fun VenueListScreen(viewModel: VenueViewModel) {
    val items by viewModel.items.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    // Remember the scroll state and maintain it across recompositions
    val listState = rememberLazyListState()

    AnimatedContent(
        targetState = isLoading to items,
        transitionSpec = {
            fadeIn(tween(300)) togetherWith fadeOut(tween(300))
        }
    ) { (loading, updatedItems) ->
        if (loading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(50.dp),
                    color = MaterialTheme.colors.primary
                )
            }
        } else {
            // Pass the remembered scroll state to VenueList
            VenueList(items = updatedItems, listState = listState)
        }
    }
}
