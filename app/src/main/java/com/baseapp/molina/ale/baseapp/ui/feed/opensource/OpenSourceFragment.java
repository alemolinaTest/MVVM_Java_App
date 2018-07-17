package com.baseapp.molina.ale.baseapp.ui.feed.opensource;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.baseapp.molina.ale.baseapp.BR;
import com.baseapp.molina.ale.baseapp.R;
import com.baseapp.molina.ale.baseapp.databinding.FragmentOpenSourceBinding;
import com.baseapp.molina.ale.baseapp.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Amolina on 02/02/17.
 */

public class OpenSourceFragment extends BaseFragment<FragmentOpenSourceBinding, OpenSourceViewModel> implements OpenSourceNavigator, OpenSourceAdapter.OpenSourceAdapterListener {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    @Inject
    OpenSourceAdapter mOpenSourceAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    private OpenSourceViewModel mOpenSourceViewModel;
    FragmentOpenSourceBinding mFragmentOpenSourceBinding;

    public static OpenSourceFragment newInstance() {
        Bundle args = new Bundle();
        OpenSourceFragment fragment = new OpenSourceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOpenSourceViewModel.setNavigator(this);
        mOpenSourceAdapter.setListener(this);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentOpenSourceBinding = getViewDataBinding();
        setUp();
        subscribeToLiveData();
    }

    private void subscribeToLiveData() {
        mOpenSourceViewModel.getOpenSourceRepos().observe(this, new Observer<List<OpenSourceItemViewModel>>() {
            @Override
            public void onChanged(@Nullable List<OpenSourceItemViewModel> openSourceItemViewModels) {
                mOpenSourceViewModel.addOpenSourceItemsToList(openSourceItemViewModels);
            }
        });
    }

    @Override
    public OpenSourceViewModel getViewModel() {
        mOpenSourceViewModel = ViewModelProviders.of(this, mViewModelFactory).get(OpenSourceViewModel.class);
        return mOpenSourceViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_open_source;
    }

    private void setUp() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mFragmentOpenSourceBinding.openSourceRecyclerView.setLayoutManager(mLayoutManager);
        mFragmentOpenSourceBinding.openSourceRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFragmentOpenSourceBinding.openSourceRecyclerView.setAdapter(mOpenSourceAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
    }

    @Override
    public void onRetryClick() {
        mOpenSourceViewModel.fetchRepos();
    }
}
