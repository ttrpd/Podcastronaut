package com.example.podtastronaut;

import java.util.Date;
import java.util.Objects;

public class Episode {
    private String link;
    private String name;
    private String description;
    private String subtitle;
    private int number;
    private boolean played;

    public Episode(String link, String name, String description, String subtitle, int number, boolean played, Integer duration) {
        this.link = link;
        this.name = name;
        this.description = description;
        this.subtitle = subtitle;
        this.number = number;
        this.played = played;
        this.duration = duration;
    }

    private Integer duration;
    private Date released;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean getPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Episode)) return false;
        Episode episode = (Episode) o;
        return getLink().equals(episode.getLink()) && getName().equals(episode.getName()) && Objects.equals(getDescription(), episode.getDescription()) && Objects.equals(getSubtitle(), episode.getSubtitle()) && Objects.equals(getNumber(), episode.getNumber()) && getDuration().equals(episode.getDuration()) && Objects.equals(getReleased(), episode.getReleased());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLink(), getName(), getDescription(), getSubtitle(), getNumber(), getDuration(), getReleased());
    }
}
