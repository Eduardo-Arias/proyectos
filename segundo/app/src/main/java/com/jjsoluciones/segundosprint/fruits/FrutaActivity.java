package com.jjsoluciones.segundosprint.fruits;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.jjsoluciones.segundosprint.R;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Marili Arevalo on 16/04/2017.
 */

public class FrutaActivity extends AppCompatActivity {

    private static final int[] CARTA_RESOURCES = new int[]{
            R.drawable.uva,
            R.drawable.platano,
            R.drawable.naranja,
            R.drawable.fresa,
            R.drawable.limon,
            R.drawable.manzana,
            R.drawable.mango,
            R.drawable.cereza,
    };
    private final Handler handler = new Handler();
    private Carta[] cartas;
    private boolean touchActivo= true;
    private Carta visible = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //se crea el tablero
        final TableLayout tabla = new TableLayout(this);
        final int tam = 4;
        cartas = crearCeldas(tam * tam);
        Collections.shuffle(Arrays.asList(cartas));
        for (int y = 0; y <tam; y++){
            final TableRow fila = new TableRow(this);
            for (int x = 0; x <tam; x++){
                fila.addView(cartas[(y*tam)+x].button1);
            }
            tabla.addView(fila);

        }
        setContentView(tabla);

    }
    private class Carta implements View.OnClickListener{
        //se calcula el tamaño de la pantalla y se saca el ancho y el alto
        Display display = getWindowManager().getDefaultDisplay();
        int ancho = display.getWidth();
        int alto = display.getHeight();
        //objeto a enviar a la vista
        private final ImageButton button1;
        private final int imagen;
        //estado por defecto del objeto
        private boolean caraVisible = false;
        //se definen los parametros del objeto que se va a mandar a la vista
        Carta(final int imagen) {
            this.imagen = imagen;
            this.button1 = new ImageButton(FrutaActivity.this);
            this.button1.setLayoutParams(new TableRow.LayoutParams(ancho*1/4,alto*1/5));//se ajusta la pantalla
            this.button1.setPadding(10, 20, 10, 30);
            this.button1.setScaleType(ImageView.ScaleType.FIT_XY);
            this.button1.setImageResource(R.drawable.line);
            //this.button1.setBackgroundColor(R.color.colorPrimary);
            this.button1.setOnClickListener(this);

        }
        //cambia la cara de la carta a desconocida si es falsa
        void setCaraVisible(final boolean caraVisible){
            this.caraVisible = caraVisible;
            button1.setImageResource(caraVisible? imagen: R.drawable.line);
        }

        //inicia la pulzacion de la carta
        @Override
        public void onClick(View view) {
            if (!caraVisible&&touchActivo){
                onCartaDescubierta(this);

            }

        }
    }
    //varajer las imagenes
    private Carta[]crearCeldas(final int cont){
        final Carta[]array = new Carta[cont];
        for (int i = 0; i <array.length; i++){
            array[i]= new Carta(CARTA_RESOURCES[i/2]);


        }
        return array;
    }
    //compara las dos cartas descuviertas
    public void onCartaDescubierta(final Carta celda){
        if (visible ==null){
            visible = celda;
            visible.setCaraVisible(true);
        }else if (visible.imagen == celda.imagen){
            celda.setCaraVisible(true);
            celda.button1.setEnabled(false);
            visible.button1.setEnabled(false);
            visible = null;

        }else {
            celda.setCaraVisible(true);
            touchActivo = false;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    celda.setCaraVisible(false);
                    visible.setCaraVisible(false);
                    visible = null;
                    touchActivo = true;

                }
            },100);
        }

    }

}
