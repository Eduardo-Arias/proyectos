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

public class OtonioActivity extends AppCompatActivity{
    //Variables que se van a mover
    private ImageView ivPapalote;
    private ImageView ivColumpio;
    private ImageView ivPatin;
    private ImageView ivNadar;
    private ImageView ivPatinarNieve;
    //Variables de contenedor
    private LinearLayout llPapalote;
    private LinearLayout llPatinar;
    private LinearLayout llColumpio;
    //variables de ayuda
    private ImageView ivPatineta;
    private ImageView ivViento;
    private ImageView ivArbol;

    //Variables para el sonido
    private MediaPlayer mediaPapalote;
    private MediaPlayer mediaPatinar;
    private MediaPlayer mediaColumpio;

    /**
     * En este metodo se inician los metodos a ejecutar en las variables, se castean las variable y
     * se le asigna el sonido a la variable mediaPlayer
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otonio);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //Se asigna a la variable su correspondiente de la vista
        ivPapalote = (ImageView)findViewById(R.id.iv_cometa);
        ivColumpio = (ImageView)findViewById(R.id.iv_columpio);
        ivPatin = (ImageView)findViewById(R.id.iv_patinar);
        ivNadar = (ImageView)findViewById(R.id.iv_nadar3);
        ivPatinarNieve = (ImageView)findViewById(R.id.iv_patinar1);

        llPapalote = (LinearLayout)findViewById(R.id.ll_papalote);
        llPatinar = (LinearLayout)findViewById(R.id.ll_patinar_otonio);
        llColumpio = (LinearLayout)findViewById(R.id.ll_columpio);

        ivViento = (ImageView)findViewById(R.id.iv_viento);
        ivArbol = (ImageView)findViewById(R.id.iv_arbol);
        ivPatineta =(ImageView)findViewById(R.id.iv_patineta);


        //Se asina el metodo de sombra de arrastre longClickListener
        ivPapalote.setOnLongClickListener(longClickListener);
        ivColumpio.setOnLongClickListener(longClickListener);
        ivColumpio.setOnLongClickListener(longClickListener);
        ivPatin.setOnLongClickListener(longClickListener);
        ivNadar.setOnLongClickListener(longClickListener);
        ivPatinarNieve.setOnLongClickListener(longClickListener);

        //Se le asigna el metodo de arrastrar y soltar dragListener
        llPapalote.setOnDragListener(dragListener);
        llColumpio.setOnDragListener(dragListener);
        llPatinar.setOnDragListener(dragListener);

        //Se estrae el audio y se prepara para su reproduccion
        mediaColumpio = MediaPlayer.create(this,R.raw.columpiarse);
        mediaPapalote = MediaPlayer.create(this,R.raw.cometa);
        mediaPatinar = MediaPlayer.create(this, R.raw.patinar);

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
                    if (view.getId()== R.id.iv_columpio && v.getId()==R.id.ll_columpio){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivArbol.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaColumpio.start();

                    }else if (view.getId()== R.id.iv_cometa && v.getId()==R.id.ll_papalote){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivViento.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaPapalote.start();

                    }else if (view.getId() == R.id.iv_patinar && v.getId()==R.id.ll_patinar_otonio){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivPatineta.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaPatinar.start();

                    }
                    break;
            }
            return true;
        }
    };
}
