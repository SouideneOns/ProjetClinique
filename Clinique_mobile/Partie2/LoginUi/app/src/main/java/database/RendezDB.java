package database;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;

import java.util.*;

import entities.*;

public class RendezDB extends SQLiteOpenHelper {

    private static String dbName = "RendezDB";
    private static String tableName = "rendez";
    private static String idColumn = "id";
    private static String nameColumn = "name";
    private static String dateColumn = "date";
    private static String etatColumn = "etat";
    private Context context;

    public RendezDB(Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + tableName + "(" + idColumn + " integer primary key autoincrement, " + nameColumn + " text, " + dateColumn + " text,"+etatColumn+" text " + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + tableName);
        onCreate(sqLiteDatabase);
    }

    public List<Rendez> findAll() {
        try {
            List<Rendez> rendezs = new ArrayList<Rendez>();
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + tableName, null);
            if (cursor.moveToFirst()) {
                do {
                    Rendez rendez = new Rendez();
                    rendez.setId(cursor.getInt(0));
                    rendez.setName(cursor.getString(1));
                    rendez.setDate(cursor.getString(2));
                    rendez.setEtat(cursor.getString(3));
                    rendezs.add(rendez);
                } while (cursor.moveToNext());
            }
            sqLiteDatabase.close();
            return rendezs;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean create(Rendez rendez) {
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(nameColumn, rendez.getName());
            contentValues.put(dateColumn, rendez.getDate());
            contentValues.put(etatColumn, rendez.getEtat());
            long rows = sqLiteDatabase.insert(tableName, null, contentValues);
            sqLiteDatabase.close();
            return rows > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(int id){
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            int rows = sqLiteDatabase.delete(tableName, idColumn + " = ?", new String[] { String.valueOf(id) });
            sqLiteDatabase.close();
            return rows > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public Rendez find(int id){
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + tableName + " where " + idColumn + " = ?", new String[]{ String.valueOf(id) });
            Rendez rendez = null;
            if (cursor.moveToFirst()){
                rendez = new Rendez();
                rendez.setId(cursor.getInt(0));
                rendez.setName(cursor.getString(1));
                rendez.setDate(cursor.getString(2));
                rendez.setEtat(cursor.getString(3));
            }
            sqLiteDatabase.close();
            return rendez;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean update(Rendez rendez){
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(nameColumn, rendez.getName());
            contentValues.put(dateColumn, rendez.getDate());
            contentValues.put(etatColumn, rendez.getEtat());
            int rows = sqLiteDatabase.update(tableName, contentValues, idColumn + " = ?", new String[] { String.valueOf(rendez.getId()) });
            sqLiteDatabase.close();
            return rows > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
