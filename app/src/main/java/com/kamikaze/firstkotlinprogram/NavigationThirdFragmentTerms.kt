package com.kamikaze.firstkotlinprogram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.kamikaze.firstkotlinprogram.databinding.FragmentNavigationThirdTermsBinding


class NavigationThirdFragmentTerms : Fragment() {

    private lateinit var binding : FragmentNavigationThirdTermsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_navigation_third_terms, container, false)
        binding.Submit.setOnClickListener { it.findNavController().navigate(R.id.action_navigationThirdFragmentTerms_to_navigationThirdFragment) }
        return binding.root
    }

    }
