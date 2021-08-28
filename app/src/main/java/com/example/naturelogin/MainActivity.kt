package com.example.naturelogin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val tv_uid : TextView = findViewById(R.id.user_id)
        val tv_email : TextView = findViewById(R.id.email)

        val user_id= intent.getStringExtra("userId")
        val email_id = intent.getStringExtra("email")

        tv_email.append(user_id.toString())
        tv_uid.append(email_id.toString())
    }

    fun onLogout(view: View) {
        val intent_login = Intent(this,LoginActivity::class.java)
        FirebaseAuth.getInstance().signOut()
        startActivity(intent_login)
        finish()
    }
}