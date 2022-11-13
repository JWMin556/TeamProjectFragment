package com.example.teamprojectfragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.teamprojectfragment.databinding.FragmentQuestionBinding

var problemNumber = 1 //problemNUmber는 화면에 직접적으로 display이 되지 않지만, 다음 페이지로 넘어가기위한 페이지 역할을 수행합니다. 그렇기에 이 변수는 계속 숫자가 바뀌므로 var로 선언했습니다.
// ResultFragment에서 돌아왔을 때, problemNumber를 재초기화 해서는 안되므로, 이렇게 전역변수로 선언하여 QustionFragment가 최초로 실행될때만 초기화되도록 했습니다.
var totalCorrect = 0  //전체 맞은 개수를 세기위한 변수입니다. 이또한 마찬가지로 전역변수로 선언했습니다
class QuestionFragment : Fragment() {
    var problems = arrayOf(  //mapOf를 사용해서 문제를 추출합니다.... 배열의 형태로 만들어줬습니다. 물론, 현재는 무작위 추출이 아니고 이 배열의 순서대로 문제가 출력되는 형식으로 했습니다.
        mapOf("question" to "1 + 2 = ?",
            "answer" to "3",
            "example1" to "1",
            "example2" to "3",
            "example3" to "2",
            "example4" to "4"),
        mapOf("question" to "3 x 2 = ?",
            "answer" to "6",
            "example1" to "4",
            "example2" to "6",
            "example3" to "5",
            "example4" to "2"),
        mapOf("question" to "5 - 3 = ?",
            "answer" to "2",
            "example1" to "6",
            "example2" to "1",
            "example3" to "5",
            "example4" to "2"),
        mapOf("question" to "8 ÷ 4 = ?",
            "answer" to "2",
            "example1" to "1",
            "example2" to "2",
            "example3" to "4",
            "example4" to "3"),
        mapOf("question" to "4 + 2 = ?",
            "answer" to "6",
            "example1" to "6",
            "example2" to "4",
            "example3" to "2",
            "example4" to "5"),
        mapOf("question" to "5 - 4 = ?",
            "answer" to "1",
            "example1" to "3",
            "example2" to "6",
            "example3" to "7",
            "example4" to "1"),
        mapOf("question" to "4 x 3 = ?",
            "answer" to "12",
            "example1" to "7",
            "example2" to "12",
            "example3" to "8",
            "example4" to "3"),
        mapOf("question" to "9 ÷ 3 = ?",
            "answer" to "3",
            "example1" to "7",
            "example2" to "3",
            "example3" to "5",
            "example4" to "4"),
        mapOf("question" to "1 + 4 = ?",
            "answer" to "5",
            "example1" to "4",
            "example2" to "5",
            "example3" to "0",
            "example4" to "6"),
        mapOf("question" to "3 + 1 = ?",
            "answer" to "4",
            "example1" to "8",
            "example2" to "3",
            "example3" to "4",
            "example4" to "0"),
        mapOf("question" to "5 x 5 = ?",
            "answer" to "25",
            "example1" to "23",
            "example2" to "25",
            "example3" to "27",
            "example4" to "29"),
        mapOf("question" to "6 x 8 = ?",
            "answer" to "48",
            "example1" to "48",
            "example2" to "50",
            "example3" to "52",
            "example4" to "54"),
        mapOf("question" to "9 ÷ 3 = ?",
            "answer" to "3",
            "example1" to "1",
            "example2" to "2",
            "example3" to "3",
            "example4" to "4"),
        mapOf("question" to "8 ÷ 4 = ?",
            "answer" to "2",
            "example1" to "2",
            "example2" to "4",
            "example3" to "6",
            "example4" to "8"),
        mapOf("question" to "4 x 2 = ?",
            "answer" to "8",
            "example1" to "3",
            "example2" to "4",
            "example3" to "8",
            "example4" to "11"),
        mapOf("question" to "5 x 4 = ?",
            "answer" to "20",
            "example1" to "16",
            "example2" to "18",
            "example3" to "20",
            "example4" to "22"),
        mapOf("question" to "4 + 3 = ?",
            "answer" to "7",
            "example1" to "7",
            "example2" to "12",
            "example3" to "8",
            "example4" to "3"),
        mapOf("question" to "9 x 3 = ?",
            "answer" to "27",
            "example1" to "27",
            "example2" to "30",
            "example3" to "33",
            "example4" to "36"),
        mapOf("question" to "15 ÷ 3 = ?",
            "answer" to "5",
            "example1" to "4",
            "example2" to "5",
            "example3" to "0",
            "example4" to "6"),
        mapOf("question" to "9 x 7 = ?",
            "answer" to "63",
            "example1" to "61",
            "example2" to "63",
            "example3" to "65",
            "example4" to "67")
    )

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

    var binding: FragmentQuestionBinding? = null
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

        if(mySubject == "수학"){
            if(myGoToNext == null)
                showProblem(problemNumber)  //문제들을 display합니다..... 아무것도 번들에 받지 않은경우
            else{
                problemNumber += 1  //즉, 페이지 수를 올려간다.
                showProblem(problemNumber)
            }
        }

        binding?.subjectTextView?.setText(mySubject)  //넘겨받은 과목이 무엇인지, 보여줍니다

        binding?.example1Button?.setOnClickListener {//각 버튼에 따라 selectExample함수를 실행합니다
            binding?.example1Button?.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example1, question)
        }
        binding?.example2Button?.setOnClickListener {
            binding?.example2Button?.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example2, question)
        }
        binding?.example3Button?.setOnClickListener {
            binding?.example3Button?.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example3, question)
        }
        binding?.example4Button?.setOnClickListener {
            binding?.example4Button?.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example4, question)
        }
    }

    fun showProblem(pn: Int) { //problemNUmber도 파라미터로 받기(객체지향으로 만들기)....수학문제용 showProblem
        binding?.NumberTextView?.setText("$problemNumber 번 문제.")

        question = problems[pn - 1]["question"].toString()  //즉, question to 머시기를 String으로 바꿔 question에 넣어줍니다.
        answer = problems[pn - 1]["answer"].toString()
        example1 = problems[pn - 1]["example1"].toString()
        example2 = problems[pn - 1]["example2"].toString()
        example3 = problems[pn - 1]["example3"].toString()
        example4 = problems[pn - 1]["example4"].toString()

        binding?.questionTextView?.text = question  //위에서 만들어준 녀석들을 binding을 통해 화면에 뿌려줍니다.
        binding?.example1Button?.text = example1
        binding?.example2Button?.text = example2
        binding?.example3Button?.text = example3
        binding?.example4Button?.text = example4
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
        /*
        binding?.example1Button?.setEnabled(false)
        binding?.example2Button?.setEnabled(false)
        binding?.example3Button?.setEnabled(false)
        binding?.example4Button?.setEnabled(false)
        val h = Handler()
        h.postDelayed({
            binding?.example1Button?.setEnabled(true)
            binding?.example2Button?.setEnabled(true)
            binding?.example3Button?.setEnabled(true)
            binding?.example4Button?.setEnabled(true)

            if (problemNumber < problems.size) {
                binding?.example1Button?.setBackgroundColor(Color.rgb(255, 255, 255))
                binding?.example2Button?.setBackgroundColor(Color.rgb(255, 255, 255))
                binding?.example3Button?.setBackgroundColor(Color.rgb(255, 255, 255))
                binding?.example4Button?.setBackgroundColor(Color.rgb(255, 255, 255))
                //showProblem(problemNumber)
            }
            else {
                binding?.example1Button?.setBackgroundColor(Color.rgb(255, 255, 255))
                binding?.example2Button?.setBackgroundColor(Color.rgb(255, 255, 255))
                binding?.example3Button?.setBackgroundColor(Color.rgb(255, 255, 255))
                binding?.example4Button?.setBackgroundColor(Color.rgb(255, 255, 255))
                //showGameOverBox()
            }
        }, 1000)

         */
    }
    /*
    fun showGameOverBox() {
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("게임 종료")
            .setMessage("게임을 다시 하실래요?")
            .setNegativeButton("앱 종료") { dialog, id -> exitApp() }
            .setPositiveButton("다시 할래요") { dialog, id -> replay() }
            .setCancelable(false) //true by default
            .create()
        alertDialog.show()
    }

    fun exitApp() {
        System.exit(0)
    }


    fun replay() {
        findNavController().navigate(R.id.)
    }
     */

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}