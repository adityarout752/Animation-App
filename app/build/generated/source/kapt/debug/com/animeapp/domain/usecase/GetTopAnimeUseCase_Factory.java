package com.animeapp.domain.usecase;

import com.animeapp.domain.repository.AnimeRepository;
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
public final class GetTopAnimeUseCase_Factory implements Factory<GetTopAnimeUseCase> {
  private final Provider<AnimeRepository> repositoryProvider;

  public GetTopAnimeUseCase_Factory(Provider<AnimeRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetTopAnimeUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetTopAnimeUseCase_Factory create(Provider<AnimeRepository> repositoryProvider) {
    return new GetTopAnimeUseCase_Factory(repositoryProvider);
  }

  public static GetTopAnimeUseCase newInstance(AnimeRepository repository) {
    return new GetTopAnimeUseCase(repository);
  }
}
