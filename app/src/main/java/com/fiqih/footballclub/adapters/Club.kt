package com.fiqih.footballclub.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.fiqih.footballclub.models.DataClub
import com.fiqih.footballclub.ui.ItemsClub
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext


class ClubAdapter(val items: List<DataClub>, val listener: (DataClub) -> Unit) : RecyclerView.Adapter<ClubAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ItemsClub().createView(AnkoContext.create(parent.context, parent)))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        val img = itemView.findViewById<ImageView>(ItemsClub.club.img_club)
        val nama = itemView.findViewById<TextView>(ItemsClub.club.nama_club)

        fun bind(item: DataClub, listener: (DataClub) -> Unit) {
            Glide.with(itemView.context)
                .load(item.img)
                .into(img)

            nama.text = item.nama

            itemView.setOnClickListener { listener(item) }
        }
    }
}