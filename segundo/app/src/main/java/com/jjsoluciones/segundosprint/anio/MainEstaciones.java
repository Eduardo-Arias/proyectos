package com.jjsoluciones.segundosprint.anio;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.jjsoluciones.segundosprint.R;


public class MainEstaciones extends AppCompatActivity implements View.OnClickListener{
    //variables contenedoras de las imagenes de las estaciones
    private ImageView txPrimavera;
    private ImageView txVerano;
    private ImageView txOtonio;
    private ImageView txInvierno;


    /**
     * Se castean las variables y se le asigna el metodo onClickListener, para la navegacion entere
     * las pantallas
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_estaciones);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //se asigna el correspondiente de la vista para el manejo de los elementos
        txPrimavera=(ImageView) findViewById(R.id.iv_primavera);
        txVerano = (ImageView) findViewById(R.id.iv_verano);
        txOtonio = (ImageView) findViewById(R.id.iv_otonio);
        txInvierno = (ImageView) findViewById(R.id.iv_invierno);

        //se asigna el metodo onClick para la navegacion entre las multiples pantallas
        txPrimavera.setOnClickListener(this);
        txVerano.setOnClickListener(this);
        txOtonio.setOnClickListener(this);
        txInvierno.setOnClickListener(this);
    }

    /**
     * Metodo en el cual sirve para redirecciona a los layout correspondientes a las imagenes que
     * se presenta en la vista
     * @param v
     */
    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.iv_primavera:
                i = new Intent(this, PrimaveraActivity.class);
                startActivity(i);
                break;
            case R.id.iv_verano:
                i = new Intent(this, VeranoActivity.class);
                startActivity(i);
                break;
            case R.id.iv_otonio:
                i = new Intent(this, OtonioActivity.class);
                startActivity(i);
                break;
            case R.id.iv_invierno:
                i = new Intent(this, InviernoActivity.class);
                startActivity(i);
                break;
        }
    }
}
