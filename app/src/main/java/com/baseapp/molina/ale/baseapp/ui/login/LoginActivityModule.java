
package com.baseapp.molina.ale.baseapp.ui.login;

import com.baseapp.molina.ale.baseapp.data.DataManager;
import com.baseapp.molina.ale.baseapp.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Amolina on 02/02/17.
 */
@Module
public class LoginActivityModule {

    @Provides
    LoginViewModel provideLoginViewModel(DataManager dataManager,
                                         SchedulerProvider schedulerProvider) {
        return new LoginViewModel(dataManager, schedulerProvider);
    }

}
