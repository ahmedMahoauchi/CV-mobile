package com.example.cvv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val actionBar = supportActionBar
        actionBar!!.title = "Your skills"

        var iosText : Int



        val submit = findViewById<Button>(R.id.submit)
        val seekIos = findViewById<SeekBar>(R.id.ios_seek)
        val seekFlutter = findViewById<SeekBar>(R.id.flutter_seek)
        val seekAndroid = findViewById<SeekBar>(R.id.android_seek)
        val arabicCheckBox = findViewById<CheckBox>(R.id.checkBox)
        val frenchCheckBox = findViewById<CheckBox>(R.id.checkBox2)
        val englishCheckBox = findViewById<CheckBox>(R.id.checkBox3)
        val movieCheckBox = findViewById<CheckBox>(R.id.checkBox4)
        val sportCheckBox = findViewById<CheckBox>(R.id.checkBox5)
        val gamesCheckBox = findViewById<CheckBox>(R.id.checkBox6)













        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val age = intent.getStringExtra("age")
        val gender = intent.getStringExtra("gender")
        intent = Intent(this,ResultActivity::class.java)
        intent.putExtra("name",name.toString())
        intent.putExtra("email",email)
        intent.putExtra("age",age)
        intent.putExtra("gender",gender)








        submit.setOnClickListener {
            intent.putExtra("iosSkills",seekIos.progress)
            intent.putExtra("flutterSkills",seekFlutter.progress)
            intent.putExtra("androidSkills",seekAndroid.progress)

            intent.putExtra("arabic",arabicCheckBox.isChecked)
            intent.putExtra("french",frenchCheckBox.isChecked)
            intent.putExtra("english",englishCheckBox.isChecked)


            intent.putExtra("movie",movieCheckBox.isChecked())
            intent.putExtra("sport",sportCheckBox.isChecked())
            intent.putExtra("games",gamesCheckBox.isChecked())


            startActivity(intent)
        }
    }
}