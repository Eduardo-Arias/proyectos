package com.jjsoluciones.segundosprint.abc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.jjsoluciones.segundosprint.R;

/**
 * Created by danie on 17/03/2017.
 */

public class LetterH extends AppCompatActivity implements View.OnClickListener{

    private ImageButton ibtLetterH;
    private ImageView ibtInicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_h);
        ibtLetterH = (ImageButton) findViewById(R.id.ibt_letter_h);
        ibtInicio = (ImageView) findViewById(R.id.ibt_inicio);

        ibtLetterH.setOnClickListener(this);
        ibtInicio.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibt_inicio:
                Intent i = new Intent(this, MainAbecedario.class);
                startActivity(i);
                finish();
                break;
        }
    }
}