package com.example.app_festejos.Modelo.BaseDatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class MotorBaseDatosSQLite extends SQLiteOpenHelper {

    private SQLiteDatabase sqLiteDatabase;

    public MotorBaseDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /* ====================================================================================================== */
        //TABLA FAVORITOS
        db.execSQL("CREATE TABLE favoritos (ID INTEGER PRIMARY KEY AUTOINCREMENT, TITULO VARCHAR, DESCRIPCION VARCHAR, IMAGE BLOB)");
        //---- Registros
        /*
        db.execSQL("INSERT INTO favoritos VALUES (1, 'Vegetariana','sssssssssssss')");
        db.execSQL("INSERT INTO favoritos VALUES (2, 'Tres quesos','hhhhhhhhhhhhhhhhhh')");
        db.execSQL("INSERT INTO favoritos VALUES (3, 'Pollo Chanpiñones','eeeeeeeeeeeeeeeeee')");

         */

        /* ====================================================================================================== */
        //TABLA PRODUCTOS
        db.execSQL("CREATE TABLE productos (imagen INT, titulo TEXT,descripcion TEXT)");
        //---- Registros
        db.execSQL("INSERT INTO productos VALUES ( 0, 'Hawaiana','ttttttttttttttttttttttt')");
        db.execSQL("INSERT INTO productos VALUES ( 1, 'Napolitana','yyyyyyyyyyyyyyyyyyyyyyyyy')");
        db.execSQL("INSERT INTO productos VALUES ( 2, 'Peperoni','qqqqqqqqqqqqqqqqqqqqqqqqqqqqq')");

        /* ====================================================================================================== */
        //TABLA SERVICIOS
        db.execSQL("CREATE TABLE servicios (titulo TEXT,descripcion TEXT)");
        //---- Registros
        db.execSQL("INSERT INTO servicios VALUES ('Domicilios','wwwwwwwwwwwwwwwwwwwwwwwwwwww')");
        db.execSQL("INSERT INTO servicios VALUES ('Promociones','uuuuuuuuuuuuuuuuuuuuuuuuu')");
        db.execSQL("INSERT INTO servicios VALUES ('Puerta a Puerta','iiiiiiiiiiiiiiiiiiiiiiiiiiiiiii')");
        /* ====================================================================================================== */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS favoritos");
        db.execSQL("DROP TABLE IF EXISTS productos");
        db.execSQL("DROP TABLE IF EXISTS servicios");
        onCreate(db);
    }

    public void insertFavoritos(String titulo, String descripcion, byte[] image){
        String sql = "INSERT INTO favoritos VALUES (null, ?, ?, ?)";
        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, titulo);
        statement.bindString(2, descripcion);
        statement.bindBlob(3, image);

        statement.executeInsert();
    }

    public Cursor getFavoritos(){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM favoritos", null);
        return cursor;
    }

    public Cursor getFavoritosById(String id){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM favoritos WHERE ID =" + id, null);
        return cursor;
    }

    public void deleteFavorito(String id){
        String[] args = new String[]{id};
        sqLiteDatabase.delete("favoritos", "ID=?", args);
    }

    public void updateFavorito(String id, String titulo, String descripcion, byte[] image){
        String sql = "UPDATE favoritos SET TITULO = ?, DESCRIPCION = ?, IMAGE = ?";
        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, titulo);
        statement.bindString(2, descripcion);
        statement.bindBlob(3, image);

        statement.executeUpdateDelete();
    }
}
