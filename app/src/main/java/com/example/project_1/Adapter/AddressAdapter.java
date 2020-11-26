package com.example.project_1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_1.AddressItem;
import com.example.project_1.R;

import java.util.ArrayList;

import model.addressSearch.Document;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {
    Context context;
    ArrayList<Document> items;
    EditText editText;
    RecyclerView recyclerView;

    public AddressAdapter(Context context, ArrayList<Document> items, EditText editText, RecyclerView recyclerView) {
        this.context = context;
        this.items = items;
        this.editText = editText;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddressAdapter.ViewHolder holder, int position) {
        final Document model = items.get(position);
        holder.address.setText(model.getAddressName());
    }

    public void claer(){
        items.clear();
    }

    public void addItem(Document item) {
        items.add(item);
    }

    @Override
    public int getItemCount() {
        return (null != items ? items.size() : 0);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.address = (TextView) itemView.findViewById(R.id.address);
        }
    }
}
