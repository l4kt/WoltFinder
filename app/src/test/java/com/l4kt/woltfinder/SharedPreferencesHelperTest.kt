package com.l4kt.woltfinder

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.l4kt.woltfinder.utils.SharedPreferencesHelper
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34], manifest = Config.NONE)
class SharedPreferencesHelperTest {

    private lateinit var context: Context

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
        SharedPreferencesHelper.clearFavourites(context)  // Ensure clean state before tests
    }

    @Test
    fun test_saveAndRetrieveFavouriteState() {
        val venueId = "venue_123"

        assertFalse("Initial state should be false",
            SharedPreferencesHelper.getFavouriteState(context, venueId)
        )

        // Save favourite state
        SharedPreferencesHelper.saveFavouriteState(context, venueId, true, sync = true)

        // Retrieve the saved state and verify
        assertTrue("Venue should be marked as favourite",
            SharedPreferencesHelper.getFavouriteState(context, venueId)
        )
    }

    @Test
    fun test_favouriteStatePersistenceAcrossCalls() {
        val venueId = "venue_456"

        SharedPreferencesHelper.saveFavouriteState(context, venueId, true, sync = true)
        assertTrue(SharedPreferencesHelper.getFavouriteState(context, venueId))

        SharedPreferencesHelper.saveFavouriteState(context, venueId, false, sync = true)
        assertFalse(SharedPreferencesHelper.getFavouriteState(context, venueId))
    }

    @Test
    fun test_clearFavourites() {
        val venueId = "venue_789"

        // Save some data
        SharedPreferencesHelper.saveFavouriteState(context, venueId, true, sync = true)
        assertTrue(SharedPreferencesHelper.getFavouriteState(context, venueId))

        // Clear all preferences and check if cleared
        SharedPreferencesHelper.clearFavourites(context)
        assertFalse(SharedPreferencesHelper.getFavouriteState(context, venueId))
    }
}
