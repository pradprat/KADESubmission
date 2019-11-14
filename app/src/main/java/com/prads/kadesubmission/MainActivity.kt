package com.prads.kadesubmission

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var leagueViewModel:LeagueViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        leagueViewModel = ViewModelProviders.of(this,viewModelFactory).get(LeagueViewModel::class.java)

        Log.d("---",leagueViewModel.loadLeagues()?.size.toString())

        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout{
                padding = dip(16)

                val name = editText {
                    hint = "What's your name?"
                }

                button("Say Hello"){
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE


                    setOnClickListener { toast("Hello, ${name.text}!") }

                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }
            }
        }
    }
}
