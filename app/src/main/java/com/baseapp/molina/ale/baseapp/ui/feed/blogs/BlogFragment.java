package com.baseapp.molina.ale.baseapp.ui.feed.blogs;

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
import com.baseapp.molina.ale.baseapp.data.model.api.BlogResponse;
import com.baseapp.molina.ale.baseapp.databinding.FragmentBlogBinding;
import com.baseapp.molina.ale.baseapp.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by Amolina on 10/10/17.
 */

public class BlogFragment extends BaseFragment<FragmentBlogBinding, BlogViewModel> implements BlogNavigator, BlogAdapter.BlogAdapterListener {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    @Inject
    BlogAdapter mBlogAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    FragmentBlogBinding mFragmentBlogBinding;
    private BlogViewModel mBlogViewModel;

    public static BlogFragment newInstance() {
        Bundle args = new Bundle();
        BlogFragment fragment = new BlogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBlogViewModel.setNavigator(this);
        mBlogAdapter.setListener(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentBlogBinding = getViewDataBinding();
        setUp();
        subscribeToLiveData();
    }

    @Override
    public BlogViewModel getViewModel() {
        mBlogViewModel = ViewModelProviders.of(this, mViewModelFactory).get(BlogViewModel.class);
        return mBlogViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_blog;
    }

    private void setUp() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mFragmentBlogBinding.blogRecyclerView.setLayoutManager(mLayoutManager);
        mFragmentBlogBinding.blogRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFragmentBlogBinding.blogRecyclerView.setAdapter(mBlogAdapter);
    }

    private void subscribeToLiveData() {
        mBlogViewModel.getBlogListLiveData().observe(this, new Observer<List<BlogResponse.Blog>>() {
            @Override
            public void onChanged(@Nullable List<BlogResponse.Blog> blogs) {
                mBlogViewModel.addBlogItemsToList(blogs);
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void updateBlog(List<BlogResponse.Blog> blogList) {
        mBlogAdapter.addItems(blogList);
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
    }

    @Override
    public void onRetryClick() {
        mBlogViewModel.fetchBlogs();
    }

}
