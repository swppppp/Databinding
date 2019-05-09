package com.example.recyclerprac.repo

import android.content.Context
import com.example.recyclerprac.R
import com.example.recyclerprac.model.RecentData
import com.google.gson.Gson

interface RecentRepository {
    fun getRecentData(mContext: Context) : RecentData
}

class RecentRepositoryImpl() : RecentRepository {
    override fun getRecentData(mContext: Context): RecentData {
        val res = mContext.getResources()
        val `in` = res.openRawResource(R.raw.dummy_recent)
        val b = ByteArray(`in`.available())
        `in`.read(b)
        `in`.close()

        val data = Gson().fromJson<RecentData>(String(b), RecentData::class.java)
        return data
    }

}