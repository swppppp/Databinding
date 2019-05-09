package com.example.recyclerprac

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

class RecentItemTouchHelperCallback() : ItemTouchHelper.Callback() {

    lateinit var mAdapter: ItemTouchHelperAdapter

    constructor(mAdapter: ItemTouchHelperAdapter) : this() {
        this.mAdapter = mAdapter
    }


    override fun getMovementFlags(rv: RecyclerView, vh: RecyclerView.ViewHolder): Int {
        val dragFlag:Int = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlag:Int = ItemTouchHelper.START or ItemTouchHelper.END
        return makeMovementFlags(dragFlag, swipeFlag)
    }

    /*
    순서 변경 및 swipe로 item삭제의 경우 adapter에서 callback 메소드를 통해 실행해야 --> listener 생성 필요
    */
    override fun onMove(rv: RecyclerView, vh: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        mAdapter.onItemMove(vh.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSwiped(vh: RecyclerView.ViewHolder, direction: Int) {
        mAdapter.onItemDismiss(vh.adapterPosition)
    }

    /// 이거도 쓴..?안써도 되넹

    override fun isLongPressDragEnabled(): Boolean {
        return false
    }
    /*
    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }
    --------------------------------------*/

}



