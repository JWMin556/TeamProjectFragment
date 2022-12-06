package com.example.teamprojectfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teamprojectfragment.databinding.FragmentRankingBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.ArrayList

class RankingFragment : Fragment() {
    private lateinit var auth : FirebaseAuth  //전역으로 사용할 FirebaseAuth를 만들었습니다.
    private lateinit var mDbRef: DatabaseReference
    lateinit var adapter: UserAdapter
    private lateinit var userList: ArrayList<MyUser>

    var binding: FragmentRankingBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRankingBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()   //auth로 파이어베이스에 접근합니다.
        mDbRef = Firebase.database.reference   //데이터베이스 초기화
        userList = ArrayList()
        adapter = UserAdapter(requireContext(), userList)  //adapter는 사람 한명한명을 보관하는 장소

        binding?.userRecyclerView?.layoutManager = LinearLayoutManager(requireContext())
        binding?.userRecyclerView?.adapter = adapter

        //사용자정보 가져옴.... 점수별로 내림차순으로 정리했습니다.
        mDbRef.child("myUser").orderByChild("myPoint").addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for(postSnapshot in snapshot.children){
                    //유저정보
                    val currentUser = postSnapshot.getValue(MyUser::class.java)
                    userList.add(currentUser!!)
                }
                Collections.reverse(userList)  //내림차순으로 된 리스트를 다시 오름차순으로 바꿉니다.
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        binding?.btnBackToStart?.setOnClickListener {
            findNavController().navigate(R.id.action_rankingFragment_to_startFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}