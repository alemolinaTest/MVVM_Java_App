package com.baseapp.molina.ale.baseapp.ui.about;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Amolina on 02/02/17.
 */
@Module
public abstract class AboutFragmentProvider {

    @ContributesAndroidInjector(modules = AboutFragmentModule.class)
    abstract AboutFragment provideAboutFragmentFactory();

}
