package com.l4kt.woltfinder.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.l4kt.woltfinder.data.model.Item

@Composable
fun VenueList(items: List<Item>, listState: androidx.compose.foundation.lazy.LazyListState) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("venue_list"),
        state = listState,
        verticalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        items(items) { item ->
            item.venue?.let { VenueItem(venue = it, image = item.image) }
        }
    }
}

