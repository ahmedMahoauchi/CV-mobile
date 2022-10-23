package com.example.cvv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cvv2.fragments.HobbiesFragment
import com.example.cvv2.fragments.LanguageFragment
import com.example.cvv2.fragments.ResumeFragment
import com.example.cvv2.fragments.SkillsFragment

class ResultActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val age = intent.getStringExtra("age")
        val gender = intent.getStringExtra("gender")
        val iosSkills = intent.getIntExtra("iosSkills",0)
        val flutterSkills = intent.getIntExtra("flutterSkills",0)
        val androidSkills = intent.getIntExtra("androidSkills",0)
        val arabic = intent.getBooleanExtra("arabic",false)
        val french = intent.getBooleanExtra("french",false)
        val english = intent.getBooleanExtra("english",false)
        val movie = intent.getBooleanExtra("movie",false)
        val sport = intent.getBooleanExtra("sport",false)
        val game = intent.getBooleanExtra("games",false)


        Toast.makeText(this,movie.toString(),Toast.LENGTH_SHORT).show()



        val btnSkills = findViewById<Button>(R.id.btn_skills)
        val btnHobbies = findViewById<Button>(R.id.btn_hobbies)
        val btnLanguage = findViewById<Button>(R.id.btn_language)
        val nameR = findViewById<TextView>(R.id.name_textview)
        val emailR = findViewById<TextView>(R.id.email_textview)
        val btnMyCareer = findViewById<Button>(R.id.career_btn)

        nameR.text = name
        emailR.text = email


        val bundle = Bundle()
        bundle.putBoolean("movie1",movie)
        bundle.putBoolean("sport1",sport)
        bundle.putBoolean("game1",game)

        //Toast.makeText(this,iosSkills,Toast.LENGTH_SHORT).show()

        btnSkills.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("ios",iosSkills)
            bundle.putInt("android",androidSkills)
            bundle.putInt("flutter",flutterSkills)

            val fragment = SkillsFragment()
            fragment.setArguments(bundle)
            showFragment(fragment)

        }
        btnHobbies.setOnClickListener {

            val bundle = Bundle()
            bundle.putBoolean("movie1",movie)
            bundle.putBoolean("sport1",sport)
            bundle.putBoolean("game1",game)

            val fragment = HobbiesFragment()
            fragment.setArguments(bundle)
            showFragment(fragment)

        }
        btnLanguage.setOnClickListener {
            val bundle = Bundle()
            bundle.putBoolean("arabic1",arabic)
            bundle.putBoolean("french1",french)
            bundle.putBoolean("english1",english)

            val fragment = LanguageFragment()
            showFragment(fragment)




        }

        btnMyCareer.setOnClickListener {
            intent = Intent(this,CareerActivity::class.java)
            startActivity(intent)
        }



    }
    override fun onCreateOptionsMenu(menu: Menu) : Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar items
        when (item.getItemId()) {
            R.id.resume -> {
                val fragment = ResumeFragment()
                showFragment(fragment)
                return true
            }
            else ->
                return super.onOptionsItemSelected(item)
        }
    }

    fun showFragment(fragment: Fragment){
        val fram = supportFragmentManager.beginTransaction()
        fram.replace(R.id.fragmentContainerView2,fragment)
        fram.commit()
    }


}