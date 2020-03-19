package com.mindorks.bootcamp.learndagger.ui.fragments

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper
import javax.inject.Inject

class HomeViewModel @Inject constructor(var databaseService: DatabaseService , var networkService: NetworkService , networkHelper: NetworkHelper) {
}