package com.jjsoluciones.segundosprint.anio;

import android.content.ClipData;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jjsoluciones.segundosprint.R;

/**
 * Created by eduardoarias on 21/03/17.
 */

public class VeranoActivity extends AppCompatActivity {
//Variables que se van a mover
    private ImageView ivJuegaArena;
    private ImageView ivNadar;
    private ImageView ivBucear;
    private ImageView ivEsquiar;
    private ImageView ivAcampar;
//Variables de contenedor a donde llegan los objetos movibles
    private LinearLayout llJuegarArena;
    private LinearLayout llNadar;
    private LinearLayout llBucear;
//Variables del texto del los contenedores
    private ImageView ivPelota;
    private ImageView ivFlotis;
    private ImageView ivLentes;
//Variables para el sonido
    private MediaPlayer mediaJuegaArena;
    private MediaPlayer mediaNadar;
    private MediaPlayer mediaBucear;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verano);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //Se asigna a la variable su correspondiente de la vista
        ivJuegaArena = (ImageView)findViewById(R.id.iv_castillo);
        ivNadar = (ImageView)findViewById(R.id.iv_nado);
        ivBucear = (ImageView)findViewById(R.id.iv_bucear);
        ivEsquiar = (ImageView)findViewById(R.id.iv_esquiar1);
        ivAcampar = (ImageView)findViewById(R.id.iv_acampar1);

        llJuegarArena = (LinearLayout)findViewById(R.id.ll_castillo);
        llNadar= (LinearLayout)findViewById(R.id.ll_nadar);
        llBucear = (LinearLayout)findViewById(R.id.ll_bucear);

        ivPelota = (ImageView)findViewById(R.id.iv_pelota);
        ivFlotis = (ImageView)findViewById(R.id.iv_flotis);
        ivLentes = (ImageView)findViewById(R.id.iv_lentes);


        //Se asina el metodo de sombra de arrastre longClickListener
        ivNadar.setOnLongClickListener(longClickListener);
        ivJuegaArena.setOnLongClickListener(longClickListener);
        ivBucear.setOnLongClickListener(longClickListener);
        ivEsquiar.setOnLongClickListener(longClickListener);
        ivAcampar.setOnLongClickListener(longClickListener);

        //Se le asigna el metodo de arrastrar y soltar dragListener
        llJuegarArena.setOnDragListener(dragListener);
        llNadar.setOnDragListener(dragListener);
        llBucear.setOnDragListener(dragListener);

        //Se extrae el audio y se prepara para su reproduccion
        mediaBucear = MediaPlayer.create(this, R.raw.diving);
        mediaJuegaArena = MediaPlayer.create(this, R.raw.jugar_arena);
        mediaNadar = MediaPlayer.create(this, R.raw.nadar);

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
     * y cuando arrastra el objeto hasta el momento en que lo suelta, para depocitarlo en el contenedor
     * @param v,event
     */

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view =(View)event.getLocalState();
            switch (dragEvent){
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.iv_nado && v.getId()==R.id.ll_nadar){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivFlotis.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaNadar.start();
                     }else if (view.getId() == R.id.iv_castillo && v.getId()==R.id.ll_castillo){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivPelota.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaJuegaArena.start();
                     }else if (view.getId() == R.id.iv_bucear && v.getId()==R.id.ll_bucear){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivLentes.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaBucear.start();
                     }
                    break;
            }
            return true;
        }
    };
}