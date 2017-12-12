package com.kadek.t_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread splash = new Thread(){
            @Override
            public void run() {
                try{
                super.run();
                sleep(5000);
                } catch (Exception e){

                }finally {
                    Intent i = new Intent(Splash.this,MenuFront.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        splash.start();
    }
}
