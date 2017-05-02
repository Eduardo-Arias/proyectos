package com.jjsoluciones.segundosprint.familia;

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

public class FamiliaActivity extends AppCompatActivity{

    //Variables que se van a mover
    private ImageView ivAbuelo;
    private ImageView ivAbuela;
    private ImageView ivPapa;
    private ImageView ivMama;
    private ImageView ivHijo;
    private ImageView ivHija;


    //Variables de ayuda
    private ImageView ivBaston;
    private ImageView ivTejer;
    private ImageView ivCorbata;
    private ImageView ivMandil;
    private ImageView ivPelota;
    private ImageView ivKiti;

    //Variables de contenedor
    private LinearLayout llAbuelo;
    private LinearLayout llAbuela;
    private LinearLayout llPapa;
    private LinearLayout llMama;
    private LinearLayout llHijo;
    private LinearLayout llHija;

    //Variables para el sonido
    private MediaPlayer mediaAbuelo;
    private MediaPlayer mediaAbuela;
    private MediaPlayer mediaPapa;
    private MediaPlayer mediaMama;
    private MediaPlayer mediaHijo;
    private MediaPlayer mediaHija;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familia);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //Se asigna a la variable su correspondiente de la vista
        ivAbuelo = (ImageView)findViewById(R.id.iv_abuelo);
        ivAbuela = (ImageView)findViewById(R.id.iv_abuela);
        ivPapa = (ImageView)findViewById(R.id.iv_papa);
        ivMama = (ImageView)findViewById(R.id.iv_mama);
        ivHijo = (ImageView)findViewById(R.id.iv_hijo);
        ivHija = (ImageView)findViewById(R.id.iv_hija);


        ivBaston = (ImageView)findViewById(R.id.iv_baston);
        ivTejer = (ImageView)findViewById(R.id.iv_tejer);
        ivCorbata = (ImageView)findViewById(R.id.iv_corbata);
        ivMandil = (ImageView)findViewById(R.id.iv_mandil);
        ivPelota = (ImageView)findViewById(R.id.iv_pelota_f);
        ivKiti = (ImageView)findViewById(R.id.iv_kiti);

        llAbuelo = (LinearLayout)findViewById(R.id.ll_abuelo);
        llAbuela = (LinearLayout)findViewById(R.id.ll_abuela);
        llPapa = (LinearLayout)findViewById(R.id.ll_papa);
        llMama = (LinearLayout)findViewById(R.id.ll_mama);
        llHijo = (LinearLayout)findViewById(R.id.ll_hijo);
        llHija = (LinearLayout)findViewById(R.id.ll_hija);

        //Se asina el metodo de sombra de arrastre longClickListener
        ivAbuela.setOnLongClickListener(longClickListener);
        ivAbuelo.setOnLongClickListener(longClickListener);
        ivPapa.setOnLongClickListener(longClickListener);
        ivMama.setOnLongClickListener(longClickListener);
        ivHijo.setOnLongClickListener(longClickListener);
        ivHija.setOnLongClickListener(longClickListener);
        //Se le asigna el metodo de arrastrar y soltar dragListener
        llAbuelo.setOnDragListener(dragListener);
        llAbuela.setOnDragListener(dragListener);
        llPapa.setOnDragListener(dragListener);
        llMama.setOnDragListener(dragListener);
        llHijo.setOnDragListener(dragListener);
        llHija.setOnDragListener(dragListener);

        //Se extrae el audio y se prepara para su reproduccion
        mediaAbuelo = MediaPlayer.create(this, R.raw.abuelo);
        mediaAbuela = MediaPlayer.create(this, R.raw.abuela);
        mediaPapa = MediaPlayer.create(this, R.raw.papa);
        mediaMama = MediaPlayer.create(this, R.raw.mama);
        mediaHijo = MediaPlayer.create(this, R.raw.hijo);
        mediaHija = MediaPlayer.create(this, R.raw.hija);
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
                    if (view.getId() == R.id.iv_abuelo && v.getId()==R.id.ll_abuelo){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivBaston.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaAbuelo.start();

                    }else if (view.getId() == R.id.iv_abuela && v.getId()==R.id.ll_abuela){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivTejer.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaAbuela.start();

                    }else if (view.getId()==R.id.iv_papa && v.getId()==R.id.ll_papa){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivCorbata.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaPapa.start();

                    }else if (view.getId()==R.id.iv_mama && v.getId()==R.id.ll_mama){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivMandil.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaMama.start();

                    }else if (view.getId()==R.id.iv_hijo && v.getId()==R.id.ll_hijo){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivPelota.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaHijo.start();

                    }else if (view.getId()==R.id.iv_hija && v.getId()==R.id.ll_hija){
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout)v;
                        ivKiti.setVisibility(View.GONE);
                        newParent.addView(view);

                        mediaHija.start();
                    }
                    break;
            }
            return true;
        }
    };
}
