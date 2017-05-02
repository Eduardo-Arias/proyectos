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


public class MiedoActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btMiedo;
    private  Button btRegresar;

    private int loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.miedo_layout);
        btMiedo = (Button)findViewById(R.id.bt_continuar_miedo);
        btRegresar = (Button) findViewById(R.id.bt_regresar);

        btMiedo.setOnClickListener(this);
        btRegresar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_continuar_miedo:
                Intent i = new Intent(this, TristezaActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.bt_regresar:
                Intent in = new Intent(this, MainActivityEmociones.class);
                startActivity(in);
                finish();
                break;
            default:
                break;


        }
    }
}

