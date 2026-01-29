package com.animeapp.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\u00052\b\b\u0003\u0010\n\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ,\u0010\f\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0003\u0010\t\u001a\u00020\u00052\b\b\u0003\u0010\n\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/animeapp/data/remote/JikanApi;", "", "getAnimeDetails", "Lcom/animeapp/data/remote/dto/AnimeDetailResponse;", "animeId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopAnime", "Lcom/animeapp/data/remote/dto/AnimeListResponse;", "page", "limit", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchAnime", "query", "", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public abstract interface JikanApi {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "https://api.jikan.moe/v4/";
    @org.jetbrains.annotations.NotNull()
    public static final com.animeapp.data.remote.JikanApi.Companion Companion = null;
    
    @retrofit2.http.GET(value = "top/anime")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopAnime(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.animeapp.data.remote.dto.AnimeListResponse> $completion);
    
    @retrofit2.http.GET(value = "anime/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAnimeDetails(@retrofit2.http.Path(value = "id")
    int animeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.animeapp.data.remote.dto.AnimeDetailResponse> $completion);
    
    @retrofit2.http.GET(value = "anime")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchAnime(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.animeapp.data.remote.dto.AnimeListResponse> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/animeapp/data/remote/JikanApi$Companion;", "", "()V", "BASE_URL", "", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BASE_URL = "https://api.jikan.moe/v4/";
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}