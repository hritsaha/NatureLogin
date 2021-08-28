package com.example.naturelogin

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()
    }

    fun onLogin(view: View) {

        val emailInput : EditText = findViewById(R.id.input_email)
        val passInput : EditText = findViewById(R.id.input_password)

        when{
            TextUtils.isEmpty(emailInput.text.toString().trim{it <= ' '}) ->{
                Toast.makeText(this,"Please Enter Email",Toast.LENGTH_SHORT).show()
            }

            TextUtils.isEmpty(passInput.text.toString().trim{it <= ' '}) -> {
                Toast.makeText(this,"Please Enter Password",Toast.LENGTH_SHORT).show()
            }

            else -> {
                val emailVal = emailInput.text.toString()
                val passVal = passInput.text.toString()

                FirebaseAuth.getInstance().signInWithEmailAndPassword(emailVal,passVal).addOnCompleteListener({
                    task ->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT)

                        val uid : String = FirebaseAuth.getInstance().currentUser!!.uid!!

                        val intent_main = Intent(this,MainActivity::class.java)
                        intent_main.putExtra("userId",uid)
                        intent_main.putExtra("email",emailVal)
                        startActivity(intent_main)
                        finish()
                    }
                })
            }
        }
    }
}