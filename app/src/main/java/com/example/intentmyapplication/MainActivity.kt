package com.example.intentmyapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveDataActivity.setOnClickListener(this)

        val btnMoveObject: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveObject.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        when (v?.id){
            R.id.btn_move_activity -> {
                val moveActivity = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveActivity)
            }

            R.id.btn_move_activity_data -> {
                val moveDataActivity = Intent(this@MainActivity, MoveWithActivityData::class.java)
                moveDataActivity.putExtra(MoveWithActivityData.EXTRA_NAME, "Trias Zaen")
                moveDataActivity.putExtra(MoveWithActivityData.EXTRA_AGE, 5)
                startActivity(moveDataActivity)
            }

            R.id.btn_move_activity_object -> {
                val person = Person("Trias Zaen Mutaqin", 24, "iaszaen@gmail.com","jakarta timur")
                val moveDataObject = Intent(this@MainActivity,MoveWithObjectData::class.java)
                //moveDataObject.putExtra(MoveWithObjectData.EXTRA_PERSON, person)
                moveDataObject.putExtra(MoveWithObjectData.EXTRA_PERSON, person)
                startActivity(moveDataObject)
            }
        }
    }
}