package com.akbarprojec.retrofithttp;

import com.google.gson.annotations.SerializedName;

public class PhotoData {

    @SerializedName("albumID")
    private String albumID;
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    @SerializedName("tubnailUrl")
    private String tubnailUrl;

    public PhotoData(String albumID, String id, String title, String url, String tubnailUrl) {
        this.albumID = albumID;
        this.id = id;
        this.title = title;
        this.url = url;
        this.tubnailUrl = tubnailUrl;
    }

    public String getAlbumID() {
        return albumID;
    }

    public void setAlbumID(String albumID) {
        this.albumID = albumID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTubnailUrl() {
        return tubnailUrl;
    }

    public void setTubnailUrl(String tubnailUrl) {
        this.tubnailUrl = tubnailUrl;
    }
}
