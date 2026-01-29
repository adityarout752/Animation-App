package com.animeapp.data.remote.dto;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u00a3\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u001aJ\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u00c6\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011H\u00c6\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJ\t\u0010;\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010+J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJ\u000b\u0010B\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u00ca\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010H\u001a\u00020\u0003H\u00d6\u0001J\t\u0010I\u001a\u00020\u0005H\u00d6\u0001R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b&\u0010\u001eR\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\'\u0010\u001eR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00118\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010)R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010)R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103\u00a8\u0006J"}, d2 = {"Lcom/animeapp/data/remote/dto/AnimeDto;", "", "malId", "", "title", "", "titleEnglish", "images", "Lcom/animeapp/data/remote/dto/ImagesDto;", "trailer", "Lcom/animeapp/data/remote/dto/TrailerDto;", "synopsis", "score", "", "episodes", "status", "genres", "", "Lcom/animeapp/data/remote/dto/GenreDto;", "studios", "Lcom/animeapp/data/remote/dto/StudioDto;", "aired", "Lcom/animeapp/data/remote/dto/AiredDto;", "rating", "rank", "popularity", "(ILjava/lang/String;Ljava/lang/String;Lcom/animeapp/data/remote/dto/ImagesDto;Lcom/animeapp/data/remote/dto/TrailerDto;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/animeapp/data/remote/dto/AiredDto;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAired", "()Lcom/animeapp/data/remote/dto/AiredDto;", "getEpisodes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGenres", "()Ljava/util/List;", "getImages", "()Lcom/animeapp/data/remote/dto/ImagesDto;", "getMalId", "()I", "getPopularity", "getRank", "getRating", "()Ljava/lang/String;", "getScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getStatus", "getStudios", "getSynopsis", "getTitle", "getTitleEnglish", "getTrailer", "()Lcom/animeapp/data/remote/dto/TrailerDto;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Lcom/animeapp/data/remote/dto/ImagesDto;Lcom/animeapp/data/remote/dto/TrailerDto;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/animeapp/data/remote/dto/AiredDto;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/animeapp/data/remote/dto/AnimeDto;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class AnimeDto {
    @com.google.gson.annotations.SerializedName(value = "mal_id")
    private final int malId = 0;
    @com.google.gson.annotations.SerializedName(value = "title")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @com.google.gson.annotations.SerializedName(value = "title_english")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String titleEnglish = null;
    @com.google.gson.annotations.SerializedName(value = "images")
    @org.jetbrains.annotations.Nullable()
    private final com.animeapp.data.remote.dto.ImagesDto images = null;
    @com.google.gson.annotations.SerializedName(value = "trailer")
    @org.jetbrains.annotations.Nullable()
    private final com.animeapp.data.remote.dto.TrailerDto trailer = null;
    @com.google.gson.annotations.SerializedName(value = "synopsis")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String synopsis = null;
    @com.google.gson.annotations.SerializedName(value = "score")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double score = null;
    @com.google.gson.annotations.SerializedName(value = "episodes")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer episodes = null;
    @com.google.gson.annotations.SerializedName(value = "status")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String status = null;
    @com.google.gson.annotations.SerializedName(value = "genres")
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.animeapp.data.remote.dto.GenreDto> genres = null;
    @com.google.gson.annotations.SerializedName(value = "studios")
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.animeapp.data.remote.dto.StudioDto> studios = null;
    @com.google.gson.annotations.SerializedName(value = "aired")
    @org.jetbrains.annotations.Nullable()
    private final com.animeapp.data.remote.dto.AiredDto aired = null;
    @com.google.gson.annotations.SerializedName(value = "rating")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String rating = null;
    @com.google.gson.annotations.SerializedName(value = "rank")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer rank = null;
    @com.google.gson.annotations.SerializedName(value = "popularity")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer popularity = null;
    
    public AnimeDto(int malId, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String titleEnglish, @org.jetbrains.annotations.Nullable()
    com.animeapp.data.remote.dto.ImagesDto images, @org.jetbrains.annotations.Nullable()
    com.animeapp.data.remote.dto.TrailerDto trailer, @org.jetbrains.annotations.Nullable()
    java.lang.String synopsis, @org.jetbrains.annotations.Nullable()
    java.lang.Double score, @org.jetbrains.annotations.Nullable()
    java.lang.Integer episodes, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.util.List<com.animeapp.data.remote.dto.GenreDto> genres, @org.jetbrains.annotations.Nullable()
    java.util.List<com.animeapp.data.remote.dto.StudioDto> studios, @org.jetbrains.annotations.Nullable()
    com.animeapp.data.remote.dto.AiredDto aired, @org.jetbrains.annotations.Nullable()
    java.lang.String rating, @org.jetbrains.annotations.Nullable()
    java.lang.Integer rank, @org.jetbrains.annotations.Nullable()
    java.lang.Integer popularity) {
        super();
    }
    
    public final int getMalId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTitleEnglish() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.animeapp.data.remote.dto.ImagesDto getImages() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.animeapp.data.remote.dto.TrailerDto getTrailer() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSynopsis() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getScore() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getEpisodes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.animeapp.data.remote.dto.GenreDto> getGenres() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.animeapp.data.remote.dto.StudioDto> getStudios() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.animeapp.data.remote.dto.AiredDto getAired() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRating() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getRank() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getPopularity() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.animeapp.data.remote.dto.GenreDto> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.animeapp.data.remote.dto.StudioDto> component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.animeapp.data.remote.dto.AiredDto component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.animeapp.data.remote.dto.ImagesDto component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.animeapp.data.remote.dto.TrailerDto component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.animeapp.data.remote.dto.AnimeDto copy(int malId, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String titleEnglish, @org.jetbrains.annotations.Nullable()
    com.animeapp.data.remote.dto.ImagesDto images, @org.jetbrains.annotations.Nullable()
    com.animeapp.data.remote.dto.TrailerDto trailer, @org.jetbrains.annotations.Nullable()
    java.lang.String synopsis, @org.jetbrains.annotations.Nullable()
    java.lang.Double score, @org.jetbrains.annotations.Nullable()
    java.lang.Integer episodes, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.util.List<com.animeapp.data.remote.dto.GenreDto> genres, @org.jetbrains.annotations.Nullable()
    java.util.List<com.animeapp.data.remote.dto.StudioDto> studios, @org.jetbrains.annotations.Nullable()
    com.animeapp.data.remote.dto.AiredDto aired, @org.jetbrains.annotations.Nullable()
    java.lang.String rating, @org.jetbrains.annotations.Nullable()
    java.lang.Integer rank, @org.jetbrains.annotations.Nullable()
    java.lang.Integer popularity) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}