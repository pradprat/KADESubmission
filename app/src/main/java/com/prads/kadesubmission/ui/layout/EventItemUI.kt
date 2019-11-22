package com.prads.kadesubmission.ui.layout

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintSet
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.constraint.layout.constraintLayout

import org.jetbrains.anko.*

import com.prads.kadesubmission.R

/**
 * Generate with Plugin
 * @plugin Kotlin Anko Converter For Xml
 * @version 1.3.4
 */
class EventItemUI : AnkoComponent<ViewGroup>{

	override fun createView(ui: AnkoContext<ViewGroup>): View {
		return with(ui) {
			linearLayout {
				cardView {
					lparams(width = matchParent)
					id = R.id.item_event_card
					elevation = dip(4).toFloat()
					constraintLayout {
						padding = dip(16)
						textView {
							id = R.id.item_event_date
							text = "22 November 2019"
							textSize = sp(16f).toFloat() //sp
						}.lparams(width = matchParent) {
							endToEnd = ConstraintSet.PARENT_ID
							startToStart = ConstraintSet.PARENT_ID
							topToTop = ConstraintSet.PARENT_ID
						}
						textView {
							id = R.id.item_event_time
							text = "19:45:00"
							textSize = sp(16f).toFloat()
						}.lparams {
							endToEnd = ConstraintSet.PARENT_ID
							startToStart = ConstraintSet.PARENT_ID
							topToBottom = R.id.item_event_date
							topMargin = dip(8)
						}
						textView {
							id = R.id.event_divider
							text = ":"
							textSize = sp(30f).toFloat()
						}.lparams {
							bottomToBottom = ConstraintSet.PARENT_ID
							endToStart = R.id.item_event_logo_away
							startToEnd = R.id.item_event_logo_home
							topToBottom = R.id.item_event_time
						}
						textView {
							id = R.id.item_score_home
							text = "2"
							textSize = sp(30f).toFloat() //sp
						}.lparams {
							bottomToBottom = ConstraintSet.PARENT_ID
							endToStart = R.id.event_divider
							startToEnd = R.id.item_event_logo_home
							topToBottom = R.id.item_event_time
						}
						textView {
							id = R.id.item_score_away
							text = "1"
							textSize = sp(30f).toFloat() //sp
						}.lparams {
							bottomToBottom = ConstraintSet.PARENT_ID
							endToStart = R.id.item_event_logo_away
							startToEnd = R.id.event_divider
							topToBottom = R.id.item_event_time
						}
						imageView {
							id = R.id.item_event_logo_home
							scaleType = ImageView.ScaleType.FIT_CENTER
							imageResource = R.drawable.american_mayor_league
						}.lparams(width = dip(100), height = dip(100)) {
							startToStart = ConstraintSet.PARENT_ID
							topToBottom = R.id.item_event_time
						}
						textView {
							id = R.id.item_event_name_home
							text = "Paris SG"
							textAlignment = View.TEXT_ALIGNMENT_CENTER
						}.lparams(width = dip(100)) {
							endToEnd = R.id.item_event_logo_home
							startToStart = R.id.item_event_logo_home
							topToBottom = R.id.item_event_logo_home
						}
						imageView {
							id = R.id.item_event_logo_away
							scaleType = ImageView.ScaleType.FIT_CENTER
							imageResource = R.drawable.english_premier_league
						}.lparams(width = dip(100), height = dip(100)) {
							endToEnd = ConstraintSet.PARENT_ID
							topToBottom = R.id.item_event_time
						}
						textView {
							id = R.id.item_event_name_away
							text = "Lilla"
							textAlignment = View.TEXT_ALIGNMENT_CENTER
						}.lparams(width = dip(100)) {
							endToEnd = R.id.item_event_logo_away
							startToStart = R.id.item_event_logo_away
							topToBottom = R.id.item_event_logo_away
						}
					}
				}
			}
		}
	}
}
