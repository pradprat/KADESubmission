package com.prads.kadesubmission

import androidx.lifecycle.MutableLiveData
import com.prads.kadesubmission.data.League
import com.prads.kadesubmission.utils.DummyData
import javax.inject.Inject

class LeagueRepository @Inject constructor(
    var dataDummyData: DummyData
){
    fun getAllMovies():MutableLiveData<List<League>>{
        val liveDataLeagues = MutableLiveData<List<League>>()
        liveDataLeagues.value = dataDummyData.getLeagues()
        return liveDataLeagues
    }
}