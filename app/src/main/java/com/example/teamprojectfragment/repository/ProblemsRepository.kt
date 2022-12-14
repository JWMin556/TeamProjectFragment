package com.example.teamprojectfragment.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ProblemsRepository {
    val auth = FirebaseAuth.getInstance()
    val database = Firebase.database
    val userRef = database.getReference("myUser")  //realtime에 myUser라는 이름으로 파일을 만들어두었기에, 해당 파일을 찾아기도록 했습니다.

    var anw = 0  //누적시킨 myPoint를 위해서 만든 임시변수입니다.
    fun observeProblems(point: MutableLiveData<Int>){  //파이어베이스의 값을 가져오기
        userRef.child(auth.currentUser?.uid!!).child("myPoint").addValueEventListener(object: ValueEventListener{  //myUser의 현재 auth의 uid의 myPoint를 추적합니다.
            override fun onDataChange(snapshot: DataSnapshot) {
                point.postValue(snapshot.value.toString().toInt())
                anw = snapshot.value.toString().toInt()  //이렇게 anw에 현재, 파이어베이스에 있는 점수를 받아넣습니다.
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    fun postPoint(newValue: Int){
        userRef.child(auth.currentUser?.uid!!).child("myPoint").setValue(newValue + anw)  //anw에 있는 현재 내 점수에 새로운 퀴즈를 거치고 얻은 점수를 더합니다.
    }
}