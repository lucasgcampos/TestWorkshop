package com.brunodles.concretetestes

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val btnLogin by lazy { findViewById<Button>(R.id.btn_login) }
    private val errorMessage by lazy { findViewById<TextView>(R.id.error_message) }

    private val inputLogin by lazy { findViewById<EditText>(R.id.input_username) }
    private val inputPassword by lazy { findViewById<EditText>(R.id.input_password) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            if (isLoginSuccessful()) {
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                errorMessage.text =
                    when {
                        inputLogin.text.isEmpty() -> "Empty username"
                        inputPassword.text.isEmpty() -> "Empty password"
                        !PasswordValidator().validate(input_password.text.toString()) -> "Invalid username or password"
                        else -> "Unexpected error"
                    }
            }
        }
    }

    private fun isLoginSuccessful() =
            inputLogin.text.isNotEmpty() &&
            inputPassword.text.isNotEmpty() &&
            PasswordValidator().validate(input_password.text.toString())
}
