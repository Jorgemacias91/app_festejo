package com.example.app_festejos.Vista;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.app_festejos.R;
import com.google.android.material.snackbar.Snackbar;


public class Fragment_Inicio extends Fragment {

    View v;
    private Button btnMensaje, btnNotificacion, btnDialogo;
    private LinearLayout linearLayout;
    private final static String CHANEL_ID = "NOTIFICACION";
    private final static int NOTIFICATION_ID = 0;

    public void createDialogo(String titulo, String contenido){
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle(titulo);
        builder.setMessage(contenido)
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Si presionado...", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "No presionado...", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    public void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Notification";
            NotificationChannel notificationChannel = new NotificationChannel(CHANEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public void createNotification(String titulo, String contenido){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), CHANEL_ID);
        builder.setSmallIcon(R.mipmap.ic_logo);
        //builder.setLargeIcon(R.drawable.ic_baseline_card_giftcard_24);
        builder.setContentTitle(titulo);
        builder.setContentText(contenido);
        builder.setDefaults(NotificationCompat.PRIORITY_DEFAULT);
        builder.setColor(Color.MAGENTA);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getContext());
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment__inicio, container, false);
        //-----------------------------------------------------------------------------
        // content...

        btnMensaje = v.findViewById(R.id.buttonMensaje);
        btnNotificacion = v.findViewById(R.id.buttonNotificacion);
        btnDialogo = v.findViewById(R.id.buttonDialogo);

        linearLayout = v.findViewById(R.id.mainInicio);

        btnMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(linearLayout, "Creado con exito", Snackbar.LENGTH_LONG);
                snackbar.setAction("Ver", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Nuevo artículo creado...", Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.show();
            }
        });

        btnNotificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotificationChannel();
                createNotification("titulo noti", "soy una noti");
            }
        });

        btnDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialogo("hola", "contenido hola");
            }
        });

        //-----------------------------------------------------------------------------
        return v;
    }


}