package com.mayank.news_app.ui.bbc;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
//Not in Built--> Written by Mayank Agrawal
// No need of this class (View Model are not Required)

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is BBC fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}