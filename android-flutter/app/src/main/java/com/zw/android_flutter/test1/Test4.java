package com.zw.android_flutter.test1;

import android.content.Intent;
import android.os.Bundle;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test4 {
    public void test() {
        try {
            Intent i = new Intent();
            Bundle extras = new Bundle();
            extras.putString("Hello", "World");
            i.putExtras(extras);

            FileOutputStream fileOutputStream = null;
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 