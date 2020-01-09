package com.prads.kadesubmission.data

import androidx.lifecycle.MutableLiveData
import com.example.subm1jetpackmovieskuy.data.source.ApiService
import com.prads.kadesubmission.data.model.Classement
import com.prads.kadesubmission.data.model.ClassementResponse
import com.prads.kadesubmission.data.model.League
import com.prads.kadesubmission.data.model.LeagueLocal
import com.prads.kadesubmission.data.source.remote.responses.LeagueResponse
import com.prads.kadesubmission.utils.DummyData
import com.prads.kadesubmission.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LeagueRepository @Inject constructor(
    var dataDummyData: DummyData,
    var service: ApiService
){
    fun getAllLeagues(): MutableLiveData<List<LeagueLocal>> {
        val liveDataLeagues = MutableLiveData<List<LeagueLocal>>()
        liveDataLeagues.value = dataDummyData.getLeagues()
        return liveDataLeagues
    }

    fun getLeague(id:String):MutableLiveData<League>{
        EspressoIdlingResource.increment()
        var league = MutableLiveData<League>()
        service.getLeagueById(id).enqueue(object : Callback<LeagueResponse>{
            override fun onFailure(call: Call<LeagueResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<LeagueResponse>, response: Response<LeagueResponse>) {
                if (response.isSuccessful){
                    if (response.body()!==null){
                        league.postValue(response.body()!!.leagues.get(0))
                        EspressoIdlingResource.decrement()
                    }
                }
            }
        })
        return league
    }

    fun getClassement(leagueId: String): MutableLiveData<List<Classement>> {
        EspressoIdlingResource.increment()
        var classementLiveData = MutableLiveData<List<Classement>>()
        service.getClassement(leagueId).enqueue(object : Callback<ClassementResponse> {
            override fun onFailure(call: Call<ClassementResponse>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<ClassementResponse>,
                response: Response<ClassementResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body() !== null) {
                        classementLiveData.postValue(response.body()!!.table)
                        EspressoIdlingResource.decrement()
                    }
                }
            }
        })
        return classementLiveData
    }
}