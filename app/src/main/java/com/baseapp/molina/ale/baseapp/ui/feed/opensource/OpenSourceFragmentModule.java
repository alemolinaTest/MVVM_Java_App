package com.baseapp.molina.ale.baseapp.ui.feed.opensource;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.LinearLayoutManager;

import com.baseapp.molina.ale.baseapp.ViewModelProviderFactory;
import com.baseapp.molina.ale.baseapp.data.DataManager;
import com.baseapp.molina.ale.baseapp.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amolina on 02/02/17.
 */
@Module
public class OpenSourceFragmentModule {

    @Provides
    OpenSourceViewModel openSourceViewModel(DataManager dataManager,
                                                   SchedulerProvider schedulerProvider) {
        return new OpenSourceViewModel(dataManager, schedulerProvider);
    }

    @Provides
    OpenSourceAdapter provideOpenSourceAdapter() {
        return new OpenSourceAdapter();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(OpenSourceFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }

    @Provides
    ViewModelProvider.Factory provideOpenSourceViewModel(OpenSourceViewModel openSourceViewModel) {
        return new ViewModelProviderFactory<>(openSourceViewModel);
    }
}
