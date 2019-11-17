package com.prads.kadesubmission

import androidx.lifecycle.MutableLiveData
import com.prads.kadesubmission.data.LeagueDummy
import com.prads.kadesubmission.utils.DummyData
import javax.inject.Inject

class LeagueRepository @Inject constructor(
    var dataDummyData: DummyData
){
    fun getAllMovies():MutableLiveData<List<LeagueDummy>>{
        val liveDataLeagues = MutableLiveData<List<LeagueDummy>>()
        liveDataLeagues.value = dataDummyData.getLeagues()
        return liveDataLeagues
    }
}