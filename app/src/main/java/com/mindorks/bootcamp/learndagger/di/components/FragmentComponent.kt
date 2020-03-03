package com.mindorks.bootcamp.learndagger.di.components

import androidx.fragment.app.Fragment
import com.mindorks.bootcamp.learndagger.di.modules.FragmentModule
import com.mindorks.bootcamp.learndagger.di.scope.ActivityScope
import com.mindorks.bootcamp.learndagger.di.scope.FragmentScope
import com.mindorks.bootcamp.learndagger.ui.fragments.HomeFragment
import dagger.Component
import javax.inject.Singleton

@FragmentScope
@Component(modules = [FragmentModule::class] , dependencies = [ApplicationCompenent::class])
interface FragmentComponent {
    fun inject(homeFragment: HomeFragment)
}