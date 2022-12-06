package com.example.teamprojectfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.teamprojectfragment.databinding.FragmentLastResultBinding
import com.example.teamprojectfragment.viewmodel.ProblemsViewModel

class LastResultFragment : Fragment() {
    private var myTotalCorrect: String? = null  //번들에 있을, totalCorrect를 위한 변수입니다.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            myTotalCorrect = it.getString("myTotalCorrect")
        }
    }

    val viewModel: ProblemsViewModel by activityViewModels()
    var binding: FragmentLastResultBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLastResultBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.txtNumCorrect?.text = "${myTotalCorrect}개"
        binding?.txtNumIncorrect?.text = "${20 - (myTotalCorrect?.toInt() ?: 0)}개"
        val mypoint = myTotalCorrect?.toInt()?.times(10)  //맞은 개수에 10을 곱해줍니다.
        viewModel.setPoint(mypoint!!)  //viewModel에 있는 점수에 갱신해줍니다.
        viewModel.point.observe(viewLifecycleOwner){
            binding?.txtRankpoint?.text = "${viewModel.point.value} p"   //viewModel에 있을 갱신된 점수를 화면에 보여줍니다.
        }
        binding?.btnRestart?.setOnClickListener {  //재시작 버튼을 눌렀을 경우
            val restart = "restart"
            val bundle = Bundle().apply {
                putString("restart", restart)
            }
            findNavController().navigate(R.id.action_lastResultFragment_to_startFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}