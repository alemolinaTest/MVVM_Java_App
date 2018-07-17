package com.baseapp.molina.ale.baseapp.ui.feed.blogs;

import android.databinding.ObservableField;

import com.baseapp.molina.ale.baseapp.data.model.api.BlogResponse;

/**
 * Created by Amolina on 10/10/17.
 */


public class BlogItemViewModel {

    private BlogResponse.Blog mBlog;
    public ObservableField<String> imageUrl;
    public ObservableField<String> title;
    public ObservableField<String> author;
    public ObservableField<String> date;
    public ObservableField<String> content;

    public BlogItemViewModelListener mListener;

    public BlogItemViewModel(BlogResponse.Blog blog, BlogItemViewModelListener listener) {
        this.mBlog = blog;
        this.mListener = listener;
        imageUrl = new ObservableField<>(mBlog.getCoverImgUrl());
        title = new ObservableField<>(mBlog.getTitle());
        author = new ObservableField<>(mBlog.getAuthor());
        date = new ObservableField<>(mBlog.getFormattedDate());
        content = new ObservableField<>(mBlog.getDescription());
    }

    public void onItemClick() {
        mListener.onItemClick(mBlog.getBlogUrl());
    }

    public interface BlogItemViewModelListener {
        void onItemClick(String blogUrl);
    }
}
