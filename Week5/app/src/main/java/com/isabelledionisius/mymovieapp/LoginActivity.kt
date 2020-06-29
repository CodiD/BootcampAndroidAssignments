package com.isabelledionisius.mymovieapp

//import androidx.preference.PreferenceManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val prefs = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        prefs.apply {
            val userName = getString("NAME", "")
            val password = getString("Password", "")
            et_UserName.setText(userName)
            et_Password.setText(password)
        }


        btn_Login.setOnClickListener {
            saveData()
        }
    }

    fun saveData() {
        var loggedin = false
        val prefs = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val editor = prefs.edit()
            .putString("NAME", et_UserName.text.toString())
            .putString("Password", et_Password.text.toString())
            .apply()

        val toast = Toast.makeText(applicationContext, "logged in", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.TOP, 0, 140)
        toast.show()
        loggedin = true
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)

    }
}
