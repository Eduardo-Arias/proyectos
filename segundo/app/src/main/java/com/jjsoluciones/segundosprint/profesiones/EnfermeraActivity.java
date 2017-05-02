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

public class EnfermeraActivity extends AppCompatActivity implements View.OnClickListener  {

    private ImageButton ibtEnfermera;
    private Button btConEnfermera;
    private  Button btRegresar;
    private MediaPlayer mediaPlayer;
    private SoundPool soundPool;
    private int loader;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enfermera_layout);
        ibtEnfermera = (ImageButton)findViewById(R.id.ibt_enfermera);
        btConEnfermera = (Button)findViewById(R.id.bt_continuar_enfermera);
        btRegresar = (Button) findViewById(R.id.bt_regresar);


        ibtEnfermera.setOnClickListener(this);
        btConEnfermera.setOnClickListener(this);
        btRegresar.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader = soundPool.load(this, R.raw.n,1);
        mediaPlayer = new MediaPlayer();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibt_enfermera:
                soundPool.play(loader, 1, 1,0,0,1);
                break;
            case R.id.bt_continuar_enfermera:
                Intent i = new Intent(this, TaxistaActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.bt_regresar:
                Intent in = new Intent(this, DoctorActivity.class);
                startActivity(in);
                finish();
                break;
            default:
                break;
        }
    }
}