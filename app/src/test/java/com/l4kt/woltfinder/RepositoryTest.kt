package com.l4kt.woltfinder

import com.l4kt.woltfinder.data.api.ApiService
import com.l4kt.woltfinder.data.model.ApiResponse
import com.l4kt.woltfinder.data.model.Image
import com.l4kt.woltfinder.data.model.Item
import com.l4kt.woltfinder.data.model.Section
import com.l4kt.woltfinder.data.model.Venue
import com.l4kt.woltfinder.data.repository.Repository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class RepositoryTest {

    private val mockApiService = FakeApiService()
    private val repository = Repository(mockApiService)

    @Test
    fun test_fetchItems_returnsOnlyFirst15Venues() = runBlocking {
        // Execute the repository function
        val items = repository.fetchItems(60.169418, 24.931618)

        // Assertions to check if only the first 15 items are returned
        assertEquals(15, items.size)
        assertEquals("Venue 1", items[0].venue?.name)
        assertEquals("Venue 15", items[14].venue?.name)
    }
}

class FakeApiService : ApiService {
    override suspend fun getVenues(lat: Double, lon: Double): ApiResponse {
        val mockVenues = (1..20).map { i ->
            Item(
                venue = Venue(
                    id = i.toString(),
                    name = "Venue $i",
                    short_description = "Description $i",
                    image = Image(url = "https://example.com/image$i.jpg")
                ),
                image = Image(url = "https://example.com/image$i.jpg")
            )
        }
        return ApiResponse(sections = listOf(Section(items = mockVenues)))
    }
}
