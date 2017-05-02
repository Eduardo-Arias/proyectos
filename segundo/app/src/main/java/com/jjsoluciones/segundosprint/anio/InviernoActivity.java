package com.jjsoluciones.segundosprint.anio;

import android.content.ClipData;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jjsoluciones.segundosprint.R;

public class InviernoActivity extends AppCompatActivity{
    //Variables que se van a mover
    private ImageView ivEsquiar;
    private ImageView ivPatinar;
    private ImageView ivJugarNieve;
    private ImageView ivCometa;
    private ImageView ivAcampar;
    //Variables de contenedor
    private LinearLayout llEsquiar;
    private LinearLayout llPatinar;
    private LinearLayout llJugarNieve;
    //variables de ayuda
    private ImageView ivEsqui;
    private ImageView ivPatin;
    private ImageView ivMunieco;

    //Variables para el sonido
    private MediaPlayer mediaEsquiar;
    private MediaPlayer mediaPatinar;
    private MediaPlayer mediaJugarNieve;

    /**
     * En este metodo se inician los metodos a ejecutar en las variables, se castean las variable y
     * se le asigna el sonido a la variable mediaPlayer
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invierno);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //Se asigna a la variable su correspondiente de la vista
        ivEsquiar = (ImageView)findViewById(R.id.iv_esquiar);
        ivPatinar = (ImageView)findViewById(R.id.iv_patinar3);
        ivJugarNieve = (ImageView)findViewById(R.id.iv_jugar_nieve);
        ivCometa = (ImageView)findViewById(R.id.iv_cometa4);
        ivAcampar = (ImageView)findViewById(R.id.iv_acampar2);
        llEsquiar = (LinearLayout)findViewById(R.id.ll_esquiar);
        llPatinar = (LinearLayout)findViewById(R.id.ll_patinar);
        llJugarNieve = (LinearLayout)findViewById(R.id.ll_jugar_nieve);

        ivEsqui = (ImageView)findViewById(R.id.iv_esq);
        ivPatin = (ImageView)findViewById(R.id.iv_patin);
        ivMunieco = (ImageView)findViewById(R.id.iv_nieve);

        //Se asina el metodo de sombra de arrastre longClickListener
        ivEsquiar.setOnLongClickListener(longClickListener);
        ivPatinar.setOnLongClickListener(longClickListener);
        ivJugarNieve.setOnLongClickListener(longClickListener);
        ivCometa.setOnLongClickListener(longClickListener);
        ivAcampar.setOnLongClickListener(longClickListener);

        //Se le asigna el metodo de arrastrar y soltar dragListener
        llEsquiar.setOnDragListener(dragListener);
        llPatinar.setOnDragListener(dragListener);
        llJugarNieve.setOnDragListener(dragListener);

        //Se estrae el audio y se prepara para su reproduccion
        mediaEsquiar = MediaPlayer.create(this,R.raw.esquiar);
        mediaPatinar = MediaPlayer.create(this,R.raw.patinar_hielo);
        mediaJugarNieve = MediaPlayer.create(this, R.raw.jugar_nieve);

    }
    /**
     * se crea una sombra del objeto que se decea mover
     * @param v
     */
    View.OnLongClickListener longClickListener = new View.OnLongClickListener(){
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data,shadowBuilder,v,0);
            return true;
        }
    };
    /**
     * se captura el momento que el ususario deja precionado la tecla por un tiempo
     * y cuando arrastra el objeto hasta el momento en que lo suelta
     * @param v,event
     */

    View.OnDragListener dragListener = new View.OnDragListener(){
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view =(View)event.getLocalState();
            switch (dragEvent){
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.iv_esquiar && v.getId()==R.id.ll_esquiar){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivEsqui.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaEsquiar.start();

                    }else if (view.getId() == R.id.iv_jugar_nieve && v.getId()==R.id.ll_jugar_nieve){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivMunieco.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaJugarNieve.start();

                    }else if (view.getId() == R.id.iv_patinar3 &&  v.getId()==R.id.ll_patinar){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivPatin.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaPatinar.start();
                    }
                    break;
            }
            return true;
        }
    };
}
