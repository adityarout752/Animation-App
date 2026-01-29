package com.animeapp.presentation.detail;

import androidx.lifecycle.SavedStateHandle;
import com.animeapp.domain.repository.AnimeRepository;
import com.animeapp.domain.usecase.GetAnimeDetailsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class DetailViewModel_Factory implements Factory<DetailViewModel> {
  private final Provider<GetAnimeDetailsUseCase> getAnimeDetailsUseCaseProvider;

  private final Provider<AnimeRepository> repositoryProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public DetailViewModel_Factory(Provider<GetAnimeDetailsUseCase> getAnimeDetailsUseCaseProvider,
      Provider<AnimeRepository> repositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.getAnimeDetailsUseCaseProvider = getAnimeDetailsUseCaseProvider;
    this.repositoryProvider = repositoryProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public DetailViewModel get() {
    return newInstance(getAnimeDetailsUseCaseProvider.get(), repositoryProvider.get(), savedStateHandleProvider.get());
  }

  public static DetailViewModel_Factory create(
      Provider<GetAnimeDetailsUseCase> getAnimeDetailsUseCaseProvider,
      Provider<AnimeRepository> repositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new DetailViewModel_Factory(getAnimeDetailsUseCaseProvider, repositoryProvider, savedStateHandleProvider);
  }

  public static DetailViewModel newInstance(GetAnimeDetailsUseCase getAnimeDetailsUseCase,
      AnimeRepository repository, SavedStateHandle savedStateHandle) {
    return new DetailViewModel(getAnimeDetailsUseCase, repository, savedStateHandle);
  }
}
