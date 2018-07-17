package com.baseapp.molina.ale.baseapp.ui.rating;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baseapp.molina.ale.baseapp.R;
import com.baseapp.molina.ale.baseapp.databinding.DialogRateUsBinding;
import com.baseapp.molina.ale.baseapp.ui.base.BaseDialog;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by Amolina on 02/02/17.
 */

public class RateUsDialog extends BaseDialog implements RateUsCallback {

    private static final String TAG = "RateUsDialog";

    @Inject
    RateUsViewModel mRateUsViewModel;

    public static RateUsDialog newInstance() {
        RateUsDialog fragment = new RateUsDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DialogRateUsBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.dialog_rate_us, container, false);
        View view = binding.getRoot();

        AndroidSupportInjection.inject(this);

        binding.setViewModel(mRateUsViewModel);

        mRateUsViewModel.setNavigator(this);

        return view;
    }


    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void dismissDialog() {
        dismissDialog(TAG);
    }
}
