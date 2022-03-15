package com.example.podtastronaut;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PodcastSearchAdapter extends RecyclerView.Adapter<PodcastSearchAdapter.ViewHolder>{

    private ArrayList<Podcast> podcasts;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public Podcast getPodcast() {
            return podcast;
        }

        public void setPodcast(Podcast podcast) {
            this.podcast = podcast;
        }

        public ImageView getPodcastArtImageView() {
            return podcastArtImageView;
        }

        public void setPodcastArtImageView(ImageView podcastArtImageView) {
            this.podcastArtImageView = podcastArtImageView;
        }

        public TextView getPodcastTitleTextView() {
            return podcastTitleTextView;
        }

        public void setPodcastTitleTextView(TextView podcastTitleTextView) {
            this.podcastTitleTextView = podcastTitleTextView;
        }

        private Podcast podcast;
        private ImageView podcastArtImageView;
        private TextView podcastTitleTextView;

        @Override
        public void onClick(View view) { }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            podcastArtImageView = itemView.findViewById(R.id.podcastSearchArtImageView);
            podcastTitleTextView = itemView.findViewById(R.id.podcastSearchTitleTextView);
            itemView.setOnClickListener(this);
        }

    }

    public PodcastSearchAdapter(ArrayList<Podcast> pods) {
        this.podcasts = pods;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.podcast_search_item, parent, false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.podcastTitleTextView.setText(podcasts.get(position).getTitle());
        //TODO: set ImageView image from podcast art link
    }

    @Override
    public int getItemCount() {
        return podcasts.size();
    }
}
