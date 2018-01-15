package com.kadek.t_1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splash = object : Thread() {
            override fun run() {
                try {
                    super.run()
                    Thread.sleep(5000)
                } catch (e: Exception) {

                } finally {
                    val i = Intent(this@Splash, MenuFront::class.java)
                    startActivity(i)
                    finish()
                }
            }
        }
        splash.start()
    }
}
