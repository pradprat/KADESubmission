package com.prads.kadesubmission.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prads.kadesubmission.R
import com.prads.kadesubmission.ui.layout.EventDetailActivityUI
import org.jetbrains.anko.setContentView


class EventDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventDetailActivityUI().setContentView(this)
    }
}
