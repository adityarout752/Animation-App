package com.animeapp.data.repository;

import com.animeapp.data.local.AnimeDao;
import com.animeapp.data.remote.JikanApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class AnimeRepositoryImpl_Factory implements Factory<AnimeRepositoryImpl> {
  private final Provider<JikanApi> apiProvider;

  private final Provider<AnimeDao> daoProvider;

  public AnimeRepositoryImpl_Factory(Provider<JikanApi> apiProvider,
      Provider<AnimeDao> daoProvider) {
    this.apiProvider = apiProvider;
    this.daoProvider = daoProvider;
  }

  @Override
  public AnimeRepositoryImpl get() {
    return newInstance(apiProvider.get(), daoProvider.get());
  }

  public static AnimeRepositoryImpl_Factory create(Provider<JikanApi> apiProvider,
      Provider<AnimeDao> daoProvider) {
    return new AnimeRepositoryImpl_Factory(apiProvider, daoProvider);
  }

  public static AnimeRepositoryImpl newInstance(JikanApi api, AnimeDao dao) {
    return new AnimeRepositoryImpl(api, dao);
  }
}
