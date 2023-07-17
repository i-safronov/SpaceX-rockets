package com.safronov.domain.model.rocket_launch

data class Links(
    val article: String,
    val flickr: Flickr,
    val patch: Patch,
    val presskit: String,
    val reddit: Reddit,
    val webcast: String,
    val wikipedia: String,
    val youtube_id: String
)