package com.example.teamprojectfragment
<<<<<<< HEAD
// Realtime DB에 어떤 걸 보관할지 data class로 저장
=======
//Realtime DB에 어떤 걸 보관할지 data class로 저장
>>>>>>> 2ae06a7c768fc5ebe16ba957fddf40f23ffb1ab4
import android.net.Uri

data class MyUser(
    var email : String,
    var myPoint: Int,
    var uId: String,
){
    constructor(): this("", 0, "")
}
