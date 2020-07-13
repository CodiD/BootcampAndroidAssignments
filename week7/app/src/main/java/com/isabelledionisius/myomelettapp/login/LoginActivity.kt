package com.isabelledionisius.myomelettapp.login

//import androidx.preference.PreferenceManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.isabelledionisius.myomelettapp.omeletts.MainActivity
import com.isabelledionisius.myomelettapp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val prefs = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        prefs.apply {
            val userName = getString(NAME, "")
            val password = getString(PASSWORD, "")
            userNameEditText.setText(userName)
            passwordEditText.setText(password)
        }

        loginButton.setOnClickListener {
            logIn()
        }
    }

    fun logIn () {
        saveLoginData()
        showLoginMessage()
        startMainScreen()
        finish()
    }

    fun saveLoginData() {
        val prefs = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = prefs.edit()
            .putString(NAME, userNameEditText.text.toString())
            .putString(PASSWORD, passwordEditText.text.toString())
            .apply()
    }

    fun showLoginMessage() {
        var loggedin = false
        val toast = Toast.makeText(applicationContext, LOGGED_IN, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.TOP, 0, 140)
        toast.show()
        loggedin = true
    }

    fun startMainScreen() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}

private const val PREFERENCE_NAME = ""
private const val LOGGED_IN = "logged in"
private const val NAME = "NAME"
private const val PASSWORD = "Password"
