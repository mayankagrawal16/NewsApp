package com.mayank.news_app.ui.DainikBhaskarNews;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Dainik Bhaskar fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}