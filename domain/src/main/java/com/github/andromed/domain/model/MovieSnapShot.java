package com.github.andromed.domain.model;

/**
 * Created by devme on 2/10/2018.
 */

public class MovieSnapShot {

    private final String title;
    private final String poster;
    private final int year;

    public MovieSnapShot(String title, String poster, int year) {
        this.title = title;
        this.poster = poster;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public int getYear() {
        return year;
    }
}
