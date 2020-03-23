package com.example.ebook.ui.aboutme;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



public class AboutmeViewModel extends ViewModel {


    private MutableLiveData<String> mText;

    public AboutmeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is about me fragment");


    }

    public LiveData<String> getText() {
        return mText;

    }


}
