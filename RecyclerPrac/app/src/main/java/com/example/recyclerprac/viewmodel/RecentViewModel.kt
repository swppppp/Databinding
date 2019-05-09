package com.example.recyclerprac.viewmodel

import android.arch.lifecycle.ViewModel
import android.content.Context
import com.example.recyclerprac.model.Recent
import com.example.recyclerprac.model.RecentData
import com.example.recyclerprac.repo.RecentRepository
import com.example.recyclerprac.repo.RecentRepositoryImpl

// 데이터를 get하는 역할만 해 줌
class RecentViewModel(private val mContext: Context, private val recentRepositoryImpl: RecentRepositoryImpl) : ViewModel() {
    var items:RecentData = recentRepositoryImpl.getRecentData(mContext)
    fun getRecentData() : RecentData {
        //val items: RecentData = recentRepository.getRecentData(mContext)
        return items
    }
}