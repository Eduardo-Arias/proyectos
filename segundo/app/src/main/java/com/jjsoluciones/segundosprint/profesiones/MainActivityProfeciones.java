package com.jjsoluciones.segundosprint.profesiones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jjsoluciones.segundosprint.R;


public class MainActivityProfeciones extends AppCompatActivity implements View.OnClickListener{
    private Button btIniciar;
    private ImageView ivProfesiones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profesiones);

        btIniciar = (Button)findViewById(R.id.bt_profesiones);
        ivProfesiones = (ImageView)findViewById(R.id.iv_profesiones);

        btIniciar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, AbogadoActivity.class );
        startActivity(i);

    }
}
