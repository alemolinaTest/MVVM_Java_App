package com.baseapp.molina.ale.baseapp.ui.feed;

import com.baseapp.molina.ale.baseapp.data.DataManager;
import com.baseapp.molina.ale.baseapp.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amolina on 02/02/17.
 */
@Module
public class FeedActivityModule {

    @Provides
    FeedViewModel provideFeedViewModel(DataManager dataManager,
                                       SchedulerProvider schedulerProvider) {
        return new FeedViewModel(dataManager, schedulerProvider);
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(FeedActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

}
