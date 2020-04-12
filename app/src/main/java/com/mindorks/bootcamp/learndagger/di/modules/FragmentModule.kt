package com.mindorks.bootcamp.learndagger.di.modules

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.mindorks.bootcamp.demo.di.ActivityContext
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.ui.MainViewModel
import com.mindorks.bootcamp.learndagger.ui.base.BaseFragment
import com.mindorks.bootcamp.learndagger.ui.fragments.HomeViewModel
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper
import com.mindorks.bootcamp.learndagger.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(var fragment: BaseFragment<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context? {
        return fragment.context
    }


    @Provides
    fun provideHomeViewModel(
            compositeDisposable: CompositeDisposable,
            networkHelper: NetworkHelper,
            databaseService: DatabaseService,
            networkService: NetworkService
    ): HomeViewModel = ViewModelProviders.of(fragment,
            ViewModelProviderFactory(HomeViewModel::class) {
                HomeViewModel(compositeDisposable, networkHelper = networkHelper, networkService = networkService, databaseService = databaseService)
            }).get(HomeViewModel::class.java)

}