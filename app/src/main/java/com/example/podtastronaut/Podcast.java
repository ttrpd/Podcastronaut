package com.example.podtastronaut;

import java.util.ArrayList;
import java.util.Objects;

public class Podcast {

    private String title;
    private String artLink;
    private String thumbnailLink;
    private String feedLink;
    private String artistName;
    private String description;
    private ArrayList<Episode> episodes;

    public Podcast(String title, String artLink, String thumbnailLink, String feedLink, String artistName, String description) {
        this.title = title;
        this.artLink = artLink;
        this.thumbnailLink = thumbnailLink;
        this.feedLink = feedLink;
        this.artistName = artistName;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtLink() {
        return artLink;
    }

    public void setArtLink(String artLink) {
        this.artLink = artLink;
    }

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    public String getFeedLink() {
        return feedLink;
    }

    public void setFeedLink(String feedLink) {
        this.feedLink = feedLink;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Podcast)) return false;
        Podcast episode = (Podcast) o;
        return getTitle().equals(episode.getTitle()) && getArtistName().equals(episode.getArtistName()) && Objects.equals(getDescription(), episode.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getArtistName(), getDescription());
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<Episode> episodes) {
        this.episodes = episodes;
    }
}
