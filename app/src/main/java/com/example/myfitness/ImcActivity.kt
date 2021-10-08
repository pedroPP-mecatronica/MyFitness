package com.example.myfitness

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
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
                createAlertDialog(escolherMensagem(imc), imc)
            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, "Valor inválido", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Preencha Todos os Campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun createAlertDialog(escolherMensagem: Int, imc: Float) {
        val dialog: AlertDialog =
            AlertDialog
                .Builder(this)
                .setTitle(getString(R.string.imc_response, imc))
                .setMessage(escolherMensagem)
                .setPositiveButton(android.R.string.ok,
                    DialogInterface.OnClickListener { dialog, id -> })
                .setNegativeButton(android.R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id -> })
                .create()
        dialog.show()
    }

    @StringRes
    private fun escolherMensagem(imc: Float): Int {
        return if (imc < 15)
            R.string.imc_severely_low_weight
        else if (imc > 15 && imc < 23)
            R.string.imc_low_weight
        else if (imc > 25 && imc < 28)
            R.string.normal
        else if (imc > 28 && imc < 30)
            R.string.imc_high_weight
        else
            R.string.imc_extreme_weight
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