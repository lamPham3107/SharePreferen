package com.example.bt1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bt1.utils.PreferenceHelper

class MainActivity : AppCompatActivity() {
    private lateinit var preferenceHelper: PreferenceHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        preferenceHelper = PreferenceHelper(this)
        val username = findViewById<EditText>(R.id.username);
        val password = findViewById<EditText>(R.id.password)
        val bt_save = findViewById<Button>(R.id.bt_save);
        val bt_del = findViewById<Button>(R.id.bt_delete);
        val bt_load = findViewById<Button>(R.id.bt_load);
        val txtResult = findViewById<TextView>(R.id.txt_result);

        bt_save.setOnClickListener {
            val user = username.text.toString()
            val pass = password.text.toString()
            preferenceHelper.save(user, pass)
        }
        bt_del.setOnClickListener {
            username.text.clear()   ;
            password.text.clear();
            preferenceHelper.clearUser()
        }
        bt_load.setOnClickListener {
            val (username, password) = preferenceHelper.getUser()
            txtResult.text = "Tên: $username\nMật khẩu: $password"
        }
    }
}