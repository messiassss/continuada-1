package com.example.messias_continuada_1

import android.graphics.Color.BLACK
import android.graphics.Color.RED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonFun(view: View) {

        if (et_input1.text.isEmpty() || et_input2.text.isEmpty() || et_input3.text.isEmpty()) {

            if (et_input1.text.isEmpty()) {
                tv_title1.setTextColor(RED)
                tv_title1.setText("NOME não foi preenchido")
            } else {

                if (et_input1.text.length <= 3) {
                    tv_title1.setTextColor(RED)
                    tv_title1.setText("NOME deve ser maior de 3 caracteres")
                }

                else {

                    tv_title1.setText("NOME")
                    tv_title1.setTextColor(BLACK)
                }

            }
//----------------
            if (et_input2.text.isEmpty()) {
                tv_title2.setTextColor(RED)
                tv_title2.setText("Nota da continuada não foi preenchida")
            } else {

                if (et_input2.text.toString().toDouble() < 0 || et_input2.text.toString()
                        .toDouble() > 10
                ) {
                    tv_title2.setTextColor(RED)
                    tv_title2.setText("Nota média da continuada deve ser maior que 0 e menor ou igual a 10")
                }

                else{
                    tv_title2.setText("Nota média das provas continuadas")
                    tv_title2.setTextColor(BLACK)
                }
            }
//----------------

            if (et_input3.text.isEmpty()) {
                tv_title3.setTextColor(RED)
                tv_title3.setText("Nota da integral não foi preenchido")
            }
            else {

                if (et_input3.text.toString().toDouble() < 0 || et_input3.text.toString()
                        .toDouble() > 10
                ) {
                    tv_title3.setTextColor(RED)
                    tv_title3.setText("Nota média da integrada deve ser maior que 0 e menor ou igual a 10")
                }else{

                    tv_title3.setTextColor(BLACK)
                    tv_title3.setText("Nota média da prova integral")
                }

            }

//----------------

        } else {

            if (et_input1.text.length > 3 &&
                et_input2.text.toString().toDouble() >= 0 &&
                et_input3.text.toString().toDouble() >= 0
            ) {
                val finalScore = (et_input2.text.toString().toDouble() * 0.4) +
                        (et_input3.text.toString().toDouble() * 0.6)

                val studentName = et_input1.text
                tv_score.setText(
                    "Olá $studentName , sua nota final é de $finalScore" + " e " +
                            if (finalScore > 6) "você foi aprovado" else "você foi reprovado"
                )

                tv_score.visibility = VISIBLE

            } else {

                tv_score.visibility = INVISIBLE
            }

        }
    }
}