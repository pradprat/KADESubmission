package com.prads.kadesubmission.data.source.local

data class EventFavorite(val id: Long?,val idEvent: String?){

    companion object {
        const val TABLE: String = "TABLE_EVENT_FAVORITE"
        const val ID: String = "ID_"
        const val EVENT_ID: String = "EVENT_ID"
    }
}