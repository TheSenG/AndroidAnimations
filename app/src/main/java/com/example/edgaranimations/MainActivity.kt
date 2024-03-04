package com.example.edgaranimations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.edgaranimations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        // Cargar la animación desde el archivo XML
        val fadeOutAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        mainBinding.root.startAnimation(fadeOutAnimation)
    }
}