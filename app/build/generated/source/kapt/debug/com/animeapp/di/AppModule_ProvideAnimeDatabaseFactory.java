package com.animeapp.di;

import android.app.Application;
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
public final class AppModule_ProvideAnimeDatabaseFactory implements Factory<AnimeDatabase> {
  private final Provider<Application> appProvider;

  public AppModule_ProvideAnimeDatabaseFactory(Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public AnimeDatabase get() {
    return provideAnimeDatabase(appProvider.get());
  }

  public static AppModule_ProvideAnimeDatabaseFactory create(Provider<Application> appProvider) {
    return new AppModule_ProvideAnimeDatabaseFactory(appProvider);
  }

  public static AnimeDatabase provideAnimeDatabase(Application app) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAnimeDatabase(app));
  }
}
