package com.example.recyclerlugares_mbca

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import java.text.ParsePosition
//NO SIRVE
abstract class BaseVH<T>(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T,position: Int)
}