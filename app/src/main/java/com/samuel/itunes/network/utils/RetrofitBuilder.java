package com.samuel.itunes.network.utils;

import com.samuel.itunes.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * A helper class to get the {@link Retrofit} instance with basic setting.
 */

public class RetrofitBuilder {

    public static Retrofit getRetrofit() {

        return new Retrofit.Builder()
                .baseUrl(APIContant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getLogInterceptorClient())
                .build();
    }

    public static OkHttpClient getLogInterceptorClient() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {    //Enable API logs in debug mode
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            clientBuilder.addInterceptor(interceptor);
        }

        return clientBuilder.build();
    }
}
