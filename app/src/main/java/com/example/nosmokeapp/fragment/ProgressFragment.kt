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
        var progress = 50
        binding = FragmentProgressBinding.inflate(inflater,container,false)

        binding.dayProgressBar.progress = progress


        return binding.root
    }

}