package com.github.andromed.starwarswiki;

import android.app.Application;

import com.github.andromed.starwarswiki.di.internal.components.ApplicationComponent;
import com.github.andromed.starwarswiki.di.internal.components.DaggerApplicationComponent;
import com.github.andromed.starwarswiki.di.internal.modules.ApplicationModule;

/**
 * Created by devme on 2/12/2018.
 */

public class StarWars extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initInjector();
    }

    private void initInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
