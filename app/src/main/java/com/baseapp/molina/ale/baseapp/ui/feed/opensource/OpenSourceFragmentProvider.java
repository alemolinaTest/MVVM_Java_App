package com.baseapp.molina.ale.baseapp.ui.feed.opensource;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Amolina on 02/02/17.
 */
@Module
public abstract class OpenSourceFragmentProvider {

    @ContributesAndroidInjector(modules = OpenSourceFragmentModule.class)
    abstract OpenSourceFragment provideOpenSourceFragmentFactory();

}
