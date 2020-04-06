package com.mindorks.bootcamp.learndagger.di.modules

import android.app.Activity
import android.content.Context
import com.mindorks.bootcamp.demo.di.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(var activity: Activity ) {

    @ActivityContext
    @Provides
    fun provideContext(): Context? {
        return activity
    }


}