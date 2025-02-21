package com.l4kt.woltfinder

import com.l4kt.woltfinder.data.api.ApiService
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var apiService: ApiService

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Test
    fun testGetVenues() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setBody("""
                    {
                        "sections": [
                            {
                                "items": [
                                    {
                                        "venue": {
                                            "name": "Test Venue"
                                        },
                                        "image": null
                                    }
                                ]
                            }
                        ]
                    }
                """.trimIndent())
                .setResponseCode(200)
        )

        val response = apiService.getVenues(lat = 60.1699, lon = 24.9384)

        assertEquals("Test Venue", response.sections.first().items.first().venue?.name)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

}
