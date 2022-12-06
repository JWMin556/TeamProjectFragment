package com.example.teamprojectfragment
//답 눌렀을 때 정답인지 오답인지 알려주는 것
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.teamprojectfragment.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var myAnswer: String? = null
    private var myquestion: String? = null
    private var myTotalProblemNum: String? = null
    private var myExample: String? = null
    private var myTotalCorrect: String? = null
    private var subject: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            myAnswer = it.getString("answer")//?:null
            myquestion = it.getString("question")//?:null
            myTotalProblemNum = it.getString("totalProblemNum")//?:null
            myExample = it.getString("example")//?:null
            myTotalCorrect = it.getString("totalCorrect")
            subject = it.getString("mySubject")
        }
    }
    var binding: FragmentResultBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val color = Color.rgb(231, 137, 137)

        if(myAnswer != null){  //answer만 넘어오면
            val str1 = "\"$myquestion\"은(는) "
            val str2 = "<$myAnswer>"
            val str3 = "입니다."
            val spannable = SpannableString("$str1$str2$str3")
            spannable.setSpan(ForegroundColorSpan(color), str1.length, str1.length + str2.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            binding?.correctTxt?.text = "정답!"
            binding?.explainTxt?.setText(spannable, TextView.BufferType.SPANNABLE)
            binding?.btnNext?.setOnClickListener {
                val goToNext = ""
                val bundle = Bundle().apply {
                    putString("goToNext", goToNext)
                    putString("subject", subject)
                }
                findNavController().navigate(R.id.action_resultFragment_to_questionFragment, bundle)
            }
        }

        if(myExample != null){  //즉, example이 같이 넘어오면 실행합니다.
            val str1 = "<$myExample> : 오답입니다.\n\n\"$myquestion\"은(는) "
            val str2 = "<$myAnswer>"
            val str3 = "입니다."
            val spannable = SpannableString("$str1$str2$str3")
            spannable.setSpan(ForegroundColorSpan(color), str1.length, str1.length + str2.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            binding?.correctTxt?.setBackgroundColor(Color.rgb(231, 137,137))  //이렇게 rgb를 이용해 background의 색을 바꿉니다
            binding?.correctTxt?.text = "오답!"
            binding?.explainTxt?.setText(spannable, TextView.BufferType.SPANNABLE)
            binding?.btnNext?.setOnClickListener {
                val goToNext = ""
                val bundle = Bundle().apply {
                    putString("goToNext", goToNext)
                    putString("subject", subject)
                }
                findNavController().navigate(R.id.action_resultFragment_to_questionFragment, bundle)
            }
        }

        if(myTotalProblemNum != null) {  //문제가 다 끝났을경우
            binding?.btnNext?.text = "최종 결과 확인"
            binding?.btnNext?.setOnClickListener {
                val bundle = Bundle().apply {
                    putString("myTotalCorrect", myTotalCorrect)
                }
                findNavController().navigate(R.id.action_resultFragment_to_lastResultFragment, bundle)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}