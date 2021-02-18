package com.application.schoolsoft

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginPage : AppCompatActivity(), View.OnClickListener {
    private lateinit var topText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)
        initViews()
        initListeners()
    }

    private fun openCreateAccount() {
        val intent = Intent(this, CreateAccount::class.java)
        startActivity(intent)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.topText -> {
                openCreateAccount()
            }
            else -> Toast.makeText(applicationContext, "ok", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initViews() {
        topText = findViewById(R.id.topText)
    }

    private fun initListeners() {
        topText.setOnClickListener(this)
    }
}