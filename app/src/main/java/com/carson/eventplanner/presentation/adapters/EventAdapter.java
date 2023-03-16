package com.carson.eventplanner.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carson.eventplanner.R;
import com.carson.eventplanner.objects.Event;
import com.carson.eventplanner.objects.EventCategory;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private final List<Event> eventList;
    private final int layout;
    private final OnEventClickListener listener;

    public interface OnEventClickListener {
        void onItemClick(Event event);
    }

    public EventAdapter(List<Event> eventList, int layout, OnEventClickListener listener) {
        this.eventList = eventList;
        this.layout = layout;
        this.listener = listener;
    }


    @NonNull
    @Override
    public EventAdapter.EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new EventAdapter.EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.EventViewHolder holder, int position) {
        holder.bind(eventList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView date;
        private final TextView time;
        private final TextView org;
        //private final ImageView image;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_event_title);
            date = itemView.findViewById(R.id.tv_event_date);
            time = itemView.findViewById(R.id.tv_event_time);
            org = itemView.findViewById(R.id.tv_organizer);
            //image = itemView.findViewById(R.id.iv_event);
        }

        public void bind(Event event, OnEventClickListener listener){
            title.setText(event.getTitle());
            date.setText(event.getDate());
            time.setText(event.getTime());

            if(org != null && event.getOrganizers() != null){
                String sOrganizers = event.getOrganizers().get(0).getUserName();
                if(event.getOrganizers().size() > 1){
                    sOrganizers += " + " + event.getOrganizers().size() + " others";
                }
                org.setText(sOrganizers);

            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(event);
                }
            });
        }
    }
}
