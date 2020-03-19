package com.mindorks.bootcamp.learndagger.di.components;

import com.mindorks.bootcamp.learndagger.di.modules.HomeModule;
import com.mindorks.bootcamp.learndagger.di.scope.FragmentScope;
import com.mindorks.bootcamp.learndagger.ui.fragments.HomeFragment;

import dagger.Component;

@FragmentScope
@Component(dependencies = ApplicationCompenent.class,modules = HomeModule.class)
public interface HomeComponent {

    void inject(HomeFragment  fragment);

}
