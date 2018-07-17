package com.baseapp.molina.ale.baseapp.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.baseapp.molina.ale.baseapp.BR;
import com.baseapp.molina.ale.baseapp.R;
import com.baseapp.molina.ale.baseapp.databinding.ActivitySplashBinding;
import com.baseapp.molina.ale.baseapp.ui.base.BaseActivity;
import com.baseapp.molina.ale.baseapp.ui.login.LoginActivity;
import com.baseapp.molina.ale.baseapp.ui.main.MainActivity;

import javax.inject.Inject;

/**
 * Created by Amolina on 02/02/17.
 */
//the view of VMMV
public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Inject
    SplashViewModel mSplashViewModel;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);
        mSplashViewModel.startSeeding();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public SplashViewModel getViewModel() {
        return mSplashViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

}
