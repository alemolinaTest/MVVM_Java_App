package com.baseapp.molina.ale.baseapp.ui.rating;

import com.baseapp.molina.ale.baseapp.data.DataManager;
import com.baseapp.molina.ale.baseapp.ui.base.BaseViewModel;
import com.baseapp.molina.ale.baseapp.rx.SchedulerProvider;

/**
 * Created by Amolina on 02/02/17.
 */

public class RateUsViewModel extends BaseViewModel<RateUsCallback> {

    public RateUsViewModel(DataManager dataManager,
                           SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onLaterClick() {
        getNavigator().dismissDialog();
    }

    public void onSubmitClick() {
        getNavigator().dismissDialog();
    }

}
