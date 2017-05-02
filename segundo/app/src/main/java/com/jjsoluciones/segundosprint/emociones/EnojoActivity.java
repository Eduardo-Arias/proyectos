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


public class EnojoActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btEnojo;
    private  Button btRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enojo_layout);
        btEnojo = (Button)findViewById(R.id.bt_continuar_enojo);
        btRegresar = (Button) findViewById(R.id.bt_regresar);

        btEnojo.setOnClickListener(this);
        btRegresar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_continuar_enojo:
                Intent i = new Intent(this, MiedoActivity.class);
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

