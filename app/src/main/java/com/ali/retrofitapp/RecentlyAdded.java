package com.ali.retrofitapp;

import com.google.gson.annotations.SerializedName;

public class RecentlyAdded {
    @SerializedName("ID")
    private String id;
    @SerializedName("Title")
    private String title;
    @SerializedName("Cover")
    private String cover;
    @SerializedName("Date")
    private String date;
    @SerializedName("Episode")
    private String episode;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public String getDate() {
        return date;
    }

    public String getEpisode() {
        return episode;
    }
}
