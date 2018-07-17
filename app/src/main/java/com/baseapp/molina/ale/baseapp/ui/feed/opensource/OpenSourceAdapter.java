package com.baseapp.molina.ale.baseapp.ui.feed.opensource;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baseapp.molina.ale.baseapp.databinding.ItemOpenSourceEmptyViewBinding;
import com.baseapp.molina.ale.baseapp.databinding.ItemOpenSourceViewBinding;
import com.baseapp.molina.ale.baseapp.ui.base.BaseViewHolder;
import com.baseapp.molina.ale.baseapp.utils.AppLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amolina on 02/02/17.
 */

public class OpenSourceAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private List<OpenSourceItemViewModel> mOpenSourceResponseList;
    private OpenSourceAdapterListener mListener;

    public OpenSourceAdapter() {
        this.mOpenSourceResponseList = new ArrayList<>();
    }

    public void setListener(OpenSourceAdapterListener listener) {
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
                ItemOpenSourceViewBinding openSourceViewBinding = ItemOpenSourceViewBinding
                        .inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new OpenSourceViewHolder(openSourceViewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                ItemOpenSourceEmptyViewBinding emptyViewBinding = ItemOpenSourceEmptyViewBinding
                        .inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new EmptyViewHolder(emptyViewBinding);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mOpenSourceResponseList != null && mOpenSourceResponseList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (mOpenSourceResponseList != null && mOpenSourceResponseList.size() > 0) {
            return mOpenSourceResponseList.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<OpenSourceItemViewModel> repoList) {
        mOpenSourceResponseList.addAll(repoList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mOpenSourceResponseList.clear();
    }

    public class OpenSourceViewHolder extends BaseViewHolder implements View.OnClickListener {

        private ItemOpenSourceViewBinding mBinding;


        public OpenSourceViewHolder(ItemOpenSourceViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final OpenSourceItemViewModel mOpenSourceItemViewModel = mOpenSourceResponseList.get(position);
            mBinding.setViewModel(mOpenSourceItemViewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();
        }


        @Override
        public void onClick(View view) {
            if (mOpenSourceResponseList.get(0).projectUrl.get() != null) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(mOpenSourceResponseList.get(0).projectUrl.get()));
                    itemView.getContext().startActivity(intent);
                } catch (Exception e) {
                    AppLogger.d("url error");
                }
            }
        }
    }

    public class EmptyViewHolder extends BaseViewHolder implements OpenSourceEmptyItemViewModel.OpenSourceEmptyItemViewModelListener {

        private ItemOpenSourceEmptyViewBinding mBinding;

        public EmptyViewHolder(ItemOpenSourceEmptyViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            OpenSourceEmptyItemViewModel emptyItemViewModel = new OpenSourceEmptyItemViewModel(this);
            mBinding.setViewModel(emptyItemViewModel);
        }

        @Override
        public void onRetryClick() {
            mListener.onRetryClick();
        }
    }

    public interface OpenSourceAdapterListener {
        void onRetryClick();
    }
}