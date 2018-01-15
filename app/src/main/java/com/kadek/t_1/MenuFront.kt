package com.kadek.t_1

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView

import com.github.chrisbanes.photoview.PhotoViewAttacher


class MenuFront : AppCompatActivity() {

    private var mTextMessage: TextView? = null
    internal var pta: PhotoViewAttacher? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                mTextMessage!!.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                mTextMessage!!.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                val intn = Intent(this@MenuFront, MapsActivity::class.java)
                startActivity(intn)
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menufront)

        mTextMessage = findViewById<View>(R.id.message) as TextView
        val navigation = findViewById<View>(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        onClick()

    }

    private fun onClick() {
        val but1 = findViewById<View>(R.id.but) as Button
        but1.setOnClickListener {
            val i = Intent(this@MenuFront, DeatiledAct::class.java)
            startActivity(i)
        }
    }


}
