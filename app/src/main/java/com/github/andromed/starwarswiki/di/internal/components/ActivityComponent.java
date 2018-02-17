package com.github.andromed.starwarswiki.di.internal.components;

import android.app.Activity;

import com.github.andromed.starwarswiki.di.internal.modules.ActivityModule;
import com.github.andromed.starwarswiki.di.internal.scopes.PerActivity;

import dagger.Component;

/**
 * Created by devme on 2/12/2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();
}
