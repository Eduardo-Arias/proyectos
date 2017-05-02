package com.jjsoluciones.segundosprint.familia;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.jjsoluciones.segundosprint.R;

public class MainFamila extends AppCompatActivity implements View.OnClickListener{
    private ImageButton ibtIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main_famila);
        ibtIniciar = (ImageButton)findViewById(R.id.ibt_iniciar);
        ibtIniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, FamiliaActivity.class);
        startActivity(i);
    }
}
