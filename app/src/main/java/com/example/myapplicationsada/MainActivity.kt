package com.example.myapplicationsada

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.manager.SupportRequestManagerFragment
import com.example.myapplicationsada.adapters.ViewAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout : TabLayout
    private lateinit var viewPager : ViewPager2



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        val viewAdapter = ViewAdapter(this)

        viewPager.adapter = viewAdapter

        TabLayoutMediator(tabLayout,viewPager){ tab, position->
            tab.text = "Tab ${position + 1} "
        }.attach()
    }
}