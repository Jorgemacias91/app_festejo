package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button boton1;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = (Button) findViewById(R.id.button1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent servicios = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(servicios);
            }
        });
        text1 = (TextView) findViewById(R.id.text1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuoptions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.productOpt){
            Intent productos = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(productos);
        }
        if(id == R.id.serviceOpt){
            Intent servicios = new Intent(getApplicationContext(), MainActivity3.class);
            startActivity(servicios);
        }
        if(id == R.id.sucurOpt){
            Intent sucursales = new Intent(getApplicationContext(), MainActivity4.class);
            startActivity(sucursales);
        }
        return super.onOptionsItemSelected(item);
    }
}