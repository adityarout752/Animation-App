package com.animeapp.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.animeapp.data.local.entity.AnimeEntity;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AnimeDao_Impl implements AnimeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AnimeEntity> __insertionAdapterOfAnimeEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<AnimeEntity> __updateAdapterOfAnimeEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteNonFavorites;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public AnimeDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAnimeEntity = new EntityInsertionAdapter<AnimeEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `anime` (`malId`,`title`,`titleEnglish`,`imageUrl`,`trailerUrl`,`synopsis`,`score`,`episodes`,`status`,`genres`,`studios`,`aired`,`rating`,`rank`,`popularity`,`isFavorite`,`timestamp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AnimeEntity entity) {
        statement.bindLong(1, entity.getMalId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getTitleEnglish() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTitleEnglish());
        }
        if (entity.getImageUrl() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getImageUrl());
        }
        if (entity.getTrailerUrl() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTrailerUrl());
        }
        if (entity.getSynopsis() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getSynopsis());
        }
        if (entity.getScore() == null) {
          statement.bindNull(7);
        } else {
          statement.bindDouble(7, entity.getScore());
        }
        if (entity.getEpisodes() == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, entity.getEpisodes());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getStatus());
        }
        final String _tmp = __converters.fromStringList(entity.getGenres());
        if (_tmp == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, _tmp);
        }
        final String _tmp_1 = __converters.fromStringList(entity.getStudios());
        if (_tmp_1 == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, _tmp_1);
        }
        if (entity.getAired() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getAired());
        }
        if (entity.getRating() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getRating());
        }
        if (entity.getRank() == null) {
          statement.bindNull(14);
        } else {
          statement.bindLong(14, entity.getRank());
        }
        if (entity.getPopularity() == null) {
          statement.bindNull(15);
        } else {
          statement.bindLong(15, entity.getPopularity());
        }
        final int _tmp_2 = entity.isFavorite() ? 1 : 0;
        statement.bindLong(16, _tmp_2);
        statement.bindLong(17, entity.getTimestamp());
      }
    };
    this.__updateAdapterOfAnimeEntity = new EntityDeletionOrUpdateAdapter<AnimeEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `anime` SET `malId` = ?,`title` = ?,`titleEnglish` = ?,`imageUrl` = ?,`trailerUrl` = ?,`synopsis` = ?,`score` = ?,`episodes` = ?,`status` = ?,`genres` = ?,`studios` = ?,`aired` = ?,`rating` = ?,`rank` = ?,`popularity` = ?,`isFavorite` = ?,`timestamp` = ? WHERE `malId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AnimeEntity entity) {
        statement.bindLong(1, entity.getMalId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getTitleEnglish() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTitleEnglish());
        }
        if (entity.getImageUrl() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getImageUrl());
        }
        if (entity.getTrailerUrl() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTrailerUrl());
        }
        if (entity.getSynopsis() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getSynopsis());
        }
        if (entity.getScore() == null) {
          statement.bindNull(7);
        } else {
          statement.bindDouble(7, entity.getScore());
        }
        if (entity.getEpisodes() == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, entity.getEpisodes());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getStatus());
        }
        final String _tmp = __converters.fromStringList(entity.getGenres());
        if (_tmp == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, _tmp);
        }
        final String _tmp_1 = __converters.fromStringList(entity.getStudios());
        if (_tmp_1 == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, _tmp_1);
        }
        if (entity.getAired() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getAired());
        }
        if (entity.getRating() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getRating());
        }
        if (entity.getRank() == null) {
          statement.bindNull(14);
        } else {
          statement.bindLong(14, entity.getRank());
        }
        if (entity.getPopularity() == null) {
          statement.bindNull(15);
        } else {
          statement.bindLong(15, entity.getPopularity());
        }
        final int _tmp_2 = entity.isFavorite() ? 1 : 0;
        statement.bindLong(16, _tmp_2);
        statement.bindLong(17, entity.getTimestamp());
        statement.bindLong(18, entity.getMalId());
      }
    };
    this.__preparedStmtOfDeleteNonFavorites = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM anime WHERE isFavorite = 0";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM anime";
        return _query;
      }
    };
  }

  @Override
  public Object insertAnime(final AnimeEntity anime, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAnimeEntity.insert(anime);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertAnimeList(final List<AnimeEntity> animeList,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAnimeEntity.insert(animeList);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateAnime(final AnimeEntity anime, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfAnimeEntity.handle(anime);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteNonFavorites(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteNonFavorites.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteNonFavorites.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<AnimeEntity>> getAllAnime() {
    final String _sql = "SELECT * FROM anime ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"anime"}, new Callable<List<AnimeEntity>>() {
      @Override
      @NonNull
      public List<AnimeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMalId = CursorUtil.getColumnIndexOrThrow(_cursor, "malId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfTitleEnglish = CursorUtil.getColumnIndexOrThrow(_cursor, "titleEnglish");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfTrailerUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "trailerUrl");
          final int _cursorIndexOfSynopsis = CursorUtil.getColumnIndexOrThrow(_cursor, "synopsis");
          final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "score");
          final int _cursorIndexOfEpisodes = CursorUtil.getColumnIndexOrThrow(_cursor, "episodes");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfGenres = CursorUtil.getColumnIndexOrThrow(_cursor, "genres");
          final int _cursorIndexOfStudios = CursorUtil.getColumnIndexOrThrow(_cursor, "studios");
          final int _cursorIndexOfAired = CursorUtil.getColumnIndexOrThrow(_cursor, "aired");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfRank = CursorUtil.getColumnIndexOrThrow(_cursor, "rank");
          final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<AnimeEntity> _result = new ArrayList<AnimeEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AnimeEntity _item;
            final int _tmpMalId;
            _tmpMalId = _cursor.getInt(_cursorIndexOfMalId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpTitleEnglish;
            if (_cursor.isNull(_cursorIndexOfTitleEnglish)) {
              _tmpTitleEnglish = null;
            } else {
              _tmpTitleEnglish = _cursor.getString(_cursorIndexOfTitleEnglish);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final String _tmpTrailerUrl;
            if (_cursor.isNull(_cursorIndexOfTrailerUrl)) {
              _tmpTrailerUrl = null;
            } else {
              _tmpTrailerUrl = _cursor.getString(_cursorIndexOfTrailerUrl);
            }
            final String _tmpSynopsis;
            if (_cursor.isNull(_cursorIndexOfSynopsis)) {
              _tmpSynopsis = null;
            } else {
              _tmpSynopsis = _cursor.getString(_cursorIndexOfSynopsis);
            }
            final Double _tmpScore;
            if (_cursor.isNull(_cursorIndexOfScore)) {
              _tmpScore = null;
            } else {
              _tmpScore = _cursor.getDouble(_cursorIndexOfScore);
            }
            final Integer _tmpEpisodes;
            if (_cursor.isNull(_cursorIndexOfEpisodes)) {
              _tmpEpisodes = null;
            } else {
              _tmpEpisodes = _cursor.getInt(_cursorIndexOfEpisodes);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final List<String> _tmpGenres;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfGenres)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfGenres);
            }
            _tmpGenres = __converters.toStringList(_tmp);
            final List<String> _tmpStudios;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfStudios)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfStudios);
            }
            _tmpStudios = __converters.toStringList(_tmp_1);
            final String _tmpAired;
            if (_cursor.isNull(_cursorIndexOfAired)) {
              _tmpAired = null;
            } else {
              _tmpAired = _cursor.getString(_cursorIndexOfAired);
            }
            final String _tmpRating;
            if (_cursor.isNull(_cursorIndexOfRating)) {
              _tmpRating = null;
            } else {
              _tmpRating = _cursor.getString(_cursorIndexOfRating);
            }
            final Integer _tmpRank;
            if (_cursor.isNull(_cursorIndexOfRank)) {
              _tmpRank = null;
            } else {
              _tmpRank = _cursor.getInt(_cursorIndexOfRank);
            }
            final Integer _tmpPopularity;
            if (_cursor.isNull(_cursorIndexOfPopularity)) {
              _tmpPopularity = null;
            } else {
              _tmpPopularity = _cursor.getInt(_cursorIndexOfPopularity);
            }
            final boolean _tmpIsFavorite;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_2 != 0;
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item = new AnimeEntity(_tmpMalId,_tmpTitle,_tmpTitleEnglish,_tmpImageUrl,_tmpTrailerUrl,_tmpSynopsis,_tmpScore,_tmpEpisodes,_tmpStatus,_tmpGenres,_tmpStudios,_tmpAired,_tmpRating,_tmpRank,_tmpPopularity,_tmpIsFavorite,_tmpTimestamp);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getAnimeById(final int malId, final Continuation<? super AnimeEntity> $completion) {
    final String _sql = "SELECT * FROM anime WHERE malId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, malId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<AnimeEntity>() {
      @Override
      @Nullable
      public AnimeEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMalId = CursorUtil.getColumnIndexOrThrow(_cursor, "malId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfTitleEnglish = CursorUtil.getColumnIndexOrThrow(_cursor, "titleEnglish");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfTrailerUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "trailerUrl");
          final int _cursorIndexOfSynopsis = CursorUtil.getColumnIndexOrThrow(_cursor, "synopsis");
          final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "score");
          final int _cursorIndexOfEpisodes = CursorUtil.getColumnIndexOrThrow(_cursor, "episodes");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfGenres = CursorUtil.getColumnIndexOrThrow(_cursor, "genres");
          final int _cursorIndexOfStudios = CursorUtil.getColumnIndexOrThrow(_cursor, "studios");
          final int _cursorIndexOfAired = CursorUtil.getColumnIndexOrThrow(_cursor, "aired");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfRank = CursorUtil.getColumnIndexOrThrow(_cursor, "rank");
          final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final AnimeEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpMalId;
            _tmpMalId = _cursor.getInt(_cursorIndexOfMalId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpTitleEnglish;
            if (_cursor.isNull(_cursorIndexOfTitleEnglish)) {
              _tmpTitleEnglish = null;
            } else {
              _tmpTitleEnglish = _cursor.getString(_cursorIndexOfTitleEnglish);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final String _tmpTrailerUrl;
            if (_cursor.isNull(_cursorIndexOfTrailerUrl)) {
              _tmpTrailerUrl = null;
            } else {
              _tmpTrailerUrl = _cursor.getString(_cursorIndexOfTrailerUrl);
            }
            final String _tmpSynopsis;
            if (_cursor.isNull(_cursorIndexOfSynopsis)) {
              _tmpSynopsis = null;
            } else {
              _tmpSynopsis = _cursor.getString(_cursorIndexOfSynopsis);
            }
            final Double _tmpScore;
            if (_cursor.isNull(_cursorIndexOfScore)) {
              _tmpScore = null;
            } else {
              _tmpScore = _cursor.getDouble(_cursorIndexOfScore);
            }
            final Integer _tmpEpisodes;
            if (_cursor.isNull(_cursorIndexOfEpisodes)) {
              _tmpEpisodes = null;
            } else {
              _tmpEpisodes = _cursor.getInt(_cursorIndexOfEpisodes);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final List<String> _tmpGenres;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfGenres)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfGenres);
            }
            _tmpGenres = __converters.toStringList(_tmp);
            final List<String> _tmpStudios;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfStudios)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfStudios);
            }
            _tmpStudios = __converters.toStringList(_tmp_1);
            final String _tmpAired;
            if (_cursor.isNull(_cursorIndexOfAired)) {
              _tmpAired = null;
            } else {
              _tmpAired = _cursor.getString(_cursorIndexOfAired);
            }
            final String _tmpRating;
            if (_cursor.isNull(_cursorIndexOfRating)) {
              _tmpRating = null;
            } else {
              _tmpRating = _cursor.getString(_cursorIndexOfRating);
            }
            final Integer _tmpRank;
            if (_cursor.isNull(_cursorIndexOfRank)) {
              _tmpRank = null;
            } else {
              _tmpRank = _cursor.getInt(_cursorIndexOfRank);
            }
            final Integer _tmpPopularity;
            if (_cursor.isNull(_cursorIndexOfPopularity)) {
              _tmpPopularity = null;
            } else {
              _tmpPopularity = _cursor.getInt(_cursorIndexOfPopularity);
            }
            final boolean _tmpIsFavorite;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_2 != 0;
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _result = new AnimeEntity(_tmpMalId,_tmpTitle,_tmpTitleEnglish,_tmpImageUrl,_tmpTrailerUrl,_tmpSynopsis,_tmpScore,_tmpEpisodes,_tmpStatus,_tmpGenres,_tmpStudios,_tmpAired,_tmpRating,_tmpRank,_tmpPopularity,_tmpIsFavorite,_tmpTimestamp);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<AnimeEntity>> getFavoriteAnime() {
    final String _sql = "SELECT * FROM anime WHERE isFavorite = 1 ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"anime"}, new Callable<List<AnimeEntity>>() {
      @Override
      @NonNull
      public List<AnimeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMalId = CursorUtil.getColumnIndexOrThrow(_cursor, "malId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfTitleEnglish = CursorUtil.getColumnIndexOrThrow(_cursor, "titleEnglish");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfTrailerUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "trailerUrl");
          final int _cursorIndexOfSynopsis = CursorUtil.getColumnIndexOrThrow(_cursor, "synopsis");
          final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "score");
          final int _cursorIndexOfEpisodes = CursorUtil.getColumnIndexOrThrow(_cursor, "episodes");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfGenres = CursorUtil.getColumnIndexOrThrow(_cursor, "genres");
          final int _cursorIndexOfStudios = CursorUtil.getColumnIndexOrThrow(_cursor, "studios");
          final int _cursorIndexOfAired = CursorUtil.getColumnIndexOrThrow(_cursor, "aired");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfRank = CursorUtil.getColumnIndexOrThrow(_cursor, "rank");
          final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<AnimeEntity> _result = new ArrayList<AnimeEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AnimeEntity _item;
            final int _tmpMalId;
            _tmpMalId = _cursor.getInt(_cursorIndexOfMalId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpTitleEnglish;
            if (_cursor.isNull(_cursorIndexOfTitleEnglish)) {
              _tmpTitleEnglish = null;
            } else {
              _tmpTitleEnglish = _cursor.getString(_cursorIndexOfTitleEnglish);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final String _tmpTrailerUrl;
            if (_cursor.isNull(_cursorIndexOfTrailerUrl)) {
              _tmpTrailerUrl = null;
            } else {
              _tmpTrailerUrl = _cursor.getString(_cursorIndexOfTrailerUrl);
            }
            final String _tmpSynopsis;
            if (_cursor.isNull(_cursorIndexOfSynopsis)) {
              _tmpSynopsis = null;
            } else {
              _tmpSynopsis = _cursor.getString(_cursorIndexOfSynopsis);
            }
            final Double _tmpScore;
            if (_cursor.isNull(_cursorIndexOfScore)) {
              _tmpScore = null;
            } else {
              _tmpScore = _cursor.getDouble(_cursorIndexOfScore);
            }
            final Integer _tmpEpisodes;
            if (_cursor.isNull(_cursorIndexOfEpisodes)) {
              _tmpEpisodes = null;
            } else {
              _tmpEpisodes = _cursor.getInt(_cursorIndexOfEpisodes);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final List<String> _tmpGenres;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfGenres)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfGenres);
            }
            _tmpGenres = __converters.toStringList(_tmp);
            final List<String> _tmpStudios;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfStudios)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfStudios);
            }
            _tmpStudios = __converters.toStringList(_tmp_1);
            final String _tmpAired;
            if (_cursor.isNull(_cursorIndexOfAired)) {
              _tmpAired = null;
            } else {
              _tmpAired = _cursor.getString(_cursorIndexOfAired);
            }
            final String _tmpRating;
            if (_cursor.isNull(_cursorIndexOfRating)) {
              _tmpRating = null;
            } else {
              _tmpRating = _cursor.getString(_cursorIndexOfRating);
            }
            final Integer _tmpRank;
            if (_cursor.isNull(_cursorIndexOfRank)) {
              _tmpRank = null;
            } else {
              _tmpRank = _cursor.getInt(_cursorIndexOfRank);
            }
            final Integer _tmpPopularity;
            if (_cursor.isNull(_cursorIndexOfPopularity)) {
              _tmpPopularity = null;
            } else {
              _tmpPopularity = _cursor.getInt(_cursorIndexOfPopularity);
            }
            final boolean _tmpIsFavorite;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_2 != 0;
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item = new AnimeEntity(_tmpMalId,_tmpTitle,_tmpTitleEnglish,_tmpImageUrl,_tmpTrailerUrl,_tmpSynopsis,_tmpScore,_tmpEpisodes,_tmpStatus,_tmpGenres,_tmpStudios,_tmpAired,_tmpRating,_tmpRank,_tmpPopularity,_tmpIsFavorite,_tmpTimestamp);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<AnimeEntity>> searchAnime(final String query) {
    final String _sql = "SELECT * FROM anime WHERE title LIKE '%' || ? || '%' OR titleEnglish LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"anime"}, new Callable<List<AnimeEntity>>() {
      @Override
      @NonNull
      public List<AnimeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMalId = CursorUtil.getColumnIndexOrThrow(_cursor, "malId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfTitleEnglish = CursorUtil.getColumnIndexOrThrow(_cursor, "titleEnglish");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfTrailerUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "trailerUrl");
          final int _cursorIndexOfSynopsis = CursorUtil.getColumnIndexOrThrow(_cursor, "synopsis");
          final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "score");
          final int _cursorIndexOfEpisodes = CursorUtil.getColumnIndexOrThrow(_cursor, "episodes");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfGenres = CursorUtil.getColumnIndexOrThrow(_cursor, "genres");
          final int _cursorIndexOfStudios = CursorUtil.getColumnIndexOrThrow(_cursor, "studios");
          final int _cursorIndexOfAired = CursorUtil.getColumnIndexOrThrow(_cursor, "aired");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfRank = CursorUtil.getColumnIndexOrThrow(_cursor, "rank");
          final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<AnimeEntity> _result = new ArrayList<AnimeEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AnimeEntity _item;
            final int _tmpMalId;
            _tmpMalId = _cursor.getInt(_cursorIndexOfMalId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpTitleEnglish;
            if (_cursor.isNull(_cursorIndexOfTitleEnglish)) {
              _tmpTitleEnglish = null;
            } else {
              _tmpTitleEnglish = _cursor.getString(_cursorIndexOfTitleEnglish);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final String _tmpTrailerUrl;
            if (_cursor.isNull(_cursorIndexOfTrailerUrl)) {
              _tmpTrailerUrl = null;
            } else {
              _tmpTrailerUrl = _cursor.getString(_cursorIndexOfTrailerUrl);
            }
            final String _tmpSynopsis;
            if (_cursor.isNull(_cursorIndexOfSynopsis)) {
              _tmpSynopsis = null;
            } else {
              _tmpSynopsis = _cursor.getString(_cursorIndexOfSynopsis);
            }
            final Double _tmpScore;
            if (_cursor.isNull(_cursorIndexOfScore)) {
              _tmpScore = null;
            } else {
              _tmpScore = _cursor.getDouble(_cursorIndexOfScore);
            }
            final Integer _tmpEpisodes;
            if (_cursor.isNull(_cursorIndexOfEpisodes)) {
              _tmpEpisodes = null;
            } else {
              _tmpEpisodes = _cursor.getInt(_cursorIndexOfEpisodes);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final List<String> _tmpGenres;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfGenres)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfGenres);
            }
            _tmpGenres = __converters.toStringList(_tmp);
            final List<String> _tmpStudios;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfStudios)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfStudios);
            }
            _tmpStudios = __converters.toStringList(_tmp_1);
            final String _tmpAired;
            if (_cursor.isNull(_cursorIndexOfAired)) {
              _tmpAired = null;
            } else {
              _tmpAired = _cursor.getString(_cursorIndexOfAired);
            }
            final String _tmpRating;
            if (_cursor.isNull(_cursorIndexOfRating)) {
              _tmpRating = null;
            } else {
              _tmpRating = _cursor.getString(_cursorIndexOfRating);
            }
            final Integer _tmpRank;
            if (_cursor.isNull(_cursorIndexOfRank)) {
              _tmpRank = null;
            } else {
              _tmpRank = _cursor.getInt(_cursorIndexOfRank);
            }
            final Integer _tmpPopularity;
            if (_cursor.isNull(_cursorIndexOfPopularity)) {
              _tmpPopularity = null;
            } else {
              _tmpPopularity = _cursor.getInt(_cursorIndexOfPopularity);
            }
            final boolean _tmpIsFavorite;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_2 != 0;
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item = new AnimeEntity(_tmpMalId,_tmpTitle,_tmpTitleEnglish,_tmpImageUrl,_tmpTrailerUrl,_tmpSynopsis,_tmpScore,_tmpEpisodes,_tmpStatus,_tmpGenres,_tmpStudios,_tmpAired,_tmpRating,_tmpRank,_tmpPopularity,_tmpIsFavorite,_tmpTimestamp);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
