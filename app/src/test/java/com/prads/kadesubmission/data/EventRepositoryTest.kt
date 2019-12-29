package com.prads.kadesubmission.data

import com.example.subm1jetpackmovieskuy.data.source.ApiMain
import com.example.subm1jetpackmovieskuy.data.source.ApiService
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class EventRepositoryTest {


    lateinit var eventRepository: EventRepository
    var service: ApiService = ApiMain().services

    @Before
    fun setUp() {
        eventRepository = EventRepository(service)
    }

    @Test
    fun getAllPastEvents() {
//        ambil data dari API getPastEvents dengan id league 4328
//        cek apakah jumlah data Event sesuai dengan yang diharapkan yaitu 15
//        cek apakah nama League pada data Event terakhir di list sesuai dengan league yang diminta yaitu English Premier League
        var events = service.getPastEvents("4328").execute().body()?.events
        assertEquals(15, events?.size)
        assertEquals("English Premier League", events?.last()?.strLeague)
    }

    @Test
    fun getAllNextEvents() {
//        ambil data dari API getNextEvents dengan id league 4334
//        cek apakah jumlah data Event sesuai dengan yang diharapkan yaitu 15
//        cek apakah nama League pada data Event terakhir di list sesuai dengan league yang diminta yaitu French Ligue 1
        var events = service.getNextEvents("4334").execute().body()?.events
        assertEquals(15, events?.size)
        assertEquals("French Ligue 1", events?.last()?.strLeague)
    }

    @Test
    fun getSearchEvents() {
//        ambil data dari API getSearchEvent dengan query Chelsea
//        cek apakah nama event pada index ke 0 mengandung string dari query
        var query = "Chelsea"
        var events = service.getSearchEvent(query).execute().body()?.event
        events?.get(0)?.strEvent?.contains(query)?.let { assert(it) }
    }
}