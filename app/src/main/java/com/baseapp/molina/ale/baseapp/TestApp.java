package com.baseapp.molina.ale.baseapp;

import android.app.Activity;
import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.baseapp.molina.ale.baseapp.di.component.DaggerAppComponent;
import com.baseapp.molina.ale.baseapp.utils.AppLogger;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Amolina on 02/02/17.
 */

public class TestApp extends Application implements HasActivityInjector {
    @Inject
    CalligraphyConfig mCalligraphyConfig;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        //Dagger 2 creates the DaggerComponent classes during compilation
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
        //custom logger with Timber
        AppLogger.init();

        //set style to text views like style="@style/TextStyle.Heading"
        //using fontPath with custom fonts (ttf)
        CalligraphyConfig.initDefault(mCalligraphyConfig);

        //instead of retrofit, implement http2, reduce latency, 50% faster
        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

}
