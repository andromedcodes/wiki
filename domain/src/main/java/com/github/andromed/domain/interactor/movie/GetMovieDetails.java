package com.github.andromed.domain.interactor.movie;

import com.github.andromed.domain.executor.PostExecutionThread;
import com.github.andromed.domain.executor.ThreadExecutor;
import com.github.andromed.domain.interactor.UseCase;
import com.github.andromed.domain.model.Movie;
import com.github.andromed.domain.repository.MovieRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by devme on 2/11/2018.
 */

public class GetMovieDetails extends UseCase<Movie, Integer> {

    private final MovieRepository mRepository;

    @Inject
    GetMovieDetails(MovieRepository repository,
                           ThreadExecutor threadExecutor,
                           PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.mRepository = repository;
    }

    @Override
    public Observable<Movie> buildUseCaseObservable(Integer position) {
        return this.mRepository.getMovieDetails(position).toObservable();
    }
}
