package com.example.myfitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnImc:Button=findViewById(R.id.btn_calcula_imc)
        btnImc.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id= view.id
        if(id==R.id.btn_calcula_imc){
            startActivity(Intent(this,ImcActivity::class.java))
        }
    }

}