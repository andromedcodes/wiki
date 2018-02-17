package com.github.andromed.starwarswiki.di.internal.components;

import android.content.Context;

import com.github.andromed.domain.executor.PostExecutionThread;
import com.github.andromed.domain.executor.ThreadExecutor;
import com.github.andromed.domain.repository.MovieRepository;
import com.github.andromed.starwarswiki.di.internal.modules.ApplicationModule;
import com.github.andromed.starwarswiki.view.base.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by devme on 2/12/2018.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity activity);

    Context context();

    ThreadExecutor threadExecuoter();

    PostExecutionThread postExecutionThread();

    MovieRepository movieRepository();
}
