package com.github.andromed.data.model.mapper;

import com.github.andromed.data.model.MovieDraft;
import com.github.andromed.domain.model.Movie;
import com.github.andromed.domain.model.MovieSnapShot;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by devme on 2/10/2018.
 */
@Singleton
public class MovieMapper {

    @Inject
    public MovieMapper() {
    }

    public List<MovieSnapShot> transform(List<MovieDraft> source) {
        List<MovieSnapShot> movies = new ArrayList<>(source.size());
        for (MovieDraft draft :
                source) {
            movies.add(new MovieSnapShot(draft.getTitle(),
                    draft.getImages().get(0),
                    Integer.parseInt(draft.getYear())));
        }
        return movies;
    }

    private Movie transform(MovieDraft source) {
        return new Movie(source.getTitle(),
                Integer.parseInt(source.getYear()),
                source.getIntro(),
                source.getText(),
                source.getImages());
    }

    public Movie filterById(List<MovieDraft> source, int position) {
        return transform(source.get(position));
    }
}
