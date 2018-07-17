package com.baseapp.molina.ale.baseapp.ui.rating;

import com.baseapp.molina.ale.baseapp.data.DataManager;
import com.baseapp.molina.ale.baseapp.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amolina on 02/02/17.
 */
@Module
public class RateUsDialogModule {

    @Provides
    RateUsViewModel provideRateUsViewModel(DataManager dataManager,
                                           SchedulerProvider schedulerProvider) {
        return new RateUsViewModel(dataManager, schedulerProvider);
    }

}
