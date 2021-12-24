package com.example.pembayaraniurankelurahan.db;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class wargaDao_Impl implements wargaDao {
  private final RoomDatabase __db;

  private final EntityDeletionOrUpdateAdapter<wargaEntity> __deletionAdapterOfwargaEntity;

  private final SharedSQLiteStatement __preparedStmtOfInsertAll;

  private final SharedSQLiteStatement __preparedStmtOfUpdate;

  public wargaDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__deletionAdapterOfwargaEntity = new EntityDeletionOrUpdateAdapter<wargaEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `wargaEntity` WHERE `idWarga` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, wargaEntity value) {
        stmt.bindLong(1, value.idWarga);
      }
    };
    this.__preparedStmtOfInsertAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "INSERT INTO wargaEntity (Nama,Alamat,NIK,JenisKelamin,Iuran,AnggotaKK) VALUES(?,?,?,?,?,?)";
        return _query;
      }
    };
    this.__preparedStmtOfUpdate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE wargaEntity SET Nama=?, Alamat=?, NIK=?, JenisKelamin=? WHERE idWarga=?";
        return _query;
      }
    };
  }

  @Override
  public void delete(final wargaEntity wargaEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfwargaEntity.handle(wargaEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final String Nama, final String Alamat, final Integer NIK,
      final String JenisKelamin, final String Iuran, final Integer AnggotaKK) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfInsertAll.acquire();
    int _argIndex = 1;
    if (Nama == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Nama);
    }
    _argIndex = 2;
    if (Alamat == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Alamat);
    }
    _argIndex = 3;
    if (NIK == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, NIK);
    }
    _argIndex = 4;
    if (JenisKelamin == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, JenisKelamin);
    }
    _argIndex = 5;
    if (Iuran == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Iuran);
    }
    _argIndex = 6;
    if (AnggotaKK == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, AnggotaKK);
    }
    __db.beginTransaction();
    try {
      _stmt.executeInsert();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfInsertAll.release(_stmt);
    }
  }

  @Override
  public void update(final int idWarga, final String Nama, final String Alamat, final Integer NIK,
      final String JenisKelamin) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdate.acquire();
    int _argIndex = 1;
    if (Nama == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Nama);
    }
    _argIndex = 2;
    if (Alamat == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Alamat);
    }
    _argIndex = 3;
    if (NIK == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, NIK);
    }
    _argIndex = 4;
    if (JenisKelamin == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, JenisKelamin);
    }
    _argIndex = 5;
    _stmt.bindLong(_argIndex, idWarga);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdate.release(_stmt);
    }
  }

  @Override
  public List<wargaEntity> getAll() {
    final String _sql = "SELECT * FROM wargaEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIdWarga = CursorUtil.getColumnIndexOrThrow(_cursor, "idWarga");
      final int _cursorIndexOfFullname = CursorUtil.getColumnIndexOrThrow(_cursor, "Nama");
      final int _cursorIndexOfAlamat = CursorUtil.getColumnIndexOrThrow(_cursor, "Alamat");
      final int _cursorIndexOfNIKKITAS = CursorUtil.getColumnIndexOrThrow(_cursor, "NIK");
      final int _cursorIndexOfJeniskelamin = CursorUtil.getColumnIndexOrThrow(_cursor, "JenisKelamin");
      final int _cursorIndexOfIuran = CursorUtil.getColumnIndexOrThrow(_cursor, "Iuran");
      final int _cursorIndexOfAnggota = CursorUtil.getColumnIndexOrThrow(_cursor, "AnggotaKK");
      final List<wargaEntity> _result = new ArrayList<wargaEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final wargaEntity _item;
        _item = new wargaEntity();
        _item.idWarga = _cursor.getInt(_cursorIndexOfIdWarga);
        if (_cursor.isNull(_cursorIndexOfFullname)) {
          _item.fullname = null;
        } else {
          _item.fullname = _cursor.getString(_cursorIndexOfFullname);
        }
        if (_cursor.isNull(_cursorIndexOfAlamat)) {
          _item.alamat = null;
        } else {
          _item.alamat = _cursor.getString(_cursorIndexOfAlamat);
        }
        _item.NIK_KITAS = _cursor.getInt(_cursorIndexOfNIKKITAS);
        if (_cursor.isNull(_cursorIndexOfJeniskelamin)) {
          _item.jeniskelamin = null;
        } else {
          _item.jeniskelamin = _cursor.getString(_cursorIndexOfJeniskelamin);
        }
        if (_cursor.isNull(_cursorIndexOfIuran)) {
          _item.iuran = null;
        } else {
          _item.iuran = _cursor.getString(_cursorIndexOfIuran);
        }
        _item.anggota = _cursor.getInt(_cursorIndexOfAnggota);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public wargaEntity get(final int idWarga) {
    final String _sql = "SELECT * FROM wargaEntity WHERE idWarga=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, idWarga);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIdWarga = CursorUtil.getColumnIndexOrThrow(_cursor, "idWarga");
      final int _cursorIndexOfFullname = CursorUtil.getColumnIndexOrThrow(_cursor, "Nama");
      final int _cursorIndexOfAlamat = CursorUtil.getColumnIndexOrThrow(_cursor, "Alamat");
      final int _cursorIndexOfNIKKITAS = CursorUtil.getColumnIndexOrThrow(_cursor, "NIK");
      final int _cursorIndexOfJeniskelamin = CursorUtil.getColumnIndexOrThrow(_cursor, "JenisKelamin");
      final int _cursorIndexOfIuran = CursorUtil.getColumnIndexOrThrow(_cursor, "Iuran");
      final int _cursorIndexOfAnggota = CursorUtil.getColumnIndexOrThrow(_cursor, "AnggotaKK");
      final wargaEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new wargaEntity();
        _result.idWarga = _cursor.getInt(_cursorIndexOfIdWarga);
        if (_cursor.isNull(_cursorIndexOfFullname)) {
          _result.fullname = null;
        } else {
          _result.fullname = _cursor.getString(_cursorIndexOfFullname);
        }
        if (_cursor.isNull(_cursorIndexOfAlamat)) {
          _result.alamat = null;
        } else {
          _result.alamat = _cursor.getString(_cursorIndexOfAlamat);
        }
        _result.NIK_KITAS = _cursor.getInt(_cursorIndexOfNIKKITAS);
        if (_cursor.isNull(_cursorIndexOfJeniskelamin)) {
          _result.jeniskelamin = null;
        } else {
          _result.jeniskelamin = _cursor.getString(_cursorIndexOfJeniskelamin);
        }
        if (_cursor.isNull(_cursorIndexOfIuran)) {
          _result.iuran = null;
        } else {
          _result.iuran = _cursor.getString(_cursorIndexOfIuran);
        }
        _result.anggota = _cursor.getInt(_cursorIndexOfAnggota);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
