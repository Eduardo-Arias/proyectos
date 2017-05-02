package com.jjsoluciones.segundosprint.objetos;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jjsoluciones.segundosprint.R;

public class Entrada extends AppCompatActivity implements View.OnClickListener {
 private Button btnIniciar;
    private ImageView ivobj;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);

        btnIniciar = (Button)findViewById(R.id.bt_obs);
        ivobj = (ImageView)findViewById(R.id.iv_objetos);

        btnIniciar.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this,  Objeto.class);
        startActivity(i);
    }
}
