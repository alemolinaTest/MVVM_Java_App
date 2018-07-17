package com.baseapp.molina.ale.baseapp.ui.login;


/**
 * Created by Amolina on 02/02/17.
 */

public interface LoginNavigator {

    void openMainActivity();

    void handleError(Throwable throwable);

    void login();

}
