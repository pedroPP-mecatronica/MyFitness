package com.example.myfitness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_imc.*
import java.lang.NumberFormatException


class ImcActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        btn_calcular.setOnClickListener(this)
    }

    fun calculate() {
        if (validationOk()) {
            try {
                val imc: Float =
                    (edit_peso.text.toString().toFloat()) / (edit_altura.text.toString()
                        .toFloat() * edit_altura.text.toString().toFloat())
                if (imc < 15) {
                    val dialog: AlertDialog = AlertDialog.Builder(this)
                        .setTitle(getString(R.string.imc_result, imc))
                        .create()
                    dialog.show()
                }
                if (imc > 15 && imc < 25) Toast.makeText(this, "Normal", Toast.LENGTH_SHORT).show()
                if (imc > 25 && imc < 28) Toast.makeText(this, "Sobre Peso", Toast.LENGTH_SHORT)
                    .show()
                if (imc > 28) Toast.makeText(this, "Sobre Peso", Toast.LENGTH_SHORT).show()
            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, "Valor inválido", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Preencha Todos os Campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validationOk(): Boolean {
        return (!edit_altura.text.isNullOrBlank() && !edit_peso.text.isNullOrBlank())
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.btn_calcular) {
            calculate()
        }
    }
}