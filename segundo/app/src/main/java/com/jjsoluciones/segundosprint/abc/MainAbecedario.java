package com.jjsoluciones.segundosprint.abc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.jjsoluciones.segundosprint.R;

public class MainAbecedario extends AppCompatActivity implements View.OnClickListener {

    private ImageButton ibtA;
    private ImageButton ibtB;
    private ImageButton ibtC;
    private ImageButton ibtD;
    private ImageButton ibtE;
    private ImageButton ibtF;
    private ImageButton ibtG;
    private ImageButton ibtH;
    private ImageButton ibtI;
    private ImageButton ibtJ;
    private ImageButton ibtK;
    private ImageButton ibtL;
    private ImageButton ibtM;
    private ImageButton ibtN;
    private ImageButton ibtO;
    private ImageButton ibtP;
    private ImageButton ibtQ;
    private ImageButton ibtR;
    private ImageButton ibtS;
    private ImageButton ibtT;
    private ImageButton ibtU;
    private ImageButton ibtV;
    private ImageButton ibtW;
    private ImageButton ibtX;
    private ImageButton ibtY;
    private ImageButton ibtZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_abecedario);

        ibtA = (ImageButton)findViewById(R.id.ibt_a);
        ibtB = (ImageButton)findViewById(R.id.ibt_b);
        ibtC = (ImageButton)findViewById(R.id.ibt_c);
        ibtD = (ImageButton)findViewById(R.id.ibt_d);
        ibtE=  (ImageButton)findViewById(R.id.ibt_e);
        ibtF = (ImageButton)findViewById(R.id.ibt_f);
        ibtG = (ImageButton)findViewById(R.id.ibt_g);
        ibtH = (ImageButton)findViewById(R.id.ibt_h);
        ibtI = (ImageButton)findViewById(R.id.ibt_i);
        ibtJ = (ImageButton)findViewById(R.id.ibt_j);
        ibtK = (ImageButton)findViewById(R.id.ibt_k);
        ibtL = (ImageButton)findViewById(R.id.ibt_l);
        ibtM = (ImageButton)findViewById(R.id.ibt_m);
        ibtN = (ImageButton)findViewById(R.id.ibt_n);
        ibtO = (ImageButton)findViewById(R.id.ibt_o);
        ibtP = (ImageButton)findViewById(R.id.ibt_p);
        ibtQ = (ImageButton)findViewById(R.id.ibt_q);
        ibtR = (ImageButton)findViewById(R.id.ibt_r);
        ibtS = (ImageButton)findViewById(R.id.ibt_s);
        ibtT = (ImageButton)findViewById(R.id.ibt_t);
        ibtU = (ImageButton)findViewById(R.id.ibt_u);
        ibtV = (ImageButton)findViewById(R.id.ibt_v);
        ibtW = (ImageButton)findViewById(R.id.ibt_w);
        ibtX = (ImageButton)findViewById(R.id.ibt_x);
        ibtY = (ImageButton)findViewById(R.id.ibt_y);
        ibtZ = (ImageButton)findViewById(R.id.ibt_z);

        ibtA.setOnClickListener(this);
        ibtB.setOnClickListener(this);
        ibtC.setOnClickListener(this);
        ibtD.setOnClickListener(this);
        ibtE.setOnClickListener(this);
        ibtF.setOnClickListener(this);
        ibtG.setOnClickListener(this);
        ibtH.setOnClickListener(this);
        ibtI.setOnClickListener(this);
        ibtJ.setOnClickListener(this);
        ibtK.setOnClickListener(this);
        ibtL.setOnClickListener(this);
        ibtM.setOnClickListener(this);
        ibtN.setOnClickListener(this);
        ibtO.setOnClickListener(this);
        ibtP.setOnClickListener(this);
        ibtQ.setOnClickListener(this);
        ibtR.setOnClickListener(this);
        ibtS.setOnClickListener(this);
        ibtT.setOnClickListener(this);
        ibtU.setOnClickListener(this);
        ibtV.setOnClickListener(this);
        ibtW.setOnClickListener(this);
        ibtX.setOnClickListener(this);
        ibtY.setOnClickListener(this);
        ibtZ.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibt_a:
                Intent intent = new Intent(this, LetterA.class);
                startActivity(intent);
                finish();
                break;
            case R.id.ibt_b:
                Intent intent1 = new Intent(this, LetterB.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.ibt_c:
                Intent intent2 = new Intent(this, LetterC.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.ibt_d:
                Intent intent3 = new Intent(this, LetterD.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.ibt_e:
                Intent intent4 = new Intent(this, LetterE.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.ibt_f:
                Intent intent5 = new Intent(this, LetterF.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.ibt_g:
                Intent intent6 = new Intent(this, LetterG.class);
                startActivity(intent6);
                finish();
                break;
            case R.id.ibt_h:
                Intent intent7 = new Intent(this, LetterH.class);
                startActivity(intent7);
                finish();
                break;
            case R.id.ibt_i:
                Intent intent8 = new Intent(this, LetterI.class);
                startActivity(intent8);
                finish();
                break;
            case R.id.ibt_j:
                Intent intent9 = new Intent(this, LetterJ.class);
                startActivity(intent9);
                finish();
                break;
            case R.id.ibt_k:
                Intent intent10 = new Intent(this, LetterK.class);
                startActivity(intent10);
                finish();
                break;
            case R.id.ibt_l:
                Intent intent11 = new Intent(this, LetterL.class);
                startActivity(intent11);
                finish();
                break;
            case R.id.ibt_m:
                Intent intent12 = new Intent(this, LetterM.class);
                startActivity(intent12);
                finish();
                break;
            case R.id.ibt_n:
                Intent intent13 = new Intent(this, LetterN.class);
                startActivity(intent13);
                finish();
                break;
            case R.id.ibt_o:
                Intent intent14 = new Intent(this, LetterO.class);
                startActivity(intent14);
                finish();
                break;
            case R.id.ibt_p:
                Intent intent15 = new Intent(this, LetterP.class);
                startActivity(intent15);
                finish();
                break;
            case R.id.ibt_q:
                Intent intent16 = new Intent(this, LetterQ.class);
                startActivity(intent16);
                finish();
                break;
            case R.id.ibt_r:
                Intent intent17 = new Intent(this, LetterR.class);
                startActivity(intent17);
                finish();
                break;
            case R.id.ibt_s:
                Intent intent18 = new Intent(this, LetterS.class);
                startActivity(intent18);
                finish();
                break;
            case R.id.ibt_t:
                Intent intent19 = new Intent(this, LetterT.class);
                startActivity(intent19);
                finish();
                break;
            case R.id.ibt_u:
                Intent intent20 = new Intent(this, LetterU.class);
                startActivity(intent20);
                finish();
                break;
            case R.id.ibt_v:
                Intent intent21 = new Intent(this, LetterV.class);
                startActivity(intent21);
                finish();
                break;
            case R.id.ibt_w:
                Intent intent22 = new Intent(this, LetterW.class);
                startActivity(intent22);
                finish();
                break;
            case R.id.ibt_x:
                Intent intent23 = new Intent(this, LetterX.class);
                startActivity(intent23);
                finish();
                break;
            case R.id.ibt_y:
                Intent intent24 = new Intent(this, LetterY.class);
                startActivity(intent24);
                finish();
                break;
            case R.id.ibt_z:
                Intent intent25 = new Intent(this, LetterZ.class);
                startActivity(intent25);
                finish();
                break;
            default:
                break;

        }
    }





}
