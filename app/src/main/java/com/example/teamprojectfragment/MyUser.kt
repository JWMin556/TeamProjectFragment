package com.example.teamprojectfragment

import android.net.Uri

data class MyUser(  //realtimedatabase에 저장시, 사용할 변수들입니다.
    var email : String,
    var myPoint: Int,
    var uId: String,
){
    constructor(): this("", 0, "")  //초기화상태입니다.
}
