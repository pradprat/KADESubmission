package com.prads.kadesubmission.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.subm1jetpackmovieskuy.data.source.ApiService
import com.prads.kadesubmission.data.LeagueDummy
import com.prads.kadesubmission.utils.DummyData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LeagueRepository @Inject constructor(
    var dataDummyData: DummyData,
    var service: ApiService
){
    fun getAllLeagues():MutableLiveData<List<LeagueDummy>>{
        val liveDataLeagues = MutableLiveData<List<LeagueDummy>>()
        liveDataLeagues.value = dataDummyData.getLeagues()
        return liveDataLeagues
    }

    fun getLeague(id:String):MutableLiveData<League>{
        var league = MutableLiveData<League>()
        service.getLeagueById(id).enqueue(object : Callback<LeagueResponse>{
            override fun onFailure(call: Call<LeagueResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<LeagueResponse>, response: Response<LeagueResponse>) {
                if (response.isSuccessful){
                    if (response.body()!==null){
                        league.postValue(response.body()!!.leagues.get(0))
                    }
                }
            }
        })
        return league
    }
}