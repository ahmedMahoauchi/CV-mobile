package com.example.cvv2.dataCalss

import java.util.*


data class Experience(

    var id: Int = getAutoId(),
    val name: String,
    val adress: String,
    val description: String,
    val startDate:String,
    val endDate: String,
    val img: Int){


        companion object {
        fun getAutoId(): Int {
            val random = Random()
            return random.nextInt(999999999)
        }
    }
    }
