package com.prads.kadesubmission.ui.layout

import android.view.View
import androidx.fragment.app.Fragment
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.textView

class TeamDetailFragmentUI : AnkoComponent<Fragment> {

    override fun createView(ui: AnkoContext<Fragment>): View {
        return with(ui) {
            coordinatorLayout {
                textView {
                    text = "aasdasd"
                }
            }
        }
    }
}