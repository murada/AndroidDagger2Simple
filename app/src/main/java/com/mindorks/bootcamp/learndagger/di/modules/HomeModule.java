package com.mindorks.bootcamp.learndagger.di.modules;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.mindorks.bootcamp.learndagger.utils.NetworkHelper;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    private Context context;

    public HomeModule(Context fragment){
        this.context = fragment ;
    }

    @Provides
    public Context provideContext(){
        return context;
    }


}
