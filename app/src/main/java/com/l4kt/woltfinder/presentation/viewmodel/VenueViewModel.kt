package com.l4kt.woltfinder.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.l4kt.woltfinder.data.model.Item
import com.l4kt.woltfinder.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class VenueViewModel(private var repository: Repository = Repository()) : ViewModel() {

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items

    private val _isLoading = MutableStateFlow(true)  // Initially true to show the loading indicator
    val isLoading: StateFlow<Boolean> = _isLoading

    private var firstLoad = true  // Track if it's the first load

    fun updateLocation(latitude: Double, longitude: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = firstLoad  // Show loading only for the first update

            try {
                val venues = repository.fetchItems(lat = latitude, lon = longitude)
                _items.emit(venues.take(15))  // Get the first 15 venues

                if (firstLoad) {
                    firstLoad = false  // Disable loading after first fetch
                }
            } catch (e: Exception) {
                Log.e("VenueViewModel", "Error fetching venues", e)
            } finally {
                _isLoading.value = false  // Ensure loading is hidden after first fetch
            }
        }
    }
}
