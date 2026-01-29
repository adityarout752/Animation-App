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
public final class GetAnimeDetailsUseCase_Factory implements Factory<GetAnimeDetailsUseCase> {
  private final Provider<AnimeRepository> repositoryProvider;

  public GetAnimeDetailsUseCase_Factory(Provider<AnimeRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetAnimeDetailsUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetAnimeDetailsUseCase_Factory create(
      Provider<AnimeRepository> repositoryProvider) {
    return new GetAnimeDetailsUseCase_Factory(repositoryProvider);
  }

  public static GetAnimeDetailsUseCase newInstance(AnimeRepository repository) {
    return new GetAnimeDetailsUseCase(repository);
  }
}
