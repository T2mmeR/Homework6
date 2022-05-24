package com.example.myapplicationsada.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.myapplicationsada.R

class FragmentOne:Fragment(R.layout.activity_one) {

    private lateinit var textViewName : TextView
    private lateinit var textViewLastName : TextView
    private lateinit var textViewAge : TextView
    private lateinit var textViewJob : TextView
    private lateinit var textViewHobby : TextView
    private lateinit var imageView : ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val preferences = requireActivity().getSharedPreferences("INFO", Context.MODE_PRIVATE)
        textViewName = view.findViewById(R.id.textViewName)
        textViewLastName = view.findViewById(R.id.textViewLastName)
        textViewAge = view.findViewById(R.id.textViewAge)
        textViewJob = view.findViewById(R.id.textViewJob)
        textViewHobby = view.findViewById(R.id.textViewHobby)
        imageView = view.findViewById(R.id.imageView)



            textViewName.text = preferences.getString("name", "")
            textViewLastName.text = preferences.getString("lastName", "")
            textViewJob.text = preferences.getString("job", "")
            textViewHobby.text = preferences.getString("hobby", "")
            textViewAge.text = preferences.getInt("age", 0).toString()


            Glide.with(requireContext())
                .load(preferences.getString("photo",""))
                .placeholder(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(imageView)



              val name = textViewName.text.toString()
              val lastName = textViewLastName.text.toString()
              val age = textViewAge.text.toString()
              val job = textViewJob.text.toString()
              val hobby = textViewHobby.text.toString()




        if(name.isEmpty() || lastName.isEmpty() || age.isEmpty() || job.isEmpty() || hobby.isEmpty() ){

            Toast.makeText(requireContext(), "Missing Data . Visit Tab 2 !  ", Toast.LENGTH_LONG)
                .show()
        }


    }
}