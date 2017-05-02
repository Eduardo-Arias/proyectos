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


public class CatCorrActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton ibtRespCat;
    private Button btContinuos;
    private MediaPlayer mediaPlayer;
    private SoundPool soundPool;
    private int loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_corr);
        ibtRespCat = (ImageButton)findViewById(R.id.ibt_res_cat);
        btContinuos = (Button)findViewById(R.id.bt_cont_cat);

        ibtRespCat.setOnClickListener(this);
        btContinuos.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader = soundPool.load(this, R.raw.cat_pro,1);
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibt_res_cat:
                soundPool.play(loader, 1, 1,0,0,1);
                break;
            case R.id.bt_cont_cat:
                Intent i = new Intent(this, LionActivity.class );
                startActivity(i);
                soundPool.stop(loader);
                finish();

                break;
            default:
                break;
        }
    }
}
