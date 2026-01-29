package com.animeapp.di;

import com.animeapp.data.local.AnimeDao;
import com.animeapp.data.local.AnimeDatabase;
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
public final class AppModule_ProvideAnimeDaoFactory implements Factory<AnimeDao> {
  private final Provider<AnimeDatabase> databaseProvider;

  public AppModule_ProvideAnimeDaoFactory(Provider<AnimeDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public AnimeDao get() {
    return provideAnimeDao(databaseProvider.get());
  }

  public static AppModule_ProvideAnimeDaoFactory create(Provider<AnimeDatabase> databaseProvider) {
    return new AppModule_ProvideAnimeDaoFactory(databaseProvider);
  }

  public static AnimeDao provideAnimeDao(AnimeDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAnimeDao(database));
  }
}
