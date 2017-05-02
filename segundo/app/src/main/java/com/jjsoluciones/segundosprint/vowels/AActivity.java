package com.jjsoluciones.segundosprint.vowels;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjsoluciones.segundosprint.R;

/**
 * Created by Marili Arevalo on 20/02/2017.
 */

public class AActivity extends AppCompatActivity implements View.OnClickListener{

    private MediaPlayer mp;
    private SoundPool soundPool;
    private int loader;

    private MediaPlayer mp5;
    private SoundPool soundPool5;
    private int loader5;

    private TextView app;
    private ImageView apple;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocal_a_layout);

        app = (TextView)findViewById(R.id.app);
        app.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader = soundPool.load(this,R.raw.a,1);
        mp = new MediaPlayer();

        soundPool5 = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader5 = soundPool5.load(this,R.raw.apple,1);
        mp5 = new MediaPlayer();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.app:
                soundPool.play(loader,1,1,0,0,1);
                break;

            case R.id.apple:
                soundPool5.play(loader5,1,1,0,0,1);
                break;
            default:
                break;
        }

    }
}
