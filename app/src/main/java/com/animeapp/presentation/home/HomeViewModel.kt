package com.animeapp.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.animeapp.domain.model.Anime
import com.animeapp.domain.usecase.GetTopAnimeUseCase
import com.animeapp.domain.usecase.SearchAnimeUseCase
import com.animeapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTopAnimeUseCase: GetTopAnimeUseCase,
    private val searchAnimeUseCase: SearchAnimeUseCase
) : ViewModel() {

    private val _state = mutableStateOf(AnimeListState())
    val state: State<AnimeListState> = _state

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    init {
        loadTopAnime()
    }

    fun loadTopAnime() {
        getTopAnimeUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = AnimeListState(
                        animeList = result.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    _state.value = AnimeListState(
                        animeList = result.data ?: emptyList(),
                        error = result.message ?: "An unexpected error occurred",
                        isLoading = false
                    )
                }
                is Resource.Loading -> {
                    _state.value = AnimeListState(
                        animeList = result.data ?: emptyList(),
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun searchAnime(query: String) {
        _searchQuery.value = query
        if (query.isBlank()) {
            loadTopAnime()
            return
        }

        searchAnimeUseCase(query).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = AnimeListState(
                        animeList = result.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    _state.value = AnimeListState(
                        animeList = result.data ?: emptyList(),
                        error = result.message ?: "An unexpected error occurred",
                        isLoading = false
                    )
                }
                is Resource.Loading -> {
                    _state.value = AnimeListState(
                        animeList = result.data ?: emptyList(),
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}

data class AnimeListState(
    val animeList: List<Anime> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
