package com.example.myapplicationsada.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplicationsada.MainActivity
import com.example.myapplicationsada.R

class FragmentTwo:Fragment(R.layout.activity_two) {
    private lateinit var editTextName : EditText
    private lateinit var editTextLastName : EditText
    private lateinit var editTextAge : EditText
    private lateinit var editTextjob : EditText
    private lateinit var editTextHobby : EditText
    private lateinit var editTextPhoto:EditText

    private lateinit var button: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = requireActivity().getSharedPreferences(
            "INFO",
            Context.MODE_PRIVATE
        )

        editTextName = view.findViewById(R.id.editTextName)
        editTextLastName = view.findViewById(R.id.editTextLastName)
        editTextAge = view.findViewById(R.id.editTextAge)
        editTextHobby = view.findViewById(R.id.editTextHobby)
        editTextjob = view.findViewById(R.id.editTextJob)
        editTextHobby = view.findViewById(R.id.editTextHobby)
        editTextPhoto = view.findViewById(R.id.editTextPhoto)

        button = view.findViewById(R.id.buttonSave)




        button.setOnClickListener {

            val name = editTextName.text.toString()
            val lastName = editTextLastName.text.toString()
            val age = editTextAge.text.toString()
            val job = editTextjob.text.toString()
            val hobby = editTextHobby.text.toString()
            val photo = editTextPhoto.text.toString()

            if(!(name.isEmpty() || lastName.isEmpty() || age.isEmpty() || job.isEmpty() || hobby.isEmpty() || photo.isEmpty() )) {
                val editor = sharedPreferences.edit()
                editor.putString("name", name)
                editor.putString("lastName", lastName)
                editor.putString("job", job)
                editor.putString("hobby", hobby)
                editor.putInt("age", age.toInt())
                editor.putString("photo", photo)


                editor.apply()


                Toast.makeText(requireContext(), "Information has been saved.", Toast.LENGTH_SHORT)
                    .show()

                val intent = Intent(getActivity(), MainActivity::class.java)
                getActivity()?.startActivity(intent)
            }

            else{
                Toast.makeText(requireContext(), "Data is Missing !!! ", Toast.LENGTH_SHORT)
                    .show()
            }

        }


        }



    }
