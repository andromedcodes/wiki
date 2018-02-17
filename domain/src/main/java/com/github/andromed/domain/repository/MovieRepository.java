package com.github.andromed.domain.repository;

import com.github.andromed.domain.model.Movie;
import com.github.andromed.domain.model.MovieSnapShot;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by devme on 2/10/2018.
 */

public interface MovieRepository {

    Single<List<MovieSnapShot>> getMovies();

    Single<Movie> getMovieDetails(int position);
}
