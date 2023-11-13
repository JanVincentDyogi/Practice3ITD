package com.example.practice3itd

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btnNext)

        button.setOnClickListener {
            val message = "Do you want to Logout?"
            showCustomDialogBox(message)
        }
//        button.setOnClickListener {
////            val myDialog = MyDialog()
////            myDialog.show(supportFragmentManager, "123")
//            val builder = AlertDialog.Builder(this)
//            builder
//                .setMessage("This is my Dialog Box")
//                .setPositiveButton("OK") { dialog, id ->
//                    Toast.makeText(this, "Accepted", Toast.LENGTH_LONG).show()
//                }
//                .setNegativeButton("Exit") { dialog, id ->
//                    Toast.makeText(this, "Rejected", Toast.LENGTH_LONG).show()
//                }
//                .show()
//        }
    }

    private fun showCustomDialogBox(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvMessage = dialog.findViewById<TextView>(R.id.tvMessage)
        val btnYes = dialog.findViewById<Button>(R.id.btnYes)
        val btnNo = dialog.findViewById<Button>(R.id.btnNo)

        tvMessage.text = message

        btnYes.setOnClickListener{
            Toast.makeText(this, "Logged Out Successfully", Toast.LENGTH_LONG).show()
            val i = Intent(this,ThirdActivity::class.java)
            startActivity(i)
            dialog.dismiss()
        }
        btnNo.setOnClickListener{
            dialog.dismiss()
        }
        dialog.show()
    }

    fun toSecondAct(view: View){
            var username = findViewById<EditText>(R.id.etUsername)
            var password = findViewById<EditText>(R.id.etPassword)

            var uname = username.text.toString()
            var pass = password.text.toString()

            if(uname == "USER" && pass == "PASS") {
                val bundle = Bundle()
                bundle.putString("username", uname)
                bundle.putString("password", pass)

                val i = Intent(this, SecondActivity::class.java)
                i.putExtras(bundle)
                startActivity(i)
            }
            else{
                Toast.makeText(this, "Invalid Username and/or Password", Toast.LENGTH_LONG).show()
            }
    }

    fun goWebsite(view: View){
        val website = findViewById<EditText>(R.id.etWebsite)
        val url = website.text.toString();

        val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://$url"))
        startActivity(i)
    }
}
