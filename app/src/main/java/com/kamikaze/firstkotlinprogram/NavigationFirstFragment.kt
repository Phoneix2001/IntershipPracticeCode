package com.kamikaze.firstkotlinprogram

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.kamikaze.firstkotlinprogram.databinding.FragmentNavigationFirstBinding


class NavigationFirstFragment : Fragment() {

    private lateinit var binding: FragmentNavigationFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_navigation_first, container, false)
        binding.submitButton10000.setOnClickListener {
        val bundle :Bundle= bundleOf("user_input" to binding.username.text.toString())
            it.findNavController()
                .navigate(R.id.action_navigationFirstFragment_to_navigationSecondFragment,bundle)
            binding.username.text = null


        }
        binding.appCompatButton2.setOnClickListener { it.findNavController().navigate(R.id.action_navigationFirstFragment_to_navigationThirdFragmentTerms) }
        return binding.root
    }

//companion object {
//    fun newInstance(): NavigationFirstFragment{
//        return NavigationFirstFragment()
//    }

}



