package com.jjsoluciones.segundosprint.objetos;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jjsoluciones.segundosprint.R;

import java.util.ArrayList;
import java.util.List;

public class Objeto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objeto);
        RecyclerView rvList =(RecyclerView)findViewById(R.id.rv_list);
        rvList.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvList.setLayoutManager(manager);
        List<Person> people=new ArrayList<Person>();
        people.add(new Person("Armchair","sillon",R.drawable.sillon,R.color.color6));
        people.add(new Person("CUP","taza",R.drawable.taza,R.color.color2));
        people.add(new Person("BOOK","\n" + "libro",R.drawable.libro,R.color.colorAccent));
        people.add(new Person("Pencil","lapiz",R.drawable.lapiz,R.color.color3));
        people.add(new Person("Lantern","linterna",R.drawable.linterna,R.color.color8));
        people.add(new Person("TV","television",R.drawable.tele,R.color.color4));
        people.add(new Person("DICE","dado",R.drawable.dado,R.color.color5));
        people.add(new Person("BUCKET","cubeta",R.drawable.cubeta,R.color.col));
        people.add(new Person("CHAIR","silla",R.drawable.silla,R.color.color7));
        people.add(new Person("FOCUS","foco",R.drawable.foco,R.color.color12));
        people.add(new Person("TABLE","mesa",R.drawable.mesa,R.color.c));
        people.add(new Person("LAMP","lampara",R.drawable.lam,R.color.cn));
        people.add(new Person("CELL PHONE","celular",R.drawable.celular,R.color.cn6));
        people.add(new Person("BED","cama",R.drawable.camaa,R.color.cn7));







        RecyclerView.Adapter adapter = new RVAdapter(people);
        rvList.setAdapter(adapter);
    }
}
