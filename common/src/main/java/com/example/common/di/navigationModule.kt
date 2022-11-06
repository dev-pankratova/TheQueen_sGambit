package com.example.common.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val APP_NAVIGATION = "app_navigation"
const val APP_ROUTER = "app_router"
const val APP_HOLDER = "app_holder"

val navigationModule = module {

    single(named(APP_NAVIGATION)) { Cicerone.create(Router()) }
    single(named(APP_ROUTER)) { get<Cicerone<Router>>(named(APP_NAVIGATION)).router }
    single(named(APP_HOLDER)) { get<Cicerone<Router>>(named(APP_NAVIGATION)).getNavigatorHolder() }
}