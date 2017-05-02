package com.jjsoluciones.segundosprint.emociones;

/**
 * Created by Yanet Mora on 16/04/2017.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jjsoluciones.segundosprint.R;



public class AlegriaActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btAlegria;
    private  Button btRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alegria_layout);
        btAlegria = (Button)findViewById(R.id.bt_continuar_alegria);
        btRegresar = (Button) findViewById(R.id.bt_regresar_alegria);

        btAlegria.setOnClickListener(this);
        btRegresar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_continuar_alegria:
                Intent i = new Intent(this, EnojoActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.bt_regresar_alegria:
                Intent in = new Intent(this, MainActivityEmociones.class);
                startActivity(in);
                finish();
                break;
            default:
                break;


        }
    }
}

