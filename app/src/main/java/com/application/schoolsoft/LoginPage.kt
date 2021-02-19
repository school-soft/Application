package com.application.schoolsoft

import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginPage : AppCompatActivity(), View.OnClickListener {
    private lateinit var topText: TextView
    private lateinit var auth: FirebaseAuth
    private lateinit var logButton: Button
    private lateinit var forgotPassword: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)
        auth = Firebase.auth
        initViews()
        initListeners()
    }

    private fun openCreateAccount() {
        val intent = Intent(this, CreateAccount::class.java)
        startActivity(intent)
    }

    override fun onClick(v: View?) {
        when (v?.id) { R.id.topText -> { openCreateAccount() }}
        when (v?.id) { R.id.logButton -> { loginEmail() }}
    }

    private fun initViews() {
        topText = findViewById(R.id.topText)
        logButton = findViewById(R.id.logButton)
        forgotPassword = findViewById(R.id.forgotPassword)
    }

    private fun initListeners() {
        topText.setOnClickListener(this)
        logButton.setOnClickListener(this)
    }

    private fun loginEmail () {
        val emailTxt = findViewById<View>(R.id.inputEmail) as EditText
        var email = emailTxt.text.toString()
        val passwordTxt = findViewById<View>(R.id.inputPassword) as EditText
        var password = passwordTxt.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            this.auth.signInWithEmailAndPassword(email, password).
                addOnCompleteListener (this) { task ->
                if (task.isSuccessful){
                    Log.d("Login", "signInWithEmail:success")
                    val user = auth.currentUser
                } else {
                    Log.w("Login","signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(this, "Please fill up the credentials", Toast.LENGTH_SHORT).show()
        }
    }
}