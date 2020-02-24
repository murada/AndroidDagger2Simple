package com.mindorks.bootcamp.learndagger.di.modules;

import android.content.Context;

import com.mindorks.bootcamp.learndagger.MyApplication;
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.qualifier.ApiKey;
import com.mindorks.bootcamp.learndagger.di.qualifier.DatabaseName;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private MyApplication myApplication ;

    public ApplicationModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Provides
    public Context provideContext(){
        return myApplication;
    }

    @Provides
    @DatabaseName
    String provideDatabaseName(){
        return "aaa";
    }
    @Provides
    int provideDatabaseVersion(){
        return  1 ;
    }

    @Provides
    @ApiKey
    String provideApiKey(){
        return "ssss";
    }

/*    @Singleton
    @Provides
    public NetworkService provideNetworkService(){
        return new NetworkService(myApplication , "abc");
    }


    @Singleton
    @Provides
    public DatabaseService provideDatabaseService(){
        return new DatabaseService(myApplication , "zzz" , 1);
    }*/


}
