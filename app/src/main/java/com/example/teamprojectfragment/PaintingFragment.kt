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
            Toast.makeText(context,"Clicked", Toast.LENGTH_SHORT).show()
            paintBrush.setColor(Color.RED)
            currentColor(paintBrush.color)
        }

        binding?.btnBlue?.setOnClickListener {
            Toast.makeText(context,"Clicked", Toast.LENGTH_SHORT).show()
            paintBrush.setColor(Color.BLUE)
            currentColor(paintBrush.color)
        }

        binding?.btnBlack?.setOnClickListener {
            Toast.makeText(context,"Clicked", Toast.LENGTH_SHORT).show()
            paintBrush.setColor(Color.BLACK)
            currentColor(paintBrush.color)
        }

        binding?.btnWhite?.setOnClickListener {
            Toast.makeText(context,"Clicked", Toast.LENGTH_SHORT).show()
            pathList.clear()
            colorList.clear()
            path.reset()
        }

        binding?.btnBackTo?.setOnClickListener {
            findNavController().navigate(R.id.action_paintingFragment_to_menuFragment)
        }
    }

    private fun currentColor(color: Int){
        currentBrush = color
        path = Path()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}