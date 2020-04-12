package com.mindorks.bootcamp.learndagger.di.modules

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.mindorks.bootcamp.demo.di.ActivityContext
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.ui.MainViewModel
import com.mindorks.bootcamp.learndagger.ui.base.BaseActivity
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper
import com.mindorks.bootcamp.learndagger.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(var activity: BaseActivity<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context? {
        return activity
    }


    @Provides
    fun provideMainViewModel(
            compositeDisposable: CompositeDisposable,
            networkHelper: NetworkHelper,
            databaseService: DatabaseService,
            networkService: NetworkService
    ): MainViewModel = ViewModelProviders.of(activity,
            ViewModelProviderFactory(MainViewModel::class) {
                MainViewModel(compositeDisposable, networkHelper = networkHelper, networkService = networkService, databaseService = databaseService)
            }).get(MainViewModel::class.java)

}