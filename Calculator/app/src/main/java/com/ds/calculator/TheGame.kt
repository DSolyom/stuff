package com.ds.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TheGame : ViewModel() {

    companion object {
        const val MAX_VALUE = 99
        const val MAX_PERCENT_VALUE = 9999
        const val MAX_DIVIDE_VALUE = 9999
    }

    enum class Operator {
        ADD,
        SUBTRACT,
        DIVIDE,
        MULTIPLE,
        PERCENT
    }

    enum class State {
        QUESTION,
        USER_ENTERED,
        RESULT
    }

    private var question: Question = createQuestionAdd()

    val gameLiveData: LiveData<GameData> = MutableLiveData()

    fun newGame(operator: Operator) {
        if (gameLiveData.value == null ||
            gameLiveData.value?.state == State.RESULT ||
            gameLiveData.value?.resultIsGood == true
        ) {
            val gameData = GameData(
                question = when (operator) {
                    Operator.ADD -> createQuestionAdd()
                    Operator.SUBTRACT -> createQuestionSubtract()
                    Operator.MULTIPLE -> createQuestionMultiple()
                    Operator.DIVIDE -> createQuestionDivide()
                    Operator.PERCENT -> createQuestionPercent()
                }
            )
            (gameLiveData as MutableLiveData).postValue(gameData)
        }
    }

    fun checkResult(result: Double) {
        (gameLiveData as MutableLiveData)
            .postValue(gameLiveData.value?.let {
                it.copy(
                    state = State.USER_ENTERED,
                    resultIsGood = result == it.question.result.round()
                )
            })
    }

    fun nextStep() {
        gameLiveData.value?.let {
            if (it.state == State.RESULT || it.state == State.USER_ENTERED && it.resultIsGood) {
                newGame(it.question.operator)
            } else if (!it.resultIsGood) {
                (gameLiveData as MutableLiveData).postValue(it.copy(state = State.RESULT))
            }
        }
    }

    private fun randomNumber(max: Int = MAX_VALUE) = ((Math.random() * max).toInt() + 1).toDouble()

    private fun createQuestionAdd() = run {
        val first = randomNumber()
        val second = randomNumber()
        Question(Operator.ADD, first, second, first + second)
    }

    private fun createQuestionSubtract() = run {
        val first = randomNumber()
        val second = randomNumber()
        if (first > second) {
            Question(Operator.SUBTRACT, first, second, first - second)
        } else {
            Question(Operator.SUBTRACT, second, first, second - first)
        }
    }

    private fun createQuestionMultiple() = run {
        val first = randomNumber()
        val second = randomNumber()
        Question(Operator.MULTIPLE, first, second, first * second)
    }

    private fun createQuestionDivide() = run {
        val first = randomNumber(MAX_DIVIDE_VALUE)
        val second = randomNumber()
        Question(Operator.DIVIDE, first, second, first / second)
    }

    private fun createQuestionPercent() = run {
        val first = randomNumber(MAX_PERCENT_VALUE)
        val second = randomNumber(100)
        Question(Operator.PERCENT, first, second, first * second / 100)
    }
}

data class Question(val operator: TheGame.Operator, val first: Double, val second: Double, val result: Double)

data class GameData(
    val question: Question,
    val state: TheGame.State = TheGame.State.QUESTION,
    val resultIsGood: Boolean = false
)