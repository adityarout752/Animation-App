package com.animeapp.domain.usecase

import com.animeapp.domain.model.Anime
import com.animeapp.domain.repository.AnimeRepository
import com.animeapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchAnimeUseCase @Inject constructor(
    private val repository: AnimeRepository
) {
    operator fun invoke(query: String): Flow<Resource<List<Anime>>> {
        return repository.searchAnime(query)
    }
}
