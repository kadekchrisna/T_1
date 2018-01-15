package com.kadek.t_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DeatiledAct extends AppCompatActivity {
    private ImageView iv;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatiled);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        onClick2();
        onClick();
        onClickGo();
        /*iv = (ImageView) findViewById(R.id.iv1);
        bitmap = getBitmapFromURL("http://webneel.com/wallpaper/sites/default/files/images/04-2013/dreamy-beach-wallpaper.jpg");
        iv.setImageBitmap(bitmap);*/

    }
    private void onClick2(){
        Button but1 = (Button) findViewById(R.id.button3);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vie) {
                Intent a = new Intent(DeatiledAct.this,ImageAct.class);
                startActivity(a);
            }
        });
    }
    private void onClick(){
        ImageButton imageButton = (ImageButton) findViewById(R.id.imbutton2);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(DeatiledAct.this, YoutubeActivity.class);
                startActivity(intent2);
            }
        });

    }
    public void onClickGo(){
        Button button = (Button)findViewById(R.id.buttongo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                mapIntent.setData(Uri.parse("geo:0,0?q=-5.364546, 105.243503(Unila)"));
                startActivity(mapIntent);
            }
        });
    }
    public Bitmap getBitmapFromURL(String src) {
        Bitmap myBitmap = null;
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            myBitmap = BitmapFactory.decodeStream(input);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myBitmap;
    }

}
