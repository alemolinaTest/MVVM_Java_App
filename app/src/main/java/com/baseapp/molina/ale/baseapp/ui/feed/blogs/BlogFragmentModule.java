package com.baseapp.molina.ale.baseapp.ui.feed.blogs;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.LinearLayoutManager;

import com.baseapp.molina.ale.baseapp.ViewModelProviderFactory;
import com.baseapp.molina.ale.baseapp.data.DataManager;
import com.baseapp.molina.ale.baseapp.data.model.api.BlogResponse;
import com.baseapp.molina.ale.baseapp.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Amolina on 10/10/17.
 */

@Module
public class BlogFragmentModule {

    @Provides
    BlogViewModel blogViewModel(DataManager dataManager,
                                       SchedulerProvider schedulerProvider) {
        return new BlogViewModel(dataManager, schedulerProvider);
    }

    @Provides
    BlogAdapter provideBlogAdapter() {
        return new BlogAdapter(new ArrayList<BlogResponse.Blog>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(BlogFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }

    @Provides
    ViewModelProvider.Factory provideBlogViewModel(BlogViewModel blogViewModel) {
        return new ViewModelProviderFactory<>(blogViewModel);
    }

}
