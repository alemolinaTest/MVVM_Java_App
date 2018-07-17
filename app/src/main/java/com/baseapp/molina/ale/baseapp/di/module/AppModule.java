
package com.baseapp.molina.ale.baseapp.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.baseapp.molina.ale.baseapp.BuildConfig;
import com.baseapp.molina.ale.baseapp.R;
import com.baseapp.molina.ale.baseapp.data.AppDataManager;
import com.baseapp.molina.ale.baseapp.data.DataManager;
import com.baseapp.molina.ale.baseapp.data.local.db.AppDatabase;
import com.baseapp.molina.ale.baseapp.data.local.db.AppDbHelper;
import com.baseapp.molina.ale.baseapp.data.local.db.DbHelper;
import com.baseapp.molina.ale.baseapp.data.local.prefs.AppPreferencesHelper;
import com.baseapp.molina.ale.baseapp.data.local.prefs.PreferencesHelper;
import com.baseapp.molina.ale.baseapp.data.remote.ApiHeader;
import com.baseapp.molina.ale.baseapp.data.remote.ApiHelper;
import com.baseapp.molina.ale.baseapp.data.remote.AppApiHelper;
import com.baseapp.molina.ale.baseapp.di.ApiInfo;
import com.baseapp.molina.ale.baseapp.di.DatabaseInfo;
import com.baseapp.molina.ale.baseapp.di.PreferenceInfo;
import com.baseapp.molina.ale.baseapp.rx.AppSchedulerProvider;
import com.baseapp.molina.ale.baseapp.rx.SchedulerProvider;
import com.baseapp.molina.ale.baseapp.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Amolina on 02/02/17.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }


    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}

