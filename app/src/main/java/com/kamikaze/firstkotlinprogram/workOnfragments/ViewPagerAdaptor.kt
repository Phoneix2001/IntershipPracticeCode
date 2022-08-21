package com.kamikaze.firstkotlinprogram.workOnfragments

import androidx.annotation.Nullable
import androidx.fragment.app.*
import androidx.lifecycle.Lifecycle

import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdaptor(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle)
    {
    private final var fragmentList: ArrayList<Fragment> = ArrayList()
    private final var fragmentTitleList: ArrayList<String> = ArrayList()





   fun addFragment(fragment: Fragment, title :String) {
        fragmentList.add(fragment)
       fragmentTitleList.add(title)
  }

        override fun getItemCount(): Int {
         return   fragmentList.size
        }

        override fun createFragment(position: Int ): Fragment {
            return fragmentList.get(position)

        }


        }


