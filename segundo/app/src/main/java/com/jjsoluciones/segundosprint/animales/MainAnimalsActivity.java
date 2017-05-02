package com.jjsoluciones.segundosprint.animales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.jjsoluciones.segundosprint.R;

public class MainAnimalsActivity extends AppCompatActivity{
    private ImageButton ibtAnimals;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_animals);

        ibtAnimals = (ImageButton)findViewById(R.id.ibt_start);

        ibtAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainAnimalsActivity.this, DogActivity.class );
                startActivity(i);

            }
        });
    }


}
