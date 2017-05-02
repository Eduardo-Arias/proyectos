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

public class DogActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton ibtLion;
    private ImageButton ibtDog;
    private ImageButton ibtFrog;
    private ImageButton ibtUnknow;

    private SoundPool soundPool;
    private int loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);
        ibtUnknow = (ImageButton)findViewById(R.id.ibt_perro_dess);
        ibtLion = (ImageButton)findViewById(R.id.ibt_lion);
        ibtDog = (ImageButton)findViewById(R.id.ibt_dog);
        ibtFrog = (ImageButton)findViewById(R.id.ibt_frog);

        ibtUnknow.setOnClickListener(this);
        ibtFrog.setOnClickListener(this);
        ibtDog.setOnClickListener(this);
        ibtLion.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader = soundPool.load(this, R.raw.perro,1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibt_perro_dess:
                soundPool.play(loader, 1, 1,0,0,1);
                break;
            case R.id.ibt_lion:
                Toast.makeText(this, "Incorrecto" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.ibt_dog:
                Intent i = new Intent(this, DogCorrectActivity.class );
                startActivity(i);
                soundPool.stop(loader);
                finish();
                break;
            case R.id.ibt_frog:
                Toast.makeText(this, "Incorrecto" , Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
