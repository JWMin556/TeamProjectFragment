package com.example.teamprojectfragment

data class MyUser(
    var email : String,
    var myPoint: Int,
    var uId: String
){
    constructor(): this("", 0, "")
}
