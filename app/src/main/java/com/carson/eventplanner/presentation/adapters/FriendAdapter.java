package com.carson.eventplanner.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carson.eventplanner.R;
import com.carson.eventplanner.objects.User;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendViewHolder> {

    private final List<User> friendList;
    //private final OnItemClickListener listener;

    /*public interface OnItemClickListener {
        void onItemClick(Event eventCategory);
    }*/

    public FriendAdapter(List<User> friendList/*, OnItemClickListener listener*/) {
        this.friendList = friendList;
        //this.listener = listener;
    }


    @NonNull
    @Override
    public FriendAdapter.FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friends, parent, false);
        return new FriendAdapter.FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendAdapter.FriendViewHolder holder, int position) {
        holder.bind(friendList.get(position)/*, listener*/);
    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }

    public static class FriendViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        //private final ImageView image;

        public FriendViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            //image = itemView.findViewById(R.id.iv_event);
        }

        public void bind(User friend){
            name.setText(friend.getUserName());
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(eventCategory);
                }
            });*/
        }
    }
}

