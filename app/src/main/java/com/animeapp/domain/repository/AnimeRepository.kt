package com.animeapp.domain.repository

import com.animeapp.domain.model.Anime
import com.animeapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {
    fun getTopAnime(page: Int = 1): Flow<Resource<List<Anime>>>
    
    fun getAnimeDetails(animeId: Int): Flow<Resource<Anime>>
    
    fun getFavoriteAnime(): Flow<List<Anime>>
    
    suspend fun toggleFavorite(anime: Anime)
    
    suspend fun clearCache()
    
    fun searchAnime(query: String): Flow<Resource<List<Anime>>>
}
