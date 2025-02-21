package com.l4kt.woltfinder.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import com.l4kt.woltfinder.data.model.Venue
import com.l4kt.woltfinder.data.model.Image
import com.l4kt.woltfinder.utils.SharedPreferencesHelper

@Composable
fun VenueItem(venue: Venue, image: Image?) {
    val context = LocalContext.current
    val isFavourite = remember { mutableStateOf(SharedPreferencesHelper.getFavouriteState(context, venue.id)) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("venue_item_${venue.id}")
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .shadow(4.dp, RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colors.surface)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2.5f / 1f)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                    .testTag("venue_name_${venue.id}")
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = image?.url ?: "https://hds.hel.fi/images/foundation/visual-assets/placeholders/image-xl@3x.png"
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                IconButton(
                    onClick = {
                        val newFavouriteState = !isFavourite.value
                        isFavourite.value = newFavouriteState
                        SharedPreferencesHelper.saveFavouriteState(context, venue.id, newFavouriteState)

                        Toast.makeText(
                            context,
                            if (isFavourite.value) "Added to Favourites" else "Removed from Favourites",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .size(36.dp)
                        .testTag("favourite_icon_${venue.id}")
                ) {
                    Icon(
                        imageVector = if (isFavourite.value) FavoriteIcons.BoldFavoriteFilled else FavoriteIcons.BoldFavoriteOutlined,
                        contentDescription = if (isFavourite.value) "Removed from favourites" else "Added to favourites",
                        tint = Color.Unspecified
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = venue.name,
                    style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Medium),
                    color = MaterialTheme.colors.onSurface,
                    maxLines = 1,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = venue.short_description,
                    style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Light),
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                    maxLines = 2,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
            }
        }
    }
}

