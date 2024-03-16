package com.example.stuntcare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.raon.R

class AntiStunting2_3 : AppCompatActivity() {

    private lateinit var editTextWeight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anti_stunting23)

        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        val nextButton = findViewById<Button>(R.id.button6)

        nextButton.setOnClickListener {
            val weight = editTextWeight.text.toString()

            val intent = Intent(this, AntiStunting2_4::class.java)
            intent.putExtra("weight", weight)
            startActivity(intent)
        }
    }
}

//        editTextWeight = findViewById(R.id.editTextWeight)
//
//        editTextWeight.setOnClickListener {
//            showNumberInputDialog()
//        }
//    }
//}





//    private fun showNumberInputDialog() {
//        val dialogView = LayoutInflater.from(this).inflate(R.layout.activity_number_input_dialog, null)
//        val editTextNumber = dialogView.findViewById<EditText>(R.id.editTextWeight)
//
//        val dialogBuilder = AlertDialog.Builder(this)
//            .setView(dialogView)
//            .setTitle("Input Weight")
//            .setPositiveButton("OK") { dialog, which ->
//                // Handle the input here, for example, set the text to editTextWeight
//                editTextWeight.setText(editTextNumber.text.toString())
//                dialog.dismiss()
//            }
//            .setNegativeButton("Cancel") { dialog, which ->
//                dialog.dismiss()
//            }
//            .create()
//
//        dialogBuilder.show()
//    }
//}