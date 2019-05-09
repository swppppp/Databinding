package com.example.recyclerprac.model


data class Recent(
    val name: String,
    val inAcct: String,
    val outAcct: String,
    val outCd: String,
    val outNum: String,
    val amt: String,
    val favorite: String,
    val path: String
)

data class RecentData(val data: ArrayList<Recent>)