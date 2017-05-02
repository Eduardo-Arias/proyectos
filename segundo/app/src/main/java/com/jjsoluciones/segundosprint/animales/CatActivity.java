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

public class CatActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton ibtCat;
    private ImageButton ibtDog;
    private ImageButton ibtFrog;
    private ImageButton ibtUnknow;
    private MediaPlayer mediaPlayer;
    private SoundPool soundPool;
    private int loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        ibtUnknow = (ImageButton)findViewById(R.id.ibt_cat_dess);
        ibtCat = (ImageButton)findViewById(R.id.ibt_cat);
        ibtDog = (ImageButton)findViewById(R.id.ibt_dog);
        ibtFrog = (ImageButton)findViewById(R.id.ibt_frog);

        ibtUnknow.setOnClickListener(this);
        ibtFrog.setOnClickListener(this);
        ibtDog.setOnClickListener(this);
        ibtCat.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader = soundPool.load(this, R.raw.gato,1);
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibt_cat_dess:
                soundPool.play(loader, 1, 1,0,0,1);
                break;
            case R.id.ibt_cat:
                Intent i = new Intent(this, CatCorrActivity.class );
                startActivity(i);
                finish();
                soundPool.stop(loader);
                break;
            case R.id.ibt_dog:
                Toast.makeText(this, "Incorrecto" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.ibt_frog:
                Toast.makeText(this, "Incorrecto" , Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
