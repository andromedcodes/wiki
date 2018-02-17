package com.github.andromed.data.network.interceptor;

import android.content.Context;

import com.github.andromed.data.utils.Utils;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by devme on 2/10/2018.
 */

public class HttpCacheManipulator implements Interceptor {

    private final Context mContext;

    public HttpCacheManipulator(Context context) {
        this.mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        int age;
        if (Utils.isNetworkAvailable(mContext)) {
            age = 60;
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, max-age=" + age)
                    .build();
        } else {
            age = 60 * 60 * 24 * 28;
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" +
                    age).build();
        }
    }
}
