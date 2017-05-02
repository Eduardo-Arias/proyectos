package com.jjsoluciones.segundosprint.animales;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.jjsoluciones.segundosprint.R;

public class ElephantActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton ibtMonkey;
    private ImageButton ibtDog;
    private ImageButton ibtElephant;
    private ImageButton ibtUnknow;
    private MediaPlayer mediaPlayer;
    private SoundPool soundPool;
    private int loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elephant);
        ibtUnknow = (ImageButton)findViewById(R.id.ibt_elephant_unknow);
        ibtMonkey = (ImageButton)findViewById(R.id.ibt_monkey);
        ibtDog = (ImageButton)findViewById(R.id.ibt_dog);
        ibtElephant = (ImageButton)findViewById(R.id.ib_elephant);

        ibtUnknow.setOnClickListener(this);
        ibtElephant.setOnClickListener(this);
        ibtDog.setOnClickListener(this);
        ibtMonkey.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader = soundPool.load(this, R.raw.elefante,1);
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibt_elephant_unknow:
                soundPool.play(loader, 1, 1,0,0,1);
                break;
            case R.id.ibt_dog:
                Toast.makeText(this, "Incorrecto" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_elephant:
                Intent i = new Intent(this, ElephantCorrActivity.class );
                startActivity(i);
                soundPool.stop(loader);
                finish();
                break;
            case R.id.ibt_monkey:
                Toast.makeText(this, "Incorrecto" , Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
