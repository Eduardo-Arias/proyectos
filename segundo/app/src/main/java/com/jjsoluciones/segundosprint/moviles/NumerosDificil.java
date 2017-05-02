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

public class NumerosDificil extends AppCompatActivity {
    //imagenes a mover
    private ImageView ivTres;
    private ImageView ivSiete;
    //imagenes a mover incorrectas
    private ImageView ivCuatro;
    private ImageView ivOcho;
    //contenedores
    private LinearLayout llTres;
    private LinearLayout llSiete;
    //imagenes a desaparecer
    private ImageView ivTresP;
    private ImageView ivSieteP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros_dificil);

        //posicion de la pantalla en horizontal
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ivTres = (ImageView)findViewById(R.id.iv_tres_prim_corr);
        ivSiete = (ImageView)findViewById(R.id.iv_siete_prim_corr);


        ivOcho = (ImageView)findViewById(R.id.iv_ocho_prim);
        ivCuatro = (ImageView)findViewById(R.id.iv_cuatro_prim);

        llTres = (LinearLayout)findViewById(R.id.ll_tres_primo);
        llSiete = (LinearLayout)findViewById(R.id.ll_siete_primo);

        ivTresP = (ImageView)findViewById(R.id.iv_tres_prim);
        ivSieteP = (ImageView)findViewById(R.id.iv_siete_prim);


        //crear sombra del objeto a mover
        ivTres.setOnLongClickListener(longClickListener);
        ivSiete.setOnLongClickListener(longClickListener);

        ivOcho.setOnLongClickListener(longClickListener);
        ivCuatro.setOnLongClickListener(longClickListener);

        //se signa el evento arrastrar y soltar al contenedor
        llTres.setOnDragListener(dragListener);
        llSiete.setOnDragListener(dragListener);
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
                    if (view.getId() == R.id.iv_tres_prim_corr && v.getId() == R.id.ll_tres_primo) {
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivTresP.setVisibility(View.GONE);
                        newParent.addView(view);


                    }else if (view.getId() == R.id.iv_siete_prim_corr && v.getId() == R.id.ll_siete_primo) {
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        ivSieteP.setVisibility(View.GONE);
                        newParent.addView(view);

                    }
                    break;
            }
            return true;
        }
    };
}
