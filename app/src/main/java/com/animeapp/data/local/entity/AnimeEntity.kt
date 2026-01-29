package com.animeapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.animeapp.data.local.Converters

@Entity(tableName = "anime")
@TypeConverters(Converters::class)
data class AnimeEntity(
    @PrimaryKey
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
    val isFavorite: Boolean = false,
    val timestamp: Long = System.currentTimeMillis()
)
