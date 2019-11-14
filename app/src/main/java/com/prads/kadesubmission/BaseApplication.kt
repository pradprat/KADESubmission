package com.prads.kadesubmission

import android.annotation.SuppressLint
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

@SuppressLint("Registered")
class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerAppComponent.builder().application(this).build()
    }
}