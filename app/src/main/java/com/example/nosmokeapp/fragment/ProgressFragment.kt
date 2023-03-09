package com.example.nosmokeapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nosmokeapp.R
import com.example.nosmokeapp.databinding.FragmentProgressBinding
import com.example.nosmokeapp.repository.PrefRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProgressFragment : Fragment() {
    private lateinit var binding:FragmentProgressBinding

    @Inject
    lateinit var repository:PrefRepository


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val progress = 50
        binding = FragmentProgressBinding.inflate(inflater,container,false)

        binding.dayProgressBar.progress = progress

        Log.d("CIGA_COUNT", repository.getCigaCountPreference().toString())
        return binding.root

    }

}