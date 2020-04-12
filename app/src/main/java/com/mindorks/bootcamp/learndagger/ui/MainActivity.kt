package com.mindorks.bootcamp.learndagger.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mindorks.bootcamp.learndagger.MyApplication
import com.mindorks.bootcamp.learndagger.R
import com.mindorks.bootcamp.learndagger.di.components.ActivityComponent
import com.mindorks.bootcamp.learndagger.di.components.DaggerActivityComponent
import com.mindorks.bootcamp.learndagger.di.modules.ActivityModule
import com.mindorks.bootcamp.learndagger.ui.base.BaseActivity
import com.mindorks.bootcamp.learndagger.ui.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {


/*
    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerActivityComponent.builder().activityModule(ActivityModule(this)).applicationCompenent((application as MyApplication).compenent).build().inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val tvData = findViewById<TextView>(R.id.tvData)
        val tvData2 = findViewById<TextView>(R.id.tvData2)


        viewModel.dummies.observe(this, Observer {
            tvData.text = it.toString()
        })

        viewModel.getDummies()

      */
/*  mainViewModel.users.observe(this, Observer {
            tvData.text = it.toString()
        })
        mainViewModel.addresses.observe(this, Observer {
            tvData2.text = it.toString()
        })*//*



    }
*/

    fun addHomeFragment() {
        if(getSupportFragmentManager().findFragmentByTag(HomeFragment.TAG) == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_fragment, HomeFragment.newInstance(), HomeFragment.TAG)
                    .commit();
        }
    }
/*

    override fun onStart() {
        super.onStart()
        viewModel.getAllAddresses()
        viewModel.getAllUsers()
    }

    override fun onStop() {
        super.onStop()
        viewModel.deleteAddress()
    }
*/

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }


    override fun setupObservers() {
        super.setupObservers()
        viewModel.data.observe(this, Observer {
            tvData.text = it
        })
    }

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun setupView(savedInstanceState: Bundle?) {
        addHomeFragment();
    }

    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

}