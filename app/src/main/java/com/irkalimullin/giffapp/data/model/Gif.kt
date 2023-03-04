package com.irkalimullin.giffapp.data.model

/**
 * Объект, содержащий информацию о гифке
 */
data class Gif(
    var type: String? = null,
    var id: String? = null,
    var url: String? = null,
    var slug: String? = null,
    var bitlyGifUrl: String? = null,
    var bitlyUrl: String? = null,
    var embedUrl: String? = null,
    var username: String = "No username",
    var source: String? = null,
    var title: String = "No title",
    var rating: String? = null,
    var contentUrl: String? = null,
    var sourceTld: String? = null,
    var sourcePostUrl: String? = null,
    var isSticker: Int? = null,
    var importDatetime: String? = null,
    var trendingDatetime: String? = null,
    var images: Images? = null,
    var user: User? = null,
    var analyticsResponsePayload: String? = null
)
