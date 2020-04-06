package com.mindorks.bootcamp.learndagger.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mindorks.bootcamp.learndagger.MyApplication
import com.mindorks.bootcamp.learndagger.R
import com.mindorks.bootcamp.learndagger.di.components.DaggerActivityComponent
import com.mindorks.bootcamp.learndagger.di.modules.ActivityModule
import com.mindorks.bootcamp.learndagger.ui.fragments.HomeFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerActivityComponent.builder().activityModule(ActivityModule(this)).applicationCompenent((application as MyApplication).compenent).build().inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val tvData = findViewById<TextView>(R.id.tvData)
        val tvData2 = findViewById<TextView>(R.id.tvData2)


        mainViewModel.dummies.observe(this, Observer {
            tvData.text = it.toString()
        })

        mainViewModel.getDummies()

      /*  mainViewModel.users.observe(this, Observer {
            tvData.text = it.toString()
        })
        mainViewModel.addresses.observe(this, Observer {
            tvData2.text = it.toString()
        })*/

        addHomeFragment();
    }

    fun addHomeFragment() {
        if(getSupportFragmentManager().findFragmentByTag(HomeFragment.TAG) == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_fragment, HomeFragment.newInstance(), HomeFragment.TAG)
                    .commit();
        }
    }

    override fun onStart() {
        super.onStart()
        mainViewModel.getAllAddresses()
        mainViewModel.getAllUsers()
    }

    override fun onStop() {
        super.onStop()
        mainViewModel.deleteAddress()
    }

    override fun onDestroy() {
        super.onDestroy()
        mainViewModel.onDestroy()
    }

}