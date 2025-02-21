package com.l4kt.woltfinder.presentation.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.vector.ImageVector.Builder

object FavoriteIcons {
    val BoldFavoriteOutlined: ImageVector
        get() {
            return Builder(
                name = "BoldFavoriteOutlined",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f
            ).apply {
                path(
                    fill = SolidColor(Color.Black.copy(alpha = 0.1f)),
                    stroke = SolidColor(Color.White),
                    strokeLineWidth = 2.9f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(12f, 21.35f)
                    lineToRelative(-1.45f, -1.32f)
                    curveTo(5.4f, 15.36f, 2f, 12.28f, 2f, 8.5f)
                    curveTo(2f, 5.42f, 4.42f, 3f, 7.5f, 3f)
                    curveTo(9.24f, 3f, 10.91f, 3.81f, 12f, 5.09f)
                    curveTo(13.09f, 3.81f, 14.76f, 3f, 16.5f, 3f)
                    curveTo(19.58f, 3f, 22f, 5.42f, 22f, 8.5f)
                    curveTo(22f, 12.28f, 18.6f, 15.36f, 13.45f, 19.04f)
                    lineToRelative(-1.45f, 1.31f)
                }
            }.build()
        }

    val BoldFavoriteFilled: ImageVector
        get() {
            return Builder(
                name = "BoldFavoriteFilled",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f
            ).apply {
                path(
                    fill = SolidColor(Color.White),
                    stroke = SolidColor(Color.White),
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(12f, 21.35f)
                    lineToRelative(-1.45f, -1.32f)
                    curveTo(5.4f, 15.36f, 2f, 12.28f, 2f, 8.5f)
                    curveTo(2f, 5.42f, 4.42f, 3f, 7.5f, 3f)
                    curveTo(9.24f, 3f, 10.91f, 3.81f, 12f, 5.09f)
                    curveTo(13.09f, 3.81f, 14.76f, 3f, 16.5f, 3f)
                    curveTo(19.58f, 3f, 22f, 5.42f, 22f, 8.5f)
                    curveTo(22f, 12.28f, 18.6f, 15.36f, 13.45f, 19.04f)
                    lineToRelative(-1.45f, 1.31f)
                }
            }.build()
        }
}

