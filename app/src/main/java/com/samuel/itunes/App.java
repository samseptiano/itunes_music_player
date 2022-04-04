package com.samuel.itunes;

import android.app.Application;

import com.samuel.itunes.BuildConfig;

import timber.log.Timber;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
    }
}
