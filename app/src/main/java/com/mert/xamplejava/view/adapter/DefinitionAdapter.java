package com.mert.xamplejava.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mert.xamplejava.databinding.RecyclerViewDefinitonsItemBinding;
import com.mert.xamplejava.model.data.response.DefinitionResponse;


import java.util.ArrayList;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionAdapter.DefinitionViewHolder> {

    private Context context;
    private ArrayList<DefinitionResponse> responses;

    public DefinitionAdapter(Context context, ArrayList<DefinitionResponse> responses) {
        this.context = context;
        this.responses = responses;
    }


    public void setResults(ArrayList<DefinitionResponse> results) {
        this.responses = results;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public DefinitionAdapter.DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionViewHolder(RecyclerViewDefinitonsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionAdapter.DefinitionViewHolder holder, int position) {
        DefinitionResponse response = responses.get(position);
        holder.binding.defId.setText(position);
        holder.binding.definition.setText((CharSequence) response.getMeanings()[position].getDefinitons()[position].getDefinition());
        holder.binding.defExample.setText( response.getMeanings()[position].getDefinitons()[position].getExample());
    }

    @Override
    public int getItemCount() {
        return responses.size();
    }


    public static class DefinitionViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerViewDefinitonsItemBinding binding;

        public DefinitionViewHolder(@NonNull RecyclerViewDefinitonsItemBinding b) {
            super(b.getRoot());
            this.binding = b;
            TextView id = binding.defId;
            TextView def = binding.definition;
            TextView def_ex = binding.defExample;
        }
    }
}
