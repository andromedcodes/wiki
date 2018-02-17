package com.github.andromed.domain.interactor.movie;

import com.github.andromed.domain.executor.PostExecutionThread;
import com.github.andromed.domain.executor.ThreadExecutor;
import com.github.andromed.domain.interactor.UseCase;
import com.github.andromed.domain.model.MovieSnapShot;
import com.github.andromed.domain.repository.MovieRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by devme on 2/11/2018.
 */

public class GetMovieList extends UseCase<List<MovieSnapShot>, Void> {

    private final MovieRepository mRepository;

    @Inject
    GetMovieList(MovieRepository repository,
                 ThreadExecutor threadExecutor,
                 PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.mRepository = repository;
    }

    @Override
    public Observable<List<MovieSnapShot>> buildUseCaseObservable(Void aVoid) {
        return this.mRepository.getMovies().toObservable();
    }
}
