package com.example.teamprojectfragment
//과목 선택
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.teamprojectfragment.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private var restart : String? = null //LastResultFragment에서 재시작 신호를 받았을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            restart = it.getString("restart")
        }
    }

    var binding: FragmentMenuBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnLanguage?.setOnClickListener {
            val subject = "국어"
            val bundle = Bundle().apply {  //이처럼 각 과목을 bundle에 넣어서 보내주기
                putString("subject", subject)
                putString("restart", restart)
            }
            findNavController().navigate(R.id.action_menuFragment_to_questionFragment, bundle)
        }

        binding?.btnMath?.setOnClickListener {
            val subject = "수학"
            val bundle = Bundle().apply {
                putString("subject", subject)
                putString("restart", restart)
            }
            findNavController().navigate(R.id.action_menuFragment_to_questionFragment, bundle)
        }

        binding?.btnCapital?.setOnClickListener {
            val subject = "수도"
            val bundle = Bundle().apply {
                putString("subject", subject)
                putString("restart", restart)
            }
            findNavController().navigate(R.id.action_menuFragment_to_questionFragment, bundle)
        }

        binding?.btnProverb?.setOnClickListener {
            val subject = "속담"
            val bundle = Bundle().apply {
                putString("subject", subject)
                putString("restart", restart)
            }
            findNavController().navigate(R.id.action_menuFragment_to_questionFragment, bundle)
        }

        binding?.btnHistory?.setOnClickListener {
            val subject = "역사"
            val bundle = Bundle().apply {
                putString("subject", subject)
                putString("restart", restart)
            }
            findNavController().navigate(R.id.action_menuFragment_to_questionFragment, bundle)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}