package com.baseapp.molina.ale.baseapp.ui.about;

import com.baseapp.molina.ale.baseapp.data.DataManager;
import com.baseapp.molina.ale.baseapp.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amolina on 02/02/17.
 */
@Module
public class AboutFragmentModule {

    @Provides
    AboutViewModel provideAboutViewModel(DataManager dataManager,
                                         SchedulerProvider schedulerProvider) {
        return new AboutViewModel(dataManager, schedulerProvider);
    }

}
