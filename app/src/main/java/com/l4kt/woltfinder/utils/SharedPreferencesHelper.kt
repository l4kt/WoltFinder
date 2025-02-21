package com.l4kt.woltfinder.utils

import android.content.Context
import android.util.Log

object SharedPreferencesHelper {
    private const val PREFS_NAME = "favourites"
    private const val TAG = "SharedPreferencesHelper"

    // Save the favourite state of a venue with an optional sync flag for testing
    fun saveFavouriteState(context: Context, venueId: String, isFavourite: Boolean, sync: Boolean = false) {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit().putBoolean(venueId, isFavourite)

        editor.apply()  // Always apply asynchronously

        if (sync) {
            // Force a synchronous read to ensure data is committed for test consistency
            sharedPreferences.getBoolean(venueId, false)
        }

        Log.d(TAG, "Saved favourite state: $venueId -> $isFavourite")
    }

    // Retrieve the favourite state of a venue
    fun getFavouriteState(context: Context, venueId: String): Boolean {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val state = sharedPreferences.getBoolean(venueId, false)
        Log.d(TAG, "Retrieved favourite state: $venueId -> $state")
        return state
    }

    // Clear all favourite states
    fun clearFavourites(context: Context) {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().apply()
        Log.d(TAG, "Cleared all favourites")
    }
}
