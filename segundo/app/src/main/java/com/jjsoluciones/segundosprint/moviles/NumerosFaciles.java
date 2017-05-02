package com.jjsoluciones.segundosprint.moviles;

import android.content.ClipData;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jjsoluciones.segundosprint.R;

public class NumerosFaciles extends AppCompatActivity {
    //imagenes a mover
    private ImageView ivDos;
    private ImageView ivTres;
    private ImageView ivSeis;
    private ImageView ivOcho;
    //imagenes a mover incorrectas
    private ImageView ivSiete;
    private ImageView ivCuatro;
    //contenedores
    private LinearLayout llDos;
    private LinearLayout llTres;
    private LinearLayout llSeis;
    private LinearLayout llOcho;
    //imagenes a desaparecer
    private ImageView ivDosP;
    private ImageView ivTresP;
    private ImageView ivSeisP;
    private ImageView ivOchoP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros_faciles);
        //posicion de la pantalla en horizontal
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ivDos = (ImageView)findViewById(R.id.iv_dos_corr);
        ivTres = (ImageView)findViewById(R.id.iv_tres_corr);
        ivSeis = (ImageView)findViewById(R.id.iv_seis_corr);
        ivOcho = (ImageView)findViewById(R.id.iv_ocho_corr);

        ivSiete = (ImageView)findViewById(R.id.iv_siete_corr);
        ivCuatro = (ImageView)findViewById(R.id.iv_cuatro_corr);

        llDos = (LinearLayout)findViewById(R.id.ll_dos);
        llTres = (LinearLayout)findViewById(R.id.ll_tres);
        llSeis = (LinearLayout)findViewById(R.id.ll_seis);
        llOcho = (LinearLayout)findViewById(R.id.ll_ocho);

        ivDosP = (ImageView)findViewById(R.id.iv_dos);
        ivTresP = (ImageView)findViewById(R.id.iv_tres);
        ivSeisP = (ImageView)findViewById(R.id.iv_seis);
        ivOchoP = (ImageView)findViewById(R.id.iv_ocho);



        //crear sombra del objeto a mover
        ivDos.setOnLongClickListener(longClickListener);
        ivTres.setOnLongClickListener(longClickListener);
        ivSeis.setOnLongClickListener(longClickListener);
        ivOcho.setOnLongClickListener(longClickListener);

        ivSiete.setOnLongClickListener(longClickListener);
        ivCuatro.setOnLongClickListener(longClickListener);

        //se signa el evento arrastrar y soltar al contenedor
        llDos.setOnDragListener(dragListener);
        llTres.setOnDragListener(dragListener);
        llSeis.setOnDragListener(dragListener);
        llOcho.setOnDragListener(dragListener);
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
                    if (view.getId() == R.id.iv_dos_corr && v.getId() == R.id.ll_dos) {
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivDosP.setVisibility(View.GONE);
                        newParent.addView(view);


                    } else if (view.getId() == R.id.iv_tres_corr && v.getId() == R.id.ll_tres) {
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivTresP.setVisibility(View.GONE);
                        newParent.addView(view);


                    } else if (view.getId() == R.id.iv_seis_corr && v.getId() == R.id.ll_seis) {
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivSeisP.setVisibility(View.GONE);
                        newParent.addView(view);

                    }else if (view.getId() == R.id.iv_ocho_corr && v.getId() == R.id.ll_ocho) {
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivOchoP.setVisibility(View.GONE);
                        newParent.addView(view);
                    }
                    break;
            }
            return true;
        }
    };
}
