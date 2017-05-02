package com.jjsoluciones.segundosprint.figuras;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.jjsoluciones.segundosprint.R;

/**
 * Created by Marili Arevalo on 26/04/2017.
 */

public class Circle extends AppCompatActivity implements View.OnClickListener {

    private ImageButton ibtCircle;
    private ImageButton ibtSiguiente;
    private ImageButton ibtAnterior;
    private MediaPlayer mediaPlayer;
    private SoundPool soundPool;
    private int loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_activity_main);
        ibtCircle = (ImageButton)findViewById(R.id.ibt_circle);
        ibtSiguiente = (ImageButton) findViewById(R.id.ibt_siguiente);
        ibtAnterior = (ImageButton) findViewById(R.id.ibt_anterior);

        ibtCircle.setOnClickListener(this);
        ibtSiguiente.setOnClickListener(this);
        ibtAnterior.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader = soundPool.load(this, R.raw.circulo,1);
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibt_circle:
                soundPool.play(loader, 1, 1,0,0,1);
                break;
            case R.id.ibt_siguiente:
                Intent i = new Intent(this, Diamond.class);
                startActivity(i);
                finish();
                break;
            case R.id.ibt_anterior:
                Intent intent = new Intent(this, MainActivityFiguras.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }
}
