package com.baseapp.molina.ale.baseapp.ui.rating;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Amolina on 02/02/17.
 */
@Module
public abstract class RateUsDialogProvider {

    @ContributesAndroidInjector(modules = RateUsDialogModule.class)
    abstract RateUsDialog provideRateUsDialogFactory();

}
