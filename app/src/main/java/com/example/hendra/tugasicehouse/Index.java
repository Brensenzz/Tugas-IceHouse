package com.example.hendra.tugasicehouse;

import android.app.Fragment;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.FacebookSdk;

/**
 * Created by Hendra on 4/15/2016.
 */
public class Index extends  FragmentActivity{

    public Index()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_form);
    }


}
