package com.animeapp.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u000bH\u0016J\"\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\f0\u000b2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\"\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\f0\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0016\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/animeapp/data/repository/AnimeRepositoryImpl;", "Lcom/animeapp/domain/repository/AnimeRepository;", "api", "Lcom/animeapp/data/remote/JikanApi;", "dao", "Lcom/animeapp/data/local/AnimeDao;", "(Lcom/animeapp/data/remote/JikanApi;Lcom/animeapp/data/local/AnimeDao;)V", "clearCache", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnimeDetails", "Lkotlinx/coroutines/flow/Flow;", "Lcom/animeapp/util/Resource;", "Lcom/animeapp/domain/model/Anime;", "animeId", "", "getFavoriteAnime", "", "getTopAnime", "page", "searchAnime", "query", "", "toggleFavorite", "anime", "(Lcom/animeapp/domain/model/Anime;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class AnimeRepositoryImpl implements com.animeapp.domain.repository.AnimeRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.animeapp.data.remote.JikanApi api = null;
    @org.jetbrains.annotations.NotNull()
    private final com.animeapp.data.local.AnimeDao dao = null;
    @org.jetbrains.annotations.NotNull()
    @java.lang.Deprecated()
    public static final java.lang.String TAG = "AnimeRepository";
    @java.lang.Deprecated()
    public static final long CACHE_TIMEOUT = 3600000L;
    @org.jetbrains.annotations.NotNull()
    private static final com.animeapp.data.repository.AnimeRepositoryImpl.Companion Companion = null;
    
    @javax.inject.Inject()
    public AnimeRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.animeapp.data.remote.JikanApi api, @org.jetbrains.annotations.NotNull()
    com.animeapp.data.local.AnimeDao dao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.animeapp.util.Resource<java.util.List<com.animeapp.domain.model.Anime>>> getTopAnime(int page) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.animeapp.util.Resource<com.animeapp.domain.model.Anime>> getAnimeDetails(int animeId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.animeapp.domain.model.Anime>> getFavoriteAnime() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object toggleFavorite(@org.jetbrains.annotations.NotNull()
    com.animeapp.domain.model.Anime anime, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object clearCache(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.animeapp.util.Resource<java.util.List<com.animeapp.domain.model.Anime>>> searchAnime(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/animeapp/data/repository/AnimeRepositoryImpl$Companion;", "", "()V", "CACHE_TIMEOUT", "", "TAG", "", "app_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}