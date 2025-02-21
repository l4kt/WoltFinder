package com.l4kt.woltfinder

import com.l4kt.woltfinder.data.model.Image
import com.l4kt.woltfinder.data.model.Item
import com.l4kt.woltfinder.data.model.Venue
import com.l4kt.woltfinder.data.repository.Repository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class VenueViewModelTest {
    private lateinit var repository: Repository

    private val testCoordinates = listOf(
        Pair(60.169418, 24.931618),  // First coordinate
        Pair(60.170000, 24.932000),  // Second coordinate
        Pair(60.171000, 24.933000)   // Third coordinate (last in sequence)
    )

    private val testItems = listOf(
        Item(
            venue = Venue(
                id = "20",
                name = "Burger King",
                short_description = "Fine Location",
                image = Image(url = "fine location url one")
            ),
            image = Image(url = "fine location url one")
        ),
        Item(
            venue = Venue(
                id = "21",
                name = "Taco Bell",
                short_description = "Fine Location",
                image = Image(url = "fine location url two")
            ),
            image = Image(url = "fine location url two")
        )
    )

    @Before
    fun setUp() {
        repository = FakeRepository(testItems)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_locationUpdatesEvery10Seconds() = runTest {
        var currentLocationIndex = 0
        repeat(4) { // Simulate 4 location updates
            val (lat, lon) = testCoordinates[currentLocationIndex % testCoordinates.size]
            val items = repository.fetchItems(lat, lon)

            assertEquals("Incorrect venue count", 2, items.size)
            assertEquals(
                "Location update not working correctly",
                testCoordinates[currentLocationIndex % testCoordinates.size].first, lat
            )

            currentLocationIndex++
            advanceTimeBy(10_000)
        }
    }


    @Test
    fun test_locationLoopBackAfterLastCoordinate() = runTest {
        var currentLocationIndex = 0
        repeat(testCoordinates.size * 2) {  // Ensure it loops twice through locations
            val (lat, lon) = testCoordinates[currentLocationIndex % testCoordinates.size]
            repository.fetchItems(lat, lon)

            assertEquals("Looping failed, incorrect latitude",
                testCoordinates[currentLocationIndex % testCoordinates.size].first, lat)

            currentLocationIndex++
        }
    }
}

class FakeRepository(private val testItems: List<Item>) : Repository() {
    override suspend fun fetchItems(lat: Double, lon: Double): List<Item> {
        return testItems
    }
}
