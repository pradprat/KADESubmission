package com.prads.kadesubmission

import android.os.Bundle
import com.prads.kadesubmission.ui.layout.ClassementActivityUI
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.setContentView

class ClassementActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ClassementActivityUI().setContentView(this)
    }
}
