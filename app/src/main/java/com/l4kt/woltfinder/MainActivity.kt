package com.l4kt.woltfinder

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.l4kt.woltfinder.presentation.ui.VenueListScreen
import com.l4kt.woltfinder.presentation.ui.WoltAppBar
import com.l4kt.woltfinder.presentation.ui.WoltFinderTheme
import com.l4kt.woltfinder.presentation.viewmodel.VenueViewModel
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WoltFinderTheme {
                val viewModel: VenueViewModel = viewModel()
                Scaffold(
                    topBar = { WoltAppBar() },
                    content = { innerPadding ->
                        Column(modifier = Modifier.padding(innerPadding)) {
                            // Automatically update location every 10 seconds
                            LaunchedEffect(Unit) {
                                val locations = listOf(
                                    Pair(60.169418, 24.931618),
                                    Pair(60.169818, 24.932906),
                                    Pair(60.170005, 24.935105),
                                    Pair(60.169108, 24.936210),
                                    Pair(60.168355, 24.934869),
                                    Pair(60.167560, 24.932562),
                                    Pair(60.168254, 24.931532),
                                    Pair(60.169012, 24.930341),
                                    Pair(60.170085, 24.929569)
                                )

                                var index = 0
                                while (true) {
                                    val currentLocation = locations[index]
                                    Log.d(
                                        "MainActivity",
                                        "Switching to location: lat=${currentLocation.first}, lon=${currentLocation.second}")

                                    viewModel.updateLocation(
                                        latitude = currentLocation.first,
                                        longitude = currentLocation.second
                                    )
                                    index = (index + 1) % locations.size
                                    delay(10000) // Wait for 10 seconds
                                }
                            }

                            // Venue list screen
                            VenueListScreen(viewModel = viewModel)
                        }
                    }
                )
            }
        }
    }
}
