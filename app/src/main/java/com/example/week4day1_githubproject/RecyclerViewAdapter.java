package com.example.week4day1_githubproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.week4day1_githubproject.model.RepoResponse;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<RepoResponse> repoList;

    public RecyclerViewAdapter(List<RepoResponse> repos){
        this.repoList = repos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.repo_items, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final RepoResponse itemRepo = repoList.get(i);
        final String name = itemRepo.getName();
        final String created = "CREATED AT: " + itemRepo.getCreatedAt();
        final String updated = "UPDATED AT: " + itemRepo.getUpdatedAt();
        final String pushed = "PUSHED AT: " + itemRepo.getPushedAt();
        viewHolder.tvName.setText(name);
        viewHolder.tvCreation.setText(created);
        viewHolder.tvUpdated.setText(updated);
        viewHolder.tvPushed.setText(pushed);
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvCreation;
        TextView tvUpdated;
        TextView tvPushed;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvDisplayName);
            tvCreation = itemView.findViewById(R.id.tvDisplayCreation);
            tvUpdated = itemView.findViewById(R.id.tvDisplayUpdated);
            tvPushed = itemView.findViewById(R.id.tvDisplayPushed);
        }
    }
}
