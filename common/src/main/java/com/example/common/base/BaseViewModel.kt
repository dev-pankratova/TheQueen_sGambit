package com.example.common.base

import androidx.lifecycle.ViewModel
import com.example.common.navigation.Screens
import com.example.common.di.APP_ROUTER
import com.github.terrakok.cicerone.Router
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named

abstract class BaseViewModel : ViewModel(), KoinComponent {

    val router: Router by inject(named(APP_ROUTER))

    val screens by inject<Screens>(named("screens"))

    fun close() {
        router.exit()
    }
}