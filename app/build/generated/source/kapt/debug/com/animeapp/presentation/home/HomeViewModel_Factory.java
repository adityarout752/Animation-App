package com.animeapp.presentation.home;

import com.animeapp.domain.usecase.GetTopAnimeUseCase;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<GetTopAnimeUseCase> getTopAnimeUseCaseProvider;

  public HomeViewModel_Factory(Provider<GetTopAnimeUseCase> getTopAnimeUseCaseProvider) {
    this.getTopAnimeUseCaseProvider = getTopAnimeUseCaseProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(getTopAnimeUseCaseProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<GetTopAnimeUseCase> getTopAnimeUseCaseProvider) {
    return new HomeViewModel_Factory(getTopAnimeUseCaseProvider);
  }

  public static HomeViewModel newInstance(GetTopAnimeUseCase getTopAnimeUseCase) {
    return new HomeViewModel(getTopAnimeUseCase);
  }
}
