package com.github.andromed.starwarswiki.view.activity;

import android.os.Bundle;

import com.github.andromed.starwarswiki.R;
import com.github.andromed.starwarswiki.view.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
