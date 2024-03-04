package com.example.edgaranimations

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.LayoutInflater
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.edgaranimations.databinding.BallIntroBinding

class SplashScreen : Activity() {
    private lateinit var ballBinding: BallIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = LayoutInflater.from(this)

        //BINDING
        ballBinding = BallIntroBinding.inflate(inflater)
        val view = ballBinding.root
        setContentView(view)

        //SPLASH SCREEN
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition{false}

        //CARGAR ANIMACION PELOTA
        val bounceAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.ball_animation)
        ballBinding.ballView.startAnimation(bounceAnimation)

        ballBinding.ballView.setOnClickListener {
            val handler = Handler(Looper.getMainLooper())

            //ANIMACION DE FADE
            val fadeAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            ballBinding.root.startAnimation(fadeAnimation)

            handler.postDelayed({
                loadMain()
            }, 2000)
        }
    }

    private fun loadMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}