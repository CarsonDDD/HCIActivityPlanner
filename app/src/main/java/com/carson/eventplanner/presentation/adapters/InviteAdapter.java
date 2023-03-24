package com.carson.eventplanner.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carson.eventplanner.R;
import com.carson.eventplanner.objects.Event;
import com.carson.eventplanner.objects.Invite;

import java.util.List;

public class InviteAdapter extends RecyclerView.Adapter<InviteAdapter.InviteViewHolder> {

    private final List<Invite> inviteList;
    private final OnEventClickListener listener;

    public List<Invite> getEvents() {
        return inviteList;
    }

    public interface OnEventClickListener {
        void onItemClick(Invite event);
    }

    public InviteAdapter(List<Invite> eventList, OnEventClickListener listener) {
        this.inviteList = eventList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public InviteAdapter.InviteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_invite, parent, false);
        return new InviteAdapter.InviteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InviteAdapter.InviteViewHolder holder, int position) {
        holder.bind(inviteList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return inviteList.size();
    }

    public static class InviteViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;

        //private final ImageView image;

        public InviteViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            //image = itemView.findViewById(R.id.iv_event);
        }

        public void bind(Invite invite, OnEventClickListener listener){

            name.setText(invite.getSender().getUserName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(invite);
                }
            });
        }
    }
}
