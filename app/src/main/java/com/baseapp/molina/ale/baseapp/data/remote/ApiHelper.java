package com.baseapp.molina.ale.baseapp.data.remote;

import com.baseapp.molina.ale.baseapp.data.model.api.BlogResponse;
import com.baseapp.molina.ale.baseapp.data.model.api.LoginRequest;
import com.baseapp.molina.ale.baseapp.data.model.api.LoginResponse;
import com.baseapp.molina.ale.baseapp.data.model.api.LogoutResponse;
import com.baseapp.molina.ale.baseapp.data.model.api.OpenSourceResponse;

import io.reactivex.Observable;

/**
 * Created by Amolina on 02/02/17.
 */

public interface ApiHelper {

    ApiHeader getApiHeader();

    Observable<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Observable<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Observable<LogoutResponse> doLogoutApiCall();

    Observable<BlogResponse> getBlogApiCall();

    Observable<OpenSourceResponse> getOpenSourceApiCall();
}
