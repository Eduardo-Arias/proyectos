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

public class EActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mp;
    private SoundPool soundPool;
    private int loader;

    private MediaPlayer mp1;
    private SoundPool soundPool1;
    private int loader1;

    private TextView ele;
    private ImageView elep;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e);

        ele = (TextView)findViewById(R.id.ele);
        elep = (ImageView)findViewById(R.id.elep);


        ele.setOnClickListener(this);
        elep.setOnClickListener(this);


        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader = soundPool.load(this,R.raw.e,1);
        mp = new MediaPlayer();



        soundPool1 = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader1 = soundPool1.load(this,R.raw.ele,1);
        mp1 = new MediaPlayer();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ele:
                soundPool.play(loader,1,1,0,0,1);
                break;

            case R.id.elep:
                soundPool1.play(loader1,1,1,0,0,1);
                break;
            default:
                break;
        }

    }
}
