package com.jjsoluciones.segundosprint.vowels;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.jjsoluciones.segundosprint.R;


public class MainVocales extends AppCompatActivity implements View.OnClickListener{


    private MediaPlayer mp;
    private SoundPool soundPool;
    private int loader;


    private ImageView iv_a;
    private ImageView iv_e;
    private ImageView iv_i;
    private ImageView iv_o;
    private ImageView iv_u;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vocales);


        iv_a = (ImageView) findViewById(R.id.iv_a);
        iv_e = (ImageView) findViewById(R.id.iv_e);
        iv_i = (ImageView) findViewById(R.id.iv_i);
        iv_o = (ImageView) findViewById(R.id.iv_o);
        iv_u = (ImageView) findViewById(R.id.iv_u);


        iv_a.setOnClickListener(this);
        iv_e.setOnClickListener(this);
        iv_i.setOnClickListener(this);
        iv_o.setOnClickListener(this);
        iv_u.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader = soundPool.load(this,R.raw.a,1);
        mp = new MediaPlayer();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_a:
                Intent i = new Intent(this, AActivity.class);
                startActivity(i);
                break;
            case R.id.iv_e:
                Intent in = new Intent(this,EActivity.class);
                startActivity(in);
                break;

            case R.id.iv_i:
                Intent inte = new Intent(this,IActivity.class);
                startActivity(inte);
                break;

            case R.id.iv_o:
                Intent intent = new Intent(this,OActivity.class);
                startActivity(intent);
                break;

            case R.id.iv_u:
               Intent inten = new Intent(this,UActivity.class);
                startActivity(inten);
                break;

            default:
                break;
        }
    }
}
