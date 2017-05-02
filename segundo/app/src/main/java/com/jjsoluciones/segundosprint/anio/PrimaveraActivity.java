package com.jjsoluciones.segundosprint.anio;

import android.content.ClipData;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jjsoluciones.segundosprint.R;

public class PrimaveraActivity extends AppCompatActivity{
    //Variables que se van a mover
    private ImageView ivCaminar;
    private ImageView ivCometa;
    private ImageView ivAcampar;
    private ImageView ivEsquiar;
    private ImageView ivNadar;

    //Variables de contenedor
    private LinearLayout llAcampar;
    private LinearLayout llCaminar;
    private LinearLayout llCometa;

    //Variables de ayuda
    private ImageView ivMochila;
    private ImageView ivViento;
    private ImageView ivSedero;
    //Variables para el sonido
    private MediaPlayer mediaAcapar;
    private MediaPlayer mediaCaminar;
    private MediaPlayer mediaCometa;

    /**
     * En este metodo se inician los metodos a ejecutar en las variables, se castean las variable y
     * se le asigna el sonido a la variable mediaPlayer
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primavera);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //Se asigna a la variable su correspondiente de la vista
        ivCaminar = (ImageView)findViewById(R.id.iv_caminata);
        ivCometa = (ImageView)findViewById(R.id.iv_cometa1);
        ivAcampar = (ImageView)findViewById(R.id.iv_acampar);
        ivEsquiar = (ImageView)findViewById(R.id.iv_esquiar2);
        ivNadar = (ImageView)findViewById(R.id.iv_nadar);

        llAcampar = (LinearLayout)findViewById(R.id.ll_acampar);
        llCaminar = (LinearLayout)findViewById(R.id.ll_caminar);
        llCometa = (LinearLayout)findViewById(R.id.ll_cometa);

        ivMochila = (ImageView)findViewById(R.id.iv_mochila);
        ivViento = (ImageView)findViewById(R.id.iv_viento_1);
        ivSedero = (ImageView)findViewById(R.id.iv_sendero);

        //Se asina el metodo de sombra de arrastre longClickListener
        ivCaminar.setOnLongClickListener(longClickListener);
        ivCometa.setOnLongClickListener(longClickListener);
        ivAcampar.setOnLongClickListener(longClickListener);
        ivEsquiar.setOnLongClickListener(longClickListener);
        ivNadar.setOnLongClickListener(longClickListener);

        //Se le asigna el metodo de arrastrar y soltar dragListener
        llCometa.setOnDragListener(dragListener);
        llCaminar.setOnDragListener(dragListener);
        llAcampar.setOnDragListener(dragListener);

        /*//Se le asigna el metodo para reproducir el audio OnClick
        txCometa.setOnClickListener(this);
        txCaminar.setOnClickListener(this);
        txAcampar.setOnClickListener(this);
        */
        //Se estrae el audio y se prepara para su reproduccion
        mediaAcapar = MediaPlayer.create(this,R.raw.acampar);
        mediaCometa = MediaPlayer.create(this,R.raw.cometa);
        mediaCaminar = MediaPlayer.create(this,R.raw.caminar);
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
            switch (dragEvent) {
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.iv_acampar && v.getId() == R.id.ll_acampar) {
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivMochila.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaAcapar.start();

                    } else if (view.getId() == R.id.iv_caminata && v.getId() == R.id.ll_caminar) {
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivSedero.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaCaminar.start();

                    } else if (view.getId() == R.id.iv_cometa1 && v.getId() == R.id.ll_cometa) {
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivViento.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaCometa.start();
                    }

                    break;
            }
            return true;
        }
    };
}
