package com.baseapp.molina.ale.baseapp.ui.feed.opensource;

import android.databinding.ObservableField;

/**
 * Created by Amolina on 02/02/17.
 */

public class OpenSourceItemViewModel {

    public ObservableField<String> imageUrl = new ObservableField<>();
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> content = new ObservableField<>();
    public ObservableField<String> projectUrl = new ObservableField<>();

    public OpenSourceItemViewModel(String imageUrl, String title, String content, String projectUrl) {
        this.imageUrl.set(imageUrl);
        this.title.set(title);
        this.content.set(content);
        this.projectUrl.set(projectUrl);
    }

}
