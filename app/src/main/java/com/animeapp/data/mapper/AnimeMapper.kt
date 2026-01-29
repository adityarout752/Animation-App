package com.animeapp.data.mapper

import com.animeapp.data.local.entity.AnimeEntity
import com.animeapp.data.remote.dto.AnimeDto
import com.animeapp.domain.model.Anime

fun AnimeDto.toAnimeEntity(): AnimeEntity {
    // Extract YouTube ID from various URL formats
    val youtubeId = trailer?.youtubeId ?: run {
        val urlToSearch = trailer?.embedUrl ?: trailer?.url ?: ""
        // Match youtube-nocookie.com/embed/ID, youtube.com/embed/ID, youtube.com/watch?v=ID, or youtu.be/ID
        val idPattern = """(?:youtube(?:-nocookie)?\.com/embed/|youtu\.be/|youtube\.com/watch\?v=)([a-zA-Z0-9_-]{11})""".toRegex()
        idPattern.find(urlToSearch)?.groupValues?.getOrNull(1)
    }

    // Build YouTube watch URL from ID (for direct playback attempts, though YouTube videos need special handling)
    val trailerUrl = if (youtubeId != null) "https://www.youtube.com/embed/$youtubeId" else null

    return AnimeEntity(
        malId = malId,
        title = title,
        titleEnglish = titleEnglish,
        imageUrl = images?.jpg?.largeImageUrl ?: images?.jpg?.imageUrl,
        trailerUrl = trailerUrl,
        synopsis = synopsis,
        score = score,
        episodes = episodes,
        status = status,
        genres = genres?.map { it.name } ?: emptyList(),
        studios = studios?.map { it.name } ?: emptyList(),
        aired = aired?.string,
        rating = rating,
        rank = rank,
        popularity = popularity,
        isFavorite = false
    )
}

fun AnimeEntity.toAnime(): Anime {
    return Anime(
        malId = malId,
        title = title,
        titleEnglish = titleEnglish,
        imageUrl = imageUrl,
        trailerUrl = trailerUrl,
        synopsis = synopsis,
        score = score,
        episodes = episodes,
        status = status,
        genres = genres,
        studios = studios,
        aired = aired,
        rating = rating,
        rank = rank,
        popularity = popularity,
        isFavorite = isFavorite
    )
}

fun Anime.toAnimeEntity(): AnimeEntity {
    return AnimeEntity(
        malId = malId,
        title = title,
        titleEnglish = titleEnglish,
        imageUrl = imageUrl,
        trailerUrl = trailerUrl,
        synopsis = synopsis,
        score = score,
        episodes = episodes,
        status = status,
        genres = genres,
        studios = studios,
        aired = aired,
        rating = rating,
        rank = rank,
        popularity = popularity,
        isFavorite = isFavorite
    )
}

fun AnimeDto.toAnime(): Anime {
    // Extract YouTube ID from various URL formats
    val youtubeId = trailer?.youtubeId ?: run {
        val urlToSearch = trailer?.embedUrl ?: trailer?.url ?: ""
        // Match youtube-nocookie.com/embed/ID, youtube.com/embed/ID, youtube.com/watch?v=ID, or youtu.be/ID
        val idPattern = """(?:youtube(?:-nocookie)?\.com/embed/|youtu\.be/|youtube\.com/watch\?v=)([a-zA-Z0-9_-]{11})""".toRegex()
        idPattern.find(urlToSearch)?.groupValues?.getOrNull(1)
    }

    // Build YouTube embed URL from ID
    val trailerUrl = if (youtubeId != null) "https://www.youtube.com/embed/$youtubeId" else null

    return Anime(
        malId = malId,
        title = title,
        titleEnglish = titleEnglish,
        imageUrl = images?.jpg?.largeImageUrl ?: images?.jpg?.imageUrl,
        trailerUrl = trailerUrl,
        synopsis = synopsis,
        score = score,
        episodes = episodes,
        status = status,
        genres = genres?.map { it.name } ?: emptyList(),
        studios = studios?.map { it.name } ?: emptyList(),
        aired = aired?.string,
        rating = rating,
        rank = rank,
        popularity = popularity,
        isFavorite = false
    )
}
