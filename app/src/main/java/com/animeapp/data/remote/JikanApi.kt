package com.animeapp.data.remote

import com.animeapp.data.remote.dto.AnimeDetailResponse
import com.animeapp.data.remote.dto.AnimeListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JikanApi {
    
    @GET("top/anime")
    suspend fun getTopAnime(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 25
    ): AnimeListResponse
    
    @GET("anime/{id}")
    suspend fun getAnimeDetails(
        @Path("id") animeId: Int
    ): AnimeDetailResponse
    
    @GET("anime")
    suspend fun searchAnime(
        @Query("q") query: String,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 25
    ): AnimeListResponse
    
    companion object {
        const val BASE_URL = "https://api.jikan.moe/v4/"
    }
}
