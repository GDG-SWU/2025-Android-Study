package com.example.a2025_android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.Timer
import kotlin.concurrent.timer

class UpgradeMainActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var btn_start : Button
    private lateinit var btn_refresh : Button
    private lateinit var tv_minute : TextView
    private lateinit var tv_second : TextView
    private lateinit var tv_millisecond : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_upgrade)

        btn_start = findViewById(R.id.btn_start)
        btn_refresh = findViewById(R.id.btn_refresh)
        tv_minute = findViewById(R.id.tv_minute)
        tv_second = findViewById(R.id.tv_second)
        tv_millisecond = findViewById(R.id.tv_milisecond)

        btn_start.setOnClickListener(this)
        btn_refresh.setOnClickListener(this)
    }

    private var isRunnig = false

    private var timer : Timer? = null
    private var time = 0

    override fun onClick(view: View) {
        when(view?.id){
            R.id.btn_start ->{
                if(isRunnig){
                    pause()
                }
                else{
                    start()
                }
            }
            R.id.btn_refresh ->{
                refresh()
            }

        }
    }

    private fun start() {
        btn_start.text = getString(R.string.btn_pause_eng)
        isRunnig = true

        timer = timer(period = 10){
            time++

            val milli_second = time%100
            val second = (time % 6000) / 100
            val minute = time / 6000

            runOnUiThread {
                if(isRunnig){
                    tv_millisecond.text = if(milli_second < 10) ".0${milli_second}" else ".${milli_second}"
                    tv_second.text = if(second < 10) ".0${second}" else ".${second}"
                    tv_minute.text = "${minute}"
                }
                }



        }
    }
    private fun pause() {
        btn_start.text = getString(R.string.btn_start_eng)


        isRunnig = false
        timer?.cancel()
    }
    private fun refresh() {
        timer?.cancel()

        btn_start.text = getString(R.string.btn_start_eng)
        isRunnig = false

        time = 0
        tv_millisecond.text = ",00"
        tv_second.text = ":00"
        tv_minute.text = "00 "
    }
}