package com.prads.kadesubmission.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prads.kadesubmission.R
import com.prads.kadesubmission.ui.layout.FavoriteEventActivityUI
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast
import javax.inject.Inject

class FavoriteEventActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var eventViewModel: EventViewModel

    lateinit var rvListEvent: RecyclerView

    lateinit var eventAdapter: EventAdapter

    var observer = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FavoriteEventActivityUI().setContentView(this)

        supportActionBar?.title = "Favorite Events"

        eventAdapter = EventAdapter {
            Intent(applicationContext, EventDetailActivity::class.java).run {
                this.putExtra("TAG_EVENT", it)
                Log.d("---Team", it.toString())
                toast("kamu memilih " + it.strEvent)
                startActivity(this)
            }
        }



        eventViewModel = ViewModelProviders.of(this,viewModelFactory).get(EventViewModel::class.java)



        rvListEvent = findViewById(R.id.rv_list_favorite_events)
        rvListEvent.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = eventAdapter
//            info("recyclerview created")
        }
    }

    override fun onResume() {
        super.onResume()
        eventViewModel.favoriteEvents(applicationContext).observe(this, Observer {
            Log.d("---GG",it.size.toString())
            eventAdapter.setData(it)
        })

        Log.d("---RESUME",eventAdapter.itemCount.toString())
    }

}
