package com.example.myapplicationsada.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplicationsada.fragments.FragmentOne
import com.example.myapplicationsada.fragments.FragmentTwo

class ViewAdapter(activity:AppCompatActivity):FragmentStateAdapter (activity){
    override fun getItemCount(): Int =2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FragmentOne()
            1 -> FragmentTwo()
            else -> FragmentOne()

        }
    }
}