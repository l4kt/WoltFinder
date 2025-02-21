package com.l4kt.woltfinder.data.repository

import com.l4kt.woltfinder.data.model.Item
import com.l4kt.woltfinder.data.api.ApiService
import com.l4kt.woltfinder.data.api.RetrofitInstance

open class Repository(private val apiService: ApiService = RetrofitInstance.api) {
    open suspend fun fetchItems(lat: Double, lon: Double): List<Item> {
        val response = apiService.getVenues(lat, lon)
        return response.sections.flatMap { section ->
            section.items.filter { it.venue != null && it.image != null }
        }.take(15)
    }
}
