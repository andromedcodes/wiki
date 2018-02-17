package com.github.andromed.starwarswiki.view.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.github.andromed.starwarswiki.StarWars;
import com.github.andromed.starwarswiki.di.internal.components.ApplicationComponent;
import com.github.andromed.starwarswiki.di.internal.components.DaggerFragmentComponent;
import com.github.andromed.starwarswiki.di.internal.components.FragmentComponent;
import com.github.andromed.starwarswiki.di.internal.modules.ActivityModule;

/**
 * Created by devme on 2/12/2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements
        BaseFragment.BaseFragmentInteractions {

    protected FragmentComponent fragmentComponent;

    protected void initializeInjector() {
        this.fragmentComponent = DaggerFragmentComponent.builder()
                .applicationComponent(this.getApplicationComponent())
                .activityModule(this.getActivityModule())
                .build();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState,
                         @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        this.getApplicationComponent().inject(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        this.fragmentComponent = null;
        super.onDestroy();
    }

    @Override
    public void openFragment(int container, Fragment fragment, boolean addToBackStack) {
        final FragmentTransaction transaction = this.getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment);
        if (addToBackStack) {
            transaction.addToBackStack(fragment.getTag())
                    .commit();
            return;
        }
        transaction.commitNow();
    }

    @Override
    public void openActivity(Class<? extends Activity> target) {
        this.startActivity(new Intent(this, target));
    }

    @Override
    public void closeFragment() {
        if (this.getSupportFragmentManager().getBackStackEntryCount() > 1)
            this.getSupportFragmentManager().popBackStackImmediate();
        else
            this.finish();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((StarWars) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
