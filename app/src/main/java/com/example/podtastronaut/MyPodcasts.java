package com.example.podtastronaut;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;

public class MyPodcasts extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_podcasts, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
