package com.example.ftc_freight_frenzy_scorer;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class MatchListAdapter extends ListAdapter<Match, MatchViewHolder> {

    public MatchListAdapter(@NonNull DiffUtil.ItemCallback<Match> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MatchViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(MatchViewHolder holder, int position) {
        Match current = getItem(position);
        holder.bind(current.teamName, current.createTime, current.id);
    }

    static class MatchDiff extends DiffUtil.ItemCallback<Match> {

        @Override
        public boolean areItemsTheSame(@NonNull Match oldItem, @NonNull Match newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Match oldItem, @NonNull Match newItem) {
            return oldItem.teamName.equals(newItem.teamName);
        }
    }
}
