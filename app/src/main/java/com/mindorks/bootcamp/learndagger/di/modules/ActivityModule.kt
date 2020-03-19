package com.mindorks.bootcamp.learndagger.di.modules

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(var activity: Activity ) {

    @Provides
    fun provideContext(): Context? {
        return activity
    }


}