package com.jjsoluciones.segundosprint.figuras;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.jjsoluciones.segundosprint.R;

/**
 * Created by Marili Arevalo on 26/04/2017.
 */

public class Triangle extends AppCompatActivity implements View.OnClickListener {


    private ImageButton ibtTriangle;
    private ImageButton ibtSiguiente;
    private ImageButton ibtAnterior;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triangle_activity_main);
        ibtTriangle = (ImageButton)findViewById(R.id.ibt_triangle);
        ibtSiguiente = (ImageButton) findViewById(R.id.ibt_siguiente);
        ibtAnterior = (ImageButton) findViewById(R.id.ibt_anterior);

        ibtTriangle.setOnClickListener(this);
        ibtSiguiente.setOnClickListener(this);
        ibtAnterior.setOnClickListener(this);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this,R.raw.triangulo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibt_triangle:
                mediaPlayer.start();
                break;
            case R.id.ibt_siguiente:
                Intent i = new Intent(this, MainActivityFiguras.class);
                startActivity(i);
                finish();
                break;
            case R.id.ibt_anterior:
                Intent intent = new Intent(this, Square.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }
}
