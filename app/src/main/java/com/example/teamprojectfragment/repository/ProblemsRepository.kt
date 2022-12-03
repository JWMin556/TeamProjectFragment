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
    val userRef = database.getReference("myUser")
    //val userRef = database.reference.child("myUser").child(auth.currentUser?.uid!!).child("myPoint")

    fun observeProblems(point: MutableLiveData<Int>){  //파이어베이스의 값을 가져오기
        userRef.child(auth.currentUser?.uid!!).child("myPoint").addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                point.postValue(snapshot.value.toString().toInt())
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    fun postPoint(newValue: Int){
        //userRef.setValue(newValue)
        userRef.child(auth.currentUser?.uid!!).child("myPoint").setValue(newValue)
    }
}