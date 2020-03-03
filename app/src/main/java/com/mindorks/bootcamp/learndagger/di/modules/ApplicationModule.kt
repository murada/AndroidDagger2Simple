package com.mindorks.bootcamp.learndagger.di.modules

import android.content.Context
import com.mindorks.bootcamp.learndagger.MyApplication
import com.mindorks.bootcamp.learndagger.di.qualifier.ApiKey
import com.mindorks.bootcamp.learndagger.di.qualifier.DatabaseName
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule (var myApplication: MyApplication){


    @Provides
    fun provideContext(): Context {
        return myApplication
    }

    @Provides
    @DatabaseName
    fun provideDatabaseName(): String {
        return "aaa"
    }

    @Provides
    fun provideDatabaseVersion(): Int {
        return 1
    }

    @Provides
    @ApiKey
    fun provideApiKey(): String {
        return "ssss"
    }
}