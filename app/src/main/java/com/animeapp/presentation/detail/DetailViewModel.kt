package com.animeapp.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.animeapp.domain.model.Anime
import com.animeapp.domain.repository.AnimeRepository
import com.animeapp.domain.usecase.GetAnimeDetailsUseCase
import com.animeapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getAnimeDetailsUseCase: GetAnimeDetailsUseCase,
    private val repository: AnimeRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(AnimeDetailState())
    val state: State<AnimeDetailState> = _state

    init {
        savedStateHandle.get<Int>("animeId")?.let { animeId ->
            getAnimeDetails(animeId)
        }
    }

    private fun getAnimeDetails(animeId: Int) {
        getAnimeDetailsUseCase(animeId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = AnimeDetailState(
                        anime = result.data,
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    _state.value = AnimeDetailState(
                        anime = result.data,
                        error = result.message ?: "An unexpected error occurred",
                        isLoading = false
                    )
                }
                is Resource.Loading -> {
                    _state.value = AnimeDetailState(
                        anime = result.data,
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun toggleFavorite() {
        _state.value.anime?.let { anime ->
            viewModelScope.launch {
                repository.toggleFavorite(anime)
                _state.value = _state.value.copy(
                    anime = anime.copy(isFavorite = !anime.isFavorite)
                )
            }
        }
    }
}

data class AnimeDetailState(
    val anime: Anime? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)
