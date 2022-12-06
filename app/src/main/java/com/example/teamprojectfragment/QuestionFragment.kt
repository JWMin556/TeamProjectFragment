package com.example.teamprojectfragment

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.teamprojectfragment.databinding.FragmentQuestionBinding
import com.example.teamprojectfragment.viewmodel.ProblemsViewModel

var problemNumber = 1 //problemNUmber는 화면에 직접적으로 display이 되지 않지만, 다음 페이지로 넘어가기위한 페이지 역할을 수행합니다. 그렇기에 이 변수는 계속 숫자가 바뀌므로 var로 선언했습니다.
// ResultFragment에서 돌아왔을 때, problemNumber를 재초기화 해서는 안되므로, 이렇게 전역변수로 선언하여 QustionFragment가 최초로 실행될때만 초기화되도록 했습니다.
var totalCorrect = 0  //전체 맞은 개수를 세기위한 변수입니다. 이또한 마찬가지로 전역변수로 선언했습니다
class QuestionFragment : Fragment() {

    private var mySubject : String? = null  //과목을 위한 것입니다.
    private var myGoToNext : String? = null  //문제를 넘기기 위한 것입니다.
    private var restart : String? = null //LastResultFragment에서 재시작 신호를 받았을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mySubject = it.getString("subject")  //이렇게 번들에 있는 subject를 가져옴
            myGoToNext = it.getString("goToNext")
            restart = it.getString("restart")
        }
    }

    val viewModel: ProblemsViewModel by activityViewModels()  //viewModel에 있는 퀴즈문제들을 사용하기 위해서 입니다
    var binding: FragmentQuestionBinding? = null

    val timer = object: CountDownTimer(10000,1000){//시간제한을 위한 변수입니다.
        override fun onTick(millisUntilFinished: Long) {
        binding?.txtRemainTime?.setTextColor(Color.rgb(173, 199, 147))
        binding?.txtRemainTime?.text = "남은 시간 : ${millisUntilFinished/1000}초"

        if(+millisUntilFinished/1000 < 5)
            binding?.txtRemainTime?.setTextColor(Color.rgb(231, 137, 137))
        }

        override fun onFinish() {
            if(totalProblemNum == problemNumber){  //마지막 문제에서 시간초과가 난 경우, 바로 최종결과를 보여주는 프레그먼트로 이동해줄 수 있게 작업했습니다.
                val bundle = Bundle().apply {putString("myTotalCorrect", totalCorrect.toString())}
                findNavController().navigate(R.id.action_questionFragment_to_lastResultFragment, bundle)
            }
            else{
                problemNumber += 1  //즉, 페이지 수를 올려간다.
                showProblem(problemNumber, mySubject!!)
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionBinding.inflate(inflater)
        return binding?.root
    }

    val totalProblemNum = 20  //전체 문제수입니다.
    var question = ""
    var answer = ""
    var example1 = ""
    var example2 = ""
    var example3 = ""
    var example4 = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(restart == "restart") {
            problemNumber = 1  //LastResultFragment에서 재시작으로 넘어왔을 경우, problemNumber를 다시 1로 초기화 합니다.
            totalCorrect = 0  //마찬가지
        }

        if(mySubject == "국어"){
            if(myGoToNext == null)
                showProblem(problemNumber, mySubject!!)  //문제들을 display합니다..... 아무것도 번들에 받지 않은경우
            else{
                problemNumber += 1  //번들에 무언가가 있으면, 다음문제로 넘어간다는 의미...즉, 페이지 수를 올려간다.
                showProblem(problemNumber, mySubject!!)
            }
        }
        if(mySubject == "수학"){
            if(myGoToNext == null)
                showProblem(problemNumber, mySubject!!)  //문제들을 display합니다..... 아무것도 번들에 받지 않은경우
            else{
                problemNumber += 1  //즉, 페이지 수를 올려간다.
                showProblem(problemNumber, mySubject!!)
            }
        }
        if(mySubject == "수도"){
            if(myGoToNext == null)
                showProblem(problemNumber, mySubject!!)  //문제들을 display합니다..... 아무것도 번들에 받지 않은경우
            else{
                problemNumber += 1  //즉, 페이지 수를 올려간다.
                showProblem(problemNumber, mySubject!!)
            }
        }
        if(mySubject == "속담"){
            if(myGoToNext == null)
                showProblem(problemNumber, mySubject!!)  //문제들을 display합니다..... 아무것도 번들에 받지 않은경우
            else{
                problemNumber += 1  //즉, 페이지 수를 올려간다.
                showProblem(problemNumber, mySubject!!)
            }
        }
        if(mySubject == "역사"){
            if(myGoToNext == null)
                showProblem(problemNumber, mySubject!!)  //문제들을 display합니다..... 아무것도 번들에 받지 않은경우
            else{
                problemNumber += 1  //즉, 페이지 수를 올려간다.
                showProblem(problemNumber, mySubject!!)
            }
        }

        binding?.subjectTextView?.setText(mySubject)  //넘겨받은 과목이 무엇인지, 보여줍니다
        binding?.example1Button?.setOnClickListener {//각 버튼에 따라 selectExample함수를 실행합니다
            binding?.example1Button?.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example1, question)
            timer.cancel()  //유저가 답을 클릭하면, 타이머를 정지합니다.
        }
        binding?.example2Button?.setOnClickListener {
            binding?.example2Button?.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example2, question)
            timer.cancel()  //유저가 답을 클릭하면, 타이머를 정지합니다.
        }
        binding?.example3Button?.setOnClickListener {
            binding?.example3Button?.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example3, question)
            timer.cancel()  //유저가 답을 클릭하면, 타이머를 정지합니다.
        }
        binding?.example4Button?.setOnClickListener {
            binding?.example4Button?.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example4, question)
            timer.cancel()  //유저가 답을 클릭하면, 타이머를 정지합니다.
        }
    }

    fun showProblem(pn: Int, mySubject: String) { //problemNUmber도 파라미터로 받기(객체지향으로 만들기)
        binding?.NumberTextView?.setText("$problemNumber /20")
        timer.start()  //문제가 보여지는 즉시, 타이머를 시작합니다.

        if(mySubject == "국어"){//....국어문제용 showProblem
            viewModel.problemsOfLanguage.observe(viewLifecycleOwner){
                question = viewModel.problemsOfLanguage.value!![pn - 1]["question"].toString()  //즉, question to 머시기를 String으로 바꿔 question에 넣어줍니다.
                answer = viewModel.problemsOfLanguage.value!![pn - 1]["answer"].toString()
                example1 = viewModel.problemsOfLanguage.value!![pn - 1]["example1"].toString()
                example2 = viewModel.problemsOfLanguage.value!![pn - 1]["example2"].toString()
                example3 = viewModel.problemsOfLanguage.value!![pn - 1]["example3"].toString()
                example4 = viewModel.problemsOfLanguage.value!![pn - 1]["example4"].toString()

                binding?.questionTextView?.text = question  //위에서 만들어준 녀석들을 binding을 통해 화면에 뿌려줍니다.
                binding?.example1Button?.text = example1
                binding?.example2Button?.text = example2
                binding?.example3Button?.text = example3
                binding?.example4Button?.text = example4
            }
        }

        if(mySubject == "수학"){//....수학문제용 showProblem
            viewModel.problemsOfMath.observe(viewLifecycleOwner){
                question = viewModel.problemsOfMath.value!![pn - 1]["question"].toString()  //즉, question to 머시기를 String으로 바꿔 question에 넣어줍니다.
                answer = viewModel.problemsOfMath.value!![pn - 1]["answer"].toString()
                example1 = viewModel.problemsOfMath.value!![pn - 1]["example1"].toString()
                example2 = viewModel.problemsOfMath.value!![pn - 1]["example2"].toString()
                example3 = viewModel.problemsOfMath.value!![pn - 1]["example3"].toString()
                example4 = viewModel.problemsOfMath.value!![pn - 1]["example4"].toString()

                binding?.questionTextView?.text = question  //위에서 만들어준 녀석들을 binding을 통해 화면에 뿌려줍니다.
                binding?.example1Button?.text = example1
                binding?.example2Button?.text = example2
                binding?.example3Button?.text = example3
                binding?.example4Button?.text = example4
            }
        }

        if(mySubject == "수도"){//....수도문제용 showProblem
            viewModel.problemsOfCapital.observe(viewLifecycleOwner){
                question = viewModel.problemsOfCapital.value!![pn - 1]["question"].toString()  //즉, question to 머시기를 String으로 바꿔 question에 넣어줍니다.
                answer = viewModel.problemsOfCapital.value!![pn - 1]["answer"].toString()
                example1 = viewModel.problemsOfCapital.value!![pn - 1]["example1"].toString()
                example2 = viewModel.problemsOfCapital.value!![pn - 1]["example2"].toString()
                example3 = viewModel.problemsOfCapital.value!![pn - 1]["example3"].toString()
                example4 = viewModel.problemsOfCapital.value!![pn - 1]["example4"].toString()

                binding?.questionTextView?.text = question  //위에서 만들어준 녀석들을 binding을 통해 화면에 뿌려줍니다.
                binding?.example1Button?.text = example1
                binding?.example2Button?.text = example2
                binding?.example3Button?.text = example3
                binding?.example4Button?.text = example4
            }
        }

        if(mySubject == "속담"){//....속담문제용 showProblem
            viewModel.problemsOfProverb.observe(viewLifecycleOwner){
                question = viewModel.problemsOfProverb.value!![pn - 1]["question"].toString()  //즉, question to 머시기를 String으로 바꿔 question에 넣어줍니다.
                answer = viewModel.problemsOfProverb.value!![pn - 1]["answer"].toString()
                example1 = viewModel.problemsOfProverb.value!![pn - 1]["example1"].toString()
                example2 = viewModel.problemsOfProverb.value!![pn - 1]["example2"].toString()
                example3 = viewModel.problemsOfProverb.value!![pn - 1]["example3"].toString()
                example4 = viewModel.problemsOfProverb.value!![pn - 1]["example4"].toString()

                binding?.questionTextView?.text = question  //위에서 만들어준 녀석들을 binding을 통해 화면에 뿌려줍니다.
                binding?.example1Button?.text = example1
                binding?.example2Button?.text = example2
                binding?.example3Button?.text = example3
                binding?.example4Button?.text = example4
            }
        }

        if(mySubject == "역사"){//....역사문제용 showProblem
            viewModel.problemsOfHistory.observe(viewLifecycleOwner){
                question = viewModel.problemsOfHistory.value!![pn - 1]["question"].toString()  //즉, question to 머시기를 String으로 바꿔 question에 넣어줍니다.
                answer = viewModel.problemsOfHistory.value!![pn - 1]["answer"].toString()
                example1 = viewModel.problemsOfHistory.value!![pn - 1]["example1"].toString()
                example2 = viewModel.problemsOfHistory.value!![pn - 1]["example2"].toString()
                example3 = viewModel.problemsOfHistory.value!![pn - 1]["example3"].toString()
                example4 = viewModel.problemsOfHistory.value!![pn - 1]["example4"].toString()

                binding?.questionTextView?.text = question  //위에서 만들어준 녀석들을 binding을 통해 화면에 뿌려줍니다.
                binding?.example1Button?.text = example1
                binding?.example2Button?.text = example2
                binding?.example3Button?.text = example3
                binding?.example4Button?.text = example4
            }
        }
    }

    fun selectExample(example: String, question: String) {  //이 함수는 버튼을 클릭했을 때, 사용하는 함수입니다.
        val bundle = Bundle()
        if (answer == example) {  //즉, 사용자가 입력한 값이 정답일때
            totalCorrect += 1
            bundle.putString("answer", answer)
            bundle.putString("question", question)
            bundle.putString("mySubject", mySubject)
            if(totalProblemNum == problemNumber) {  //만약, 문제가 다 끝났으면
                bundle.putString("totalProblemNum", totalProblemNum.toString())
                bundle.putString("totalCorrect", totalCorrect.toString())
            }
            findNavController().navigate(R.id.action_questionFragment_to_resultFragment, bundle)
        } else {  //즉, 사용자가 입력한 값이 오답일때,
            bundle.putString("example", example)
            bundle.putString("answer", answer)
            bundle.putString("question", question)
            bundle.putString("mySubject", mySubject)
            if(totalProblemNum == problemNumber) {  //만약, 문제가 다 끝났으면
                bundle.putString("totalProblemNum", totalProblemNum.toString())
                bundle.putString("totalCorrect", totalCorrect.toString())
            }
            findNavController().navigate(R.id.action_questionFragment_to_resultFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}