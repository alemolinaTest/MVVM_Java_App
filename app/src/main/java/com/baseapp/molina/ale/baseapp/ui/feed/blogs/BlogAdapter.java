package com.baseapp.molina.ale.baseapp.ui.feed.blogs;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.baseapp.molina.ale.baseapp.data.model.api.BlogResponse;
import com.baseapp.molina.ale.baseapp.databinding.ItemBlogEmptyViewBinding;
import com.baseapp.molina.ale.baseapp.databinding.ItemBlogViewBinding;
import com.baseapp.molina.ale.baseapp.ui.base.BaseViewHolder;
import com.baseapp.molina.ale.baseapp.utils.AppLogger;

import java.util.List;

/**
 * Created by Amolina on 10/10/17.
 */

public class BlogAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private List<BlogResponse.Blog> mBlogResponseList;

    private BlogAdapterListener mListener;

    public BlogAdapter(List<BlogResponse.Blog> blogResponseList) {
        this.mBlogResponseList = blogResponseList;
    }

    public void setListener(BlogAdapterListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ItemBlogViewBinding blogViewBinding = ItemBlogViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new BlogViewHolder(blogViewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                ItemBlogEmptyViewBinding emptyViewBinding = ItemBlogEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new EmptyViewHolder(emptyViewBinding);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mBlogResponseList != null && mBlogResponseList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (mBlogResponseList != null && mBlogResponseList.size() > 0) {
            return mBlogResponseList.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<BlogResponse.Blog> blogList) {
        mBlogResponseList.addAll(blogList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mBlogResponseList.clear();
    }

    public class BlogViewHolder extends BaseViewHolder implements BlogItemViewModel.BlogItemViewModelListener {

        private ItemBlogViewBinding mBinding;

        private BlogItemViewModel mBlogItemViewModel;

        public BlogViewHolder(ItemBlogViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {

            final BlogResponse.Blog blog = mBlogResponseList.get(position);

            mBlogItemViewModel = new BlogItemViewModel(blog, this);

            mBinding.setViewModel(mBlogItemViewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();

        }

        @Override
        public void onItemClick(String blogUrl) {
            if (blogUrl != null) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(blogUrl));
                    itemView.getContext().startActivity(intent);
                } catch (Exception e) {
                    AppLogger.d("url error");
                }
            }
        }
    }

    public class EmptyViewHolder extends BaseViewHolder implements BlogEmptyItemViewModel.BlogEmptyItemViewModelListener {

        private ItemBlogEmptyViewBinding mBinding;

        public EmptyViewHolder(ItemBlogEmptyViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            BlogEmptyItemViewModel emptyItemViewModel = new BlogEmptyItemViewModel(this);
            mBinding.setViewModel(emptyItemViewModel);
        }

        @Override
        public void onRetryClick() {
            mListener.onRetryClick();
        }
    }

    public interface BlogAdapterListener {
        void onRetryClick();
    }
}