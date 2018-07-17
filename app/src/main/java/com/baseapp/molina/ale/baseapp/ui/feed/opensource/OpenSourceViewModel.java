package com.baseapp.molina.ale.baseapp.ui.feed.opensource;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;

import com.baseapp.molina.ale.baseapp.data.DataManager;
import com.baseapp.molina.ale.baseapp.data.model.api.OpenSourceResponse;
import com.baseapp.molina.ale.baseapp.ui.base.BaseViewModel;
import com.baseapp.molina.ale.baseapp.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Amolina on 02/02/17.
 */

public class OpenSourceViewModel extends BaseViewModel<OpenSourceNavigator> {

    private final ObservableArrayList<OpenSourceItemViewModel> openSourceItemViewModels = new ObservableArrayList<>();
    private final MutableLiveData<List<OpenSourceItemViewModel>> openSourceItemsLiveData;


    public OpenSourceViewModel(DataManager dataManager,
                               SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        openSourceItemsLiveData = new MutableLiveData<>();
        fetchRepos();
    }

    public void fetchRepos() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getOpenSourceApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<OpenSourceResponse>() {
                    @Override
                    public void accept(@NonNull OpenSourceResponse openSourceResponse)
                            throws Exception {
                        if (openSourceResponse != null && openSourceResponse.getData() != null) {
                            openSourceItemsLiveData.setValue(getViewModelList(openSourceResponse.getData()));
                        }
                        setIsLoading(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        setIsLoading(false);
                        getNavigator().handleError(throwable);
                    }
                }));
    }


    public List<OpenSourceItemViewModel> getViewModelList(List<OpenSourceResponse.Repo> repoList) {
        ArrayList<OpenSourceItemViewModel> openSourceItemViewModels = new ArrayList<>();
        for (int i = 0; i < repoList.size(); i++) {
            openSourceItemViewModels.add(new OpenSourceItemViewModel(
                    repoList.get(i).getCoverImgUrl(), repoList.get(i).getTitle(),
                    repoList.get(i).getDescription(), repoList.get(i).getProjectUrl()));
        }
        return openSourceItemViewModels;
    }

    public MutableLiveData<List<OpenSourceItemViewModel>> getOpenSourceRepos() {
        return openSourceItemsLiveData;
    }

    public void addOpenSourceItemsToList(List<OpenSourceItemViewModel> openSourceItems) {
        openSourceItemViewModels.clear();
        openSourceItemViewModels.addAll(openSourceItems);
    }

    public ObservableArrayList<OpenSourceItemViewModel> getOpenSourceItemViewModels() {
        return openSourceItemViewModels;
    }
}
