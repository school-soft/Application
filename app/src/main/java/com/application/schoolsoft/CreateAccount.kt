package com.application.schoolsoft

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CreateAccount : ActivityBase(), View.OnClickListener {
    private lateinit var auth: FirebaseAuth
    private lateinit var createButton: Button
    private lateinit var backButton: ImageView
    private val KEY_USER: String = "Username"
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
        }}
        when (v?.id) {R.id.backButton2 -> {
            finish()
        }}
    }

    private fun createAccount() {
        val emailTxt = findViewById<View>(R.id.createEmail) as EditText
        val createUser = findViewById<View>(R.id.createUser) as EditText
        val passwordTxt = findViewById<View>(R.id.createPassword) as EditText
        val confirmPass = findViewById<View>(R.id.confirmPassword) as EditText
        var email = emailTxt.text.toString()
        var username = createUser.text.toString()
        var password = passwordTxt.text.toString()
        var conPass = confirmPass.text.toString()
        if (conPass == password) {
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Log.d("createAcc", "createUserWithEmail:success")
                            Toast.makeText(baseContext, "Contul a fost creat",
                                    Toast.LENGTH_SHORT).show()
                            addUserDb(username)
                            openAlegeClasa()
                        } else {
                            Log.w("createAcc", "createUserWithEmail:failure", task.exception)
                            Toast.makeText(baseContext, "Autentificare eșuată",
                                    Toast.LENGTH_SHORT).show()
                        }
                    }
        } else {
            Toast.makeText(baseContext, "Verifică parola și confirmarea acesteia",
                    Toast.LENGTH_LONG).show()
        }
    }

    private fun openAlegeClasa() {
        val intent = Intent(this, AlegeClasa::class.java)
        startActivity(intent)
        finish()
    }

    private fun addUserDb(username: String) {
        val userID: String = auth.uid.toString();
        val database = Firebase.firestore
        val data = hashMapOf(KEY_USER to username)
        database.collection("Users").document(userID).set(data, SetOptions.merge()).
        addOnSuccessListener { Log.d("db.user", "Username successfully set!") }.
        addOnFailureListener { Log.w("db.user", "Set Username Failure")}
    }
}