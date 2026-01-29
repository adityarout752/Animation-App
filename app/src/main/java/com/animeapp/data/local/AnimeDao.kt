package com.animeapp.data.local

import androidx.room.*
import com.animeapp.data.local.entity.AnimeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimeDao {
    
    @Query("SELECT * FROM anime ORDER BY timestamp DESC")
    fun getAllAnime(): Flow<List<AnimeEntity>>
    
    @Query("SELECT * FROM anime WHERE malId = :malId")
    suspend fun getAnimeById(malId: Int): AnimeEntity?
    
    @Query("SELECT * FROM anime WHERE isFavorite = 1 ORDER BY timestamp DESC")
    fun getFavoriteAnime(): Flow<List<AnimeEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnime(anime: AnimeEntity)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnimeList(animeList: List<AnimeEntity>)
    
    @Update
    suspend fun updateAnime(anime: AnimeEntity)
    
    @Query("DELETE FROM anime WHERE isFavorite = 0")
    suspend fun deleteNonFavorites()
    
    @Query("DELETE FROM anime")
    suspend fun deleteAll()
    
    @Query("SELECT * FROM anime WHERE title LIKE '%' || :query || '%' OR titleEnglish LIKE '%' || :query || '%'")
    fun searchAnime(query: String): Flow<List<AnimeEntity>>
}
