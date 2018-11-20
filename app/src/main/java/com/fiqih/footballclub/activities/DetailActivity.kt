package com.fiqih.footballclub.activities

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.fiqih.footballclub.MainActivity
import com.fiqih.footballclub.models.DataClub
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val item = intent.getParcelableExtra<DataClub>(MainActivity.PARCELABLE_ITEM_DATA)
        DetailActivityUI(item).setContentView(this)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == android.R.id.home) {
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    inner class DetailActivityUI(val item: DataClub) : AnkoComponent<DetailActivity> {
        val id_view = 1
        val id_img = 2
        val id_nama = 3

        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            relativeLayout {
                lparams(wrapContent, wrapContent)

                imageView {
                    id = id_img
                    Glide.with(this)
                        .load(item.img)
                        .into(this)
                }.lparams(dip(100), dip(100)) {
                    centerHorizontally()
                    topMargin = dip(100)
                }

                textView {
                    id = id_nama
                    text = item.nama
                    textSize = 24f
                    setTypeface(null, Typeface.BOLD)
                }.lparams {
                    below(id_img)
                    centerHorizontally()
                    margin = dip(10)
                }

                textView {
                    padding = dip(16)
                    text = item.deskripsi
                }.lparams {
                    below(id_nama)
                }
            }
        }
    }
}