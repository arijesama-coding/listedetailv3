package mg.itu.listedetail;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
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
public final class ProduitDao_Impl implements ProduitDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Produit> __insertionAdapterOfProduit;

  public ProduitDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProduit = new EntityInsertionAdapter<Produit>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `produits` (`id`,`nom`,`origine`,`prixKg`,`stockKg`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Produit entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getNom());
        statement.bindString(3, entity.getOrigine());
        if (entity.getPrixKg() == null) {
          statement.bindNull(4);
        } else {
          statement.bindDouble(4, entity.getPrixKg());
        }
        statement.bindDouble(5, entity.getStockKg());
      }
    };
  }

  @Override
  public Object insererTous(final List<Produit> produits,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfProduit.insert(produits);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Produit>> tousLesProduits() {
    final String _sql = "SELECT * FROM produits ORDER BY nom ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"produits"}, new Callable<List<Produit>>() {
      @Override
      @NonNull
      public List<Produit> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
          final int _cursorIndexOfOrigine = CursorUtil.getColumnIndexOrThrow(_cursor, "origine");
          final int _cursorIndexOfPrixKg = CursorUtil.getColumnIndexOrThrow(_cursor, "prixKg");
          final int _cursorIndexOfStockKg = CursorUtil.getColumnIndexOrThrow(_cursor, "stockKg");
          final List<Produit> _result = new ArrayList<Produit>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Produit _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNom;
            _tmpNom = _cursor.getString(_cursorIndexOfNom);
            final String _tmpOrigine;
            _tmpOrigine = _cursor.getString(_cursorIndexOfOrigine);
            final Double _tmpPrixKg;
            if (_cursor.isNull(_cursorIndexOfPrixKg)) {
              _tmpPrixKg = null;
            } else {
              _tmpPrixKg = _cursor.getDouble(_cursorIndexOfPrixKg);
            }
            final double _tmpStockKg;
            _tmpStockKg = _cursor.getDouble(_cursorIndexOfStockKg);
            _item = new Produit(_tmpId,_tmpNom,_tmpOrigine,_tmpPrixKg,_tmpStockKg);
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
  public Object parId(final int id, final Continuation<? super Produit> $completion) {
    final String _sql = "SELECT * FROM produits WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Produit>() {
      @Override
      @Nullable
      public Produit call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
          final int _cursorIndexOfOrigine = CursorUtil.getColumnIndexOrThrow(_cursor, "origine");
          final int _cursorIndexOfPrixKg = CursorUtil.getColumnIndexOrThrow(_cursor, "prixKg");
          final int _cursorIndexOfStockKg = CursorUtil.getColumnIndexOrThrow(_cursor, "stockKg");
          final Produit _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNom;
            _tmpNom = _cursor.getString(_cursorIndexOfNom);
            final String _tmpOrigine;
            _tmpOrigine = _cursor.getString(_cursorIndexOfOrigine);
            final Double _tmpPrixKg;
            if (_cursor.isNull(_cursorIndexOfPrixKg)) {
              _tmpPrixKg = null;
            } else {
              _tmpPrixKg = _cursor.getDouble(_cursorIndexOfPrixKg);
            }
            final double _tmpStockKg;
            _tmpStockKg = _cursor.getDouble(_cursorIndexOfStockKg);
            _result = new Produit(_tmpId,_tmpNom,_tmpOrigine,_tmpPrixKg,_tmpStockKg);
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
  public Flow<List<Produit>> parPrixDecroissant() {
    final String _sql = "SELECT * FROM PRODUITS ORDER BY prixKg IS NULL, prixKg DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"PRODUITS"}, new Callable<List<Produit>>() {
      @Override
      @NonNull
      public List<Produit> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
          final int _cursorIndexOfOrigine = CursorUtil.getColumnIndexOrThrow(_cursor, "origine");
          final int _cursorIndexOfPrixKg = CursorUtil.getColumnIndexOrThrow(_cursor, "prixKg");
          final int _cursorIndexOfStockKg = CursorUtil.getColumnIndexOrThrow(_cursor, "stockKg");
          final List<Produit> _result = new ArrayList<Produit>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Produit _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNom;
            _tmpNom = _cursor.getString(_cursorIndexOfNom);
            final String _tmpOrigine;
            _tmpOrigine = _cursor.getString(_cursorIndexOfOrigine);
            final Double _tmpPrixKg;
            if (_cursor.isNull(_cursorIndexOfPrixKg)) {
              _tmpPrixKg = null;
            } else {
              _tmpPrixKg = _cursor.getDouble(_cursorIndexOfPrixKg);
            }
            final double _tmpStockKg;
            _tmpStockKg = _cursor.getDouble(_cursorIndexOfStockKg);
            _item = new Produit(_tmpId,_tmpNom,_tmpOrigine,_tmpPrixKg,_tmpStockKg);
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
  public Flow<List<Produit>> stockSuperieurA(final double seuilKg) {
    final String _sql = "SELECT * FROM produits WHERE prixKg > ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindDouble(_argIndex, seuilKg);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"produits"}, new Callable<List<Produit>>() {
      @Override
      @NonNull
      public List<Produit> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
          final int _cursorIndexOfOrigine = CursorUtil.getColumnIndexOrThrow(_cursor, "origine");
          final int _cursorIndexOfPrixKg = CursorUtil.getColumnIndexOrThrow(_cursor, "prixKg");
          final int _cursorIndexOfStockKg = CursorUtil.getColumnIndexOrThrow(_cursor, "stockKg");
          final List<Produit> _result = new ArrayList<Produit>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Produit _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNom;
            _tmpNom = _cursor.getString(_cursorIndexOfNom);
            final String _tmpOrigine;
            _tmpOrigine = _cursor.getString(_cursorIndexOfOrigine);
            final Double _tmpPrixKg;
            if (_cursor.isNull(_cursorIndexOfPrixKg)) {
              _tmpPrixKg = null;
            } else {
              _tmpPrixKg = _cursor.getDouble(_cursorIndexOfPrixKg);
            }
            final double _tmpStockKg;
            _tmpStockKg = _cursor.getDouble(_cursorIndexOfStockKg);
            _item = new Produit(_tmpId,_tmpNom,_tmpOrigine,_tmpPrixKg,_tmpStockKg);
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
  public Flow<Double> stockTotal() {
    final String _sql = "SELECT SUM(stockKg) FROM produits";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"produits"}, new Callable<Double>() {
      @Override
      @Nullable
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
            }
            _result = _tmp;
          } else {
            _result = null;
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
