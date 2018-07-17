package com.baseapp.molina.ale.baseapp.ui.feed.blogs;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


/**
 * Created by Amolina on 10/10/17.
 */

@Module
public abstract class BlogFragmentProvider {

    @ContributesAndroidInjector(modules = BlogFragmentModule.class)
    abstract BlogFragment provideBlogFragmentFactory();

}
