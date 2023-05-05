package com.tankarsolutions.finddotsbraintraininggame.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.tankarsolutions.finddotsbraintraininggame.R
import kotlinx.android.synthetic.main.grid_item.view.*


class DotAdapter(private val onDotClick: OnDotClick) :
    RecyclerView.Adapter<DotAdapter.MyDotAdapterHolder>() {

    var dotList = ArrayList<Int>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var gameStarts = false


    interface OnDotClick {
        fun onclick(isRight: Boolean, totalPressAllowed: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDotAdapterHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false)
        return MyDotAdapterHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return (dotList.size * 5)
    }


    override fun onBindViewHolder(holder: MyDotAdapterHolder, position: Int) {

        if (dotList.contains(position)) {
            holder.dotImage.setBackgroundResource(R.drawable.easy_card_dot)
        } else {
            holder.dotImage.setBackgroundResource(R.drawable.ic_dot)
        }

        if (gameStarts) {
            holder.dotImage.visibility = View.GONE
            holder.itemView.setOnClickListener {
                holder.dotImage.visibility = View.VISIBLE
                if (dotList.contains(position)) {
                    onDotClick.onclick(true, dotList.size)
                } else {
                    onDotClick.onclick(false, dotList.size)

                }
            }
        } else {
            holder.itemView.setOnClickListener(null)
            holder.dotImage.visibility = View.VISIBLE
        }

    }


    class MyDotAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dotImage: AppCompatImageView = itemView.imageview
    }

}