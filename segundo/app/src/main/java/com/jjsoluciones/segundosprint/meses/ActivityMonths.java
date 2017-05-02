package com.jjsoluciones.segundosprint.meses;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.jjsoluciones.segundosprint.R;

public class ActivityMonths extends AppCompatActivity implements View.OnClickListener{

    private ImageButton ibtJanuary;
    private ImageButton ibtFebruary;
    private ImageButton ibtMarch;
    private ImageButton ibtApril;
    private ImageButton ibtMay;
    private ImageButton ibtJune;
    private ImageButton ibtJuly;
    private ImageButton ibtAugust;
    private ImageButton ibtSeptember;
    private ImageButton ibtOctober;
    private ImageButton ibtNovember;
    private ImageButton ibtDecember;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);

        ibtJanuary = (ImageButton) findViewById(R.id.ibt_january);
        ibtFebruary = (ImageButton) findViewById(R.id.ibt_february);
        ibtMarch = (ImageButton) findViewById(R.id.ibt_march);
        ibtApril = (ImageButton) findViewById(R.id.ibt_april);
        ibtMay = (ImageButton) findViewById(R.id.ibt_may);
        ibtJune = (ImageButton) findViewById(R.id.ibt_june);
        ibtJuly = (ImageButton) findViewById(R.id.ibt_july);
        ibtAugust = (ImageButton) findViewById(R.id.ibt_august);
        ibtSeptember = (ImageButton) findViewById(R.id.ibt_september);
        ibtOctober = (ImageButton) findViewById(R.id.ibt_october);
        ibtNovember = (ImageButton) findViewById(R.id.ibt_november);
        ibtDecember = (ImageButton) findViewById(R.id.ibt_december);


        ibtJanuary.setOnClickListener(this);
        ibtFebruary.setOnClickListener(this);
        ibtMarch.setOnClickListener(this);
        ibtApril.setOnClickListener(this);
        ibtMay.setOnClickListener(this);
        ibtJune.setOnClickListener(this);
        ibtJuly.setOnClickListener(this);
        ibtAugust.setOnClickListener(this);
        ibtSeptember.setOnClickListener(this);
        ibtOctober.setOnClickListener(this);
        ibtNovember.setOnClickListener(this);
        ibtDecember.setOnClickListener(this);

        mediaPlayer = new MediaPlayer();

    }

    public void juanuary (){
        mediaPlayer=MediaPlayer.create(this, R.raw.january);
        mediaPlayer.start();
    }

    public void february (){
        mediaPlayer=MediaPlayer.create(this, R.raw.february);
        mediaPlayer.start();
    }

    public void march (){
        mediaPlayer=MediaPlayer.create(this, R.raw.march);
        mediaPlayer.start();
    }

    public void april (){
        mediaPlayer=MediaPlayer.create(this, R.raw.april);
        mediaPlayer.start();
    }

    public void may (){
        mediaPlayer=MediaPlayer.create(this, R.raw.may);
        mediaPlayer.start();
    }

    public void june (){
        mediaPlayer=MediaPlayer.create(this, R.raw.june);
        mediaPlayer.start();
    }

    public void july (){
        mediaPlayer=MediaPlayer.create(this, R.raw.july);
        mediaPlayer.start();
    }

    public void august (){
        mediaPlayer=MediaPlayer.create(this, R.raw.august);
        mediaPlayer.start();
    }

    public void september (){
        mediaPlayer=MediaPlayer.create(this, R.raw.september);
        mediaPlayer.start();
    }

    public void october (){
        mediaPlayer=MediaPlayer.create(this, R.raw.october);
        mediaPlayer.start();
    }

    public void november (){
        mediaPlayer=MediaPlayer.create(this, R.raw.november);
        mediaPlayer.start();
    }

    public void december (){
        mediaPlayer=MediaPlayer.create(this, R.raw.december);
        mediaPlayer.start();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibt_january:
                juanuary();
                break;
            case R.id.ibt_february:
                february();
                break;
            case R.id.ibt_march:
                march();
                break;
            case R.id.ibt_april:
                april();
                break;
            case R.id.ibt_may:
                may();
                break;
            case R.id.ibt_june:
                june();
                break;
            case R.id.ibt_july:
                july();
                break;
            case R.id.ibt_august:
                august();
                break;
            case R.id.ibt_september:
                september();
                break;
            case R.id.ibt_october:
                october();
                break;
            case R.id.ibt_november:
                november();
                break;
            case R.id.ibt_december:
                december();
                break;
            default:
                break;
        }
    }
}

