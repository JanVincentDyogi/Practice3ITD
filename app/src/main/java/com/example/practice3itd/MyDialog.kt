package com.example.practice3itd

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MyDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.requireActivity())

        builder
            .setMessage("This is our Dialog Message")
            .setPositiveButton("OK") { dialog, id ->
                //put commands here
            }
            .setNegativeButton("Exit") { dialog, id ->
                //put commands here
            }

        return builder.create()
        //return super.onCreateDialog(savedInstanceState)
    }
}