package com.github.andromed.starwarswiki.view.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.andromed.starwarswiki.di.internal.HasComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by devme on 2/12/2018.
 */

public abstract class BaseFragment extends Fragment {

    protected BaseFragmentInteractions mListener;
    private Unbinder unbinder;

    protected abstract int getFragmentLayout();

    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseFragmentInteractions) {
            mListener = (BaseFragmentInteractions) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement BaseFragmentInteractions interface");
        }
    }

    @Override
    public void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    public interface BaseFragmentInteractions {

        void openFragment(int container, Fragment fragment, boolean addToBackStack);

        void openActivity(Class<? extends Activity> target);

        void closeFragment();
    }
}
