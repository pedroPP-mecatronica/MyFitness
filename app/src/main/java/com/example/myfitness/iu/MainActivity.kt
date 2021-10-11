package com.example.myfitness.iu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.myfitness.R
import com.example.myfitness.db.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var preferences:SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnImc:Button=findViewById(R.id.btn_calcula_imc)
        btnImc.setOnClickListener(this)
        preferences= SecurityPreferences(this)
    }

    override fun onClick(view: View) {
        val id= view.id
        if(id== R.id.btn_calcula_imc){
            val name: String =edit_name.text.toString()
            preferences.storeString("name",name)
            startActivity(Intent(this,ImcActivity::class.java))
        }
    }

}