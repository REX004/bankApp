package com.example.animationapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.animationapp.databinding.ActivityMainBinding

class LaunchScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Применение анимации к логотипу
        val logoAnimation = AnimationUtils.loadAnimation(this, R.anim.logo_animation)
        binding.bankLogoImageView.startAnimation(logoAnimation)

        // Применение анимации к тексту
        val textAnimation = AnimationUtils.loadAnimation(this, R.anim.text_right)
        binding.welcomeTextView.startAnimation(textAnimation)

        // Применение анимации к фоновому изображению
        val backgroundAnimation = AnimationUtils.loadAnimation(this, R.anim.background_animation)
        binding.backgroundImageView.startAnimation(backgroundAnimation)

        val animation = AnimationUtils.loadAnimation(this, R.anim.scroll_animation)

        // Переход к MainActivity после завершения анимации с задержкой
        Handler().postDelayed({
            startActivity(Intent(this@LaunchScreenActivity, MainActivity::class.java))
            overridePendingTransition(0, R.anim.slide_out_right)

            finish()
        }, ANIMATION_DURATION)
    }

    companion object {
        private const val ANIMATION_DURATION = 3200L
    }
}


