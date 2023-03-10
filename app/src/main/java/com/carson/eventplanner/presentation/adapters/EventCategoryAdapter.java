package com.carson.eventplanner.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carson.eventplanner.R;
import com.carson.eventplanner.objects.EventCategory;

import java.util.List;

// Should only be used for the event categories (since a category is not an event)
// However, now its used for eveything including events (popular events, recommended events would use the same adapter)
public class EventCategoryAdapter extends RecyclerView.Adapter<EventCategoryAdapter.EventCategoryViewHolder> {

    private final List<EventCategory> eventCategoryList;
    //private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(EventCategory eventCategory);
    }

    public EventCategoryAdapter(List<EventCategory> eventCategoryList/*, OnItemClickListener listener*/) {
        this.eventCategoryList = eventCategoryList;
        //this.listener = listener;
    }

    @NonNull
    @Override
    public EventCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event_category, parent, false);
        return new EventCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventCategoryViewHolder holder, int position) {
        holder.bind(eventCategoryList.get(position)/*, listener*/);
    }

    @Override
    public int getItemCount() {
        return eventCategoryList.size();
    }

    public static class EventCategoryViewHolder extends RecyclerView.ViewHolder {

        private final TextView eventCategoryTitleTextView;
        private final TextView eventCategoryDescriptionTextView;
        //private final ImageView eventCategoryImageView;

        public EventCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            eventCategoryTitleTextView = itemView.findViewById(R.id.tv_event_category_title);
            eventCategoryDescriptionTextView = itemView.findViewById(R.id.tv_event_category_description);
            //eventCategoryImageView = itemView.findViewById(R.id.iv_event_category);
        }

        public void bind(EventCategory eventCategory/*, final OnItemClickListener listener*/) {
            /*eventCategoryTitleTextView.setText(eventCategory.getTitle());
            eventCategoryDescriptionTextView.setText(eventCategory.getDescription());
            eventCategoryImageView.setImageResource(eventCategory.getImageResource());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(eventCategory);
                }
            });*/

            eventCategoryTitleTextView.setText(eventCategory.getTitle());
            eventCategoryDescriptionTextView.setText(eventCategory.getDescription());
            //eventCategoryImageView.setImageResource(eventCategory.getImageResource());
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(eventCategory);
                }
            });*/
        }
    }
}
