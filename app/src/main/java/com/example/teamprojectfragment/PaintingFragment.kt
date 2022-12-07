package com.example.teamprojectfragment

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.teamprojectfragment.PaintView.Companion.colorList
import com.example.teamprojectfragment.PaintView.Companion.currentBrush
import com.example.teamprojectfragment.PaintView.Companion.pathList
import com.example.teamprojectfragment.databinding.FragmentPaintingBinding

class PaintingFragment : Fragment() {
    var binding : FragmentPaintingBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaintingBinding.inflate(inflater)
        return binding?.root
    }

    companion object {
        var path = Path()
        var paintBrush = Paint()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnRed?.setOnClickListener {
            Toast.makeText(context,"빨간색을 선택했습니다", Toast.LENGTH_SHORT).show() // 약 3초간 메시지가 떠오름
            paintBrush.setColor(Color.RED)
            currentColor(paintBrush.color)
        }

        binding?.btnBlue?.setOnClickListener {
            Toast.makeText(context,"파란색을 선택했습니다", Toast.LENGTH_SHORT).show() // 약 3초간 메시지가 떠오름
            paintBrush.setColor(Color.BLUE)
            currentColor(paintBrush.color)
        }

        binding?.btnBlack?.setOnClickListener {
            Toast.makeText(context,"검은색을 선택했습니다", Toast.LENGTH_SHORT).show() // 약 3초간 메시지가 떠오름
            paintBrush.setColor(Color.BLACK)
            currentColor(paintBrush.color)
        }

        binding?.btnWhite?.setOnClickListener {
            Toast.makeText(context,"모두 지웁니다", Toast.LENGTH_SHORT).show() // 약 3초간 메시지가 떠오름
            pathList.clear()
            colorList.clear()
            path.reset()
        }

        binding?.btnBackTo?.setOnClickListener { // 뒤로 가기(페인팅에서 메뉴로 이동)
            findNavController().navigate(R.id.action_paintingFragment_to_menuFragment)
        }
    }

    private fun currentColor(color: Int){ // 현재 컬러
        currentBrush = color
        path = Path()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}