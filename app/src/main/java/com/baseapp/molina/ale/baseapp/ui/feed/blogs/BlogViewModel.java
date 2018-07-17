package com.baseapp.molina.ale.baseapp.ui.feed.blogs;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;

import com.baseapp.molina.ale.baseapp.data.DataManager;
import com.baseapp.molina.ale.baseapp.data.model.api.BlogResponse;
import com.baseapp.molina.ale.baseapp.ui.base.BaseViewModel;
import com.baseapp.molina.ale.baseapp.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;


/**
 * Created by Amolina on 10/10/17.
 */


public class BlogViewModel extends BaseViewModel<BlogNavigator> {

    private final ObservableArrayList<BlogResponse.Blog> blogObservableArrayList = new ObservableArrayList<>();
    private final MutableLiveData<List<BlogResponse.Blog>> blogListLiveData;

    public BlogViewModel(DataManager dataManager,
                         SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        blogListLiveData = new MutableLiveData<>();
        fetchBlogs();
    }

    public void fetchBlogs() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getBlogApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<BlogResponse>() {
                    @Override
                    public void accept(@NonNull BlogResponse blogResponse)
                            throws Exception {
                        if (blogResponse != null && blogResponse.getData() != null) {
                            blogListLiveData.setValue(blogResponse.getData());
                        }
                        setIsLoading(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        setIsLoading(false);
                        getNavigator().handleError(throwable);
                    }
                }));
    }

    public MutableLiveData<List<BlogResponse.Blog>> getBlogListLiveData() {
        return blogListLiveData;
    }

    public void addBlogItemsToList(List<BlogResponse.Blog> blogs) {
        blogObservableArrayList.clear();
        blogObservableArrayList.addAll(blogs);
    }

    public ObservableArrayList<BlogResponse.Blog> getBlogObservableArrayList() {
        return blogObservableArrayList;
    }
}
