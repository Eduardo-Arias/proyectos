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

public class Diamond extends AppCompatActivity implements View.OnClickListener{


    private ImageButton ibtDiamond;
    private ImageButton ibtSiguiente;
    private ImageButton ibtAnterior;
    private MediaPlayer mediaPlayer;
    private SoundPool soundPool;
    private int loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diamond_activity_main);
        ibtDiamond = (ImageButton)findViewById(R.id.ibt_diamond);
        ibtSiguiente = (ImageButton) findViewById(R.id.ibt_siguiente);
        ibtAnterior = (ImageButton) findViewById(R.id.ibt_anterior);

        ibtDiamond.setOnClickListener(this);
        ibtSiguiente.setOnClickListener(this);
        ibtAnterior.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader = soundPool.load(this, R.raw.rombo,1);
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibt_diamond:
                soundPool.play(loader, 1, 1,0,0,1);
                break;
            case R.id.ibt_siguiente:
                Intent i = new Intent(this, Rectangle.class);
                startActivity(i);
                finish();
                break;
            case R.id.ibt_anterior:
                Intent intent = new Intent(this, Circle.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }
}
