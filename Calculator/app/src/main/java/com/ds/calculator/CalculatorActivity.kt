package com.ds.calculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_calculator.*
import kotlinx.android.synthetic.main.calculator_panel.*
import java.lang.Exception
import java.math.RoundingMode
import java.text.DecimalFormat

class CalculatorActivity : AppCompatActivity() {

    lateinit var game: TheGame

    private var state: TheGame.State = TheGame.State.RESULT

    private var userEntered: String = ""
        set(value) {
            field = value
            result.text = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        game = ViewModelProviders.of(this).get(TheGame::class.java)

        setupGame()
        setupPanel()
    }

    private fun setupGame() {
        game.gameLiveData.observe(this, Observer {
            state = it.state
            if (state == TheGame.State.QUESTION) {
                userEntered = ""
            }
            showGameData(it)
        })
    }

    private fun setupPanel() {
        add.setOnClickListener {
            if (state != TheGame.State.QUESTION) {
                game.newGame(TheGame.Operator.ADD)
            }
        }
        subtract.setOnClickListener {
            if (state != TheGame.State.QUESTION) {
                game.newGame(TheGame.Operator.SUBTRACT)
            }
        }
        multiple.setOnClickListener {
            if (state != TheGame.State.QUESTION) {
                game.newGame(TheGame.Operator.MULTIPLE)
            }
        }
        divide.setOnClickListener {
            if (state != TheGame.State.QUESTION) {
                game.newGame(TheGame.Operator.DIVIDE)
            }
        }
        percent.setOnClickListener {
            if (state != TheGame.State.QUESTION) {
                game.newGame(TheGame.Operator.PERCENT)
            }
        }

        one.setOnClickListener(numberClickListener("1"))
        two.setOnClickListener(numberClickListener("2"))
        three.setOnClickListener(numberClickListener("3"))
        four.setOnClickListener(numberClickListener("4"))
        five.setOnClickListener(numberClickListener("5"))
        six.setOnClickListener(numberClickListener("6"))
        seven.setOnClickListener(numberClickListener("7"))
        eight.setOnClickListener(numberClickListener("8"))
        nine.setOnClickListener(numberClickListener("9"))
        zero.setOnClickListener(numberClickListener("0"))
        decimal.setOnClickListener(numberClickListener(".", false))
        reset.setOnClickListener {
            if (state == TheGame.State.QUESTION) {
                userEntered = ""
            }

        }
        delete.setOnClickListener {
            if (state == TheGame.State.QUESTION && userEntered.isNotEmpty()) {
                userEntered = userEntered.substring(0, userEntered.length - 1)
            }
        }
        check_result.setOnClickListener {
            if (state == TheGame.State.QUESTION) {
                if (userEntered.isNotEmpty()) {
                    try {
                        game.checkResult(userEntered.toDouble())
                    } catch (ex: Exception) {
                        // do nothing
                    }
                }
            } else {
                game.nextStep()
            }
        }
    }

    private fun showGameData(gameData: GameData) {
        val question = gameData.question
        first.text = "${question.first.toInt()}"
        second.text = show(question.operator) + "  ${question.second.toInt()}"
        result.text = if (state == TheGame.State.RESULT) {
            question.result.round().removeTrailingZeros()
        } else {
            userEntered
        }
        result.setTextColor(
            ContextCompat.getColor(
                this,
                if (state == TheGame.State.USER_ENTERED) {
                    if (gameData.resultIsGood) {
                        R.color.good
                    } else {
                        R.color.bad
                    }
                } else {
                    R.color.colorPrimary
                }
            )
        )
    }

    private fun show(operator: TheGame.Operator): String {
        return when (operator) {
            TheGame.Operator.PERCENT -> "%"
            TheGame.Operator.DIVIDE -> "/"
            TheGame.Operator.MULTIPLE -> "X"
            TheGame.Operator.SUBTRACT -> "-"
            TheGame.Operator.ADD -> "+"
        }
    }

    private fun numberClickListener(entered: String, canBeMultiple: Boolean = true) = View.OnClickListener {
        if (state == TheGame.State.QUESTION && (canBeMultiple || !userEntered.contains(entered))) {
            userEntered += entered
        }
    }
}

fun Double.round(): Double = run {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    df.format(this).toDouble()
}

fun Double.removeTrailingZeros() = run {
    val value = this.toString()
    if (value.isNotEmpty()) {
        if (value.indexOf(".") < 0) {
            value
        } else {
            value.replace("0*$".toRegex(), "").replace("\\.$".toRegex(), "")
        }
    } else {
        value
    }
}