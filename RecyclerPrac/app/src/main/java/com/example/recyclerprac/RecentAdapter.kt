package com.example.recyclerprac

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerprac.databinding.ItemListBinding
import com.example.recyclerprac.model.Recent
import java.util.*
import kotlin.collections.ArrayList


class RecentAdapter(var items:ArrayList<Recent>, var context:Context)
    : RecyclerView.Adapter<RecentAdapter.ViewHolder>(), ItemTouchHelperAdapter {

    //lateinit var binding: ItemListBinding

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemListBinding = ItemListBinding.bind(itemView)

        fun onBindViewHolder(item: Recent){
//            binding.tvName.text = item.name
//            binding.tvInacct.text = item.inAcct
//            binding.tvOutacct.text = item.outAcct
            // 여기서 text를 set하는게 아녀!!
            binding.data=item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBindViewHolder(items[position])
    }


    /*----------------------------------------*/
    // 스와이프로 삭제, 롱프레스드래그로 순서바꾸기
    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        Collections.swap(items, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }


}