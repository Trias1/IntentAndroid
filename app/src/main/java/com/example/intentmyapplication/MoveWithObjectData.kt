package com.example.intentmyapplication

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectData : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object_data)

        val tvObject: TextView = findViewById(R.id.tv_object_received)

        val personn = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        if (personn != null){
            val text = "Name: ${personn.name.toString()},\nEmail: ${personn.email}, \nAge: ${personn.age},\nLocation: ${personn.city}"
            tvObject.text = text
        }
    }
}