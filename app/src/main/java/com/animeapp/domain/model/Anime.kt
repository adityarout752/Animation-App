package com.animeapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val malId: Int,
    val title: String,
    val titleEnglish: String?,
    val imageUrl: String?,
    val trailerUrl: String?,
    val synopsis: String?,
    val score: Double?,
    val episodes: Int?,
    val status: String?,
    val genres: List<String>,
    val studios: List<String>,
    val aired: String?,
    val rating: String?,
    val rank: Int?,
    val popularity: Int?,
    val isFavorite: Boolean = false
) : Parcelable {
    fun getDisplayTitle(): String = titleEnglish ?: title
    
    fun getFormattedScore(): String = score?.let { "★ %.2f".format(it) } ?: "N/A"
    
    fun getFormattedEpisodes(): String = when {
        episodes == null -> "Unknown"
        episodes == 0 -> "Ongoing"
        else -> "$episodes Episodes"
    }
    
    fun getGenresText(): String = genres.joinToString(", ")
}
