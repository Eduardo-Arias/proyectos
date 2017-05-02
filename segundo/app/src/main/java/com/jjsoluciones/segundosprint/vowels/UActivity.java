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

public class UActivity extends AppCompatActivity implements View.OnClickListener{

    private MediaPlayer mp;
    private SoundPool soundPool;
    private int loader;

    private MediaPlayer mp4;
    private SoundPool soundPool4;
    private int loader4;

    private TextView uni;
    private ImageView nube;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u);

        uni = (TextView)findViewById(R.id.uni);
        nube = (ImageView)findViewById(R.id.nube);


        uni.setOnClickListener(this);
        nube.setOnClickListener(this);


        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader = soundPool.load(this,R.raw.u,1);
        mp = new MediaPlayer();



        soundPool4 = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader4 = soundPool4.load(this,R.raw.uni,1);
        mp4 = new MediaPlayer();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.uni:
                soundPool.play(loader,1,1,0,0,1);
                break;

            case R.id.nube:
                soundPool4.play(loader4,1,1,0,0,1);
                break;
            default:
                break;
        }
    }
}
