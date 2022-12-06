package com.example.teamprojectfragment
<<<<<<< HEAD
// 맞힌 개수 틀린 개수 포인트 최종 결과

=======
//맞힌 개수 틀린 개수 포인트 최종 결과
>>>>>>> 2ae06a7c768fc5ebe16ba957fddf40f23ffb1ab4
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
    private var myTotalCorrect: String? = null

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
        val mypoint = myTotalCorrect?.toInt()?.times(10)
        viewModel.setPoint(mypoint!!)
        viewModel.point.observe(viewLifecycleOwner){
            binding?.txtRankpoint?.text = "${viewModel.point.value} p"
        }
        binding?.btnRestart?.setOnClickListener {
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