
package com.baseapp.molina.ale.baseapp.ui.about;

import com.baseapp.molina.ale.baseapp.data.DataManager;
import com.baseapp.molina.ale.baseapp.ui.base.BaseViewModel;
import com.baseapp.molina.ale.baseapp.rx.SchedulerProvider;

/**
 * Created by Amolina on 02/02/17.
 */

public class AboutViewModel extends BaseViewModel<AboutNavigator> {

    public AboutViewModel(DataManager dataManager,
                          SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onNavBackClick() {
        getNavigator().goBack();
    }
}
