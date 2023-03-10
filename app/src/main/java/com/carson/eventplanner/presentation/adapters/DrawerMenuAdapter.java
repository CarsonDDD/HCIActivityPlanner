package com.carson.eventplanner.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carson.eventplanner.R;

import java.util.List;

// Used for the hamburger menu
public class DrawerMenuAdapter extends RecyclerView.Adapter<DrawerMenuAdapter.DrawerMenuViewHolder> {

    private final List<String> drawerMenuList;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public DrawerMenuAdapter(List<String> drawerMenuList, OnItemClickListener listener) {
        this.drawerMenuList = drawerMenuList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DrawerMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drawer_menu, parent, false);
        return new DrawerMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrawerMenuViewHolder holder, int position) {
        holder.bind(drawerMenuList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return drawerMenuList.size();
    }

    public static class DrawerMenuViewHolder extends RecyclerView.ViewHolder {

        private final TextView drawerMenuTextView;

        public DrawerMenuViewHolder(@NonNull View itemView) {
            super(itemView);
            drawerMenuTextView = itemView.findViewById(R.id.tv_title);
        }

        public void bind(final String drawerMenu, final OnItemClickListener listener) {
            drawerMenuTextView.setText(drawerMenu);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
