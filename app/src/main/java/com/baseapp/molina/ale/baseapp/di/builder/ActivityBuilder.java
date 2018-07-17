package com.baseapp.molina.ale.baseapp.di.builder;

import com.baseapp.molina.ale.baseapp.ui.about.AboutFragmentProvider;
import com.baseapp.molina.ale.baseapp.ui.feed.FeedActivity;
import com.baseapp.molina.ale.baseapp.ui.feed.FeedActivityModule;
import com.baseapp.molina.ale.baseapp.ui.feed.blogs.BlogFragmentProvider;
import com.baseapp.molina.ale.baseapp.ui.feed.opensource.OpenSourceFragmentProvider;
import com.baseapp.molina.ale.baseapp.ui.login.LoginActivity;
import com.baseapp.molina.ale.baseapp.ui.login.LoginActivityModule;
import com.baseapp.molina.ale.baseapp.ui.main.MainActivity;
import com.baseapp.molina.ale.baseapp.ui.main.MainActivityModule;
import com.baseapp.molina.ale.baseapp.ui.rating.RateUsDialogProvider;
import com.baseapp.molina.ale.baseapp.ui.splash.SplashActivity;
import com.baseapp.molina.ale.baseapp.ui.splash.SplashActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Amolina on 14/09/17.
 */

// We map all our activities here, with their modules, that provides the correspondent ViewModule
@Module
public abstract class ActivityBuilder {
/* UI subcomponents(SplashActivityComponent , LoginActivityComponent, MainActivityComponent)
    are just like bridges to get the modules in the graph
    With this annotation, we can easily attach activities/fragments to dagger graph
    without using components for every activity*/

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = {MainActivityModule.class,
            AboutFragmentProvider.class, RateUsDialogProvider.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {FeedActivityModule.class,
            BlogFragmentProvider.class, OpenSourceFragmentProvider.class})
    abstract FeedActivity bindFeedActivity();

}
