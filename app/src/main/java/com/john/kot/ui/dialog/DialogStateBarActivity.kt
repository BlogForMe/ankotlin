package com.john.kot.ui.dialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.john.kot.R
import com.john.kot.databinding.ActivityDialogStatebarBinding

class DialogStateBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val biding = ActivityDialogStatebarBinding.inflate(layoutInflater)
        setContentView(biding.root)

        biding.btClick.setOnClickListener {
            val alertDialog: AlertDialog? = this?.let {
                val builder = AlertDialog.Builder(it)
                builder.apply {
                    setPositiveButton("R.string.ok",
                        DialogInterface.OnClickListener { dialog, id ->
                            // User clicked OK button
                        })
                    setNegativeButton(R.string.cancel,
                        DialogInterface.OnClickListener { dialog, id ->
                            // User cancelled the dialog
                        })
                }
                // Set other dialog properties
                // Create the AlertDialog
                builder.create()
            }
            alertDialog?.show()

        }
    }


}