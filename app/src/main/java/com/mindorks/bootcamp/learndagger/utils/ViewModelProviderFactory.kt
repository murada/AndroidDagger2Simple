package com.mindorks.bootcamp.learndagger.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
import kotlin.reflect.KClass

class ViewModelProviderFactory<T : ViewModel>(
        private val kClass: KClass<T>,
        private val creator: () -> T
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(kClass.java)) return creator() as T
        throw  IllegalArgumentException("Unknown class name")
    }
}