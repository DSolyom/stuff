package com.ds.symbols_base

import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ds.symbols_base.model.Board
import com.ds.symbols_base.viewmodel.GameBase
import kotlinx.android.synthetic.main.activity_main.*


abstract class MainActivityBase : AppCompatActivity() {

    private lateinit var game: GameBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        game = createGameModel()
        game.restore(applicationContext)

        game.board.observe(this, Observer {
            showBoard(it)
        })
        game.state.observe(this, Observer {
            showState()
        })
        game.atTarget.observe(this, Observer {
            if (game.state.value == State.SHOW_TARGET) {
                showTarget()
                setButtonVisibility()
            }
        })

        btn_back.setOnClickListener {
            game.goBack()
            setButtonVisibility()
        }
        btn_next.setOnClickListener {
            game.next()
            setButtonVisibility()
        }
        btn_done.setOnClickListener {
            game.done()
        }

        level.setOnLongClickListener {
            showLevelPicker()
            true
        }

        game.setup(applicationContext)
    }

    private fun showBoard(board: Board) {
        the_grid.board = board
    }

    private fun showState() {
        val state = game.state.value
        if (state == State.SHOW_TARGET) {
            showTarget()
        }
        target_symbol.visibility = when (state) {
            State.SHOW_TARGET -> View.VISIBLE
            else -> View.GONE
        }
        level.visibility = target_symbol.visibility
        level.text = "${game.level}"
        the_grid.visibility = when (state) {
            State.SHOW_TARGET -> View.GONE
            else -> View.VISIBLE
        }
        the_grid.isEnabled = when (state) {
            State.SELECT -> true
            else -> false
        }
        setButtonVisibility()
    }

    private fun showTarget() {
        target_symbol.targetSymbol = TheGrid.validSymbols[game.targetSymbols?.get(game.atTarget.value!!) ?: 0]
    }

    private fun setButtonVisibility() {
        val state = game.state.value
        val onShowTarget = state == State.SHOW_TARGET
        no_button.visibility =
            if (onShowTarget && game.isFirstTarget || !onShowTarget && game.isFirstBoard) {
                View.VISIBLE
            } else {
                View.GONE
            }
        btn_back.visibility =
            if (no_button.visibility == View.VISIBLE) {
                View.GONE
            } else {
                View.VISIBLE
            }
        btn_next.visibility =
            if (onShowTarget && game.isLastTarget || !onShowTarget && game.isLastBoard) {
                View.GONE
            } else {
                View.VISIBLE
            }
        btn_done.visibility =
            if (btn_next.visibility == View.VISIBLE) {
                View.GONE
            } else {
                View.VISIBLE
            }
    }

    private fun showLevelPicker() {
        val d = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.number_picker_dialog, null)
        d.setView(dialogView)
        val numberPicker = dialogView.findViewById(R.id.dialog_number_picker) as NumberPicker
        numberPicker.maxValue = 1500
        numberPicker.minValue = 1
        numberPicker.value = game.level
        numberPicker.wrapSelectorWheel = false
        var selectedLevel = 1
        numberPicker.setOnValueChangedListener { _, _, newLevel ->
            selectedLevel = newLevel
        }
        d.setPositiveButton("OK") { _, _ ->
            game.restartAtLevel(selectedLevel)
        }
        val alertDialog = d.create()
        alertDialog.show()
    }

    abstract fun createGameModel(): GameBase
}
