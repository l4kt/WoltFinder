package com.l4kt.woltfinder.data.model

data class ApiResponse(
    val sections: List<Section>
)

data class Section(
    val items: List<Item>
)

data class Item(
    val venue: Venue?,
    val image: Image?
)
