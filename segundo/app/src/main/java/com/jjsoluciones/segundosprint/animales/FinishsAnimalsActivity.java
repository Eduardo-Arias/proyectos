package com.jjsoluciones.segundosprint.animales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.jjsoluciones.segundosprint.MainActivity;
import com.jjsoluciones.segundosprint.R;

public class FinishsAnimalsActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView ibtEndAnimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishs_animals);
        ibtEndAnimals = (ImageView) findViewById(R.id.ibt_animals);

        ibtEndAnimals.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MainAnimalsActivity.class);
        startActivity(i);
        finish();
    }
}
