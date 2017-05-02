package com.jjsoluciones.segundosprint.emociones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jjsoluciones.segundosprint.R;

/**
 * Created by Yanet Mora on 16/04/2017.
 */

public class TristezaActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btTristeza;
    private  Button btRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tristeza_layout);
        btTristeza = (Button)findViewById(R.id.bt_continuar_triste);
        btRegresar = (Button) findViewById(R.id.bt_regresar);


        btTristeza.setOnClickListener(this);
        btRegresar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_continuar_triste:
                Intent i = new Intent(this, MainActivityEmociones.class);
                startActivity(i);
                finish();
                break;
            case R.id.bt_regresar:
                Intent in = new Intent(this, MiedoActivity.class);
                startActivity(in);
                finish();
                break;
            default:
                break;
        }
    }
}
