package com.animeapp.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AnimeDatabase_Impl extends AnimeDatabase {
  private volatile AnimeDao _animeDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `anime` (`malId` INTEGER NOT NULL, `title` TEXT NOT NULL, `titleEnglish` TEXT, `imageUrl` TEXT, `trailerUrl` TEXT, `synopsis` TEXT, `score` REAL, `episodes` INTEGER, `status` TEXT, `genres` TEXT NOT NULL, `studios` TEXT NOT NULL, `aired` TEXT, `rating` TEXT, `rank` INTEGER, `popularity` INTEGER, `isFavorite` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, PRIMARY KEY(`malId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ff60387af9b75734ed355e9e98cbb6c1')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `anime`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsAnime = new HashMap<String, TableInfo.Column>(17);
        _columnsAnime.put("malId", new TableInfo.Column("malId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnime.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnime.put("titleEnglish", new TableInfo.Column("titleEnglish", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnime.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnime.put("trailerUrl", new TableInfo.Column("trailerUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnime.put("synopsis", new TableInfo.Column("synopsis", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnime.put("score", new TableInfo.Column("score", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnime.put("episodes", new TableInfo.Column("episodes", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnime.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnime.put("genres", new TableInfo.Column("genres", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnime.put("studios", new TableInfo.Column("studios", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnime.put("aired", new TableInfo.Column("aired", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnime.put("rating", new TableInfo.Column("rating", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnime.put("rank", new TableInfo.Column("rank", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnime.put("popularity", new TableInfo.Column("popularity", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnime.put("isFavorite", new TableInfo.Column("isFavorite", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAnime.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAnime = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAnime = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAnime = new TableInfo("anime", _columnsAnime, _foreignKeysAnime, _indicesAnime);
        final TableInfo _existingAnime = TableInfo.read(db, "anime");
        if (!_infoAnime.equals(_existingAnime)) {
          return new RoomOpenHelper.ValidationResult(false, "anime(com.animeapp.data.local.entity.AnimeEntity).\n"
                  + " Expected:\n" + _infoAnime + "\n"
                  + " Found:\n" + _existingAnime);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "ff60387af9b75734ed355e9e98cbb6c1", "c96b474c005ac2b4da780c6fa3a228d8");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "anime");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `anime`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(AnimeDao.class, AnimeDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public AnimeDao animeDao() {
    if (_animeDao != null) {
      return _animeDao;
    } else {
      synchronized(this) {
        if(_animeDao == null) {
          _animeDao = new AnimeDao_Impl(this);
        }
        return _animeDao;
      }
    }
  }
}
