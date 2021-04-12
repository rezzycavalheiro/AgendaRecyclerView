package com.example.agendarecycler;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

public class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // quando cria o viewholder, o que ele deve fazer

        Context context = parent.getContext();
        // cria os componentes da lista
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(
                R.layout.recyclerview_item, parent, false
        );
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // atualiza o conteúdo pro usuáiro
        Log.v("ItemArrayAdapter", "onBindViewHolder " + position);
        UserInfo userinfo = DataModel.getInstance().userArray.get(position);
        holder.text_user_name.setText(userinfo.getName());
        holder.text_user_adress.setText(userinfo.getAddress());
        holder.text_user_phone.setText(userinfo.getPhone());
        holder.text_user_phonetype.setText(userinfo.getPhoneType());
    }

    @Override
    public int getItemCount() {
        return DataModel.getInstance().userArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_user_name;
        TextView text_user_adress;
        TextView text_user_phone;
        TextView text_user_phonetype;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_user_name = itemView.findViewById(R.id.text_user_name);
            text_user_adress = itemView.findViewById(R.id.text_user_adress);
            text_user_phone = itemView.findViewById(R.id.text_user_phone);
            text_user_phonetype = itemView.findViewById(R.id.text_user_phonetype);

        }
    }
}
