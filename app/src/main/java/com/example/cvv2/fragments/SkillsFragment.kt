package com.example.cvv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import com.example.cvv2.R
class SkillsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_skills, container, false)


        val bundle = this.arguments

        //val fares : String? = bundle?.getString("fares")

        //Toast.makeText(inflater.context,fares.toString(),Toast.LENGTH_SHORT).show()


        val ios = bundle?.getInt("ios",0)
        val android = bundle?.getInt("android",0)
        val flutter = bundle?.getInt("flutter",0)

        val seekIos = view.findViewById<SeekBar>(R.id.ios_seekf)
        val seekFlutter = view.findViewById<SeekBar>(R.id.flutter_seekf)
        val seekAndroid = view.findViewById<SeekBar>(R.id.android_seekf)

        //Toast.makeText(inflater.context,ios.toString(),Toast.LENGTH_SHORT).show()



        seekIos.progress = ios!!.toInt()
        seekAndroid.progress = android!!.toInt()
        seekFlutter.progress = flutter!!.toInt()



        view.isEnabled = false;

        return view
    }


}