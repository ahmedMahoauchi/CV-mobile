package com.example.cvv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cvv2.R
import com.example.cvv2.adapters.ExperienceAdapter
import com.example.cvv2.dataCalss.Experience
import com.suis.sqlite.SQLiteHelper


class ExperienceFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private lateinit var sqLiteHelper: SQLiteHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_experience, container, false)

        sqLiteHelper = SQLiteHelper(this.context)
        var rv=view.findViewById<RecyclerView>(R.id.experience_recyclerview)
        var experiences:ArrayList<Experience> = ArrayList()
        rv.layoutManager= LinearLayoutManager(this.context)




        var adapter=ExperienceAdapter(sqLiteHelper.getAllExperiences(),this.context)
        rv.adapter=adapter

        return view
    }


}