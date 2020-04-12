package com.mindorks.bootcamp.learndagger.ui.fragments

import androidx.lifecycle.MutableLiveData
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.ui.base.BaseViewModel
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeViewModel ( compositeDisposable: CompositeDisposable,
        var databaseService: DatabaseService ,
                     var networkService: NetworkService ,
                     networkHelper: NetworkHelper) :BaseViewModel( compositeDisposable ,networkHelper

){
    val data  = MutableLiveData<String>()
    override fun onCreate() {
        data.postValue("HomeViewModel")
    }
}