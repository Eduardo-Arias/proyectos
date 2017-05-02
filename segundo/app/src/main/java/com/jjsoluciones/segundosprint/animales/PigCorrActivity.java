package com.jjsoluciones.segundosprint.animales;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.jjsoluciones.segundosprint.R;

public class PigCorrActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton ibtPigCorr;
    private Button btPigFin;
    private MediaPlayer mediaPlayer;
    private SoundPool soundPool;
    private int loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pig_corr);
        ibtPigCorr = (ImageButton)findViewById(R.id.ibt_res_pig);
        btPigFin = (Button)findViewById(R.id.bt_cont_pig);

        ibtPigCorr.setOnClickListener(this);
        btPigFin.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader = soundPool.load(this, R.raw.pig_pro,1);
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibt_res_pig:
                soundPool.play(loader, 1, 1,0,0,1);
                break;
            case R.id.bt_cont_pig:
                Intent i = new Intent(this, FinishsAnimalsActivity.class);
                startActivity(i);
                soundPool.stop(loader);
                finish();
                break;
        }
    }
}