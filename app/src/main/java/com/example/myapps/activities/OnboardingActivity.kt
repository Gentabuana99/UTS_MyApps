package com.example.myapps.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myapps.activities.MainActivity
import com.example.myapps.R
import com.example.myapps.adapters.OnboardingAdapter
import com.example.myapps.models.OnboardingItem
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingActivity : AppCompatActivity() {

    private lateinit var onboardingViewPager: ViewPager2
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        onboardingViewPager = findViewById(R.id.onboardingViewPager)
        btnNext = findViewById(R.id.btnNext)

        val onboardingItems = listOf(
            OnboardingItem(R.drawable.ic_launcher_foreground, "Selamat Datang", "Ini adalah aplikasi pribadi saya."),
            OnboardingItem(R.drawable.ic_launcher_foreground, "Fitur Lengkap", "Aplikasi ini punya fitur profil, aktivitas, galeri, musik, dan lainnya."),
            OnboardingItem(R.drawable.ic_launcher_foreground, "Ayo Mulai", "Mari mulai menggunakan aplikasinya sekarang juga!")
        )

        val adapter = OnboardingAdapter(onboardingItems)
        onboardingViewPager.adapter = adapter

        // Next button action
        btnNext.setOnClickListener {
            if (onboardingViewPager.currentItem + 1 < onboardingItems.size) {
                onboardingViewPager.currentItem += 1
            } else {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        val tabLayout = findViewById<com.google.android.material.tabs.TabLayout>(R.id.tabIndicator)
        TabLayoutMediator(tabLayout, onboardingViewPager) { _, _ -> }.attach()
    }
}


