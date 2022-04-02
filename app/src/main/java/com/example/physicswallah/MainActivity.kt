package com.example.physicswallah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.physicswallah.ui.professorList.ProfessorsListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProfessorsListFragment.newInstance())
                .commitNow()
        }
    }
}