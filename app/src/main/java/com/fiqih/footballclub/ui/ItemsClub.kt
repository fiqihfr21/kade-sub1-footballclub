package com.fiqih.footballclub.ui

import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import com.fiqih.footballclub.dp
import org.jetbrains.anko.*


class ItemsClub : AnkoComponent<ViewGroup>{
    object club {
        val img_club = 1
        val nama_club = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>)= with(ui) {
        verticalLayout{
            lparams(matchParent, wrapContent){
                margin = dip(10)
            }
            orientation = LinearLayout.HORIZONTAL
            backgroundColor = Color.rgb(123, 229, 183)
            isBaselineAligned = true
            padding = dip(16)

            imageView {
                id = club.img_club
            }.lparams(width = 50.dp, height = 50.dp)

            textView {
                id = club.nama_club
            }.lparams(wrapContent, wrapContent) {
                gravity = Gravity.CENTER_VERTICAL
                margin = dip(10)
            }
        }
    }
}