package com.github.andromed.starwarswiki.di.internal.modules;

import android.content.Context;

import com.github.andromed.data.executor.JobExecutor;
import com.github.andromed.data.repository.MovieDataRepository;
import com.github.andromed.domain.executor.PostExecutionThread;
import com.github.andromed.domain.executor.ThreadExecutor;
import com.github.andromed.domain.repository.MovieRepository;
import com.github.andromed.starwarswiki.StarWars;
import com.github.andromed.starwarswiki.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by devme on 2/12/2018.
 */

@Module
public class ApplicationModule {

    private final StarWars application;

    public ApplicationModule(StarWars application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor executor) {
        return executor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    MovieRepository provideMovieRepository(MovieDataRepository dataRepository) {
        return dataRepository;
    }
}
