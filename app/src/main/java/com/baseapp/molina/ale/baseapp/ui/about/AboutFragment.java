package com.baseapp.molina.ale.baseapp.ui.about;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.baseapp.molina.ale.baseapp.BR;
import com.baseapp.molina.ale.baseapp.R;
import com.baseapp.molina.ale.baseapp.databinding.FragmentAboutBinding;
import com.baseapp.molina.ale.baseapp.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * Created by Amolina on 02/02/17.
 */

public class AboutFragment extends BaseFragment<FragmentAboutBinding, AboutViewModel> implements AboutNavigator {

    public static final String TAG = "AboutFragment";

    @Inject
    AboutViewModel mAboutViewModel;

    public static AboutFragment newInstance() {
        Bundle args = new Bundle();
        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAboutViewModel.setNavigator(this);
    }

    @Override
    public AboutViewModel getViewModel() {
        return mAboutViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_about;
    }

    @Override
    public void goBack() {
        getBaseActivity().onFragmentDetached(TAG);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
