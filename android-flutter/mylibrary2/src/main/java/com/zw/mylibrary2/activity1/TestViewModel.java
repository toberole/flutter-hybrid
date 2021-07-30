package com.zw.mylibrary2.activity1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TestViewModel extends ViewModel {
    private MutableLiveData<String> currentName;
    private MutableLiveData<String> currentAddress;

    public MutableLiveData<String> getCurrentName() {
        if (currentName == null) {
            currentName = new MutableLiveData<String>();
        }
        return currentName;
    }

    public MutableLiveData<String> getCurrentAddress() {
        if (currentAddress == null) {
            currentAddress = new MutableLiveData<>();
        }

        return currentAddress;
    }

    public void getAddress() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                currentAddress.postValue("address " + System.currentTimeMillis());
            }
        }).start();
    }

    public void getName() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                currentName.postValue("name " + System.currentTimeMillis());
            }
        }).start();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
