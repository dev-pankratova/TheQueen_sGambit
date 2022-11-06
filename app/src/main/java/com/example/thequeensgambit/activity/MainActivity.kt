package com.example.thequeensgambit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.common.di.APP_HOLDER
import com.example.thequeensgambit.R
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent
import org.koin.core.qualifier.named

class MainActivity : FragmentActivity(), KoinComponent {

    private val viewModel: MainViewModel by inject()

    private val navigator = AppNavigator(this, R.id.container_fragment)
    private val navigationHolder: NavigatorHolder by inject(named(APP_HOLDER))

    private val currentFragment
        get() = supportFragmentManager.findFragmentById(R.id.container_fragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.launchAuthScreen()

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigationHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        if (currentFragment != null) {
            if (currentFragment is com.example.common.base.BaseFragment) {
                (currentFragment as? com.example.common.base.BaseFragment)?.onBackPressed()
            } else {
                throw Exception("${currentFragment!!::class.java.canonicalName} is not child of BaseFragment")
            }
        }
    }
}