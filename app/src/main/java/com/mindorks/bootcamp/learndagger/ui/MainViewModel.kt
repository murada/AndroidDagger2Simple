package com.mindorks.bootcamp.learndagger.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.local.entity.Address
import com.mindorks.bootcamp.learndagger.data.local.entity.User
import com.mindorks.bootcamp.learndagger.data.model.Dummy
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.data.remote.request.DummyRequest
import com.mindorks.bootcamp.learndagger.ui.base.BaseViewModel
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.disposables.ArrayCompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject


class MainViewModel(
        compositeDisposable: CompositeDisposable,
        private val databaseService: DatabaseService,
        private val networkService: NetworkService,
        networkHelper: NetworkHelper) : BaseViewModel(compositeDisposable, networkHelper) {


    val data  = MutableLiveData<String>()

    override fun onCreate() {
        data.postValue("MainViewModel")

        if(!checkInternetConnection()) messageString.postValue("No Internet Connection")

    }

    companion object {
        const val TAG = "MainViewModel"
    }

    val user = MutableLiveData<User>()

    val address = MutableLiveData<Address>()

    val users = MutableLiveData<List<User>>()

    val addresses = MutableLiveData<List<Address>>()

    var allUsers: List<User> = emptyList()

    var allAddresses: List<Address> = emptyList()


    val dummies = MutableLiveData<List<Dummy>>()


    fun getDummies() {
        compositeDisposable.add(
                networkService.doDummyCall(DummyRequest("123"))
                        .subscribeOn(Schedulers.io())
                        .subscribe(
                                {
                                    dummies.postValue(it.data)
                                },
                                {
                                    Log.d(TAG, it.toString())
                                }
                        )
        )
    }

    init {

        compositeDisposable.add(
                databaseService.userDao()
                        .count()
                        .flatMap {
                            if (it == 0)
                                databaseService.addressDao().insertMany(
                                        Address(city = "amman", code = 2, country = "jordan"),
                                        Address(city = "irbid", code = 2, country = "jordan"),
                                        Address(city = "home", code = 2, country = "jordan"),
                                        Address(city = "here", code = 2, country = "jordan"),
                                        Address(city = "there", code = 2, country = "jordan"),
                                        Address(city = "mars", code = 2, country = "jordan")
                                ).flatMap { addressessIds ->
                                    databaseService.userDao().insertMany(
                                            User(name = "Murad", dateOfBirth = Date(9596845779), addressId = addressessIds[0]),
                                            User(name = "Murad1", dateOfBirth = Date(9596845779), addressId = addressessIds[1]),
                                            User(name = "Murad2", dateOfBirth = Date(9596845779), addressId = addressessIds[2]),
                                            User(name = "Murad3", dateOfBirth = Date(9596845779), addressId = addressessIds[3]),
                                            User(name = "Murad4", dateOfBirth = Date(9596845779), addressId = addressessIds[4]),
                                            User(name = "Murad5", dateOfBirth = Date(9596845779), addressId = addressessIds[5])
                                    )
                                }
                            else
                                Single.just(0)
                        }
                        .subscribeOn(Schedulers.io())
                        .subscribe({
                            Log.d(TAG, "users exists in the table: $it")
                        }, {
                            Log.d(TAG, it.toString())
                        })
        )


    }

    fun getAllUsers() {
        compositeDisposable.add(
                databaseService.userDao().getAllUsers()
                        .subscribeOn(Schedulers.io())
                        .subscribe({
                            allUsers = it
                            users.postValue(it)
                        }, {
                            Log.d(TAG, it.toString())
                        })

        )
    }


    fun getAllAddresses() {
        compositeDisposable.add(
                databaseService.addressDao().getAllAddresses()
                        .subscribeOn(Schedulers.io())
                        .subscribe({
                            allAddresses = it
                            addresses.postValue(it)
                        }, {
                            Log.d(TAG, it.toString())
                        })

        )
    }

    fun deleteUser() {
        if (allUsers.isNotEmpty()) {
            compositeDisposable.addAll(
                    databaseService.userDao().delete(allUsers[0])
                            .flatMap {

                                databaseService.userDao().getAllUsers()
                            }
                            .subscribeOn(Schedulers.io())
                            .subscribe({
                                allUsers = it
                                users.postValue(it)
                            }, {
                                Log.d(TAG, it.toString())
                            })

            )
        }
    }

    fun deleteAddress() {
        if (allAddresses.isNotEmpty()) {
            compositeDisposable.addAll(
                    databaseService.addressDao().delete(allAddresses[0])
                            .flatMap {

                                databaseService.addressDao().getAllAddresses()
                            }
                            .subscribeOn(Schedulers.io())
                            .subscribe({
                                allAddresses = it
                                addresses.postValue(it)
                            }, {
                                Log.d(TAG, it.toString())
                            })

            )
        }
    }

    fun onDestroy() {
        compositeDisposable.dispose()
    }

}