package com.baseapp.molina.ale.baseapp.data;

import com.baseapp.molina.ale.baseapp.data.local.db.DbHelper;
import com.baseapp.molina.ale.baseapp.data.local.prefs.PreferencesHelper;
import com.baseapp.molina.ale.baseapp.data.model.others.QuestionCardData;
import com.baseapp.molina.ale.baseapp.data.remote.ApiHelper;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Amolina on 02/02/17.
 */

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {

    void updateApiHeader(Long userId, String accessToken);

    void setUserAsLoggedOut();

    Observable<Boolean> seedDatabaseQuestions();

    Observable<Boolean> seedDatabaseOptions();

    Observable<List<QuestionCardData>> getQuestionCardData();

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
