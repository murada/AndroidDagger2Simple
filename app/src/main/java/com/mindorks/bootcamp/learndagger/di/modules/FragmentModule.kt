package com.mindorks.bootcamp.learndagger.di.modules

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import com.mindorks.bootcamp.demo.di.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(var fragment: Fragment) {

    @ActivityContext
    @Provides
    fun provideContext(): Context? {
        return fragment.context
    }

}