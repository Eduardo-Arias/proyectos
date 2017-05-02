package com.jjsoluciones.segundosprint.figuras;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.jjsoluciones.segundosprint.R;

public class MainActivityFiguras extends AppCompatActivity {

    private ImageButton ibtFiguras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_figuras);
        ibtFiguras = (ImageButton)findViewById(R.id.ibt_figura);

        ibtFiguras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivityFiguras.this,Circle.class);
                startActivity(i);
            }
        });
    }
}
