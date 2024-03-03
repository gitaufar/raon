package com.example.raon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginn)
        val auth = FirebaseAuth.getInstance()
        val btnLogin: Button = findViewById(R.id.login)
        val etPass : TextInputEditText = findViewById(R.id.etPasswordLogin)
        val etEmail: TextInputEditText = findViewById(R.id.etEmailLogin)
        
        btnLogin.setOnClickListener(){
            val email: String = etEmail.text.toString()
            val pass: String = etPass.text.toString()
            
            if(email.isNotEmpty() && pass.isNotEmpty()){
                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener({
                    if(it.isSuccessful){
                        val intent = Intent(this,HomeActivity::class.java)
                        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                      startActivity(intent)
                    } else {
                        Toast.makeText(this, "wrong email or password", Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                Toast.makeText(this, "email and password cant be empty", Toast.LENGTH_SHORT).show()
            }

        }
        
    }
}