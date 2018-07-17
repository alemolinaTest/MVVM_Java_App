package com.baseapp.molina.ale.baseapp.ui.feed.opensource;

/**
 * Created by Amolina on 02/02/17.
 */

public class OpenSourceEmptyItemViewModel {

    private OpenSourceEmptyItemViewModelListener mListener;

    public OpenSourceEmptyItemViewModel(OpenSourceEmptyItemViewModelListener listener) {
        this.mListener = listener;
    }

    public void onRetryClick() {
        mListener.onRetryClick();
    }

    public interface OpenSourceEmptyItemViewModelListener {
        void onRetryClick();
    }
}
