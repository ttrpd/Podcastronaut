package com.example.podtastronaut;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PodcastSearchAdapter extends RecyclerView.Adapter<PodcastSearchAdapter.ViewHolder> {

    private Podcast[] podcasts;

    public static class ViewHolder extends RecyclerView.ViewHolder {
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //TODO: implement click listener
            podcastArtImageView = itemView.findViewById(R.id.podcastSearchArtImageView);
            podcastTitleTextView = itemView.findViewById(R.id.podcastSearchTitleTextView);
        }
    }

    public PodcastSearchAdapter(Podcast[] pods) {
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
        holder.podcastTitleTextView.setText(podcasts[position].getTitle());
        //TODO: set ImageView image from podcast art link
    }

    @Override
    public int getItemCount() {
        return podcasts.length;
    }

}
