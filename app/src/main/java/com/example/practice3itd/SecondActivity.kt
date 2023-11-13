package com.example.practice3itd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val username = findViewById<TextView>(R.id.tvUsername)
        val password = findViewById<TextView>(R.id.tvPassword)

        val bundle = intent.extras
        if(bundle != null){
            username.text = "${bundle.getString("username")}"
            password.text = "${bundle.getString("password")}"
        }
    }

    fun toMainAct(view: View){
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}