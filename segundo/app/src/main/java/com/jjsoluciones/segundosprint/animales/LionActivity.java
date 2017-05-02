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


public class LionActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton ibtLion;
    private ImageButton ibtElephat;
    private ImageButton ibtPig;
    private ImageButton ibtUnknow;
    private MediaPlayer mediaPlayer;
    private SoundPool soundPool;
    private int loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lion);
        ibtUnknow = (ImageButton)findViewById(R.id.ibt_lion_des);
        ibtLion = (ImageButton)findViewById(R.id.ib_leon);
        ibtElephat = (ImageButton)findViewById(R.id.ibt_elephant);
        ibtPig = (ImageButton)findViewById(R.id.ibt_pig);

        ibtUnknow.setOnClickListener(this);
        ibtPig.setOnClickListener(this);
        ibtElephat.setOnClickListener(this);
        ibtLion.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader = soundPool.load(this, R.raw.leon,1);
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibt_lion_des:
                soundPool.play(loader, 1, 1,0,0,1);
                break;
            case R.id.ibt_elephant:
                Toast.makeText(this, "Incorrecto" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_leon:
                Intent i = new Intent(this, LionCorrActivity.class );
                startActivity(i);
                soundPool.stop(loader);
                finish();
                break;
            case R.id.ibt_pig:
                Toast.makeText(this, "Incorrecto" , Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
