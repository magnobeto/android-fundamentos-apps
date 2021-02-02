package com.example.avaliamais.ui.studentPlace

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.avaliamais.R

class StudentPlaceFragment : Fragment() {

    private lateinit var galleryViewModel: StudentPlaceViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProvider(this).get(StudentPlaceViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_student_place, container, false)
        val textView: TextView = root.findViewById(R.id.text_student_place)
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}