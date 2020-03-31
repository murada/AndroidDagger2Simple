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


    var mViewModel: HomeViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        DaggerFragmentComponent.builder().fragmentModule(FragmentModule(this)).applicationCompenent((activity!!.application as MyApplication).compenent).build().inject(this)

        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    companion object {
        const val TAG = "homeFragment"
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}