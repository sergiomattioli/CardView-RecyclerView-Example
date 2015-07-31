package com.astro.cardviewrecyclerview;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;


import java.util.List;

/**
 * Created by Sergio Mattioli on 30/07/2015.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PersonViewHolder> {

    private List<Database.Person> persons;
    MyClickListener mItemClickListener;


    public RecyclerViewAdapter(List<Database.Person> persons) {
        this.persons = persons;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder,final int position) {

        personViewHolder.name.setText(persons.get(position).getName());
        personViewHolder.age.setText(persons.get(position).getAge());
        personViewHolder.photo.setImageResource(persons.get(position).getPhotoId());
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.mItemClickListener = myClickListener;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        @Bind(R.id.person_name) TextView name;
        @Bind(R.id.person_age) TextView age;
        @Bind(R.id.person_photo) ImageView photo;

        public PersonViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(getAdapterPosition(),view);
            }
        }
    }


}
