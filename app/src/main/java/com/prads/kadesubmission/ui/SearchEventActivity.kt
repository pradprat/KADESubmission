package com.prads.kadesubmission.ui

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.model.LeagueLocal
import com.prads.kadesubmission.ui.adapter.EventAdapter
import com.prads.kadesubmission.ui.layout.SearchEventActivityUI
import com.prads.kadesubmission.ui.viewmodel.EventViewModel
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast
import javax.inject.Inject

class SearchEventActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var eventViewModel: EventViewModel

    lateinit var rvListEvent: RecyclerView

    lateinit var eventAdapter: EventAdapter

    lateinit var league:LeagueLocal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SearchEventActivityUI().setContentView(this)

        supportActionBar?.title = ""

        val query = intent.getStringExtra("TAG_LEAGUE_SEARCH")
        val league = intent.getParcelableExtra<LeagueLocal>("TAG_LEAGUE_INFO")

        eventAdapter = EventAdapter {
            Intent(applicationContext, EventDetailActivity::class.java).run {
                this.putExtra("TAG_EVENT", it)
                Log.d("---Team", it.toString())
                toast("kamu memilih " + it.strEvent)
                startActivity(this)
            }
        }

        eventViewModel = ViewModelProviders.of(this,viewModelFactory).get(EventViewModel::class.java)

        eventViewModel.searchEvents(query,league.id).observe(this, Observer {
//            Log.d("---GG",it.last().idHomeTeam)
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

                Intent(applicationContext,
                    SearchEventActivity::class.java).run {
                    putExtra("TAG_LEAGUE_SEARCH",query)
                    putExtra("TAG_LEAGUE_INFO",league)
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
