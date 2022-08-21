package com.kamikaze.firstkotlinprogram.workOnfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kamikaze.firstkotlinprogram.R
import kotlinx.android.synthetic.main.activity_fragment_with_view_pager_and_bottom_navigation_bar.*

class FragmentWithViewPagerAndBottomNavigationBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_with_view_pager_and_bottom_navigation_bar)
        setSupportActionBar(toolbar)
        setupViewPager(tab_viewpager)


        TabLayoutMediator(tab_tablayout,tab_viewpager){tab,position->tab.text ="Fragment ${position+1}"
        }.attach()
        tab_tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })


    }

     private fun setupViewPager(tabViewpager: ViewPager2) {
         val adapter = ViewPagerAdaptor(supportFragmentManager,lifecycle)
        adapter.addFragment(FirstFragment(),"First")
         adapter.addFragment(SecondFragment(),"Second")
         adapter.addFragment(ThirdFragment(),"Third")
tabViewpager.adapter = adapter

     }}



