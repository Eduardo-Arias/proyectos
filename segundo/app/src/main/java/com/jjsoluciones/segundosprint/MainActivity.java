package com.jjsoluciones.segundosprint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.jjsoluciones.segundosprint.abc.MainAbecedario;
import com.jjsoluciones.segundosprint.animales.MainAnimalsActivity;
import com.jjsoluciones.segundosprint.anio.MainEstaciones;
import com.jjsoluciones.segundosprint.colores.OrangeActivity;
import com.jjsoluciones.segundosprint.emociones.MainActivityEmociones;
import com.jjsoluciones.segundosprint.familia.MainFamila;
import com.jjsoluciones.segundosprint.figuras.MainActivityFiguras;
import com.jjsoluciones.segundosprint.fruits.Main;
import com.jjsoluciones.segundosprint.meses.ActivityMonths;
import com.jjsoluciones.segundosprint.moviles.MainNumerosMoviles;
import com.jjsoluciones.segundosprint.numeros.Numeros;
import com.jjsoluciones.segundosprint.objetos.Objeto;
import com.jjsoluciones.segundosprint.profesiones.MainActivityProfeciones;
import com.jjsoluciones.segundosprint.vowels.MainVocales;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

        private ImageButton ibtAbecedario;
        private ImageButton ibtAnimales;
        private ImageButton ibtColores;
        private ImageButton ibtEmociones;
        private ImageButton ibtFamilia;
        private ImageButton ibtFigura;
        private ImageButton ibtFrutas;
        private ImageButton ibtMeses;
        private ImageButton ibtNumMovi;
        private ImageButton ibtNumeros;
        private ImageButton ibtObjetos;
        private ImageButton ibtEstaciones;
        private ImageButton ibtProfeciones;
        private ImageButton ibtVocales;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.content_main);

            ibtAnimales = (ImageButton)findViewById(R.id.ibt_animales);
            ibtAbecedario = (ImageButton)findViewById(R.id.ibt_abecedario);
            ibtEstaciones = (ImageButton)findViewById(R.id.ibt_estaciones);
            ibtColores = (ImageButton)findViewById(R.id.ibt_colores);
            ibtEmociones = (ImageButton)findViewById(R.id.ibt_emociones);
            ibtFamilia = (ImageButton)findViewById(R.id.ibt_familia);
            ibtFigura = (ImageButton)findViewById(R.id.ibt_figuras);
            ibtFrutas = (ImageButton)findViewById(R.id.ibt_fruta);
            ibtMeses = (ImageButton)findViewById(R.id.ibt_meses);
            ibtNumMovi = (ImageButton)findViewById(R.id.ibt_num_mov);
            ibtNumeros = (ImageButton)findViewById(R.id.ibt_numeros);
            ibtObjetos = (ImageButton)findViewById(R.id.ibt_objetos);
            ibtProfeciones = (ImageButton)findViewById(R.id.ibt_profesiones);
            ibtVocales = (ImageButton)findViewById(R.id.ibt_vocales);

            ibtAnimales.setOnClickListener(this);
            ibtAbecedario.setOnClickListener(this);
            ibtEstaciones.setOnClickListener(this);
            ibtColores.setOnClickListener(this);
            ibtEmociones.setOnClickListener(this);
            ibtFamilia.setOnClickListener(this);
            ibtFigura.setOnClickListener(this);
            ibtFrutas.setOnClickListener(this);
            ibtMeses.setOnClickListener(this);
            ibtNumMovi.setOnClickListener(this);
            ibtNumeros.setOnClickListener(this);
            ibtObjetos.setOnClickListener(this);
            ibtProfeciones.setOnClickListener(this);
            ibtVocales.setOnClickListener(this);

        }

    @Override
    public void onClick(View view) {
        Intent inte;
        switch (view.getId()){
            case R.id.ibt_animales:
                inte = new Intent(this, MainAnimalsActivity.class);
                startActivity(inte);
                break;
            case R.id.ibt_estaciones:
                inte = new Intent(this, MainEstaciones.class);
                startActivity(inte);
                break;
            case R.id.ibt_colores:
                inte = new Intent(this, OrangeActivity.class);
                startActivity(inte);
                break;
            case R.id.ibt_emociones:
                inte = new Intent(this, MainActivityEmociones.class);
                startActivity(inte);
                break;
            case R.id.ibt_familia:
                inte = new Intent(this, MainFamila.class);
                startActivity(inte);
                break;
            case R.id.ibt_figuras:
                inte = new Intent(this, MainActivityFiguras.class);
                startActivity(inte);
                break;
            case R.id.ibt_fruta:
                inte = new Intent(this, Main.class);
                startActivity(inte);
                break;
            case R.id.ibt_meses:
                inte = new Intent(this, ActivityMonths.class);
                startActivity(inte);
                break;
            case R.id.ibt_num_mov:
                inte = new Intent(this, MainNumerosMoviles.class);
                startActivity(inte);
                break;
            case R.id.ibt_numeros:
                inte = new Intent(this, Numeros.class);
                startActivity(inte);
                break;
            case R.id.ibt_objetos:
                inte = new Intent(this, Objeto.class);
                startActivity(inte);
                break;
            case R.id.ibt_profesiones:
                inte = new Intent(this, MainActivityProfeciones.class);
                startActivity(inte);
                break;
            case R.id.ibt_vocales:
                inte = new Intent(this, MainVocales.class);
                startActivity(inte);
                break;
            case R.id.ibt_abecedario:
                inte = new Intent(this, MainAbecedario.class);
                startActivity(inte);
                break;
        }

    }
}
