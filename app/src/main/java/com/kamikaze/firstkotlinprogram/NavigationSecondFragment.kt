package com.kamikaze.firstkotlinprogram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.kamikaze.firstkotlinprogram.databinding.FragmentNavigationSecondBinding

class navigationSecondFragment : Fragment() {

    private lateinit var binding :FragmentNavigationSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_navigation_second,container,false)
        var input :String?= requireArguments().getString("user_input")
        binding.inputtext.text =input
        binding.appCompatButton3.setOnClickListener { it.findNavController().navigate(R.id.action_navigationSecondFragment_to_navigationThirdFragmentTerms) }
        return binding.root
    }


    }
