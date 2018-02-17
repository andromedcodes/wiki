package com.github.andromed.data.network;

import android.content.Context;
import android.support.annotation.NonNull;

import com.github.andromed.data.BuildConfig;
import com.github.andromed.data.network.interceptor.HttpCacheManipulator;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by devme on 2/10/2018.
 */
@Singleton
public class ApiService {

    private MovieApi mService;
    private Context mContext;

    @Inject
    ApiService(@NonNull Context context) {
        this.mContext = context;
        mService = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(createHttpClient())
                .build()
                .create(MovieApi.class);
    }

    @NonNull
    private OkHttpClient createHttpClient() {
        return new OkHttpClient.Builder()
                .cache(buildCache())
                .addInterceptor(new HttpCacheManipulator(mContext))
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    @NonNull
    private Cache buildCache() {
        return new Cache(mContext.getCacheDir(), 10 * 1024 * 1024);
    }

    public MovieApi getService() {
        return this.mService;
    }
}
