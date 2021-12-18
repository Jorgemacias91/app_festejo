package com.example.app_festejos.Modelo.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MotorBaseDatosSQLite extends SQLiteOpenHelper {


    public MotorBaseDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        /* ====================================================================================================== */
        //TABLA FAVORITOS
        db.execSQL("CREATE TABLE favoritos (id INT, titulo TEXT,descripcion TEXT)");
        //---- Registros
        /*=======================================================================================
        db.execSQL("INSERT INTO favoritos VALUES (1, 'fiesta navideña','descripcion 1')");
        db.execSQL("INSERT INTO favoritos VALUES (2, 'fiesta escolar','descipcion 2')");
        db.execSQL("INSERT INTO favoritos VALUES (3, 'fiesta popular','descripcion 3')");
          */

        /* ====================================================================================================== */
        //TABLA PRODUCTOS
        db.execSQL("CREATE TABLE productos (imagen INT, titulo TEXT,descripcion TEXT)");
        //---- Registros
        db.execSQL("INSERT INTO productos VALUES ( 0, 'Fiesta Juvenil','Celebra la juventud')");
        db.execSQL("INSERT INTO productos VALUES ( 1, 'Fiesta de niños','celebra en grande')");
        db.execSQL("INSERT INTO productos VALUES ( 2, 'Fiesta de 15','Celebra tus 15 primaveras')");

        /* ====================================================================================================== */
        //TABLA SERVICIOS
        db.execSQL("CREATE TABLE servicios (titulo TEXT,descripcion TEXT)");
        //---- Registros
        db.execSQL("INSERT INTO servicios VALUES ( 0, 'Limpieza','Servicio de limpieza')");
        db.execSQL("INSERT INTO servicios VALUES ( 1, 'Gastronomia','Servicio de comida')");
        db.execSQL("INSERT INTO servicios VALUES ( 2, 'Decoración','Servicio de decoración')");



        /* ======================================================================================================*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE favoritos");
        db.execSQL("DROP TABLE productos");
        db.execSQL("DROP TABLE servicios");
        onCreate(db);

    }


}
