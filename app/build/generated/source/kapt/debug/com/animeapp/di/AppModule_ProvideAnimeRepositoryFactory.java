package com.animeapp.di;

import com.animeapp.data.local.AnimeDao;
import com.animeapp.data.remote.JikanApi;
import com.animeapp.domain.repository.AnimeRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideAnimeRepositoryFactory implements Factory<AnimeRepository> {
  private final Provider<JikanApi> apiProvider;

  private final Provider<AnimeDao> daoProvider;

  public AppModule_ProvideAnimeRepositoryFactory(Provider<JikanApi> apiProvider,
      Provider<AnimeDao> daoProvider) {
    this.apiProvider = apiProvider;
    this.daoProvider = daoProvider;
  }

  @Override
  public AnimeRepository get() {
    return provideAnimeRepository(apiProvider.get(), daoProvider.get());
  }

  public static AppModule_ProvideAnimeRepositoryFactory create(Provider<JikanApi> apiProvider,
      Provider<AnimeDao> daoProvider) {
    return new AppModule_ProvideAnimeRepositoryFactory(apiProvider, daoProvider);
  }

  public static AnimeRepository provideAnimeRepository(JikanApi api, AnimeDao dao) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAnimeRepository(api, dao));
  }
}
