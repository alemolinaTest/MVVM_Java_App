package com.baseapp.molina.ale.baseapp.ui.main;

import android.arch.lifecycle.ViewModelProvider;

import com.baseapp.molina.ale.baseapp.ViewModelProviderFactory;
import com.baseapp.molina.ale.baseapp.data.DataManager;
import com.baseapp.molina.ale.baseapp.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Amolina on 02/02/17.
 */

@Module
public class MainActivityModule {

    @Provides
    MainViewModel provideMainViewModel(DataManager dataManager,
                                       SchedulerProvider schedulerProvider) {
        return new MainViewModel(dataManager, schedulerProvider);
    }

    @Provides
    ViewModelProvider.Factory mainViewModelProvider(MainViewModel mainViewModel) {
        return new ViewModelProviderFactory<>(mainViewModel);
    }

}
