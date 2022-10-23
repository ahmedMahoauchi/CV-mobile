package com.example.cvv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import com.example.cvv2.R


class LanguageFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_language, container, false)
        val bundle = this.arguments

        val movie = bundle?.getBoolean("arabic1",false)
        val sport = bundle?.getBoolean("french1",false)
        val game = bundle?.getBoolean("english1",false)





        return view
    }


  //  override fun onCreate(savedInstanceState: Bundle?) {
  //      super.onCreate(savedInstanceState)
  //  }


}