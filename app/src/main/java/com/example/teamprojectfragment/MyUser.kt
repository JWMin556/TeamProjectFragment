package com.example.teamprojectfragment

import android.net.Uri

data class MyUser(
    var email : String,
    var myPoint: Int,
    var uId: String,
){
    constructor(): this("", 0, "")
}
