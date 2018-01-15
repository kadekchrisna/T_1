package com.kadek.t_1

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class DeatiledAct : AppCompatActivity() {
    private val iv: ImageView? = null
    private val bitmap: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deatiled)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        onClick2()
        onClick()
        onClickGo()
        /*iv = (ImageView) findViewById(R.id.iv1);
        bitmap = getBitmapFromURL("http://webneel.com/wallpaper/sites/default/files/images/04-2013/dreamy-beach-wallpaper.jpg");
        iv.setImageBitmap(bitmap);*/

    }

    private fun onClick2() {
        val but1 = findViewById<View>(R.id.button3) as Button
        but1.setOnClickListener {
            val a = Intent(this@DeatiledAct, ImageAct::class.java)
            startActivity(a)
        }
    }

    private fun onClick() {
        val imageButton = findViewById<View>(R.id.imbutton2) as ImageButton
        imageButton.setOnClickListener {
            val intent2 = Intent(this@DeatiledAct, YoutubeActivity::class.java)
            startActivity(intent2)
        }

    }

    fun onClickGo() {
        val button = findViewById<View>(R.id.buttongo) as Button
        button.setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW)
            mapIntent.data = Uri.parse("geo:0,0?q=-5.364546, 105.243503(Unila)")
            startActivity(mapIntent)
        }
    }

    fun getBitmapFromURL(src: String): Bitmap? {
        var myBitmap: Bitmap? = null
        try {
            val url = URL(src)
            val connection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input = connection.inputStream
            myBitmap = BitmapFactory.decodeStream(input)

        } catch (e: MalformedURLException) {
            e.printStackTrace()
            return null
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return myBitmap
    }

}
