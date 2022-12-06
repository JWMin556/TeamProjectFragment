package com.example.teamprojectfragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.teamprojectfragment.databinding.FragmentStartBinding
import com.google.firebase.storage.FirebaseStorage
import java.util.*

class StartFragment : Fragment() {

    private var restart : String? = null //LastResultFragment에서 재시작 신호를 받았을때는 번들에서 값을 가져옵니다. 그렇지 않으면, 그냥, null로 냅둡니다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            restart = it.getString("restart")
        }
    }

    var binding: FragmentStartBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnStart?.setOnClickListener {
            val bundle = Bundle().apply {
                putString("restart", restart)  //재시작할 경우, bundle에 그 값을 넣어서 menuFragment에 보내줍니다.
            }
            findNavController().navigate(R.id.action_startFragment_to_menuFragment, bundle)
        }

        /* 이거 startFragment에서 로그인 할때 했던 코드인데, 저희는 맨 처음을 로그인화면으로 하였기에, 이 버튼은 해제하는게 좋다고 생각합니다.
        binding?.btnLogin?.setOnClickListener{  //로그인을 위한 entryFragment로 이동합니다.
            findNavController().navigate(R.id.action_startFragment_to_entryFragment)
        }
         */

        binding?.btnLogout?.setOnClickListener {  //로그아웃을 위해 다시 entryFragment로 이동합니다.
            val bundle = Bundle().apply {
                val logout = "로그아웃"
                putString("logout", logout)
                putString("restart", restart)  //혹여나 문제있으면 삭제
            }
            findNavController().navigate(R.id.action_startFragment_to_entryFragment, bundle)
        }

        binding?.btnRank?.setOnClickListener {  //해당 회원의 랭킹을 보여주기 위해, rankingFragment로 이동합니다.
            val bundle = Bundle().apply {
                putString("restart", restart)  //재시작할 경우, bundle에 그 값을 넣어서 menuFragment에 보내줍니다.
            }
            findNavController().navigate(R.id.action_startFragment_to_rankingFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}