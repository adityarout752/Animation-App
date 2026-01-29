package com.animeapp.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\'J\u0018\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\'J\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\'J\u0016\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/animeapp/data/local/AnimeDao;", "", "deleteAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNonFavorites", "getAllAnime", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/animeapp/data/local/entity/AnimeEntity;", "getAnimeById", "malId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavoriteAnime", "insertAnime", "anime", "(Lcom/animeapp/data/local/entity/AnimeEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAnimeList", "animeList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchAnime", "query", "", "updateAnime", "app_debug"})
@androidx.room.Dao()
public abstract interface AnimeDao {
    
    @androidx.room.Query(value = "SELECT * FROM anime ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.animeapp.data.local.entity.AnimeEntity>> getAllAnime();
    
    @androidx.room.Query(value = "SELECT * FROM anime WHERE malId = :malId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAnimeById(int malId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.animeapp.data.local.entity.AnimeEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM anime WHERE isFavorite = 1 ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.animeapp.data.local.entity.AnimeEntity>> getFavoriteAnime();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAnime(@org.jetbrains.annotations.NotNull()
    com.animeapp.data.local.entity.AnimeEntity anime, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAnimeList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.animeapp.data.local.entity.AnimeEntity> animeList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateAnime(@org.jetbrains.annotations.NotNull()
    com.animeapp.data.local.entity.AnimeEntity anime, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM anime WHERE isFavorite = 0")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteNonFavorites(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM anime")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM anime WHERE title LIKE \'%\' || :query || \'%\' OR titleEnglish LIKE \'%\' || :query || \'%\'")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.animeapp.data.local.entity.AnimeEntity>> searchAnime(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
}