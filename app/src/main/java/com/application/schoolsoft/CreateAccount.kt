package com.application.schoolsoft

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class CreateAccount : AppCompatActivity(), View.OnClickListener {
    private lateinit var auth: FirebaseAuth
    private lateinit var createButton: Button
    private lateinit var backButton: ImageView
    private lateinit var name: String
    private lateinit var email: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account)
        auth = Firebase.auth
        initViews()
        initListeners()
    }

    private fun initViews() {
        createButton = findViewById(R.id.createAcc2)
        backButton = findViewById(R.id.backButton2)
    }

    private fun initListeners() {
        createButton.setOnClickListener(this)
        backButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) { R.id.createAcc2 -> {
            createAccount()
            val user = auth.currentUser
            if ( user != null ) {
                Toast.makeText(baseContext, "Contul a fost creat, logați-vă",
                        Toast.LENGTH_LONG).show()
                openLogin()
            }

        }}
        when (v?.id) {R.id.backButton2 -> {
            openLogin()
        }}
    }

    private fun createAccount() {
        val emailTxt = findViewById<View>(R.id.createEmail) as EditText
        val passwordTxt = findViewById<View>(R.id.createPassword) as EditText
        val confirmPass = findViewById<View>(R.id.confirmPassword) as EditText
        var email = emailTxt.text.toString()
        var password = passwordTxt.text.toString()
        var conPass = confirmPass.text.toString()
        if (conPass == password) {
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Log.d("createAcc", "createUserWithEmail:success")
                        } else {
                            Log.w("createAcc", "createUserWithEmail:failure", task.exception)
                            Toast.makeText(baseContext, "Authentication failed",
                                    Toast.LENGTH_SHORT).show()
                        }
                    }
        } else {
            Toast.makeText(baseContext, "Verifică parola și confirmarea acesteia",
                    Toast.LENGTH_LONG).show()
        }
    }

    private fun openLogin() {
        val intent = Intent(this, LoginPage::class.java)
        startActivity(intent)
    }

}