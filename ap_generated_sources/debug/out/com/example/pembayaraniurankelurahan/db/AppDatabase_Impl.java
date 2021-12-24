package com.example.pembayaraniurankelurahan.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile wargaDao _wargaDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `wargaEntity` (`idWarga` INTEGER NOT NULL, `Nama` TEXT, `Alamat` TEXT, `NIK` INTEGER NOT NULL, `JenisKelamin` TEXT, `Iuran` TEXT, `AnggotaKK` INTEGER NOT NULL, PRIMARY KEY(`idWarga`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '93bf37882253dc7a892c3024f121386b')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `wargaEntity`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsWargaEntity = new HashMap<String, TableInfo.Column>(7);
        _columnsWargaEntity.put("idWarga", new TableInfo.Column("idWarga", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWargaEntity.put("Nama", new TableInfo.Column("Nama", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWargaEntity.put("Alamat", new TableInfo.Column("Alamat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWargaEntity.put("NIK", new TableInfo.Column("NIK", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWargaEntity.put("JenisKelamin", new TableInfo.Column("JenisKelamin", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWargaEntity.put("Iuran", new TableInfo.Column("Iuran", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWargaEntity.put("AnggotaKK", new TableInfo.Column("AnggotaKK", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWargaEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWargaEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWargaEntity = new TableInfo("wargaEntity", _columnsWargaEntity, _foreignKeysWargaEntity, _indicesWargaEntity);
        final TableInfo _existingWargaEntity = TableInfo.read(_db, "wargaEntity");
        if (! _infoWargaEntity.equals(_existingWargaEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "wargaEntity(com.example.pembayaraniurankelurahan.db.wargaEntity).\n"
                  + " Expected:\n" + _infoWargaEntity + "\n"
                  + " Found:\n" + _existingWargaEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "93bf37882253dc7a892c3024f121386b", "d0e9e039fe73cf78be453ea3375a42bc");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "wargaEntity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `wargaEntity`");
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
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(wargaDao.class, wargaDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public wargaDao wargaDao() {
    if (_wargaDao != null) {
      return _wargaDao;
    } else {
      synchronized(this) {
        if(_wargaDao == null) {
          _wargaDao = new wargaDao_Impl(this);
        }
        return _wargaDao;
      }
    }
  }
}
