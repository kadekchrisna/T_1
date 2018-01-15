package com.kadek.t_1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class YoutubeActivity : YouTubeBaseActivity() {
    internal lateinit var youTubePlayerView: YouTubePlayerView
    internal lateinit var onInitializedListener: YouTubePlayer.OnInitializedListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)
        youTubePlayerView = findViewById<View>(R.id.view) as YouTubePlayerView

        onInitializedListener = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(provider: YouTubePlayer.Provider, youTubePlayer: YouTubePlayer, b: Boolean) {
                youTubePlayer.loadVideo("gRyPjRrjS34")
            }

            override fun onInitializationFailure(provider: YouTubePlayer.Provider, youTubeInitializationResult: YouTubeInitializationResult) {

            }
        }
        youTubePlayerView.initialize(YouTubeConfig.apiKey, onInitializedListener)
    }
}
