package com.animeapp.data.repository

import android.util.Log
import com.animeapp.data.local.AnimeDao
import com.animeapp.data.mapper.toAnime
import com.animeapp.data.mapper.toAnimeEntity
import com.animeapp.data.remote.JikanApi
import com.animeapp.domain.model.Anime
import com.animeapp.domain.repository.AnimeRepository
import com.animeapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnimeRepositoryImpl @Inject constructor(
    private val api: JikanApi,
    private val dao: AnimeDao
) : AnimeRepository {

    private companion object {
        const val TAG = "AnimeRepository"
        const val CACHE_TIMEOUT = 3600000L // 1 hour
    }

    override fun getTopAnime(page: Int): Flow<Resource<List<Anime>>> = flow {
        emit(Resource.Loading())

        // Try to get cached data first
        val cachedAnime = dao.getAllAnime().first()
        if (cachedAnime.isNotEmpty()) {
            emit(Resource.Loading(cachedAnime.map { it.toAnime() }))
        }

        try {
            // Fetch from API
            val response = api.getTopAnime(page)
            val animeList = response.data.map { dto ->
                val existingAnime = dao.getAnimeById(dto.malId)
                val entity = dto.toAnimeEntity().copy(
                    isFavorite = existingAnime?.isFavorite ?: false
                )
                entity
            }

            // Cache the results
            dao.insertAnimeList(animeList)

            // Emit success with fresh data
            emit(Resource.Success(animeList.map { it.toAnime() }))
        } catch (e: HttpException) {
            Log.e(TAG, "HTTP error: ${e.message()}", e)
            emit(
                Resource.Error(
                    message = "Server error: ${e.code()}",
                    data = cachedAnime.map { it.toAnime() }
                )
            )
        } catch (e: IOException) {
            Log.e(TAG, "Network error", e)
            emit(
                Resource.Error(
                    message = "No internet connection. Showing cached data.",
                    data = cachedAnime.map { it.toAnime() }
                )
            )
        } catch (e: Exception) {
            Log.e(TAG, "Unknown error", e)
            emit(
                Resource.Error(
                    message = "An unexpected error occurred: ${e.localizedMessage}",
                    data = cachedAnime.map { it.toAnime() }
                )
            )
        }
    }

    override fun getAnimeDetails(animeId: Int): Flow<Resource<Anime>> = flow {
        emit(Resource.Loading())

        // Check cache first
        val cachedAnime = dao.getAnimeById(animeId)
        if (cachedAnime != null) {
            emit(Resource.Loading(cachedAnime.toAnime()))
        }

        try {
            // Fetch from API
            val response = api.getAnimeDetails(animeId)
            val animeEntity = response.data.toAnimeEntity().copy(
                isFavorite = cachedAnime?.isFavorite ?: false
            )

            // Cache the result
            dao.insertAnime(animeEntity)

            // Emit success
            emit(Resource.Success(animeEntity.toAnime()))
        } catch (e: HttpException) {
            Log.e(TAG, "HTTP error: ${e.message()}", e)
            emit(
                Resource.Error(
                    message = "Server error: ${e.code()}",
                    data = cachedAnime?.toAnime()
                )
            )
        } catch (e: IOException) {
            Log.e(TAG, "Network error", e)
            emit(
                Resource.Error(
                    message = "No internet connection. Showing cached data.",
                    data = cachedAnime?.toAnime()
                )
            )
        } catch (e: Exception) {
            Log.e(TAG, "Unknown error", e)
            emit(
                Resource.Error(
                    message = "An unexpected error occurred: ${e.localizedMessage}",
                    data = cachedAnime?.toAnime()
                )
            )
        }
    }

    override fun getFavoriteAnime(): Flow<List<Anime>> = flow {
        dao.getFavoriteAnime().collect { entities ->
            emit(entities.map { it.toAnime() })
        }
    }

    override suspend fun toggleFavorite(anime: Anime) {
        val entity = anime.copy(isFavorite = !anime.isFavorite).toAnimeEntity()
        dao.updateAnime(entity)
    }

    override suspend fun clearCache() {
        dao.deleteNonFavorites()
    }

    override fun searchAnime(query: String): Flow<Resource<List<Anime>>> = flow {
        emit(Resource.Loading())

        // Search in local database first
        val localResults = dao.searchAnime(query).first()
        if (localResults.isNotEmpty()) {
            emit(Resource.Loading(localResults.map { it.toAnime() }))
        }

        try {
            // Search via API
            val response = api.searchAnime(query)
            val animeList = response.data.map { dto ->
                val existingAnime = dao.getAnimeById(dto.malId)
                dto.toAnimeEntity().copy(
                    isFavorite = existingAnime?.isFavorite ?: false
                )
            }

            // Cache the results
            dao.insertAnimeList(animeList)

            emit(Resource.Success(animeList.map { it.toAnime() }))
        } catch (e: HttpException) {
            Log.e(TAG, "HTTP error: ${e.message()}", e)
            emit(
                Resource.Error(
                    message = "Server error: ${e.code()}",
                    data = localResults.map { it.toAnime() }
                )
            )
        } catch (e: IOException) {
            Log.e(TAG, "Network error", e)
            emit(
                Resource.Error(
                    message = "No internet connection. Showing local results.",
                    data = localResults.map { it.toAnime() }
                )
            )
        } catch (e: Exception) {
            Log.e(TAG, "Unknown error", e)
            emit(
                Resource.Error(
                    message = "An unexpected error occurred: ${e.localizedMessage}",
                    data = localResults.map { it.toAnime() }
                )
            )
        }
    }
}
