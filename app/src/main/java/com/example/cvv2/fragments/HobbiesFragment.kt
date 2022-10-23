package com.example.cvv2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cvv2.R

class HobbiesFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(R.layout.fragment_hobbies, container, false)

        val bundle = this.arguments

        val movie = bundle?.getBoolean("movie1",false)
        val sport = bundle?.getBoolean("sport1",false)
        val game = bundle?.getBoolean("game1",false)


        Toast.makeText(inflater.context,movie.toString(),Toast.LENGTH_SHORT).show()


        val moviec = view.findViewById<CheckBox>(R.id.checkBox4)
        val sportc = view.findViewById<CheckBox>(R.id.checkBox5)
        val gamec = view.findViewById<CheckBox>(R.id.checkBox6)

        if (movie != null) {
            moviec.isChecked = movie
        }

        if (sport != null) {
            sportc.isChecked = sport
        }

        if (game != null) {
            gamec.isChecked = game
        }
        return view
    }


}