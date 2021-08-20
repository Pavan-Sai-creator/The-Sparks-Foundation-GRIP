package com.example.socialmediaintegration

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser
        Handler().postDelayed({
            if(user!=null){
               val dashboardIntent = Intent(this, DashboardActivity::class.java)
               startActivity(dashboardIntent)
                finish()
            }
            else
            {
                val signInIntent = Intent(this,SignInActivity::class.java)
                startActivity(signInIntent)
                finish()
            }
        },1000
        )
    }
}