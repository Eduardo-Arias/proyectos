package com.jjsoluciones.segundosprint.colores;

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
 * Created by danie on 17/02/2017.
 */

public class PinkActivity extends AppCompatActivity implements View.OnClickListener{

private ImageButton ibtPink;
private ImageButton ibtSiguiente;
        private ImageButton ibtAnterior;
private MediaPlayer mediaPlayer;
private SoundPool soundPool;
private int loader;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_pink);
        ibtPink = (ImageButton)findViewById(R.id.ibt_pink);
        ibtSiguiente = (ImageButton) findViewById(R.id.ibt_siguiente);
        ibtAnterior = (ImageButton) findViewById(R.id.ibt_anterior);

        ibtPink.setOnClickListener(this);
        ibtSiguiente.setOnClickListener(this);
        ibtAnterior.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader = soundPool.load(this, R.raw.pink,1);
        mediaPlayer = new MediaPlayer();
        }

@Override
public void onClick(View v) {
        switch (v.getId()){
        case R.id.ibt_pink:
        soundPool.play(loader, 1, 1,0,0,1);
        break;
        case R.id.ibt_siguiente:
        Intent i = new Intent(this, RedActivity.class);
        startActivity(i);
                finish();
        break;
                case R.id.ibt_anterior:
                        Intent intent = new Intent(this, GreyActivity.class);
                        startActivity(intent);
                        finish();
                        break;
default:
        break;
        }
        }
        }