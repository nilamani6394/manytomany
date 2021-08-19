package com.main.relationonetomany.model.request

data class ReqStudent(
    val name:String?="",
    val age:Int=0,
    val grade:String?="",
    val title:String="",
    val abbreviation:String?="",
    val fee:Double=0.0,
)
