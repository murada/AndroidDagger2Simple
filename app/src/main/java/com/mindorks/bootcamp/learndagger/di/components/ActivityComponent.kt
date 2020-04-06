package com.mindorks.bootcamp.learndagger.di.components

import com.mindorks.bootcamp.demo.di.ActivityScope
import com.mindorks.bootcamp.learndagger.di.modules.ActivityModule
import com.mindorks.bootcamp.learndagger.ui.MainActivity
import dagger.Component


@ActivityScope
@Component(dependencies = [ApplicationCompenent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity?)

}