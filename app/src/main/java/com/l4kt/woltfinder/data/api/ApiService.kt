package com.l4kt.woltfinder.data.api

import com.l4kt.woltfinder.data.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/pages/restaurants")
    suspend fun getVenues(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
    ): ApiResponse
}
