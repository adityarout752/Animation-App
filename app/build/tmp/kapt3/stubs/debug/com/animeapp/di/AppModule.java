package com.animeapp.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0011H\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/animeapp/di/AppModule;", "", "()V", "provideAnimeDao", "Lcom/animeapp/data/local/AnimeDao;", "database", "Lcom/animeapp/data/local/AnimeDatabase;", "provideAnimeDatabase", "app", "Landroid/app/Application;", "provideAnimeRepository", "Lcom/animeapp/domain/repository/AnimeRepository;", "api", "Lcom/animeapp/data/remote/JikanApi;", "dao", "provideJikanApi", "okHttpClient", "Lokhttp3/OkHttpClient;", "provideOkHttpClient", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.animeapp.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideOkHttpClient() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.animeapp.data.remote.JikanApi provideJikanApi(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.animeapp.data.local.AnimeDatabase provideAnimeDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.animeapp.data.local.AnimeDao provideAnimeDao(@org.jetbrains.annotations.NotNull()
    com.animeapp.data.local.AnimeDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.animeapp.domain.repository.AnimeRepository provideAnimeRepository(@org.jetbrains.annotations.NotNull()
    com.animeapp.data.remote.JikanApi api, @org.jetbrains.annotations.NotNull()
    com.animeapp.data.local.AnimeDao dao) {
        return null;
    }
}