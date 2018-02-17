package com.github.andromed.data.network;

import com.github.andromed.data.model.MovieDraft;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by devme on 2/10/2018.
 */

public interface MovieApi {

    @GET("/")
    Single<List<MovieDraft>> getMovies();
}
