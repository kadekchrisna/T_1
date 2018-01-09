package com.kadek.t_1;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;

public class ImageAct extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerAdapter adapter;


    private String[] images = {

            "http://webneel.com/wallpaper/sites/default/files/images/04-2013/dreamy-beach-wallpaper.jpg",
            "https://static.pexels.com/photos/36764/marguerite-daisy-beautiful-beauty.jpg",
            "https://wallpaperscraft.com/image/patterns_background_dark_spots_50633_1080x1920.jpg",
            "http://www.1080x1920wallpapers.com/1080x1920-backgrounds/1080x1920-wallpapers-1/1080x1920-HD-wallpapers-samsung-htc-android-smartphone-1069sjm9-1080P.jpg"

    };

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(ImageAct.this,images);
        viewPager.setAdapter(adapter);

    }
}
