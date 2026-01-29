package com.animeapp.presentation.detail;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0011R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/animeapp/presentation/detail/DetailViewModel;", "Landroidx/lifecycle/ViewModel;", "getAnimeDetailsUseCase", "Lcom/animeapp/domain/usecase/GetAnimeDetailsUseCase;", "repository", "Lcom/animeapp/domain/repository/AnimeRepository;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/animeapp/domain/usecase/GetAnimeDetailsUseCase;Lcom/animeapp/domain/repository/AnimeRepository;Landroidx/lifecycle/SavedStateHandle;)V", "_state", "Landroidx/compose/runtime/MutableState;", "Lcom/animeapp/presentation/detail/AnimeDetailState;", "state", "Landroidx/compose/runtime/State;", "getState", "()Landroidx/compose/runtime/State;", "getAnimeDetails", "", "animeId", "", "toggleFavorite", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.animeapp.domain.usecase.GetAnimeDetailsUseCase getAnimeDetailsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.animeapp.domain.repository.AnimeRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<com.animeapp.presentation.detail.AnimeDetailState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<com.animeapp.presentation.detail.AnimeDetailState> state = null;
    
    @javax.inject.Inject()
    public DetailViewModel(@org.jetbrains.annotations.NotNull()
    com.animeapp.domain.usecase.GetAnimeDetailsUseCase getAnimeDetailsUseCase, @org.jetbrains.annotations.NotNull()
    com.animeapp.domain.repository.AnimeRepository repository, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<com.animeapp.presentation.detail.AnimeDetailState> getState() {
        return null;
    }
    
    private final void getAnimeDetails(int animeId) {
    }
    
    public final void toggleFavorite() {
    }
}