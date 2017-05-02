package com.jjsoluciones.segundosprint.vowels;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjsoluciones.segundosprint.R;

/**
 * Created by Marili Arevalo on 20/02/2017.
 */

public class OActivity extends AppCompatActivity implements View.OnClickListener{

    private MediaPlayer mp;
    private SoundPool soundPool;
    private int loader;


    private MediaPlayer mp3;
    private SoundPool soundPool3;
    private int loader3;

    private TextView octo;
    private ImageView pul;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.o);

        octo = (TextView)findViewById(R.id.octo);
        pul = (ImageView)findViewById(R.id.pul);


        octo.setOnClickListener(this);
        pul.setOnClickListener(this);


        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader = soundPool.load(this,R.raw.o,1);
        mp = new MediaPlayer();



        soundPool3 = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader3 = soundPool3.load(this,R.raw.octo,1);
        mp3 = new MediaPlayer();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.octo:
                soundPool.play(loader,1,1,0,0,1);
                break;

            case R.id.pul:
                soundPool3.play(loader3,1,1,0,0,1);
                break;
            default:
                break;
        }

    }
}
