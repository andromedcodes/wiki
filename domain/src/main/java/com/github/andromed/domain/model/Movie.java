package com.github.andromed.domain.model;

import java.util.List;

/**
 * Created by devme on 2/10/2018.
 */

public class Movie {

    private final String title;
    private final int year;
    private final String intro;
    private final String longDescription;
    private final List<String> images;

    public Movie(String title,
                 int year,
                 String intro,
                 String longDescription,
                 List<String> images) {
        this.title = title;
        this.year = year;
        this.intro = intro;
        this.longDescription = longDescription;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getIntro() {
        return intro;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public List<String> getImages() {
        return images;
    }
}
