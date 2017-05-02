package com.jjsoluciones.segundosprint.objetos;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjsoluciones.segundosprint.R;

import java.util.List;

/**
 * Created by yanet  Mora on 16/03/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    List<Person> people;


    public RVAdapter(List<Person> persons) {
        this.people=persons;

    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        PersonViewHolder holder = new PersonViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.tvPersonName.setText(people.get(position).getName());
        holder.tvPersonAge.setText(people.get(position).getAge());
        holder.ivPersonPhoto.setImageResource(people.get(position).getPothoId());
        holder.cvPersonL.setBackgroundResource(people.get(position).getCardColor());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder{
        CardView cvPersonL;
        TextView tvPersonName;
        ImageView ivPersonPhoto;
        TextView tvPersonAge;

        public PersonViewHolder(View v) {
            super(v);
            cvPersonL=(CardView)v.findViewById(R.id.cv_data);
            tvPersonName=(TextView) v.findViewById(R.id.tv_person_name);
            tvPersonAge=(TextView)v.findViewById(R.id.tv_person_age);
            ivPersonPhoto=(ImageView)v.findViewById(R.id.iv_person_photo);
        }
    }
}
