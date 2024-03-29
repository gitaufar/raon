package com.example.stuntcare

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.raon.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.database

class AntiStunting2_3 : AppCompatActivity() {

    private lateinit var editTextWeight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anti_stunting23)

        editTextWeight = findViewById(R.id.editTextWeight)

        editTextWeight.showSoftInputOnFocus = false

        editTextWeight.setOnClickListener {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken,0)
            showBottomSheet()
        }

        val button6 = findViewById<Button>(R.id.button6)
        button6.setOnClickListener {
            navigateToNextPage()
        }

        val imageViewBack = findViewById<ImageView>(R.id.imageView17)
        imageViewBack.setOnClickListener {
            onBackPressed()

        }
    }

    private fun navigateToNextPage() {
        val preWeight = editTextWeight.text.toString().toDoubleOrNull()
        if (preWeight != null) {
            val auth = FirebaseAuth.getInstance()
            val currentUser = auth.currentUser
            val db = Firebase.database
            val ref = db.getReference(currentUser?.uid!!)
            ref.child("pre-pregnancy weight").setValue(preWeight)

            val intent = Intent(this, AntiStunting2_4::class.java)
            startActivity(intent)
        }


    }

    private fun showBottomSheet() {
        val dialog = BottomSheetDialog(this)
        val bottomSheetView = layoutInflater.inflate(R.layout.number, null)

        val bottomSheetButtonClickListener = View.OnClickListener { view ->
            val button = view as Button
            val buttonText = button.text.toString()
            val currentText = editTextWeight.text.toString()
            editTextWeight.setText(currentText + buttonText)
        }

        val button0 = bottomSheetView.findViewById<Button>(R.id.button0)
        button0.setOnClickListener(bottomSheetButtonClickListener)
        val button1 = bottomSheetView.findViewById<Button>(R.id.button1)
        button1.setOnClickListener(bottomSheetButtonClickListener)
        val button2 = bottomSheetView.findViewById<Button>(R.id.button2)
        button2.setOnClickListener(bottomSheetButtonClickListener)
        val button3 = bottomSheetView.findViewById<Button>(R.id.button3)
        button3.setOnClickListener(bottomSheetButtonClickListener)
        val button4 = bottomSheetView.findViewById<Button>(R.id.button4)
        button4.setOnClickListener(bottomSheetButtonClickListener)
        val button5 = bottomSheetView.findViewById<Button>(R.id.button5)
        button5.setOnClickListener(bottomSheetButtonClickListener)
        val button6 = bottomSheetView.findViewById<Button>(R.id.button6)
        button6.setOnClickListener(bottomSheetButtonClickListener)
        val button7 = bottomSheetView.findViewById<Button>(R.id.button7)
        button7.setOnClickListener(bottomSheetButtonClickListener)
        val button8 = bottomSheetView.findViewById<Button>(R.id.button8)
        button8.setOnClickListener(bottomSheetButtonClickListener)
        val button9 = bottomSheetView.findViewById<Button>(R.id.button9)
        button9.setOnClickListener(bottomSheetButtonClickListener)

        val buttonClear = bottomSheetView.findViewById<Button>(R.id.buttonClear)
        buttonClear.setOnClickListener {
            editTextWeight.setText("")
        }

        val buttonOK = bottomSheetView.findViewById<Button>(R.id.button10)
        buttonOK.setOnClickListener {
            dialog.dismiss()
        }

        val buttonComma = bottomSheetView.findViewById<Button>(R.id.buttonOK)
        buttonComma.setOnClickListener {
            val currentText = editTextWeight.text.toString()
            if (!currentText.contains(".")) {
                editTextWeight.setText(currentText + ".")
            } else {
                Toast.makeText(this, "Sudah ada koma", Toast.LENGTH_SHORT).show()
            }
        }

        dialog.setContentView(bottomSheetView)
        dialog.show()
    }
}