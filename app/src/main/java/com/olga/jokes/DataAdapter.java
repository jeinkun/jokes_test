package com.olga.jokes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

//    private LayoutInflater inflater;
    private ArrayList<String> jokes;

    DataAdapter( ArrayList<String> jokes) {
        this.jokes = jokes;
//        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewJoke.setText(jokes.get(position));
    }

    @Override
    public int getItemCount() {
        return jokes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewJoke;

        ViewHolder(View view){
            super(view);
            textViewJoke = view.findViewById(R.id.TextView_Joke);
        }
    }
}
