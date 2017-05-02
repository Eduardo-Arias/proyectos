package com.jjsoluciones.segundosprint.fruits;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.jjsoluciones.segundosprint.R;

import java.util.Arrays;
import java.util.Collections;

public class Verduras extends AppCompatActivity {

    private static final int[] CARTA_VERDURAS = new int[]{
            R.drawable.aguacate,
            R.drawable.brocoli,
            R.drawable.cebolla,
            R.drawable.lechuga,
            R.drawable.papa1,
            R.drawable.pepino,
            R.drawable.zanahoria,
            R.drawable.jitomate,

    };
    private final Handler handler = new Handler();
    private Carta[] cartas;
    private boolean touchActivo= true;
    private Carta visible = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final TableLayout tabla = new TableLayout(this);
        final int tam = 4;
        cartas = crearCeldas(tam * tam);
        Collections.shuffle(Arrays.asList(cartas));
        for (int y = 0; y <tam; y++){
            final TableRow fila = new TableRow(this);
            for (int x = 0; x <tam; x++){
                fila.addView(cartas[(y*tam)+x].button);
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
        private final ImageButton button;
        private final int imagen;
        //estado por defecto del objeto
        private boolean caraVisible = false;
        //se definen los parametros del objeto que se va a mandar a la vista
        Carta(final int imagen) {
            this.imagen = imagen;
            this.button = new ImageButton(Verduras.this);
            this.button.setLayoutParams(new TableRow.LayoutParams(ancho*1/4,alto*1/5));//se ajusta la tabla al tamaño de la pantalla
            this.button.setPadding(10, 20, 10, 30);
            this.button.setScaleType(ImageView.ScaleType.FIT_XY);
            this.button.setImageResource(R.drawable.linea);
            this.button.setBackgroundColor(R.color.aqua);
            this.button.setOnClickListener(this);

        }
        //cambia la cara de la carta a desconocida si es falsa
        void setCaraVisible(final boolean caraVisible){
           this.caraVisible = caraVisible;
            button.setImageResource(caraVisible? imagen: R.drawable.linea);
        }

        //inicia al pulsar la carta
        @Override
        public void onClick(View view) {
            if (!caraVisible&&touchActivo){
                onCartaDescubierta(this);

            }

        }
    }
    //barajear las imagenes
    private Carta[]crearCeldas(final int cont){
        final Carta[]array = new Carta[cont];
        for (int i = 0; i <array.length; i++){
            array[i]= new Carta(CARTA_VERDURAS[i/2]);


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
             celda.button.setEnabled(false);
             visible.button.setEnabled(false);
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
