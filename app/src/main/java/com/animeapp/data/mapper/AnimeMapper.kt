package com.animeapp.data.mapper

import com.animeapp.data.local.entity.AnimeEntity
import com.animeapp.data.remote.dto.AnimeDto
import com.animeapp.domain.model.Anime

fun AnimeDto.toAnimeEntity(): AnimeEntity {
    return AnimeEntity(
        malId = malId,
        title = title,
        titleEnglish = titleEnglish,
        imageUrl = images?.jpg?.largeImageUrl ?: images?.jpg?.imageUrl,
        trailerUrl = trailer?.embedUrl ?: trailer?.url,
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
    return Anime(
        malId = malId,
        title = title,
        titleEnglish = titleEnglish,
        imageUrl = images?.jpg?.largeImageUrl ?: images?.jpg?.imageUrl,
        trailerUrl = trailer?.embedUrl ?: trailer?.url,
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
