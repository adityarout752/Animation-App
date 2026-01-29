package com.animeapp.domain.usecase

import com.animeapp.domain.model.Anime
import com.animeapp.domain.repository.AnimeRepository
import com.animeapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAnimeDetailsUseCase @Inject constructor(
    private val repository: AnimeRepository
) {
    operator fun invoke(animeId: Int): Flow<Resource<Anime>> {
        return repository.getAnimeDetails(animeId)
    }
}
