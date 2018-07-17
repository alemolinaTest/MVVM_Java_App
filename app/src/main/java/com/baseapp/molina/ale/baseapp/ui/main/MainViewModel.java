
package com.baseapp.molina.ale.baseapp.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;

import com.baseapp.molina.ale.baseapp.data.DataManager;
import com.baseapp.molina.ale.baseapp.data.model.api.LogoutResponse;
import com.baseapp.molina.ale.baseapp.data.model.others.QuestionCardData;
import com.baseapp.molina.ale.baseapp.ui.base.BaseViewModel;
import com.baseapp.molina.ale.baseapp.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.functions.Consumer;


/**
 * Created by Amolina on 02/02/17.
 */


public class MainViewModel extends BaseViewModel<MainNavigator> {

    public static final int NO_ACTION = -1, ACTION_ADD_ALL = 0, ACTION_DELETE_SINGLE = 1;

    private final ObservableField<String> appVersion = new ObservableField<>();
    private final ObservableField<String> userName = new ObservableField<>();
    private final ObservableField<String> userEmail = new ObservableField<>();
    private final ObservableField<String> userProfilePicUrl = new ObservableField<>();
    private final ObservableArrayList<QuestionCardData> questionDataList = new ObservableArrayList<>();

    private final MutableLiveData<List<QuestionCardData>> questionCardData;

    private int action = NO_ACTION;

    public MainViewModel(DataManager dataManager,
                         SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        questionCardData = new MutableLiveData<>();
        loadQuestionCards();
    }

    public void updateAppVersion(String version) {
        appVersion.set(version);
    }

    public void onNavMenuCreated() {

        final String currentUserName = getDataManager().getCurrentUserName();
        if (currentUserName != null && !currentUserName.isEmpty()) {
            userName.set(currentUserName);
        }

        final String currentUserEmail = getDataManager().getCurrentUserEmail();
        if (currentUserEmail != null && !currentUserEmail.isEmpty()) {
            userEmail.set(currentUserEmail);
        }

        final String profilePicUrl = getDataManager().getCurrentUserProfilePicUrl();
        if (profilePicUrl != null && !profilePicUrl.isEmpty()) {
            userProfilePicUrl.set(profilePicUrl);
        }
    }

    public void loadQuestionCards() {
        getCompositeDisposable().add(getDataManager()
                .getQuestionCardData()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<QuestionCardData>>() {
                    @Override
                    public void accept(List<QuestionCardData> questionList) throws Exception {
                        if (questionList != null) {
                            action = ACTION_ADD_ALL;
                            questionCardData.setValue(questionList);
                        }
                    }
                }));
    }


    public void logout() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager().doLogoutApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LogoutResponse>() {
                    @Override
                    public void accept(LogoutResponse response) throws Exception {
                        getDataManager().setUserAsLoggedOut();
                        setIsLoading(false);
                        getNavigator().openLoginActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        setIsLoading(false);
                        getNavigator().handleError(throwable);
                    }
                }));
    }

    public void removeQuestionCard() {
        action = ACTION_DELETE_SINGLE;
        questionDataList.remove(0);
        questionCardData.getValue().remove(0);
    }

    public void setQuestionDataList(List<QuestionCardData> questionCardDatas) {
        action = ACTION_ADD_ALL;
        questionDataList.clear();
        questionDataList.addAll(questionCardDatas);
    }

    public MutableLiveData<List<QuestionCardData>> getQuestionCardData() {
        return questionCardData;
    }

    public ObservableField<String> getAppVersion() {
        return appVersion;
    }

    public ObservableField<String> getUserName() {
        return userName;
    }

    public ObservableField<String> getUserEmail() {
        return userEmail;
    }

    public ObservableField<String> getUserProfilePicUrl() {
        return userProfilePicUrl;
    }

    public ObservableArrayList<QuestionCardData> getQuestionDataList() {
        return questionDataList;
    }

    public int getAction() {
        return action;
    }
}
