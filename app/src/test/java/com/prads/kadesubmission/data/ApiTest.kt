package com.prads.kadesubmission.data

import com.example.subm1jetpackmovieskuy.data.source.ApiMain
import com.example.subm1jetpackmovieskuy.data.source.ApiService
import com.prads.kadesubmission.utils.DummyData
import org.junit.Assert
import org.junit.Test

class ApiTest {
    var service: ApiService = ApiMain().services

    @Test
    fun getAllPastEvents() {
//        ambil data dari API getPastEvents dengan id league 4328
//        cek apakah jumlah data Event sesuai dengan yang diharapkan yaitu 15
//        cek apakah nama League pada data Event terakhir di list sesuai dengan league yang diminta yaitu English Premier League
        var events = service.getPastEvents("4328").execute().body()?.events
        Assert.assertEquals(15, events?.size)
        Assert.assertEquals("English Premier League", events?.last()?.strLeague)
    }

    @Test
    fun getAllNextEvents() {
//        ambil data dari API getNextEvents dengan id league 4334
//        cek apakah jumlah data Event sesuai dengan yang diharapkan yaitu 15
//        cek apakah nama League pada data Event terakhir di list sesuai dengan league yang diminta yaitu French Ligue 1
        var events = service.getNextEvents("4334").execute().body()?.events
        Assert.assertEquals(15, events?.size)
        Assert.assertEquals("French Ligue 1", events?.last()?.strLeague)
    }

    @Test
    fun getSearchEvents() {
//        ambil data dari API getSearchEvent dengan query Chelsea
//        cek apakah nama event pada index ke 0 mengandung string dari query
        var query = "Chelsea"
        var events = service.getSearchEvent(query).execute().body()?.event
        events?.get(0)?.strEvent?.contains(query)?.let { assert(it) }
    }

    @Test
    fun getAllLeagues() {
//        ambil semua data dari dummyData
//        cek apakah jumlah data sesuai dengan yang diharapkan yaitu 10
        var leagues = DummyData().getLeagues()
        Assert.assertEquals(10, leagues?.size)
    }

    @Test
    fun getLeague() {
//        ambil data dari API getLeagueById dengan id league 4334
//        cek apakah nama league dari data League yang didapatkan sesuai dengan yang diinginkan yaitu French Ligue 1
        var league = service.getLeagueById("4334").execute().body()?.leagues?.last()
        Assert.assertEquals("French Ligue 1", league?.strLeague)
    }

    @Test
    fun getTeam() {
//        ambil data Team dari API getTeamById dengan id league 133712
//        cek apakah nama league dari data team yang didapatkan sesuai dengan yang diinginkan yaitu French Ligue 1
//        cek apakah nama team dari data team yang didapatkan sesuai dengan yang diinginkan yaitu Nice

        var events = service.getTeamById("133712").execute().body()?.teams
        Assert.assertEquals("French Ligue 1", events?.last()?.strLeague)
        Assert.assertEquals("Nice", events?.last()?.strTeam)
    }
}