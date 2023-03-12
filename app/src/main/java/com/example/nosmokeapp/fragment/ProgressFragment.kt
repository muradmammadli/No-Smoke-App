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
import kotlinx.coroutines.currentCoroutineContext
import java.util.Calendar
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class ProgressFragment : Fragment() {
    private lateinit var binding: FragmentProgressBinding

    @Inject
    lateinit var repository: PrefRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProgressBinding.inflate(inflater, container, false)
        setProgress()
        return binding.root
    }

    private fun setProgress() {
        val currentTime = Calendar.getInstance().timeInMillis
        val choosenTime = repository.getTimeStampPreference()
        val diffTime = currentTime - choosenTime
        val days = TimeUnit.MILLISECONDS.toDays(diffTime)
        val hours = TimeUnit.MILLISECONDS.toHours(diffTime)
        val price = repository.getPackPricePreference()
        Log.d("price", "$price")
        val totalPrice = days * price
        binding.apply {
            freeCigarHours.text = "$hours saat"
            priceTxt.text = "${totalPrice} AZN"
            if (days < 7) {
                dayProgressBar.progress = 0
                progressAmount.text = "0 %"
            } else {
                val progress = days * 2
                dayProgressBar.progress = progress.toInt()
                progressAmount.text = "$progress %"
            }
        }
    }


}