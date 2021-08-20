package com.example.socialmediaintegration

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.facebook.login.LoginManager
import com.google.firebase.auth.FirebaseAuth

class DashboardActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser
        val name = findViewById<TextView>(R.id.name_txt)
        val email = findViewById<TextView>(R.id.email_txt)
        val signOutBtn = findViewById<Button>(R.id.sign_out_btn)
        val photo = findViewById<ImageView>(R.id.profile_picture)
        val personPhoto: Uri? = currentUser?.photoUrl

        name.text = currentUser?.displayName
        email.text = currentUser?.email
        Glide.with(this).load(personPhoto).into(photo)

        signOutBtn.setOnClickListener {
            mAuth.signOut()
            LoginManager.getInstance().logOut()
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}