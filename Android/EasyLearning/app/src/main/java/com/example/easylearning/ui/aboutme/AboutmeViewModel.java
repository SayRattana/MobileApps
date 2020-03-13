package com.example.easylearning.ui.aboutme;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.easylearning.IMyActivity.IMyActivity;

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
