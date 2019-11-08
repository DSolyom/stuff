package com.ds.balloons

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.LinearLayout
import androidx.annotation.RawRes
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ds.balloons.vm.Balloon
import com.ds.balloons.vm.SkyModel
import com.ds.balloons.widget.BalloonLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val MAX_NOTIFY_COUNT = 3
        private const val NOTIFICATION_SELECTING_DELAY = 5000L
        private const val NOTIFICATION_START_DELAY = 3000L
        private const val NOTIFICATION_GOOD_DELAY = 4000L
        private const val NOTIFICATION_BAD_DELAY = 3000L
        private const val NOTIFICATION_BAD_GOOD_DELAY = 4000L

        private val SOUND_SELECT = mapOf(
            Pair(0, R.raw.kek),
            Pair(1, R.raw.piros),
            Pair(2, R.raw.sarga),
            Pair(3, R.raw.zold)
        )

        private val SOUND_BAD = mapOf(
            Pair(0, R.raw.ezkek),
            Pair(1, R.raw.ezpiros),
            Pair(2, R.raw.ezsarga),
            Pair(3, R.raw.ezzold)
        )

        private val SOUND_GOOD = mapOf(
            Pair(0, R.raw.igenkek),
            Pair(1, R.raw.igenpiros),
            Pair(2, R.raw.igensarga),
            Pair(3, R.raw.igenzold)
        )
    }

    /**
     *
     */
    private var mediaPlayer: MediaPlayer? = null

    /**
     *
     */
    private var balloonLayouts: Array<BalloonLayout?>? = null

    /**
     *
     */
    private lateinit var model: SkyModel

    /**
     *
     */
    private val handler = Handler()

    /**
     *
     */
    private var notifiedCount = 0

    /**
     * Is the game in a selecting state? Can player select the good balloon?
     */
    private var inSelectingState: Boolean = false
        set(value) {
            if (balloonLayouts == null) {
                return
            }
            for (balloonLayout in balloonLayouts!!) {
                balloonLayout?.isEnabled = value
            }
            field = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = ViewModelProviders.of(this).get(SkyModel::class.java)

        model.balloonsData.observe(this, Observer<Array<Balloon?>> { balloonsData ->
            clearSkyView()
            createBalloons(balloonsData)
        })
        model.state.observe(this, Observer {
            resetNotifications()
            notifyAboutState()
        })
    }

    override fun onResume() {
        super.onResume()
        startFullNewGame()
    }

    override fun onPause() {
        stopNotifications()
        mediaPlayer?.stop()
        super.onPause()
    }

    /**
     *
     */
    private fun startFullNewGame() {
        resetNotifications()
        model.getResetAction()()
    }

    /**
     *
     */
    private fun clearSkyView() {
        sky_view.removeAllViews()
    }

    /**
     *
     */
    private fun createBalloons(balloons: Array<Balloon?>) {
        if (balloons.isEmpty()) {
            return
        }
        balloonLayouts = arrayOfNulls(balloons.size)
        for (i in 0 until balloons.size) {
            val balloon = balloons[i]!!
            val balloonLayout = when (balloon.isSelected) {
                true -> when (balloon.isTarget) {
                    true -> R.layout.good_balloon
                    false -> R.layout.bad_balloon
                }
                false -> R.layout.balloon
            }
            val balloonLayoutView = layoutInflater.inflate(balloonLayout, sky_view, false) as BalloonLayout
            balloonLayoutView.balloon = balloon
            sky_view.addView(balloonLayoutView)
            (balloonLayoutView.layoutParams as LinearLayout.LayoutParams).apply {
                width = 0
                height = LinearLayout.LayoutParams.MATCH_PARENT
                weight = 1.0f
            }
            balloonLayoutView.onBalloonTouched = {
                resetNotifications()
                model.getOnBalloonSelectedAction()(it)
            }
            balloonLayouts!![i] = balloonLayoutView
        }
    }

    /**
     *
     */
    private fun notifyAboutState() {
        when (model.state.value) {
            SkyModel.SkyState.INITIALIZED -> {
                inSelectingState = false
                playSound(SOUND_SELECT[model.targetBalloon.value?.color ?: 0] ?: R.raw.piros)
                handler.postDelayed(model.getStartGameAction(), NOTIFICATION_START_DELAY)
            }
            SkyModel.SkyState.SELECTING -> {
                if (inSelectingState && notifiedCount < MAX_NOTIFY_COUNT) {
                    playSound(SOUND_SELECT[model.targetBalloon.value?.color ?: 0] ?: R.raw.piros)
                }
                if (++notifiedCount < MAX_NOTIFY_COUNT + 1) {
                    inSelectingState = true
                    handler.postDelayed(::notifyAboutState, NOTIFICATION_SELECTING_DELAY)
                } else {
                    model.getShowBadGoodAction()()
                }
            }
            SkyModel.SkyState.SHOWING_BAD -> {
                inSelectingState = false
                // Only the wrongly selected balloon visible
                playSound(SOUND_BAD[model.balloonsData.value?.get(0)?.color ?: 0] ?: R.raw.ezpiros)
                handler.postDelayed(model.getShowBadGoodAction(), NOTIFICATION_BAD_DELAY)
            }
            SkyModel.SkyState.SHOWING_GOOD -> {
                inSelectingState = false
                playSound(SOUND_GOOD[model.targetBalloon.value?.color ?: 0] ?: R.raw.igenpiros)
                handler.postDelayed(model.getNewGameAction(), NOTIFICATION_GOOD_DELAY)
            }
            SkyModel.SkyState.SHOWING_BAD_GOOD -> {
                inSelectingState = false
                // Only the would be good balloon visible
                playSound(SOUND_BAD[model.balloonsData.value?.get(0)?.color ?: 0] ?: R.raw.ezpiros)
                handler.postDelayed(model.getNewGameAction(), NOTIFICATION_BAD_GOOD_DELAY)
            }
        }
    }

    private fun playSound(@RawRes sound: Int) {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(this, sound)
        mediaPlayer?.start()
    }

    /**
     *
     */
    private fun resetNotifications() {
        stopNotifications()
        notifiedCount = 0
    }

    /**
     *
     */
    private fun stopNotifications() {
        handler.removeCallbacksAndMessages(null)
    }
}
