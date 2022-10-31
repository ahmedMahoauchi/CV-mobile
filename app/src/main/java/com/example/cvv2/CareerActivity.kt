package com.example.cvv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.cvv2.fragments.EducationFragment
import com.example.cvv2.fragments.ExperienceFragment
import com.example.cvv2.fragments.LanguageFragment
import com.example.cvv2.fragments.ResumeFragment

class CareerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_career)
        val btnEducation = findViewById<Button>(R.id.btn_education)
        val btnExperience = findViewById<Button>(R.id.btn_experience)

        btnEducation.setOnClickListener {
            val fragment = EducationFragment()
            showFragment(fragment)
        }

        btnExperience.setOnClickListener {
            val fragment = ExperienceFragment()
            showFragment(fragment)
        }


    }


    fun showFragment(fragment: Fragment){
        val fram = supportFragmentManager.beginTransaction()
        fram.replace(R.id.fragmentContainerView,fragment)
        fram.commit()
    }


    override fun onCreateOptionsMenu(menu: Menu) : Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu2, menu);
        return true;
    }

    //TODO logout
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar items
        when (item.getItemId()) {
            R.id.menu_experience -> {
                intent = Intent(this,AddExperienceActivity::class.java)
                startActivity(intent)
                return true
            } R.id.menu_education -> {
            intent = Intent(this,AddEducationActivity::class.java)
            startActivity(intent)
            return true
        }
            else ->
                return super.onOptionsItemSelected(item)
        }
    }
}