package com.application.schoolsoft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ForgotPassword : AppCompatActivity(), View.OnClickListener {
    private lateinit var auth: FirebaseAuth
    private lateinit var sendRecoveryMail: Button
    private lateinit var backButton: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgot_password)
        auth = Firebase.auth
        initViews()
        initListeners()
    }

    override fun onClick(v: View?) {
        when(v?.id) {R.id.sendRecoveryMail -> { resetPassword() }}
        when(v?.id) {R.id.backButton -> { openLogin() }}
    }

    private fun initViews() {
        sendRecoveryMail = findViewById(R.id.sendRecoveryMail)
        backButton = findViewById(R.id.backButton)
    }

    private fun initListeners() {
        sendRecoveryMail.setOnClickListener(this)
        backButton.setOnClickListener(this)
    }

    private fun openLogin() {
        finish()
        /*val intent = Intent(this, LoginPage::class.java)
        startActivity(intent)*/
    }

    private fun resetPassword() {
        val emailTxt = findViewById<View>(R.id.restorepassEmail) as EditText
        var email = emailTxt.text.toString()
        Firebase.auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("passReset", "Email sent.")
                        Toast.makeText(baseContext, "Emailul a fost trimis.",
                            Toast.LENGTH_SHORT).show()
                    } else {
                        Log.w("passReset", "ERROR")
                        Toast.makeText(baseContext, "Eroare. Verificați emailul introdus.",
                            Toast.LENGTH_LONG).show()
                    }
                }
    }
}