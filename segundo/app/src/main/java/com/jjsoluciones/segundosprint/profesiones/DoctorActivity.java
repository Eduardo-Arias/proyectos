package com.jjsoluciones.segundosprint.profesiones;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.jjsoluciones.segundosprint.R;


/**
 * Created by Yanet Mora on 16/02/2017.
 */

public class DoctorActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton ibtDoctor;
    private Button btConDoctor;
    private  Button btRegresar;
    private MediaPlayer mediaPlayer;
    private SoundPool soundPool;
    private int loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_layout);
        ibtDoctor = (ImageButton)findViewById(R.id.ibt_doctor);
        btConDoctor = (Button)findViewById(R.id.bt_continuar_doctor);
        btRegresar = (Button) findViewById(R.id.bt_regresar);

        ibtDoctor.setOnClickListener(this);
        btConDoctor.setOnClickListener(this);
        btRegresar.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader = soundPool.load(this, R.raw.d,1);
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibt_doctor:
                soundPool.play(loader, 1, 1,0,0,1);
                break;
            case R.id.bt_continuar_doctor:
                Intent i = new Intent(this, EnfermeraActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.bt_regresar:
                Intent in = new Intent(this, DentistaActivity.class);
                startActivity(in);
                finish();
                break;
            default:
                break;
        }
    }
}
