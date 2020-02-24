package com.mindorks.bootcamp.learndagger;

import android.app.Application;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.components.ApplicationCompenent;
import com.mindorks.bootcamp.learndagger.di.components.DaggerApplicationCompenent;
import com.mindorks.bootcamp.learndagger.di.modules.ApplicationModule;

import javax.inject.Inject;

public class MyApplication extends Application {

    @Inject
    public NetworkService networkService;
    @Inject
    public DatabaseService databaseService;
    public ApplicationCompenent compenent;

    @Override
    public void onCreate() {
        super.onCreate();
        compenent = DaggerApplicationCompenent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        compenent.inject(this);
    }
}