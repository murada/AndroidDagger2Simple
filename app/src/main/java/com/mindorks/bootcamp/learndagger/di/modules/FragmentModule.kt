package com.mindorks.bootcamp.learndagger.di.modules

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(var fragment: Fragment) {

    @Provides
    fun provideContext(): Context? {
        return fragment.context
    }

}