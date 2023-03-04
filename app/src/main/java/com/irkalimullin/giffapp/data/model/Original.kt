package com.irkalimullin.giffapp.data.model

/**
 * Объект, содержащий информацию и ссылки на медиа файлы гифки
 */
data class Original(
    var height: String? = null,
    var width: String? = null,
    var size: String? = null,
    var url: String? = null,
    var mp4Size: String? = null,
    var mp4: String? = null,
    var webpSize: String? = null,
    var webp: String? = null,
    var frames: String? = null,
    var hash: String? = null
)
