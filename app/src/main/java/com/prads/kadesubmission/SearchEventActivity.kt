package com.prads.kadesubmission

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prads.kadesubmission.data.Event
import com.prads.kadesubmission.ui.*
import com.prads.kadesubmission.ui.layout.SearchEventActivityUI
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast
import javax.inject.Inject

class SearchEventActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var eventViewModel: EventViewModel

    lateinit var rvListEvent: RecyclerView

    lateinit var eventAdapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SearchEventActivityUI().setContentView(this)

        supportActionBar?.title = ""

        val query = intent.getStringExtra("TAG_LEAGUE_SEARCH")

        eventAdapter = EventAdapter {
            Intent(applicationContext, EventDetailActivity::class.java).run {
                this.putExtra("TAG_EVENT", it)
                Log.d("---Team", it.toString())
                toast("kamu memilih " + it.strEvent)
                startActivity(this)
            }
        }

        eventViewModel = ViewModelProviders.of(this,viewModelFactory).get(EventViewModel::class.java)

        eventViewModel.searchEvents(query).observe(this, Observer {
            Log.d("---GG",it.last().idHomeTeam)
            eventAdapter.addData(it)
        })

        rvListEvent = findViewById(R.id.rv_list_search_events)

        rvListEvent.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = eventAdapter
//            info("recyclerview created")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.league_detail_menu, menu)

        var query = intent.getStringExtra("TAG_LEAGUE_SEARCH")

        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchItem = menu?.findItem(R.id.league_detail_search)
        val searchView = searchItem?.actionView as androidx.appcompat.widget.SearchView

        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))

        searchItem.expandActionView()
        searchView.setQuery(query,false)
        searchView.clearFocus()

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                searchView.clearFocus()
                Toast.makeText(applicationContext,query,Toast.LENGTH_SHORT).show()

                Intent(applicationContext,SearchEventActivity::class.java).run {
                    putExtra("TAG_LEAGUE_SEARCH",query)
                    startActivity(this)
                }

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
        return true
    }
}