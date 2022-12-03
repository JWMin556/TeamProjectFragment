package com.example.teamprojectfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.teamprojectfragment.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    private var restart : String? = null //LastResultFragment에서 재시작 신호를 받았을때
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
                putString("restart", restart)
            }
            findNavController().navigate(R.id.action_startFragment_to_menuFragment, bundle)
        }

        binding?.btnLogin?.setOnClickListener{  //로그인을 위한 entryFragment로 이동합니다.
            findNavController().navigate(R.id.action_startFragment_to_entryFragment)
        }

        binding?.btnLogout?.setOnClickListener {
            val bundle = Bundle().apply {
                val logout = "로그아웃"
                putString("logout", logout)
                putString("restart", restart)  //혹여나 문제있으면 삭제
            }
            findNavController().navigate(R.id.action_startFragment_to_entryFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}