package com.github.andromed.starwarswiki.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.andromed.starwarswiki.R;
import com.github.andromed.starwarswiki.view.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieListFragment extends BaseFragment {


    public MovieListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false);
    }

}
