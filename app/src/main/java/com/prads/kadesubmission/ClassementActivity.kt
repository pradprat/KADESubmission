package com.prads.kadesubmission

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prads.kadesubmission.data.model.LeagueLocal
import com.prads.kadesubmission.ui.adapter.ClassementAdapter
import com.prads.kadesubmission.ui.layout.ClassementActivityUI
import com.prads.kadesubmission.ui.viewmodel.LeagueViewModel
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.setContentView
import javax.inject.Inject

class ClassementActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var leagueViewModel: LeagueViewModel
    lateinit var league: LeagueLocal
    lateinit var rvClassement: RecyclerView
    lateinit var classementAdapter: ClassementAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ClassementActivityUI().setContentView(this)

        league = intent.getParcelableExtra("TAG_CLASSEMENT")

        leagueViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(LeagueViewModel::class.java)


        classementAdapter = ClassementAdapter {
            //            Intent(this, ::class.java).run {
//                this.putExtra("TAG_LEAGUE", it)
//                toast("kamu memilih " + it.name)
//                startActivity(this)
//            }
        }

        leagueViewModel.loadClassement(league.id).observe(this, Observer {
            classementAdapter.addData(it)
        })

        rvClassement = findViewById(R.id.rv_list_classement)

        rvClassement.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = classementAdapter
//            info("recyclerview created")
        }


    }

}
