package com.tankarsolutions.finddotsbraintraininggame.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tankarsolutions.finddotsbraintraininggame.entity.GameDB;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GameDao_Impl implements GameDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GameDB> __insertionAdapterOfGameDB;

  public GameDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGameDB = new EntityInsertionAdapter<GameDB>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `gameDB` (`id`,`game_type`,`accuracy`,`time`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GameDB value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getGame_type());
        stmt.bindLong(3, value.getAccuracy());
        stmt.bindLong(4, value.getTime());
      }
    };
  }

  @Override
  public void insertData(final GameDB gameDB) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGameDB.insert(gameDB);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<GameDB>> getAllData() {
    final String _sql = "SELECT * FROM gameDB ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"gameDB"}, false, new Callable<List<GameDB>>() {
      @Override
      public List<GameDB> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfGameType = CursorUtil.getColumnIndexOrThrow(_cursor, "game_type");
          final int _cursorIndexOfAccuracy = CursorUtil.getColumnIndexOrThrow(_cursor, "accuracy");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final List<GameDB> _result = new ArrayList<GameDB>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final GameDB _item;
            final int _tmpGame_type;
            _tmpGame_type = _cursor.getInt(_cursorIndexOfGameType);
            final int _tmpAccuracy;
            _tmpAccuracy = _cursor.getInt(_cursorIndexOfAccuracy);
            final long _tmpTime;
            _tmpTime = _cursor.getLong(_cursorIndexOfTime);
            _item = new GameDB(_tmpGame_type,_tmpAccuracy,_tmpTime);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
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
}
