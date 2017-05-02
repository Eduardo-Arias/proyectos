package com.jjsoluciones.segundosprint.fruits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjsoluciones.segundosprint.R;

public class Main extends AppCompatActivity {
    private Button btVerduras;
    private Button btFrutas;

    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_verduras);

        btFrutas= (Button)findViewById(R.id.bt_frutas);
        btVerduras = (Button)findViewById(R.id.bt_verduras);

        btVerduras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(Main.this,Verduras.class);
                startActivity(i);
            }
        });
        btFrutas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(Main.this,FrutaActivity.class);
                startActivity(i);
            }
        });
    }
}
