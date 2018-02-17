package com.github.andromed.starwarswiki.di.internal.modules;

import android.app.Activity;

import com.github.andromed.starwarswiki.di.internal.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by devme on 2/12/2018.
 */

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }
}
