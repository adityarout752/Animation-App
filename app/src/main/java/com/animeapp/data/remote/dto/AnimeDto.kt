package com.animeapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AnimeListResponse(
    @SerializedName("data")
    val data: List<AnimeDto>,
    @SerializedName("pagination")
    val pagination: PaginationDto?
)

data class AnimeDetailResponse(
    @SerializedName("data")
    val data: AnimeDto
)

data class AnimeDto(
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("title_english")
    val titleEnglish: String?,
    @SerializedName("images")
    val images: ImagesDto?,
    @SerializedName("trailer")
    val trailer: TrailerDto?,
    @SerializedName("synopsis")
    val synopsis: String?,
    @SerializedName("score")
    val score: Double?,
    @SerializedName("episodes")
    val episodes: Int?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("genres")
    val genres: List<GenreDto>?,
    @SerializedName("studios")
    val studios: List<StudioDto>?,
    @SerializedName("aired")
    val aired: AiredDto?,
    @SerializedName("rating")
    val rating: String?,
    @SerializedName("rank")
    val rank: Int?,
    @SerializedName("popularity")
    val popularity: Int?
)

data class ImagesDto(
    @SerializedName("jpg")
    val jpg: ImageUrlDto?,
    @SerializedName("webp")
    val webp: ImageUrlDto?
)

data class ImageUrlDto(
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("small_image_url")
    val smallImageUrl: String?,
    @SerializedName("large_image_url")
    val largeImageUrl: String?
)

data class TrailerDto(
    @SerializedName("youtube_id")
    val youtubeId: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("embed_url")
    val embedUrl: String?
)

data class GenreDto(
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

data class StudioDto(
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

data class AiredDto(
    @SerializedName("from")
    val from: String?,
    @SerializedName("to")
    val to: String?,
    @SerializedName("string")
    val string: String?
)

data class PaginationDto(
    @SerializedName("last_visible_page")
    val lastVisiblePage: Int,
    @SerializedName("has_next_page")
    val hasNextPage: Boolean
)
