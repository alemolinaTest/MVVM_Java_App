package com.baseapp.molina.ale.baseapp.ui.feed.blogs;

/**
 * Created by Amolina on 10/10/17.
 */


public class BlogEmptyItemViewModel {

    private BlogEmptyItemViewModelListener mListener;

    public BlogEmptyItemViewModel(BlogEmptyItemViewModelListener listener) {
        this.mListener = listener;
    }

    public void onRetryClick() {
        mListener.onRetryClick();
    }

    public interface BlogEmptyItemViewModelListener {
        void onRetryClick();
    }

}
