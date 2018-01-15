package com.kadek.t_1

import android.app.Activity
import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.github.chrisbanes.photoview.PhotoView
import com.github.chrisbanes.photoview.PhotoViewAttacher
import com.squareup.picasso.Picasso

/**
 * Created by reale on 13/07/2016.
 */
class ViewPagerAdapter(internal var activity: Activity, internal var images: Array<String>) : PagerAdapter() {
    internal lateinit var inflater: LayoutInflater

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        inflater = activity.applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = inflater.inflate(R.layout.viewpager_item, container, false)

        val image: ImageView
        image = itemView.findViewById<View>(R.id.imageView) as ImageView
        val dis = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(dis)
        val height = dis.heightPixels
        val width = dis.widthPixels
        image.minimumHeight = height
        image.minimumWidth = width





        try {
            Picasso.with(activity.applicationContext)
                    .load(images[position])
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(image)
        } catch (ex: Exception) {

        }

        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as View)
    }
}
