package com.animeapp.domain.usecase

import com.animeapp.domain.model.Anime
import com.animeapp.domain.repository.AnimeRepository
import com.animeapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopAnimeUseCase @Inject constructor(
    private val repository: AnimeRepository
) {
    operator fun invoke(page: Int = 1): Flow<Resource<List<Anime>>> {
        return repository.getTopAnime(page)
    }
}
