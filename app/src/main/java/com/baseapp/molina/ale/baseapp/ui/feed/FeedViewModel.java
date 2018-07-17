package com.baseapp.molina.ale.baseapp.ui.feed;

import com.baseapp.molina.ale.baseapp.data.DataManager;
import com.baseapp.molina.ale.baseapp.ui.base.BaseViewModel;
import com.baseapp.molina.ale.baseapp.rx.SchedulerProvider;

/**
 * Created by Amolina on 02/02/17.
 */

public class FeedViewModel extends BaseViewModel {

    public FeedViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

}
