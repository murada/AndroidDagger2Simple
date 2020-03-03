package com.mindorks.bootcamp.learndagger.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mindorks.bootcamp.learndagger.MyApplication
import com.mindorks.bootcamp.learndagger.R
import com.mindorks.bootcamp.learndagger.di.components.DaggerFragmentComponent
import com.mindorks.bootcamp.learndagger.di.modules.FragmentModule
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DaggerFragmentComponent.builder().fragmentModule(FragmentModule(this)).applicationCompenent((activity?.application as MyApplication).compenent).
                build().inject(this)
        return inflater.inflate(R.layout.home_fragment, container, false)
    }
}