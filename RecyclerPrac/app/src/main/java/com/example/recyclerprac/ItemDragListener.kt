package com.example.recyclerprac

import android.support.v7.widget.RecyclerView

interface ItemDragListener {
    fun onStartDrag(vh:RecyclerView.ViewHolder)
}