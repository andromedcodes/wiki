package com.github.andromed.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by devme on 2/10/2018.
 */

public class MovieDraft {

    @SerializedName("images")
    @Expose
    private List<String> images = null;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("intro")
    @Expose
    private String intro;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("text")
    @Expose
    private String text;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}