package com.example.teamprojectfragment
// Realtime DB에 어떤 걸 보관할지 data class로 저장
import android.net.Uri

data class MyUser(
    var email : String,
    var myPoint: Int,
    var uId: String,
){
    constructor(): this("", 0, "")
}
