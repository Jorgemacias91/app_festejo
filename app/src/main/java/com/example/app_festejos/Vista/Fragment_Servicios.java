package com.example.app_festejos.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.app_festejos.Modelo.Adaptador;
import com.example.app_festejos.Modelo.BaseDatos.MotorBaseDatosSQLite;
import com.example.app_festejos.Modelo.Entidad;
import com.example.app_festejos.R;

import java.util.ArrayList;


public class Fragment_Servicios extends Fragment {

    int [] imagen = {R.drawable.cleaning, R.drawable.decoration, R.drawable.food };

    String TAG = "Fragment_Servicios";

    View v;

    ListView listaServicios;
    Adaptador adaptador;

    // CONEXIÓN A LA BASE DE DATOS
    MotorBaseDatosSQLite conectar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment__servicios, container, false);
        //-----------------------------------------------------------------------------
        // content...
            listaServicios = (ListView) v.findViewById(R.id.lista_servicios);
            adaptador = new Adaptador(getTablaServicios(), getContext());

            listaServicios.setAdapter(adaptador);
        //-----------------------------------------------------------------------------
        return v;
    }

    private ArrayList<Entidad> getTablaServicios(){
        ArrayList<Entidad> listaProductos = new ArrayList<>();
        conectar = new MotorBaseDatosSQLite(getContext(), "TiendaProductos", null, 1);
        SQLiteDatabase db_leer = conectar.getReadableDatabase();
        Cursor cursor = db_leer.rawQuery("SELECT * FROM servicios", null);
        Log.v(TAG, "leyendo base de datos");

        while(cursor.moveToNext()){
            Log.v(TAG, "dentro del while");
            listaProductos.add(new Entidad(imagen[cursor.getInt(0)],cursor.getString(1), cursor.getString(1)));
            Log.v(TAG, "despues del while");
        }
        return listaProductos;
    }

}