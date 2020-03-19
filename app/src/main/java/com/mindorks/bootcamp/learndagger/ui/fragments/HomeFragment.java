/*
package com.mindorks.bootcamp.learndagger.ui.fragments;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mindorks.bootcamp.learndagger.MyApplication;
import com.mindorks.bootcamp.learndagger.R;
import com.mindorks.bootcamp.learndagger.di.components.DaggerHomeComponent;
import com.mindorks.bootcamp.learndagger.di.modules.HomeModule;

import javax.inject.Inject;

public class HomeFragment extends Fragment {


    public static final String TAG = "homeFragment";
    @Inject
    public HomeViewModel mViewModel;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        DaggerHomeComponent.builder().homeModule(new HomeModule(getActivity())).applicationCompenent(((MyApplication)getActivity().getApplication()).compenent).build().inject(this);
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}
*/
