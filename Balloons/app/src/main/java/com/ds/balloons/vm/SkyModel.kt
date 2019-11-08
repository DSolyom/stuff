package com.ds.balloons.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SkyModel : ViewModel() {

    companion object {
        /**
         * Default balloon count.
         */
        private const val DEFAULT_BALLOON_COUNT = 4

        /**
         *
         */
        private const val SUCCESS_TO_INCREASE = 4

        /**
         *
         */
        private const val MAX_BALLOON_COUNT = 4
    }

    /**
     * Live data with the balloons.
     */
    val balloonsData: LiveData<Array<Balloon?>> = MutableLiveData()

    /**
     * The target balloon.
     */
    val targetBalloon: LiveData<Balloon?> = MutableLiveData()

    /**
     * State of the sky.
     */
    val state: LiveData<SkyState> = MutableLiveData()

    /**
     * The balloon count.
     */
    private var balloonCount = DEFAULT_BALLOON_COUNT

    /**
     *
     */
    private var successCount = 0

    /**
     *
     */
    private var selectedBalloon: Balloon? = null

    /**
     *
     */
    fun getResetAction(): () -> Unit {
        return {
            successCount = 0
            balloonCount = DEFAULT_BALLOON_COUNT
            newGame()
        }
    }

    /**
     * Clears the sky and creates the balloons.
     */
    private fun newGame(target: Int = (Math.random() * balloonCount).toInt()) {
        val balloons = arrayOfNulls<Balloon>(balloonCount)
        for (i in 0 until balloons.size) {
            balloons[i] = Balloon(i, i == target)
        }
        (targetBalloon as MutableLiveData).value = balloons[target]

        // Randomizing
        for (i in 0..10) {
            val random: Int = (Math.random() * balloonCount - 1).toInt() + 1
            val balloon = balloons[0]
            balloons[0] = balloons[random]
            balloons[random] = balloon
        }

        (balloonsData as MutableLiveData).postValue(balloons)
        (state as MutableLiveData).value = SkyState.INITIALIZED
    }

    /**
     *
     */
    fun getStartGameAction(): () -> Unit {
        return {
            (state as MutableLiveData).value = SkyState.SELECTING
        }
    }

    /**
     * Gets the balloon selected action.
     */
    fun getOnBalloonSelectedAction(): (Balloon) -> Unit {
        return { selected ->
            selectedBalloon = selected
            selectedBalloon?.apply {
                isSelected = true
                x = 0.5
                y = 0.5
            }
            (balloonsData as MutableLiveData).postValue(arrayOf(selected))
            (state as MutableLiveData).postValue(when (selectedBalloon?.isTarget) {
                true -> SkyState.SHOWING_GOOD
                else -> SkyState.SHOWING_BAD
            })
        }
    }

    /**
     *
     */
    fun getShowBadGoodAction(): () -> Unit {
        return {
            targetBalloon.value?.apply {
                x = 0.5
                y = 0.5
                (balloonsData as MutableLiveData).postValue(arrayOf(this))
            }
            (state as MutableLiveData).postValue(SkyState.SHOWING_BAD_GOOD)
        }
    }

    /**
     * Get new game action.
     */
    fun getNewGameAction(): () -> Unit {
        return {
            if (selectedBalloon?.isTarget == true) {
                successCount++
                if (successCount % SUCCESS_TO_INCREASE == 0 && balloonCount < MAX_BALLOON_COUNT) {
                    balloonCount++
                }
                newGame()
            } else {
                successCount = 0
                newGame(targetBalloon.value!!.color)
            }
        }
    }

    enum class SkyState {
        INITIALIZED,
        SELECTING,
        SHOWING_BAD,
        SHOWING_GOOD,
        SHOWING_BAD_GOOD
    }
}