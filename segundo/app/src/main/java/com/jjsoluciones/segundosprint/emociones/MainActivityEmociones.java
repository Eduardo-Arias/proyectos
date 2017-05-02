package com.jjsoluciones.segundosprint.emociones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jjsoluciones.segundosprint.R;


public class MainActivityEmociones extends AppCompatActivity implements View.OnClickListener{
    private Button btIniciar;
    private ImageView ivEmociones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_emociones);

        btIniciar = (Button)findViewById(R.id.bt_emociones);
        ivEmociones= (ImageView)findViewById(R.id.iv_emociones);

        btIniciar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, AlegriaActivity.class );
        startActivity(i);

    }
}
