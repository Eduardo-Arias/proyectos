package com.jjsoluciones.segundosprint.moviles;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjsoluciones.segundosprint.R;

public class MainNumerosMoviles extends AppCompatActivity {
    //variables para cambiar elegir nivel de dificultad, redirecciona a otra vista
    private Button btFacil;
    private Button btMedio;
    private Button btDificil;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_numeros_moviles);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//posicion de la pantalla en horizontal

        //se relacionan las variales con las variables de la vista
        btFacil = (Button)findViewById(R.id.bt_facil);
        btMedio = (Button)findViewById(R.id.bt_medio);
        btDificil = (Button)findViewById(R.id.bt_dificil);

        //se capta el evento onClick y se redirecciona a la vista de juego correspondiente
        btFacil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainNumerosMoviles.this, NumerosFaciles.class);
                startActivity(i);
            }
        });

        btMedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainNumerosMoviles.this,NumerosMedios.class);
                startActivity(i);
            }
        });

        btDificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainNumerosMoviles.this, NumerosDificil.class);
                startActivity(i);
            }
        });

    }
}
