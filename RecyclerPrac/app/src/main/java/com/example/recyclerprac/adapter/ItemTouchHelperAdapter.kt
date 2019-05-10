package com.example.recyclerprac.adapter

// 리스너 같은건가..
interface ItemTouchHelperAdapter {
    fun onItemMove(fromPosition: Int, toPosition: Int)
    fun onItemDismiss(position: Int)
}