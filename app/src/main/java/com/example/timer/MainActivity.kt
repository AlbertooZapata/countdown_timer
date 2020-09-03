package com.example.timer

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var cTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startTimer(60005)

    }
    private fun startTimer(Seconds: Long) {
        cTimer = object : CountDownTimer(Seconds * 1000 + 1000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {

                var seconds = (millisUntilFinished / 1000).toInt()

                val hours = seconds / (60 * 60)
                val tempMint = seconds - hours * 60 * 60
                val minutes = tempMint / 60
                seconds = tempMint - minutes * 60

                txtTimer.text = String.format(
                    "%02d",
                    hours
                ) + ":" + String.format("%02d", minutes) + ":" + String.format(
                    "%02d",
                    seconds
                )
            }
            override fun onFinish() {}
        }
        (cTimer as CountDownTimer).start()
    }


    //cancel timer
    fun cancelTimer() {
        if (cTimer != null) cTimer!!.cancel()
    }
}