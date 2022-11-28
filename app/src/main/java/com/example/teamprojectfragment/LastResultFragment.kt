package com.example.teamprojectfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.teamprojectfragment.databinding.FragmentLastResultBinding

class LastResultFragment : Fragment() {
    private var myTotalCorrect: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            myTotalCorrect = it.getString("myTotalCorrect")
        }
    }
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
        binding?.txtPoint?.text = "${myTotalCorrect?.toInt()?.times(10)} p"
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