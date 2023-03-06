package com.example.nosmokeapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nosmokeapp.R
import com.example.nosmokeapp.databinding.FragmentProgressBinding


class ProgressFragment : Fragment() {
    private lateinit var binding:FragmentProgressBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var progress = 0
        binding = FragmentProgressBinding.inflate(inflater,container,false)

        binding.dayProgressBar.progress = progress


        binding.button2.setOnClickListener {
            if (progress <= 90){
                progress += 10
                binding.dayProgressBar.progress = progress
            }
        }

        binding.button.setOnClickListener {
            if (progress >= 10){
                progress -= 10
                binding.dayProgressBar.progress = progress
            }
        }


        return binding.root
    }

}