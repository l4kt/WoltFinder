package com.l4kt.woltfinder.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WoltAppBar() {
    Surface(
        shape = RoundedCornerShape(bottomEnd = 24.dp, bottomStart = 24.dp),
        elevation = 8.dp,
        color = MaterialTheme.colors.primary,
    ) {
        TopAppBar(
            modifier = Modifier.height(48.dp),
            title = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "WoltFinder",
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
        )
    }
}

