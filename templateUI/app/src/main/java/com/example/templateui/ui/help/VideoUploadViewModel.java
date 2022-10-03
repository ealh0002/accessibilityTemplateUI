package com.example.templateui.ui.help;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VideoUploadViewModel extends ViewModel  {

    private final MutableLiveData<String> mText;

    public VideoUploadViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}
