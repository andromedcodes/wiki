package com.github.andromed.data.repository;

import com.github.andromed.data.model.mapper.MovieMapper;
import com.github.andromed.data.network.ApiService;
import com.github.andromed.domain.model.Movie;
import com.github.andromed.domain.model.MovieSnapShot;
import com.github.andromed.domain.repository.MovieRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by devme on 2/10/2018.
 */
@Singleton
public class MovieDataRepository implements MovieRepository {

    private final ApiService mService;
    private final MovieMapper mapper;

    @Inject
    MovieDataRepository(ApiService mService,
                        MovieMapper mapper) {
        this.mService = mService;
        this.mapper = mapper;
    }

    @Override
    public Single<List<MovieSnapShot>> getMovies() {
        return this.mService.getService()
                .getMovies()
                .map(mapper::transform);
    }

    @Override
    public Single<Movie> getMovieDetails(int position) {
        return this.mService.getService()
                .getMovies()
                .flatMap(movieDrafts ->
                        Single.just(mapper.filterById(movieDrafts, position)));
    }
}
