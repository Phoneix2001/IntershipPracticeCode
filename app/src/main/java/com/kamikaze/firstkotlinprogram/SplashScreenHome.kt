package com.kamikaze.firstkotlinprogram

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.kamikaze.firstkotlinprogram.databinding.ActivitySplashScreenBinding

class SplashScreenHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashBinding :ActivitySplashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)



        val splashAnimation2 = AnimationUtils.loadAnimation(this,R.anim.anime_splash2)
        splashBinding.textView2.animation = splashAnimation2
        splashAnimation2.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                startActivity(Intent(this@SplashScreenHome,MainActivity::class.java))
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }

        })
    }
}